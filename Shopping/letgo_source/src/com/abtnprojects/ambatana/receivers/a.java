// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.support.v7.aqo;
import android.support.v7.is;

public abstract class a extends BroadcastReceiver
{

    public a()
    {
    }

    void a(Context context)
    {
        aqo.a("On update", new Object[0]);
        is.a(context, false);
    }
}
