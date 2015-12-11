// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.os;


public class SystemProperties
{

    public SystemProperties()
    {
    }

    public static String get(String s, String s1)
    {
        return System.getProperty(s, s1);
    }
}
