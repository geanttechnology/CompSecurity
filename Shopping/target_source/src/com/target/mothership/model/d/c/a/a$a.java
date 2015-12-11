// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.d.c.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.d.c.a:
//            a

public static final class mErrorCodes extends Enum
    implements j
{

    private static final ERR_UNKNOWN $VALUES[];
    public static final ERR_UNKNOWN ERR_INVALID_ALARM_CODE;
    public static final ERR_UNKNOWN ERR_INVALID_STORE_ID;
    public static final ERR_UNKNOWN ERR_TOKEN_EXPIRED;
    public static final ERR_UNKNOWN ERR_UNKNOWN;
    private c mErrorCodes[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/model/d/c/a/a$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public c[] a()
    {
        return mErrorCodes;
    }

    static 
    {
        ERR_INVALID_STORE_ID = new <init>("ERR_INVALID_STORE_ID", 0, new c[] {
            c._ERR_INVALID_STORE_ID
        });
        ERR_INVALID_ALARM_CODE = new <init>("ERR_INVALID_ALARM_CODE", 1, new c[] {
            c._ERR_INVALID_ALARM_CODE
        });
        ERR_TOKEN_EXPIRED = new <init>("ERR_TOKEN_EXPIRED", 2, new c[] {
            c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
        });
        ERR_UNKNOWN = new <init>("ERR_UNKNOWN", 3, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_INVALID_STORE_ID, ERR_INVALID_ALARM_CODE, ERR_TOKEN_EXPIRED, ERR_UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mErrorCodes = ac;
    }
}
