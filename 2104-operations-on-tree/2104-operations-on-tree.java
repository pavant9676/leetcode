class LockingTree {
    Map<Integer, Integer> lockMap = new HashMap<>();
    List<List<Integer>> children = new ArrayList<>();
    int[] parent;

    public LockingTree(int[] parent) {
        this.parent = parent;
        for (int i = 0; i < parent.length; i++) children.add(new ArrayList<>());
        for (int i = 1; i < parent.length; i++) children.get(parent[i]).add(i);
    }

    public boolean lock(int num, int user) {
        if (lockMap.containsKey(num)) return false;
        lockMap.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockMap.getOrDefault(num, -1) != user) return false;
        lockMap.remove(num);
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (lockMap.containsKey(num)) return false;
        if (hasLockedAncestor(num)) return false;
        if (!hasLockedDescendant(num)) return false;

        unlockAllDescendants(num);
        lockMap.put(num, user);
        return true;
    }

    private boolean hasLockedAncestor(int num) {
        while (num != -1) {
            if (lockMap.containsKey(num)) return true;
            num = parent[num];
        }
        return false;
    }

    private boolean hasLockedDescendant(int num) {
        for (int child : children.get(num)) {
            if (lockMap.containsKey(child) || hasLockedDescendant(child)) return true;
        }
        return false;
    }

    private void unlockAllDescendants(int num) {
        for (int child : children.get(num)) {
            lockMap.remove(child);
            unlockAllDescendants(child);
        }
    }
}
