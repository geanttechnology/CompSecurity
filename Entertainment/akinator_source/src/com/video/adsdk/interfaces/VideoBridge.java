// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.interfaces;

import android.view.View;

// Referenced classes of package com.video.adsdk.interfaces:
//            VideoBridgeListener, FileDownloader

public interface VideoBridge
{
    public static final class MovieState extends Enum
    {

        private static final MovieState $VALUES[];
        public static final MovieState MOVIESTATE_BUFFERING;
        public static final MovieState MOVIESTATE_COMPLETED;
        public static final MovieState MOVIESTATE_INITIALIZED;
        public static final MovieState MOVIESTATE_PAUSED;
        public static final MovieState MOVIESTATE_PLAYING_NO_SKIP;
        public static final MovieState MOVIESTATE_PLAYING_SKIP;
        public static final MovieState MOVIESTATE_RESUMED;
        public static final MovieState MOVIESTATE_STARTED;
        public static final MovieState MOVIESTATE_STOPPED_BY_USER;

        public static MovieState valueOf(String s)
        {
            return (MovieState)Enum.valueOf(com/video/adsdk/interfaces/VideoBridge$MovieState, s);
        }

        public static MovieState[] values()
        {
            return (MovieState[])$VALUES.clone();
        }

        static 
        {
            MOVIESTATE_INITIALIZED = new MovieState("MOVIESTATE_INITIALIZED", 0);
            MOVIESTATE_BUFFERING = new MovieState("MOVIESTATE_BUFFERING", 1);
            MOVIESTATE_PLAYING_NO_SKIP = new MovieState("MOVIESTATE_PLAYING_NO_SKIP", 2);
            MOVIESTATE_PLAYING_SKIP = new MovieState("MOVIESTATE_PLAYING_SKIP", 3);
            MOVIESTATE_PAUSED = new MovieState("MOVIESTATE_PAUSED", 4);
            MOVIESTATE_COMPLETED = new MovieState("MOVIESTATE_COMPLETED", 5);
            MOVIESTATE_STARTED = new MovieState("MOVIESTATE_STARTED", 6);
            MOVIESTATE_RESUMED = new MovieState("MOVIESTATE_RESUMED", 7);
            MOVIESTATE_STOPPED_BY_USER = new MovieState("MOVIESTATE_STOPPED_BY_USER", 8);
            $VALUES = (new MovieState[] {
                MOVIESTATE_INITIALIZED, MOVIESTATE_BUFFERING, MOVIESTATE_PLAYING_NO_SKIP, MOVIESTATE_PLAYING_SKIP, MOVIESTATE_PAUSED, MOVIESTATE_COMPLETED, MOVIESTATE_STARTED, MOVIESTATE_RESUMED, MOVIESTATE_STOPPED_BY_USER
            });
        }

        private MovieState(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void addListener(VideoBridgeListener videobridgelistener);

    public abstract MovieState getCurrentMovieState();

    public abstract int getCurrentSecond();

    public abstract boolean isClosableByUI();

    public abstract void pause();

    public abstract void play();

    public abstract void removeListener(VideoBridgeListener videobridgelistener);

    public abstract void removeWebView();

    public abstract void setBackgroundColor(int i);

    public abstract void setFileDownloader(FileDownloader filedownloader);

    public abstract void setUrl(String s);

    public abstract void setWebview(View view);

    public abstract void showSkip();

    public abstract void shutdown();

    public abstract void stop();
}
