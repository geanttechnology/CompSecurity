// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.app.Activity;
import android.widget.Toast;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.sdk:
//            ap, AppLovinSdkImpl, bw

public class ao
{

    private final AppLovinSdkImpl a;
    private final String b;
    private final Activity c;

    public ao(AppLovinSdkImpl applovinsdkimpl, Activity activity, String s)
    {
        a = applovinsdkimpl;
        b = s;
        c = activity;
    }

    static AppLovinSdkImpl a(ao ao1)
    {
        return ao1.a;
    }

    static Activity b(ao ao1)
    {
        return ao1.c;
    }

    void a()
    {
        c.runOnUiThread(new ap(this));
    }

    void a(String s, Throwable throwable)
    {
        a.getLogger().userError("IncentivizedConfirmationManager", "Unable to show incentivized ad reward dialog. Have you defined com.applovin.adview.AppLovinConfirmationActivity in your manifest?", throwable);
        Toast.makeText(c, s, 1).show();
    }

    String b()
    {
        if (b.equals("accepted"))
        {
            return (String)a.a(bw.ac);
        }
        if (b.equals("quota_exceeded"))
        {
            return (String)a.a(bw.ad);
        }
        if (b.equals("rejected"))
        {
            return (String)a.a(bw.ae);
        } else
        {
            return (String)a.a(bw.af);
        }
    }
}
