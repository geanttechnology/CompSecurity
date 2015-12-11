// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;


// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase.models:
//            ShopCart

public static final class  extends Enum
{

    private static final ZWL $VALUES[];
    public static final ZWL AED;
    public static final ZWL AFN;
    public static final ZWL ALL;
    public static final ZWL AMD;
    public static final ZWL ANG;
    public static final ZWL AOA;
    public static final ZWL ARS;
    public static final ZWL AUD;
    public static final ZWL AWG;
    public static final ZWL AZN;
    public static final ZWL BAM;
    public static final ZWL BBD;
    public static final ZWL BDT;
    public static final ZWL BGN;
    public static final ZWL BHD;
    public static final ZWL BIF;
    public static final ZWL BMD;
    public static final ZWL BND;
    public static final ZWL BOB;
    public static final ZWL BRL;
    public static final ZWL BSD;
    public static final ZWL BTN;
    public static final ZWL BWP;
    public static final ZWL BYR;
    public static final ZWL BZD;
    public static final ZWL CAD;
    public static final ZWL CDF;
    public static final ZWL CHF;
    public static final ZWL CLP;
    public static final ZWL CNY;
    public static final ZWL COP;
    public static final ZWL CRC;
    public static final ZWL CUP;
    public static final ZWL CVE;
    public static final ZWL CZK;
    public static final ZWL DJF;
    public static final ZWL DKK;
    public static final ZWL DOP;
    public static final ZWL DZD;
    public static final ZWL EGP;
    public static final ZWL ERN;
    public static final ZWL ETB;
    public static final ZWL EUR;
    public static final ZWL FJD;
    public static final ZWL FKP;
    public static final ZWL GBP;
    public static final ZWL GEL;
    public static final ZWL GHS;
    public static final ZWL GIP;
    public static final ZWL GMD;
    public static final ZWL GNF;
    public static final ZWL GTQ;
    public static final ZWL GYD;
    public static final ZWL HKD;
    public static final ZWL HNL;
    public static final ZWL HRK;
    public static final ZWL HTG;
    public static final ZWL HUF;
    public static final ZWL IDR;
    public static final ZWL ILS;
    public static final ZWL INR;
    public static final ZWL IQD;
    public static final ZWL IRR;
    public static final ZWL ISK;
    public static final ZWL JMD;
    public static final ZWL JOD;
    public static final ZWL JPY;
    public static final ZWL KES;
    public static final ZWL KGS;
    public static final ZWL KHR;
    public static final ZWL KMF;
    public static final ZWL KPW;
    public static final ZWL KRW;
    public static final ZWL KWD;
    public static final ZWL KYD;
    public static final ZWL KZT;
    public static final ZWL LAK;
    public static final ZWL LBP;
    public static final ZWL LKR;
    public static final ZWL LRD;
    public static final ZWL LSL;
    public static final ZWL LTL;
    public static final ZWL LYD;
    public static final ZWL MAD;
    public static final ZWL MDL;
    public static final ZWL MGA;
    public static final ZWL MKD;
    public static final ZWL MMK;
    public static final ZWL MNT;
    public static final ZWL MOP;
    public static final ZWL MRO;
    public static final ZWL MUR;
    public static final ZWL MVR;
    public static final ZWL MWK;
    public static final ZWL MXN;
    public static final ZWL MYR;
    public static final ZWL MZN;
    public static final ZWL NAD;
    public static final ZWL NGN;
    public static final ZWL NIO;
    public static final ZWL NOK;
    public static final ZWL NPR;
    public static final ZWL NZD;
    public static final ZWL OMR;
    public static final ZWL PAB;
    public static final ZWL PEN;
    public static final ZWL PGK;
    public static final ZWL PHP;
    public static final ZWL PKR;
    public static final ZWL PLN;
    public static final ZWL PYG;
    public static final ZWL QAR;
    public static final ZWL RON;
    public static final ZWL RSD;
    public static final ZWL RUB;
    public static final ZWL RWF;
    public static final ZWL SAR;
    public static final ZWL SBD;
    public static final ZWL SCR;
    public static final ZWL SDG;
    public static final ZWL SEK;
    public static final ZWL SGD;
    public static final ZWL SHP;
    public static final ZWL SLL;
    public static final ZWL SOS;
    public static final ZWL SRD;
    public static final ZWL STD;
    public static final ZWL SYP;
    public static final ZWL SZL;
    public static final ZWL THB;
    public static final ZWL TJS;
    public static final ZWL TMT;
    public static final ZWL TND;
    public static final ZWL TOP;
    public static final ZWL TRY;
    public static final ZWL TTD;
    public static final ZWL TWD;
    public static final ZWL TZS;
    public static final ZWL UAH;
    public static final ZWL UGX;
    public static final ZWL USD;
    public static final ZWL UYU;
    public static final ZWL UZS;
    public static final ZWL VEF;
    public static final ZWL VND;
    public static final ZWL VUV;
    public static final ZWL WST;
    public static final ZWL XAF;
    public static final ZWL XCD;
    public static final ZWL XOF;
    public static final ZWL XPF;
    public static final ZWL YER;
    public static final ZWL ZAR;
    public static final ZWL ZMW;
    public static final ZWL ZWL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$CurrencyCodeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AED = new <init>("AED", 0);
        AFN = new <init>("AFN", 1);
        ALL = new <init>("ALL", 2);
        AMD = new <init>("AMD", 3);
        AOA = new <init>("AOA", 4);
        ARS = new <init>("ARS", 5);
        AWG = new <init>("AWG", 6);
        AZN = new <init>("AZN", 7);
        BAM = new <init>("BAM", 8);
        BBD = new <init>("BBD", 9);
        BDT = new <init>("BDT", 10);
        BGN = new <init>("BGN", 11);
        BHD = new <init>("BHD", 12);
        BIF = new <init>("BIF", 13);
        BMD = new <init>("BMD", 14);
        BND = new <init>("BND", 15);
        BOB = new <init>("BOB", 16);
        BRL = new <init>("BRL", 17);
        BSD = new <init>("BSD", 18);
        BTN = new <init>("BTN", 19);
        BWP = new <init>("BWP", 20);
        BYR = new <init>("BYR", 21);
        BZD = new <init>("BZD", 22);
        CAD = new <init>("CAD", 23);
        CDF = new <init>("CDF", 24);
        CLP = new <init>("CLP", 25);
        CNY = new <init>("CNY", 26);
        COP = new <init>("COP", 27);
        CRC = new <init>("CRC", 28);
        CUP = new <init>("CUP", 29);
        CVE = new <init>("CVE", 30);
        CZK = new <init>("CZK", 31);
        DJF = new <init>("DJF", 32);
        DOP = new <init>("DOP", 33);
        DZD = new <init>("DZD", 34);
        EGP = new <init>("EGP", 35);
        ERN = new <init>("ERN", 36);
        ETB = new <init>("ETB", 37);
        FJD = new <init>("FJD", 38);
        FKP = new <init>("FKP", 39);
        GEL = new <init>("GEL", 40);
        GHS = new <init>("GHS", 41);
        GIP = new <init>("GIP", 42);
        DKK = new <init>("DKK", 43);
        GMD = new <init>("GMD", 44);
        GNF = new <init>("GNF", 45);
        GTQ = new <init>("GTQ", 46);
        GYD = new <init>("GYD", 47);
        HKD = new <init>("HKD", 48);
        HNL = new <init>("HNL", 49);
        HRK = new <init>("HRK", 50);
        HTG = new <init>("HTG", 51);
        HUF = new <init>("HUF", 52);
        IDR = new <init>("IDR", 53);
        INR = new <init>("INR", 54);
        IQD = new <init>("IQD", 55);
        IRR = new <init>("IRR", 56);
        ISK = new <init>("ISK", 57);
        GBP = new <init>("GBP", 58);
        JMD = new <init>("JMD", 59);
        JOD = new <init>("JOD", 60);
        JPY = new <init>("JPY", 61);
        KES = new <init>("KES", 62);
        KGS = new <init>("KGS", 63);
        KHR = new <init>("KHR", 64);
        KMF = new <init>("KMF", 65);
        KPW = new <init>("KPW", 66);
        KRW = new <init>("KRW", 67);
        KWD = new <init>("KWD", 68);
        KYD = new <init>("KYD", 69);
        KZT = new <init>("KZT", 70);
        LAK = new <init>("LAK", 71);
        LBP = new <init>("LBP", 72);
        CHF = new <init>("CHF", 73);
        LKR = new <init>("LKR", 74);
        LRD = new <init>("LRD", 75);
        LSL = new <init>("LSL", 76);
        LTL = new <init>("LTL", 77);
        LYD = new <init>("LYD", 78);
        MAD = new <init>("MAD", 79);
        MDL = new <init>("MDL", 80);
        MGA = new <init>("MGA", 81);
        MKD = new <init>("MKD", 82);
        MMK = new <init>("MMK", 83);
        MNT = new <init>("MNT", 84);
        MOP = new <init>("MOP", 85);
        MRO = new <init>("MRO", 86);
        XCD = new <init>("XCD", 87);
        MUR = new <init>("MUR", 88);
        MVR = new <init>("MVR", 89);
        MWK = new <init>("MWK", 90);
        MXN = new <init>("MXN", 91);
        MYR = new <init>("MYR", 92);
        MZN = new <init>("MZN", 93);
        NAD = new <init>("NAD", 94);
        NGN = new <init>("NGN", 95);
        NIO = new <init>("NIO", 96);
        NPR = new <init>("NPR", 97);
        OMR = new <init>("OMR", 98);
        PAB = new <init>("PAB", 99);
        PEN = new <init>("PEN", 100);
        XPF = new <init>("XPF", 101);
        PGK = new <init>("PGK", 102);
        PHP = new <init>("PHP", 103);
        PKR = new <init>("PKR", 104);
        PLN = new <init>("PLN", 105);
        ILS = new <init>("ILS", 106);
        PYG = new <init>("PYG", 107);
        QAR = new <init>("QAR", 108);
        RON = new <init>("RON", 109);
        RSD = new <init>("RSD", 110);
        RUB = new <init>("RUB", 111);
        RWF = new <init>("RWF", 112);
        SAR = new <init>("SAR", 113);
        SBD = new <init>("SBD", 114);
        SCR = new <init>("SCR", 115);
        SDG = new <init>("SDG", 116);
        SEK = new <init>("SEK", 117);
        SGD = new <init>("SGD", 118);
        SHP = new <init>("SHP", 119);
        NOK = new <init>("NOK", 120);
        SLL = new <init>("SLL", 121);
        SOS = new <init>("SOS", 122);
        SRD = new <init>("SRD", 123);
        STD = new <init>("STD", 124);
        ANG = new <init>("ANG", 125);
        SYP = new <init>("SYP", 126);
        SZL = new <init>("SZL", 127);
        XAF = new <init>("XAF", 128);
        XOF = new <init>("XOF", 129);
        THB = new <init>("THB", 130);
        TJS = new <init>("TJS", 131);
        NZD = new <init>("NZD", 132);
        TMT = new <init>("TMT", 133);
        TND = new <init>("TND", 134);
        TOP = new <init>("TOP", 135);
        TRY = new <init>("TRY", 136);
        TTD = new <init>("TTD", 137);
        AUD = new <init>("AUD", 138);
        TWD = new <init>("TWD", 139);
        TZS = new <init>("TZS", 140);
        UAH = new <init>("UAH", 141);
        UGX = new <init>("UGX", 142);
        USD = new <init>("USD", 143);
        UYU = new <init>("UYU", 144);
        UZS = new <init>("UZS", 145);
        VEF = new <init>("VEF", 146);
        VND = new <init>("VND", 147);
        VUV = new <init>("VUV", 148);
        WST = new <init>("WST", 149);
        YER = new <init>("YER", 150);
        EUR = new <init>("EUR", 151);
        ZAR = new <init>("ZAR", 152);
        ZMW = new <init>("ZMW", 153);
        ZWL = new <init>("ZWL", 154);
        $VALUES = (new .VALUES[] {
            AED, AFN, ALL, AMD, AOA, ARS, AWG, AZN, BAM, BBD, 
            BDT, BGN, BHD, BIF, BMD, BND, BOB, BRL, BSD, BTN, 
            BWP, BYR, BZD, CAD, CDF, CLP, CNY, COP, CRC, CUP, 
            CVE, CZK, DJF, DOP, DZD, EGP, ERN, ETB, FJD, FKP, 
            GEL, GHS, GIP, DKK, GMD, GNF, GTQ, GYD, HKD, HNL, 
            HRK, HTG, HUF, IDR, INR, IQD, IRR, ISK, GBP, JMD, 
            JOD, JPY, KES, KGS, KHR, KMF, KPW, KRW, KWD, KYD, 
            KZT, LAK, LBP, CHF, LKR, LRD, LSL, LTL, LYD, MAD, 
            MDL, MGA, MKD, MMK, MNT, MOP, MRO, XCD, MUR, MVR, 
            MWK, MXN, MYR, MZN, NAD, NGN, NIO, NPR, OMR, PAB, 
            PEN, XPF, PGK, PHP, PKR, PLN, ILS, PYG, QAR, RON, 
            RSD, RUB, RWF, SAR, SBD, SCR, SDG, SEK, SGD, SHP, 
            NOK, SLL, SOS, SRD, STD, ANG, SYP, SZL, XAF, XOF, 
            THB, TJS, NZD, TMT, TND, TOP, TRY, TTD, AUD, TWD, 
            TZS, UAH, UGX, USD, UYU, UZS, VEF, VND, VUV, WST, 
            YER, EUR, ZAR, ZMW, ZWL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
