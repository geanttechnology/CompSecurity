// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;


// Referenced classes of package com.smule.pianoandroid.data.model:
//            Listing, Section

public class SectionListingLink
{

    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_LISTING = "listing";
    public static final String COLUMN_NAME_SECTION = "section";
    public static final String COLUMN_NAME_SECTION_ORDER = "section_order";
    public int _id;
    public Listing listing;
    public Section section;
    public int sectionOrder;

    public SectionListingLink()
    {
    }
}
