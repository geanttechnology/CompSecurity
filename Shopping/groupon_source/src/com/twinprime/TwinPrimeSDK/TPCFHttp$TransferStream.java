// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPCFHttp

static class  extends ByteArrayOutputStream
{

    public ByteArrayInputStream convert()
    {
        return new ByteArrayInputStream(buf, 0, count);
    }

    public (int i)
    {
        super(i);
    }
}
