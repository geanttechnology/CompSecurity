// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class FeedItemFooterLayout
{
    public static final class Layout extends Enum
    {

        private static final Layout $VALUES[];
        public static final Layout LEGACY_FOOTER;
        public static final Layout SIMPLE_LAUNCH_FOOTER;
        public static final Layout SOCIAL_ACTIONS_FOOTER;
        public static final Layout invalid;

        public static Layout valueOf(String s)
        {
            return (Layout)Enum.valueOf(com/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout, s);
        }

        public static Layout[] values()
        {
            return (Layout[])$VALUES.clone();
        }

        static 
        {
            SOCIAL_ACTIONS_FOOTER = new Layout("SOCIAL_ACTIONS_FOOTER", 0);
            SIMPLE_LAUNCH_FOOTER = new Layout("SIMPLE_LAUNCH_FOOTER", 1);
            LEGACY_FOOTER = new Layout("LEGACY_FOOTER", 2);
            invalid = new Layout("invalid", 3);
            $VALUES = (new Layout[] {
                SOCIAL_ACTIONS_FOOTER, SIMPLE_LAUNCH_FOOTER, LEGACY_FOOTER, invalid
            });
        }

        private Layout(String s, int i)
        {
            super(s, i);
        }
    }


    public Layout currentLayout;

    public FeedItemFooterLayout()
    {
        currentLayout = Layout.invalid;
    }

    public FeedItemFooterLayout(Layout layout)
    {
        currentLayout = Layout.invalid;
        currentLayout = layout;
    }
}
