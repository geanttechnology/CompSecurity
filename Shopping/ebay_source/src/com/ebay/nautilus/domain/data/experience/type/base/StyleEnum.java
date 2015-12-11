// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;


public final class StyleEnum extends Enum
{

    private static final StyleEnum $VALUES[];
    public static final StyleEnum BOLD;
    public static final StyleEnum DEFAULT;
    public static final StyleEnum EMPHASIS;
    public static final StyleEnum ITALIC;
    public static final StyleEnum NEGATIVE;
    public static final StyleEnum POSITIVE;
    public static final StyleEnum STRIKETHROUGH;
    public static final StyleEnum SUBSCRIPT;
    public static final StyleEnum SUPERSCRIPT;
    public static final StyleEnum UNKNOWN;

    private StyleEnum(String s, int i)
    {
        super(s, i);
    }

    public static StyleEnum valueOf(String s)
    {
        return (StyleEnum)Enum.valueOf(com/ebay/nautilus/domain/data/experience/type/base/StyleEnum, s);
    }

    public static StyleEnum[] values()
    {
        return (StyleEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new StyleEnum("UNKNOWN", 0);
        STRIKETHROUGH = new StyleEnum("STRIKETHROUGH", 1);
        EMPHASIS = new StyleEnum("EMPHASIS", 2);
        POSITIVE = new StyleEnum("POSITIVE", 3);
        NEGATIVE = new StyleEnum("NEGATIVE", 4);
        SUPERSCRIPT = new StyleEnum("SUPERSCRIPT", 5);
        SUBSCRIPT = new StyleEnum("SUBSCRIPT", 6);
        BOLD = new StyleEnum("BOLD", 7);
        ITALIC = new StyleEnum("ITALIC", 8);
        DEFAULT = new StyleEnum("DEFAULT", 9);
        $VALUES = (new StyleEnum[] {
            UNKNOWN, STRIKETHROUGH, EMPHASIS, POSITIVE, NEGATIVE, SUPERSCRIPT, SUBSCRIPT, BOLD, ITALIC, DEFAULT
        });
    }
}
