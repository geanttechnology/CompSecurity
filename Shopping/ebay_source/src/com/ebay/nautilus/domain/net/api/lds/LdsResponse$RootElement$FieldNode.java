// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class isRecommendation extends com.ebay.nautilus.kernel.util.ldNode
{
    private final class FieldId extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final LdsResponse.RootElement.FieldNode this$2;

        public void text(String s)
            throws SAXException
        {
            byte byte0;
            field.id = s;
            if (s.startsWith("Listing.Item.Picture["))
            {
                draft.pictureUrls.add(field);
                return;
            }
            if (s.startsWith("Listing.PaymentInfo.AcceptedPaymentMethod"))
            {
                draft.paymentMethods.add(field);
                return;
            }
            if (!s.equals("Listing.Item.ItemSpecific") && s.startsWith("Listing.Item.ItemSpecific"))
            {
                draft.selectedItemSpecifics.add(field);
                return;
            }
            if (!s.equals("Listing.Item.ProductInfo.ProductSpecific") && s.startsWith("Listing.Item.ProductInfo.ProductSpecific"))
            {
                draft.productSpecifics.add(field);
                return;
            }
            if (!s.equals("Listing.Item.VariationItem") && s.startsWith("Listing.Item.VariationItem"))
            {
                draft.variationItems.add(field);
                return;
            }
            byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 105: default 1064
        //                       -2142798111: 1681
        //                       -2054689084: 2326
        //                       -1895994383: 1696
        //                       -1894437585: 2536
        //                       -1859025745: 2356
        //                       -1819650879: 2281
        //                       -1732918401: 2191
        //                       -1722374881: 1711
        //                       -1620015196: 3037
        //                       -1546729086: 2925
        //                       -1546728848: 2941
        //                       -1514854946: 2416
        //                       -1414978534: 3069
        //                       -1334767506: 1756
        //                       -1329987705: 1801
        //                       -1277407359: 2476
        //                       -1251971564: 2641
        //                       -1227359776: 2176
        //                       -1219480245: 1621
        //                       -1189439095: 1831
        //                       -1184759794: 2611
        //                       -1121724152: 2431
        //                       -1107890055: 2446
        //                       -947605760: 2206
        //                       -927877850: 1726
        //                       -855292374: 2717
        //                       -853244906: 1536
        //                       -829390680: 2071
        //                       -807383103: 2581
        //                       -742606908: 2765
        //                       -727012036: 1564
        //                       -721801151: 2161
        //                       -719917629: 2251
        //                       -701379387: 2341
        //                       -688842070: 2101
        //                       -648182689: 3085
        //                       -642377653: 2861
        //                       -613188024: 2401
        //                       -466341182: 2296
        //                       -321635276: 2026
        //                       -312365286: 1996
        //                       -253382681: 2551
        //                       -244772376: 2656
        //                       -216242526: 2146
        //                       -213488052: 2686
        //                       -179905446: 2957
        //                       -179905208: 2973
        //                       -110771714: 1666
        //                       42632695: 2521
        //                       52754348: 2877
        //                       90930945: 3021
        //                       104416198: 2893
        //                       108764073: 2506
        //                       147394657: 1891
        //                       152617814: 2491
        //                       163371579: 2845
        //                       289316099: 2131
        //                       354107398: 2461
        //                       356039691: 3101
        //                       458785774: 2989
        //                       479320575: 1936
        //                       559946049: 2221
        //                       571553691: 2371
        //                       596236533: 1741
        //                       602259847: 1522
        //                       615606861: 2829
        //                       652953282: 1876
        //                       738391709: 2797
        //                       747221638: 1786
        //                       787634180: 2266
        //                       833094972: 1951
        //                       886968515: 2311
        //                       887770248: 1816
        //                       933475537: 1606
        //                       1044068654: 1771
        //                       1059534383: 3053
        //                       1158511907: 1861
        //                       1184534529: 3005
        //                       1198337633: 1981
        //                       1201446375: 2701
        //                       1241040731: 2626
        //                       1247818663: 2056
        //                       1279863377: 1578
        //                       1385210354: 2733
        //                       1388367273: 2086
        //                       1424044777: 2781
        //                       1424356159: 2566
        //                       1528915883: 2116
        //                       1537056755: 2671
        //                       1608797125: 2596
        //                       1622574577: 1636
        //                       1664070532: 1846
        //                       1676295387: 2909
        //                       1722733619: 1921
        //                       1765731083: 2386
        //                       1765833431: 1550
        //                       1792590827: 1592
        //                       1828528848: 1651
        //                       1849129502: 2749
        //                       1975455385: 2813
        //                       1979196205: 2041
        //                       2027398200: 2011
        //                       2035689627: 1966
        //                       2067497858: 2236
        //                       2080663844: 1906;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88 _L89 _L90 _L91 _L92 _L93 _L94 _L95 _L96 _L97 _L98 _L99 _L100 _L101 _L102 _L103 _L104 _L105 _L106
_L1:
            break; /* Loop/switch isn't completed */
_L60:
            break MISSING_BLOCK_LABEL_3101;
_L107:
            switch (byte0)
            {
            default:
                return;

            case 0: // '\0'
                draft.title = field;
                return;

            case 1: // '\001'
                draft.subtitle = field;
                return;

            case 2: // '\002'
                draft.category = field;
                return;

            case 3: // '\003'
                draft.categoryNamePath = field;
                return;

            case 4: // '\004'
                draft.categoryIdPath = field;
                return;

            case 5: // '\005'
                draft.description = field;
                return;

            case 6: // '\006'
                draft.appendToDescription = field;
                return;

            case 7: // '\007'
                draft.conditionDescription = field;
                return;

            case 8: // '\b'
                draft.condition = field;
                return;

            case 9: // '\t'
                draft.conditionSetId = field;
                return;

            case 10: // '\n'
                draft.duration = field;
                return;

            case 11: // '\013'
                draft.format = field;
                return;

            case 12: // '\f'
                draft.startPrice = field;
                return;

            case 13: // '\r'
                draft.price = field;
                return;

            case 14: // '\016'
                draft.reservePrice = field;
                return;

            case 15: // '\017'
                draft.quantity = field;
                return;

            case 16: // '\020'
                draft.shippingType = field;
                return;

            case 17: // '\021'
                draft.shippingFree = field;
                return;

            case 18: // '\022'
                draft.shippingService1 = field;
                return;

            case 19: // '\023'
                draft.shippingService2 = field;
                return;

            case 20: // '\024'
                draft.shippingService3 = field;
                return;

            case 21: // '\025'
                draft.shippingService4 = field;
                return;

            case 22: // '\026'
                draft.shippingService1fee = field;
                return;

            case 23: // '\027'
                draft.shippingService2fee = field;
                return;

            case 24: // '\030'
                draft.shippingService3fee = field;
                return;

            case 25: // '\031'
                draft.shippingService4fee = field;
                return;

            case 26: // '\032'
                draft.packageType = field;
                return;

            case 27: // '\033'
                draft.packageLength = field;
                return;

            case 28: // '\034'
                draft.packageWidth = field;
                return;

            case 29: // '\035'
                draft.packageDepth = field;
                return;

            case 30: // '\036'
                draft.packageIrregular = field;
                return;

            case 31: // '\037'
                draft.packageUnitOfMeasure = field;
                return;

            case 32: // ' '
                draft.packageWeightEstimated = field;
                return;

            case 33: // '!'
                draft.packageWeightMajor = field;
                return;

            case 34: // '"'
                draft.packageWeightMinor = field;
                return;

            case 35: // '#'
                draft.intlShippingType = field;
                return;

            case 36: // '$'
                draft.intlShippingService1 = field;
                return;

            case 37: // '%'
                draft.intlShippingService2 = field;
                return;

            case 38: // '&'
                draft.intlShippingService3 = field;
                return;

            case 39: // '\''
                draft.intlShippingService4 = field;
                return;

            case 40: // '('
                draft.intlShippingService5 = field;
                return;

            case 41: // ')'
                draft.intlShippingFee1 = field;
                return;

            case 42: // '*'
                draft.intlShippingFee2 = field;
                return;

            case 43: // '+'
                draft.intlShippingFee3 = field;
                return;

            case 44: // ','
                draft.intlShippingFee4 = field;
                return;

            case 45: // '-'
                draft.intlShippingFee5 = field;
                return;

            case 46: // '.'
                draft.intlShipToRegion1 = field;
                return;

            case 47: // '/'
                draft.intlShipToRegion2 = field;
                return;

            case 48: // '0'
                draft.intlShipToRegion3 = field;
                return;

            case 49: // '1'
                draft.intlShipToRegion4 = field;
                return;

            case 50: // '2'
                draft.intlShipToRegion5 = field;
                return;

            case 51: // '3'
                draft.intlShipToLocation1 = field;
                return;

            case 52: // '4'
                draft.intlShipToLocation2 = field;
                return;

            case 53: // '5'
                draft.intlShipToLocation3 = field;
                return;

            case 54: // '6'
                draft.intlShipToLocation4 = field;
                return;

            case 55: // '7'
                draft.intlShipToLocation5 = field;
                return;

            case 56: // '8'
                draft.paypalEmailAddress = field;
                return;

            case 57: // '9'
                draft.immediatePay = field;
                return;

            case 58: // ':'
                draft.setCurrency(field);
                return;

            case 59: // ';'
                draft.productTitle = field;
                return;

            case 60: // '<'
                draft.productStockPhoto = field;
                return;

            case 61: // '='
                draft.productId = field;
                return;

            case 62: // '>'
                draft.productReferenceId = field;
                return;

            case 63: // '?'
                draft.startDate = field;
                return;

            case 64: // '@'
                draft.startDateEnabled = field;
                return;

            case 65: // 'A'
                draft.itemSpecifics = field;
                return;

            case 66: // 'B'
                draft.bestOfferEnabled = field;
                return;

            case 67: // 'C'
                draft.bestOfferAutoAccept = field;
                return;

            case 68: // 'D'
                draft.bestOfferAutoAcceptValue = field;
                return;

            case 69: // 'E'
                draft.bestOfferAutoDecline = field;
                return;

            case 70: // 'F'
                draft.bestOfferAutoDeclineValue = field;
                return;

            case 71: // 'G'
                draft.handlingTime = field;
                return;

            case 72: // 'H'
                draft.extendedHandlingDuration = field;
                return;

            case 73: // 'I'
                draft.refundPolicyDetails = field;
                return;

            case 74: // 'J'
                draft.refundMethod = field;
                return;

            case 75: // 'K'
                draft.refundShipmentPayee = field;
                return;

            case 76: // 'L'
                draft.refundReturnsAccepted = field;
                return;

            case 77: // 'M'
                draft.refundReturnPeriod = field;
                return;

            case 78: // 'N'
                draft.refundRestockingFee = field;
                return;

            case 79: // 'O'
                draft.locationCountry = field;
                return;

            case 80: // 'P'
                draft.locationCityState = field;
                return;

            case 81: // 'Q'
                draft.locationPostalCode = field;
                return;

            case 82: // 'R'
                draft.pictureMaxRemaining = field;
                return;

            case 83: // 'S'
                draft.pictureMaxFree = field;
                return;

            case 84: // 'T'
                draft.lastModified = field;
                return;

            case 85: // 'U'
                draft.appName = field;
                return;

            case 86: // 'V'
                draft.globalShipping = field;
                return;

            case 87: // 'W'
                draft.originalItemId = field;
                return;

            case 88: // 'X'
                draft.paypalEmailAddressKnown = field;
                return;

            case 89: // 'Y'
                draft.autoRelistEnabled = field;
                return;

            case 90: // 'Z'
                draft.autoRelistFeeSetting = field;
                return;

            case 91: // '['
                draft.autoRelistCount = field;
                return;

            case 92: // '\\'
                draft.autoRelistMaxRelist = field;
                return;

            case 93: // ']'
                draft.similarListingPriceMax = field;
                return;

            case 94: // '^'
                draft.similarListingPriceMin = field;
                return;

            case 95: // '_'
                draft.similarListingStartPriceMax = field;
                return;

            case 96: // '`'
                draft.similarListingStartPriceMin = field;
                return;

            case 97: // 'a'
                draft.feeOnTotalCost = field;
                return;

            case 98: // 'b'
                draft.charityDonationPercent = field;
                return;

            case 99: // 'c'
                draft.charityId = field;
                return;

            case 100: // 'd'
                draft.localPickup = field;
                return;

            case 101: // 'e'
                draft.guaranteeStartPrice = field;
                return;

            case 102: // 'f'
                draft.guaranteeSalePrice = field;
                return;

            case 103: // 'g'
                draft.guaranteeTerms = field;
                return;

            case 104: // 'h'
                draft.guaranteeProvided = field;
                break;
            }
            break MISSING_BLOCK_LABEL_5300;
_L66:
            if (s.equals("Listing.Item.Title"))
            {
                byte0 = 0;
            }
              goto _L107
_L28:
            if (s.equals("Listing.EnhancementInfo.SubTitle"))
            {
                byte0 = 1;
            }
              goto _L107
_L97:
            if (s.equals("Listing.CategoryInfo[0].Id"))
            {
                byte0 = 2;
            }
              goto _L107
_L32:
            if (s.equals("Metadata.CategoryInfo[0].Name"))
            {
                byte0 = 3;
            }
              goto _L107
_L84:
            if (s.equals("Metadata.CategoryInfo[0].IdPath"))
            {
                byte0 = 4;
            }
              goto _L107
_L98:
            if (s.equals("Listing.Item.Description"))
            {
                byte0 = 5;
            }
              goto _L107
_L75:
            if (s.equals("Listing.Item.AddToDescription"))
            {
                byte0 = 6;
            }
              goto _L107
_L20:
            if (s.equals("Listing.ConditionDescription"))
            {
                byte0 = 7;
            }
              goto _L107
_L92:
            if (s.equals("Listing.Condition"))
            {
                byte0 = 8;
            }
              goto _L107
_L99:
            if (s.equals("Metadata.ConditionInfo.ValueSetId"))
            {
                byte0 = 9;
            }
              goto _L107
_L49:
            if (s.equals("Listing.Duration"))
            {
                byte0 = 10;
            }
              goto _L107
_L2:
            if (s.equals("Listing.Format"))
            {
                byte0 = 11;
            }
              goto _L107
_L4:
            if (s.equals("Listing.StartPrice"))
            {
                byte0 = 12;
            }
              goto _L107
_L9:
            if (s.equals("Listing.Price"))
            {
                byte0 = 13;
            }
              goto _L107
_L26:
            if (s.equals("Listing.AuctionReservePrice"))
            {
                byte0 = 14;
            }
              goto _L107
_L65:
            if (s.equals("Listing.Quantity"))
            {
                byte0 = 15;
            }
              goto _L107
_L15:
            if (s.equals("Listing.ShippingInfo.DomesticShippingType"))
            {
                byte0 = 16;
            }
              goto _L107
_L76:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping"))
            {
                byte0 = 17;
            }
              goto _L107
_L70:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode"))
            {
                byte0 = 18;
            }
              goto _L107
_L16:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode"))
            {
                byte0 = 19;
            }
              goto _L107
_L74:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode"))
            {
                byte0 = 20;
            }
              goto _L107
_L21:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode"))
            {
                byte0 = 21;
            }
              goto _L107
_L93:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee"))
            {
                byte0 = 22;
            }
              goto _L107
_L78:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee"))
            {
                byte0 = 23;
            }
              goto _L107
_L68:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee"))
            {
                byte0 = 24;
            }
              goto _L107
_L55:
            if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee"))
            {
                byte0 = 25;
            }
              goto _L107
_L106:
            if (s.equals("Listing.ShippingInfo.ShippingPackageDetails.PackageType"))
            {
                byte0 = 26;
            }
              goto _L107
_L95:
            if (s.equals("Listing.ShippingInfo.ShippingPackageDetails.PackageLength.Value"))
            {
                byte0 = 27;
            }
              goto _L107
_L62:
            if (s.equals("Listing.ShippingInfo.ShippingPackageDetails.PackageWidth.Value"))
            {
                byte0 = 28;
            }
              goto _L107
_L72:
            if (s.equals("Listing.ShippingInfo.ShippingPackageDetails.PackageDepth.Value"))
            {
                byte0 = 29;
            }
              goto _L107
_L104:
            if (s.equals("Listing.ShippingInfo.IrregularPackage"))
            {
                byte0 = 30;
            }
              goto _L107
_L80:
            if (s.equals("Listing.PkgUnitOfMeasure"))
            {
                byte0 = 31;
            }
              goto _L107
_L42:
            if (s.equals("Listing.ShippingPackageDetails.EstimatedWeight"))
            {
                byte0 = 32;
            }
              goto _L107
_L103:
            if (s.equals("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value"))
            {
                byte0 = 33;
            }
              goto _L107
_L41:
            if (s.equals("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value"))
            {
                byte0 = 34;
            }
              goto _L107
_L102:
            if (s.equals("Listing.ShippingInfo.IntlShippingType"))
            {
                byte0 = 35;
            }
              goto _L107
_L83:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode"))
            {
                byte0 = 36;
            }
              goto _L107
_L29:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode"))
            {
                byte0 = 37;
            }
              goto _L107
_L86:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode"))
            {
                byte0 = 38;
            }
              goto _L107
_L36:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode"))
            {
                byte0 = 39;
            }
              goto _L107
_L89:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode"))
            {
                byte0 = 40;
            }
              goto _L107
_L58:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee"))
            {
                byte0 = 41;
            }
              goto _L107
_L45:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee"))
            {
                byte0 = 42;
            }
              goto _L107
_L33:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee"))
            {
                byte0 = 43;
            }
              goto _L107
_L19:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee"))
            {
                byte0 = 44;
            }
              goto _L107
_L8:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[4].ShippingFee"))
            {
                byte0 = 45;
            }
              goto _L107
_L25:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[0].ShipToRegion"))
            {
                byte0 = 46;
            }
              goto _L107
_L63:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[1].ShipToRegion"))
            {
                byte0 = 47;
            }
              goto _L107
_L105:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[2].ShipToRegion"))
            {
                byte0 = 48;
            }
              goto _L107
_L34:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[3].ShipToRegion"))
            {
                byte0 = 49;
            }
              goto _L107
_L71:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[4].ShipToRegion"))
            {
                byte0 = 50;
            }
              goto _L107
_L7:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[0].ShipToLocation"))
            {
                byte0 = 51;
            }
              goto _L107
_L40:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[1].ShipToLocation"))
            {
                byte0 = 52;
            }
              goto _L107
_L73:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[2].ShipToLocation"))
            {
                byte0 = 53;
            }
              goto _L107
_L3:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[3].ShipToLocation"))
            {
                byte0 = 54;
            }
              goto _L107
_L35:
            if (s.equals("Listing.ShippingInfo.IntlItemShippingService[4].ShipToLocation"))
            {
                byte0 = 55;
            }
              goto _L107
_L6:
            if (s.equals("Listing.PaymentInfo.PaypalEmailAddress"))
            {
                byte0 = 56;
            }
              goto _L107
_L64:
            if (s.equals("Listing.PaymentInfo.ImmediatePay"))
            {
                byte0 = 57;
            }
              goto _L107
_L96:
            if (s.equals("Listing.ListingCurrency"))
            {
                byte0 = 58;
            }
              goto _L107
_L39:
            if (s.equals("Metadata.ProductInfo.Title"))
            {
                byte0 = 59;
            }
              goto _L107
_L13:
            if (s.equals("Listing.Item.ProductInfo.StockPhoto"))
            {
                byte0 = 60;
            }
              goto _L107
_L23:
            if (s.equals("Listing.Item.ProductInfo.ProductId"))
            {
                byte0 = 61;
            }
              goto _L107
_L24:
            if (s.equals("Listing.Item.ProductInfo.ProductReferenceId"))
            {
                byte0 = 62;
            }
              goto _L107
_L59:
            if (s.equals("Listing.StartDate"))
            {
                byte0 = 63;
            }
              goto _L107
_L17:
            if (s.equals("Listing.ScheduledListing"))
            {
                byte0 = 64;
            }
              goto _L107
_L56:
            if (s.equals("Listing.Item.ItemSpecific"))
            {
                byte0 = 65;
            }
              goto _L107
_L54:
            if (s.equals("Listing.BestOffer.BestOfferEnabled"))
            {
                byte0 = 66;
            }
              goto _L107
_L50:
            if (s.equals("Listing.BestOffer.AutoAccept"))
            {
                byte0 = 67;
            }
              goto _L107
_L5:
            if (s.equals("Listing.BestOffer.AutoAcceptAmount"))
            {
                byte0 = 68;
            }
              goto _L107
_L43:
            if (s.equals("Listing.BestOffer.AutoDecline"))
            {
                byte0 = 69;
            }
              goto _L107
_L88:
            if (s.equals("Listing.BestOffer.AutodeclineAmount"))
            {
                byte0 = 70;
            }
              goto _L107
_L30:
            if (s.equals("Listing.ShippingInfo.HandlingDuration"))
            {
                byte0 = 71;
            }
              goto _L107
_L91:
            if (s.equals("Metadata.ShippingInfo.ExtendedHandlingDuration"))
            {
                byte0 = 72;
            }
              goto _L107
_L22:
            if (s.equals("Listing.ReturnPolicy.PolicyDetails"))
            {
                byte0 = 73;
            }
              goto _L107
_L82:
            if (s.equals("Listing.ReturnPolicy.RefundMethod"))
            {
                byte0 = 74;
            }
              goto _L107
_L18:
            if (s.equals("Listing.ReturnPolicy.RefundShipmentPayee"))
            {
                byte0 = 75;
            }
              goto _L107
_L44:
            if (s.equals("Listing.ReturnPolicy.ReturnsAccepted"))
            {
                byte0 = 76;
            }
              goto _L107
_L90:
            if (s.equals("Listing.ReturnPolicy.ReturnPeriod"))
            {
                byte0 = 77;
            }
              goto _L107
_L46:
            if (s.equals("Listing.ReturnPolicy.RestockingFeeValue"))
            {
                byte0 = 78;
            }
              goto _L107
_L81:
            if (s.equals("Listing.ItemLocation.CountryCode"))
            {
                byte0 = 79;
            }
              goto _L107
_L27:
            if (s.equals("Listing.ItemLocation.CityState"))
            {
                byte0 = 80;
            }
              goto _L107
_L85:
            if (s.equals("Listing.ItemLocation.ZipCode"))
            {
                byte0 = 81;
            }
              goto _L107
_L100:
            if (s.equals("Metadata.PictureInfo.MaxPicturesRemaining"))
            {
                byte0 = 82;
            }
              goto _L107
_L31:
            if (s.equals("Metadata.PictureInfo.MaxFreePictures"))
            {
                byte0 = 83;
            }
              goto _L107
_L87:
            if (s.equals("Listing.LastModified"))
            {
                byte0 = 84;
            }
              goto _L107
_L69:
            if (s.equals("Metadata.ApplicationInfo.AppName"))
            {
                byte0 = 85;
            }
              goto _L107
_L101:
            if (s.equals("Listing.ShippingInfo.GlobalShipping"))
            {
                byte0 = 86;
            }
              goto _L107
_L67:
            if (s.equals("Metadata.ItemInfo.OriginalItemId"))
            {
                byte0 = 87;
            }
              goto _L107
_L57:
            if (s.equals("Metadata.PaymentInfo.RegisteredPaypalEmailAddreses"))
            {
                byte0 = 88;
            }
              goto _L107
_L38:
            if (s.equals("Listing.AutoRelistInfo.AutoRelistEnabled"))
            {
                byte0 = 89;
            }
              goto _L107
_L51:
            if (s.equals("Metadata.Fees.AutoRelistFeeSetting"))
            {
                byte0 = 90;
            }
              goto _L107
_L53:
            if (s.equals("Metadata.Listing.AutoRelistCount"))
            {
                byte0 = 91;
            }
              goto _L107
_L94:
            if (s.equals("Metadata.Listing.MaxAutoRelist"))
            {
                byte0 = 92;
            }
              goto _L107
_L11:
            if (s.equals("Metadata.SimilarListings.Listing.Price.Max"))
            {
                byte0 = 93;
            }
              goto _L107
_L12:
            if (s.equals("Metadata.SimilarListings.Listing.Price.Min"))
            {
                byte0 = 94;
            }
              goto _L107
_L47:
            if (s.equals("Metadata.SimilarListings.Listing.StartPrice.Max"))
            {
                byte0 = 95;
            }
              goto _L107
_L48:
            if (s.equals("Metadata.SimilarListings.Listing.StartPrice.Min"))
            {
                byte0 = 96;
            }
              goto _L107
_L61:
            if (s.equals("Metadata.Fees.FeeOnTotalCost"))
            {
                byte0 = 97;
            }
              goto _L107
_L79:
            if (s.equals("Listing.CharityInfo.DonationPercent"))
            {
                byte0 = 98;
            }
              goto _L107
_L52:
            if (s.equals("Listing.CharityInfo.CharityId"))
            {
                byte0 = 99;
            }
              goto _L107
_L10:
            if (s.equals("Listing.LocalPickupInfo.LocalPickup"))
            {
                byte0 = 100;
            }
              goto _L107
_L77:
            if (s.equals("Metadata.Listing.PriceInfo.GuaranteeStartPrice"))
            {
                byte0 = 101;
            }
              goto _L107
_L14:
            if (s.equals("Metadata.Listing.PriceInfo.GuaranteeSalePrice"))
            {
                byte0 = 102;
            }
              goto _L107
_L37:
            if (s.equals("Metadata.Listing.PriceInfo.GuaranteeTerms"))
            {
                byte0 = 103;
            }
              goto _L107
            if (s.equals("Metadata.Listing.PriceInfo.GuaranteeProvided"))
            {
                byte0 = 104;
            }
              goto _L107
        }

        private FieldId()
        {
            this$2 = LdsResponse.RootElement.FieldNode.this;
            super();
        }

        FieldId(LdsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FieldRecommendationId extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final LdsResponse.RootElement.FieldNode this$2;

        public void text(String s)
            throws SAXException
        {
            field.id = s;
            if (s.equals("Listing.Price"))
            {
                draft.recommendedPrice = field;
            }
            if (s.equals("Listing.StartPrice"))
            {
                draft.recommendedStartPrice = field;
            }
            if (s.equals("Listing.Format"))
            {
                draft.recommendedFormat = field;
            }
            if (s.equals("Listing.Duration"))
            {
                draft.recommendedDuration = field;
            }
        }

        private FieldRecommendationId()
        {
            this$2 = LdsResponse.RootElement.FieldNode.this;
            super();
        }

        FieldRecommendationId(LdsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class OptionValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
   