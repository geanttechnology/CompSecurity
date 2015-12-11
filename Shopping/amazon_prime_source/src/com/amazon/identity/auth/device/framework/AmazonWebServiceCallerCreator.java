// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.credentials.AccountCredentialsHolder;
import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCaller;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCaller;
import com.amazon.identity.kcpsdk.auth.RequestSigner;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AsyncAmazonWebserviceCaller, Tracer

public class AmazonWebServiceCallerCreator
{

    private final Context mContext;

    public AmazonWebServiceCallerCreator(Context context)
    {
        mContext = context;
    }

    public AsyncAmazonWebserviceCaller create(AccountCredentials accountcredentials, Tracer tracer)
    {
        return new AsyncAmazonWebserviceCaller(mContext, accountcredentials, tracer);
    }

    public AsyncAmazonWebserviceCaller create(String s, Tracer tracer)
    {
        return new AsyncAmazonWebserviceCaller(mContext, s, tracer);
    }

    public IAmazonWebserviceCaller createSync(AccountCredentials accountcredentials, Tracer tracer)
    {
        return new AmazonWebserviceCaller(mContext, new RequestSigner(accountcredentials), tracer);
    }

    public IAmazonWebserviceCaller createSync(Tracer tracer)
    {
        return new AmazonWebserviceCaller(mContext, new RequestSigner(AccountCredentialsHolder.getInstance(mContext)), tracer);
    }

    public IAmazonWebserviceCaller createSync(String s, Tracer tracer)
    {
        return new AmazonWebserviceCaller(mContext, new RequestSigner(AccountCredentialsHolder.getCredentialsForAccount(mContext, s)), tracer);
    }
}
