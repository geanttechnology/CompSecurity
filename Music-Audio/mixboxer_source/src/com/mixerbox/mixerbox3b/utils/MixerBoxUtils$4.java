// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import com.mixerbox.mixerbox3b.MainPage;

final class val.ctx
    implements Runnable
{

    final Context val$ctx;

    public final void run()
    {
        ((MainPage)val$ctx).setLocalNotificationList();
    }

    ()
    {
        val$ctx = context;
        super();
    }
}
