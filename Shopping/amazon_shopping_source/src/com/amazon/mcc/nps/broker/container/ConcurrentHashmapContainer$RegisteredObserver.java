// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker.container;

import com.amazon.mcc.nps.Observer;
import com.amazon.mcc.nps.ObserverProperties;

// Referenced classes of package com.amazon.mcc.nps.broker.container:
//            ConcurrentHashmapContainer

private static class properties
{

    private final Observer observer;
    private final ObserverProperties properties;

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (properties)obj;
        if (observer != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((observer) (obj)).observer == null) goto _L1; else goto _L3
_L3:
        return false;
        if (observer.equals(((observer) (obj)).observer)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public Observer getObserver()
    {
        return observer;
    }

    public int getPriority()
    {
        return properties.getPriority();
    }

    public int hashCode()
    {
        int i;
        if (observer == null)
        {
            i = 0;
        } else
        {
            i = observer.hashCode();
        }
        return i + 31;
    }

    public (Observer observer1, ObserverProperties observerproperties)
    {
        observer = observer1;
        properties = observerproperties;
    }
}
