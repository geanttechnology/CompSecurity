// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import org.apache.http.HttpEntity;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b, au

public class ar extends b
{

    private final String d;
    private au e;

    public ar()
    {
        d = "GetTreeResponse";
        e = null;
    }

    public ar(HttpEntity httpentity)
    {
        super(httpentity);
        d = "GetTreeResponse";
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            e = null;
            return;
        } else
        {
            e = new au(b);
            return;
        }
    }

    public au a()
    {
        return e;
    }
}
