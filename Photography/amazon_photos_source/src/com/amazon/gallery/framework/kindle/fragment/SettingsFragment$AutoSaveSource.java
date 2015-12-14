// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;


// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

public static final class  extends Enum
{

    private static final OOBE $VALUES[];
    public static final OOBE Dialog;
    public static final OOBE OOBE;
    public static final OOBE Settings;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/fragment/SettingsFragment$AutoSaveSource, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Dialog = new <init>("Dialog", 0);
        Settings = new <init>("Settings", 1);
        OOBE = new <init>("OOBE", 2);
        $VALUES = (new .VALUES[] {
            Dialog, Settings, OOBE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
