// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.view.Listener
{

    final MainPage this$0;

    public void onClick(View view)
    {
        String s;
        String s1;
        Intent intent;
        if (playingPlaylist == null || playingPlaylist.getPlaylistType() == 5)
        {
            view = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(playingSong.getSongYtId()).toString();
        } else
        {
            view = (new StringBuilder()).append("http://www.mixerbox.com/music/").append(playingPlaylist.getPlaylistId()).append("/").append(playingSong.getSongId()).toString();
        }
        s = (new StringBuilder()).append(getResources().getString(0x7f0800ba)).append(getResources().getString(0x7f0800b8)).toString();
        s1 = getResources().getString(0x7f0800b9);
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(s).append(playingSong.getSongName()).append(s1).toString());
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s).append(playingSong.getSongName()).append(s1).append(view).toString());
        startActivity(Intent.createChooser(intent, null));
    }

    Item()
    {
        this$0 = MainPage.this;
        super();
    }
}
