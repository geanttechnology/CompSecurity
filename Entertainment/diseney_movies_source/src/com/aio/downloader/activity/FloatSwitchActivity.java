// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.aio.downloader.floatwindow.FloatWindowService;
import com.aio.downloader.utils.Myutils;

// Referenced classes of package com.aio.downloader.activity:
//            FloatControlActivity, MyMainActivity

public class FloatSwitchActivity extends Activity
{

    public static Intent intent_float;

    public FloatSwitchActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag = getSharedPreferences("floatctri", 0).getBoolean("fctri", true);
        intent_float = new Intent(getApplicationContext(), com/aio/downloader/floatwindow/FloatWindowService);
        if (flag)
        {
            startService(intent_float);
        } else
        {
            stopService(intent_float);
        }
        if (Myutils.iswidget2)
        {
            startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/FloatControlActivity));
            return;
        } else
        {
            bundle = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
            bundle.putExtra("acquire_url_start", "");
            startActivity(bundle);
            overridePendingTransition(0x7f04000c, 0x7f040011);
            return;
        }
    }
}
