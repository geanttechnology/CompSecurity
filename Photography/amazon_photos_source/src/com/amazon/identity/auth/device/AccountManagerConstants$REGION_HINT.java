// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;


// Referenced classes of package com.amazon.identity.auth.device:
//            AccountManagerConstants

public static class <init> extends Enum
{

    private static final FE $VALUES[];
    public static final FE CN;
    public static final FE EU;
    public static final FE FE;
    public static final FE NA;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    static 
    {
        NA = new AccountManagerConstants.REGION_HINT("NA", 0) {

            public String toString()
            {
                return "NA";
            }

        };
        EU = new AccountManagerConstants.REGION_HINT("EU", 1) {

            public String toString()
            {
                return "EU";
            }

        };
        CN = new AccountManagerConstants.REGION_HINT("CN", 2) {

            public String toString()
            {
                return "CN";
            }

        };
        FE = new AccountManagerConstants.REGION_HINT("FE", 3) {

            public String toString()
            {
                return "JP";
            }

        };
        $VALUES = (new .VALUES[] {
            NA, EU, CN, FE
        });
    }

    private _cls4(String s, int i)
    {
        super(s, i);
    }

    _cls4(String s, int i, _cls4 _pcls4)
    {
        this(s, i);
    }
}
