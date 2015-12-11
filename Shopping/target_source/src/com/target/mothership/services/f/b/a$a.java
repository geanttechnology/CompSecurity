// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.b;


// Referenced classes of package com.target.mothership.services.f.b:
//            a

public static final class  extends Enum
{

    private static final GoogleAds $VALUES[];
    public static final GoogleAds AKQA;
    public static final GoogleAds Apigee;
    public static final GoogleAds ApigeePciSecure;
    public static final GoogleAds ApigeeSecure;
    public static final GoogleAds BAZAAR_VOICE;
    public static final GoogleAds Cartwheel;
    public static final GoogleAds Codebroker;
    public static final GoogleAds GoogleAds;
    public static final GoogleAds Lists;
    public static final GoogleAds Pluck;
    public static final GoogleAds PrzSecure;
    public static final GoogleAds Scene7;
    public static final GoogleAds ShopLocal;
    public static final GoogleAds TGTAppData;
    public static final GoogleAds TGTAppDataApi;
    public static final GoogleAds TGTAppDataSecure;
    public static final GoogleAds TGTFiles;
    public static final GoogleAds TWS;
    public static final GoogleAds Typeahead;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/services/f/b/a$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Apigee = new <init>("Apigee", 0);
        ApigeeSecure = new <init>("ApigeeSecure", 1);
        ApigeePciSecure = new <init>("ApigeePciSecure", 2);
        ShopLocal = new <init>("ShopLocal", 3);
        TGTFiles = new <init>("TGTFiles", 4);
        Scene7 = new <init>("Scene7", 5);
        AKQA = new <init>("AKQA", 6);
        Pluck = new <init>("Pluck", 7);
        Codebroker = new <init>("Codebroker", 8);
        TGTAppData = new <init>("TGTAppData", 9);
        TGTAppDataSecure = new <init>("TGTAppDataSecure", 10);
        TGTAppDataApi = new <init>("TGTAppDataApi", 11);
        Typeahead = new <init>("Typeahead", 12);
        Cartwheel = new <init>("Cartwheel", 13);
        Lists = new <init>("Lists", 14);
        PrzSecure = new <init>("PrzSecure", 15);
        TWS = new <init>("TWS", 16);
        BAZAAR_VOICE = new <init>("BAZAAR_VOICE", 17);
        GoogleAds = new <init>("GoogleAds", 18);
        $VALUES = (new .VALUES[] {
            Apigee, ApigeeSecure, ApigeePciSecure, ShopLocal, TGTFiles, Scene7, AKQA, Pluck, Codebroker, TGTAppData, 
            TGTAppDataSecure, TGTAppDataApi, Typeahead, Cartwheel, Lists, PrzSecure, TWS, BAZAAR_VOICE, GoogleAds
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
