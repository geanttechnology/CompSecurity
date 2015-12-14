// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;


public final class  extends Enum
{

    private static final SHARE_PHOTO $VALUES[];
    public static final SHARE_PHOTO CLOSE_CONFIRM;
    public static final SHARE_PHOTO EDIT_CALLOUT;
    public static final SHARE_PHOTO EDIT_TEXT;
    public static final SHARE_PHOTO OPEN_RESIZE_DIALOG;
    public static final SHARE_PHOTO SAVE_PHOTO;
    public static final SHARE_PHOTO SELECT_CALLOUT;
    public static final SHARE_PHOTO SELECT_CLIPART;
    public static final SHARE_PHOTO SELECT_FRAME;
    public static final SHARE_PHOTO SELECT_LENS_FLARE;
    public static final SHARE_PHOTO SELECT_PHOTO;
    public static final SHARE_PHOTO SELECT_STICKER;
    public static final SHARE_PHOTO SELECT_TEXT;
    public static final SHARE_PHOTO SHARE_PHOTO;

    public static  fromInt(int i)
    {
         a[] = values();
        if (i < 0 || i >= a.length)
        {
            return null;
        } else
        {
            return values()[i];
        }
    }

    public static values valueOf(String s)
    {
        return (values)Enum.valueOf(com/picsart/studio/editor/activity/EditorActivity$RequestCode, s);
    }

    public static values[] values()
    {
        return (values[])$VALUES.clone();
    }

    public final int toInt()
    {
        return ordinal();
    }

    static 
    {
        SELECT_CLIPART = new <init>("SELECT_CLIPART", 0);
        SELECT_STICKER = new <init>("SELECT_STICKER", 1);
        SELECT_TEXT = new <init>("SELECT_TEXT", 2);
        EDIT_TEXT = new <init>("EDIT_TEXT", 3);
        SELECT_CALLOUT = new <init>("SELECT_CALLOUT", 4);
        SELECT_LENS_FLARE = new <init>("SELECT_LENS_FLARE", 5);
        SELECT_PHOTO = new <init>("SELECT_PHOTO", 6);
        SAVE_PHOTO = new <init>("SAVE_PHOTO", 7);
        EDIT_CALLOUT = new <init>("EDIT_CALLOUT", 8);
        OPEN_RESIZE_DIALOG = new <init>("OPEN_RESIZE_DIALOG", 9);
        CLOSE_CONFIRM = new <init>("CLOSE_CONFIRM", 10);
        SELECT_FRAME = new <init>("SELECT_FRAME", 11);
        SHARE_PHOTO = new <init>("SHARE_PHOTO", 12);
        $VALUES = (new .VALUES[] {
            SELECT_CLIPART, SELECT_STICKER, SELECT_TEXT, EDIT_TEXT, SELECT_CALLOUT, SELECT_LENS_FLARE, SELECT_PHOTO, SAVE_PHOTO, EDIT_CALLOUT, OPEN_RESIZE_DIALOG, 
            CLOSE_CONFIRM, SELECT_FRAME, SHARE_PHOTO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
