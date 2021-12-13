package com.epam.rd.autotasks.confbeans.video;

import java.time.LocalDateTime;

public class VideoStudioImpl implements VideoStudio{
    String name = "Cat & Curious ";
    LocalDateTime time = LocalDateTime.of(2001,10,18,10,0);
    int index = 1;
    @Override
    public Video produce() {
        if(index>1){
            this.time=time.plusYears(2);
        }
        Video video = new Video(name+index,time);

        index++;
        return video;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getIndex() {
        return index;
    }
}
