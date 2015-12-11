// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;


// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerConstants

public static final class COOKIE_TYPE extends COOKIE_TYPE
{
    public static final class COOKIE_TYPE extends Enum
    {

        private static final COOKIE_TYPE $VALUES[];
        public static final COOKIE_TYPE COOKIE;
        public static final COOKIE_TYPE DELEGATED_COOKIE;

        public static COOKIE_TYPE valueOf(String s)
        {
            return (COOKIE_TYPE)Enum.valueOf(com/amazon/identity/auth/accounts/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE, s);
        }

        public static COOKIE_TYPE[] values()
        {
            return (COOKIE_TYPE[])$VALUES.clone();
        }

        static 
        {
            COOKIE = new COOKIE_TYPE("COOKIE", 0);
            DELEGATED_COOKIE = new COOKIE_TYPE("DELEGATED_COOKIE", 1);
            $VALUES = (new COOKIE_TYPE[] {
                COOKIE, DELEGATED_COOKIE
            });
        }

        private COOKIE_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

}
