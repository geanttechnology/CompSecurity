// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.grammar;


// Referenced classes of package com.nuance.nmdp.speechkit.util.grammar:
//            Grammar

public static final class  extends Enum
{

    public static final INSTANT_ITEM_LIST CONTACTS;
    public static final INSTANT_ITEM_LIST CUSTOMWORDS;
    public static final INSTANT_ITEM_LIST HISTORY;
    public static final INSTANT_ITEM_LIST INSTANT_ITEM_LIST;
    public static final INSTANT_ITEM_LIST PREDEFINED_STATIC_GRAMMARS;
    public static final INSTANT_ITEM_LIST URI;
    private static final INSTANT_ITEM_LIST a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/nuance/nmdp/speechkit/util/grammar/Grammar$GrammarType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        CONTACTS = new <init>("CONTACTS", 0);
        CUSTOMWORDS = new <init>("CUSTOMWORDS", 1);
        HISTORY = new <init>("HISTORY", 2);
        URI = new <init>("URI", 3);
        PREDEFINED_STATIC_GRAMMARS = new <init>("PREDEFINED_STATIC_GRAMMARS", 4);
        INSTANT_ITEM_LIST = new <init>("INSTANT_ITEM_LIST", 5);
        a = (new a[] {
            CONTACTS, CUSTOMWORDS, HISTORY, URI, PREDEFINED_STATIC_GRAMMARS, INSTANT_ITEM_LIST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
