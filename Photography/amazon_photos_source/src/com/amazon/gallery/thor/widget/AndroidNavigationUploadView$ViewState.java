// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;


// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationUploadView

private static final class priority extends Enum
{

    private static final PAUSED $VALUES[];
    public static final PAUSED PAUSED;
    public static final PAUSED REST;
    public static final PAUSED SYNCING;
    public static final PAUSED UPLOADING;
    private int priority;

    public static priority valueOf(String s)
    {
        return (priority)Enum.valueOf(com/amazon/gallery/thor/widget/AndroidNavigationUploadView$ViewState, s);
    }

    public static priority[] values()
    {
        return (priority[])$VALUES.clone();
    }

    boolean isHigherPriority(e_3B_.clone clone)
    {
        return priority < clone.priority;
    }

    static 
    {
        SYNCING = new <init>("SYNCING", 0, 0);
        UPLOADING = new <init>("UPLOADING", 1, 1);
        REST = new <init>("REST", 2, 2);
        PAUSED = new <init>("PAUSED", 3, 2);
        $VALUES = (new .VALUES[] {
            SYNCING, UPLOADING, REST, PAUSED
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        priority = j;
    }
}
