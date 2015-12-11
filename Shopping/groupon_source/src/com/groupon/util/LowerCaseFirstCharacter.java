// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public class LowerCaseFirstCharacter
{

    public LowerCaseFirstCharacter()
    {
    }

    public static String toLowerCaseFirstCharacter(String s)
    {
        if (s == null || s.length() == 0)
        {
            return s;
        }
        if (s.length() == 1)
        {
            return s.toLowerCase();
        } else
        {
            return (new StringBuilder()).append(s.substring(0, 1).toLowerCase()).append(s.substring(1)).toString();
        }
    }
}
