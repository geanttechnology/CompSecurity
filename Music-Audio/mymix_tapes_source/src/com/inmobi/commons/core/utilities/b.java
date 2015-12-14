// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities;

import java.io.File;

public class b
{

    public static void a(File file)
    {
        if (file.exists())
        {
            File afile[] = file.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                int i = 0;
                while (i < j) 
                {
                    File file1 = afile[i];
                    if (file1.isDirectory())
                    {
                        a(file1);
                    } else
                    {
                        file1.delete();
                    }
                    i++;
                }
            }
            file.delete();
        }
    }
}
