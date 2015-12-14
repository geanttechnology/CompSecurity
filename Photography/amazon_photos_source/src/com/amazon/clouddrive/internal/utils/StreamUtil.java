// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal.utils;

import com.amazon.clouddrive.exceptions.InvalidParameter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.amazon.clouddrive.internal.utils:
//            ThreadUtil

public class StreamUtil
{

    public static long copyInputStreamToOutputStream(InputStream inputstream, OutputStream outputstream, int i, long l)
        throws IOException, InterruptedException, InvalidParameter
    {
        ThreadUtil.checkIfInterrupted();
        long l1 = 0L;
        byte abyte0[] = new byte[i];
        do
        {
label0:
            {
                i = inputstream.read(abyte0, 0, abyte0.length);
                long l2 = l1;
                if (i > 0)
                {
                    l1 += i;
                    if (l1 <= l)
                    {
                        break label0;
                    }
                    l2 = l1;
                }
                return l2;
            }
            ThreadUtil.checkIfInterrupted();
            outputstream.write(abyte0, 0, i);
            ThreadUtil.checkIfInterrupted();
        } while (true);
    }
}
