// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.guest.interfaces.a:
//            e

public static final class mCodes extends Enum
    implements j
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ERR_ACCOUNT_IN_USE;
    public static final UNKNOWN ERR_ADDRESS_LINE1_MAX_LENGTH;
    public static final UNKNOWN ERR_ADDRESS_LINE1_PATTERN;
    public static final UNKNOWN ERR_ADDRESS_LINE1_REQUIRED;
    public static final UNKNOWN ERR_ADDRESS_LINE2_MAX_LENGTH;
    public static final UNKNOWN ERR_ADDRESS_LINE2_PATTERN;
    public static final UNKNOWN ERR_CITY_MAX_LENGTH;
    public static final UNKNOWN ERR_CITY_PATTERN;
    public static final UNKNOWN ERR_CITY_REQUIRED;
    public static final UNKNOWN ERR_FIRSTNAME_MAX_LENGTH;
    public static final UNKNOWN ERR_FIRSTNAME_PATTERN;
    public static final UNKNOWN ERR_FIRSTNAME_REQUIRED;
    public static final UNKNOWN ERR_LASTNAME_MAX_LENGTH;
    public static final UNKNOWN ERR_LASTNAME_PATTERN;
    public static final UNKNOWN ERR_LASTNAME_REQUIRED;
    public static final UNKNOWN ERR_MIDDLENAME_MAX_LENGTH;
    public static final UNKNOWN ERR_MIDDLENAME_PATTERN;
    public static final UNKNOWN ERR_PHONE_PATTERN;
    public static final UNKNOWN ERR_PHONE_REQUIRED;
    public static final UNKNOWN ERR_REAUTH_REQUIRED;
    public static final UNKNOWN ERR_STATE_PATTERN;
    public static final UNKNOWN ERR_STATE_REQUIRED;
    public static final UNKNOWN ERR_TOKEN_EXPIRED;
    public static final UNKNOWN ERR_TOO_MANY_REQUESTS;
    public static final UNKNOWN ERR_ZIPCODE_MAX_LENGTH;
    public static final UNKNOWN ERR_ZIPCODE_PATTERN;
    public static final UNKNOWN ERR_ZIPCODE_REQUIRED;
    public static final UNKNOWN UNKNOWN;
    private c mCodes[];

    public static mCodes valueOf(String s)
    {
        return (mCodes)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/e$a, s);
    }

    public static mCodes[] values()
    {
        return (mCodes[])$VALUES.clone();
    }

    public c[] a()
    {
        return mCodes;
    }

    static 
    {
        ERR_FIRSTNAME_REQUIRED = new <init>("ERR_FIRSTNAME_REQUIRED", 0, new c[] {
            c._ERR_REQUIRED_FIRSTNAME
        });
        ERR_FIRSTNAME_MAX_LENGTH = new <init>("ERR_FIRSTNAME_MAX_LENGTH", 1, new c[] {
            c._ERR_MAX_LENGTH_FIRSTNAME
        });
        ERR_FIRSTNAME_PATTERN = new <init>("ERR_FIRSTNAME_PATTERN", 2, new c[] {
            c._ERR_PATTERN_FIRSTNAME
        });
        ERR_MIDDLENAME_PATTERN = new <init>("ERR_MIDDLENAME_PATTERN", 3, new c[] {
            c._ERR_PATTERN_MIDDLENAME
        });
        ERR_MIDDLENAME_MAX_LENGTH = new <init>("ERR_MIDDLENAME_MAX_LENGTH", 4, new c[] {
            c._ERR_MAX_LENGTH_MIDDLENAME
        });
        ERR_LASTNAME_REQUIRED = new <init>("ERR_LASTNAME_REQUIRED", 5, new c[] {
            c._ERR_REQUIRED_LASTNAME
        });
        ERR_LASTNAME_PATTERN = new <init>("ERR_LASTNAME_PATTERN", 6, new c[] {
            c._ERR_PATTERN_LASTNAME
        });
        ERR_LASTNAME_MAX_LENGTH = new <init>("ERR_LASTNAME_MAX_LENGTH", 7, new c[] {
            c._ERR_MAX_LENGTH_LASTNAME
        });
        ERR_ADDRESS_LINE1_REQUIRED = new <init>("ERR_ADDRESS_LINE1_REQUIRED", 8, new c[] {
            c._ERR_REQUIRED_ADDRESS1
        });
        ERR_ADDRESS_LINE1_PATTERN = new <init>("ERR_ADDRESS_LINE1_PATTERN", 9, new c[] {
            c._ERR_PATTERN_ADDRESS1
        });
        ERR_ADDRESS_LINE1_MAX_LENGTH = new <init>("ERR_ADDRESS_LINE1_MAX_LENGTH", 10, new c[] {
            c._ERR_MAX_LENGTH_ADDRESS1
        });
        ERR_ADDRESS_LINE2_PATTERN = new <init>("ERR_ADDRESS_LINE2_PATTERN", 11, new c[] {
            c._ERR_PATTERN_ADDRESS2
        });
        ERR_ADDRESS_LINE2_MAX_LENGTH = new <init>("ERR_ADDRESS_LINE2_MAX_LENGTH", 12, new c[] {
            c._ERR_MAX_LENGTH_ADDRESS2
        });
        ERR_CITY_REQUIRED = new <init>("ERR_CITY_REQUIRED", 13, new c[] {
            c._ERR_REQUIRED_CITY
        });
        ERR_CITY_PATTERN = new <init>("ERR_CITY_PATTERN", 14, new c[] {
            c._ERR_PATTERN_CITY
        });
        ERR_CITY_MAX_LENGTH = new <init>("ERR_CITY_MAX_LENGTH", 15, new c[] {
            c._ERR_MAX_LENGTH_CITY
        });
        ERR_STATE_REQUIRED = new <init>("ERR_STATE_REQUIRED", 16, new c[] {
            c._ERR_REQUIRED_STATE
        });
        ERR_STATE_PATTERN = new <init>("ERR_STATE_PATTERN", 17, new c[] {
            c._ERR_MAX_LENGTH_STATE
        });
        ERR_ZIPCODE_REQUIRED = new <init>("ERR_ZIPCODE_REQUIRED", 18, new c[] {
            c._ERR_REQUIRED_ZIPCODE
        });
        ERR_ZIPCODE_PATTERN = new <init>("ERR_ZIPCODE_PATTERN", 19, new c[] {
            c._ERR_PATTERN_ZIPCODE
        });
        ERR_ZIPCODE_MAX_LENGTH = new <init>("ERR_ZIPCODE_MAX_LENGTH", 20, new c[] {
            c._ERR_MAX_LENGTH_ZIPCODE
        });
        ERR_PHONE_REQUIRED = new <init>("ERR_PHONE_REQUIRED", 21, new c[] {
            c._ERR_REQUIRED_PHONE
        });
        ERR_PHONE_PATTERN = new <init>("ERR_PHONE_PATTERN", 22, new c[] {
            c._ERR_PATTERN_PHONE
        });
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 23, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_REAUTH_REQUIRED = new <init>("ERR_REAUTH_REQUIRED", 24, new c[] {
            c.SCOPE_1_ACCESS_LEVEL_REQUIRED
        });
        ERR_ACCOUNT_IN_USE = new <init>("ERR_ACCOUNT_IN_USE", 25, new c[] {
            c._ERR_INVALID_COOKIE
        });
        ERR_TOO_MANY_REQUESTS = new <init>("ERR_TOO_MANY_REQUESTS", 26, new c[] {
            c.TAPI_VPA
        });
        UNKNOWN = new <init>("UNKNOWN", 27, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_FIRSTNAME_REQUIRED, ERR_FIRSTNAME_MAX_LENGTH, ERR_FIRSTNAME_PATTERN, ERR_MIDDLENAME_PATTERN, ERR_MIDDLENAME_MAX_LENGTH, ERR_LASTNAME_REQUIRED, ERR_LASTNAME_PATTERN, ERR_LASTNAME_MAX_LENGTH, ERR_ADDRESS_LINE1_REQUIRED, ERR_ADDRESS_LINE1_PATTERN, 
            ERR_ADDRESS_LINE1_MAX_LENGTH, ERR_ADDRESS_LINE2_PATTERN, ERR_ADDRESS_LINE2_MAX_LENGTH, ERR_CITY_REQUIRED, ERR_CITY_PATTERN, ERR_CITY_MAX_LENGTH, ERR_STATE_REQUIRED, ERR_STATE_PATTERN, ERR_ZIPCODE_REQUIRED, ERR_ZIPCODE_PATTERN, 
            ERR_ZIPCODE_MAX_LENGTH, ERR_PHONE_REQUIRED, ERR_PHONE_PATTERN, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mCodes = ac;
    }
}
