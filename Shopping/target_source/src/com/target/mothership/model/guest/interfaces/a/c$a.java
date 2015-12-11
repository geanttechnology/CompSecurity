// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.guest.interfaces.a:
//            c

public static final class mErrorCodes extends Enum
    implements j
{

    private static final ERR_UNKNOWN $VALUES[];
    public static final ERR_UNKNOWN ERR_ACCOUNT_IN_USE;
    public static final ERR_UNKNOWN ERR_ACCOUNT_LOCKED;
    public static final ERR_UNKNOWN ERR_INVALID_ACCOUNT_OR_PASSWORD;
    public static final ERR_UNKNOWN ERR_INVALID_EMAIL;
    public static final ERR_UNKNOWN ERR_REQUIRED_FIELD_EMAIL;
    public static final ERR_UNKNOWN ERR_REQUIRED_FIELD_PASSWORD;
    public static final ERR_UNKNOWN ERR_TOKEN_EXPIRED;
    public static final ERR_UNKNOWN ERR_TOO_MANY_REQUESTS;
    public static final ERR_UNKNOWN ERR_UNKNOWN;
    private c mErrorCodes[];

    public static mErrorCodes a(c c1)
    {
        mErrorCodes amerrorcodes[] = values();
        int l = amerrorcodes.length;
        for (int i = 0; i < l; i++)
        {
            mErrorCodes merrorcodes = amerrorcodes[i];
            c ac[] = merrorcodes.a();
            int i1 = ac.length;
            for (int k = 0; k < i1; k++)
            {
                if (ac[k] == c1)
                {
                    return merrorcodes;
                }
            }

        }

        return ERR_UNKNOWN;
    }

    public static ERR_UNKNOWN valueOf(String s)
    {
        return (ERR_UNKNOWN)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/c$a, s);
    }

    public static ERR_UNKNOWN[] values()
    {
        return (ERR_UNKNOWN[])$VALUES.clone();
    }

    public c[] a()
    {
        return mErrorCodes;
    }

    static 
    {
        ERR_ACCOUNT_LOCKED = new <init>("ERR_ACCOUNT_LOCKED", 0, new c[] {
            c._ERR_LOCKED_ACCOUNT
        });
        ERR_INVALID_ACCOUNT_OR_PASSWORD = new <init>("ERR_INVALID_ACCOUNT_OR_PASSWORD", 1, new c[] {
            c._ERR_INVALID_EMAILPASSWORD
        });
        ERR_INVALID_EMAIL = new <init>("ERR_INVALID_EMAIL", 2, new c[] {
            c._ERR_PATTERN_LOGON_ID
        });
        ERR_REQUIRED_FIELD_PASSWORD = new <init>("ERR_REQUIRED_FIELD_PASSWORD", 3, new c[] {
            c._ERR_REQUIRED_LOGON_PASSWORD
        });
        ERR_REQUIRED_FIELD_EMAIL = new <init>("ERR_REQUIRED_FIELD_EMAIL", 4, new c[] {
            c._ERR_REQUIRED_LOGON_ID
        });
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 5, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_ACCOUNT_IN_USE = new <init>("ERR_ACCOUNT_IN_USE", 6, new c[] {
            c._ERR_INVALID_COOKIE
        });
        ERR_TOO_MANY_REQUESTS = new <init>("ERR_TOO_MANY_REQUESTS", 7, new c[] {
            c.TAPI_VPA
        });
        ERR_UNKNOWN = new <init>("ERR_UNKNOWN", 8, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_ACCOUNT_LOCKED, ERR_INVALID_ACCOUNT_OR_PASSWORD, ERR_INVALID_EMAIL, ERR_REQUIRED_FIELD_PASSWORD, ERR_REQUIRED_FIELD_EMAIL, ERR_TOKEN_EXPIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mErrorCodes = ac;
    }
}
