// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;


// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GalleryBadgeableCoverView

public static final class viewId extends Enum
{

    private static final SHARED $VALUES[];
    public static final SHARED ACTIVE;
    public static final SHARED DEVICE;
    public static final SHARED HIDDEN;
    public static final SHARED HIGHLIGHT;
    public static final SHARED LENTICULAR;
    public static final SHARED NEW_CONTENT;
    public static final SHARED NOT_UPLOADED;
    public static final SHARED NO_NETWORK;
    public static final SHARED PLAYABLE;
    public static final SHARED QUEUED;
    public static final SHARED REWIND;
    public static final SHARED SELECTED;
    public static final SHARED SHARED;
    public static final SHARED UPLOADED;
    public static final SHARED UPLOADING;
    public static final SHARED UPLOADING_NO_PROGRESS;
    public final int category;
    public final int viewId;

    public static viewId valueOf(String s)
    {
        return (viewId)Enum.valueOf(com/amazon/gallery/framework/gallery/widget/GalleryBadgeableCoverView$BadgeType, s);
    }

    public static viewId[] values()
    {
        return (viewId[])$VALUES.clone();
    }

    static 
    {
        HIGHLIGHT = new <init>("HIGHLIGHT", 0, 0, 0x7f0c0175);
        PLAYABLE = new <init>("PLAYABLE", 1, 1, -1);
        NO_NETWORK = new <init>("NO_NETWORK", 2, 2, 0x7f0c0134);
        UPLOADED = new <init>("UPLOADED", 3, 2, 0x7f0c0130);
        NOT_UPLOADED = new <init>("NOT_UPLOADED", 4, 2, 0x7f0c0134);
        UPLOADING = new <init>("UPLOADING", 5, 2, -1);
        UPLOADING_NO_PROGRESS = new <init>("UPLOADING_NO_PROGRESS", 6, 2, 0x7f0c0204);
        NEW_CONTENT = new <init>("NEW_CONTENT", 7, 2, 0x7f0c018c);
        DEVICE = new <init>("DEVICE", 8, 2, 0x7f0c012e);
        HIDDEN = new <init>("HIDDEN", 9, 6, 0x7f0c0174);
        LENTICULAR = new <init>("LENTICULAR", 10, 5, 0x7f0c0183);
        REWIND = new <init>("REWIND", 11, 5, 0x7f0c01c6);
        ACTIVE = new <init>("ACTIVE", 12, 3, -1);
        SELECTED = new <init>("SELECTED", 13, 4, 0x7f0c01c7);
        QUEUED = new <init>("QUEUED", 14, 7, 0x7f0c01c3);
        SHARED = new <init>("SHARED", 15, 6, 0x7f0c01c9);
        $VALUES = (new .VALUES[] {
            HIGHLIGHT, PLAYABLE, NO_NETWORK, UPLOADED, NOT_UPLOADED, UPLOADING, UPLOADING_NO_PROGRESS, NEW_CONTENT, DEVICE, HIDDEN, 
            LENTICULAR, REWIND, ACTIVE, SELECTED, QUEUED, SHARED
        });
    }

    private (String s, int i, int j, int k)
    {
        super(s, i);
        category = j;
        viewId = k;
    }
}
