// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class  extends Enum
{

    private static final INDIC $VALUES[];
    public static final INDIC ARABIC;
    public static final INDIC ARMENIAN;
    public static final INDIC CHINESE;
    public static final INDIC CYRILLIC;
    public static final INDIC GEORGIAN;
    public static final INDIC GREEK;
    public static final INDIC HEBREW;
    public static final INDIC INDIC;
    public static final INDIC JAPANESE;
    public static final INDIC KOREAN;
    public static final INDIC LATIN;
    public static final INDIC THAI;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$LanguageScriptEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LATIN = new <init>("LATIN", 0);
        CYRILLIC = new <init>("CYRILLIC", 1);
        ARABIC = new <init>("ARABIC", 2);
        HEBREW = new <init>("HEBREW", 3);
        GREEK = new <init>("GREEK", 4);
        JAPANESE = new <init>("JAPANESE", 5);
        CHINESE = new <init>("CHINESE", 6);
        GEORGIAN = new <init>("GEORGIAN", 7);
        ARMENIAN = new <init>("ARMENIAN", 8);
        THAI = new <init>("THAI", 9);
        KOREAN = new <init>("KOREAN", 10);
        INDIC = new <init>("INDIC", 11);
        $VALUES = (new .VALUES[] {
            LATIN, CYRILLIC, ARABIC, HEBREW, GREEK, JAPANESE, CHINESE, GEORGIAN, ARMENIAN, THAI, 
            KOREAN, INDIC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
