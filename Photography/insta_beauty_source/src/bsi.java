// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bsi
{

    public static String a(int i)
    {
        return (new StringBuilder()).append(i >> 24 & 0xff).append(".").append(i >> 16 & 0xff).append(".").append(i >> 8 & 0xff).append(".").append(i & 0xff).toString();
    }
}
