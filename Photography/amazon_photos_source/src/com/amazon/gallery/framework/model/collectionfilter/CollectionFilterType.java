// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.collectionfilter;


public final class CollectionFilterType extends Enum
{

    private static final CollectionFilterType $VALUES[];
    public static final CollectionFilterType FOLDER;
    public static final CollectionFilterType UNKNOWN;
    private final String typeId;

    private CollectionFilterType(String s, int i, String s1)
    {
        super(s, i);
        typeId = s1;
    }

    public static CollectionFilterType getTypeFromId(String s)
    {
        CollectionFilterType acollectionfiltertype[] = values();
        int j = acollectionfiltertype.length;
        for (int i = 0; i < j; i++)
        {
            CollectionFilterType collectionfiltertype = acollectionfiltertype[i];
            if (collectionfiltertype.getTypeId().equals(s))
            {
                return collectionfiltertype;
            }
        }

        return UNKNOWN;
    }

    public static CollectionFilterType valueOf(String s)
    {
        return (CollectionFilterType)Enum.valueOf(com/amazon/gallery/framework/model/collectionfilter/CollectionFilterType, s);
    }

    public static CollectionFilterType[] values()
    {
        return (CollectionFilterType[])$VALUES.clone();
    }

    public String getTypeId()
    {
        return typeId;
    }

    static 
    {
        UNKNOWN = new CollectionFilterType("UNKNOWN", 0, "unknown");
        FOLDER = new CollectionFilterType("FOLDER", 1, "folderIds");
        $VALUES = (new CollectionFilterType[] {
            UNKNOWN, FOLDER
        });
    }
}
