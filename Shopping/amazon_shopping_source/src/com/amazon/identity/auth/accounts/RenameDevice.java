// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.AsyncAmazonWebserviceCall;
import com.amazon.identity.auth.device.framework.AsyncAmazonWebserviceCaller;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.RenameDeviceRequest;
import com.amazon.identity.kcpsdk.auth.RenameDeviceResponse;
import com.amazon.identity.kcpsdk.auth.RenameDeviceResponseParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseParser;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AmazonAccountManager

public class RenameDevice
{

    private static final String TAG = com/amazon/identity/auth/accounts/RenameDevice.getName();
    private final AmazonAccountManager mAmazonAccountManager;
    private Context mContext;

    public RenameDevice(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("One or more arguments are null");
        } else
        {
            mContext = ServiceWrappingContext.create(context);
            mAmazonAccountManager = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
            return;
        }
    }

    private void callbackOnError(Callback callback, int i, String s)
    {
        MAPLog.e(TAG, (new StringBuilder("Rename Device Error: ")).append(s).toString());
        SSOMetrics.renameDeviceRequestFailure(i);
        Bundle bundle = new Bundle();
        bundle.putInt("error_code_key", i);
        bundle.putString("error_message_key", s);
        callback.onError(bundle);
    }

    protected void invokeWebRequest(String s, WebRequest webrequest, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener, Context context, Tracer tracer)
    {
        (new AsyncAmazonWebserviceCaller(context, s, tracer)).createCall(webrequest, webresponseparser, iamazonwebservicecalllistener).call();
    }

    public void renameDevice(final String directedId, String s, Bundle bundle, final Callback callback, Tracer tracer)
    {
        MAPLog.i(TAG, "Start to process rename device request");
        if (directedId == null || !mAmazonAccountManager.doesAccountExist(directedId))
        {
            callbackOnError(callback, 6, "The provided amazon account could not be found on the device.");
            return;
        }
        bundle = new RenameDeviceRequest();
        if (!bundle.setDeviceName(s))
        {
            callbackOnError(callback, 3, "Invalid device name.  The device name cannot be null or empty.");
            return;
        } else
        {
            s = new DefaultAmazonWebserviceCallListener() {

                final RenameDevice this$0;
                final Callback val$callback;
                final String val$directedId;

                public void onAuthenticationFailed()
                {
                    callbackOnError(callback, 2, "Authentication failure performing rename device request");
                }

                public void onNetworkFailure()
                {
                    callbackOnError(callback, 1, "Network failure performing rename device request");
                }

                public void onParseError(ParseError parseerror)
                {
                    callbackOnError(callback, 4, "Parsing failure performing rename device request");
                }

                public void onResponseComplete(Object obj)
                {
                    MAPLog.i(RenameDevice.TAG, "Completed the rename device request");
                    obj = (RenameDeviceResponse)obj;
                    if (obj == null)
                    {
                        callbackOnError(callback, 7, " Unrecognized response from server");
                        return;
                    }
                    int i = ((RenameDeviceResponse) (obj)).getError();
                    obj = ((RenameDeviceResponse) (obj)).getMessage();
                    if (i == 0)
                    {
                        MAPLog.i(RenameDevice.TAG, "Successfully completed the rename device request");
                        mAmazonAccountManager.setUserData(directedId, "com.amazon.dcp.sso.property.devicename", ((String) (obj)));
                        MAPLog.i(RenameDevice.TAG, "RenameDevice completed successfully.");
                        SSOMetrics.renameDeviceRequestSuccess();
                        callback.onSuccess(this = new Bundle());
                        return;
                    } else
                    {
                        callbackOnError(callback, i, ((String) (obj)));
                        return;
                    }
                }

            
            {
                this$0 = RenameDevice.this;
                callback = callback1;
                directedId = s;
                super();
            }
            };
            invokeWebRequest(directedId, bundle.getWebRequest(), new RenameDeviceResponseParser(), s, mContext, tracer);
            return;
        }
    }






/*
    static Bundle access$300(RenameDevice renamedevice, String s)
    {
        renamedevice = new Bundle();
        renamedevice.putString("new_device_name", s);
        return renamedevice;
    }

*/
}
