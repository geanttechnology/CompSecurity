// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.guest.interfaces.a:
//            b

public static final class mErrorCodes extends Enum
    implements j
{

    private static final ERR_UNKNOWN $VALUES[];
    public static final ERR_UNKNOWN ERR_ACCOUNT_IN_USE;
    public static final ERR_UNKNOWN ERR_ADDRESS2_LINE2_PATTERN;
    public static final ERR_UNKNOWN ERR_ADDRESS_ID_INVALID;
    public static final ERR_UNKNOWN ERR_ADDRESS_ID_PATTERN;
    public static final ERR_UNKNOWN ERR_ADDRESS_LINE1_PATTERN;
    public static final ERR_UNKNOWN ERR_ADDRESS_LINE1_REQUIRED;
    public static final ERR_UNKNOWN ERR_CARD_EXPIRY_MONTH_REQUIRED;
    public static final ERR_UNKNOWN ERR_CARD_EXPIRY_YEAR_REQUIRED;
    public static final ERR_UNKNOWN ERR_CARD_INFORMATION_INVALID;
    public static final ERR_UNKNOWN ERR_CARD_NAME_PATTERN;
    public static final ERR_UNKNOWN ERR_CARD_NAME_REQUIRED;
    public static final ERR_UNKNOWN ERR_CARD_NUMBER_INVALID;
    public static final ERR_UNKNOWN ERR_CARD_NUMBER_REQUIRED;
    public static final ERR_UNKNOWN ERR_CARD_TYPE_INVALID;
    public static final ERR_UNKNOWN ERR_CARD_TYPE_REQUIRED;
    public static final ERR_UNKNOWN ERR_CITY_PATTERN;
    public static final ERR_UNKNOWN ERR_CITY_REQUIRED;
    public static final ERR_UNKNOWN ERR_COUNTRY_REQUIRED;
    public static final ERR_UNKNOWN ERR_CVV_PATTERN;
    public static final ERR_UNKNOWN ERR_CVV_REQUIRED;
    public static final ERR_UNKNOWN ERR_FIRST_NAME_PATTERN;
    public static final ERR_UNKNOWN ERR_FIRST_NAME_REQUIRED;
    public static final ERR_UNKNOWN ERR_LAST_NAME_PATTERN;
    public static final ERR_UNKNOWN ERR_LAST_NAME_REQUIRED;
    public static final ERR_UNKNOWN ERR_PHONE_PATTERN;
    public static final ERR_UNKNOWN ERR_PHONE_REQUIRED;
    public static final ERR_UNKNOWN ERR_REAUTH_REQUIRED;
    public static final ERR_UNKNOWN ERR_STATE_MAX_LENGTH;
    public static final ERR_UNKNOWN ERR_STATE_REQUIRED;
    public static final ERR_UNKNOWN ERR_TC_PIN_PATTERN;
    public static final ERR_UNKNOWN ERR_TC_PIN_REQUIRED;
    public static final ERR_UNKNOWN ERR_TOKEN_EXPIRED;
    public static final ERR_UNKNOWN ERR_TOO_MANY_REQUESTS;
    public static final ERR_UNKNOWN ERR_UNKNOWN;
    public static final ERR_UNKNOWN ERR_ZIP_CODE_PATTERN;
    public static final ERR_UNKNOWN ERR_ZIP_CODE_REQUIRED;
    private c mErrorCodes[];

    public static mErrorCodes valueOf(String s)
    {
        return (mErrorCodes)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/b$a, s);
    }

    public static mErrorCodes[] values()
    {
        return (mErrorCodes[])$VALUES.clone();
    }

    public c[] a()
    {
        return mErrorCodes;
    }

    static 
    {
        ERR_CVV_REQUIRED = new <init>("ERR_CVV_REQUIRED", 0, new c[] {
            c._ERR_REQUIRED_CVV
        });
        ERR_CVV_PATTERN = new <init>("ERR_CVV_PATTERN", 1, new c[] {
            c._ERR_MIN_LENGTH_CVV, c._ERR_MAX_LENGTH_CVV, c._ERR_PATTERN_CVV
        });
        ERR_TC_PIN_REQUIRED = new <init>("ERR_TC_PIN_REQUIRED", 2, new c[] {
            c._ERR_REQUIRED_TCPINNUM
        });
        ERR_TC_PIN_PATTERN = new <init>("ERR_TC_PIN_PATTERN", 3, new c[] {
            c._ERR_PATTERN_TCPINNUM, c._ERR_MIN_LENGTH_TCPINNUM, c._ERR_MAX_LENGTH_TCPINNUM
        });
        ERR_CARD_TYPE_REQUIRED = new <init>("ERR_CARD_TYPE_REQUIRED", 4, new c[] {
            c._ERR_REQUIRED_CARDTYPE
        });
        ERR_CARD_TYPE_INVALID = new <init>("ERR_CARD_TYPE_INVALID", 5, new c[] {
            c._ERR_INVALID_CARDTYPE
        });
        ERR_CARD_NUMBER_REQUIRED = new <init>("ERR_CARD_NUMBER_REQUIRED", 6, new c[] {
            c._ERR_REQUIRED_CARDNUMBER
        });
        ERR_CARD_NUMBER_INVALID = new <init>("ERR_CARD_NUMBER_INVALID", 7, new c[] {
            c._ERR_INVALID_CARDNUMBER
        });
        ERR_CARD_INFORMATION_INVALID = new <init>("ERR_CARD_INFORMATION_INVALID", 8, new c[] {
            c._ERR_INVALID_CARD_INFORMATION
        });
        ERR_CARD_NAME_REQUIRED = new <init>("ERR_CARD_NAME_REQUIRED", 9, new c[] {
            c._ERR_REQUIRED_CARDNAME
        });
        ERR_CARD_NAME_PATTERN = new <init>("ERR_CARD_NAME_PATTERN", 10, new c[] {
            c._ERR_MAX_LENGTH_CARDNAME, c._ERR_PATTERN_CARDNAME
        });
        ERR_CARD_EXPIRY_MONTH_REQUIRED = new <init>("ERR_CARD_EXPIRY_MONTH_REQUIRED", 11, new c[] {
            c._ERR_REQUIRED_EXPIRYMONTH
        });
        ERR_CARD_EXPIRY_YEAR_REQUIRED = new <init>("ERR_CARD_EXPIRY_YEAR_REQUIRED", 12, new c[] {
            c._ERR_REQUIRED_EXPIRYYEAR
        });
        ERR_ADDRESS_ID_PATTERN = new <init>("ERR_ADDRESS_ID_PATTERN", 13, new c[] {
            c._ERR_PATTERN_ADDRESSID
        });
        ERR_ADDRESS_ID_INVALID = new <init>("ERR_ADDRESS_ID_INVALID", 14, new c[0]);
        ERR_FIRST_NAME_REQUIRED = new <init>("ERR_FIRST_NAME_REQUIRED", 15, new c[] {
            c._ERR_REQUIRED_FIRSTNAME
        });
        ERR_FIRST_NAME_PATTERN = new <init>("ERR_FIRST_NAME_PATTERN", 16, new c[] {
            c._ERR_MAX_LENGTH_FIRSTNAME, c._ERR_PATTERN_FIRSTNAME
        });
        ERR_LAST_NAME_REQUIRED = new <init>("ERR_LAST_NAME_REQUIRED", 17, new c[] {
            c._ERR_REQUIRED_LASTNAME
        });
        ERR_LAST_NAME_PATTERN = new <init>("ERR_LAST_NAME_PATTERN", 18, new c[] {
            c._ERR_MAX_LENGTH_LASTNAME, c._ERR_PATTERN_LASTNAME
        });
        ERR_ADDRESS_LINE1_REQUIRED = new <init>("ERR_ADDRESS_LINE1_REQUIRED", 19, new c[] {
            c._ERR_REQUIRED_ADDRESS1
        });
        ERR_ADDRESS_LINE1_PATTERN = new <init>("ERR_ADDRESS_LINE1_PATTERN", 20, new c[] {
            c._ERR_MAX_LENGTH_ADDRESS1, c._ERR_PATTERN_ADDRESS1
        });
        ERR_ADDRESS2_LINE2_PATTERN = new <init>("ERR_ADDRESS2_LINE2_PATTERN", 21, new c[] {
            c._ERR_MAX_LENGTH_ADDRESS2, c._ERR_PATTERN_ADDRESS2
        });
        ERR_CITY_REQUIRED = new <init>("ERR_CITY_REQUIRED", 22, new c[] {
            c._ERR_REQUIRED_CITY
        });
        ERR_CITY_PATTERN = new <init>("ERR_CITY_PATTERN", 23, new c[] {
            c._ERR_MAX_LENGTH_CITY, c._ERR_PATTERN_CITY
        });
        ERR_COUNTRY_REQUIRED = new <init>("ERR_COUNTRY_REQUIRED", 24, new c[] {
            c._ERR_REQUIRED_COUNTRY
        });
        ERR_STATE_REQUIRED = new <init>("ERR_STATE_REQUIRED", 25, new c[] {
            c._ERR_REQUIRED_STATE
        });
        ERR_STATE_MAX_LENGTH = new <init>("ERR_STATE_MAX_LENGTH", 26, new c[] {
            c._ERR_MAX_LENGTH_STATE
        });
        ERR_ZIP_CODE_REQUIRED = new <init>("ERR_ZIP_CODE_REQUIRED", 27, new c[] {
            c._ERR_REQUIRED_ZIPCODE
        });
        ERR_ZIP_CODE_PATTERN = new <init>("ERR_ZIP_CODE_PATTERN", 28, new c[] {
            c._ERR_MAX_LENGTH_ZIPCODE, c._ERR_PATTERN_ZIPCODE
        });
        ERR_PHONE_REQUIRED = new <init>("ERR_PHONE_REQUIRED", 29, new c[] {
            c._ERR_REQUIRED_PHONE
        });
        ERR_PHONE_PATTERN = new <init>("ERR_PHONE_PATTERN", 30, new c[] {
            c._ERR_PATTERN_PHONE
        });
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 31, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_REAUTH_REQUIRED = new <init>("ERR_REAUTH_REQUIRED", 32, new c[] {
            c.SCOPE_1_ACCESS_LEVEL_REQUIRED
        });
        ERR_ACCOUNT_IN_USE = new <init>("ERR_ACCOUNT_IN_USE", 33, new c[] {
            c._ERR_INVALID_COOKIE
        });
        ERR_TOO_MANY_REQUESTS = new <init>("ERR_TOO_MANY_REQUESTS", 34, new c[] {
            c.TAPI_VPA
        });
        ERR_UNKNOWN = new <init>("ERR_UNKNOWN", 35, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_CVV_REQUIRED, ERR_CVV_PATTERN, ERR_TC_PIN_REQUIRED, ERR_TC_PIN_PATTERN, ERR_CARD_TYPE_REQUIRED, ERR_CARD_TYPE_INVALID, ERR_CARD_NUMBER_REQUIRED, ERR_CARD_NUMBER_INVALID, ERR_CARD_INFORMATION_INVALID, ERR_CARD_NAME_REQUIRED, 
            ERR_CARD_NAME_PATTERN, ERR_CARD_EXPIRY_MONTH_REQUIRED, ERR_CARD_EXPIRY_YEAR_REQUIRED, ERR_ADDRESS_ID_PATTERN, ERR_ADDRESS_ID_INVALID, ERR_FIRST_NAME_REQUIRED, ERR_FIRST_NAME_PATTERN, ERR_LAST_NAME_REQUIRED, ERR_LAST_NAME_PATTERN, ERR_ADDRESS_LINE1_REQUIRED, 
            ERR_ADDRESS_LINE1_PATTERN, ERR_ADDRESS2_LINE2_PATTERN, ERR_CITY_REQUIRED, ERR_CITY_PATTERN, ERR_COUNTRY_REQUIRED, ERR_STATE_REQUIRED, ERR_STATE_MAX_LENGTH, ERR_ZIP_CODE_REQUIRED, ERR_ZIP_CODE_PATTERN, ERR_PHONE_REQUIRED, 
            ERR_PHONE_PATTERN, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mErrorCodes = ac;
    }
}
