// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models;

import java.util.List;

public class VPCatalog
{
    public static final class CatalogType extends Enum
    {

        private static final CatalogType $VALUES[];
        public static final CatalogType CHANNEL;
        public static final CatalogType SCHEDULE;
        public static final CatalogType VIDEO;

        public static CatalogType valueOf(String s)
        {
            return (CatalogType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType, s);
        }

        public static CatalogType[] values()
        {
            return (CatalogType[])$VALUES.clone();
        }

        static 
        {
            VIDEO = new CatalogType("VIDEO", 0);
            CHANNEL = new CatalogType("CHANNEL", 1);
            SCHEDULE = new CatalogType("SCHEDULE", 2);
            $VALUES = (new CatalogType[] {
                VIDEO, CHANNEL, SCHEDULE
            });
        }

        private CatalogType(String s, int i)
        {
            super(s, i);
        }
    }


    private CatalogType catalogType;
    private List collection;

    public VPCatalog()
    {
    }

    public List getCollection()
    {
        return collection;
    }

    public void setCollection(List list, CatalogType catalogtype)
    {
        collection = list;
        catalogType = catalogtype;
    }
}
