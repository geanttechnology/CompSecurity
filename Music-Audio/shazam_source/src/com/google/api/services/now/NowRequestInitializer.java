// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now;

import com.google.api.a.c.e.a.b;
import com.google.api.a.c.e.a.c;

// Referenced classes of package com.google.api.services.now:
//            NowRequest

public class NowRequestInitializer extends c
{

    public NowRequestInitializer()
    {
    }

    public NowRequestInitializer(String s)
    {
        super(s);
    }

    public NowRequestInitializer(String s, String s1)
    {
        super(s, s1);
    }

    public final void initializeJsonRequest(b b)
    {
        super.initializeJsonRequest(b);
        initializeNowRequest((NowRequest)b);
    }

    protected void initializeNowRequest(NowRequest nowrequest)
    {
    }
}
