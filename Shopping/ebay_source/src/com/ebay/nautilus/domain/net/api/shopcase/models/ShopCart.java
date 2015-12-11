// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;

import android.text.TextUtils;
import com.ebay.nautilus.domain.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class ShopCart
{
    public static final class Address
    {

        public String addressId;
        public List attributeContainers;
        public String city;
        public String country;
        public String county;
        public String name;
        public String phone;
        public String postalCode;
        public String stateOrProvince;
        public String street1;
        public String street2;

        public Address()
        {
        }
    }

    public static final class AddressIdentifier
    {

        public String type;
        public String value;

        public AddressIdentifier()
        {
        }
    }

    public static final class AddressInfo
    {

        public Address address;
        public Attribute cartAddressIdentifier;

        public AddressInfo()
        {
        }
    }

    public static class Adjustment
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount adjustmentAmount;
        public String adjustmentDescription;

        public Adjustment()
        {
        }
    }

    public static class Attribute
    {

        public String name;
        public String value;

        public Attribute()
        {
        }
    }

    public static final class AttributeContainer
    {

        public List attributes;
        public String name;

        public AttributeContainer()
        {
        }
    }

    public static abstract class BaseCartItem
    {

        public ItemDetails itemDetails;
        public String lastModifiedDate;
        public Integer requestedQuantity;
        public LogisticPlanOption selectedLogisticsPlanOption;
        public TransactionDetails transactionDetails;
        public ItemVariationDetails variationDetails;
        public String variationId;

        public BaseCartItem()
        {
        }
    }

    public static final class CartCounts
    {

        public int buyableCount;
        public int buyableLimit;
        public int transactionCount;
        public int unbuyableCount;

        public CartCounts()
        {
        }
    }

    public static final class CartItem extends BaseCartItem
    {

        public List attributeContainers;
        public List notifications;

        public CartItem()
        {
        }
    }

    public static class CartLineItem
    {

        public Date addedTime;
        public List attributeContainers;
        public List availableLogisticPlanOptions;
        public List availablePaymentMethods;
        public CartLineItemCharges chargesSummary;
        public PricingDetail itemPricingDetail;
        public String itemReferenceId;
        public List items;
        public LineItemTypes lineItemType;
        public OrderDetails orderDetails;
        public List problemStatus;
        public LogisticPlanOption selectedLogisticPlanOption;

        public CartLineItem()
        {
        }
    }

    public static final class CartLineItemCharges extends LineItemCostSummary
    {

        public CartLineItemCharges()
        {
        }
    }

    public static final class CartLineItemSellerGroup
    {

        public CostSummary costSummary;
        public PricingDetail groupPricingDetail;
        public List lineItems;
        public String paymentStatus;
        public List problemStatus;
        public Seller seller;
        public List unbuyableItems;

        public CartLineItemSellerGroup()
        {
        }
    }

    public static final class CartPurchaseStatusEnum extends Enum
    {

        private static final CartPurchaseStatusEnum $VALUES[];
        public static final CartPurchaseStatusEnum NOT_PURCHASED;
        public static final CartPurchaseStatusEnum PURCHASED;
        public static final CartPurchaseStatusEnum PURCHASE_FAILED;

        public static CartPurchaseStatusEnum valueOf(String s)
        {
            return (CartPurchaseStatusEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$CartPurchaseStatusEnum, s);
        }

        public static CartPurchaseStatusEnum[] values()
        {
            return (CartPurchaseStatusEnum[])$VALUES.clone();
        }

        static 
        {
            NOT_PURCHASED = new CartPurchaseStatusEnum("NOT_PURCHASED", 0);
            PURCHASED = new CartPurchaseStatusEnum("PURCHASED", 1);
            PURCHASE_FAILED = new CartPurchaseStatusEnum("PURCHASE_FAILED", 2);
            $VALUES = (new CartPurchaseStatusEnum[] {
                NOT_PURCHASED, PURCHASED, PURCHASE_FAILED
            });
        }

        private CartPurchaseStatusEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class CartQuantityDetails
    {

        public int cartUnits;

        public CartQuantityDetails()
        {
        }
    }

    public static class Cost
    {

        public List attributes;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount cost;
        public String type;

        public Cost()
        {
        }
    }

    public static final class CostSummary
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount feeTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount importCharges;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount insuranceTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount itemTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount logisticCharges;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount savingsAmount;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount taxTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount totalAdjustments;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount totalAmount;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount totalAppliedIncentives;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount totalAppliedPromotions;

        public CostSummary()
        {
        }
    }

    public static final class CurrencyCodeEnum extends Enum
    {

        private static final CurrencyCodeEnum $VALUES[];
        public static final CurrencyCodeEnum AED;
        public static final CurrencyCodeEnum AFN;
        public static final CurrencyCodeEnum ALL;
        public static final CurrencyCodeEnum AMD;
        public static final CurrencyCodeEnum ANG;
        public static final CurrencyCodeEnum AOA;
        public static final CurrencyCodeEnum ARS;
        public static final CurrencyCodeEnum AUD;
        public static final CurrencyCodeEnum AWG;
        public static final CurrencyCodeEnum AZN;
        public static final CurrencyCodeEnum BAM;
        public static final CurrencyCodeEnum BBD;
        public static final CurrencyCodeEnum BDT;
        public static final CurrencyCodeEnum BGN;
        public static final CurrencyCodeEnum BHD;
        public static final CurrencyCodeEnum BIF;
        public static final CurrencyCodeEnum BMD;
        public static final CurrencyCodeEnum BND;
        public static final CurrencyCodeEnum BOB;
        public static final CurrencyCodeEnum BRL;
        public static final CurrencyCodeEnum BSD;
        public static final CurrencyCodeEnum BTN;
        public static final CurrencyCodeEnum BWP;
        public static final CurrencyCodeEnum BYR;
        public static final CurrencyCodeEnum BZD;
        public static final CurrencyCodeEnum CAD;
        public static final CurrencyCodeEnum CDF;
        public static final CurrencyCodeEnum CHF;
        public static final CurrencyCodeEnum CLP;
        public static final CurrencyCodeEnum CNY;
        public static final CurrencyCodeEnum COP;
        public static final CurrencyCodeEnum CRC;
        public static final CurrencyCodeEnum CUP;
        public static final CurrencyCodeEnum CVE;
        public static final CurrencyCodeEnum CZK;
        public static final CurrencyCodeEnum DJF;
        public static final CurrencyCodeEnum DKK;
        public static final CurrencyCodeEnum DOP;
        public static final CurrencyCodeEnum DZD;
        public static final CurrencyCodeEnum EGP;
        public static final CurrencyCodeEnum ERN;
        public static final CurrencyCodeEnum ETB;
        public static final CurrencyCodeEnum EUR;
        public static final CurrencyCodeEnum FJD;
        public static final CurrencyCodeEnum FKP;
        public static final CurrencyCodeEnum GBP;
        public static final CurrencyCodeEnum GEL;
        public static final CurrencyCodeEnum GHS;
        public static final CurrencyCodeEnum GIP;
        public static final CurrencyCodeEnum GMD;
        public static final CurrencyCodeEnum GNF;
        public static final CurrencyCodeEnum GTQ;
        public static final CurrencyCodeEnum GYD;
        public static final CurrencyCodeEnum HKD;
        public static final CurrencyCodeEnum HNL;
        public static final CurrencyCodeEnum HRK;
        public static final CurrencyCodeEnum HTG;
        public static final CurrencyCodeEnum HUF;
        public static final CurrencyCodeEnum IDR;
        public static final CurrencyCodeEnum ILS;
        public static final CurrencyCodeEnum INR;
        public static final CurrencyCodeEnum IQD;
        public static final CurrencyCodeEnum IRR;
        public static final CurrencyCodeEnum ISK;
        public static final CurrencyCodeEnum JMD;
        public static final CurrencyCodeEnum JOD;
        public static final CurrencyCodeEnum JPY;
        public static final CurrencyCodeEnum KES;
        public static final CurrencyCodeEnum KGS;
        public static final CurrencyCodeEnum KHR;
        public static final CurrencyCodeEnum KMF;
        public static final CurrencyCodeEnum KPW;
        public static final CurrencyCodeEnum KRW;
        public static final CurrencyCodeEnum KWD;
        public static final CurrencyCodeEnum KYD;
        public static final CurrencyCodeEnum KZT;
        public static final CurrencyCodeEnum LAK;
        public static final CurrencyCodeEnum LBP;
        public static final CurrencyCodeEnum LKR;
        public static final CurrencyCodeEnum LRD;
        public static final CurrencyCodeEnum LSL;
        public static final CurrencyCodeEnum LTL;
        public static final CurrencyCodeEnum LYD;
        public static final CurrencyCodeEnum MAD;
        public static final CurrencyCodeEnum MDL;
        public static final CurrencyCodeEnum MGA;
        public static final CurrencyCodeEnum MKD;
        public static final CurrencyCodeEnum MMK;
        public static final CurrencyCodeEnum MNT;
        public static final CurrencyCodeEnum MOP;
        public static final CurrencyCodeEnum MRO;
        public static final CurrencyCodeEnum MUR;
        public static final CurrencyCodeEnum MVR;
        public static final CurrencyCodeEnum MWK;
        public static final CurrencyCodeEnum MXN;
        public static final CurrencyCodeEnum MYR;
        public static final CurrencyCodeEnum MZN;
        public static final CurrencyCodeEnum NAD;
        public static final CurrencyCodeEnum NGN;
        public static final CurrencyCodeEnum NIO;
        public static final CurrencyCodeEnum NOK;
        public static final CurrencyCodeEnum NPR;
        public static final CurrencyCodeEnum NZD;
        public static final CurrencyCodeEnum OMR;
        public static final CurrencyCodeEnum PAB;
        public static final CurrencyCodeEnum PEN;
        public static final CurrencyCodeEnum PGK;
        public static final CurrencyCodeEnum PHP;
        public static final CurrencyCodeEnum PKR;
        public static final CurrencyCodeEnum PLN;
        public static final CurrencyCodeEnum PYG;
        public static final CurrencyCodeEnum QAR;
        public static final CurrencyCodeEnum RON;
        public static final CurrencyCodeEnum RSD;
        public static final CurrencyCodeEnum RUB;
        public static final CurrencyCodeEnum RWF;
        public static final CurrencyCodeEnum SAR;
        public static final CurrencyCodeEnum SBD;
        public static final CurrencyCodeEnum SCR;
        public static final CurrencyCodeEnum SDG;
        public static final CurrencyCodeEnum SEK;
        public static final CurrencyCodeEnum SGD;
        public static final CurrencyCodeEnum SHP;
        public static final CurrencyCodeEnum SLL;
        public static final CurrencyCodeEnum SOS;
        public static final CurrencyCodeEnum SRD;
        public static final CurrencyCodeEnum STD;
        public static final CurrencyCodeEnum SYP;
        public static final CurrencyCodeEnum SZL;
        public static final CurrencyCodeEnum THB;
        public static final CurrencyCodeEnum TJS;
        public static final CurrencyCodeEnum TMT;
        public static final CurrencyCodeEnum TND;
        public static final CurrencyCodeEnum TOP;
        public static final CurrencyCodeEnum TRY;
        public static final CurrencyCodeEnum TTD;
        public static final CurrencyCodeEnum TWD;
        public static final CurrencyCodeEnum TZS;
        public static final CurrencyCodeEnum UAH;
        public static final CurrencyCodeEnum UGX;
        public static final CurrencyCodeEnum USD;
        public static final CurrencyCodeEnum UYU;
        public static final CurrencyCodeEnum UZS;
        public static final CurrencyCodeEnum VEF;
        public static final CurrencyCodeEnum VND;
        public static final CurrencyCodeEnum VUV;
        public static final CurrencyCodeEnum WST;
        public static final CurrencyCodeEnum XAF;
        public static final CurrencyCodeEnum XCD;
        public static final CurrencyCodeEnum XOF;
        public static final CurrencyCodeEnum XPF;
        public static final CurrencyCodeEnum YER;
        public static final CurrencyCodeEnum ZAR;
        public static final CurrencyCodeEnum ZMW;
        public static final CurrencyCodeEnum ZWL;

        public static CurrencyCodeEnum valueOf(String s)
        {
            return (CurrencyCodeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$CurrencyCodeEnum, s);
        }

        public static CurrencyCodeEnum[] values()
        {
            return (CurrencyCodeEnum[])$VALUES.clone();
        }

        static 
        {
            AED = new CurrencyCodeEnum("AED", 0);
            AFN = new CurrencyCodeEnum("AFN", 1);
            ALL = new CurrencyCodeEnum("ALL", 2);
            AMD = new CurrencyCodeEnum("AMD", 3);
            AOA = new CurrencyCodeEnum("AOA", 4);
            ARS = new CurrencyCodeEnum("ARS", 5);
            AWG = new CurrencyCodeEnum("AWG", 6);
            AZN = new CurrencyCodeEnum("AZN", 7);
            BAM = new CurrencyCodeEnum("BAM", 8);
            BBD = new CurrencyCodeEnum("BBD", 9);
            BDT = new CurrencyCodeEnum("BDT", 10);
            BGN = new CurrencyCodeEnum("BGN", 11);
            BHD = new CurrencyCodeEnum("BHD", 12);
            BIF = new CurrencyCodeEnum("BIF", 13);
            BMD = new CurrencyCodeEnum("BMD", 14);
            BND = new CurrencyCodeEnum("BND", 15);
            BOB = new CurrencyCodeEnum("BOB", 16);
            BRL = new CurrencyCodeEnum("BRL", 17);
            BSD = new CurrencyCodeEnum("BSD", 18);
            BTN = new CurrencyCodeEnum("BTN", 19);
            BWP = new CurrencyCodeEnum("BWP", 20);
            BYR = new CurrencyCodeEnum("BYR", 21);
            BZD = new CurrencyCodeEnum("BZD", 22);
            CAD = new CurrencyCodeEnum("CAD", 23);
            CDF = new CurrencyCodeEnum("CDF", 24);
            CLP = new CurrencyCodeEnum("CLP", 25);
            CNY = new CurrencyCodeEnum("CNY", 26);
            COP = new CurrencyCodeEnum("COP", 27);
            CRC = new CurrencyCodeEnum("CRC", 28);
            CUP = new CurrencyCodeEnum("CUP", 29);
            CVE = new CurrencyCodeEnum("CVE", 30);
            CZK = new CurrencyCodeEnum("CZK", 31);
            DJF = new CurrencyCodeEnum("DJF", 32);
            DOP = new CurrencyCodeEnum("DOP", 33);
            DZD = new CurrencyCodeEnum("DZD", 34);
            EGP = new CurrencyCodeEnum("EGP", 35);
            ERN = new CurrencyCodeEnum("ERN", 36);
            ETB = new CurrencyCodeEnum("ETB", 37);
            FJD = new CurrencyCodeEnum("FJD", 38);
            FKP = new CurrencyCodeEnum("FKP", 39);
            GEL = new CurrencyCodeEnum("GEL", 40);
            GHS = new CurrencyCodeEnum("GHS", 41);
            GIP = new CurrencyCodeEnum("GIP", 42);
            DKK = new CurrencyCodeEnum("DKK", 43);
            GMD = new CurrencyCodeEnum("GMD", 44);
            GNF = new CurrencyCodeEnum("GNF", 45);
            GTQ = new CurrencyCodeEnum("GTQ", 46);
            GYD = new CurrencyCodeEnum("GYD", 47);
            HKD = new CurrencyCodeEnum("HKD", 48);
            HNL = new CurrencyCodeEnum("HNL", 49);
            HRK = new CurrencyCodeEnum("HRK", 50);
            HTG = new CurrencyCodeEnum("HTG", 51);
            HUF = new CurrencyCodeEnum("HUF", 52);
            IDR = new CurrencyCodeEnum("IDR", 53);
            INR = new CurrencyCodeEnum("INR", 54);
            IQD = new CurrencyCodeEnum("IQD", 55);
            IRR = new CurrencyCodeEnum("IRR", 56);
            ISK = new CurrencyCodeEnum("ISK", 57);
            GBP = new CurrencyCodeEnum("GBP", 58);
            JMD = new CurrencyCodeEnum("JMD", 59);
            JOD = new CurrencyCodeEnum("JOD", 60);
            JPY = new CurrencyCodeEnum("JPY", 61);
            KES = new CurrencyCodeEnum("KES", 62);
            KGS = new CurrencyCodeEnum("KGS", 63);
            KHR = new CurrencyCodeEnum("KHR", 64);
            KMF = new CurrencyCodeEnum("KMF", 65);
            KPW = new CurrencyCodeEnum("KPW", 66);
            KRW = new CurrencyCodeEnum("KRW", 67);
            KWD = new CurrencyCodeEnum("KWD", 68);
            KYD = new CurrencyCodeEnum("KYD", 69);
            KZT = new CurrencyCodeEnum("KZT", 70);
            LAK = new CurrencyCodeEnum("LAK", 71);
            LBP = new CurrencyCodeEnum("LBP", 72);
            CHF = new CurrencyCodeEnum("CHF", 73);
            LKR = new CurrencyCodeEnum("LKR", 74);
            LRD = new CurrencyCodeEnum("LRD", 75);
            LSL = new CurrencyCodeEnum("LSL", 76);
            LTL = new CurrencyCodeEnum("LTL", 77);
            LYD = new CurrencyCodeEnum("LYD", 78);
            MAD = new CurrencyCodeEnum("MAD", 79);
            MDL = new CurrencyCodeEnum("MDL", 80);
            MGA = new CurrencyCodeEnum("MGA", 81);
            MKD = new CurrencyCodeEnum("MKD", 82);
            MMK = new CurrencyCodeEnum("MMK", 83);
            MNT = new CurrencyCodeEnum("MNT", 84);
            MOP = new CurrencyCodeEnum("MOP", 85);
            MRO = new CurrencyCodeEnum("MRO", 86);
            XCD = new CurrencyCodeEnum("XCD", 87);
            MUR = new CurrencyCodeEnum("MUR", 88);
            MVR = new CurrencyCodeEnum("MVR", 89);
            MWK = new CurrencyCodeEnum("MWK", 90);
            MXN = new CurrencyCodeEnum("MXN", 91);
            MYR = new CurrencyCodeEnum("MYR", 92);
            MZN = new CurrencyCodeEnum("MZN", 93);
            NAD = new CurrencyCodeEnum("NAD", 94);
            NGN = new CurrencyCodeEnum("NGN", 95);
            NIO = new CurrencyCodeEnum("NIO", 96);
            NPR = new CurrencyCodeEnum("NPR", 97);
            OMR = new CurrencyCodeEnum("OMR", 98);
            PAB = new CurrencyCodeEnum("PAB", 99);
            PEN = new CurrencyCodeEnum("PEN", 100);
            XPF = new CurrencyCodeEnum("XPF", 101);
            PGK = new CurrencyCodeEnum("PGK", 102);
            PHP = new CurrencyCodeEnum("PHP", 103);
            PKR = new CurrencyCodeEnum("PKR", 104);
            PLN = new CurrencyCodeEnum("PLN", 105);
            ILS = new CurrencyCodeEnum("ILS", 106);
            PYG = new CurrencyCodeEnum("PYG", 107);
            QAR = new CurrencyCodeEnum("QAR", 108);
            RON = new CurrencyCodeEnum("RON", 109);
            RSD = new CurrencyCodeEnum("RSD", 110);
            RUB = new CurrencyCodeEnum("RUB", 111);
            RWF = new CurrencyCodeEnum("RWF", 112);
            SAR = new CurrencyCodeEnum("SAR", 113);
            SBD = new CurrencyCodeEnum("SBD", 114);
            SCR = new CurrencyCodeEnum("SCR", 115);
            SDG = new CurrencyCodeEnum("SDG", 116);
            SEK = new CurrencyCodeEnum("SEK", 117);
            SGD = new CurrencyCodeEnum("SGD", 118);
            SHP = new CurrencyCodeEnum("SHP", 119);
            NOK = new CurrencyCodeEnum("NOK", 120);
            SLL = new CurrencyCodeEnum("SLL", 121);
            SOS = new CurrencyCodeEnum("SOS", 122);
            SRD = new CurrencyCodeEnum("SRD", 123);
            STD = new CurrencyCodeEnum("STD", 124);
            ANG = new CurrencyCodeEnum("ANG", 125);
            SYP = new CurrencyCodeEnum("SYP", 126);
            SZL = new CurrencyCodeEnum("SZL", 127);
            XAF = new CurrencyCodeEnum("XAF", 128);
            XOF = new CurrencyCodeEnum("XOF", 129);
            THB = new CurrencyCodeEnum("THB", 130);
            TJS = new CurrencyCodeEnum("TJS", 131);
            NZD = new CurrencyCodeEnum("NZD", 132);
            TMT = new CurrencyCodeEnum("TMT", 133);
            TND = new CurrencyCodeEnum("TND", 134);
            TOP = new CurrencyCodeEnum("TOP", 135);
            TRY = new CurrencyCodeEnum("TRY", 136);
            TTD = new CurrencyCodeEnum("TTD", 137);
            AUD = new CurrencyCodeEnum("AUD", 138);
            TWD = new CurrencyCodeEnum("TWD", 139);
            TZS = new CurrencyCodeEnum("TZS", 140);
            UAH = new CurrencyCodeEnum("UAH", 141);
            UGX = new CurrencyCodeEnum("UGX", 142);
            USD = new CurrencyCodeEnum("USD", 143);
            UYU = new CurrencyCodeEnum("UYU", 144);
            UZS = new CurrencyCodeEnum("UZS", 145);
            VEF = new CurrencyCodeEnum("VEF", 146);
            VND = new CurrencyCodeEnum("VND", 147);
            VUV = new CurrencyCodeEnum("VUV", 148);
            WST = new CurrencyCodeEnum("WST", 149);
            YER = new CurrencyCodeEnum("YER", 150);
            EUR = new CurrencyCodeEnum("EUR", 151);
            ZAR = new CurrencyCodeEnum("ZAR", 152);
            ZMW = new CurrencyCodeEnum("ZMW", 153);
            ZWL = new CurrencyCodeEnum("ZWL", 154);
            $VALUES = (new CurrencyCodeEnum[] {
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

        private CurrencyCodeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FormattedDateTime
    {

        public String formattedValue;
        public Date value;

        public FormattedDateTime()
        {
        }
    }

    public static final class GuestCartMergeInfo
    {

        public GuestCartMergeResult mergeResult;
        public GuestCartMergeSourceInfo mergeSource;

        public GuestCartMergeInfo()
        {
        }
    }

    public static final class GuestCartMergeResult
    {

        public String mergeFromCartToCartItemReferenceIds;

        public GuestCartMergeResult()
        {
        }
    }

    public static final class GuestCartMergeSourceInfo
    {

        public String mergeFromCartId;
        public ItemIdentificationDetails mergeFromCartToCartItemIds;

        public GuestCartMergeSourceInfo()
        {
        }
    }

    public static final class Incentive
    {

        public List incentiveAttributeContainer;
        public String incentiveCode;
        public String incentiveMessage;
        public String incentiveType;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount redeemedAmount;

        public Incentive()
        {
        }
    }

    public static class InsuranceCost
    {

        public InsuranceCostType type;

        public InsuranceCost()
        {
        }
    }

    public static final class InsuranceCostType extends Enum
    {

        private static final InsuranceCostType $VALUES[];
        public static final InsuranceCostType INCLUDED_IN_SHIPPING_HANDLING;
        public static final InsuranceCostType NOT_OFFERED;
        public static final InsuranceCostType NOT_OFFERED_ON_SITE;
        public static final InsuranceCostType OPTIONAL;
        public static final InsuranceCostType REQUIRED;

        public static InsuranceCostType valueOf(String s)
        {
            return (InsuranceCostType)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$InsuranceCostType, s);
        }

        public static InsuranceCostType[] values()
        {
            return (InsuranceCostType[])$VALUES.clone();
        }

        static 
        {
            OPTIONAL = new InsuranceCostType("OPTIONAL", 0);
            REQUIRED = new InsuranceCostType("REQUIRED", 1);
            NOT_OFFERED = new InsuranceCostType("NOT_OFFERED", 2);
            INCLUDED_IN_SHIPPING_HANDLING = new InsuranceCostType("INCLUDED_IN_SHIPPING_HANDLING", 3);
            NOT_OFFERED_ON_SITE = new InsuranceCostType("NOT_OFFERED_ON_SITE", 4);
            $VALUES = (new InsuranceCostType[] {
                OPTIONAL, REQUIRED, NOT_OFFERED, INCLUDED_IN_SHIPPING_HANDLING, NOT_OFFERED_ON_SITE
            });
        }

        private InsuranceCostType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ItemDetails
    {

        public List attributeContainers;
        public List availableLogisticPlanOptions;
        public List availablePaymentMethods;
        public Integer availableQuantity;
        public String condition;
        public String createdTime;
        public boolean ended;
        public String galleryUrl;
        public List imageUrls;
        public Boolean immediatePay;
        public List incentives;
        public Date itemEndTime;
        public Long itemId;
        public String itemPriceType;
        public Integer itemType;
        public String lastModifiedDate;
        public List orderTransactions;
        public Price price;
        public String sellerLoginName;
        public String title;
        public String viewItemUrl;

        public ItemDetails()
        {
        }
    }

    public static final class ItemIdentificationDetails
    {

        public String itemId;
        public String transactionId;
        public String variationId;

        public ItemIdentificationDetails()
        {
        }
    }

    public static final class ItemLocationAttribute
    {

        public String country;
        public String location;
        public String postalCode;

        public ItemLocationAttribute()
        {
        }
    }

    public static final class ItemVariationDetails
    {

        public VariationSpecifics variationSpecifics;

        public ItemVariationDetails()
        {
        }
    }

    public static class LineItemCostSummary
    {

        public List adjustmentsAmountLineItemChargesSummary;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount depositItemFullAmount;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount feeTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount importCharges;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount incentiveTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount insuranceTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount itemTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount logisticsCharges;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount promotionTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount quantitySubTotalPrice;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount taxTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount totalAmount;

        public LineItemCostSummary()
        {
        }
    }

    public static final class LineItemTypes extends Enum
    {

        private static final LineItemTypes $VALUES[];
        public static final LineItemTypes BUYABLE_LISTING_ITEM;
        public static final LineItemTypes SELLER_CREATED_ORDER;
        public static final LineItemTypes TRANSACTION_ITEM;
        public static final LineItemTypes UNKNOWN_LINE_ITEM_TYPE;

        public static LineItemTypes valueOf(String s)
        {
            return (LineItemTypes)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$LineItemTypes, s);
        }

        public static LineItemTypes[] values()
        {
            return (LineItemTypes[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN_LINE_ITEM_TYPE = new LineItemTypes("UNKNOWN_LINE_ITEM_TYPE", 0);
            BUYABLE_LISTING_ITEM = new LineItemTypes("BUYABLE_LISTING_ITEM", 1);
            SELLER_CREATED_ORDER = new LineItemTypes("SELLER_CREATED_ORDER", 2);
            TRANSACTION_ITEM = new LineItemTypes("TRANSACTION_ITEM", 3);
            $VALUES = (new LineItemTypes[] {
                UNKNOWN_LINE_ITEM_TYPE, BUYABLE_LISTING_ITEM, SELLER_CREATED_ORDER, TRANSACTION_ITEM
            });
        }

        private LineItemTypes(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class LogisticPlanOption
    {

        public AddressIdentifier addressId;
        public List attributes;
        public LogisticsDeliveryEstimate deliveryEstimate;
        public String logisticsOptionIdentifier;
        public String name;
        public String nameSuperscript;
        public String provider;
        public Boolean selected;
        public String serviceCategory;
        public String token;
        public LogisticsTotalCostWithSavings totalCostWithSavings;
        public String type;

        public LogisticPlanOption()
        {
        }
    }

    public static final class LogisticsAdditionalCharge
    {

        public List additionalCharges;

        public LogisticsAdditionalCharge()
        {
        }
    }

    public static final class LogisticsAdditionalChargeBreakDown
    {

        public Cost costBreakdownComponent;

        public LogisticsAdditionalChargeBreakDown()
        {
        }
    }

    public static final class LogisticsAdjustmentCharge
    {

        public LogisticsAdditionalCharge additionalCharges;
        public LogisticsDiscountCharge discounts;

        public LogisticsAdjustmentCharge()
        {
        }
    }

    public static final class LogisticsAttribute extends Attribute
    {

        public String currencyId;
        public String format;

        public LogisticsAttribute()
        {
        }
    }

    public static final class LogisticsChargeAttribute extends Attribute
    {

        public String currencyId;
        public String format;

        public LogisticsChargeAttribute()
        {
        }
    }

    public static final class LogisticsChargeType extends Cost
    {

        public LogisticsAdditionalChargeBreakDown costBreakdown;

        public LogisticsChargeType()
        {
        }
    }

    public static final class LogisticsDeliveryEstimate
    {

        public FormattedDateTime deliveryDateMax;
        public FormattedDateTime deliveryDateMin;
        public Integer deliveryDaysMax;
        public Integer deliveryDaysMin;
        public FormattedDateTime estimatedPickupTime;
        public Duration fulfillmentDuration;
        public FormattedDateTime fulfillmentTime;
        public Integer handlingTime;

        public LogisticsDeliveryEstimate()
        {
        }
    }

    public static final class LogisticsDiscountCharge
    {

        public List discounts;

        public LogisticsDiscountCharge()
        {
        }
    }

    public static class LogisticsTotalCostWithSavings
    {

        public LogisticsAdjustmentCharge adjustment;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount baseCost;
        public InsuranceCost insuranceCost;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount subTotal;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount totalCost;

        public LogisticsTotalCostWithSavings()
        {
        }
    }

    public static class Notification
    {

        public Map attributes;
        public String message;
        public Integer notificationId;
        public NotificationLevel notificationLevel;

        public Notification()
        {
        }
    }

    public static final class NotificationCode extends Enum
    {

        private static final NotificationCode $VALUES[];
        public static final NotificationCode AUCTION_ENDED_AS_BIN;
        public static final NotificationCode BLOCKED_ITEM_CATEGORY;
        public static final NotificationCode BML_SERVICE_ERROR;
        public static final NotificationCode BUYER_BLOCKED;
        public static final NotificationCode BUYER_BLOCKED_AUTHENTIFY_VERIFICATION;
        public static final NotificationCode BUYER_BLOCKED_CC_VERIFICATION;
        public static final NotificationCode BUYER_BLOCKED_DOES_NOT_SHIP_TO_LOCATION;
        public static final NotificationCode BUYER_BLOCKED_ITEM_COUNT_LIMIT_EXCEEDED;
        public static final NotificationCode BUYER_BLOCKED_LOW_FEEDBACK_SCORE;
        public static final NotificationCode BUYER_BLOCKED_LOW_UNPAID_ITEM_STRIKE;
        public static final NotificationCode BUYER_BLOCKED_NO_LINKED_PAYPAL_ACCOUNT;
        public static final NotificationCode BUYER_BLOCKED_SELLER_EXCLUDED_SHIP_TO_LOCATION;
        public static final NotificationCode BUYER_BLOCKED_SMS_VERIFICATION;
        public static final NotificationCode BUYER_BLOCKED_VERIFICATION_NO_REMEDY;
        public static final NotificationCode BUYER_BLOCKED_VERIFIED_USER;
        public static final NotificationCode BUYER_BLOCKED_ZERO_FEEDBACK_SCORE;
        public static final NotificationCode BUYER_INFO_INVALID;
        public static final NotificationCode BUYER_IS_SELLER;
        public static final NotificationCode BUYER_MARKED_PAID;
        public static final NotificationCode BUYER_MESSAGE;
        public static final NotificationCode BUYER_NOT_CART_BUYER;
        public static final NotificationCode BUYER_WARNING_DOES_NOT_SHIP_TO_POBOX;
        public static final NotificationCode BUYING_SERVICE_CANCELLABLE;
        public static final NotificationCode BUYING_SERVICE_LOCKABLE;
        public static final NotificationCode BUYING_SERVICE_PURCHASE_FAILED;
        public static final NotificationCode BUYING_SERVICE_RETRYABLE;
        public static final NotificationCode CART_API_VERSION_FAILED_TO_UPDATE;
        public static final NotificationCode CART_IS_NOT_ENABLED_ON_THIS_SITE;
        public static final NotificationCode CART_SERVICE_INTERNAL_EXCEPTION;
        public static final NotificationCode CASH_BACK_ITEMS_NOT_CARTABLE;
        public static final NotificationCode CHECKOUT_COMPLETED;
        public static final NotificationCode CHECKOUT_EXPIRED;
        public static final NotificationCode DATASOURCE_DOWN_ERROR;
        public static final NotificationCode DOMAIN_INTERNAL_ERROR;
        public static final NotificationCode DOUBLE_BINNING;
        public static final NotificationCode EMPTY_ORDER;
        public static final NotificationCode IDENTICAL;
        public static final NotificationCode INCENTIVE_NOT_APPLIED;
        public static final NotificationCode INCENTIVE_SERVICE_ERROR;
        public static final NotificationCode INVALID_BASE_IDENTIFIER;
        public static final NotificationCode INVALID_BUYER_STATE;
        public static final NotificationCode INVALID_CART_ITEM_REFERENCE_ID;
        public static final NotificationCode INVALID_CART_SERVICE_REQUEST;
        public static final NotificationCode INVALID_COUNTRY;
        public static final NotificationCode INVALID_DOMAIN;
        public static final NotificationCode INVALID_EXTENDED_IDENTIFIER;
        public static final NotificationCode INVALID_IDENTIFIER;
        public static final NotificationCode INVALID_INPUT;
        public static final NotificationCode INVALID_ITEMID;
        public static final NotificationCode INVALID_ITEM_PRICE;
        public static final NotificationCode INVALID_ITEM_REFERENCE_ID;
        public static final NotificationCode INVALID_ITEM_SELLER;
        public static final NotificationCode INVALID_ITEM_VERSION;
        public static final NotificationCode INVALID_ORDER_STATE;
        public static final NotificationCode INVALID_PAYMENT_METHOD;
        public static final NotificationCode INVALID_PICKUP_LOCATION;
        public static final NotificationCode INVALID_QUANTITY;
        public static final NotificationCode INVALID_SALE_TYPE;
        public static final NotificationCode INVALID_SFL_ITEM_REFERENCE_ID;
        public static final NotificationCode INVALID_SHIPPING;
        public static final NotificationCode INVALID_SHIPPING_ADDRESS;
        public static final NotificationCode INVALID_SHIPPING_TYPE;
        public static final NotificationCode INVALID_VARIATION_ID;
        public static final NotificationCode ITEM_ALREADY_EXIST;
        public static final NotificationCode ITEM_ALREADY_EXISTS_IN_CART;
        public static final NotificationCode ITEM_CANNOT_BE_ADDED_AS_COMMITTED;
        public static final NotificationCode ITEM_CANNOT_BE_ADDED_AS_UNCOMMITTED;
        public static final NotificationCode ITEM_COMPONENTS_MISSING;
        public static final NotificationCode ITEM_ERROR;
        public static final NotificationCode ITEM_LISTING_SITE_UNSUPPORED;
        public static final NotificationCode ITEM_NOT_AVAILABLE;
        public static final NotificationCode ITEM_NOT_AVAILABLE_FOR_PURCHASE;
        public static final NotificationCode ITEM_NOT_FOUND;
        public static final NotificationCode ITEM_REVISED;
        public static final NotificationCode ITEM_TYPE_NOT_SUPPORTED;
        public static final NotificationCode ITEM_VALIDATION_ERROR;
        public static final NotificationCode LOCAL_INVENTORY_SERVICE_ERROR;
        public static final NotificationCode LOGISTICS_SERVICE_ERROR;
        public static final NotificationCode LOGISTIC_UPDATE_FAILED;
        public static final NotificationCode NOT_BIN_ITEM;
        public static final NotificationCode NOT_RELISTED;
        public static final NotificationCode NOT_SELLER_CREATED_ORDER;
        public static final NotificationCode OFFER_AMOUNT_LIMIT_EXCEEDED;
        public static final NotificationCode ORDER_BUYER_MISMATCH;
        public static final NotificationCode ORDER_NOT_FOUND;
        public static final NotificationCode PAYMENT_SERVICE_ERROR;
        public static final NotificationCode POSTPAY_ERROR;
        public static final NotificationCode POSTPAY_WARNING;
        public static final NotificationCode PROMOTION_SERVICE_ERROR;
        public static final NotificationCode REAL_ESTATE_ITEMS_NOT_CARTABLE;
        public static final NotificationCode RELISTED;
        public static final NotificationCode RELISTED_ADDED;
        public static final NotificationCode RELISTED_AVAILABLE;
        public static final NotificationCode REQUEST_DATA_ERROR;
        public static final NotificationCode REWARDS_SERVICE_ERROR;
        public static final NotificationCode SALE_ENDED;
        public static final NotificationCode SCO_CANNOT_BE_REMOVED;
        public static final NotificationCode SELECTED_SHIPPING_UPDATED;
        public static final NotificationCode SELLER_CREATED_ORDER_NOT_UPDATABLE;
        public static final NotificationCode SELLER_NOT_PERMITTED_TO_BUY_HISITEM;
        public static final NotificationCode SELLER_STATE_INVALID;
        public static final NotificationCode SHIPPING_SERVICE_ERROR;
        public static final NotificationCode SHIPPING_SERVICE_NOT_SUPPORTED;
        public static final NotificationCode STATUS_FLAG_ERROR;
        public static final NotificationCode STORE_OWNER_ON_VACATION;
        public static final NotificationCode TAX_SERVICE_ERROR;
        public static final NotificationCode TRACKING_SERVICE_ERROR;
        public static final NotificationCode TRANSACTION_ARCHIVED_REMOVED_FROM_CART;
        public static final NotificationCode TRANSACTION_BUYER_MISMATCH;
        public static final NotificationCode TRANSACTION_CANCELLED;
        public static final NotificationCode TRANSACTION_CANNOT_BE_REMOVED;
        public static final NotificationCode TRANSACTION_IS_PART_OF_ORDER;
        public static final NotificationCode TRANSACTION_NOT_FOUND;
        public static final NotificationCode UNFORESEEN_DOMAIN_ERROR;
        public static final NotificationCode UNFORSEEN_EXCEPTION;
        public static final NotificationCode UNPROCESSED;
        public static final NotificationCode UNSUPPORTED_CATEGORY;
        public static final NotificationCode UNSUPPORTED_SALE_TYPE;
        public static final NotificationCode UPI_CASE_CLOSED;
        public static final NotificationCode USER_NOT_PREAPPROVED;
        public static final NotificationCode USER_NOT_VALID;
        public static final NotificationCode USER_SUSPENDED;
        public static final NotificationCode VARIATION_NOT_FOUND;

        public static NotificationCode valueOf(String s)
        {
            return (NotificationCode)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$NotificationCode, s);
        }

        public static NotificationCode[] values()
        {
            return (NotificationCode[])$VALUES.clone();
        }

        static 
        {
            TRANSACTION_NOT_FOUND = new NotificationCode("TRANSACTION_NOT_FOUND", 0);
            UPI_CASE_CLOSED = new NotificationCode("UPI_CASE_CLOSED", 1);
            CHECKOUT_EXPIRED = new NotificationCode("CHECKOUT_EXPIRED", 2);
            CHECKOUT_COMPLETED = new NotificationCode("CHECKOUT_COMPLETED", 3);
            TRANSACTION_BUYER_MISMATCH = new NotificationCode("TRANSACTION_BUYER_MISMATCH", 4);
            TRANSACTION_CANCELLED = new NotificationCode("TRANSACTION_CANCELLED", 5);
            TRANSACTION_IS_PART_OF_ORDER = new NotificationCode("TRANSACTION_IS_PART_OF_ORDER", 6);
            BUYER_MARKED_PAID = new NotificationCode("BUYER_MARKED_PAID", 7);
            TRANSACTION_ARCHIVED_REMOVED_FROM_CART = new NotificationCode("TRANSACTION_ARCHIVED_REMOVED_FROM_CART", 8);
            RELISTED = new NotificationCode("RELISTED", 9);
            NOT_RELISTED = new NotificationCode("NOT_RELISTED", 10);
            IDENTICAL = new NotificationCode("IDENTICAL", 11);
            RELISTED_AVAILABLE = new NotificationCode("RELISTED_AVAILABLE", 12);
            RELISTED_ADDED = new NotificationCode("RELISTED_ADDED", 13);
            VARIATION_NOT_FOUND = new NotificationCode("VARIATION_NOT_FOUND", 14);
            INVALID_QUANTITY = new NotificationCode("INVALID_QUANTITY", 15);
            UNSUPPORTED_CATEGORY = new NotificationCode("UNSUPPORTED_CATEGORY", 16);
            NOT_BIN_ITEM = new NotificationCode("NOT_BIN_ITEM", 17);
            SALE_ENDED = new NotificationCode("SALE_ENDED", 18);
            SHIPPING_SERVICE_NOT_SUPPORTED = new NotificationCode("SHIPPING_SERVICE_NOT_SUPPORTED", 19);
            ITEM_ERROR = new NotificationCode("ITEM_ERROR", 20);
            ITEM_REVISED = new NotificationCode("ITEM_REVISED", 21);
            BUYER_MESSAGE = new NotificationCode("BUYER_MESSAGE", 22);
            ITEM_NOT_AVAILABLE = new NotificationCode("ITEM_NOT_AVAILABLE", 23);
            OFFER_AMOUNT_LIMIT_EXCEEDED = new NotificationCode("OFFER_AMOUNT_LIMIT_EXCEEDED", 24);
            INVALID_ITEM_PRICE = new NotificationCode("INVALID_ITEM_PRICE", 25);
            INVALID_SHIPPING = new NotificationCode("INVALID_SHIPPING", 26);
            INVALID_COUNTRY = new NotificationCode("INVALID_COUNTRY", 27);
            SELLER_NOT_PERMITTED_TO_BUY_HISITEM = new NotificationCode("SELLER_NOT_PERMITTED_TO_BUY_HISITEM", 28);
            DOUBLE_BINNING = new NotificationCode("DOUBLE_BINNING", 29);
            UNSUPPORTED_SALE_TYPE = new NotificationCode("UNSUPPORTED_SALE_TYPE", 30);
            AUCTION_ENDED_AS_BIN = new NotificationCode("AUCTION_ENDED_AS_BIN", 31);
            ITEM_TYPE_NOT_SUPPORTED = new NotificationCode("ITEM_TYPE_NOT_SUPPORTED", 32);
            USER_NOT_VALID = new NotificationCode("USER_NOT_VALID", 33);
            UNPROCESSED = new NotificationCode("UNPROCESSED", 34);
            REQUEST_DATA_ERROR = new NotificationCode("REQUEST_DATA_ERROR", 35);
            DATASOURCE_DOWN_ERROR = new NotificationCode("DATASOURCE_DOWN_ERROR", 36);
            INVALID_VARIATION_ID = new NotificationCode("INVALID_VARIATION_ID", 37);
            SELECTED_SHIPPING_UPDATED = new NotificationCode("SELECTED_SHIPPING_UPDATED", 38);
            BUYER_BLOCKED_ZERO_FEEDBACK_SCORE = new NotificationCode("BUYER_BLOCKED_ZERO_FEEDBACK_SCORE", 39);
            BUYER_BLOCKED_LOW_FEEDBACK_SCORE = new NotificationCode("BUYER_BLOCKED_LOW_FEEDBACK_SCORE", 40);
            BUYER_BLOCKED_LOW_UNPAID_ITEM_STRIKE = new NotificationCode("BUYER_BLOCKED_LOW_UNPAID_ITEM_STRIKE", 41);
            BUYER_BLOCKED_DOES_NOT_SHIP_TO_LOCATION = new NotificationCode("BUYER_BLOCKED_DOES_NOT_SHIP_TO_LOCATION", 42);
            BUYER_BLOCKED_NO_LINKED_PAYPAL_ACCOUNT = new NotificationCode("BUYER_BLOCKED_NO_LINKED_PAYPAL_ACCOUNT", 43);
            BUYER_BLOCKED_CC_VERIFICATION = new NotificationCode("BUYER_BLOCKED_CC_VERIFICATION", 44);
            BUYER_BLOCKED_SMS_VERIFICATION = new NotificationCode("BUYER_BLOCKED_SMS_VERIFICATION", 45);
            BUYER_BLOCKED_AUTHENTIFY_VERIFICATION = new NotificationCode("BUYER_BLOCKED_AUTHENTIFY_VERIFICATION", 46);
            BUYER_BLOCKED_VERIFICATION_NO_REMEDY = new NotificationCode("BUYER_BLOCKED_VERIFICATION_NO_REMEDY", 47);
            BUYER_BLOCKED_VERIFIED_USER = new NotificationCode("BUYER_BLOCKED_VERIFIED_USER", 48);
            BUYER_BLOCKED_ITEM_COUNT_LIMIT_EXCEEDED = new NotificationCode("BUYER_BLOCKED_ITEM_COUNT_LIMIT_EXCEEDED", 49);
            BUYER_BLOCKED = new NotificationCode("BUYER_BLOCKED", 50);
            BUYER_WARNING_DOES_NOT_SHIP_TO_POBOX = new NotificationCode("BUYER_WARNING_DOES_NOT_SHIP_TO_POBOX", 51);
            USER_SUSPENDED = new NotificationCode("USER_SUSPENDED", 52);
            USER_NOT_PREAPPROVED = new NotificationCode("USER_NOT_PREAPPROVED", 53);
            TRANSACTION_CANNOT_BE_REMOVED = new NotificationCode("TRANSACTION_CANNOT_BE_REMOVED", 54);
            SCO_CANNOT_BE_REMOVED = new NotificationCode("SCO_CANNOT_BE_REMOVED", 55);
            ITEM_NOT_FOUND = new NotificationCode("ITEM_NOT_FOUND", 56);
            ITEM_ALREADY_EXISTS_IN_CART = new NotificationCode("ITEM_ALREADY_EXISTS_IN_CART", 57);
            INVALID_SHIPPING_ADDRESS = new NotificationCode("INVALID_SHIPPING_ADDRESS", 58);
            INVALID_ORDER_STATE = new NotificationCode("INVALID_ORDER_STATE", 59);
            NOT_SELLER_CREATED_ORDER = new NotificationCode("NOT_SELLER_CREATED_ORDER", 60);
            EMPTY_ORDER = new NotificationCode("EMPTY_ORDER", 61);
            ORDER_NOT_FOUND = new NotificationCode("ORDER_NOT_FOUND", 62);
            ORDER_BUYER_MISMATCH = new NotificationCode("ORDER_BUYER_MISMATCH", 63);
            INVALID_ITEM_REFERENCE_ID = new NotificationCode("INVALID_ITEM_REFERENCE_ID", 64);
            INVALID_INPUT = new NotificationCode("INVALID_INPUT", 65);
            LOGISTIC_UPDATE_FAILED = new NotificationCode("LOGISTIC_UPDATE_FAILED", 66);
            LOCAL_INVENTORY_SERVICE_ERROR = new NotificationCode("LOCAL_INVENTORY_SERVICE_ERROR", 67);
            INVALID_PICKUP_LOCATION = new NotificationCode("INVALID_PICKUP_LOCATION", 68);
            CART_SERVICE_INTERNAL_EXCEPTION = new NotificationCode("CART_SERVICE_INTERNAL_EXCEPTION", 69);
            CART_API_VERSION_FAILED_TO_UPDATE = new NotificationCode("CART_API_VERSION_FAILED_TO_UPDATE", 70);
            INVALID_SFL_ITEM_REFERENCE_ID = new NotificationCode("INVALID_SFL_ITEM_REFERENCE_ID", 71);
            INVALID_CART_ITEM_REFERENCE_ID = new NotificationCode("INVALID_CART_ITEM_REFERENCE_ID", 72);
            SELLER_STATE_INVALID = new NotificationCode("SELLER_STATE_INVALID", 73);
            BUYER_BLOCKED_SELLER_EXCLUDED_SHIP_TO_LOCATION = new NotificationCode("BUYER_BLOCKED_SELLER_EXCLUDED_SHIP_TO_LOCATION", 74);
            STORE_OWNER_ON_VACATION = new NotificationCode("STORE_OWNER_ON_VACATION", 75);
            INVALID_BUYER_STATE = new NotificationCode("INVALID_BUYER_STATE", 76);
            INVALID_CART_SERVICE_REQUEST = new NotificationCode("INVALID_CART_SERVICE_REQUEST", 77);
            INVALID_DOMAIN = new NotificationCode("INVALID_DOMAIN", 78);
            INVALID_IDENTIFIER = new NotificationCode("INVALID_IDENTIFIER", 79);
            INVALID_BASE_IDENTIFIER = new NotificationCode("INVALID_BASE_IDENTIFIER", 80);
            INVALID_EXTENDED_IDENTIFIER = new NotificationCode("INVALID_EXTENDED_IDENTIFIER", 81);
            ITEM_NOT_AVAILABLE_FOR_PURCHASE = new NotificationCode("ITEM_NOT_AVAILABLE_FOR_PURCHASE", 82);
            ITEM_CANNOT_BE_ADDED_AS_COMMITTED = new NotificationCode("ITEM_CANNOT_BE_ADDED_AS_COMMITTED", 83);
            ITEM_CANNOT_BE_ADDED_AS_UNCOMMITTED = new NotificationCode("ITEM_CANNOT_BE_ADDED_AS_UNCOMMITTED", 84);
            INVALID_ITEM_SELLER = new NotificationCode("INVALID_ITEM_SELLER", 85);
            BUYER_NOT_CART_BUYER = new NotificationCode("BUYER_NOT_CART_BUYER", 86);
            BUYER_IS_SELLER = new NotificationCode("BUYER_IS_SELLER", 87);
            BUYER_INFO_INVALID = new NotificationCode("BUYER_INFO_INVALID", 88);
            INCENTIVE_NOT_APPLIED = new NotificationCode("INCENTIVE_NOT_APPLIED", 89);
            ITEM_ALREADY_EXIST = new NotificationCode("ITEM_ALREADY_EXIST", 90);
            INVALID_ITEM_VERSION = new NotificationCode("INVALID_ITEM_VERSION", 91);
            ITEM_COMPONENTS_MISSING = new NotificationCode("ITEM_COMPONENTS_MISSING", 92);
            ITEM_VALIDATION_ERROR = new NotificationCode("ITEM_VALIDATION_ERROR", 93);
            DOMAIN_INTERNAL_ERROR = new NotificationCode("DOMAIN_INTERNAL_ERROR", 94);
            TAX_SERVICE_ERROR = new NotificationCode("TAX_SERVICE_ERROR", 95);
            PAYMENT_SERVICE_ERROR = new NotificationCode("PAYMENT_SERVICE_ERROR", 96);
            INCENTIVE_SERVICE_ERROR = new NotificationCode("INCENTIVE_SERVICE_ERROR", 97);
            STATUS_FLAG_ERROR = new NotificationCode("STATUS_FLAG_ERROR", 98);
            BUYING_SERVICE_PURCHASE_FAILED = new NotificationCode("BUYING_SERVICE_PURCHASE_FAILED", 99);
            BUYING_SERVICE_RETRYABLE = new NotificationCode("BUYING_SERVICE_RETRYABLE", 100);
            BUYING_SERVICE_LOCKABLE = new NotificationCode("BUYING_SERVICE_LOCKABLE", 101);
            BUYING_SERVICE_CANCELLABLE = new NotificationCode("BUYING_SERVICE_CANCELLABLE", 102);
            POSTPAY_ERROR = new NotificationCode("POSTPAY_ERROR", 103);
            POSTPAY_WARNING = new NotificationCode("POSTPAY_WARNING", 104);
            SHIPPING_SERVICE_ERROR = new NotificationCode("SHIPPING_SERVICE_ERROR", 105);
            UNFORSEEN_EXCEPTION = new NotificationCode("UNFORSEEN_EXCEPTION", 106);
            PROMOTION_SERVICE_ERROR = new NotificationCode("PROMOTION_SERVICE_ERROR", 107);
            REWARDS_SERVICE_ERROR = new NotificationCode("REWARDS_SERVICE_ERROR", 108);
            BML_SERVICE_ERROR = new NotificationCode("BML_SERVICE_ERROR", 109);
            TRACKING_SERVICE_ERROR = new NotificationCode("TRACKING_SERVICE_ERROR", 110);
            LOGISTICS_SERVICE_ERROR = new NotificationCode("LOGISTICS_SERVICE_ERROR", 111);
            INVALID_ITEMID = new NotificationCode("INVALID_ITEMID", 112);
            CASH_BACK_ITEMS_NOT_CARTABLE = new NotificationCode("CASH_BACK_ITEMS_NOT_CARTABLE", 113);
            REAL_ESTATE_ITEMS_NOT_CARTABLE = new NotificationCode("REAL_ESTATE_ITEMS_NOT_CARTABLE", 114);
            CART_IS_NOT_ENABLED_ON_THIS_SITE = new NotificationCode("CART_IS_NOT_ENABLED_ON_THIS_SITE", 115);
            ITEM_LISTING_SITE_UNSUPPORED = new NotificationCode("ITEM_LISTING_SITE_UNSUPPORED", 116);
            BLOCKED_ITEM_CATEGORY = new NotificationCode("BLOCKED_ITEM_CATEGORY", 117);
            INVALID_SHIPPING_TYPE = new NotificationCode("INVALID_SHIPPING_TYPE", 118);
            INVALID_PAYMENT_METHOD = new NotificationCode("INVALID_PAYMENT_METHOD", 119);
            INVALID_SALE_TYPE = new NotificationCode("INVALID_SALE_TYPE", 120);
            SELLER_CREATED_ORDER_NOT_UPDATABLE = new NotificationCode("SELLER_CREATED_ORDER_NOT_UPDATABLE", 121);
            UNFORESEEN_DOMAIN_ERROR = new NotificationCode("UNFORESEEN_DOMAIN_ERROR", 122);
            $VALUES = (new NotificationCode[] {
                TRANSACTION_NOT_FOUND, UPI_CASE_CLOSED, CHECKOUT_EXPIRED, CHECKOUT_COMPLETED, TRANSACTION_BUYER_MISMATCH, TRANSACTION_CANCELLED, TRANSACTION_IS_PART_OF_ORDER, BUYER_MARKED_PAID, TRANSACTION_ARCHIVED_REMOVED_FROM_CART, RELISTED, 
                NOT_RELISTED, IDENTICAL, RELISTED_AVAILABLE, RELISTED_ADDED, VARIATION_NOT_FOUND, INVALID_QUANTITY, UNSUPPORTED_CATEGORY, NOT_BIN_ITEM, SALE_ENDED, SHIPPING_SERVICE_NOT_SUPPORTED, 
                ITEM_ERROR, ITEM_REVISED, BUYER_MESSAGE, ITEM_NOT_AVAILABLE, OFFER_AMOUNT_LIMIT_EXCEEDED, INVALID_ITEM_PRICE, INVALID_SHIPPING, INVALID_COUNTRY, SELLER_NOT_PERMITTED_TO_BUY_HISITEM, DOUBLE_BINNING, 
                UNSUPPORTED_SALE_TYPE, AUCTION_ENDED_AS_BIN, ITEM_TYPE_NOT_SUPPORTED, USER_NOT_VALID, UNPROCESSED, REQUEST_DATA_ERROR, DATASOURCE_DOWN_ERROR, INVALID_VARIATION_ID, SELECTED_SHIPPING_UPDATED, BUYER_BLOCKED_ZERO_FEEDBACK_SCORE, 
                BUYER_BLOCKED_LOW_FEEDBACK_SCORE, BUYER_BLOCKED_LOW_UNPAID_ITEM_STRIKE, BUYER_BLOCKED_DOES_NOT_SHIP_TO_LOCATION, BUYER_BLOCKED_NO_LINKED_PAYPAL_ACCOUNT, BUYER_BLOCKED_CC_VERIFICATION, BUYER_BLOCKED_SMS_VERIFICATION, BUYER_BLOCKED_AUTHENTIFY_VERIFICATION, BUYER_BLOCKED_VERIFICATION_NO_REMEDY, BUYER_BLOCKED_VERIFIED_USER, BUYER_BLOCKED_ITEM_COUNT_LIMIT_EXCEEDED, 
                BUYER_BLOCKED, BUYER_WARNING_DOES_NOT_SHIP_TO_POBOX, USER_SUSPENDED, USER_NOT_PREAPPROVED, TRANSACTION_CANNOT_BE_REMOVED, SCO_CANNOT_BE_REMOVED, ITEM_NOT_FOUND, ITEM_ALREADY_EXISTS_IN_CART, INVALID_SHIPPING_ADDRESS, INVALID_ORDER_STATE, 
                NOT_SELLER_CREATED_ORDER, EMPTY_ORDER, ORDER_NOT_FOUND, ORDER_BUYER_MISMATCH, INVALID_ITEM_REFERENCE_ID, INVALID_INPUT, LOGISTIC_UPDATE_FAILED, LOCAL_INVENTORY_SERVICE_ERROR, INVALID_PICKUP_LOCATION, CART_SERVICE_INTERNAL_EXCEPTION, 
                CART_API_VERSION_FAILED_TO_UPDATE, INVALID_SFL_ITEM_REFERENCE_ID, INVALID_CART_ITEM_REFERENCE_ID, SELLER_STATE_INVALID, BUYER_BLOCKED_SELLER_EXCLUDED_SHIP_TO_LOCATION, STORE_OWNER_ON_VACATION, INVALID_BUYER_STATE, INVALID_CART_SERVICE_REQUEST, INVALID_DOMAIN, INVALID_IDENTIFIER, 
                INVALID_BASE_IDENTIFIER, INVALID_EXTENDED_IDENTIFIER, ITEM_NOT_AVAILABLE_FOR_PURCHASE, ITEM_CANNOT_BE_ADDED_AS_COMMITTED, ITEM_CANNOT_BE_ADDED_AS_UNCOMMITTED, INVALID_ITEM_SELLER, BUYER_NOT_CART_BUYER, BUYER_IS_SELLER, BUYER_INFO_INVALID, INCENTIVE_NOT_APPLIED, 
                ITEM_ALREADY_EXIST, INVALID_ITEM_VERSION, ITEM_COMPONENTS_MISSING, ITEM_VALIDATION_ERROR, DOMAIN_INTERNAL_ERROR, TAX_SERVICE_ERROR, PAYMENT_SERVICE_ERROR, INCENTIVE_SERVICE_ERROR, STATUS_FLAG_ERROR, BUYING_SERVICE_PURCHASE_FAILED, 
                BUYING_SERVICE_RETRYABLE, BUYING_SERVICE_LOCKABLE, BUYING_SERVICE_CANCELLABLE, POSTPAY_ERROR, POSTPAY_WARNING, SHIPPING_SERVICE_ERROR, UNFORSEEN_EXCEPTION, PROMOTION_SERVICE_ERROR, REWARDS_SERVICE_ERROR, BML_SERVICE_ERROR, 
                TRACKING_SERVICE_ERROR, LOGISTICS_SERVICE_ERROR, INVALID_ITEMID, CASH_BACK_ITEMS_NOT_CARTABLE, REAL_ESTATE_ITEMS_NOT_CARTABLE, CART_IS_NOT_ENABLED_ON_THIS_SITE, ITEM_LISTING_SITE_UNSUPPORED, BLOCKED_ITEM_CATEGORY, INVALID_SHIPPING_TYPE, INVALID_PAYMENT_METHOD, 
                INVALID_SALE_TYPE, SELLER_CREATED_ORDER_NOT_UPDATABLE, UNFORESEEN_DOMAIN_ERROR
            });
        }

        private NotificationCode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class NotificationLevel extends Enum
    {

        private static final NotificationLevel $VALUES[];
        public static final NotificationLevel ERROR;
        public static final NotificationLevel INFO;
        public static final NotificationLevel SUCCESS;
        public static final NotificationLevel WARNING;

        public static NotificationLevel valueOf(String s)
        {
            return (NotificationLevel)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$NotificationLevel, s);
        }

        public static NotificationLevel[] values()
        {
            return (NotificationLevel[])$VALUES.clone();
        }

        static 
        {
            SUCCESS = new NotificationLevel("SUCCESS", 0);
            INFO = new NotificationLevel("INFO", 1);
            WARNING = new NotificationLevel("WARNING", 2);
            ERROR = new NotificationLevel("ERROR", 3);
            $VALUES = (new NotificationLevel[] {
                SUCCESS, INFO, WARNING, ERROR
            });
        }

        private NotificationLevel(String s, int i)
        {
            super(s, i);
        }
    }

    public static class OrderDetails
    {

        public String orderCreationTime;
        public String orderId;
        public String transactionCreationTime;
        public String transactionId;
        public String transactionType;

        public OrderDetails()
        {
        }
    }

    public static final class PaymentMethod
    {

        public Boolean applicable;
        public String name;
        public String nonApplicableReason;

        public PaymentMethod()
        {
        }
    }

    public static final class Price
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount amount;
        public String type;

        public Price()
        {
        }
    }

    public static final class PriceLine
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount amount;
        public String desc;
        public String externalId;
        public PriceLineType type;

        public PriceLine()
        {
        }
    }

    public static final class PriceLineType extends Enum
    {

        private static final PriceLineType $VALUES[];
        public static final PriceLineType ADDITIONAL_AMOUNT;
        public static final PriceLineType BASE_COST;
        public static final PriceLineType COLLECTION_LINE_ITEM_TOTAL;
        public static final PriceLineType COLLECTION_TOTAL;
        public static final PriceLineType DECLARED_VALUE;
        public static final PriceLineType DISTRIBUTION_LINE_ITEM_TOTAL;
        public static final PriceLineType DISTRIBUTION_TOTAL;
        public static final PriceLineType DOMESTIC_LEG_COST;
        public static final PriceLineType FEE;
        public static final PriceLineType FUNDING_ADJUSTMENT;
        public static final PriceLineType HANDLING_COST;
        public static final PriceLineType IMPORT_CHARGES;
        public static final PriceLineType INCENTIVE;
        public static final PriceLineType INSURANCE;
        public static final PriceLineType INTERMEDIATED_SHIPPING_CHARGES;
        public static final PriceLineType INTERNATIONAL_LEG_COST;
        public static final PriceLineType ITEM_COST;
        public static final PriceLineType ITEM_TAX;
        public static final PriceLineType ORDER_ADJUSTMENT;
        public static final PriceLineType OTHER_CHARGES;
        public static final PriceLineType RESIDENTIAL_SURCHARGE;
        public static final PriceLineType RESTOCKING_FEE;
        public static final PriceLineType SHIPPING_COST;
        public static final PriceLineType SHIPPING_DISCOUNT;
        public static final PriceLineType SHIPPING_TAX;
        public static final PriceLineType SIGNATURE_SERVICE;
        public static final PriceLineType TOTAL;
        public static final PriceLineType UNKNOWN;

        public static PriceLineType valueOf(String s)
        {
            return (PriceLineType)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$PriceLineType, s);
        }

        public static PriceLineType[] values()
        {
            return (PriceLineType[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new PriceLineType("UNKNOWN", 0);
            ITEM_COST = new PriceLineType("ITEM_COST", 1);
            ITEM_TAX = new PriceLineType("ITEM_TAX", 2);
            SHIPPING_COST = new PriceLineType("SHIPPING_COST", 3);
            HANDLING_COST = new PriceLineType("HANDLING_COST", 4);
            INCENTIVE = new PriceLineType("INCENTIVE", 5);
            SHIPPING_TAX = new PriceLineType("SHIPPING_TAX", 6);
            SHIPPING_DISCOUNT = new PriceLineType("SHIPPING_DISCOUNT", 7);
            ORDER_ADJUSTMENT = new PriceLineType("ORDER_ADJUSTMENT", 8);
            INSURANCE = new PriceLineType("INSURANCE", 9);
            FEE = new PriceLineType("FEE", 10);
            FUNDING_ADJUSTMENT = new PriceLineType("FUNDING_ADJUSTMENT", 11);
            RESTOCKING_FEE = new PriceLineType("RESTOCKING_FEE", 12);
            ADDITIONAL_AMOUNT = new PriceLineType("ADDITIONAL_AMOUNT", 13);
            DOMESTIC_LEG_COST = new PriceLineType("DOMESTIC_LEG_COST", 14);
            INTERNATIONAL_LEG_COST = new PriceLineType("INTERNATIONAL_LEG_COST", 15);
            IMPORT_CHARGES = new PriceLineType("IMPORT_CHARGES", 16);
            INTERMEDIATED_SHIPPING_CHARGES = new PriceLineType("INTERMEDIATED_SHIPPING_CHARGES", 17);
            BASE_COST = new PriceLineType("BASE_COST", 18);
            SIGNATURE_SERVICE = new PriceLineType("SIGNATURE_SERVICE", 19);
            DECLARED_VALUE = new PriceLineType("DECLARED_VALUE", 20);
            RESIDENTIAL_SURCHARGE = new PriceLineType("RESIDENTIAL_SURCHARGE", 21);
            OTHER_CHARGES = new PriceLineType("OTHER_CHARGES", 22);
            TOTAL = new PriceLineType("TOTAL", 23);
            COLLECTION_TOTAL = new PriceLineType("COLLECTION_TOTAL", 24);
            DISTRIBUTION_TOTAL = new PriceLineType("DISTRIBUTION_TOTAL", 25);
            COLLECTION_LINE_ITEM_TOTAL = new PriceLineType("COLLECTION_LINE_ITEM_TOTAL", 26);
            DISTRIBUTION_LINE_ITEM_TOTAL = new PriceLineType("DISTRIBUTION_LINE_ITEM_TOTAL", 27);
            $VALUES = (new PriceLineType[] {
                UNKNOWN, ITEM_COST, ITEM_TAX, SHIPPING_COST, HANDLING_COST, INCENTIVE, SHIPPING_TAX, SHIPPING_DISCOUNT, ORDER_ADJUSTMENT, INSURANCE, 
                FEE, FUNDING_ADJUSTMENT, RESTOCKING_FEE, ADDITIONAL_AMOUNT, DOMESTIC_LEG_COST, INTERNATIONAL_LEG_COST, IMPORT_CHARGES, INTERMEDIATED_SHIPPING_CHARGES, BASE_COST, SIGNATURE_SERVICE, 
                DECLARED_VALUE, RESIDENTIAL_SURCHARGE, OTHER_CHARGES, TOTAL, COLLECTION_TOTAL, DISTRIBUTION_TOTAL, COLLECTION_LINE_ITEM_TOTAL, DISTRIBUTION_LINE_ITEM_TOTAL
            });
        }

        private PriceLineType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PricingDetail
    {

        public List feeDetails;
        public List incentives;
        public List logisticChargesDetails;
        public List promotions;
        public TaxDetail taxDetails;

        public PricingDetail()
        {
        }
    }

    public static class ProblemStatus
    {

        public String details;
        public String status;
        public String summary;
        public String systemId;

        public ProblemStatus()
        {
        }
    }

    public static final class Promotion
    {

        public List attributeContainers;
        public String promotionAppliedStatus;
        public String promotionCode;
        public String promotionMessage;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount promotionSavingsAmount;
        public String promotionType;

        public Promotion()
        {
        }
    }

    public static final class RelistItemInfo
    {

        public String itemId;
        public String lastWalkDate;
        public NotificationCode notificationCode;
        public Object recoveryParams;
        public String relistStatus;
        public String viewItemUrl;

        public RelistItemInfo()
        {
        }
    }

    public static final class SaleType extends Enum
    {

        private static final SaleType $VALUES[];
        public static final SaleType BID_AND_BIN;
        public static final SaleType BID_ONLY;
        public static final SaleType FIXED_PRICE;
        public static final SaleType UNKNOWN;

        public static SaleType from(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return UNKNOWN;
            }
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return UNKNOWN;
            }
            return s;
        }

        public static SaleType valueOf(String s)
        {
            return (SaleType)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$SaleType, s);
        }

        public static SaleType[] values()
        {
            return (SaleType[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new SaleType("UNKNOWN", 0);
            BID_AND_BIN = new SaleType("BID_AND_BIN", 1);
            BID_ONLY = new SaleType("BID_ONLY", 2);
            FIXED_PRICE = new SaleType("FIXED_PRICE", 3);
            $VALUES = (new SaleType[] {
                UNKNOWN, BID_AND_BIN, BID_ONLY, FIXED_PRICE
            });
        }

        private SaleType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class SaveForLaterItem extends CartLineItem
    {

        public String saveForLaterRecordKey;

        public SaveForLaterItem()
        {
        }
    }

    public static final class Seller extends User
    {

        public int sellerFeedBackScore;
        public boolean sellerOnVacation;
        public Date sellerVacationEndDate;
        public boolean topRatedSeller;

        public Seller()
        {
        }
    }

    public static final class Shopper extends User
    {

        public String cGuid;
        public Address guestUserAddressInfo;
        public String shopperGuid;

        public Shopper()
        {
        }
    }

    public static final class TaxDetail
    {

        public String percentage;
        public Boolean shippingIncludedInTax;
        public String state;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount taxAmount;
        public List taxPriceLineDetail;

        public TaxDetail()
        {
        }
    }

    public static class TransactionDetails
    {

        public String transactionCreationTime;
        public Long transactionId;
        public String transactionType;

        public TransactionDetails()
        {
        }
    }

    public static final class UnbuyableItem extends BaseCartItem
    {

        public String itemReferenceId;
        public List notifications;
        public RelistItemInfo relistItemInfo;

        public UnbuyableItem()
        {
        }
    }

    public static class User
    {

        public boolean isGuestUser;
        public String loginName;
        public List userAttributes;
        public Long userId;

        public User()
        {
        }
    }

    public static final class VariationSpecifics
    {

        public List nameValueList;

        public VariationSpecifics()
        {
        }
    }


    public List buyerAddresses;
    public CartCounts cartCounts;
    public Integer cartLineItemCount;
    public List cartLineItemSellerGroups;
    public List cartNotifications;
    public PricingDetail cartPricingDetail;
    public CartQuantityDetails cartQuantityDetails;
    public CostSummary costSummary;
    public String globalId;
    public GuestCartMergeInfo guestCartMergeInfo;
    public List saveForLaterItems;
    public Address selectedShippingAddress;
    public long shopCartId;
    public Shopper shopper;

    public ShopCart()
    {
    }
}
