// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;


public class CategoryMetadata
{

    public final String guId;
    public final String id;
    public final int imageResId;
    public final int titleResId;

    public CategoryMetadata(String s, String s1, int i, int j)
    {
        id = s;
        guId = s1;
        imageResId = j;
        titleResId = i;
    }
}
