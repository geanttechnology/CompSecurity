// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;


// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerConstants

public static final class TOKEN_TYPE extends TOKEN_TYPE
{
    public static final class TOKEN_TYPE extends Enum
    {

        private static final TOKEN_TYPE $VALUES[];
        public static final TOKEN_TYPE ACCESS_TOKEN;
        public static final TOKEN_TYPE DELEGATED_ACCESS_TOKEN;

        public static TOKEN_TYPE valueOf(String s)
        {
            return (TOKEN_TYPE)Enum.valueOf(com/amazon/identity/auth/accounts/AccountManagerConstants$GetTokenParams$TOKEN_TYPE, s);
        }

        public static TOKEN_TYPE[] values()
        {
            return (TOKEN_TYPE[])$VALUES.clone();
        }

        static 
        {
            ACCESS_TOKEN = new TOKEN_TYPE("ACCESS_TOKEN", 0);
            DELEGATED_ACCESS_TOKEN = new TOKEN_TYPE("DELEGATED_ACCESS_TOKEN", 1);
            $VALUES = (new TOKEN_TYPE[] {
                ACCESS_TOKEN, DELEGATED_ACCESS_TOKEN
            });
        }

        private TOKEN_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

}
