// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            Function1

public class DetachableFunction1
    implements Function1
{

    boolean isDetached;

    public DetachableFunction1()
    {
        isDetached = false;
    }

    public void detach()
    {
        isDetached = true;
    }

    public void execute(Object obj)
    {
        if (isDetached)
        {
            executeIfDetached(obj);
            return;
        } else
        {
            executeIfAttached(obj);
            return;
        }
    }

    public void executeIfAttached(Object obj)
    {
    }

    public void executeIfDetached(Object obj)
    {
    }
}
