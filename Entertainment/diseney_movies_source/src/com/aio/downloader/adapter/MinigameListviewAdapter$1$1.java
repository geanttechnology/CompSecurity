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
    implements Runnable
{

    final val.in_fo this$1;
    private final MiniGameModel val$in_fo;

    public void run()
    {
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id=")).append(val$in_fo.getSerial()).append("&title=").append(val$in_fo.getTitle()).toString());
    }

    l.in_fo()
    {
        this$1 = final_in_fo1;
        val$in_fo = MiniGameModel.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/MinigameListviewAdapter$1

/* anonymous class */
    class MinigameListviewAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final MinigameListviewAdapter this$0;
        private final MiniGameModel val$in_fo;

        public void onClick(View view)
        {
            (new Thread(in_fo. new MinigameListviewAdapter._cls1._cls1())).start();
            view = new Intent(MinigameListviewAdapter.access$0(MinigameListviewAdapter.this), com/aio/downloader/activity/MiniGamePlayActivity);
            view.putExtra("playurl", in_fo.getPlay_url());
            view.putExtra("proc", in_fo.getProc());
            view.putExtra("sound", in_fo.getSound());
            MinigameListviewAdapter.access$0(MinigameListviewAdapter.this).startActivity(view);
        }

            
            {
                this$0 = final_minigamelistviewadapter;
                in_fo = MiniGameModel.this;
                super();
            }
    }

}
