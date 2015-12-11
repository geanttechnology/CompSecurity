// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;

import android.view.View;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.adapters:
//            SongAdapter

class val.position
    implements android.view.stener
{

    final SongAdapter this$0;
    final int val$position;

    public void onClick(View view)
    {
        MixerBoxUtils.performSongAction(SongAdapter.access$100(SongAdapter.this), 1, (SongItem)array.get(val$position), currentPlaylistId, array.size() - val$position - 1);
    }

    ()
    {
        this$0 = final_songadapter;
        val$position = I.this;
        super();
    }
}
