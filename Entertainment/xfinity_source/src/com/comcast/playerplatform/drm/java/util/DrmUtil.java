// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.util;

import com.comcast.playerplatform.util.android.StringUtil;
import java.util.Random;

public class DrmUtil
{

    public DrmUtil()
    {
    }

    private static byte[] charToByteArray(char ac[])
    {
        byte abyte0[] = new byte[ac.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)ac[i];
        }

        return abyte0;
    }

    public static String generateDrmKeyString(Boolean boolean1, String s, String s1, boolean flag, boolean flag1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\"message:id\":\"").append(s1).append("\", \"message:type\":\"clientAccess\"");
        if (!boolean1.booleanValue() && StringUtil.isNotNullOrEmpty(s))
        {
            stringbuilder.append(", \"client:accessToken\":\"").append(s).append("\"");
        }
        if (flag)
        {
            if (flag1)
            {
                stringbuilder.append(", \"client:mediaUsage\":\"download\"");
            } else
            {
                stringbuilder.append(", \"client:mediaUsage\":\"stream\"");
            }
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public static String generateId()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                stringbuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(35)));
            }

            if (i != 3)
            {
                stringbuilder.append("-");
            }
        }

        return stringbuilder.toString();
    }

    public static byte[] generateNonce()
    {
        char ac[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();
        char ac1[] = new char[20];
        for (int i = 0; i < 20; i++)
        {
            ac1[i] = ac[random.nextInt(25)];
        }

        return charToByteArray(ac1);
    }

    public static String generateWhiteListString()
    {
        return (new StringBuilder()).append("message:id=").append(generateId()).toString();
    }
}
