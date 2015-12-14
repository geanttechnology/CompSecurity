// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.instamag.activity.compose.MagComposeActivity;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import java.util.List;

public class bab extends BroadcastReceiver
{

    final MagComposeActivity a;

    public bab(MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append("BroadcastReceiver on receiver").toString());
        if (context != null && (context.equalsIgnoreCase("ACTION_MATERIAL_ADDED") || context.equalsIgnoreCase("ACTION_MATERIAL_INSTAMAG_CHOOSE")) && intent.getStringExtra("TYPE_MATERIAL") != null && intent.getStringExtra("TYPE_MATERIAL").equalsIgnoreCase(bgv.getStringByResType(EOnlineResType.MAG_MASK_INFO)))
        {
            int i = intent.getIntExtra("INSTAMAG_RESID", -1);
            int j = intent.getIntExtra("INSTAMAG_IMAGE_COUNT", -1);
            Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver resid:").append(i).toString());
            Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver imagecount:").append(j).toString());
            if (j == a.e().size())
            {
                a.i = i;
                Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver _needResetrid:").append(a.i).toString());
            }
        }
        if (context != null && context.equalsIgnoreCase("ACTION_MAG_MATERIAL_SHARETOWECHAT") && intent.getBooleanExtra("sharesucceed", false))
        {
            if (a.c() != null && MagComposeActivity.c(a) != null)
            {
                if (this != null)
                {
                    a.a(a.getApplicationContext().getResources().getString(0x7f0600e9));
                }
                a.b(MagComposeActivity.c(a));
            }
            FlurryAgent.logEvent("ShareToWechatSucceed");
        }
        if (context != null && context.equalsIgnoreCase(ber.a))
        {
            MagComposeActivity.d(a);
        }
    }
}
