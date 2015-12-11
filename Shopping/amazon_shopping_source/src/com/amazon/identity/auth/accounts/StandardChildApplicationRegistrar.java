// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.framework.AmazonWebServiceCallerCreator;
import com.amazon.identity.auth.device.framework.AsyncAmazonWebserviceCall;
import com.amazon.identity.auth.device.framework.AsyncAmazonWebserviceCaller;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponseParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebRequest;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            ChildApplicationRegistrar, ChildApplicationRegistrarCallback

public class StandardChildApplicationRegistrar
    implements ChildApplicationRegistrar
{

    private static final String TAG = com/amazon/identity/auth/accounts/StandardChildApplicationRegistrar.getName();
    private final AmazonWebServiceCallerCreator mCallerCreator;
    private final Context mContext;

    public StandardChildApplicationRegistrar(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mCallerCreator = (AmazonWebServiceCallerCreator)mContext.getSystemService("sso_webservice_caller_creator");
    }

    public void registerChild(String s, WebRequest webrequest, final ChildApplicationRegistrarCallback callback, Tracer tracer)
    {
        callback = new DefaultAmazonWebserviceCallListener() {

            final StandardChildApplicationRegistrar this$0;
            final ChildApplicationRegistrarCallback val$callback;

            public void onAuthenticationFailed()
            {
                callback.onAuthenticationFailed();
            }

            public void onNetworkFailure()
            {
                callback.onNetworkError();
            }

            public void onParseError(ParseError parseerror)
            {
                callback.onBadResponse();
            }

            public void onResponseComplete(Object obj)
            {
                obj = (RegisterDeviceResponse)obj;
                callback.onRegisterChildApplicationComplete(((RegisterDeviceResponse) (obj)));
            }

            
            {
                this$0 = StandardChildApplicationRegistrar.this;
                callback = childapplicationregistrarcallback;
                super();
            }
        };
        RegisterDeviceResponseParser registerdeviceresponseparser = new RegisterDeviceResponseParser();
        mCallerCreator.create(s, tracer).createCall(webrequest, registerdeviceresponseparser, callback).call();
    }

}
