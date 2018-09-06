package com.xyc.fastdevproject.example;

import java.util.List;

/**
 * Created by hasee on 2018/3/5.
 */

public class ComListModel<T> {
    private int total; //总消息数
    private List<T> data;
    private int unreadNumber;//未读系统消息

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUnreadNumber() {
        return unreadNumber;
    }

    public void setUnreadNumber(int unreadNumber) {
        this.unreadNumber = unreadNumber;
    }

    @Override
    public String toString() {
        return "GetMessageListModel{" +
                "total=" + total +
                ", data=" + data +
                ", unreadNumber=" + unreadNumber +
                '}';
    }
}
