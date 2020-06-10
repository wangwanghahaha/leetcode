package com.company;

class DSU {
    private int[] parent;
    private int[] num;

    public DSU(int N) {
        parent = new int[N];
        num = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            num[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public int union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        parent[p1] = p2;
        num[p1] = num[p1] + num[p2];
        num[p2] = num[p1];
        return num[p1];

    }

}