// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;


// Referenced classes of package com.google.common.eventbus:
//            Dispatcher, Subscriber

private static final class <init>
{

    private final Object event;
    private final Subscriber subscriber;



    private (Object obj, Subscriber subscriber1)
    {
        event = obj;
        subscriber = subscriber1;
    }

    subscriber(Object obj, Subscriber subscriber1, subscriber subscriber2)
    {
        this(obj, subscriber1);
    }
}
