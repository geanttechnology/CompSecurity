// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;


// Referenced classes of package com.bumptech.glide.request:
//            RequestFutureTarget

static class 
{

    public void notifyAll(Object obj)
    {
        obj.notifyAll();
    }

    public void waitForTimeout(Object obj, long l)
        throws InterruptedException
    {
        obj.wait(l);
    }

    ()
    {
    }
}
