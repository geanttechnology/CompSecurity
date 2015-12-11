// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


public class DerivedGiftTheme
{

    public int categoryIndex;
    public String id;
    public String imageUrl;
    public boolean selected;
    public int subIndex;

    public DerivedGiftTheme(String s, String s1)
    {
        imageUrl = s;
        id = s1;
    }
}
