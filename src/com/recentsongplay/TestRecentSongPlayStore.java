package com.recentsongplay;

public class TestRecentSongPlayStore {

	public static void main(String[] args) {
		
		// creating song store
		RecentSongPlayStore store = new RecentSongPlayStore(3);
		
		System.out.println("Song Store is generated with capacity for each user is : " + store.getSongStoreCapacityPerUser());
		
		store.playSong("song1", "userA");
		store.playSong("song2", "userA");
		store.playSong("song3", "userA");
		
		store.displaySingleUserPlayList("userA");
		
		System.out.println("-------------------------------");
		store.playSong("song4", "userA");
		store.displaySingleUserPlayList("userA");
		
		System.out.println("-------------------------------");
		store.playSong("song2", "userA");
		store.displaySingleUserPlayList("userA");
		
		System.out.println("-------------------------------");
		store.playSong("song1", "userA");
		store.displaySingleUserPlayList("userA");
		
		System.out.println("-------------------------------");
		store.displayEntireStorePlayList();
		
		System.out.println("================================================");
		store.playSong("song1", "userB");
		store.playSong("song2", "userB");
		store.playSong("song5", "userB");
		
		store.displaySingleUserPlayList("userB");
		
		System.out.println("-------------------------------");
		store.playSong("song4", "userB");
		store.displaySingleUserPlayList("userB");
		
		System.out.println("-------------------------------");
		store.playSong("song2", "userB");
		store.displaySingleUserPlayList("userB");
		
		System.out.println("-------------------------------");
		store.playSong("song7", "userB");
		store.displaySingleUserPlayList("userB");
		
		System.out.println("-------------------------------");
		store.displayEntireStorePlayList();
		
	}
}
