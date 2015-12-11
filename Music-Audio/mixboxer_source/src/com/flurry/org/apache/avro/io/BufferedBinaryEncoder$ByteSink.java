// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BufferedBinaryEncoder

private static abstract class 
{

    protected abstract void innerFlush()
        throws IOException;

    protected abstract void innerWrite(byte abyte0[], int i, int j)
        throws IOException;

    protected ()
    {
    }
}
