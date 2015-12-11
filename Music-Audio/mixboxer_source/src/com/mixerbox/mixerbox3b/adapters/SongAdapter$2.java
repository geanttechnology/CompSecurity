// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.adapters:
//            SongAdapter

class val.position
    implements android.view.stener
{

    final SongAdapter this$0;
    final int val$position;

    public void onClick(View view)
    {
        MixerBoxUtils.createPopupMenu(SongAdapter.access$100(SongAdapter.this), view, (SongItem)array.get(val$position), currentPlaylistId, array.size() - val$position - 1);
        view = new HashMap();
        view.put("id", ((SongItem)array.get(val$position)).getSongId());
        view.put("playlist", currentPlaylistId);
        FlurryAgent.logEvent("action:music_edit", view);
    }

    ()
    {
        this$0 = final_songadapter;
        val$position = I.this;
        super();
    }
}
