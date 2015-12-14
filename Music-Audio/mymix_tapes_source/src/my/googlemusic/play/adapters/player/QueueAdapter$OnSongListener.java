// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.player;

import my.googlemusic.play.model.Song;

// Referenced classes of package my.googlemusic.play.adapters.player:
//            QueueAdapter

public static interface 
{

    public abstract void onSongDownload(Song song);

    public abstract void onSongMore(Song song);

    public abstract void onSongPlay(int i);
}
