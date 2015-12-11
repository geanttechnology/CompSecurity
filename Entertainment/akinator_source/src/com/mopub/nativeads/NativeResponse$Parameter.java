// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.mopub.nativeads:
//            NativeResponse

static final class required extends Enum
{

    private static final name $VALUES[];
    public static final name CALL_TO_ACTION;
    public static final name CLICK_DESTINATION;
    public static final name CLICK_TRACKER;
    public static final name FALLBACK;
    public static final name ICON_IMAGE;
    public static final name IMPRESSION_TRACKER;
    public static final name MAIN_IMAGE;
    public static final name STAR_RATING;
    public static final name TEXT;
    public static final name TITLE;
    static final Set requiredKeys;
    final String name;
    final boolean required;

    static required from(String s)
    {
        required arequired[] = values();
        int j = arequired.length;
        for (int i = 0; i < j; i++)
        {
            required required1 = arequired[i];
            if (required1.name.equals(s))
            {
                return required1;
            }
        }

        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/mopub/nativeads/NativeResponse$Parameter, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        IMPRESSION_TRACKER = new <init>("IMPRESSION_TRACKER", 0, "imptracker", true);
        CLICK_TRACKER = new <init>("CLICK_TRACKER", 1, "clktracker", true);
        TITLE = new <init>("TITLE", 2, "title", false);
        TEXT = new <init>("TEXT", 3, "text", false);
        MAIN_IMAGE = new <init>("MAIN_IMAGE", 4, "mainimage", false);
        ICON_IMAGE = new <init>("ICON_IMAGE", 5, "iconimage", false);
        CLICK_DESTINATION = new <init>("CLICK_DESTINATION", 6, "clk", false);
        FALLBACK = new <init>("FALLBACK", 7, "fallback", false);
        CALL_TO_ACTION = new <init>("CALL_TO_ACTION", 8, "ctatext", false);
        STAR_RATING = new <init>("STAR_RATING", 9, "starrating", false);
        $VALUES = (new .VALUES[] {
            IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, MAIN_IMAGE, ICON_IMAGE, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, STAR_RATING
        });
        requiredKeys = new HashSet();
        r_3B_.clone aclone[] = values();
        int j = aclone.length;
        for (int i = 0; i < j; i++)
        {
            r_3B_.clone clone = aclone[i];
            if (clone.required)
            {
                requiredKeys.add(clone.name);
            }
        }

    }

    private (String s, int i, String s1, boolean flag)
    {
        super(s, i);
        name = s1;
        required = flag;
    }
}
