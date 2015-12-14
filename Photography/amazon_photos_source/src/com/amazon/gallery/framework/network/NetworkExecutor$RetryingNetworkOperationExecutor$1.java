// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;


// Referenced classes of package com.amazon.gallery.framework.network:
//            NetworkExecutor

static final class  extends ThreadLocal
{

    protected Integer initialValue()
    {
        return Integer.valueOf(0);
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    ()
    {
    }
}
