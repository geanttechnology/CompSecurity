// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import java.io.IOException;

// Referenced classes of package com.facebook.cache.disk:
//            DefaultDiskStorage

private static class actual extends IOException
{

    public final long actual;
    public final long expected;

    public (long l, long l1)
    {
        super((new StringBuilder()).append("File was not written completely. Expected: ").append(l).append(", found: ").append(l1).toString());
        expected = l;
        actual = l1;
    }
}
