// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import java.util.Random;

public class m
{

    private static final char a[];
    private final Random b = new Random();
    private final char c[];

    public m(int i)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("length < 1: ").append(i).toString());
        } else
        {
            c = new char[i];
            return;
        }
    }

    public String a()
    {
        for (int i = 0; i < c.length; i++)
        {
            c[i] = a[b.nextInt(a.length)];
        }

        return new String(c);
    }

    static 
    {
        byte byte0 = 10;
        a = new char[36];
        int i = 0;
        int j;
        do
        {
            j = byte0;
            if (i >= 10)
            {
                break;
            }
            a[i] = (char)(i + 48);
            i++;
        } while (true);
        for (; j < 36; j++)
        {
            a[j] = (char)((j + 97) - 10);
        }

    }
}
