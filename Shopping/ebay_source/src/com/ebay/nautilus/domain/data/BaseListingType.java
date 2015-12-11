// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public abstract class BaseListingType extends BaseCommonType
{
    public static final class ListingFormatEnum extends Enum
    {

        private static final ListingFormatEnum $VALUES[];
        public static final ListingFormatEnum ADFORMAT;
        public static final ListingFormatEnum AUCTION;
        public static final ListingFormatEnum CLASSIFIED_AD;
        public static final ListingFormatEnum FIXED_PRICE;
        public static final ListingFormatEnum HALF;
        public static final ListingFormatEnum SECOND_CHANCE_OFFER;

        public static ListingFormatEnum valueOf(String s)
        {
            return (ListingFormatEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseListingType$ListingFormatEnum, s);
        }

        public static ListingFormatEnum[] values()
        {
            return (ListingFormatEnum[])$VALUES.clone();
        }

        static 
        {
            AUCTION = new ListingFormatEnum("AUCTION", 0);
            FIXED_PRICE = new ListingFormatEnum("FIXED_PRICE", 1);
            CLASSIFIED_AD = new ListingFormatEnum("CLASSIFIED_AD", 2);
            HALF = new ListingFormatEnum("HALF", 3);
            SECOND_CHANCE_OFFER = new ListingFormatEnum("SECOND_CHANCE_OFFER", 4);
            ADFORMAT = new ListingFormatEnum("ADFORMAT", 5);
            $VALUES = (new ListingFormatEnum[] {
                AUCTION, FIXED_PRICE, CLASSIFIED_AD, HALF, SECOND_CHANCE_OFFER, ADFORMAT
            });
        }

        private ListingFormatEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ListingStatusEnum extends Enum
    {

        private static final ListingStatusEnum $VALUES[];
        public static final ListingStatusEnum ACTIVE;
        public static final ListingStatusEnum ENDED;
        public static final ListingStatusEnum ENDED_BY_EBAY;
        public static final ListingStatusEnum ENDED_BY_SELLER;
        public static final ListingStatusEnum ON_HOLD;
        public static final ListingStatusEnum PENDING_CS_REVIEW;
        public static final ListingStatusEnum PENDING_REVIEW;
        public static final ListingStatusEnum SCHEDULED;
        public static final ListingStatusEnum SELLER_ON_VACATION;
        public static final ListingStatusEnum SOLD;

        public static ListingStatusEnum valueOf(String s)
        {
            return (ListingStatusEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseListingType$ListingStatusEnum, s);
        }

        public static ListingStatusEnum[] values()
        {
            return (ListingStatusEnum[])$VALUES.clone();
        }

        static 
        {
            SCHEDULED = new ListingStatusEnum("SCHEDULED", 0);
            ACTIVE = new ListingStatusEnum("ACTIVE", 1);
            ENDED = new ListingStatusEnum("ENDED", 2);
            PENDING_REVIEW = new ListingStatusEnum("PENDING_REVIEW", 3);
            ON_HOLD = new ListingStatusEnum("ON_HOLD", 4);
            ENDED_BY_SELLER = new ListingStatusEnum("ENDED_BY_SELLER", 5);
            ENDED_BY_EBAY = new ListingStatusEnum("ENDED_BY_EBAY", 6);
            SOLD = new ListingStatusEnum("SOLD", 7);
            SELLER_ON_VACATION = new ListingStatusEnum("SELLER_ON_VACATION", 8);
            PENDING_CS_REVIEW = new ListingStatusEnum("PENDING_CS_REVIEW", 9);
            $VALUES = (new ListingStatusEnum[] {
                SCHEDULED, ACTIVE, ENDED, PENDING_REVIEW, ON_HOLD, ENDED_BY_SELLER, ENDED_BY_EBAY, SOLD, SELLER_ON_VACATION, PENDING_CS_REVIEW
            });
        }

        private ListingStatusEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MarketplaceIdEnum extends Enum
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
        public static final MarketplaceIdEnum EBAY_MOTORS_AU;
        public static final MarketplaceIdEnum EBAY_MOTORS_CA;
        public static final MarketplaceIdEnum EBAY_MOTORS_DE;
        public static final MarketplaceIdEnum EBAY_MOTORS_UK;
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

        public static MarketplaceIdEnum valueOf(String s)
        {
            return (MarketplaceIdEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseListingType$MarketplaceIdEnum, s);
        }

        public static MarketplaceIdEnum[] values()
        {
            return (MarketplaceIdEnum[])$VALUES.clone();
        }

        static 
        {
            EBAY_US = new MarketplaceIdEnum("EBAY_US", 0);
            EBAY_CA = new MarketplaceIdEnum("EBAY_CA", 1);
            EBAY_GB = new MarketplaceIdEnum("EBAY_GB", 2);
            EBAY_AU = new MarketplaceIdEnum("EBAY_AU", 3);
            EBAY_AT = new MarketplaceIdEnum("EBAY_AT", 4);
            EBAY_BE = new MarketplaceIdEnum("EBAY_BE", 5);
            EBAY_DE = new MarketplaceIdEnum("EBAY_DE", 6);
            EBAY_FR = new MarketplaceIdEnum("EBAY_FR", 7);
            EBAY_IT = new MarketplaceIdEnum("EBAY_IT", 8);
            EBAY_NL = new MarketplaceIdEnum("EBAY_NL", 9);
            EBAY_ES = new MarketplaceIdEnum("EBAY_ES", 10);
            EBAY_CH = new MarketplaceIdEnum("EBAY_CH", 11);
            EBAY_TW = new MarketplaceIdEnum("EBAY_TW", 12);
            EBAY_CZ = new MarketplaceIdEnum("EBAY_CZ", 13);
            EBAY_DK = new MarketplaceIdEnum("EBAY_DK", 14);
            EBAY_FI = new MarketplaceIdEnum("EBAY_FI", 15);
            EBAY_GR = new MarketplaceIdEnum("EBAY_GR", 16);
            EBAY_HK = new MarketplaceIdEnum("EBAY_HK", 17);
            EBAY_HU = new MarketplaceIdEnum("EBAY_HU", 18);
            EBAY_IN = new MarketplaceIdEnum("EBAY_IN", 19);
            EBAY_ID = new MarketplaceIdEnum("EBAY_ID", 20);
            EBAY_IE = new MarketplaceIdEnum("EBAY_IE", 21);
            EBAY_IL = new MarketplaceIdEnum("EBAY_IL", 22);
            EBAY_MY = new MarketplaceIdEnum("EBAY_MY", 23);
            EBAY_NZ = new MarketplaceIdEnum("EBAY_NZ", 24);
            EBAY_NO = new MarketplaceIdEnum("EBAY_NO", 25);
            EBAY_PH = new MarketplaceIdEnum("EBAY_PH", 26);
            EBAY_PL = new MarketplaceIdEnum("EBAY_PL", 27);
            EBAY_PT = new MarketplaceIdEnum("EBAY_PT", 28);
            EBAY_PR = new MarketplaceIdEnum("EBAY_PR", 29);
            EBAY_RU = new MarketplaceIdEnum("EBAY_RU", 30);
            EBAY_SG = new MarketplaceIdEnum("EBAY_SG", 31);
            EBAY_ZA = new MarketplaceIdEnum("EBAY_ZA", 32);
            EBAY_SE = new MarketplaceIdEnum("EBAY_SE", 33);
            EBAY_TH = new MarketplaceIdEnum("EBAY_TH", 34);
            EBAY_VN = new MarketplaceIdEnum("EBAY_VN", 35);
            EBAY_CN = new MarketplaceIdEnum("EBAY_CN", 36);
            EBAY_JP = new MarketplaceIdEnum("EBAY_JP", 37);
            EBAY_PE = new MarketplaceIdEnum("EBAY_PE", 38);
            EBAY_HALF_US = new MarketplaceIdEnum("EBAY_HALF_US", 39);
            EBAY_MOTORS_US = new MarketplaceIdEnum("EBAY_MOTORS_US", 40);
            EBAY_MOTORS_CA = new MarketplaceIdEnum("EBAY_MOTORS_CA", 41);
            EBAY_MOTORS_DE = new MarketplaceIdEnum("EBAY_MOTORS_DE", 42);
            EBAY_MOTORS_UK = new MarketplaceIdEnum("EBAY_MOTORS_UK", 43);
            EBAY_MOTORS_AU = new MarketplaceIdEnum("EBAY_MOTORS_AU", 44);
            $VALUES = (new MarketplaceIdEnum[] {
                EBAY_US, EBAY_CA, EBAY_GB, EBAY_AU, EBAY_AT, EBAY_BE, EBAY_DE, EBAY_FR, EBAY_IT, EBAY_NL, 
                EBAY_ES, EBAY_CH, EBAY_TW, EBAY_CZ, EBAY_DK, EBAY_FI, EBAY_GR, EBAY_HK, EBAY_HU, EBAY_IN, 
                EBAY_ID, EBAY_IE, EBAY_IL, EBAY_MY, EBAY_NZ, EBAY_NO, EBAY_PH, EBAY_PL, EBAY_PT, EBAY_PR, 
                EBAY_RU, EBAY_SG, EBAY_ZA, EBAY_SE, EBAY_TH, EBAY_VN, EBAY_CN, EBAY_JP, EBAY_PE, EBAY_HALF_US, 
                EBAY_MOTORS_US, EBAY_MOTORS_CA, EBAY_MOTORS_DE, EBAY_MOTORS_UK, EBAY_MOTORS_AU
            });
        }

        private MarketplaceIdEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UserIdentifier
    {

        public String userId;
        public String username;
        public String usernameInLatin;

        public UserIdentifier(String s)
        {
            username = s;
        }
    }


    public BaseListingType()
    {
    }
}
