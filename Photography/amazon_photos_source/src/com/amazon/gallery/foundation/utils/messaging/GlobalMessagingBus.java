// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class GlobalMessagingBus
{

    private static final Bus bus;

    public static void post(Object obj)
    {
        bus.post(obj);
    }

    public static void register(Object obj)
    {
        bus.register(obj);
    }

    public static void unregister(Object obj)
    {
        bus.unregister(obj);
    }

    static 
    {
        bus = new Bus(ThreadEnforcer.ANY);
    }
}
