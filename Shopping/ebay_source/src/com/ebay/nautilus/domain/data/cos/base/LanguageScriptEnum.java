// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class LanguageScriptEnum extends Enum
{

    private static final LanguageScriptEnum $VALUES[];
    public static final LanguageScriptEnum ARABIC;
    public static final LanguageScriptEnum ARMENIAN;
    public static final LanguageScriptEnum CHINESE;
    public static final LanguageScriptEnum CYRILLIC;
    public static final LanguageScriptEnum GEORGIAN;
    public static final LanguageScriptEnum GREEK;
    public static final LanguageScriptEnum HEBREW;
    public static final LanguageScriptEnum INDIC;
    public static final LanguageScriptEnum JAPANESE;
    public static final LanguageScriptEnum KOREAN;
    public static final LanguageScriptEnum LATIN;
    public static final LanguageScriptEnum THAI;
    public static final LanguageScriptEnum UNKNOWN;

    private LanguageScriptEnum(String s, int i)
    {
        super(s, i);
    }

    public static LanguageScriptEnum valueOf(String s)
    {
        return (LanguageScriptEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/LanguageScriptEnum, s);
    }

    public static LanguageScriptEnum[] values()
    {
        return (LanguageScriptEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new LanguageScriptEnum("UNKNOWN", 0);
        LATIN = new LanguageScriptEnum("LATIN", 1);
        CYRILLIC = new LanguageScriptEnum("CYRILLIC", 2);
        ARABIC = new LanguageScriptEnum("ARABIC", 3);
        HEBREW = new LanguageScriptEnum("HEBREW", 4);
        GREEK = new LanguageScriptEnum("GREEK", 5);
        JAPANESE = new LanguageScriptEnum("JAPANESE", 6);
        CHINESE = new LanguageScriptEnum("CHINESE", 7);
        GEORGIAN = new LanguageScriptEnum("GEORGIAN", 8);
        ARMENIAN = new LanguageScriptEnum("ARMENIAN", 9);
        THAI = new LanguageScriptEnum("THAI", 10);
        KOREAN = new LanguageScriptEnum("KOREAN", 11);
        INDIC = new LanguageScriptEnum("INDIC", 12);
        $VALUES = (new LanguageScriptEnum[] {
            UNKNOWN, LATIN, CYRILLIC, ARABIC, HEBREW, GREEK, JAPANESE, CHINESE, GEORGIAN, ARMENIAN, 
            THAI, KOREAN, INDIC
        });
    }
}
