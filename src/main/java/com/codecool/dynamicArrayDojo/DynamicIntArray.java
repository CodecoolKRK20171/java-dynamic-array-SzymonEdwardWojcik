package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int[] data;
    private int size;
    private int initialCap = 16;

    public DynamicIntArray() {
        data = new int[initialCap];
        size = 0;
    }

    public DynamicIntArray(int capacity) {

        if (capacity < initialCap) {
            capacity = initialCap;
        }
        data = new int[capacity];
        size = 0;
    }

    private void manageCapacity(int minCapacity) {

        int oldCapatity = data.length;
        if (minCapacity > oldCapatity) {
            int newCapacity = oldCapatity*2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            int maxRange = size-1;
            throw new ArrayIndexOutOfBoundsException("The index should be between 0 and " + maxRange);
        }
    }

    public void add(int number) {
        manageCapacity(size + 1);
        data[size++] = number;
    }

    public void remove(int index) {
        rangeCheck(index);
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    public void insert(int index, int newNumber) {
        manageCapacity(size + 1);
        if (index >= size) {
            index = size;
        }
        size++;
        for (int i = size-1; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = newNumber;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += " " + data[i];
        }
        return str;
    }
}
