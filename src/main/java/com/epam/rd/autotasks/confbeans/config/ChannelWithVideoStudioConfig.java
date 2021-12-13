package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;
import com.epam.rd.autotasks.confbeans.video.VideoStudioImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("video")
public class ChannelWithVideoStudioConfig {
    @Bean
    public Channel channelBean() {
        Channel channel = new Channel();
        VideoStudioImpl videoStudio = videoFranchiseCreate();
        for (int i = 0; i < 8; i++) {
            Video video = videoStudio.produce();
           channel.addVideo(video);
        }
        return channel;
    }

    @Bean
    public VideoStudioImpl videoFranchiseCreate() {
        return new VideoStudioImpl();
    }
}
