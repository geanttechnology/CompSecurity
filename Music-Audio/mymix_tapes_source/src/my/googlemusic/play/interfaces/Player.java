// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.interfaces;

import java.util.List;
import my.googlemusic.play.model.Song;

public interface Player
{

    public abstract void finish();

    public abstract int getCurrentPosition();

    public abstract Song getCurrentSong();

    public abstract int getCurrentTrack();

    public abstract int getDuration();

    public abstract long getIdArtistRadio();

    public abstract List getPlaylist();

    public abstract boolean isActive();

    public abstract boolean isPaused();

    public abstract boolean isPlaying();

    public abstract boolean isPreparing();

    public abstract boolean isRadio();

    public abstract boolean isShuffle();

    public abstract void next();

    public abstract void pause();

    public abstract void play();

    public abstract void play(int i);

    public abstract void previous();

    public abstract void seekTo(int i);

    public abstract void setNotificationVisible(boolean flag);

    public abstract void setPlayList(List list);

    public abstract void setPlayList(List list, boolean flag, boolean flag1, long l);

    public abstract void setShuffle(boolean flag);
}
