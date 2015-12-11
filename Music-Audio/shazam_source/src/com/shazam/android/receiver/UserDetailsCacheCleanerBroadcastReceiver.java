// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.android.ak.b.a;
import com.shazam.h.c;

public class UserDetailsCacheCleanerBroadcastReceiver extends BroadcastReceiver
{

    private final c a;

    public UserDetailsCacheCleanerBroadcastReceiver()
    {
        this(((c) (new a(com.shazam.i.i.a.a()))));
    }

    public UserDetailsCacheCleanerBroadcastReceiver(c c1)
    {
        a = c1;
    }

    public void onReceive(Context context, Intent intent)
    {
        a.a();
    }
}
