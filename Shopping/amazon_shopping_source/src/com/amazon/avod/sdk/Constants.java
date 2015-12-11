// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;

import java.util.HashMap;
import java.util.Map;

public class Constants
{
    public static final class CallResponseType extends Enum
    {

        private static final CallResponseType $VALUES[];
        public static final CallResponseType FAILURE;
        private static final Map RESPONSE_CODE_MAP;
        public static final CallResponseType SUCCESS;
        private final int mCode;

        public static CallResponseType fromResponseCode(int i)
        {
            return (CallResponseType)RESPONSE_CODE_MAP.get(Integer.valueOf(i));
        }

        public static CallResponseType valueOf(String s)
        {
            return (CallResponseType)Enum.valueOf(com/amazon/avod/sdk/Constants$CallResponseType, s);
        }

        public static CallResponseType[] values()
        {
            return (CallResponseType[])$VALUES.clone();
        }

        public int getResponseCode()
        {
            return mCode;
        }

        static 
        {
            SUCCESS = new CallResponseType("SUCCESS", 0, 0);
            FAILURE = new CallResponseType("FAILURE", 1, 1);
            $VALUES = (new CallResponseType[] {
                SUCCESS, FAILURE
            });
            RESPONSE_CODE_MAP = new HashMap();
            RESPONSE_CODE_MAP.put(Integer.valueOf(SUCCESS.getResponseCode()), SUCCESS);
            RESPONSE_CODE_MAP.put(Integer.valueOf(FAILURE.getResponseCode()), FAILURE);
        }

        private CallResponseType(String s, int i, int j)
        {
            super(s, i);
            mCode = j;
        }
    }

    public static final class UrlType extends Enum
    {

        private static final UrlType $VALUES[];
        public static final UrlType CONTENT;
        public static final UrlType TRAILER;

        public static UrlType valueOf(String s)
        {
            return (UrlType)Enum.valueOf(com/amazon/avod/sdk/Constants$UrlType, s);
        }

        public static UrlType[] values()
        {
            return (UrlType[])$VALUES.clone();
        }

        static 
        {
            TRAILER = new UrlType("TRAILER", 0);
            CONTENT = new UrlType("CONTENT", 1);
            $VALUES = (new UrlType[] {
                TRAILER, CONTENT
            });
        }

        private UrlType(String s, int i)
        {
            super(s, i);
        }
    }


    public Constants()
    {
    }
}
