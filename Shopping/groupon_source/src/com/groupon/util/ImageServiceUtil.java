// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public class ImageServiceUtil
{

    public ImageServiceUtil()
    {
    }

    public static String getLargeImageUrl(String s)
    {
        return (new StringBuilder()).append(s).append("t440x300.jpg").toString();
    }
}
