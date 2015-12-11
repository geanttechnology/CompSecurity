// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.guest.interfaces.a:
//            k

public static final class mCodes extends Enum
    implements j
{

    private static final ERR_UNKNOWN $VALUES[];
    public static final ERR_UNKNOWN ERR_ACCOUNT_IN_USE;
    public static final ERR_UNKNOWN ERR_MEMBER_CARD_INFO_ID_INVALID;
    public static final ERR_UNKNOWN ERR_MEMBER_CARD_INFO_ID_PATTERN;
    public static final ERR_UNKNOWN ERR_MEMBER_CARD_INFO_ID_REQUIRED;
    public static final ERR_UNKNOWN ERR_PAYMENT_TYPE_INVALID;
    public static final ERR_UNKNOWN ERR_PAYMENT_TYPE_REQUIRED;
    public static final ERR_UNKNOWN ERR_REAUTH_REQUIRED;
    public static final ERR_UNKNOWN ERR_TOKEN_EXPIRED;
    public static final ERR_UNKNOWN ERR_TOO_MANY_REQUESTS;
    public static final ERR_UNKNOWN ERR_UNKNOWN;
    private c mCodes[];

    public static mCodes valueOf(String s)
    {
        return (mCodes)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/k$a, s);
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
        ERR_MEMBER_CARD_INFO_ID_REQUIRED = new <init>("ERR_MEMBER_CARD_INFO_ID_REQUIRED", 0, new c[] {
            c._ERR_REQUIRED_MEMBERCARDINFOID
        });
        ERR_MEMBER_CARD_INFO_ID_PATTERN = new <init>("ERR_MEMBER_CARD_INFO_ID_PATTERN", 1, new c[] {
            c._ERR_PATTERN_MEMBERCARDINFOID
        });
        ERR_MEMBER_CARD_INFO_ID_INVALID = new <init>("ERR_MEMBER_CARD_INFO_ID_INVALID", 2, new c[] {
            c._ERR_CMD_INVALID_PARAM
        });
        ERR_PAYMENT_TYPE_REQUIRED = new <init>("ERR_PAYMENT_TYPE_REQUIRED", 3, new c[] {
            c._ERR_REQUIRED_PAYMENT_TYPE
        });
        ERR_PAYMENT_TYPE_INVALID = new <init>("ERR_PAYMENT_TYPE_INVALID", 4, new c[] {
            c._ERR_INVALID_PAYMENT_TYPE
        });
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 5, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_REAUTH_REQUIRED = new <init>("ERR_REAUTH_REQUIRED", 6, new c[] {
            c.SCOPE_1_ACCESS_LEVEL_REQUIRED
        });
        ERR_ACCOUNT_IN_USE = new <init>("ERR_ACCOUNT_IN_USE", 7, new c[] {
            c._ERR_INVALID_COOKIE
        });
        ERR_TOO_MANY_REQUESTS = new <init>("ERR_TOO_MANY_REQUESTS", 8, new c[] {
            c.TAPI_VPA
        });
        ERR_UNKNOWN = new <init>("ERR_UNKNOWN", 9, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_MEMBER_CARD_INFO_ID_REQUIRED, ERR_MEMBER_CARD_INFO_ID_PATTERN, ERR_MEMBER_CARD_INFO_ID_INVALID, ERR_PAYMENT_TYPE_REQUIRED, ERR_PAYMENT_TYPE_INVALID, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mCodes = ac;
    }
}
