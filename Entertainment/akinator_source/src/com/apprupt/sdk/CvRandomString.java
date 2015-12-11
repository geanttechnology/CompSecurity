// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.Random;

class CvRandomString
{

    public static final String DEFAULT_CHARACTERS = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789";
    public static final int DEFAULT_LENGTH = 8;
    private static String idFormat = null;
    private static int idIndex = 0;

    CvRandomString()
    {
    }

    public static String generate()
    {
        return generate(8, "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789");
    }

    public static String generate(int i)
    {
        return generate(i, "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789");
    }

    public static String generate(int i, String s)
    {
        if (s.length() < 2)
        {
            throw new IllegalArgumentException("Characters set have to contain at least two characters.");
        }
        if (i < 1)
        {
            return "";
        }
        char ac[] = new char[i];
        Random random = new Random();
        for (int j = 0; j < i; j++)
        {
            ac[j] = s.charAt(random.nextInt(i));
        }

        return new String(ac);
    }

    public static String generate(String s)
    {
        return generate(8, s);
    }

    public static String nextId()
    {
        if (idFormat == null)
        {
            idFormat = (new StringBuilder()).append("cvid-").append(generate(8, "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789")).append("-%05d").toString();
        }
        String s = idFormat;
        int i = idIndex + 1;
        idIndex = i;
        return String.format(s, new Object[] {
            Integer.valueOf(i)
        });
    }

}
