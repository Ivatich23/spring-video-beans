package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoStudioImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
@ComponentScan("video")
public class ChannelWithPhantomVideoStudioConfig {
    String name = "Cat & Curious ";
    LocalDateTime time = LocalDateTime.of(2001, 10, 18, 10, 0);
    int index = 1;

    @Bean
    public Channel channelBean() {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(videoBean());
        }
        return channel;
    }

    @Bean
    @Scope("prototype")
    public Video videoBean() {
        if (index > 1) {
            this.time = time.plusYears(2);
        }
        Video video = new Video(name + index, time);

        index++;
        return video;
    }
}
