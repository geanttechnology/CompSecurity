// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            Mixtape, App, NowPlayingActivity, MainActivity

class this._cls0
    implements android.widget.w.OnItemClickListener
{

    final Mixtape this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        Log.v("mixtape", "track clicked");
        i -= Mixtape.access$32(Mixtape.this).getHeaderViewsCount();
        adapterview = (ArrayList)mixtape.get("tracks");
        if (!playlistMode.booleanValue())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        view = (String)((HashMap)adapterview.get(i)).get("track_id");
        if (!selectedPlayListTracks.contains(view)) goto _L2; else goto _L1
_L1:
        selectedPlayListTracks.remove(view);
        updatePlayListSelectionBackground(i, false);
_L3:
        App.showNotification((String)((HashMap)adapterview.get(i)).get("track_title"), Mixtape.access$29(Mixtape.this));
        return;
_L2:
        try
        {
            selectedPlayListTracks.add(view);
            updatePlayListSelectionBackground(i, true);
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            adapterview.printStackTrace();
            return;
        }
          goto _L3
        NowPlayingActivity.mixtape = mixtape;
        NowPlayingActivity.position = i;
        NowPlayingActivity.flag = 1;
        MainActivity.isPlaying = true;
        NowPlayingActivity.initializeAndReload();
        MainActivity.nowplayingbutton.setImageResource(0x7f0200f8);
        Mixtape.access$33(Mixtape.this, MainActivity.nowplayingbutton, null);
          goto _L3
    }

    ty()
    {
        this$0 = Mixtape.this;
        super();
    }
}
