// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;


public final class AlipayAdapterStatus extends Enum
{

    private static final AlipayAdapterStatus $VALUES[];
    public static final AlipayAdapterStatus ADAPTER_INVOKE_SUCCESS;
    public static final AlipayAdapterStatus ALIPAY_UAVAILABLE;
    public static final AlipayAdapterStatus SERVICE_BIND_FAILURE;
    public static final AlipayAdapterStatus SERVICE_INVOKE_SUCCESS;
    public static final AlipayAdapterStatus UNDEFINED;

    private AlipayAdapterStatus(String s, int i)
    {
        super(s, i);
    }

    public static AlipayAdapterStatus valueOf(String s)
    {
        return (AlipayAdapterStatus)Enum.valueOf(com/amazon/mShop/payment/alipay/AlipayAdapterStatus, s);
    }

    public static AlipayAdapterStatus[] values()
    {
        return (AlipayAdapterStatus[])$VALUES.clone();
    }

    static 
    {
        UNDEFINED = new AlipayAdapterStatus("UNDEFINED", 0);
        ALIPAY_UAVAILABLE = new AlipayAdapterStatus("ALIPAY_UAVAILABLE", 1);
        ADAPTER_INVOKE_SUCCESS = new AlipayAdapterStatus("ADAPTER_INVOKE_SUCCESS", 2);
        SERVICE_BIND_FAILURE = new AlipayAdapterStatus("SERVICE_BIND_FAILURE", 3);
        SERVICE_INVOKE_SUCCESS = new AlipayAdapterStatus("SERVICE_INVOKE_SUCCESS", 4);
        $VALUES = (new AlipayAdapterStatus[] {
            UNDEFINED, ALIPAY_UAVAILABLE, ADAPTER_INVOKE_SUCCESS, SERVICE_BIND_FAILURE, SERVICE_INVOKE_SUCCESS
        });
    }
}
