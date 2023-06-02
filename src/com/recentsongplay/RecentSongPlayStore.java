package com.recentsongplay;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map.Entry;


public class RecentSongPlayStore {

	private int capacity;
	private static LinkedHashMap<String, LinkedList<String>> userMap = new LinkedHashMap<String, LinkedList<String>>();
	
	public RecentSongPlayStore(int capacity) {

		this.capacity = capacity;
	}

	
	/**
	 * This method is use to get capacity of songs which will be saved in song store per user
	 * @return capacity
	 */
	public int getSongStoreCapacityPerUser() {
		return capacity;
	}
	
	/**
	 * This method is use to play songs for particular user & 
	 * add those songs into song store with respect to that user
	 * @param song
	 * @param userName
	 */
	public void playSong(String song, String userName) {

		if(userMap.containsKey(userName)) {
			
			LinkedList<String> oldList = userMap.get(userName);
			oldList.add(song);
			userMap.put(userName, oldList);
		}else {
			StoreUser user = new StoreUser(userName);
			user.songList.add(song);
			userMap.put(userName, user.songList);
		}
		
		if(userMap.get(userName).size() > capacity) {
			removeLeastPlaySong(userName, userMap.get(userName));
		}
		
	}
	
	/**
	 * This method is use to remove the least played song by particular user
	 * from song store once user per song capacity is fully filled. 
	 * @param userName
	 * @param songList
	 */
	private void removeLeastPlaySong(String userName, LinkedList<String> songList) {
		
		songList.removeFirst(); 
		userMap.put(userName, songList);
	}

	/**
	 * This method is use to display all users data present in song store
	 */
	public void displayEntireStorePlayList() {
		
		System.out.println("Complete Songplay Store :- ");
		Set<Entry<String, LinkedList<String>>> storeSet = userMap.entrySet();
		
		for (Entry<String, LinkedList<String>> userSongPair : storeSet) {
			System.out.println(userSongPair.getKey() + " songs list is : " + userSongPair.getValue());
		}
	}
	
	/**
	 * This method is use to display recent playlist for particular user
	 * @param userName
	 */
	public void displaySingleUserPlayList(String userName) {
		System.out.println(userName + " songs list is : " + userMap.get(userName));
	}
}

class StoreUser
{
	String userName;
	LinkedList<String> songList;
	
	StoreUser(String userName) {
		this.userName = userName;
		this.songList = new LinkedList<String>();
	}
}
