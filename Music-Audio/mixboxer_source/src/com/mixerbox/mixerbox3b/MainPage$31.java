// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Intent;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.services.PlayerService;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class val.b
    implements Runnable
{

    final MainPage this$0;
    final boolean val$b;

    public void run()
    {
        String s;
        Object obj;
        obj = null;
        s = "";
        if (playingSong.getSongSource() != 2) goto _L2; else goto _L1
_L1:
        s = MainPage.access$500(MainPage.this, playingSong.getSongId());
_L4:
        Intent intent = new Intent(MainPage.this, com/mixerbox/mixerbox3b/services/PlayerService);
        String s1 = "";
        if (playingSong.getSongName() != null)
        {
            s1 = playingSong.getSongName();
        }
        intent.putExtra("song_name", s1);
        intent.putExtra("bitmap", ((android.os.Parcelable) (obj)));
        intent.putExtra("song_source", playingSong.getSongSource());
        intent.putExtra("url", s);
        intent.putExtra("is_playing", val$b);
        startService(intent);
        return;
_L2:
        if (playingSong.getSongSource() != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        s = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(playingSong.getSongYtId()).append("/mqdefault.jpg").toString();
_L6:
        obj = MixerBoxUtils.getBitmapFromURL(s);
        if (true) goto _L4; else goto _L3
_L3:
        if (playingSong.getSongSource() != 3) goto _L6; else goto _L5
_L5:
        s = playingSong.getSongThumbnail();
          goto _L6
    }

    oxUtils()
    {
        this$0 = final_mainpage;
        val$b = Z.this;
        super();
    }
}
