// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.aio.downloader.activity.MiniGamePlayActivity;
import com.aio.downloader.model.MiniGameModel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.adapter:
//            MinigameListviewAdapter

class val.in_fo
    implements android.view.viewAdapter._cls1
{

    final MinigameListviewAdapter this$0;
    private final MiniGameModel val$in_fo;

    public void onClick(View view)
    {
        (new Thread(new Runnable() {

            final MinigameListviewAdapter._cls1 this$1;
            private final MiniGameModel val$in_fo;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id=")).append(in_fo.getSerial()).append("&title=").append(in_fo.getTitle()).toString());
            }

            
            {
                this$1 = MinigameListviewAdapter._cls1.this;
                in_fo = minigamemodel;
                super();
            }
        })).start();
        view = new Intent(MinigameListviewAdapter.access$0(MinigameListviewAdapter.this), com/aio/downloader/activity/MiniGamePlayActivity);
        view.putExtra("playurl", val$in_fo.getPlay_url());
        view.putExtra("proc", val$in_fo.getProc());
        view.putExtra("sound", val$in_fo.getSound());
        MinigameListviewAdapter.access$0(MinigameListviewAdapter.this).startActivity(view);
    }

    _cls1.val.in_fo()
    {
        this$0 = final_minigamelistviewadapter;
        val$in_fo = MiniGameModel.this;
        super();
    }
}
