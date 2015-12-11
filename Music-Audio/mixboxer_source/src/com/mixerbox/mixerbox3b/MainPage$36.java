// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements Runnable
{

    final MainPage this$0;

    public void run()
    {
        try
        {
            DB.checkHistory(playingSong.getSongYtId());
            DB.addSong("PLAYLISTHISTORYID", playingSong.getSongName(), playingSong.getSongTime(), playingSong.getSongYtId(), playingSong.getSongOrder(), playingSong.getSongSource(), playingSong.getSongThumbnail());
            if (DB.getSongCount("PLAYLISTHISTORYID") > 100)
            {
                DB.deleteHistory();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    oxSQLite()
    {
        this$0 = MainPage.this;
        super();
    }
}
