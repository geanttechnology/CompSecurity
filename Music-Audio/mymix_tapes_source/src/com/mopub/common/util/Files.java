// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import java.io.File;

public class Files
{

    public Files()
    {
    }

    public static File createDirectory(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        File file;
        file = new File(s);
        if (!file.exists())
        {
            break; /* Loop/switch isn't completed */
        }
        s = file;
        if (file.isDirectory()) goto _L4; else goto _L3
_L3:
        if (!file.mkdirs())
        {
            break; /* Loop/switch isn't completed */
        }
        s = file;
        if (file.isDirectory()) goto _L4; else goto _L5
_L5:
        return null;
    }

    public static int intLength(File file)
    {
        if (file == null)
        {
            return 0;
        }
        long l = file.length();
        if (l < 0x7fffffffL)
        {
            return (int)l;
        } else
        {
            return 0x7fffffff;
        }
    }
}
