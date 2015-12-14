// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library;


public final class Constants
{
    public static final class QuickLaunch
    {

        public static final String CONTENT_ITEM_ID = "quick-contentId";
        public static final String CONTENT_PACK_ID = "quick-packId";
        public static final String NUMERIC_VALUE = "quick-numericValue";
        public static final String STRING_VALUE = "quick-stringValue";

        public QuickLaunch()
        {
        }
    }

    public static final class SourceType extends Enum
    {

        private static final SourceType $VALUES[];
        public static final SourceType Camera;
        public static final SourceType Gallery;
        public static final SourceType Grid;
        public static final SourceType None;

        public static SourceType valueOf(String s)
        {
            return (SourceType)Enum.valueOf(com/aviary/android/feather/library/Constants$SourceType, s);
        }

        public static SourceType[] values()
        {
            return (SourceType[])$VALUES.clone();
        }

        static 
        {
            None = new SourceType("None", 0);
            Camera = new SourceType("Camera", 1);
            Gallery = new SourceType("Gallery", 2);
            Grid = new SourceType("Grid", 3);
            $VALUES = (new SourceType[] {
                None, Camera, Gallery, Grid
            });
        }

        private SourceType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int APP_MEMORY_LARGE = 127;
    public static final int APP_MEMORY_MEDIUM = 48;
    public static final int APP_MEMORY_SMALL = 32;
    public static final int DEFAULT_IMAGE_QUALITY = 97;
    public static final String EXTRA_APP_ID = "app-id";
    public static final String EXTRA_HIDE_EXIT_UNSAVE_CONFIRMATION = "hide-exit-unsave-confirmation";
    public static final String EXTRA_IN_API_KEY_SECRET = "extra-api-key-secret";
    public static final String EXTRA_IN_BILLING_PUBLIC_KEY = "extra-billing-public-key";
    public static final String EXTRA_IN_EXTRAS = "extra-in-extras";
    public static final String EXTRA_IN_HIRES_MEGAPIXELS = "output-hires-megapixels";
    public static final String EXTRA_IN_PREVIEW_MAX_SIZE = "max-image-size";
    public static final String EXTRA_IN_SAVE_ON_NO_CHANGES = "save-on-no-changes";
    public static final String EXTRA_IN_SOURCE_TYPE = "source-type";
    public static final String EXTRA_OUTPUT = "output";
    public static final String EXTRA_OUTPUT_FORMAT = "output-format";
    public static final String EXTRA_OUTPUT_QUALITY = "output-quality";
    public static final String EXTRA_OUT_BITMAP_CHANGED = "bitmap-changed";
    public static final String EXTRA_QUICK_LAUNCH_TOOL = "extra-in-quick-tool";
    public static final String EXTRA_QUICK_LAUNCH_TOOL_OPTIONS = "extra-in-quick-tool-options";
    public static final String EXTRA_RETURN_DATA = "return-data";
    public static final String EXTRA_TOOLS_DISABLE_VIBRATION = "tools-vibration-disabled";
    public static final String EXTRA_TOOLS_LIST = "tools-list";
    public static final String EXTRA_WHITELABEL = "white-label";

    private Constants()
    {
    }
}
