// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;


public class PublicURLProcessException extends Exception
{
    public static final class PublicURLErrorCode extends Enum
    {

        private static final PublicURLErrorCode $VALUES[];
        public static final PublicURLErrorCode ERROR_CODE_ERROR_HOSTNAME;
        public static final PublicURLErrorCode ERROR_CODE_ERROR_PATH;
        public static final PublicURLErrorCode ERROR_CODE_NEED_SIGNIN;
        public static final PublicURLErrorCode ERROR_CODE_NEED_SWITCH_LOCALE;

        public static PublicURLErrorCode valueOf(String s)
        {
            return (PublicURLErrorCode)Enum.valueOf(com/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode, s);
        }

        public static PublicURLErrorCode[] values()
        {
            return (PublicURLErrorCode[])$VALUES.clone();
        }

        static 
        {
            ERROR_CODE_NEED_SWITCH_LOCALE = new PublicURLErrorCode("ERROR_CODE_NEED_SWITCH_LOCALE", 0);
            ERROR_CODE_NEED_SIGNIN = new PublicURLErrorCode("ERROR_CODE_NEED_SIGNIN", 1);
            ERROR_CODE_ERROR_HOSTNAME = new PublicURLErrorCode("ERROR_CODE_ERROR_HOSTNAME", 2);
            ERROR_CODE_ERROR_PATH = new PublicURLErrorCode("ERROR_CODE_ERROR_PATH", 3);
            $VALUES = (new PublicURLErrorCode[] {
                ERROR_CODE_NEED_SWITCH_LOCALE, ERROR_CODE_NEED_SIGNIN, ERROR_CODE_ERROR_HOSTNAME, ERROR_CODE_ERROR_PATH
            });
        }

        private PublicURLErrorCode(String s, int i)
        {
            super(s, i);
        }
    }


    private PublicURLErrorCode mErrorCode;

    public PublicURLProcessException(PublicURLErrorCode publicurlerrorcode)
    {
        mErrorCode = publicurlerrorcode;
    }

    public PublicURLErrorCode errorCode()
    {
        return mErrorCode;
    }
}
