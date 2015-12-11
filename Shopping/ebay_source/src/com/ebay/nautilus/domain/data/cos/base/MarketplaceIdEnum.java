// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class MarketplaceIdEnum extends Enum
{

    private static final MarketplaceIdEnum $VALUES[];
    public static final MarketplaceIdEnum EBAY_AT;
    public static final MarketplaceIdEnum EBAY_AU;
    public static final MarketplaceIdEnum EBAY_BE;
    public static final MarketplaceIdEnum EBAY_CA;
    public static final MarketplaceIdEnum EBAY_CH;
    public static final MarketplaceIdEnum EBAY_CN;
    public static final MarketplaceIdEnum EBAY_CZ;
    public static final MarketplaceIdEnum EBAY_DE;
    public static final MarketplaceIdEnum EBAY_DK;
    public static final MarketplaceIdEnum EBAY_ES;
    public static final MarketplaceIdEnum EBAY_FI;
    public static final MarketplaceIdEnum EBAY_FR;
    public static final MarketplaceIdEnum EBAY_GB;
    public static final MarketplaceIdEnum EBAY_GR;
    public static final MarketplaceIdEnum EBAY_HALF_US;
    public static final MarketplaceIdEnum EBAY_HK;
    public static final MarketplaceIdEnum EBAY_HU;
    public static final MarketplaceIdEnum EBAY_ID;
    public static final MarketplaceIdEnum EBAY_IE;
    public static final MarketplaceIdEnum EBAY_IL;
    public static final MarketplaceIdEnum EBAY_IN;
    public static final MarketplaceIdEnum EBAY_IT;
    public static final MarketplaceIdEnum EBAY_JP;
    public static final MarketplaceIdEnum EBAY_MOTORS_US;
    public static final MarketplaceIdEnum EBAY_MY;
    public static final MarketplaceIdEnum EBAY_NL;
    public static final MarketplaceIdEnum EBAY_NO;
    public static final MarketplaceIdEnum EBAY_NZ;
    public static final MarketplaceIdEnum EBAY_PE;
    public static final MarketplaceIdEnum EBAY_PH;
    public static final MarketplaceIdEnum EBAY_PL;
    public static final MarketplaceIdEnum EBAY_PR;
    public static final MarketplaceIdEnum EBAY_PT;
    public static final MarketplaceIdEnum EBAY_RU;
    public static final MarketplaceIdEnum EBAY_SE;
    public static final MarketplaceIdEnum EBAY_SG;
    public static final MarketplaceIdEnum EBAY_TH;
    public static final MarketplaceIdEnum EBAY_TW;
    public static final MarketplaceIdEnum EBAY_US;
    public static final MarketplaceIdEnum EBAY_VN;
    public static final MarketplaceIdEnum EBAY_ZA;
    public static final MarketplaceIdEnum UNKNOWN;

    private MarketplaceIdEnum(String s, int i)
    {
        super(s, i);
    }

    public static MarketplaceIdEnum valueOf(String s)
    {
        return (MarketplaceIdEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/MarketplaceIdEnum, s);
    }

    public static MarketplaceIdEnum[] values()
    {
        return (MarketplaceIdEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new MarketplaceIdEnum("UNKNOWN", 0);
        EBAY_US = new MarketplaceIdEnum("EBAY_US", 1);
        EBAY_CA = new MarketplaceIdEnum("EBAY_CA", 2);
        EBAY_GB = new MarketplaceIdEnum("EBAY_GB", 3);
        EBAY_AU = new MarketplaceIdEnum("EBAY_AU", 4);
        EBAY_AT = new MarketplaceIdEnum("EBAY_AT", 5);
        EBAY_BE = new MarketplaceIdEnum("EBAY_BE", 6);
        EBAY_DE = new MarketplaceIdEnum("EBAY_DE", 7);
        EBAY_FR = new MarketplaceIdEnum("EBAY_FR", 8);
        EBAY_IT = new MarketplaceIdEnum("EBAY_IT", 9);
        EBAY_NL = new MarketplaceIdEnum("EBAY_NL", 10);
        EBAY_ES = new MarketplaceIdEnum("EBAY_ES", 11);
        EBAY_CH = new MarketplaceIdEnum("EBAY_CH", 12);
        EBAY_TW = new MarketplaceIdEnum("EBAY_TW", 13);
        EBAY_CZ = new MarketplaceIdEnum("EBAY_CZ", 14);
        EBAY_DK = new MarketplaceIdEnum("EBAY_DK", 15);
        EBAY_FI = new MarketplaceIdEnum("EBAY_FI", 16);
        EBAY_GR = new MarketplaceIdEnum("EBAY_GR", 17);
        EBAY_HK = new MarketplaceIdEnum("EBAY_HK", 18);
        EBAY_HU = new MarketplaceIdEnum("EBAY_HU", 19);
        EBAY_IN = new MarketplaceIdEnum("EBAY_IN", 20);
        EBAY_ID = new MarketplaceIdEnum("EBAY_ID", 21);
        EBAY_IE = new MarketplaceIdEnum("EBAY_IE", 22);
        EBAY_IL = new MarketplaceIdEnum("EBAY_IL", 23);
        EBAY_MY = new MarketplaceIdEnum("EBAY_MY", 24);
        EBAY_NZ = new MarketplaceIdEnum("EBAY_NZ", 25);
        EBAY_NO = new MarketplaceIdEnum("EBAY_NO", 26);
        EBAY_PH = new MarketplaceIdEnum("EBAY_PH", 27);
        EBAY_PL = new MarketplaceIdEnum("EBAY_PL", 28);
        EBAY_PT = new MarketplaceIdEnum("EBAY_PT", 29);
        EBAY_PR = new MarketplaceIdEnum("EBAY_PR", 30);
        EBAY_RU = new MarketplaceIdEnum("EBAY_RU", 31);
        EBAY_SG = new MarketplaceIdEnum("EBAY_SG", 32);
        EBAY_ZA = new MarketplaceIdEnum("EBAY_ZA", 33);
        EBAY_SE = new MarketplaceIdEnum("EBAY_SE", 34);
        EBAY_TH = new MarketplaceIdEnum("EBAY_TH", 35);
        EBAY_VN = new MarketplaceIdEnum("EBAY_VN", 36);
        EBAY_CN = new MarketplaceIdEnum("EBAY_CN", 37);
        EBAY_JP = new MarketplaceIdEnum("EBAY_JP", 38);
        EBAY_PE = new MarketplaceIdEnum("EBAY_PE", 39);
        EBAY_HALF_US = new MarketplaceIdEnum("EBAY_HALF_US", 40);
        EBAY_MOTORS_US = new MarketplaceIdEnum("EBAY_MOTORS_US", 41);
        $VALUES = (new MarketplaceIdEnum[] {
            UNKNOWN, EBAY_US, EBAY_CA, EBAY_GB, EBAY_AU, EBAY_AT, EBAY_BE, EBAY_DE, EBAY_FR, EBAY_IT, 
            EBAY_NL, EBAY_ES, EBAY_CH, EBAY_TW, EBAY_CZ, EBAY_DK, EBAY_FI, EBAY_GR, EBAY_HK, EBAY_HU, 
            EBAY_IN, EBAY_ID, EBAY_IE, EBAY_IL, EBAY_MY, EBAY_NZ, EBAY_NO, EBAY_PH, EBAY_PL, EBAY_PT, 
            EBAY_PR, EBAY_RU, EBAY_SG, EBAY_ZA, EBAY_SE, EBAY_TH, EBAY_VN, EBAY_CN, EBAY_JP, EBAY_PE, 
            EBAY_HALF_US, EBAY_MOTORS_US
        });
    }
}
