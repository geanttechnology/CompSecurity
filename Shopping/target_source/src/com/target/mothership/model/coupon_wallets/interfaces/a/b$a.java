// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.coupon_wallets.interfaces.a:
//            b

public static final class mErrorCodes extends Enum
    implements j
{

    private static final ERR_UNKNOWN $VALUES[];
    public static final ERR_UNKNOWN ERR_TOKEN_EXPIRED;
    public static final ERR_UNKNOWN ERR_UNKNOWN;
    private c mErrorCodes[];

    public static mErrorCodes valueOf(String s)
    {
        return (mErrorCodes)Enum.valueOf(com/target/mothership/model/coupon_wallets/interfaces/a/b$a, s);
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
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 0, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_UNKNOWN = new <init>("ERR_UNKNOWN", 1, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_TOKEN_EXPIRED, ERR_UNKNOWN
        });
    }

    private transient A(String s, int i, c ac[])
    {
        super(s, i);
        mErrorCodes = ac;
    }
}
