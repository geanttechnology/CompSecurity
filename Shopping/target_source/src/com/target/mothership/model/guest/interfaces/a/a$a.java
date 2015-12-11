// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.guest.interfaces.a:
//            a

public static final class mErrorCodes extends Enum
    implements j
{

    private static final ERR_UNKNOWN $VALUES[];
    public static final ERR_UNKNOWN ERR_ACCOUNT_IN_USE;
    public static final ERR_UNKNOWN ERR_GIFT_CARD_ACCESS_NUMBER_INVALID;
    public static final ERR_UNKNOWN ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN;
    public static final ERR_UNKNOWN ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED;
    public static final ERR_UNKNOWN ERR_GIFT_CARD_ALREADY_ADDED;
    public static final ERR_UNKNOWN ERR_GIFT_CARD_NUMBER_INVALID;
    public static final ERR_UNKNOWN ERR_GIFT_CARD_NUMBER_PATTERN;
    public static final ERR_UNKNOWN ERR_GIFT_CARD_NUMBER_REQUIRED;
    public static final ERR_UNKNOWN ERR_REAUTH_REQUIRED;
    public static final ERR_UNKNOWN ERR_TOKEN_EXPIRED;
    public static final ERR_UNKNOWN ERR_TOO_MANY_REQUESTS;
    public static final ERR_UNKNOWN ERR_UNKNOWN;
    private c mErrorCodes[];

    public static mErrorCodes valueOf(String s)
    {
        return (mErrorCodes)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/a$a, s);
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
        ERR_GIFT_CARD_NUMBER_REQUIRED = new <init>("ERR_GIFT_CARD_NUMBER_REQUIRED", 0, new c[] {
            c._ERR_REQUIRED_GIFTCARDNUMBER
        });
        ERR_GIFT_CARD_NUMBER_INVALID = new <init>("ERR_GIFT_CARD_NUMBER_INVALID", 1, new c[] {
            c._ERR_AMZ_GIFTCARD_NUMBER
        });
        ERR_GIFT_CARD_NUMBER_PATTERN = new <init>("ERR_GIFT_CARD_NUMBER_PATTERN", 2, new c[] {
            c._ERR_PATTERN_GIFTCARDNUMBER, c._ERR_MAX_LENGTH_GIFTCARDNUMBER, c._ERR_MIN_LENGTH_GIFTCARDNUMBER
        });
        ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED = new <init>("ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED", 3, new c[] {
            c._ERR_REQUIRED_ACCESSNUMBER
        });
        ERR_GIFT_CARD_ACCESS_NUMBER_INVALID = new <init>("ERR_GIFT_CARD_ACCESS_NUMBER_INVALID", 4, new c[] {
            c._ERR_INVALID_GIFTCARD_ACCESS_NUMBER
        });
        ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN = new <init>("ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN", 5, new c[] {
            c._ERR_PATTERN_ACCESSNUMBER, c._ERR_LENGTH_ACCESSNUMBER
        });
        ERR_GIFT_CARD_ALREADY_ADDED = new <init>("ERR_GIFT_CARD_ALREADY_ADDED", 6, new c[] {
            c.ERR_DUPLICATECARD_EXCEPTION
        });
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 7, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_REAUTH_REQUIRED = new <init>("ERR_REAUTH_REQUIRED", 8, new c[] {
            c.SCOPE_1_ACCESS_LEVEL_REQUIRED
        });
        ERR_ACCOUNT_IN_USE = new <init>("ERR_ACCOUNT_IN_USE", 9, new c[] {
            c._ERR_INVALID_COOKIE
        });
        ERR_TOO_MANY_REQUESTS = new <init>("ERR_TOO_MANY_REQUESTS", 10, new c[] {
            c.TAPI_VPA
        });
        ERR_UNKNOWN = new <init>("ERR_UNKNOWN", 11, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_GIFT_CARD_NUMBER_REQUIRED, ERR_GIFT_CARD_NUMBER_INVALID, ERR_GIFT_CARD_NUMBER_PATTERN, ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED, ERR_GIFT_CARD_ACCESS_NUMBER_INVALID, ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN, ERR_GIFT_CARD_ALREADY_ADDED, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, 
            ERR_TOO_MANY_REQUESTS, ERR_UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mErrorCodes = ac;
    }
}
