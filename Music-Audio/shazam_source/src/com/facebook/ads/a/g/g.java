// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.content.Intent;
import android.os.Bundle;
import android.widget.VideoView;
import com.facebook.ads.InterstitialAdActivity;

// Referenced classes of package com.facebook.ads.a.g:
//            f, e

public final class g
    implements f
{

    private e a;

    public g(InterstitialAdActivity interstitialadactivity, f.a a1)
    {
        a = new e(interstitialadactivity);
        interstitialadactivity = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        interstitialadactivity.addRule(15);
        a.setLayoutParams(interstitialadactivity);
        a1.a(a);
    }

    public final void a()
    {
    }

    public final void a(Intent intent, Bundle bundle)
    {
        bundle = intent.getStringExtra("videoURL");
        String s = intent.getStringExtra("videoPlayReportURL");
        intent = intent.getStringExtra("videoTimeReportURL");
        a.setVideoPlayReportURI(s);
        a.setVideoTimeReportURI(intent);
        a.setVideoURI(bundle);
        a.a.start();
    }

    public final void a(Bundle bundle)
    {
    }

    public final void b()
    {
    }

    public final void c()
    {
        e e1 = a;
        if (e1.a != null)
        {
            e1.a.stopPlayback();
        }
    }
}
