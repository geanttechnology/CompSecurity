// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CorPfmLogic, CORPFMResponse

private static class <init>
{

    final CountDownLatch mLatch;
    CORPFMResponse mResponse;

    private ()
    {
        mLatch = new CountDownLatch(1);
    }

    mLatch(byte byte0)
    {
        this();
    }
}
