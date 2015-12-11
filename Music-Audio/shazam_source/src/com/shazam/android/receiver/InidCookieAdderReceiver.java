// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.shazam.android.p.c;
import com.shazam.android.p.m;
import com.shazam.android.web.a;
import com.shazam.android.web.d;

public class InidCookieAdderReceiver extends BroadcastReceiver
{

    private final a a;

    public InidCookieAdderReceiver()
    {
        if ((new c()).c())
        {
            CookieSyncManager.createInstance(com.shazam.i.b.c.a());
        }
        this(((a) (new d(CookieManager.getInstance(), com.shazam.i.b.ah.c.d.a()))));
    }

    public InidCookieAdderReceiver(a a1)
    {
        a = a1;
    }

    public void onReceive(Context context, Intent intent)
    {
        a.a();
    }
}
