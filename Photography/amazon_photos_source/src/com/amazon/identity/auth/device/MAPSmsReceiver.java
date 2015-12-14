// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PhoneVerificationHelper;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class MAPSmsReceiver extends BroadcastReceiver
{
    private class _cls2
        implements Runnable
    {

        final MAPSmsReceiver this$0;
        final String val$url;

        public void run()
        {
            if (mIsReceiverRegistered.get())
            {
                MAPLog.i(MAPSmsReceiver.TAG, "Start loading phone verification url from SMS");
                mStartedLoadingPvUrlFromSMS = Boolean.valueOf(true);
                mWebView.loadUrl(url);
            }
        }

        _cls2()
        {
            this$0 = MAPSmsReceiver.this;
            url = s;
            super();
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/MAPSmsReceiver.getName();
    private Boolean mHasSmsPermission;
    private AtomicBoolean mIsReceiverRegistered;
    private Boolean mStartedLoadingPvUrlFromSMS;
    private Tracer mTracer;
    private WebView mWebView;

    public MAPSmsReceiver(Tracer tracer, WebView webview)
    {
        mTracer = tracer;
        mIsReceiverRegistered = new AtomicBoolean(false);
        mWebView = webview;
        mHasSmsPermission = null;
        mStartedLoadingPvUrlFromSMS = Boolean.valueOf(false);
    }

    public IntentFilter buildSmsIntentFilter()
    {
        return new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
    }

    public void incrementCounterForAutoPhoneVerificationSuccess()
    {
        if (mStartedLoadingPvUrlFromSMS.booleanValue())
        {
            mTracer.incrementCounter("MOA:AutoPVSuccess");
        }
    }

    public boolean isSmsPermissionGranted(Context context)
    {
        if (mHasSmsPermission == null)
        {
            if (context.checkCallingOrSelfPermission("android.permission.RECEIVE_SMS") == 0)
            {
                mHasSmsPermission = Boolean.valueOf(true);
            } else
            {
                mHasSmsPermission = Boolean.valueOf(false);
            }
        }
        return mHasSmsPermission.booleanValue();
    }

    public void onReceive(Context context, final Intent intent)
    {
        try
        {
            ThreadUtils.runOffMainThread(new Runnable() {

                final MAPSmsReceiver this$0;
                final Intent val$intent;

                public void run()
                {
                    if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
                    {
                        Object obj = intent.getExtras();
                        if (obj != null)
                        {
                            Object aobj[] = (Object[])((Bundle) (obj)).get("pdus");
                            SmsMessage asmsmessage[] = new SmsMessage[aobj.length];
                            obj = null;
                            StringBuilder stringbuilder = new StringBuilder();
                            for (int i = 0; i < asmsmessage.length; i++)
                            {
                                asmsmessage[i] = SmsMessage.createFromPdu((byte[])aobj[i]);
                                obj = asmsmessage[i].getOriginatingAddress();
                                stringbuilder.append(asmsmessage[i].getMessageBody());
                            }

                            String s = stringbuilder.toString();
                            String _tmp = MAPSmsReceiver.TAG;
                            (new StringBuilder("Receiving message from: ")).append(((String) (obj))).append(". Message body:").append(s).toString();
                            obj = PhoneVerificationHelper.parsePVTinyURLFromSMS(s);
                            if (obj != null)
                            {
                                mTracer.incrementCounter("MOA:GetValidUrlFromSMS");
                                try
                                {
                                    obj = (HttpURLConnection)((URL) (obj)).openConnection();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Object obj)
                                {
                                    MAPLog.logAndReportError(MAPSmsReceiver.TAG, mTracer, "IOException happens when trying to open Connection", "OpenTinyURLConnectionIOException");
                                    return;
                                }
                                obj = PhoneVerificationHelper.resolveTinyURLRedirect(((HttpURLConnection) (obj)), mTracer);
                                if (TextUtils.isEmpty(((CharSequence) (obj))))
                                {
                                    mTracer.incrementCounter("MOA:CannotResolveTinyUrl");
                                    return;
                                }
                                obj = PhoneVerificationHelper.getPhoneVerificationUrlFromDeepLinkUrl(((String) (obj)), mTracer);
                                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                                {
                                    MAPLog.i(MAPSmsReceiver.TAG, "Finished parsing the url from SMS");
                                    MAPSmsReceiver.access$200(MAPSmsReceiver.this, ((String) (obj)));
                                    return;
                                }
                            }
                        }
                    }
                }

            
            {
                this$0 = MAPSmsReceiver.this;
                intent = intent1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.logAndReportError(TAG, mTracer, "Unknown exception happened when reading the message.", (new StringBuilder("UnknownExceptionReadingSMS:")).append(context.getClass().getName()).toString());
        }
    }

    public void recordSessionExpired()
    {
        mTracer.incrementCounter("MOA:PVUrlSessionExpired");
    }

    public void registerMAPSmsReceiverIfUnregistered(Context context)
    {
        if (!mIsReceiverRegistered.getAndSet(true))
        {
            mTracer.incrementCounter("MOA:RegisterReadSmsReceiver");
            String s = TAG;
            context.registerReceiver(this, buildSmsIntentFilter());
        }
    }

    public boolean shouldRegisterMAPSmsReceiver(String s, Context context)
    {
        if (TextUtils.isEmpty(s))
        {
            MAPLog.e(TAG, "url is null or empty");
            return false;
        }
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = TAG;
            (new StringBuilder("MalformedURLException url=")).append(null).toString();
            return false;
        }
        return shouldRegisterMAPSmsReceiver(((URL) (s)), context);
    }

    public boolean shouldRegisterMAPSmsReceiver(URL url, Context context)
    {
        if (context != null && "/ap/pv".equals(url.getPath()))
        {
            url = url.getQuery();
            if (url != null && url.contains("spin=true") && isSmsPermissionGranted(context))
            {
                return true;
            }
        }
        return false;
    }

    public void unregisterMAPSmsReceiverIfRegistered(Context context)
    {
        if (context != null && mIsReceiverRegistered.getAndSet(false))
        {
            String s = TAG;
            if (!mStartedLoadingPvUrlFromSMS.booleanValue())
            {
                mTracer.incrementCounter("MOA:AutoPVCancel");
            }
            context.unregisterReceiver(this);
        }
    }





/*
    static void access$200(MAPSmsReceiver mapsmsreceiver, final String url)
    {
        if (mapsmsreceiver.mWebView != null)
        {
            ThreadUtils.runOnMainThread(mapsmsreceiver. new _cls2());
        }
        return;
    }

*/



/*
    static Boolean access$402(MAPSmsReceiver mapsmsreceiver, Boolean boolean1)
    {
        mapsmsreceiver.mStartedLoadingPvUrlFromSMS = boolean1;
        return boolean1;
    }

*/

}
