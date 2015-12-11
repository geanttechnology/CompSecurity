// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;

import java.util.List;

public class Layout
{
    public static class LayoutEntry
    {

        public String locator;
        public LayoutEntryType type;

        public LayoutEntry()
        {
        }
    }

    public static final class LayoutEntryType extends Enum
    {

        private static final LayoutEntryType $VALUES[];
        public static final LayoutEntryType LABELED_ITEM_ANSWER;
        public static final LayoutEntryType LISTING;
        public static final LayoutEntryType PRODUCT;
        public static final LayoutEntryType QUERY_ANSWER;
        public static final LayoutEntryType REWRITE_START;

        public static LayoutEntryType valueOf(String s)
        {
            return (LayoutEntryType)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Layout$LayoutEntryType, s);
        }

        public static LayoutEntryType[] values()
        {
            return (LayoutEntryType[])$VALUES.clone();
        }

        static 
        {
            LISTING = new LayoutEntryType("LISTING", 0);
            PRODUCT = new LayoutEntryType("PRODUCT", 1);
            LABELED_ITEM_ANSWER = new LayoutEntryType("LABELED_ITEM_ANSWER", 2);
            QUERY_ANSWER = new LayoutEntryType("QUERY_ANSWER", 3);
            REWRITE_START = new LayoutEntryType("REWRITE_START", 4);
            $VALUES = (new LayoutEntryType[] {
                LISTING, PRODUCT, LABELED_ITEM_ANSWER, QUERY_ANSWER, REWRITE_START
            });
        }

        private LayoutEntryType(String s, int i)
        {
            super(s, i);
        }
    }


    public List layoutEntries;

    public Layout()
    {
    }
}
