// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import java.io.File;

public class l
{

    public static boolean a(File file)
    {
        boolean flag1;
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            int i = 0;
            boolean flag = true;
            do
            {
                flag1 = flag;
                if (i >= j)
                {
                    break;
                }
                if (a(afile[i]) && flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i++;
            } while (true);
        } else
        {
            flag1 = true;
        }
        return file.delete() && flag1;
    }
}
