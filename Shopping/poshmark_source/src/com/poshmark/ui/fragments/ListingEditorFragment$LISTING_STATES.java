// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

static final class  extends Enum
{

    private static final SHARE_LISTING $VALUES[];
    public static final SHARE_LISTING EDIT_LISTING;
    public static final SHARE_LISTING EDIT_PHOTO;
    public static final SHARE_LISTING FILTER_PHOTO;
    public static final SHARE_LISTING GET_AVAILABILITY_STATUS;
    public static final SHARE_LISTING GET_BRAND;
    public static final SHARE_LISTING GET_CATEGORY;
    public static final SHARE_LISTING GET_COLOR;
    public static final SHARE_LISTING GET_CONDITION_STATUS;
    public static final SHARE_LISTING GET_SIZE;
    public static final SHARE_LISTING LISTING_SETUP_STATE;
    public static final SHARE_LISTING NEW_PHOTO;
    public static final SHARE_LISTING SHARE_LISTING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LISTING_SETUP_STATE = new <init>("LISTING_SETUP_STATE", 0);
        EDIT_LISTING = new <init>("EDIT_LISTING", 1);
        EDIT_PHOTO = new <init>("EDIT_PHOTO", 2);
        FILTER_PHOTO = new <init>("FILTER_PHOTO", 3);
        NEW_PHOTO = new <init>("NEW_PHOTO", 4);
        GET_BRAND = new <init>("GET_BRAND", 5);
        GET_SIZE = new <init>("GET_SIZE", 6);
        GET_COLOR = new <init>("GET_COLOR", 7);
        GET_CATEGORY = new <init>("GET_CATEGORY", 8);
        GET_CONDITION_STATUS = new <init>("GET_CONDITION_STATUS", 9);
        GET_AVAILABILITY_STATUS = new <init>("GET_AVAILABILITY_STATUS", 10);
        SHARE_LISTING = new <init>("SHARE_LISTING", 11);
        $VALUES = (new .VALUES[] {
            LISTING_SETUP_STATE, EDIT_LISTING, EDIT_PHOTO, FILTER_PHOTO, NEW_PHOTO, GET_BRAND, GET_SIZE, GET_COLOR, GET_CATEGORY, GET_CONDITION_STATUS, 
            GET_AVAILABILITY_STATUS, SHARE_LISTING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
