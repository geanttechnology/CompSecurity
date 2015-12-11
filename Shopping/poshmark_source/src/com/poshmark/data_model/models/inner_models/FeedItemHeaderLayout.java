// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class FeedItemHeaderLayout
{
    public static final class Layout extends Enum
    {

        private static final Layout $VALUES[];
        public static final Layout DOUBLE_LEVEL_HEADER;
        public static final Layout LEGACY_HEADER;
        public static final Layout SINGLE_LEVEL_HEADER;
        public static final Layout SINGLE_LEVEL_HEADER_POSHPOST;
        public static final Layout invalid;

        public static Layout valueOf(String s)
        {
            return (Layout)Enum.valueOf(com/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout, s);
        }

        public static Layout[] values()
        {
            return (Layout[])$VALUES.clone();
        }

        static 
        {
            SINGLE_LEVEL_HEADER = new Layout("SINGLE_LEVEL_HEADER", 0);
            DOUBLE_LEVEL_HEADER = new Layout("DOUBLE_LEVEL_HEADER", 1);
            LEGACY_HEADER = new Layout("LEGACY_HEADER", 2);
            SINGLE_LEVEL_HEADER_POSHPOST = new Layout("SINGLE_LEVEL_HEADER_POSHPOST", 3);
            invalid = new Layout("invalid", 4);
            $VALUES = (new Layout[] {
                SINGLE_LEVEL_HEADER, DOUBLE_LEVEL_HEADER, LEGACY_HEADER, SINGLE_LEVEL_HEADER_POSHPOST, invalid
            });
        }

        private Layout(String s, int i)
        {
            super(s, i);
        }
    }


    public Layout currentLayout;

    public FeedItemHeaderLayout()
    {
        currentLayout = Layout.invalid;
    }

    public FeedItemHeaderLayout(Layout layout)
    {
        currentLayout = Layout.invalid;
        currentLayout = layout;
    }
}
