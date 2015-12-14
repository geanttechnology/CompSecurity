// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.InterstitialAdActivity;

// Referenced classes of package com.facebook.ads.internal.view:
//            h, g

public class m
    implements h
{

    private g a;

    public m(InterstitialAdActivity interstitialadactivity, h.a a1)
    {
        a = new g(interstitialadactivity);
        interstitialadactivity = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        interstitialadactivity.addRule(15);
        a.setLayoutParams(interstitialadactivity);
        a1.a(a);
    }

    public void a()
    {
    }

    public void a(Intent intent, Bundle bundle)
    {
        bundle = intent.getStringExtra("videoURL");
        String s = intent.getStringExtra("videoPlayReportURL");
        intent = intent.getStringExtra("videoTimeReportURL");
        a.setVideoPlayReportURI(s);
        a.setVideoTimeReportURI(intent);
        a.setVideoURI(bundle);
        a.a();
    }

    public void a(Bundle bundle)
    {
    }

    public void b()
    {
    }

    public void c()
    {
        a.b();
    }
}
