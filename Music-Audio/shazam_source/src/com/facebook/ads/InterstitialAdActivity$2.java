// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.facebook.ads:
//            InterstitialAdActivity

final class a
    implements com.facebook.ads.a.g.
{

    final InterstitialAdActivity a;

    public final void a(View view)
    {
        InterstitialAdActivity.a(a).addView(view);
        if (InterstitialAdActivity.b(a) != null)
        {
            InterstitialAdActivity.a(a).addView(InterstitialAdActivity.b(a));
        }
    }

    public final void a(String s)
    {
        InterstitialAdActivity.a(a, s);
    }

    (InterstitialAdActivity interstitialadactivity)
    {
        a = interstitialadactivity;
        super();
    }
}
