// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;


public class PlayerUtil
{

    private static String sAuthority;

    public PlayerUtil()
    {
    }

    public static String getAuthority(String s)
    {
        return (new StringBuilder()).append(sAuthority).append(s).toString();
    }

    public static void setup(String s)
    {
        sAuthority = s;
    }
}
