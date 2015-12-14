// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import java.util.Locale;

public final class AccountManagerConstants
{
    public static final class GetCookiesParams extends GetParams
    {
    }

    public static final class GetCookiesParams.COOKIE_TYPE extends Enum
    {

        private static final GetCookiesParams.COOKIE_TYPE $VALUES[];
        public static final GetCookiesParams.COOKIE_TYPE COOKIE;
        public static final GetCookiesParams.COOKIE_TYPE DELEGATED_COOKIE;

        public static GetCookiesParams.COOKIE_TYPE valueOf(String s)
        {
            return (GetCookiesParams.COOKIE_TYPE)Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE, s);
        }

        public static GetCookiesParams.COOKIE_TYPE[] values()
        {
            return (GetCookiesParams.COOKIE_TYPE[])$VALUES.clone();
        }

        static 
        {
            COOKIE = new GetCookiesParams.COOKIE_TYPE("COOKIE", 0);
            DELEGATED_COOKIE = new GetCookiesParams.COOKIE_TYPE("DELEGATED_COOKIE", 1);
            $VALUES = (new GetCookiesParams.COOKIE_TYPE[] {
                COOKIE, DELEGATED_COOKIE
            });
        }

        private GetCookiesParams.COOKIE_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    public static class GetParams
    {
    }

    public static final class GetTokenParams extends GetParams
    {
    }

    public static final class GetTokenParams.TOKEN_TYPE extends Enum
    {

        private static final GetTokenParams.TOKEN_TYPE $VALUES[];
        public static final GetTokenParams.TOKEN_TYPE ACCESS_TOKEN;
        public static final GetTokenParams.TOKEN_TYPE DELEGATED_ACCESS_TOKEN;

        public static GetTokenParams.TOKEN_TYPE valueOf(String s)
        {
            return (GetTokenParams.TOKEN_TYPE)Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$GetTokenParams$TOKEN_TYPE, s);
        }

        public static GetTokenParams.TOKEN_TYPE[] values()
        {
            return (GetTokenParams.TOKEN_TYPE[])$VALUES.clone();
        }

        static 
        {
            ACCESS_TOKEN = new GetTokenParams.TOKEN_TYPE("ACCESS_TOKEN", 0);
            DELEGATED_ACCESS_TOKEN = new GetTokenParams.TOKEN_TYPE("DELEGATED_ACCESS_TOKEN", 1);
            $VALUES = (new GetTokenParams.TOKEN_TYPE[] {
                ACCESS_TOKEN, DELEGATED_ACCESS_TOKEN
            });
        }

        private GetTokenParams.TOKEN_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class LOCALE extends Enum
    {

        private static final LOCALE $VALUES[];
        public static final LOCALE CA;
        public static final LOCALE CN;
        public static final LOCALE DE;
        public static final LOCALE ES;
        public static final LOCALE FR;
        public static final LOCALE JP;
        private static final String LOCALE_SEPERATOR = "-";
        public static final LOCALE UK;
        public static final LOCALE US;

        public static LOCALE valueOf(String s)
        {
            return (LOCALE)Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$LOCALE, s);
        }

        public static LOCALE[] values()
        {
            return (LOCALE[])$VALUES.clone();
        }

        public String toUrlString()
        {
            if (!US.equals(this))
            {
                return (new StringBuilder()).append(name().toLowerCase(Locale.US)).append("-").toString();
            } else
            {
                return "";
            }
        }

        static 
        {
            US = new LOCALE("US", 0);
            DE = new LOCALE("DE", 1);
            UK = new LOCALE("UK", 2);
            JP = new LOCALE("JP", 3);
            FR = new LOCALE("FR", 4);
            CA = new LOCALE("CA", 5);
            ES = new LOCALE("ES", 6);
            CN = new LOCALE("CN", 7);
            $VALUES = (new LOCALE[] {
                US, DE, UK, JP, FR, CA, ES, CN
            });
        }

        private LOCALE(String s, int i)
        {
            super(s, i);
        }
    }

    public static class REGION_HINT extends Enum
    {

        private static final REGION_HINT $VALUES[];
        public static final REGION_HINT CN;
        public static final REGION_HINT EU;
        public static final REGION_HINT FE;
        public static final REGION_HINT NA;

        public static REGION_HINT valueOf(String s)
        {
            return (REGION_HINT)Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT, s);
        }

        public static REGION_HINT[] values()
        {
            return (REGION_HINT[])$VALUES.clone();
        }

        static 
        {
            NA = new REGION_HINT("NA", 0) {

                public String toString()
                {
                    return "NA";
                }

            };
            EU = new REGION_HINT("EU", 1) {

                public String toString()
                {
                    return "EU";
                }

            };
            CN = new REGION_HINT("CN", 2) {

                public String toString()
                {
                    return "CN";
                }

            };
            FE = new REGION_HINT("FE", 3) {

                public String toString()
                {
                    return "JP";
                }

            };
            $VALUES = (new REGION_HINT[] {
                NA, EU, CN, FE
            });
        }

        private REGION_HINT(String s, int i)
        {
            super(s, i);
        }

    }

    public static final class TOKEN_EXCHANGER_TYPE extends Enum
    {

        private static final TOKEN_EXCHANGER_TYPE $VALUES[];
        public static final TOKEN_EXCHANGER_TYPE DMS_FOR_ACCESS;
        public static final TOKEN_EXCHANGER_TYPE REFRESH_FOR_ACCESS;
        public static final TOKEN_EXCHANGER_TYPE REFRESH_FOR_COOKIES;

        public static TOKEN_EXCHANGER_TYPE valueOf(String s)
        {
            return (TOKEN_EXCHANGER_TYPE)Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$TOKEN_EXCHANGER_TYPE, s);
        }

        public static TOKEN_EXCHANGER_TYPE[] values()
        {
            return (TOKEN_EXCHANGER_TYPE[])$VALUES.clone();
        }

        static 
        {
            REFRESH_FOR_ACCESS = new TOKEN_EXCHANGER_TYPE("REFRESH_FOR_ACCESS", 0);
            DMS_FOR_ACCESS = new TOKEN_EXCHANGER_TYPE("DMS_FOR_ACCESS", 1);
            REFRESH_FOR_COOKIES = new TOKEN_EXCHANGER_TYPE("REFRESH_FOR_COOKIES", 2);
            $VALUES = (new TOKEN_EXCHANGER_TYPE[] {
                REFRESH_FOR_ACCESS, DMS_FOR_ACCESS, REFRESH_FOR_COOKIES
            });
        }

        private TOKEN_EXCHANGER_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

}
