// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import com.instamag.activity.library.activity.MainDownloadActivity;

public class bcb extends BroadcastReceiver
{

    final MainDownloadActivity a;

    public bcb(MainDownloadActivity maindownloadactivity)
    {
        a = maindownloadactivity;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (context != null && context.equalsIgnoreCase("ACTION_MAG_MATERIAL_SHARETOWECHAT") && intent.getBooleanExtra("sharesucceed", false) && a.b() != null && MainDownloadActivity.a(a) != null)
        {
            bcv.a().a(MainDownloadActivity.a(a), MainDownloadActivity.b(a));
            MainDownloadActivity.c(a).setEnabled(false);
            MainDownloadActivity.d(a).setBackgroundColor(0x106000b);
        }
    }
}
