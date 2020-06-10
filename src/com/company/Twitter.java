package com.company;

import java.util.*;

public class Twitter {
    int time;
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer,Node> twitters;
    private PriorityQueue<Node> maxHeap;
    /** Initialize your data structure here. */
    public Twitter() {
        follows=new HashMap<Integer,Set<Integer>>();
        twitters=new HashMap<Integer,Node>();
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
        time=0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Node node=twitters.get(userId);
        Node node1=new Node(tweetId,time);
        time++;
        if(node!=null){
            node1.next=node;
        }
        twitters.put(userId,node1);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if (twitters.containsKey(userId)) {
            maxHeap.offer(twitters.get(userId));
        }

        Set<Integer> followingList = follows.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Node node = twitters.get(followingId);
                if (node != null) {
                    maxHeap.offer(node);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Node head = maxHeap.poll();
            res.add(head.id);

            // 这里最好的操作应该是 replace，但是 Java 没有提供
            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;


    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return ;
        Set<Integer> set=follows.get(followeeId);
        if(set==null){
            set=new HashSet<Integer>();
            set.add(followeeId);
        }else{
            set.add(followeeId);
        }

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)return ;
        Set<Integer> set =follows.get(followerId);
        if(set==null)return;
        set.remove(followeeId);
    }
    private class Node {
        /**
         * 推文 id
         */
        private int id;

        /**
         * 发推文的时间戳
         */
        private int timestamp;
        private Node next;

        public Node(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(1, 2);
        twitter.follow(2,1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);

    }

}