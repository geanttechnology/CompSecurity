// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;

import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp.event:
//            Subscriber

public class SubscriberList extends Vector
{

    public SubscriberList()
    {
    }

    public Subscriber getSubscriber(int i)
    {
        Object obj = null;
        Object obj1 = get(i);
        obj = obj1;
_L2:
        return (Subscriber)obj;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
