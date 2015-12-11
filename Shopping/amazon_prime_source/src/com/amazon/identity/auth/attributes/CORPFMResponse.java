// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class CORPFMResponse
{
    public static final class ComputationConfidenceValue extends Enum
    {

        private static final ComputationConfidenceValue $VALUES[];
        public static final ComputationConfidenceValue CUSTOMER_BASED_GUESS;
        public static final ComputationConfidenceValue CUSTOMER_PROVIDED;
        public static final ComputationConfidenceValue DEVICE_BASED_GUESS;
        private static final Map LOOKUP_BY_VALUE;
        private final boolean mIsGuess;
        private final String mValue;

        public static ComputationConfidenceValue parseFromValue(String s, ComputationConfidenceValue computationconfidencevalue)
        {
            s = (ComputationConfidenceValue)LOOKUP_BY_VALUE.get(s);
            if (s != null)
            {
                return s;
            } else
            {
                return computationconfidencevalue;
            }
        }

        public static ComputationConfidenceValue valueOf(String s)
        {
            return (ComputationConfidenceValue)Enum.valueOf(com/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue, s);
        }

        public static ComputationConfidenceValue[] values()
        {
            return (ComputationConfidenceValue[])$VALUES.clone();
        }

        public String getValue()
        {
            return mValue;
        }

        public boolean isGuess()
        {
            return mIsGuess;
        }

        static 
        {
            CUSTOMER_PROVIDED = new ComputationConfidenceValue("CUSTOMER_PROVIDED", 0, "CUSTOMER_PROVIDED", false);
            CUSTOMER_BASED_GUESS = new ComputationConfidenceValue("CUSTOMER_BASED_GUESS", 1, "CUSTOMER_BASED_GUESS", true);
            DEVICE_BASED_GUESS = new ComputationConfidenceValue("DEVICE_BASED_GUESS", 2, "DEVICE_BASED_GUESS", true);
            $VALUES = (new ComputationConfidenceValue[] {
                CUSTOMER_PROVIDED, CUSTOMER_BASED_GUESS, DEVICE_BASED_GUESS
            });
            LOOKUP_BY_VALUE = new HashMap();
            ComputationConfidenceValue acomputationconfidencevalue[] = values();
            int j = acomputationconfidencevalue.length;
            for (int i = 0; i < j; i++)
            {
                ComputationConfidenceValue computationconfidencevalue = acomputationconfidencevalue[i];
                LOOKUP_BY_VALUE.put(computationconfidencevalue.getValue(), computationconfidencevalue);
            }

        }

        private ComputationConfidenceValue(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            mValue = s1;
            mIsGuess = flag;
        }
    }


    private final ComputationConfidenceValue mComputationConfidenceValue;
    private final String mCor;
    private final String mPfm;

    public CORPFMResponse(String s, String s1, ComputationConfidenceValue computationconfidencevalue)
    {
        mCor = s;
        mPfm = s1;
        mComputationConfidenceValue = computationconfidencevalue;
    }

    public CORPFMResponse(String s, String s1, String s2)
    {
        mCor = s;
        mPfm = s1;
        mComputationConfidenceValue = ComputationConfidenceValue.parseFromValue(s2, ComputationConfidenceValue.CUSTOMER_PROVIDED);
    }

    private boolean isCustomerProvided()
    {
        return getComputationConfidenceValue() == ComputationConfidenceValue.CUSTOMER_PROVIDED;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (CORPFMResponse)obj;
            if (!TextUtils.equals(getCOR(), ((CORPFMResponse) (obj)).getCOR()) || !TextUtils.equals(getPFM(), ((CORPFMResponse) (obj)).getPFM()) || mComputationConfidenceValue != ((CORPFMResponse) (obj)).getComputationConfidenceValue())
            {
                return false;
            }
        }
        return true;
    }

    public String getCOR()
    {
        return mCor;
    }

    public ComputationConfidenceValue getComputationConfidenceValue()
    {
        return mComputationConfidenceValue;
    }

    public String getCustomerProvidedCOR()
    {
        if (!isCustomerProvided())
        {
            return null;
        } else
        {
            return getCOR();
        }
    }

    public String getCustomerProvidedPFM()
    {
        if (!isCustomerProvided())
        {
            return null;
        } else
        {
            return getPFM();
        }
    }

    public String getPFM()
    {
        return mPfm;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (mCor == null)
        {
            i = 0;
        } else
        {
            i = mCor.hashCode();
        }
        if (mPfm == null)
        {
            j = 0;
        } else
        {
            j = mPfm.hashCode();
        }
        if (mComputationConfidenceValue != null)
        {
            k = mComputationConfidenceValue.hashCode();
        }
        return ((i + 31) * 31 + j) * 31 + k;
    }
}
