package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.Period;


@Configuration
public class ChannelWithInjectedPrototypeVideoConfig {
    String name = "Cat Failure Compilation";
    LocalDateTime time = LocalDateTime.now();
    Period period = Period.ofDays(8) ;


    @Bean
    public Channel channelBean() {
        Channel channel = new Channel();
        while (!period.isZero()) {
            channel.addVideo(videoBean());
            this.period = period.minusDays(1);
        }
        return channel;
    }

    @Bean
    @Scope("prototype")
    public Video videoBean() {
        Video video = new Video(name, time);
        this.time = time.plusDays(1);
        return video;
    }
}
