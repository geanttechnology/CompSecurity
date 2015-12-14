// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import java.io.BufferedReader;
import java.io.Writer;

// Referenced classes of package com.amazon.device.utils:
//            DetUtil

public static class 
    implements 
{

    public void write(BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        char ac[] = new char[8192];
        do
        {
            int i = bufferedreader.read(ac, 0, 8192);
            if (i == -1)
            {
                return;
            }
            writer.write(ac, 0, i);
        } while (true);
    }

    public ()
    {
    }
}
