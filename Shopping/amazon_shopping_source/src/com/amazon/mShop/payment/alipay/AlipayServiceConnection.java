// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;

// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayAdapterStatus, AlipayCallback

final class AlipayServiceConnection
    implements ServiceConnection
{

    private static final String TAG = com/amazon/mShop/payment/alipay/AlipayServiceConnection.getSimpleName();
    private final Activity mActivity;
    private final AlipayCallback mCallback;
    private final String mOrderInfo;
    private final IRemoteServiceCallback mRemoteCallback = new com.alipay.android.app.IRemoteServiceCallback.Stub() {

        final AlipayServiceConnection this$0;

        public boolean isHideLoadingScreen()
            throws RemoteException
        {
            return false;
        }

        public void payEnd(boolean flag, String s1)
            throws RemoteException
        {
        }

        public void startActivity(String s1, String s2, int i, Bundle bundle)
            throws RemoteException
        {
            Intent intent = new Intent("android.intent.action.MAIN", null);
            Bundle bundle1 = bundle;
            if (bundle == null)
            {
                bundle1 = new Bundle();
            }
            try
            {
                bundle1.putInt("CallingPid", i);
                intent.putExtras(bundle1);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            intent.setClassName(s1, s2);
            mActivity.startActivity(intent);
        }

            
            {
                this$0 = AlipayServiceConnection.this;
                super();
            }
    };

    AlipayServiceConnection(Activity activity, String s, AlipayCallback alipaycallback)
    {
        mActivity = activity;
        mOrderInfo = s;
        mCallback = alipaycallback;
    }

    private void finishPayment()
    {
        mActivity.getApplicationContext().unbindService(this);
    }

    private void invokePayServiceAsync(final IAlixPay alipayService, final String orderInfo)
    {
        (new AsyncTask() {

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
                if (alipayService == null)
                {
                    break MISSING_BLOCK_LABEL_63;
                }
                avoid = obj;
                try
                {
                    alipayService.registerCallback(mRemoteCallback);
                }
                catch (Exception exception)
                {
                    return avoid;
                }
                avoid = obj;
                s = alipayService.Pay(orderInfo);
                avoid = s;
                alipayService.unregisterCallback(mRemoteCallback);
                return s;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((String)obj);
            }

            protected void onPostExecute(String s)
            {
                mCallback.onPaymentFinish(AlipayAdapterStatus.SERVICE_INVOKE_SUCCESS, s);
                finishPayment();
            }

            
            {
                this$0 = AlipayServiceConnection.this;
                alipayService = ialixpay;
                orderInfo = s;
                super();
            }
        }).execute(new Void[0]);
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = com.alipay.android.app.IAlixPay.Stub.asInterface(ibinder);
        if (componentname != null)
        {
            invokePayServiceAsync(componentname, mOrderInfo);
            return;
        } else
        {
            mCallback.onPaymentFinish(AlipayAdapterStatus.SERVICE_BIND_FAILURE, null);
            finishPayment();
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }

    public void startPayment(String s)
    {
        mActivity.getApplicationContext().bindService(new Intent(s), this, 1);
    }





}
