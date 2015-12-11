// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.guest.interfaces.a:
//            d

public static final class mErrors extends Enum
    implements j
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ERR_FIRST_NAME_MAX_LENGTH;
    public static final UNKNOWN ERR_FIRST_NAME_PATTERN;
    public static final UNKNOWN ERR_FIRST_NAME_REQUIRED;
    public static final UNKNOWN ERR_LAST_NAME_MAX_LENGTH;
    public static final UNKNOWN ERR_LAST_NAME_PATTERN;
    public static final UNKNOWN ERR_LAST_NAME_REQUIRED;
    public static final UNKNOWN ERR_LOGIN_ID_ALREADY_EXISTS;
    public static final UNKNOWN ERR_LOGIN_ID_MAX_LENGTH;
    public static final UNKNOWN ERR_LOGIN_ID_PATTERN;
    public static final UNKNOWN ERR_LOGIN_ID_REQUIRED;
    public static final UNKNOWN ERR_PASSWORD_CONFIRM_MAX_LENGTH;
    public static final UNKNOWN ERR_PASSWORD_CONFIRM_MISMATCH;
    public static final UNKNOWN ERR_PASSWORD_CONFIRM_PATTERN;
    public static final UNKNOWN ERR_PASSWORD_CONFIRM_REQUIRED;
    public static final UNKNOWN ERR_PASSWORD_MAX_LENGTH;
    public static final UNKNOWN ERR_PASSWORD_PATTERN;
    public static final UNKNOWN ERR_PASSWORD_REQUIRED;
    public static final UNKNOWN ERR_TOO_MANY_REQUESTS;
    public static final UNKNOWN UNKNOWN;
    private c mErrors[];

    public static mErrors valueOf(String s)
    {
        return (mErrors)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/d$a, s);
    }

    public static mErrors[] values()
    {
        return (mErrors[])$VALUES.clone();
    }

    public c[] a()
    {
        return mErrors;
    }

    static 
    {
        ERR_FIRST_NAME_MAX_LENGTH = new <init>("ERR_FIRST_NAME_MAX_LENGTH", 0, new c[] {
            c._ERR_MAX_LENGTH_FIRSTNAME
        });
        ERR_FIRST_NAME_PATTERN = new <init>("ERR_FIRST_NAME_PATTERN", 1, new c[] {
            c._ERR_PATTERN_FIRSTNAME
        });
        ERR_FIRST_NAME_REQUIRED = new <init>("ERR_FIRST_NAME_REQUIRED", 2, new c[] {
            c._ERR_REQUIRED_FIRSTNAME
        });
        ERR_LAST_NAME_MAX_LENGTH = new <init>("ERR_LAST_NAME_MAX_LENGTH", 3, new c[] {
            c._ERR_MAX_LENGTH_LASTNAME
        });
        ERR_LAST_NAME_PATTERN = new <init>("ERR_LAST_NAME_PATTERN", 4, new c[] {
            c._ERR_PATTERN_LASTNAME
        });
        ERR_LAST_NAME_REQUIRED = new <init>("ERR_LAST_NAME_REQUIRED", 5, new c[] {
            c._ERR_REQUIRED_LASTNAME
        });
        ERR_LOGIN_ID_MAX_LENGTH = new <init>("ERR_LOGIN_ID_MAX_LENGTH", 6, new c[] {
            c._ERR_MAX_LENGTH_LOGONID
        });
        ERR_LOGIN_ID_PATTERN = new <init>("ERR_LOGIN_ID_PATTERN", 7, new c[] {
            c._ERR_PATTERN_LOGONID
        });
        ERR_LOGIN_ID_REQUIRED = new <init>("ERR_LOGIN_ID_REQUIRED", 8, new c[] {
            c._ERR_REQUIRED_LOGONID
        });
        ERR_LOGIN_ID_ALREADY_EXISTS = new <init>("ERR_LOGIN_ID_ALREADY_EXISTS", 9, new c[] {
            c._ERR_LOGONID_ALREADY_EXIST
        });
        ERR_PASSWORD_MAX_LENGTH = new <init>("ERR_PASSWORD_MAX_LENGTH", 10, new c[] {
            c._ERR_MAX_LENGTH_LOGONPASSWORD
        });
        ERR_PASSWORD_PATTERN = new <init>("ERR_PASSWORD_PATTERN", 11, new c[] {
            c._ERR_PATTERN_LOGONPASSWORD
        });
        ERR_PASSWORD_REQUIRED = new <init>("ERR_PASSWORD_REQUIRED", 12, new c[] {
            c._ERR_REQUIRED_LOGONPASSWORD
        });
        ERR_PASSWORD_CONFIRM_MAX_LENGTH = new <init>("ERR_PASSWORD_CONFIRM_MAX_LENGTH", 13, new c[] {
            c._ERR_MAX_LENGTH_LOGONPASSWORDVERIFY
        });
        ERR_PASSWORD_CONFIRM_PATTERN = new <init>("ERR_PASSWORD_CONFIRM_PATTERN", 14, new c[] {
            c._ERR_PATTERN_LOGONPASSWORDVERIFY
        });
        ERR_PASSWORD_CONFIRM_REQUIRED = new <init>("ERR_PASSWORD_CONFIRM_REQUIRED", 15, new c[] {
            c._ERR_REQUIRED_LOGONPASSWORDVERIFY
        });
        ERR_PASSWORD_CONFIRM_MISMATCH = new <init>("ERR_PASSWORD_CONFIRM_MISMATCH", 16, new c[] {
            c._ERR_MISMATCH_LOGONPASSWORDVERIFY
        });
        ERR_TOO_MANY_REQUESTS = new <init>("ERR_TOO_MANY_REQUESTS", 17, new c[] {
            c.TAPI_VPA
        });
        UNKNOWN = new <init>("UNKNOWN", 18, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERR_FIRST_NAME_MAX_LENGTH, ERR_FIRST_NAME_PATTERN, ERR_FIRST_NAME_REQUIRED, ERR_LAST_NAME_MAX_LENGTH, ERR_LAST_NAME_PATTERN, ERR_LAST_NAME_REQUIRED, ERR_LOGIN_ID_MAX_LENGTH, ERR_LOGIN_ID_PATTERN, ERR_LOGIN_ID_REQUIRED, ERR_LOGIN_ID_ALREADY_EXISTS, 
            ERR_PASSWORD_MAX_LENGTH, ERR_PASSWORD_PATTERN, ERR_PASSWORD_REQUIRED, ERR_PASSWORD_CONFIRM_MAX_LENGTH, ERR_PASSWORD_CONFIRM_PATTERN, ERR_PASSWORD_CONFIRM_REQUIRED, ERR_PASSWORD_CONFIRM_MISMATCH, ERR_TOO_MANY_REQUESTS, UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mErrors = ac;
    }
}
