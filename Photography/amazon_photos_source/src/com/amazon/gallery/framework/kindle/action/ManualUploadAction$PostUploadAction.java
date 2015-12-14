// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;


// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

protected static final class  extends Enum
{

    private static final MANAGE_STORAGE $VALUES[];
    public static final MANAGE_STORAGE MANAGE_STORAGE;
    public static final MANAGE_STORAGE WIRELESS_SETTINGS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/action/ManualUploadAction$PostUploadAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        WIRELESS_SETTINGS = new <init>("WIRELESS_SETTINGS", 0);
        MANAGE_STORAGE = new <init>("MANAGE_STORAGE", 1);
        $VALUES = (new .VALUES[] {
            WIRELESS_SETTINGS, MANAGE_STORAGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
