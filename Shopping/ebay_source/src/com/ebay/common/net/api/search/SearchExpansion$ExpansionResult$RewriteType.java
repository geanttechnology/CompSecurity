// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;


// Referenced classes of package com.ebay.common.net.api.search:
//            SearchExpansion

public static final class  extends Enum
{

    private static final FITMENT $VALUES[];
    public static final FITMENT CATEGORY_CONSTRAINT;
    public static final FITMENT FITMENT;
    public static final FITMENT KEYWORD_CONSTRAINT;
    public static final FITMENT QUERY_REWRITE;
    public static final FITMENT SITE_CONSTRAINT;
    public static final FITMENT SPELL_AUTO_CORRECT;
    public static final FITMENT SPELL_CHECK;
    public static final FITMENT VERSATILE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/search/SearchExpansion$ExpansionResult$RewriteType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SPELL_CHECK = new <init>("SPELL_CHECK", 0);
        KEYWORD_CONSTRAINT = new <init>("KEYWORD_CONSTRAINT", 1);
        CATEGORY_CONSTRAINT = new <init>("CATEGORY_CONSTRAINT", 2);
        SITE_CONSTRAINT = new <init>("SITE_CONSTRAINT", 3);
        SPELL_AUTO_CORRECT = new <init>("SPELL_AUTO_CORRECT", 4);
        QUERY_REWRITE = new <init>("QUERY_REWRITE", 5);
        VERSATILE = new <init>("VERSATILE", 6);
        FITMENT = new <init>("FITMENT", 7);
        $VALUES = (new .VALUES[] {
            SPELL_CHECK, KEYWORD_CONSTRAINT, CATEGORY_CONSTRAINT, SITE_CONSTRAINT, SPELL_AUTO_CORRECT, QUERY_REWRITE, VERSATILE, FITMENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
