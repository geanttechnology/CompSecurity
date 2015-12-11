// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import com.smule.android.network.models.ListingV2;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class c
    implements Runnable
{

    final ListingV2 a;
    final Activity b;
    final Runnable c;

    public void run()
    {
        o.a(a, b, c);
    }

    istingV2(ListingV2 listingv2, Activity activity, Runnable runnable)
    {
        a = listingv2;
        b = activity;
        c = runnable;
        super();
    }
}
