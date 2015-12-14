// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.multiselect;


public final class MultiSelectKind extends Enum
{

    private static final MultiSelectKind $VALUES[];
    public static final MultiSelectKind CLOUD_VIDEO;
    public static final MultiSelectKind LOCAL_VIDEO;
    public static final MultiSelectKind NOT_ALLOWED;
    public static final MultiSelectKind PHOTO;

    private MultiSelectKind(String s, int i)
    {
        super(s, i);
    }

    public static MultiSelectKind valueOf(String s)
    {
        return (MultiSelectKind)Enum.valueOf(com/amazon/gallery/framework/gallery/view/multiselect/MultiSelectKind, s);
    }

    public static MultiSelectKind[] values()
    {
        return (MultiSelectKind[])$VALUES.clone();
    }

    static 
    {
        PHOTO = new MultiSelectKind("PHOTO", 0);
        CLOUD_VIDEO = new MultiSelectKind("CLOUD_VIDEO", 1);
        LOCAL_VIDEO = new MultiSelectKind("LOCAL_VIDEO", 2);
        NOT_ALLOWED = new MultiSelectKind("NOT_ALLOWED", 3);
        $VALUES = (new MultiSelectKind[] {
            PHOTO, CLOUD_VIDEO, LOCAL_VIDEO, NOT_ALLOWED
        });
    }
}
