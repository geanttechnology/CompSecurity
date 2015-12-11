// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class PMColor
{

    public String name;
    public String rgb;

    public PMColor()
    {
    }

    public PMColor(String s, String s1)
    {
        name = s;
        rgb = s1;
    }

    public static PMColor clone(PMColor pmcolor)
    {
        return new PMColor(pmcolor.name, pmcolor.rgb);
    }

    public String getName()
    {
        return name;
    }
}
