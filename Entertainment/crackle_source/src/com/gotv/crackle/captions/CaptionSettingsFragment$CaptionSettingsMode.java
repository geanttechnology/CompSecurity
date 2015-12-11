// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;


// Referenced classes of package com.gotv.crackle.captions:
//            CaptionSettingsFragment

public static final class  extends Enum
{

    private static final CaptionEffects $VALUES[];
    public static final CaptionEffects CaptionEffects;
    public static final CaptionEffects CharacterBackground;
    public static final CaptionEffects FontStyle;
    public static final CaptionEffects Main;
    public static final CaptionEffects WindowSettings;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/gotv/crackle/captions/CaptionSettingsFragment$CaptionSettingsMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Main = new <init>("Main", 0);
        WindowSettings = new <init>("WindowSettings", 1);
        CharacterBackground = new <init>("CharacterBackground", 2);
        FontStyle = new <init>("FontStyle", 3);
        CaptionEffects = new <init>("CaptionEffects", 4);
        $VALUES = (new .VALUES[] {
            Main, WindowSettings, CharacterBackground, FontStyle, CaptionEffects
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
