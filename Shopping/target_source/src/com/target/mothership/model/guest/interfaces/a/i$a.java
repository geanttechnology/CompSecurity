// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.guest.interfaces.a:
//            i

public static final class mCodes extends Enum
    implements j
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ERR_ACCOUNT_IN_USE;
    public static final UNKNOWN ERR_NO_ORDER_HISTORY_DATA;
    public static final UNKNOWN ERR_REAUTH_REQUIRED;
    public static final UNKNOWN ERR_TOKEN_EXPIRED;
    public static final UNKNOWN ERR_TOO_MANY_REQUESTS;
    public static final UNKNOWN ERR_UNREGISTERED_USER;
    public static final UNKNOWN UNKNOWN;
    private c mCodes[];

    public static mCodes valueOf(String s)
    {
        return (mCodes)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/i$a, s);
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
        ERR_UNREGISTERED_USER = new <init>("ERR_UNREGISTERED_USER", 0, new c[] {
            c._ERR_UNREGISTERED_USER
        });
        ERR_NO_ORDER_HISTORY_DATA = new <init>("ERR_NO_ORDER_HISTORY_DATA", 1, new c[] {
            c.ERR_NO_ORDER_LIST_DATA
        });
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 2, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_REAUTH_REQUIRED = new <init>("ERR_REAUTH_REQUIRED", 3, new c[] {
            c.SCOPE_1_ACCESS_LEVEL_REQUIRED
        });
        ERR_ACCOUNT_IN_USE = new <init>("ERR_ACCOUNT_IN_USE", 4, new c[] {
            c._ERR_INVALID_COOKIE
        });
        ERR_TOO_MANY_REQUESTS = new <init>("ERR_TOO_MANY_REQUESTS", 5, new c[] {
            c.TAPI_VPA
        });
        UNKNOWN = new <init>("UNKNOWN", 6, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_UNREGISTERED_USER, ERR_NO_ORDER_HISTORY_DATA, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, UNKNOWN
        });
    }

    private transient (String s, int k, c ac[])
    {
        super(s, k);
        mCodes = ac;
    }
}
