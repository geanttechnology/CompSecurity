// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;


// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            Endpoint

public static final class Q extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN AUSTRALIA;
    public static final UNKNOWN CANADA;
    public static final UNKNOWN CHINA;
    public static final UNKNOWN EUROPE;
    public static final UNKNOWN FRANCE;
    public static final UNKNOWN GERMANY;
    public static final UNKNOWN INDIA;
    public static final UNKNOWN ITALY;
    public static final UNKNOWN JAPAN;
    public static final UNKNOWN SPAIN;
    public static final UNKNOWN UK;
    public static final UNKNOWN UNKNOWN;
    public static final UNKNOWN US;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/gallery/framework/network/http/rest/account/Endpoint$Marketplace, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        CHINA = new <init>("CHINA", 0);
        JAPAN = new <init>("JAPAN", 1);
        US = new <init>("US", 2);
        EUROPE = new <init>("EUROPE", 3);
        CANADA = new <init>("CANADA", 4);
        INDIA = new <init>("INDIA", 5);
        SPAIN = new <init>("SPAIN", 6);
        ITALY = new <init>("ITALY", 7);
        FRANCE = new <init>("FRANCE", 8);
        GERMANY = new <init>("GERMANY", 9);
        UK = new <init>("UK", 10);
        AUSTRALIA = new <init>("AUSTRALIA", 11);
        UNKNOWN = new <init>("UNKNOWN", 12);
        $VALUES = (new .VALUES[] {
            CHINA, JAPAN, US, EUROPE, CANADA, INDIA, SPAIN, ITALY, FRANCE, GERMANY, 
            UK, AUSTRALIA, UNKNOWN
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
