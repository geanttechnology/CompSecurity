// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import java.util.List;

public class EditorialVideoCoverResource
{

    private String collectionTitle;
    private List programs;

    public EditorialVideoCoverResource(List list, String s)
    {
        programs = list;
        collectionTitle = s;
    }

    public String getCollectionTitle()
    {
        return collectionTitle;
    }

    public List getPrograms()
    {
        return programs;
    }
}
