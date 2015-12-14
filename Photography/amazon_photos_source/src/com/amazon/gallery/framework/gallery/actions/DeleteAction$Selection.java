// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction

protected static final class I extends Enum
{

    private static final DELETE_FROM_ALBUM $VALUES[];
    public static final DELETE_FROM_ALBUM CLOUD;
    public static final DELETE_FROM_ALBUM CLOUD_AND_LOCAL;
    public static final DELETE_FROM_ALBUM DELETE_FROM_ALBUM;
    public static final DELETE_FROM_ALBUM LOCAL;
    public static final DELETE_FROM_ALBUM REMOVE_FROM_ALBUM;
    public static final DELETE_FROM_ALBUM TAG;
    public static final DELETE_FROM_ALBUM UNIFIED;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$Selection, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        CLOUD = new <init>("CLOUD", 0);
        LOCAL = new <init>("LOCAL", 1);
        CLOUD_AND_LOCAL = new <init>("CLOUD_AND_LOCAL", 2);
        UNIFIED = new <init>("UNIFIED", 3);
        TAG = new <init>("TAG", 4);
        REMOVE_FROM_ALBUM = new <init>("REMOVE_FROM_ALBUM", 5);
        DELETE_FROM_ALBUM = new <init>("DELETE_FROM_ALBUM", 6);
        $VALUES = (new .VALUES[] {
            CLOUD, LOCAL, CLOUD_AND_LOCAL, UNIFIED, TAG, REMOVE_FROM_ALBUM, DELETE_FROM_ALBUM
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
