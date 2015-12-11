// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;


// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayAdapterStatus

public interface AlipayCallback
{
    public static final class ResultField extends Enum
    {

        private static final ResultField $VALUES[];
        public static final ResultField memo;
        public static final ResultField result;
        public static final ResultField resultStatus;

        public static ResultField valueOf(String s)
        {
            return (ResultField)Enum.valueOf(com/amazon/mShop/payment/alipay/AlipayCallback$ResultField, s);
        }

        public static ResultField[] values()
        {
            return (ResultField[])$VALUES.clone();
        }

        static 
        {
            resultStatus = new ResultField("resultStatus", 0);
            result = new ResultField("result", 1);
            memo = new ResultField("memo", 2);
            $VALUES = (new ResultField[] {
                resultStatus, result, memo
            });
        }

        private ResultField(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void onPaymentFinish(AlipayAdapterStatus alipayadapterstatus, String s);
}
