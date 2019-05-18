package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer::max).get();
    }

    public double getMinimum() {
        return arrayList.stream().reduce(Integer::min).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToDouble(item->Double.valueOf(item.toString())).average().getAsDouble();
    }

    public double getOrderedMedian() {
        Integer mid = arrayList.size()/2;
        if(arrayList.size()%2==0){
            return (double)(arrayList.get(mid-1)+arrayList.get(mid))/2;
        }else{
            return arrayList.get(mid);
        }
    }

    public int getFirstEven() {
        for(Integer item:arrayList){
            if(item%2==0)
                return item;
        }
        return 0;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)%2==0){
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        if(this.arrayList.size()!=arrayList.size()){
            return false;
        }
        List<Integer> collection1 = this.arrayList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        List<Integer> collection2 = this.arrayList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        for (int i = 0; i < collection1.size(); i++) {
            if(collection1.get(i)!=collection2.get(i)){
                return false;
            }
        }
        return true;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        return getOrderedMedian();
    }

    public int getLastOdd() {
        int lastOdd = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)%2!=0){
                lastOdd = arrayList.get(i);
            }
        }
        return lastOdd;
    }

    public int getIndexOfLastOdd() {
        int index = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)%2!=0){
                index = i;
            }
        }
        return index;
    }
}
