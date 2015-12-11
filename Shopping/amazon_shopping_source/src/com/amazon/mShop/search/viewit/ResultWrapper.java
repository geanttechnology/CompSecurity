// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.util.Util;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class ResultWrapper
{
    public static final class ResultType extends Enum
    {

        private static final ResultType $VALUES[];
        public static final ResultType BARCODE;
        public static final ResultType IMAGE;
        private String mTypeValue;

        public static ResultType valueOf(String s)
        {
            return (ResultType)Enum.valueOf(com/amazon/mShop/search/viewit/ResultWrapper$ResultType, s);
        }

        public static ResultType[] values()
        {
            return (ResultType[])$VALUES.clone();
        }

        public String getTypeValue()
        {
            return mTypeValue;
        }

        static 
        {
            BARCODE = new ResultType("BARCODE", 0, "barcode:");
            IMAGE = new ResultType("IMAGE", 1, "image:");
            $VALUES = (new ResultType[] {
                BARCODE, IMAGE
            });
        }

        private ResultType(String s, int i, String s1)
        {
            super(s, i);
            mTypeValue = null;
            mTypeValue = s1;
        }
    }


    private String mOriginalScannedOutput;
    private ResultType mResultType;
    private Date mScannedDate;

    public ResultWrapper(String s, Date date)
    {
        mOriginalScannedOutput = s;
        mScannedDate = date;
        updateResultType(s);
    }

    public static Date getCurrentDate()
    {
        long l = System.currentTimeMillis();
        Date date = Calendar.getInstance().getTime();
        date.setTime(Long.valueOf(l).longValue());
        return date;
    }

    private void updateResultType(String s)
    {
label0:
        {
            if (!Util.isEmpty(s))
            {
                if (!s.startsWith(ResultType.BARCODE.getTypeValue()))
                {
                    break label0;
                }
                mResultType = ResultType.BARCODE;
            }
            return;
        }
        if (s.startsWith(ResultType.IMAGE.getTypeValue()))
        {
            mResultType = ResultType.IMAGE;
            return;
        } else
        {
            mResultType = null;
            return;
        }
    }

    public abstract List getAsinList();

    public String getOriginalScannedOutput()
    {
        return mOriginalScannedOutput;
    }

    public ResultType getResultType()
    {
        return mResultType;
    }

    public Date getScannedDate()
    {
        return mScannedDate;
    }

    public void updateOriginalScannedOutput(String s)
    {
        mOriginalScannedOutput = s;
        updateResultType(s);
    }

    public void updateScannedDate()
    {
        mScannedDate = getCurrentDate();
    }
}
