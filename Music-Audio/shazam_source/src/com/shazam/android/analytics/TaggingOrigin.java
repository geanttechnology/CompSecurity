// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;


public final class TaggingOrigin extends Enum
{

    private static final TaggingOrigin $VALUES[];
    public static final TaggingOrigin BACKGROUND;
    public static final TaggingOrigin DEEPLINK;
    public static final TaggingOrigin FLOATING_BUTTON;
    public static final TaggingOrigin MINI_TAG_BUTTON;
    public static final TaggingOrigin PRIMARY;
    public static final TaggingOrigin TAB_BAR;
    public static final TaggingOrigin TAG_ON_START;
    public static final TaggingOrigin TOP_BAR;
    public static final TaggingOrigin UNKNOWN;
    public static final TaggingOrigin UNSUBMITTED;
    public static final TaggingOrigin VISUAL_SHAZAM;
    public static final TaggingOrigin VOICE_ACTION;
    public static final TaggingOrigin WATERMARKS;
    public static final TaggingOrigin WEARABLE;
    public static final TaggingOrigin WIDGET;
    private final String origin;

    private TaggingOrigin(String s, int i, String s1)
    {
        super(s, i);
        origin = s1;
    }

    public static TaggingOrigin fromString(String s)
    {
        if (s != null)
        {
            TaggingOrigin ataggingorigin[] = values();
            int j = ataggingorigin.length;
            for (int i = 0; i < j; i++)
            {
                TaggingOrigin taggingorigin = ataggingorigin[i];
                if (s.equalsIgnoreCase(taggingorigin.getOrigin()))
                {
                    return taggingorigin;
                }
            }

        }
        return UNKNOWN;
    }

    public static TaggingOrigin valueOf(String s)
    {
        return (TaggingOrigin)Enum.valueOf(com/shazam/android/analytics/TaggingOrigin, s);
    }

    public static TaggingOrigin[] values()
    {
        return (TaggingOrigin[])$VALUES.clone();
    }

    public final String getOrigin()
    {
        return origin;
    }

    static 
    {
        UNKNOWN = new TaggingOrigin("UNKNOWN", 0, "unknown");
        PRIMARY = new TaggingOrigin("PRIMARY", 1, "primary");
        TAB_BAR = new TaggingOrigin("TAB_BAR", 2, "tabbar");
        TOP_BAR = new TaggingOrigin("TOP_BAR", 3, "topbar");
        TAG_ON_START = new TaggingOrigin("TAG_ON_START", 4, "tagonstart");
        DEEPLINK = new TaggingOrigin("DEEPLINK", 5, "deeplink");
        UNSUBMITTED = new TaggingOrigin("UNSUBMITTED", 6, "unsubmitted");
        BACKGROUND = new TaggingOrigin("BACKGROUND", 7, "background");
        WATERMARKS = new TaggingOrigin("WATERMARKS", 8, "watermarks");
        FLOATING_BUTTON = new TaggingOrigin("FLOATING_BUTTON", 9, "floatingbutton");
        MINI_TAG_BUTTON = new TaggingOrigin("MINI_TAG_BUTTON", 10, "minitagbutton");
        WEARABLE = new TaggingOrigin("WEARABLE", 11, "wearable");
        WIDGET = new TaggingOrigin("WIDGET", 12, "widget");
        VOICE_ACTION = new TaggingOrigin("VOICE_ACTION", 13, "voiceaction");
        VISUAL_SHAZAM = new TaggingOrigin("VISUAL_SHAZAM", 14, "visualshazam");
        $VALUES = (new TaggingOrigin[] {
            UNKNOWN, PRIMARY, TAB_BAR, TOP_BAR, TAG_ON_START, DEEPLINK, UNSUBMITTED, BACKGROUND, WATERMARKS, FLOATING_BUTTON, 
            MINI_TAG_BUTTON, WEARABLE, WIDGET, VOICE_ACTION, VISUAL_SHAZAM
        });
    }
}
