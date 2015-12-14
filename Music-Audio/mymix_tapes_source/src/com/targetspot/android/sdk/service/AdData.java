// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;


public class AdData
{

    String type;
    String url;

    AdData(String s, String s1)
    {
        url = s;
        type = s1;
    }

    public String getType()
    {
        return type;
    }

    public String getUrl()
    {
        return url;
    }
}
