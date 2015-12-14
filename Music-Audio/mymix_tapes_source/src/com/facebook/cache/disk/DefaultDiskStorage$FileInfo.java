// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import java.io.File;
import java.io.IOException;

// Referenced classes of package com.facebook.cache.disk:
//            DefaultDiskStorage

private static class <init>
{

    public final String resourceId;
    public final resourceId type;

    public static <init> fromFile(File file)
    {
        int i;
        file = file.getName();
        i = file.lastIndexOf('.');
        if (i > 0) goto _L2; else goto _L1
_L1:
        <init> <init>1;
        return null;
_L2:
        if ((<init>1 = fromExtension(file.substring(i))) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s = file.substring(0, i);
        file = s;
        if (!<init>1.equals(TEMP))
        {
            break; /* Loop/switch isn't completed */
        }
        i = s.lastIndexOf('.');
        if (i <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        file = s.substring(0, i);
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return new <init>(<init>1, file);
    }

    public File createTempFile(File file)
        throws IOException
    {
        return File.createTempFile((new StringBuilder()).append(resourceId).append(".").toString(), ".tmp", file);
    }

    public File toFile(File file)
    {
        return new File(file, (new StringBuilder()).append(resourceId).append(type.extension).toString());
    }

    public String toString()
    {
        return (new StringBuilder()).append(type).append("(").append(resourceId).append(")").toString();
    }

    private _cls9(_cls9 _pcls9, String s)
    {
        type = _pcls9;
        resourceId = s;
    }

    resourceId(resourceId resourceid, String s, resourceId resourceid1)
    {
        this(resourceid, s);
    }
}
