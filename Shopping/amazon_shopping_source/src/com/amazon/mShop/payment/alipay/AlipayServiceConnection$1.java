// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;

import android.os.AsyncTask;
import com.alipay.android.app.IAlixPay;

// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayServiceConnection, AlipayAdapterStatus, AlipayCallback

class val.orderInfo extends AsyncTask
{

    final AlipayServiceConnection this$0;
    final IAlixPay val$alipayService;
    final String val$orderInfo;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        Object obj = null;
        String s = null;
        if (val$alipayService == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        avoid = obj;
        try
        {
            val$alipayService.registerCallback(AlipayServiceConnection.access$000(AlipayServiceConnection.this));
        }
        catch (Exception exception)
        {
            return avoid;
        }
        avoid = obj;
        s = val$alipayService.Pay(val$orderInfo);
        avoid = s;
        val$alipayService.unregisterCallback(AlipayServiceConnection.access$000(AlipayServiceConnection.this));
        return s;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        AlipayServiceConnection.access$100(AlipayServiceConnection.this).onPaymentFinish(AlipayAdapterStatus.SERVICE_INVOKE_SUCCESS, s);
        AlipayServiceConnection.access$200(AlipayServiceConnection.this);
    }

    ()
    {
        this$0 = final_alipayserviceconnection;
        val$alipayService = ialixpay;
        val$orderInfo = String.this;
        super();
    }
}
