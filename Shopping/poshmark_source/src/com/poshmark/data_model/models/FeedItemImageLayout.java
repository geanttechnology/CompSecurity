// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class FeedItemImageLayout
{
    public static final class Layout extends Enum
    {

        private static final Layout $VALUES[];
        public static final Layout Invalid;
        public static final Layout MIFU_3_FLUID_LARGE_LEFT;
        public static final Layout MIFU_4_GRID;
        public static final Layout SIFU_LEFT_IMAGE_RIGHT_TEXT;
        public static final Layout SIFU_SOCIAL;
        public static final Layout SIFU_SUMMARY;

        public static Layout valueOf(String s)
        {
            return (Layout)Enum.valueOf(com/poshmark/data_model/models/FeedItemImageLayout$Layout, s);
        }

        public static Layout[] values()
        {
            return (Layout[])$VALUES.clone();
        }

        static 
        {
            SIFU_SUMMARY = new Layout("SIFU_SUMMARY", 0);
            SIFU_SOCIAL = new Layout("SIFU_SOCIAL", 1);
            MIFU_3_FLUID_LARGE_LEFT = new Layout("MIFU_3_FLUID_LARGE_LEFT", 2);
            MIFU_4_GRID = new Layout("MIFU_4_GRID", 3);
            SIFU_LEFT_IMAGE_RIGHT_TEXT = new Layout("SIFU_LEFT_IMAGE_RIGHT_TEXT", 4);
            Invalid = new Layout("Invalid", 5);
            $VALUES = (new Layout[] {
                SIFU_SUMMARY, SIFU_SOCIAL, MIFU_3_FLUID_LARGE_LEFT, MIFU_4_GRID, SIFU_LEFT_IMAGE_RIGHT_TEXT, Invalid
            });
        }

        private Layout(String s, int i)
        {
            super(s, i);
        }
    }


    Layout currentLayout;

    public FeedItemImageLayout()
    {
        currentLayout = Layout.Invalid;
    }

    public FeedItemImageLayout(String s)
    {
        currentLayout = Layout.Invalid;
        setLayoutType(s);
    }

    public Layout getCurrentLayout()
    {
        return currentLayout;
    }

    public boolean isLayoutValid()
    {
        return currentLayout != Layout.Invalid;
    }

    public void setLayoutType(String s)
    {
label0:
        {
            if (s != null)
            {
                if (!s.equalsIgnoreCase("SIFU_SUMMARY"))
                {
                    break label0;
                }
                currentLayout = Layout.SIFU_SUMMARY;
            }
            return;
        }
        if (s.equalsIgnoreCase("SIFU_SOCIAL"))
        {
            currentLayout = Layout.SIFU_SOCIAL;
            return;
        }
        if (s.equalsIgnoreCase("MIFU_3_FLUID_LARGE_LEFT"))
        {
            currentLayout = Layout.MIFU_3_FLUID_LARGE_LEFT;
            return;
        }
        if (s.equalsIgnoreCase("MIFU_4_GRID"))
        {
            currentLayout = Layout.MIFU_4_GRID;
            return;
        }
        if (s.equalsIgnoreCase("SIFU_LEFT_IMAGE_RIGHT_TEXT"))
        {
            currentLayout = Layout.SIFU_LEFT_IMAGE_RIGHT_TEXT;
            return;
        } else
        {
            currentLayout = Layout.Invalid;
            return;
        }
    }
}
