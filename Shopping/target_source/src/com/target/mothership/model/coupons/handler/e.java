// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.util.o;

public final class e extends Enum
{

    private static final e $VALUES[];
    public static final e AUTH_FAILURE;
    public static final e BAD_CREDENTIALS;
    public static final e BAD_INSTANCE_KEY;
    public static final e DENIED;
    public static final e DISABLED;
    public static final e EXPIRED;
    public static final e FAILED;
    public static final e MISMATCH;
    public static final e MUST_REQUEST_UID;
    public static final e NO_SMS_DELIVERY_DETAILS;
    public static final e OK;
    public static final e OPERATOR_UNSUPPORTED;
    public static final e PHONE_ERROR;
    public static final e PROVIDER_NOT_FOUND;
    public static final e QUEUED;
    public static final e SERVER_ERROR;
    public static final e SMS_DELIVERY_FAILED;
    public static final e UNKNOWN;
    public static final e UNSUPPORTED;
    private String mValue;

    private e(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static e a(String s)
    {
        if (o.g(s)) goto _L2; else goto _L1
_L1:
        e e1 = UNKNOWN;
_L4:
        return e1;
_L2:
        e ae[] = values();
        int j = ae.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                e e2 = ae[i];
                e1 = e2;
                if (s.equalsIgnoreCase(e2.a()))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return UNKNOWN;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/target/mothership/model/coupons/handler/e, s);
    }

    public static e[] values()
    {
        return (e[])$VALUES.clone();
    }

    public String a()
    {
        return mValue;
    }

    static 
    {
        OK = new e("OK", 0, "0");
        QUEUED = new e("QUEUED", 1, "2");
        FAILED = new e("FAILED", 2, "4");
        SERVER_ERROR = new e("SERVER_ERROR", 3, "8");
        UNSUPPORTED = new e("UNSUPPORTED", 4, "24");
        PHONE_ERROR = new e("PHONE_ERROR", 5, "68");
        OPERATOR_UNSUPPORTED = new e("OPERATOR_UNSUPPORTED", 6, "84");
        BAD_CREDENTIALS = new e("BAD_CREDENTIALS", 7, "136");
        PROVIDER_NOT_FOUND = new e("PROVIDER_NOT_FOUND", 8, "260");
        AUTH_FAILURE = new e("AUTH_FAILURE", 9, "264");
        DISABLED = new e("DISABLED", 10, "340");
        NO_SMS_DELIVERY_DETAILS = new e("NO_SMS_DELIVERY_DETAILS", 11, "388");
        SMS_DELIVERY_FAILED = new e("SMS_DELIVERY_FAILED", 12, "404");
        DENIED = new e("DENIED", 13, "420");
        EXPIRED = new e("EXPIRED", 14, "452");
        MISMATCH = new e("MISMATCH", 15, "468");
        BAD_INSTANCE_KEY = new e("BAD_INSTANCE_KEY", 16, "324");
        MUST_REQUEST_UID = new e("MUST_REQUEST_UID", 17, "436");
        UNKNOWN = new e("UNKNOWN", 18, "");
        $VALUES = (new e[] {
            OK, QUEUED, FAILED, SERVER_ERROR, UNSUPPORTED, PHONE_ERROR, OPERATOR_UNSUPPORTED, BAD_CREDENTIALS, PROVIDER_NOT_FOUND, AUTH_FAILURE, 
            DISABLED, NO_SMS_DELIVERY_DETAILS, SMS_DELIVERY_FAILED, DENIED, EXPIRED, MISMATCH, BAD_INSTANCE_KEY, MUST_REQUEST_UID, UNKNOWN
        });
    }
}
