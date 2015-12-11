// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsActivity

public class BabyGuideLiveStreamsActivity extends LiveStreamsActivity
{

    public BabyGuideLiveStreamsActivity()
    {
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        if (searchMenuItem != null)
        {
            searchMenuItem.setVisible(false);
        }
        return false;
    }

    public void onLiveStreamClick(HalLiveStream hallivestream)
    {
        hallivestream = VideoPlayerActivity.createIntentForPlayer(hallivestream.getStreamId());
        hallivestream.setAction("reset");
        hallivestream.setFlags(0x4000000);
        startActivity(hallivestream);
    }
}
