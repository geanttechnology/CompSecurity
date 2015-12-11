// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.android.ao.h;
import com.shazam.android.fragment.news.a;
import com.shazam.android.fragment.news.j;
import com.shazam.b.a.e;
import com.shazam.i.b.ah.f.b;
import com.shazam.model.account.UserState;

public class NewsFeedCacheCleanerBroadcastReceiver extends BroadcastReceiver
{

    private final j a;
    private final e b;

    public NewsFeedCacheCleanerBroadcastReceiver()
    {
        this(((j) (new a(com.shazam.i.b.ah.f.b.a(), com.shazam.i.b.au.a.a.b()))), ((e) (new h())));
    }

    public NewsFeedCacheCleanerBroadcastReceiver(j j1, e e1)
    {
        a = j1;
        b = e1;
    }

    public void onReceive(Context context, Intent intent)
    {
        context = (UserState)intent.getSerializableExtra("extraNewUserState");
        if (b.apply(context))
        {
            a.a();
        }
    }
}
