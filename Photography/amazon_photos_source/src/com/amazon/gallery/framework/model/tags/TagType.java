// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.tags;


public final class TagType extends Enum
{

    private static final TagType $VALUES[];
    public static final TagType ALBUM;
    public static final TagType ALL;
    public static final TagType EVENT;
    public static final TagType FOLDER;
    public static final TagType LOCAL_FOLDER;
    public static final TagType PERSON;
    public static final TagType PLACE;
    public static final TagType SOURCE;
    public static final TagType UNKNOWN;

    private TagType(String s, int i)
    {
        super(s, i);
    }

    public static TagType valueOf(String s)
    {
        return (TagType)Enum.valueOf(com/amazon/gallery/framework/model/tags/TagType, s);
    }

    public static TagType[] values()
    {
        return (TagType[])$VALUES.clone();
    }

    static 
    {
        PERSON = new TagType("PERSON", 0);
        PLACE = new TagType("PLACE", 1);
        EVENT = new TagType("EVENT", 2);
        ALBUM = new TagType("ALBUM", 3);
        FOLDER = new TagType("FOLDER", 4);
        SOURCE = new TagType("SOURCE", 5);
        ALL = new TagType("ALL", 6);
        LOCAL_FOLDER = new TagType("LOCAL_FOLDER", 7);
        UNKNOWN = new TagType("UNKNOWN", 8);
        $VALUES = (new TagType[] {
            PERSON, PLACE, EVENT, ALBUM, FOLDER, SOURCE, ALL, LOCAL_FOLDER, UNKNOWN
        });
    }
}
