// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.view.View;

// Referenced classes of package com.facebook.ads:
//            InterstitialAdActivity

class c
    implements android.view.View.OnClickListener
{

    final InterstitialAdActivity a;

    c(InterstitialAdActivity interstitialadactivity)
    {
        a = interstitialadactivity;
        super();
    }

    public void onClick(View view)
    {
        a.finish();
    }
}
