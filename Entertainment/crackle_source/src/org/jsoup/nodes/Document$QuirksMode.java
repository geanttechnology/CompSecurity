// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;


// Referenced classes of package org.jsoup.nodes:
//            Document

public static final class  extends Enum
{

    private static final limitedQuirks $VALUES[];
    public static final limitedQuirks limitedQuirks;
    public static final limitedQuirks noQuirks;
    public static final limitedQuirks quirks;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/jsoup/nodes/Document$QuirksMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        noQuirks = new <init>("noQuirks", 0);
        quirks = new <init>("quirks", 1);
        limitedQuirks = new <init>("limitedQuirks", 2);
        $VALUES = (new .VALUES[] {
            noQuirks, quirks, limitedQuirks
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
