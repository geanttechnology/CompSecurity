// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

static final class mRequired extends Enum
{

    private static final mName $VALUES[];
    public static final mName CALL_TO_ACTION;
    public static final mName CLICK_DESTINATION;
    public static final mName CLICK_TRACKER;
    public static final mName FALLBACK;
    public static final mName ICON_URL;
    public static final mName IMAGE_URL;
    public static final mName IMPRESSION_TRACKER;
    public static final mName TEXT;
    public static final mName TITLE;
    public static final mName VAST_VIDEO;
    static final Set requiredKeys;
    final String mName;
    final boolean mRequired;

    static mRequired from(String s)
    {
        Preconditions.checkNotNull(s);
        mRequired amrequired[] = values();
        int j = amrequired.length;
        for (int i = 0; i < j; i++)
        {
            mRequired mrequired = amrequired[i];
            if (mrequired.mName.equals(s))
            {
                return mrequired;
            }
        }

        return null;
    }

    public static mName valueOf(String s)
    {
        return (mName)Enum.valueOf(com/mopub/nativeads/MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter, s);
    }

    public static mName[] values()
    {
        return (mName[])$VALUES.clone();
    }

    static 
    {
        IMPRESSION_TRACKER = new <init>("IMPRESSION_TRACKER", 0, "imptracker", true);
        CLICK_TRACKER = new <init>("CLICK_TRACKER", 1, "clktracker", true);
        TITLE = new <init>("TITLE", 2, "title", false);
        TEXT = new <init>("TEXT", 3, "text", false);
        IMAGE_URL = new <init>("IMAGE_URL", 4, "mainimage", false);
        ICON_URL = new <init>("ICON_URL", 5, "iconimage", false);
        CLICK_DESTINATION = new <init>("CLICK_DESTINATION", 6, "clk", false);
        FALLBACK = new <init>("FALLBACK", 7, "fallback", false);
        CALL_TO_ACTION = new <init>("CALL_TO_ACTION", 8, "ctatext", false);
        VAST_VIDEO = new <init>("VAST_VIDEO", 9, "video", false);
        $VALUES = (new .VALUES[] {
            IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, IMAGE_URL, ICON_URL, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, VAST_VIDEO
        });
        requiredKeys = new HashSet();
        r_3B_.clone aclone[] = values();
        int j = aclone.length;
        for (int i = 0; i < j; i++)
        {
            r_3B_.clone clone = aclone[i];
            if (clone.mRequired)
            {
                requiredKeys.add(clone.mName);
            }
        }

    }

    private (String s, int i, String s1, boolean flag)
    {
        super(s, i);
        Preconditions.checkNotNull(s1);
        mName = s1;
        mRequired = flag;
    }
}
