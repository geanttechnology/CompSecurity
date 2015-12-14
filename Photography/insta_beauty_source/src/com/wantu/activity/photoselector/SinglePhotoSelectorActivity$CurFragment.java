// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;


public final class  extends Enum
{

    private static final files $VALUES[];
    public static final files files;
    public static final files folder;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/activity/photoselector/SinglePhotoSelectorActivity$CurFragment, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        folder = new <init>("folder", 0);
        files = new <init>("files", 1);
        $VALUES = (new .VALUES[] {
            folder, files
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
