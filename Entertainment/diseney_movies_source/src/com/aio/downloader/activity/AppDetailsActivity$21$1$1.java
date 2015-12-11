// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls2
    implements Runnable
{

    final _cls76 this$2;

    public void run()
    {
        if (AppDetailsActivity.access$4(_fld0).getProgress() >= AppDetailsActivity.access$78(_fld0))
        {
            if (AppDetailsActivity.access$7(_fld0) != null)
            {
                AppDetailsActivity.access$7(_fld0).cancel();
            }
            return;
        } else
        {
            AppDetailsActivity.access$4(_fld0).setProgress(AppDetailsActivity.access$4(_fld0).getProgress() + 1);
            AppDetailsActivity appdetailsactivity = _fld0;
            AppDetailsActivity.access$79(appdetailsactivity, AppDetailsActivity.access$76(appdetailsactivity) + 1);
            return;
        }
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/AppDetailsActivity$21

/* anonymous class */
    class AppDetailsActivity._cls21
        implements android.view.View.OnClickListener
    {

        final AppDetailsActivity this$0;

        public void onClick(View view)
        {
            AppDetailsActivity.access$3(AppDetailsActivity.this).setVisibility(0);
            AppDetailsActivity.access$8(AppDetailsActivity.this).setVisibility(8);
            AppDetailsActivity.access$4(AppDetailsActivity.this).setProgress(AppDetailsActivity.access$76(AppDetailsActivity.this));
            AppDetailsActivity.access$77(AppDetailsActivity.this, null);
            AppDetailsActivity.access$77(AppDetailsActivity.this, new Timer());
            AppDetailsActivity.access$7(AppDetailsActivity.this).schedule(new AppDetailsActivity._cls21._cls1(), 1000L, 600L);
            view = new Intent("pdtpause");
            view.putExtra("type", "resume");
            sendBroadcast(view);
        }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
    }


    // Unreferenced inner class com/aio/downloader/activity/AppDetailsActivity$21$1

/* anonymous class */
    class AppDetailsActivity._cls21._cls1 extends TimerTask
    {

        final AppDetailsActivity._cls21 this$1;

        public void run()
        {
            runOnUiThread(new AppDetailsActivity._cls21._cls1._cls1());
        }


            
            {
                this$1 = AppDetailsActivity._cls21.this;
                super();
            }
    }

}
