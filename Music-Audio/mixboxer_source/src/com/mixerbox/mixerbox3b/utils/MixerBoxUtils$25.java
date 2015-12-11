// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.view.MenuItem;
import com.mixerbox.mixerbox3b.classes.SongItem;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class val.k
    implements android.widget.temClickListener
{

    final Context val$ctx;
    final String val$currentPlaylistId;
    final SongItem val$currentSong;
    final int val$k;

    public final boolean onMenuItemClick(MenuItem menuitem)
    {
        MixerBoxUtils.performSongAction(val$ctx, menuitem.getItemId(), val$currentSong, val$currentPlaylistId, val$k);
        return true;
    }

    r()
    {
        val$ctx = context;
        val$currentSong = songitem;
        val$currentPlaylistId = s;
        val$k = i;
        super();
    }
}
