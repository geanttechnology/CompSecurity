// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bz;

import java.io.File;
import java.io.FilenameFilter;

public final class a
    implements FilenameFilter
{

    private String a[] = {
        ".jpg", ".png", ".jpeg", ".gif"
    };
    private int b;

    public a()
    {
        b = a.length;
    }

    public final boolean accept(File file, String s)
    {
        int i = 0;
        do
        {
            if (i >= b || s.startsWith("."))
            {
                return false;
            }
            if (s.toLowerCase().endsWith(a[i]))
            {
                return true;
            }
            i++;
        } while (true);
    }
}
