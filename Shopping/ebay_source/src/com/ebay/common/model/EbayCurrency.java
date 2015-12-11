// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.text.TextUtils;

public final class EbayCurrency
{

    public static final EbayCurrency AED;
    public static final EbayCurrency AFN;
    public static final EbayCurrency ALL;
    public static final EbayCurrency AMD;
    public static final EbayCurrency AOA;
    public static final EbayCurrency ARS;
    public static final EbayCurrency AUD;
    public static final EbayCurrency AWG;
    public static final EbayCurrency AZN;
    public static final EbayCurrency BAM;
    public static final EbayCurrency BBD;
    public static final EbayCurrency BDT;
    public static final EbayCurrency BGN;
    public static final EbayCurrency BHD;
    public static final EbayCurrency BIF;
    public static final EbayCurrency BMD;
    public static final EbayCurrency BND;
    public static final EbayCurrency BOB;
    public static final EbayCurrency BRL;
    public static final EbayCurrency BSD;
    public static final EbayCurrency BTN;
    public static final EbayCurrency BWP;
    public static final EbayCurrency BZD;
    public static final EbayCurrency CAD = new EbayCurrency("CAD", "C $", "$", 2);
    public static final EbayCurrency CHF;
    public static final EbayCurrency CLP;
    public static final EbayCurrency CNY;
    public static final EbayCurrency COP;
    public static final EbayCurrency CRC;
    public static final EbayCurrency CVE;
    public static final EbayCurrency CZK;
    public static final EbayCurrency DJF;
    public static final EbayCurrency DKK;
    public static final EbayCurrency DOP;
    public static final EbayCurrency DZD;
    public static final EbayCurrency EGP;
    public static final EbayCurrency ERN;
    public static final EbayCurrency ETB;
    public static final EbayCurrency EUR;
    public static final EbayCurrency FJD;
    public static final EbayCurrency FKP;
    public static final EbayCurrency GBP;
    public static final EbayCurrency GEL;
    public static final EbayCurrency GHS;
    public static final EbayCurrency GIP;
    public static final EbayCurrency GMD;
    public static final EbayCurrency GNF;
    public static final EbayCurrency GTQ;
    public static final EbayCurrency GYD;
    public static final EbayCurrency HKD;
    public static final EbayCurrency HNL;
    public static final EbayCurrency HRK;
    public static final EbayCurrency HTG;
    public static final EbayCurrency HUF;
    public static final EbayCurrency IDR;
    public static final EbayCurrency ILS;
    public static final EbayCurrency INR;
    public static final EbayCurrency ISK;
    public static final EbayCurrency JMD;
    public static final EbayCurrency JOD;
    public static final EbayCurrency JPY;
    public static final EbayCurrency KES;
    public static final EbayCurrency KGS;
    public static final EbayCurrency KHR;
    public static final EbayCurrency KMF;
    public static final EbayCurrency KRW;
    public static final EbayCurrency KWD;
    public static final EbayCurrency KYD;
    public static final EbayCurrency KZT;
    public static final EbayCurrency LAK;
    public static final EbayCurrency LBP;
    public static final EbayCurrency LKR;
    public static final EbayCurrency LTL;
    public static final EbayCurrency LVL;
    public static final EbayCurrency MAD;
    public static final EbayCurrency MDL;
    public static final EbayCurrency MGA;
    public static final EbayCurrency MKD;
    public static final EbayCurrency MNT;
    public static final EbayCurrency MOP;
    public static final EbayCurrency MRO;
    public static final EbayCurrency MUR;
    public static final EbayCurrency MVR;
    public static final EbayCurrency MWK;
    public static final EbayCurrency MXN;
    public static final EbayCurrency MYR = new EbayCurrency("MYR", "RM");
    public static final EbayCurrency MZN;
    public static final EbayCurrency NAD;
    public static final EbayCurrency NGN;
    public static final EbayCurrency NIO;
    public static final EbayCurrency NOK;
    public static final EbayCurrency NPR;
    public static final EbayCurrency NZD;
    public static final EbayCurrency OMR;
    public static final EbayCurrency PAB;
    public static final EbayCurrency PEN;
    public static final EbayCurrency PGK;
    public static final EbayCurrency PHP = new EbayCurrency("PHP", "PHP ");
    public static final EbayCurrency PKR;
    public static final EbayCurrency PLN = new EbayCurrency("PLN", "z\u0142");
    public static final EbayCurrency PYG;
    public static final EbayCurrency QAR;
    public static final EbayCurrency RON;
    public static final EbayCurrency RSD;
    public static final EbayCurrency RUB;
    public static final EbayCurrency RWF;
    public static final EbayCurrency SAR;
    public static final EbayCurrency SBD;
    public static final EbayCurrency SCR;
    public static final EbayCurrency SEK;
    public static final EbayCurrency SGD = new EbayCurrency("SGD", "S $", "$", 2);
    public static final EbayCurrency SHP;
    public static final EbayCurrency SLL;
    public static final EbayCurrency SRD;
    public static final EbayCurrency SVC;
    public static final EbayCurrency SZL;
    public static final EbayCurrency THB;
    public static final EbayCurrency TJS;
    public static final EbayCurrency TMT;
    public static final EbayCurrency TND;
    public static final EbayCurrency TOP;
    public static final EbayCurrency TRY;
    public static final EbayCurrency TTD;
    public static final EbayCurrency TWD;
    public static final EbayCurrency TZS;
    public static final EbayCurrency UAH;
    public static final EbayCurrency UGX;
    public static final EbayCurrency USD;
    public static final EbayCurrency UYU;
    public static final EbayCurrency UZS;
    public static final EbayCurrency VEF;
    public static final EbayCurrency VND;
    public static final EbayCurrency VUV;
    public static final EbayCurrency WST;
    public static final EbayCurrency XAF;
    public static final EbayCurrency XCD;
    public static final EbayCurrency XOF;
    public static final EbayCurrency XPF;
    public static final EbayCurrency YER;
    public static final EbayCurrency ZAR;
    public static final EbayCurrency ZMW;
    private static final EbayCurrency currencies[];
    public final String code;
    public final int fractionalLength;
    public final String longSymbol;
    public final String shortSymbol;

    private EbayCurrency(String s)
    {
        this(s, s, s, 2);
    }

    private EbayCurrency(String s, String s1)
    {
        this(s, s1, s1, 2);
    }

    private EbayCurrency(String s, String s1, String s2, int i)
    {
        code = s;
        longSymbol = s1;
        shortSymbol = s2;
        fractionalLength = i;
    }

    public static EbayCurrency getCurrencyFromCode(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        EbayCurrency ebaycurrency = null;
_L4:
        return ebaycurrency;
_L2:
        EbayCurrency aebaycurrency[] = currencies;
        int j = aebaycurrency.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                EbayCurrency ebaycurrency1 = aebaycurrency[i];
                ebaycurrency = ebaycurrency1;
                if (s.equals(ebaycurrency1.code))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    public static String getLongSynbolFromCode(String s)
    {
        EbayCurrency ebaycurrency = getCurrencyFromCode(s);
        if (ebaycurrency != null)
        {
            s = ebaycurrency.longSymbol;
        }
        return s;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof EbayCurrency))
        {
            obj = (EbayCurrency)obj;
            return code.equals(((EbayCurrency) (obj)).code);
        } else
        {
            return super.equals(obj);
        }
    }

    public int hashCode()
    {
        return code.hashCode();
    }

    public String toString()
    {
        return code;
    }

    static 
    {
        AUD = new EbayCurrency("AUD", "AU $", "$", 2);
        EUR = new EbayCurrency("EUR", "\u20AC");
        INR = new EbayCurrency("INR", "Rs. ");
        CHF = new EbayCurrency("CHF", "CHF ");
        GBP = new EbayCurrency("GBP", "\243");
        USD = new EbayCurrency("USD", "US $", "$", 2);
        HKD = new EbayCurrency("HKD", "HK $", "$", 2);
        CNY = new EbayCurrency("CNY", "CN \245", "\245", 2);
        SEK = new EbayCurrency("SEK", "kr");
        TWD = new EbayCurrency("TWD", "NT $", "$", 2);
        AED = new EbayCurrency("AED");
        AFN = new EbayCurrency("AFN");
        ALL = new EbayCurrency("ALL");
        AMD = new EbayCurrency("AMD");
        AOA = new EbayCurrency("AOA");
        ARS = new EbayCurrency("ARS");
        AWG = new EbayCurrency("AWG");
        AZN = new EbayCurrency("AZN");
        BAM = new EbayCurrency("BAM");
        BBD = new EbayCurrency("BBD");
        BDT = new EbayCurrency("BDT");
        BGN = new EbayCurrency("BGN");
        BHD = new EbayCurrency("BHD");
        BIF = new EbayCurrency("BIF");
        BMD = new EbayCurrency("BMD");
        BND = new EbayCurrency("BND");
        BOB = new EbayCurrency("BOB");
        BRL = new EbayCurrency("BRL");
        BSD = new EbayCurrency("BSD");
        BTN = new EbayCurrency("BTN");
        BWP = new EbayCurrency("BWP");
        BZD = new EbayCurrency("BZD");
        CLP = new EbayCurrency("CLP");
        COP = new EbayCurrency("COP");
        CRC = new EbayCurrency("CRC");
        CVE = new EbayCurrency("CVE");
        CZK = new EbayCurrency("CZK");
        DJF = new EbayCurrency("DJF");
        DKK = new EbayCurrency("DKK");
        DOP = new EbayCurrency("DOP");
        DZD = new EbayCurrency("DZD");
        EGP = new EbayCurrency("EGP");
        ERN = new EbayCurrency("ERN");
        ETB = new EbayCurrency("ETB");
        FJD = new EbayCurrency("FJD");
        FKP = new EbayCurrency("FKP");
        GEL = new EbayCurrency("GEL");
        GHS = new EbayCurrency("GHS");
        GIP = new EbayCurrency("GIP");
        GMD = new EbayCurrency("GMD");
        GNF = new EbayCurrency("GNF");
        GTQ = new EbayCurrency("GTQ");
        GYD = new EbayCurrency("GYD");
        HNL = new EbayCurrency("HNL");
        HRK = new EbayCurrency("HRK");
        HTG = new EbayCurrency("HTG");
        HUF = new EbayCurrency("HUF");
        IDR = new EbayCurrency("IDR");
        ILS = new EbayCurrency("ILS");
        ISK = new EbayCurrency("ISK");
        JMD = new EbayCurrency("JMD");
        JOD = new EbayCurrency("JOD");
        JPY = new EbayCurrency("JPY", "JP \245", "\245", 0);
        KES = new EbayCurrency("KES");
        KGS = new EbayCurrency("KGS");
        KHR = new EbayCurrency("KHR");
        KMF = new EbayCurrency("KMF");
        KRW = new EbayCurrency("KRW");
        KWD = new EbayCurrency("KWD");
        KYD = new EbayCurrency("KYD");
        KZT = new EbayCurrency("KZT");
        LAK = new EbayCurrency("LAK");
        LBP = new EbayCurrency("LBP");
        LKR = new EbayCurrency("LKR");
        LTL = new EbayCurrency("LTL");
        LVL = new EbayCurrency("LVL");
        MAD = new EbayCurrency("MAD");
        MDL = new EbayCurrency("MDL");
        MGA = new EbayCurrency("MGA");
        MKD = new EbayCurrency("MKD");
        MNT = new EbayCurrency("MNT");
        MOP = new EbayCurrency("MOP");
        MRO = new EbayCurrency("MRO");
        MUR = new EbayCurrency("MUR");
        MVR = new EbayCurrency("MVR");
        MWK = new EbayCurrency("MWK");
        MXN = new EbayCurrency("MXN");
        MZN = new EbayCurrency("MZN");
        NAD = new EbayCurrency("NAD");
        NGN = new EbayCurrency("NGN");
        NIO = new EbayCurrency("NIO");
        NOK = new EbayCurrency("NOK");
        NPR = new EbayCurrency("NPR");
        NZD = new EbayCurrency("NZD");
        OMR = new EbayCurrency("OMR");
        PAB = new EbayCurrency("PAB");
        PEN = new EbayCurrency("PEN");
        PGK = new EbayCurrency("PGK");
        PKR = new EbayCurrency("PKR");
        PYG = new EbayCurrency("PYG");
        QAR = new EbayCurrency("QAR");
        RON = new EbayCurrency("RON");
        RSD = new EbayCurrency("RSD");
        RUB = new EbayCurrency("RUB");
        RWF = new EbayCurrency("RWF");
        SAR = new EbayCurrency("SAR");
        SBD = new EbayCurrency("SBD");
        SCR = new EbayCurrency("SCR");
        SHP = new EbayCurrency("SHP");
        SLL = new EbayCurrency("SLL");
        SRD = new EbayCurrency("SRD");
        SVC = new EbayCurrency("SVC");
        SZL = new EbayCurrency("SZL");
        THB = new EbayCurrency("THB");
        TJS = new EbayCurrency("TJS");
        TMT = new EbayCurrency("TMT");
        TND = new EbayCurrency("TND");
        TOP = new EbayCurrency("TOP");
        TRY = new EbayCurrency("TRY");
        TTD = new EbayCurrency("TTD");
        TZS = new EbayCurrency("TZS");
        UAH = new EbayCurrency("UAH");
        UGX = new EbayCurrency("UGX");
        UYU = new EbayCurrency("UYU");
        UZS = new EbayCurrency("UZS");
        VEF = new EbayCurrency("VEF");
        VND = new EbayCurrency("VND");
        VUV = new EbayCurrency("VUV");
        WST = new EbayCurrency("WST");
        XAF = new EbayCurrency("XAF");
        XCD = new EbayCurrency("XCD");
        XOF = new EbayCurrency("XOF");
        XPF = new EbayCurrency("XPF");
        YER = new EbayCurrency("YER");
        ZAR = new EbayCurrency("ZAR");
        ZMW = new EbayCurrency("ZMW");
        currencies = (new EbayCurrency[] {
            AED, AFN, ALL, AMD, AOA, ARS, AUD, AWG, AZN, BAM, 
            BBD, BDT, BGN, BHD, BIF, BMD, BND, BOB, BRL, BSD, 
            BTN, BWP, BZD, CHF, CLP, CNY, COP, CRC, CVE, CZK, 
            DJF, DKK, DOP, DZD, EGP, ERN, ETB, EUR, FJD, FKP, 
            GBP, GEL, GHS, GIP, GMD, GNF, GTQ, GYD, HKD, HNL, 
            HRK, HTG, HUF, IDR, ILS, INR, ISK, JMD, JOD, JPY, 
            KES, KGS, KHR, KMF, KRW, KWD, KYD, KZT, LAK, LBP, 
            LKR, LTL, LVL, MAD, MDL, MGA, MKD, MNT, MOP, MRO, 
            MUR, MVR, MWK, MXN, MZN, NAD, NGN, NIO, NOK, NPR, 
            NZD, OMR, PAB, PEN, PGK, PKR, PYG, QAR, RON, RSD, 
            RUB, RWF, SAR, SBD, SCR, SEK, SHP, SLL, SRD, SVC, 
            SZL, THB, TJS, TMT, TND, TOP, TRY, TTD, TWD, TZS, 
            UAH, UGX, USD, UYU, UZS, VEF, VND, VUV, WST, XAF, 
            XCD, XOF, XPF, YER, ZAR, ZMW
        });
    }
}
