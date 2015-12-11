// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;


// Referenced classes of package co.vine.android.player:
//            SdkVideoView

public interface HasVideoPlayerAdapter
{

    public abstract SdkVideoView getLastPlayer();

    public abstract SdkVideoView getPlayer(int i, boolean flag);

    public abstract void pauseCurrentPlayer();

    public abstract void play(int i);

    public abstract void playCurrentPosition();

    public abstract void playFile(int i, boolean flag);
}
