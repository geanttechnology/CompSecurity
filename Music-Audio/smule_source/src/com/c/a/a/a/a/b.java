// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.a.a.a;

import com.c.a.a.a.c;
import com.c.a.b.a;
import java.io.File;

public class b extends c
{

    public b(File file, int i)
    {
        this(file, com.c.a.b.a.a(), i);
    }

    public b(File file, com.c.a.a.a.b.a a1, int i)
    {
        super(file, a1, i);
        if (i < 0x200000)
        {
            com.c.a.c.c.c("You set too small disc cache size (less than %1$d Mb)", new Object[] {
                Integer.valueOf(2)
            });
        }
    }

    protected int a(File file)
    {
        return (int)file.length();
    }
}
