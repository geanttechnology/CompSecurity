// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;


public class n
{

    private final long a;
    private final long b;

    public n(long l, long l1)
    {
        a = l;
        b = l1;
    }

    public long a()
    {
        return a;
    }

    public long b()
    {
        return b;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof n)
            {
                obj = (n)obj;
                if (a != ((n) (obj)).a || b != ((n) (obj)).b)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append("/").append(b).toString();
    }
}
