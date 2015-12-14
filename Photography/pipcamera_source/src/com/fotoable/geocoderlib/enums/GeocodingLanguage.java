// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.geocoderlib.enums;


public final class GeocodingLanguage extends Enum
{

    private static final GeocodingLanguage $VALUES[];
    public static final GeocodingLanguage AR;
    public static final GeocodingLanguage BG;
    public static final GeocodingLanguage BN;
    public static final GeocodingLanguage CA;
    public static final GeocodingLanguage CS;
    public static final GeocodingLanguage DA;
    public static final GeocodingLanguage DE;
    public static final GeocodingLanguage EL;
    public static final GeocodingLanguage EN;
    public static final GeocodingLanguage EN_AU;
    public static final GeocodingLanguage EN_GB;
    public static final GeocodingLanguage ES;
    public static final GeocodingLanguage EU;
    public static final GeocodingLanguage FA;
    public static final GeocodingLanguage FI;
    public static final GeocodingLanguage FIL;
    public static final GeocodingLanguage FR;
    public static final GeocodingLanguage GL;
    public static final GeocodingLanguage GU;
    public static final GeocodingLanguage HI;
    public static final GeocodingLanguage HR;
    public static final GeocodingLanguage HU;
    public static final GeocodingLanguage ID;
    public static final GeocodingLanguage IT;
    public static final GeocodingLanguage IW;
    public static final GeocodingLanguage JA;
    public static final GeocodingLanguage KN;
    public static final GeocodingLanguage KO;
    public static final GeocodingLanguage LT;
    public static final GeocodingLanguage LV;
    public static final GeocodingLanguage ML;
    public static final GeocodingLanguage MR;
    public static final GeocodingLanguage NL;
    public static final GeocodingLanguage NN;
    public static final GeocodingLanguage NO;
    public static final GeocodingLanguage OR;
    public static final GeocodingLanguage PL;
    public static final GeocodingLanguage PT;
    public static final GeocodingLanguage PT_BR;
    public static final GeocodingLanguage PT_PT;
    public static final GeocodingLanguage RM;
    public static final GeocodingLanguage RO;
    public static final GeocodingLanguage RU;
    public static final GeocodingLanguage SK;
    public static final GeocodingLanguage SL;
    public static final GeocodingLanguage SR;
    public static final GeocodingLanguage SV;
    public static final GeocodingLanguage TA;
    public static final GeocodingLanguage TE;
    public static final GeocodingLanguage TH;
    public static final GeocodingLanguage TL;
    public static final GeocodingLanguage TR;
    public static final GeocodingLanguage UK;
    public static final GeocodingLanguage VI;
    public static final GeocodingLanguage ZH_CN;
    public static final GeocodingLanguage ZH_TW;

    private GeocodingLanguage(String s, int i)
    {
        super(s, i);
    }

    public static GeocodingLanguage valueOf(String s)
    {
        return (GeocodingLanguage)Enum.valueOf(com/fotoable/geocoderlib/enums/GeocodingLanguage, s);
    }

    public static GeocodingLanguage[] values()
    {
        return (GeocodingLanguage[])$VALUES.clone();
    }

    static 
    {
        AR = new GeocodingLanguage("AR", 0);
        BG = new GeocodingLanguage("BG", 1);
        BN = new GeocodingLanguage("BN", 2);
        CA = new GeocodingLanguage("CA", 3);
        CS = new GeocodingLanguage("CS", 4);
        DA = new GeocodingLanguage("DA", 5);
        DE = new GeocodingLanguage("DE", 6);
        EL = new GeocodingLanguage("EL", 7);
        EN = new GeocodingLanguage("EN", 8);
        EN_AU = new GeocodingLanguage("EN_AU", 9);
        EN_GB = new GeocodingLanguage("EN_GB", 10);
        ES = new GeocodingLanguage("ES", 11);
        EU = new GeocodingLanguage("EU", 12);
        FA = new GeocodingLanguage("FA", 13);
        FI = new GeocodingLanguage("FI", 14);
        FIL = new GeocodingLanguage("FIL", 15);
        FR = new GeocodingLanguage("FR", 16);
        GL = new GeocodingLanguage("GL", 17);
        GU = new GeocodingLanguage("GU", 18);
        HI = new GeocodingLanguage("HI", 19);
        HR = new GeocodingLanguage("HR", 20);
        HU = new GeocodingLanguage("HU", 21);
        ID = new GeocodingLanguage("ID", 22);
        IT = new GeocodingLanguage("IT", 23);
        IW = new GeocodingLanguage("IW", 24);
        JA = new GeocodingLanguage("JA", 25);
        KN = new GeocodingLanguage("KN", 26);
        KO = new GeocodingLanguage("KO", 27);
        LT = new GeocodingLanguage("LT", 28);
        LV = new GeocodingLanguage("LV", 29);
        ML = new GeocodingLanguage("ML", 30);
        MR = new GeocodingLanguage("MR", 31);
        NL = new GeocodingLanguage("NL", 32);
        NN = new GeocodingLanguage("NN", 33);
        NO = new GeocodingLanguage("NO", 34);
        OR = new GeocodingLanguage("OR", 35);
        PL = new GeocodingLanguage("PL", 36);
        PT = new GeocodingLanguage("PT", 37);
        PT_BR = new GeocodingLanguage("PT_BR", 38);
        PT_PT = new GeocodingLanguage("PT_PT", 39);
        RM = new GeocodingLanguage("RM", 40);
        RO = new GeocodingLanguage("RO", 41);
        RU = new GeocodingLanguage("RU", 42);
        SK = new GeocodingLanguage("SK", 43);
        SL = new GeocodingLanguage("SL", 44);
        SR = new GeocodingLanguage("SR", 45);
        SV = new GeocodingLanguage("SV", 46);
        TL = new GeocodingLanguage("TL", 47);
        TA = new GeocodingLanguage("TA", 48);
        TE = new GeocodingLanguage("TE", 49);
        TH = new GeocodingLanguage("TH", 50);
        TR = new GeocodingLanguage("TR", 51);
        UK = new GeocodingLanguage("UK", 52);
        VI = new GeocodingLanguage("VI", 53);
        ZH_CN = new GeocodingLanguage("ZH_CN", 54);
        ZH_TW = new GeocodingLanguage("ZH_TW", 55);
        $VALUES = (new GeocodingLanguage[] {
            AR, BG, BN, CA, CS, DA, DE, EL, EN, EN_AU, 
            EN_GB, ES, EU, FA, FI, FIL, FR, GL, GU, HI, 
            HR, HU, ID, IT, IW, JA, KN, KO, LT, LV, 
            ML, MR, NL, NN, NO, OR, PL, PT, PT_BR, PT_PT, 
            RM, RO, RU, SK, SL, SR, SV, TL, TA, TE, 
            TH, TR, UK, VI, ZH_CN, ZH_TW
        });
    }
}
