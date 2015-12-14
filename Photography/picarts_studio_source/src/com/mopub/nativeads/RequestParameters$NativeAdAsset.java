// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


public final class mAssetName extends Enum
{

    private static final STAR_RATING $VALUES[];
    public static final STAR_RATING CALL_TO_ACTION_TEXT;
    public static final STAR_RATING ICON_IMAGE;
    public static final STAR_RATING MAIN_IMAGE;
    public static final STAR_RATING STAR_RATING;
    public static final STAR_RATING TEXT;
    public static final STAR_RATING TITLE;
    private final String mAssetName;

    public static mAssetName valueOf(String s)
    {
        return (mAssetName)Enum.valueOf(com/mopub/nativeads/RequestParameters$NativeAdAsset, s);
    }

    public static mAssetName[] values()
    {
        return (mAssetName[])$VALUES.clone();
    }

    public final String toString()
    {
        return mAssetName;
    }

    static 
    {
        TITLE = new <init>("TITLE", 0, "title");
        TEXT = new <init>("TEXT", 1, "text");
        ICON_IMAGE = new <init>("ICON_IMAGE", 2, "iconimage");
        MAIN_IMAGE = new <init>("MAIN_IMAGE", 3, "mainimage");
        CALL_TO_ACTION_TEXT = new <init>("CALL_TO_ACTION_TEXT", 4, "ctatext");
        STAR_RATING = new <init>("STAR_RATING", 5, "starrating");
        $VALUES = (new .VALUES[] {
            TITLE, TEXT, ICON_IMAGE, MAIN_IMAGE, CALL_TO_ACTION_TEXT, STAR_RATING
        });
    }

    private _cls9(String s, int i, String s1)
    {
        super(s, i);
        mAssetName = s1;
    }
}
