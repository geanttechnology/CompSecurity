// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codebutler.android_websockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.codebutler.android_websockets:
//            HybiParser

public static class  extends DataInputStream
{

    public byte[] readBytes(int i)
        throws IOException
    {
        byte abyte0[] = new byte[i];
        readFully(abyte0);
        return abyte0;
    }

    public (InputStream inputstream)
    {
        super(inputstream);
    }
}
