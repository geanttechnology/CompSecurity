// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.t;
import com.shazam.android.k.f.b.a;
import com.shazam.android.widget.page.NotifyingViewPager;

// Referenced classes of package com.shazam.android.activities:
//            MainActivity

private final class <init> extends BroadcastReceiver
{

    final MainActivity a;

    public final void onReceive(Context context, Intent intent)
    {
        MainActivity.b(a);
        int i = com.shazam.android.activities.MainActivity.a(a, a.h);
        if (i != -1)
        {
            context = MainActivity.c(a).c(i);
            if (context instanceof com.shazam.android.fragment.myshazam.a)
            {
                context = (com.shazam.android.fragment.myshazam.a)context;
                if (((com.shazam.android.fragment.myshazam.a) (context)).a.getAdapter().c() == 1)
                {
                    context.a();
                }
            }
        }
    }

    private ager(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }

    a(MainActivity mainactivity, byte byte0)
    {
        this(mainactivity);
    }
}
