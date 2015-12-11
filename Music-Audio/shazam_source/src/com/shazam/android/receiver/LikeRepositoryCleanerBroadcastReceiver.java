// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.android.ao.g;
import com.shazam.b.a.e;
import com.shazam.i.l.c;
import com.shazam.k.i;
import com.shazam.model.account.UserState;

public class LikeRepositoryCleanerBroadcastReceiver extends BroadcastReceiver
{

    private final i a;
    private final e b;

    public LikeRepositoryCleanerBroadcastReceiver()
    {
        this(c.a(), ((e) (new g())));
    }

    public LikeRepositoryCleanerBroadcastReceiver(i j, e e1)
    {
        a = j;
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
