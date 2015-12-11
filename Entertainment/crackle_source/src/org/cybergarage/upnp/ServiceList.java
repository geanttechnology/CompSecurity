// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp:
//            Service

public class ServiceList extends Vector
{

    public static final String ELEM_NAME = "serviceList";

    public ServiceList()
    {
    }

    public Service getService(int i)
    {
        Object obj = null;
        Object obj1 = get(i);
        obj = obj1;
_L2:
        return (Service)obj;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
