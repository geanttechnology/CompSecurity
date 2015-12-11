// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


public class FBUtils
{

    public FBUtils()
    {
    }

    public static String getUserFBImageURL(String s)
    {
        return (new StringBuilder()).append("https://graph.facebook.com/").append(s).append("/picture?type=square").toString();
    }
}
