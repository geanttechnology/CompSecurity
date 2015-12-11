// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.domain.net.api.ecas.models.ErrorMessage;
import com.ebay.nautilus.domain.net.dataobject.ErrorMessageContainer;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class EcasErrorHandler
{
    public static class EcasMessage
        implements com.ebay.nautilus.kernel.content.ResultStatus.Message
    {

        private final int errorCode;
        private final String longMessage;
        private final com.ebay.nautilus.kernel.content.ResultStatus.Severity severity;
        private final String shortMessage;
        private final boolean supressErrors;

        public boolean displayToUser()
        {
            return !supressErrors;
        }

        public String getCategory()
        {
            return "";
        }

        public String getDomain()
        {
            return "";
        }

        public int getId()
        {
            return errorCode;
        }

        public String getLongMessage(EbayContext ebaycontext)
        {
            return longMessage;
        }

        public String getRemediationUrl()
        {
            return "";
        }

        public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
        {
            if (!supressErrors)
            {
                return severity;
            } else
            {
                return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning;
            }
        }

        public String getShortMessage(EbayContext ebaycontext)
        {
            return shortMessage;
        }

        public boolean isLongMessageHtml(EbayContext ebaycontext)
        {
            return false;
        }

        public EcasMessage(com.ebay.nautilus.kernel.content.ResultStatus.Severity severity1, int i, String s, String s1, boolean flag)
        {
            severity = severity1;
            errorCode = i;
            longMessage = s1;
            shortMessage = s;
            supressErrors = flag;
        }
    }


    public static final int ADD_ITEM_INPUT_TAG_MISSING_MESSAGE_CODE = 520;
    public static final int ADD_ITEM_LIMIT_MESSAGE_CODE = 423;
    public static final int ADMIN_ARCHIVED_MESSAGE_CODE = 114;
    public static final int ARCHIVED_ITEM_MESSAGE_CODE = 117;
    public static final int AUCTION_ENDED_AS_BIN_MESSAGE_CODE = 140;
    public static final int AUCTION_LOST_MESSAGE_CODE = 922;
    public static final int AUCTION_NOT_ALLOWED_MESSAGE_CODE = 403;
    public static final int AUCTION_OUTBID_MESSAGE_CODE = 924;
    public static final int AUCTION_TRACK_COLLECTION_CREATION_FAILED_MESSAGE_CODE = 2001;
    public static final int AUCTION_WINNING_MESSAGE_CODE = 923;
    public static final int AUCTION_WON_MESSAGE_CODE = 921;
    public static final int AVAILABLE_SHIPPING_SERVICE_NOT_FOUND_MESSAGE_CODE = 2006;
    public static final int BIDDERCACHE_LOAD_FAILED_MESSAGE_CODE = 419;
    public static final int BUYER_BLOCKED_AUTHENTIFY_VERIFICATION_MESSAGE_CODE = 1008;
    public static final int BUYER_BLOCKED_CC_VERIFICATION_MESSAGE_CODE = 1006;
    public static final int BUYER_BLOCKED_DOES_NOT_SHIP_TO_LOCATION_MESSAGE_CODE = 1004;
    public static final int BUYER_BLOCKED_ITEM_COUNT_LIMIT_EXCEEDED_MESSAGE_CODE = 1011;
    public static final int BUYER_BLOCKED_LOW_FEEDBACK_SCORE_MESSAGE_CODE = 1002;
    public static final int BUYER_BLOCKED_LOW_UNPAID_ITEM_STRIKE_MESSAGE_CODE = 1003;
    public static final int BUYER_BLOCKED_MESSAGE_CODE = 1012;
    public static final int BUYER_BLOCKED_NO_LINKED_PAYPAL_ACCOUNT_MESSAGE_CODE = 1005;
    public static final int BUYER_BLOCKED_SELLER_EXCLUDED_SHIP_TO_LOCATION_MESSAGE_CODE = 1015;
    public static final int BUYER_BLOCKED_SMS_VERIFICATION_MESSAGE_CODE = 1007;
    public static final int BUYER_BLOCKED_VERIFICATION_NO_REMEDY_MESSAGE_CODE = 1009;
    public static final int BUYER_BLOCKED_VERIFIED_USER_MESSAGE_CODE = 1010;
    public static final int BUYER_BLOCKED_ZERO_FEEDBACK_SCORE_MESSAGE_CODE = 1001;
    public static final int BUYER_INFO_INVALID_MESSAGE_CODE = 3014;
    public static final int BUYER_IS_SELLER_MESSAGE_CODE = 3013;
    public static final int BUYER_LOAD_FAILED_MESSAGE_CODE = 420;
    public static final int BUYER_MARKED_PAID_MESSAGE_CODE = 131;
    public static final int BUYER_MESSAGE_MESSAGE_CODE = 126;
    public static final int BUYER_NOT_CART_BUYER_MESSGE_CODE = 3012;
    public static final int BUYER_NOT_EXIST_MESSAGE_CODE = 515;
    public static final int BUYER_STATE_INVALID_MESSAGE_CODE = 1017;
    public static final int BUYER_WARNING_DOES_NOT_SHIP_TO_POBOX_MESSAGE_CODE = 1013;
    public static final int BUYING_SERVICE_CANCELLABLE_MESSAGE_CODE = 3030;
    public static final int BUYING_SERVICE_LOCKABLE_MESSAGE_CODE = 3028;
    public static final int BUYING_SERVICE_PURCHASE_FAILED_MESSAGE_CODE = 3026;
    public static final int BUYING_SERVICE_RETRYABLE_MESSAGE_CODE = 3027;
    public static final int CART_CANNOT_BE_OBTAINED_MESSAGE_CODE = 407;
    public static final int CART_COULD_NOT_BE_UPDATED_MESSAGE_CODE = 409;
    public static final List CART_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(417), Integer.valueOf(424), Integer.valueOf(418), Integer.valueOf(419), Integer.valueOf(420), Integer.valueOf(421), Integer.valueOf(422), Integer.valueOf(423), Integer.valueOf(401), Integer.valueOf(402), 
        Integer.valueOf(403), Integer.valueOf(404), Integer.valueOf(405), Integer.valueOf(406), Integer.valueOf(407), Integer.valueOf(408), Integer.valueOf(409), Integer.valueOf(410), Integer.valueOf(411), Integer.valueOf(412), 
        Integer.valueOf(413), Integer.valueOf(414), Integer.valueOf(415), Integer.valueOf(416)
    });
    public static final int CART_NOT_EXIST_MESSAGE_CODE = 401;
    public static final int CART_TRUNCATED_ON_LIMIT_MESSAGE_CODE = 422;
    public static final int CHECKOUT_CART_CONVERTER_ERROR_MESSAGE_CODE = 901;
    public static final int CHECKOUT_CART_CONVERTER_WARNING_MESSAGE_CODE = 902;
    public static final int CHECKOUT_COMPLETED_MESSAGE_CODE = 115;
    public static final int CHECKOUT_EXPIRED_MESSAGE_CODE = 113;
    public static final List CHECKOUT_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(901), Integer.valueOf(903), Integer.valueOf(904), Integer.valueOf(905), Integer.valueOf(906), Integer.valueOf(902)
    });
    public static final int CLASSIFIEDS_MESSAGE_CODE = 110;
    public static final int DATABASE_EXCEPTION_MESSAGE_CODE = 602;
    public static final int DATASOURCE_DOWN_ERROR_MESSAGE_CODE = 416;
    public static final int DOMAIN_INTERNAL_ERROR_MESSAGE_CODE = 3020;
    public static final int DOUBLE_BINNING_MESSAGE_CODE = 138;
    public static final int EMPTY_GROUP_MESSAGE_CODE = 3018;
    public static final int EMPTY_ORDER_MESSAGE_CODE = 145;
    public static final int GET_AUCTION_TRACK_COLLECTION_ATTRIBUTES_ERROR_MESSAGE_CODE = 2004;
    public static final int GET_SFL_LIST_FAILURE_MESSAGE_CODE = 710;
    public static final int GROUP_ERROR_MESSAGE_CODE = 801;
    public static final List GROUP_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(801)
    });
    public static final int HIGHEST_BIDDER_MESSAGE_CODE = 925;
    public static final int IAF_TOKEN_EXPIRED_MESSAGE_CODE = 11002;
    private static final List IGNORED_CODES = Collections.unmodifiableList(Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(113), Integer.valueOf(118), Integer.valueOf(124), Integer.valueOf(401), Integer.valueOf(3021), Integer.valueOf(3022), Integer.valueOf(123), Integer.valueOf(128), Integer.valueOf(103)
    }));
    public static final int INCENTIVE_NOT_APPLIED_MESSAGE_CODE = 3015;
    public static final int INCENTIVE_SERVICE_ERROR_MESSAGE_CODE = 3024;
    public static final int INVALID_BASE_IDENTIFIER_MESSAGE_CODE = 3004;
    public static final int INVALID_BUYING_CONTEXT_MESSAGE_CODE = 412;
    public static final int INVALID_CART_ITEM_REFERENCE_ID_MESSAGE_CODE = 705;
    public static final int INVALID_CART_SERVICE_REQUEST_MESSAGE_CODE = 3001;
    public static final int INVALID_CHECKOUT_FLOW_IDENTIFIER_MESSAGE_CODE = 904;
    public static final int INVALID_COUNTRY_CODE_MESSAGE_CODE = 514;
    public static final int INVALID_COUNTRY_MESSAGE_CODE = 136;
    public static final int INVALID_DOMAIN_MESSAGE_CODE = 3002;
    public static final int INVALID_EXTENDED_IDENTIFIER_MESSAGE_CODE = 3005;
    public static final int INVALID_GROUP_PAID_STATUS_MESSAGE_CODE = 3033;
    public static final int INVALID_IDENTIFIER_MESSAGE_CODE = 3003;
    public static final int INVALID_INPUT_ADDRESS_ID_MESSAGE_CODE = 516;
    public static final int INVALID_INPUT_MESSAGE_CODE = 513;
    public static final int INVALID_ITEM_IDENTIFIER_MESSAGE_CODE = 506;
    public static final int INVALID_ITEM_PRICE_MESSAGE_CODE = 134;
    public static final int INVALID_ITEM_REFERENCE_ID_MESSAGE_CODE = 510;
    public static final int INVALID_ITEM_SELLER_MESSAGE_CODE = 3009;
    public static final int INVALID_ITEM_TITLE_MESSAGE_CODE = 3011;
    public static final int INVALID_ITEM_VERSION_MESSAGE_CODE = 3017;
    public static final int INVALID_LIST_OF_ITEMS_TO_CHECKOUT_MESSAGE_CODE = 905;
    public static final int INVALID_LIST_OF_ITEM_IDENTIFIERS_MESSAGE_CODE = 906;
    public static final int INVALID_LIST_OF_ITEM_REFERENCE_ID_MESSAGE_CODE = 517;
    public static final int INVALID_MOVE_AUCTION_ITEM_FROM_CART_TO_SFL_OPERATION_MESSAGE_CODE = 2007;
    public static final int INVALID_MOVE_AUCTION_ITEM_FROM_SFL_TO_CART_OPERATION_MESSAGE_CODE = 2008;
    public static final int INVALID_ORDER_STATE_MESSAGE_CODE = 122;
    public static final int INVALID_QUANTITY_MESSAGE_CODE = 104;
    public static final int INVALID_REMOVE_AUCTION_ITEM_FROM_CART_OPERATION_MESSAGE_CODE = 2009;
    public static final int INVALID_REMOVE_AUCTION_ITEM_FROM_SAVE_FOR_LATER_OPERATION_MESSAGE_CODE = 2010;
    public static final int INVALID_REQUESTED_QUANTITY_MESSAGE_CODE = 509;
    public static final int INVALID_SFL_ITEM_REFERENCE_ID_MESSAGE_CODE = 704;
    public static final int INVALID_SHIPPING_ADDRESS_MESSAGE_CODE = 511;
    public static final int INVALID_SHIPPING_IDENTIFIER_MESSAGE_CODE = 507;
    public static final int INVALID_SHIPPING_MESSAGE_CODE = 135;
    public static final int INVALID_SHOP_CART_ID_MESSAGE_CODE = 502;
    public static final int INVALID_SITE_ID_MESSAGE_CODE = 505;
    public static final int INVALID_USER_AND_SITE_ID_MESSAGE_CODE = 503;
    public static final int INVALID_USER_ID_MESSAGE_CODE = 504;
    public static final int INVALID_VARIATION_ID_MESSAGE_CODE = 508;
    public static final int ITEM_ALREADY_EXISTS_MESSAGE_CODE = 3016;
    public static final int ITEM_CANNOT_BE_ADDED_AS_COMMITTED_MESSAGE_CODE = 3007;
    public static final int ITEM_CANNOT_BE_ADDED_AS_UNCOMMITTED_MESSAGE_CODE = 3008;
    public static final int ITEM_CURRENCY_MISMATCH_MESSAGE_CODE = 101;
    public static final int ITEM_DETAILS_MISSING_MESSAGE_CODE = 521;
    public static final int ITEM_ERROR_MESSAGE_CODE = 124;
    public static final int ITEM_HIDDEN_OR_PAID_MESSAGE_CODE = 148;
    public static final List ITEM_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(126), Integer.valueOf(127), Integer.valueOf(921), Integer.valueOf(922), Integer.valueOf(923), Integer.valueOf(924), Integer.valueOf(925), Integer.valueOf(101), Integer.valueOf(102), Integer.valueOf(104), 
        Integer.valueOf(125), Integer.valueOf(141), Integer.valueOf(146), Integer.valueOf(147), Integer.valueOf(148), Integer.valueOf(149), Integer.valueOf(145), Integer.valueOf(145), Integer.valueOf(143), Integer.valueOf(144), 
        Integer.valueOf(142), Integer.valueOf(138), Integer.valueOf(139), Integer.valueOf(140), Integer.valueOf(103), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108), Integer.valueOf(109), 
        Integer.valueOf(110), Integer.valueOf(111), Integer.valueOf(112), Integer.valueOf(113), Integer.valueOf(114), Integer.valueOf(115), Integer.valueOf(116), Integer.valueOf(117), Integer.valueOf(118), Integer.valueOf(119), 
        Integer.valueOf(120), Integer.valueOf(121), Integer.valueOf(122), Integer.valueOf(123), Integer.valueOf(124), Integer.valueOf(128), Integer.valueOf(129), Integer.valueOf(130), Integer.valueOf(131), Integer.valueOf(133), 
        Integer.valueOf(134), Integer.valueOf(135), Integer.valueOf(136), Integer.valueOf(137), Integer.valueOf(2001), Integer.valueOf(2002), Integer.valueOf(2003), Integer.valueOf(2004), Integer.valueOf(2005), Integer.valueOf(2006), 
        Integer.valueOf(2007), Integer.valueOf(2008), Integer.valueOf(2009), Integer.valueOf(2010), Integer.valueOf(2011), Integer.valueOf(2012)
    });
    public static final int ITEM_NOT_ACTIVE_MESSAGE_CODE = 102;
    public static final int ITEM_NOT_AVAILABLE_FOR_PURCHASE_MESSAGE_CODE = 3006;
    public static final int ITEM_NOT_AVAILABLE_MESSAGE_CODE = 128;
    public static final int ITEM_NOT_ELIGIBLE_TO_BE_IN_SAVE_FOR_LATER = 712;
    public static final int ITEM_NOT_ELIGIBLE_TO_BE_MOVED_MESSAGE_CODE = 711;
    public static final int ITEM_NOT_EXIST_MESSAGE_CODE = 406;
    public static final int ITEM_NOT_FOUND_MESSAGE_CODE = 411;
    public static final int ITEM_PRICE_CHANGED_MESSAGE_CODE = 3010;
    public static final int ITEM_QUANTITY_TAG_MISSING_MESSAGE_CODE = 523;
    public static final int ITEM_REFERENCE_ID_INPUT_TAG_MISSING_MESSAGE_CODE = 518;
    public static final int ITEM_REFERENCE_ID_MISSING_MESSAGE_CODE = 519;
    public static final int ITEM_REVISED_MESSAGE_CODE = 125;
    public static final int ITEM_SHIPPING_SERVICE_TAG_MISSING_MESSAGE_CODE = 526;
    public static final int ITEM_TYPE_NOT_SUPPORTED_MESSAGE_CODE = 147;
    public static final int ITEM_VALIDATION_ERROR_MESSAGE_CODE = 3019;
    public static final int LATEST_VERSION_MESSAGE_CODE = 127;
    public static final int LIVE_AUCTION_ITEM_MESSAGE_CODE = 107;
    private static final String MESSAGE_FIELD_VALUE_SEPARATOR = ": ";
    private static final String MESSAGE_SEPARATOR = "\n";
    public static final int MOTORS_WITHOUT_DEPOSIT_MESSAGE_CODE = 108;
    public static final int MOVE_FROM_CART_TO_SFL_OPERATION_FAILURE_MESSAGE_CODE = 706;
    public static final int MOVE_FROM_SFL_TO_CART_OPERATION_FAILURE_MESSAGE_CODE = 702;
    public static final int NATIVE_PROVIDER_INFO_MESSAGE_CODE = 205;
    public static final int NATIVE_SHIPPING_EXCLUSIONS_MESSAGE_CODE = 208;
    public static final int NOT_BIN_ITEM_MESSAGE_CODE = 106;
    public static final int NOT_SELLER_CREATED_ORDER_MESSAGE_CODE = 121;
    public static final int NO_AUCTION_HISTORY_FOR_BUYER_MESSAGE_CODE = 141;
    public static final int NO_MESSAGE_CODE = 0;
    public static final int OFFER_AMOUNT_LIMIT_EXCEEDED_MESSAGE_CODE = 133;
    public static final int ORDER_ARCHIVED_REMOVED_FROM_CART_MESSAGE_CODE = 2012;
    public static final int ORDER_BUYER_MISMATCH_MESSAGE_CODE = 120;
    public static final int ORDER_CANCELLED_MESSAGE_CODE = 149;
    public static final int ORDER_NOT_FOUND_MESSAGE_CODE = 119;
    public static final int PAYMENT_SERVICE_ERROR_MESSAGE_CODE = 3023;
    public static final int POSTPAY_ERROR_MESSAGE_CODE = 3031;
    public static final int POSTPAY_WARNING_MESSAGE_CODE = 3032;
    public static final int QUANTITY_DETAILS_MISSING_MESSAGE_CODE = 524;
    public static final int QUANTITY_TAG_MISSING_MESSAGE_CODE = 522;
    public static final int QUANTITY_UPDATE_ERROR_FOR_SCO_MESSAGE_CODE = 145;
    public static final int QUANTITY_UPDATE_ERROR_FOR_TXN_MESSAGE_CODE = 144;
    public static final int REMOVE_AUCTION_ENTITY_FAILURE_MESSAGE_CODE = 2003;
    public static final int REMOVE_SFL_ENTITY_FAILURE_MESSAGE_CODE = 709;
    public static final int REQUEST_DATA_ERROR_MESSAGE_CODE = 415;
    public static final List REQUEST_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(501), Integer.valueOf(502), Integer.valueOf(503), Integer.valueOf(504), Integer.valueOf(505), Integer.valueOf(506), Integer.valueOf(507), Integer.valueOf(508), Integer.valueOf(509), Integer.valueOf(510), 
        Integer.valueOf(511), Integer.valueOf(512), Integer.valueOf(513), Integer.valueOf(514), Integer.valueOf(515), Integer.valueOf(516), Integer.valueOf(517), Integer.valueOf(518), Integer.valueOf(518), Integer.valueOf(519), 
        Integer.valueOf(520), Integer.valueOf(521), Integer.valueOf(522), Integer.valueOf(523), Integer.valueOf(524), Integer.valueOf(525), Integer.valueOf(526), Integer.valueOf(527)
    });
    public static final int REQUEST_NULL_MESSAGE_CODE = 501;
    public static final int SALE_BO_LIST_FOR_AUCTION_ITEMS_NOT_FOUND_MESSAGE_CODE = 2005;
    public static final int SALE_ENDED_ITEM_REMOVED_FROM_CART_MESSAGE_CODE = 417;
    public static final int SALE_ENDED_ITEM_REMOVED_FROM_SFL_MESSAGE_CODE = 713;
    public static final int SALE_ENDED_MESSAGE_CODE = 118;
    public static final int SALE_LOAD_FAILED_MESSAGE_CODE = 421;
    public static final int SCO_CANNOT_BE_REMOVED_MESSAGE_CODE = 143;
    private static final String SECURITY_DOMAIN = "Security";
    public static final int SELLER_LOAD_FAILED_MESSAGE_CODE = 424;
    public static final int SELLER_NOT_PERMITTED_TO_BUY_HIS_ITEM_MESSAGE_CODE = 137;
    public static final int SERVICE_INVOCATION_EXCEPTION_MESSAGE_CODE = 603;
    public static final List SERVICE_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(3001), Integer.valueOf(3002), Integer.valueOf(3003), Integer.valueOf(3004), Integer.valueOf(3005), Integer.valueOf(3006), Integer.valueOf(3007), Integer.valueOf(3008), Integer.valueOf(3009), Integer.valueOf(3010), 
        Integer.valueOf(3011), Integer.valueOf(3012), Integer.valueOf(3013), Integer.valueOf(3014), Integer.valueOf(3015), Integer.valueOf(3016), Integer.valueOf(3017), Integer.valueOf(3018), Integer.valueOf(3019), Integer.valueOf(3020), 
        Integer.valueOf(3021), Integer.valueOf(3022), Integer.valueOf(3023), Integer.valueOf(3024), Integer.valueOf(3025), Integer.valueOf(3026), Integer.valueOf(3027), Integer.valueOf(3028), Integer.valueOf(3030), Integer.valueOf(3031), 
        Integer.valueOf(3032), Integer.valueOf(3033), Integer.valueOf(601), Integer.valueOf(602), Integer.valueOf(603)
    });
    public static final int SFL_ITEM_NOT_FOUND_MESSAGE_CODE = 701;
    public static final int SFL_ITEM_REMOVAL_FAILED_MESSAGE_CODE = 703;
    public static final List SFL_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(701), Integer.valueOf(702), Integer.valueOf(703), Integer.valueOf(704), Integer.valueOf(705), Integer.valueOf(706), Integer.valueOf(707), Integer.valueOf(708), Integer.valueOf(709), Integer.valueOf(710), 
        Integer.valueOf(711), Integer.valueOf(712), Integer.valueOf(713)
    });
    public static final int SFL_LIST_CANNOT_BE_OBTAINED_MESSAGE_CODE = 408;
    public static final int SFL_LIST_COULD_BE_UPDATED_MESSAGE_CODE = 410;
    public static final int SFL_LIST_CREATION_FAILED_MESSAGE_CODE = 707;
    public static final int SFL_NOT_ALLOWED_MESSAGE_CODE = 404;
    public static final int SHIPPING_SERIVCE_ERROR_MESSAGE_CODE = 3021;
    public static final int SHIPPING_SERVICE_DETAILS_MISSING_MESSAGE_CODE = 527;
    public static final int SHIPPING_SERVICE_NOT_SUPPORTED_MESSAGE_CODE = 123;
    public static final int SHIPPING_SERVICE_TAG_MISSING_MESSAGE_CODE = 525;
    public static final int SHOP_CART_IS_EMPTY_MESSAGE_CODE = 402;
    public static final int SHOP_CART_OWNER_IS_DIFFERENT_MESSAGE_CODE = 405;
    public static final int SITE_NOT_EXIST_MESSAGE_CODE = 512;
    public static final int STATUS_FLAG_ERROR_MESSAGE_CODE = 3025;
    public static final int STORE_OWNER_ON_VACATION_MESSAGE_CODE = 146;
    public static final int TAX_SERVICE_ERROR_MESSAGE_CODE = 3022;
    public static final int TCACHE_LOAD_FAILED_MESSAGE_CODE = 418;
    public static final int THIRD_PARTY_CHECKOUT_MESSAGE_CODE = 109;
    public static final int TRANSACTION_ARCHIVED_REMOVED_FROM_CART_MESSAGE_CODE = 2011;
    public static final int TRANSACTION_BUYER_MISMATCH_MESSAGE_CODE = 116;
    public static final int TRANSACTION_CANCELLED_MESSAGE_CODE = 129;
    public static final int TRANSACTION_CANNOT_BE_REMOVED_MESSAGE_CODE = 142;
    public static final int TRANSACTION_IS_PART_OF_ORDER_MESSAGE_CODE = 130;
    public static final int TRANSACTION_NOT_FOUND_MESSAGE_CODE = 111;
    public static final int UNFORSEEN_EXCEPTION_MESSAGE_CODE = 601;
    public static final int UNPROCESSED_MESSAGE_CODE = 414;
    public static final int UNSUPPORTED_CATEGORY_MESSAGE_CODE = 105;
    public static final int UNSUPPORTED_SALE_TYPE_MESSAGE_CODE = 139;
    public static final int UPDATE_SHOPPING_CART_POST_CHECKOUT_ERROR_MESSAGE_CODE = 903;
    public static final int UPI_CASE_CLOSED_MESSAGE_CODE = 112;
    public static final int UPSERT_AUCTION_ENTITY_FAILIURE_MESSAGE_CODE = 2002;
    public static final int UPSERT_SFL_ENTITY_FAILURE_MESSAGE_CODE = 708;
    public static final List USER_LEVEL_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(1001), Integer.valueOf(1002), Integer.valueOf(1003), Integer.valueOf(1004), Integer.valueOf(1005), Integer.valueOf(1006), Integer.valueOf(1007), Integer.valueOf(1008), Integer.valueOf(1009), Integer.valueOf(1010), 
        Integer.valueOf(1011), Integer.valueOf(1012), Integer.valueOf(1013), Integer.valueOf(1014), Integer.valueOf(1015), Integer.valueOf(1016), Integer.valueOf(1017), Integer.valueOf(11002)
    });
    public static final int USER_NOT_PREAPPROVED_MESSAGE_CODE = 1016;
    public static final int USER_NOT_VALID_MESSAGE_CODE = 413;
    public static final int USER_SUSPENDED_MESSAGE_CODE = 1014;
    public static final int VARIATION_NOT_FOUND_MESSAGE_CODE = 103;
    private final com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action;
    private final String itemId;
    private final List messages = new LinkedList();

    public EcasErrorHandler(com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action1, String s)
    {
        action = action1;
        itemId = s;
    }

    public static final ErrorMessageDetails getIafTokenError(ErrorMessageContainer errormessagecontainer)
    {
label0:
        {
            if (errormessagecontainer == null)
            {
                break label0;
            }
            errormessagecontainer = errormessagecontainer.getErrors();
            if (errormessagecontainer == null || errormessagecontainer.isEmpty())
            {
                break label0;
            }
            errormessagecontainer = errormessagecontainer.iterator();
            ErrorMessageDetails errormessagedetails;
            do
            {
                if (!errormessagecontainer.hasNext())
                {
                    break label0;
                }
                errormessagedetails = (ErrorMessageDetails)errormessagecontainer.next();
            } while (11002 != errormessagedetails.getId() || !TextUtils.equals("Security", errormessagedetails.domain));
            return errormessagedetails;
        }
        return null;
    }

    public static final transient boolean hasAnyMessageCode(Collection collection, Integer ainteger[])
    {
label0:
        {
            if (collection == null || collection.isEmpty())
            {
                break label0;
            }
            ainteger = Arrays.asList(ainteger);
            collection = collection.iterator();
            do
            {
                if (!collection.hasNext())
                {
                    break label0;
                }
            } while (!ainteger.contains(Integer.valueOf(((com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.Message)collection.next()).code)));
            return true;
        }
        return false;
    }

    public static final boolean hasIgnoredNativeCheckoutError(Collection collection)
    {
        if (collection != null && !collection.isEmpty())
        {
            collection = collection.iterator();
            while (collection.hasNext()) 
            {
                Object obj = (com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter)collection.next();
                if (obj != null && ((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).name != null && ((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).name.toLowerCase(Locale.ENGLISH).equals("nativeErrorCode"))
                {
                    obj = ((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).value;
                    if (obj != null && (((String) (obj)).equals(Integer.toString(205)) || ((String) (obj)).equals(Integer.toString(208))))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private com.ebay.nautilus.kernel.content.ResultStatus.Severity severityFrom(String s)
    {
        if (s == null)
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning;
        }
        if (s.equalsIgnoreCase("error"))
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
        }
        if (s.equalsIgnoreCase("partialfailure"))
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.PartialFailure;
        } else
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning;
        }
    }

    public void addMessage(ErrorMessage errormessage)
    {
        if (errormessage != null && errormessage.error != null && !errormessage.error.isEmpty())
        {
            Iterator iterator = errormessage.error.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ErrorMessageDetails errormessagedetails = (ErrorMessageDetails)iterator.next();
                if (!IGNORED_CODES.contains(Integer.valueOf(errormessagedetails.getId())) && !hasIgnoredNativeCheckoutError(errormessagedetails.parameters))
                {
                    errormessage = "";
                    StringBuilder stringbuilder = new StringBuilder();
                    Object obj = errormessage;
                    if (errormessagedetails.parameters != null)
                    {
                        Iterator iterator1 = errormessagedetails.parameters.iterator();
                        do
                        {
                            obj = errormessage;
                            if (!iterator1.hasNext())
                            {
                                break;
                            }
                            obj = (com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter)iterator1.next();
                            if (((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).name.toLowerCase(Locale.ENGLISH).endsWith("message"))
                            {
                                errormessage = ((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).value;
                            }
                            stringbuilder.append(((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).name).append(": ").append(((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).value).append("\n");
                        } while (true);
                    }
                    messages.add(new EcasMessage(errormessagedetails.getSeverity(), errormessagedetails.getId(), ((String) (obj)), stringbuilder.toString(), shouldSuppressErrorFor(errormessagedetails.getId(), null)));
                }
            } while (true);
        }
    }

    public void addMessages(Collection collection, String s)
    {
        if (collection != null && !collection.isEmpty())
        {
            Iterator iterator = collection.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.Message message = (com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.Message)iterator.next();
                if (!IGNORED_CODES.contains(Integer.valueOf(message.code)))
                {
                    collection = "";
                    StringBuilder stringbuilder = new StringBuilder();
                    com.ebay.nautilus.kernel.content.ResultStatus.Severity severity = severityFrom(message.level);
                    Object obj = collection;
                    if (message.parameters != null)
                    {
                        Iterator iterator1 = message.parameters.iterator();
                        do
                        {
                            obj = collection;
                            if (!iterator1.hasNext())
                            {
                                break;
                            }
                            obj = (com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.NamedAttribute)iterator1.next();
                            if (((com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.NamedAttribute) (obj)).name.toLowerCase(Locale.ENGLISH).endsWith("message"))
                            {
                                collection = ((com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.NamedAttribute) (obj)).value;
                            }
                            stringbuilder.append(((com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.NamedAttribute) (obj)).name).append(": ").append(((com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.NamedAttribute) (obj)).value).append("\n");
                        } while (true);
                    }
                    messages.add(new EcasMessage(severity, message.code, ((String) (obj)), stringbuilder.toString(), shouldSuppressErrorFor(message.code, s)));
                }
            } while (true);
        }
    }

    public ResultStatus getResultStatus()
    {
        return ResultStatus.create(messages);
    }

    protected boolean shouldSuppressErrorFor(int i, String s)
    {
        boolean flag;
        boolean flag1;
        boolean flag3;
        flag3 = true;
        boolean flag2 = true;
        flag1 = false;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action = new int[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.ADD_TO_CART.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.GET_CART.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.GET_AND_VALIDATE_CART.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (!TextUtils.isEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action[action.ordinal()];
        JVM INSTR tableswitch 1 3: default 56
    //                   1 83
    //                   2 111
    //                   3 111;
           goto _L1 _L2 _L3 _L3
_L1:
        if (flag)
        {
            if (!s.equals(itemId))
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
        }
_L5:
        return flag1;
_L2:
        if (flag)
        {
            if (!s.equals(itemId))
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
            return flag1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag || ITEM_LEVEL_CODES.contains(Integer.valueOf(i)))
        {
            return true;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

}
