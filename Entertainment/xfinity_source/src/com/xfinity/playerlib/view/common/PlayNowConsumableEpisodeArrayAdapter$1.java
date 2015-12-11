// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.view.View;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            PlayNowConsumableEpisodeArrayAdapter

class val.position
    implements android.view.pisodeArrayAdapter._cls1
{

    final PlayNowConsumableEpisodeArrayAdapter this$0;
    final int val$position;
    final SeriesWatchable val$watchable;

    public void onClick(View view)
    {
        if (PlayNowConsumableEpisodeArrayAdapter.access$200(PlayNowConsumableEpisodeArrayAdapter.this) != null)
        {
            PlayNowConsumableEpisodeArrayAdapter.access$200(PlayNowConsumableEpisodeArrayAdapter.this).onClick(val$watchable, val$position);
        }
    }

    InfoClickListener()
    {
        this$0 = final_playnowconsumableepisodearrayadapter;
        val$watchable = serieswatchable;
        val$position = I.this;
        super();
    }
}
