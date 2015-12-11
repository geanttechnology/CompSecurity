// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.aio.downloader.activity.GameActivity1;
import com.aio.downloader.activity.MyMainActivity;
import com.aio.downloader.activity.Noti_Set_Activity;
import com.aio.downloader.cleaner.PhoneBoostActivity;

// Referenced classes of package com.aio.downloader.floatwindow:
//            MyFloatService

class this._cls0 extends BroadcastReceiver
{

    final MyFloatService this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("home"))
        {
            Log.e("floattag", "floattag++home");
            MyFloatService.collapseStatusBar(getApplicationContext());
            context = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
            context.putExtra("acquire_url_start", "");
            context.setFlags(0x10000000);
            startActivity(context);
        } else
        {
            if (intent.getAction().equals("boost"))
            {
                MyFloatService.collapseStatusBar(getApplicationContext());
                context = new Intent(getApplicationContext(), com/aio/downloader/cleaner/PhoneBoostActivity);
                context.setFlags(0x10000000);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("games"))
            {
                MyFloatService.collapseStatusBar(getApplicationContext());
                context = new Intent(getApplicationContext(), com/aio/downloader/activity/GameActivity1);
                context.setFlags(0x10000000);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("camera"))
            {
                context = new Intent();
                context.setAction("android.media.action.STILL_IMAGE_CAMERA");
                context.setFlags(0x10000000);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("set"))
            {
                MyFloatService.collapseStatusBar(getApplicationContext());
                context = new Intent(getApplicationContext(), com/aio/downloader/activity/Noti_Set_Activity);
                context.setFlags(0x10000000);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("flash"))
            {
                MyFloatService.collapseStatusBar(getApplicationContext());
                context = new Intent("android.intent.action.SET_ALARM");
                context.setFlags(0x10000000);
                startActivity(context);
                return;
            }
        }
    }

    ()
    {
        this$0 = MyFloatService.this;
        super();
    }
}
