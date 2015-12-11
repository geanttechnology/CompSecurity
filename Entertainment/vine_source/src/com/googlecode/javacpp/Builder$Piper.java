// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

// Referenced classes of package com.googlecode.javacpp:
//            Builder

public static class os extends Thread
{

    InputStream is;
    OutputStream os;

    public void run()
    {
        byte abyte0[] = new byte[1024];
_L1:
        int i = is.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        os.write(abyte0, 0, i);
          goto _L1
        IOException ioexception;
        ioexception;
        System.err.println((new StringBuilder()).append("Could not pipe from the InputStream to the OutputStream: ").append(ioexception.getMessage()).toString());
    }

    public (InputStream inputstream, OutputStream outputstream)
    {
        is = inputstream;
        os = outputstream;
    }
}
