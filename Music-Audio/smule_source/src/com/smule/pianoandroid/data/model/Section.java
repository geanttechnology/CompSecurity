// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import java.util.Collection;
import java.util.Date;

public class Section
{

    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_LISTINGS = "listings";
    public static final String COLUMN_NAME_UID = "uid";
    public static final String COLUMN_NAME_UPDATED_AT = "updated_at";
    public int _id;
    public Collection listings;
    public Collection sectionListings;
    public String uid;
    public Date updatedAt;

    public Section()
    {
    }

    public void copyLocal(Section section)
    {
        _id = section._id;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((Section)obj);
    }

    public String equatableId()
    {
        return uid;
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }
}
