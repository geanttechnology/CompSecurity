// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.token.CentralTokenManagementCommunication;
import com.amazon.identity.auth.device.token.TokenManagementDefinition;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit, MAPCallbackErrorException, MAPFuture, Callback

public class TokenManagement
{

    public static final int ERROR_INVALID_PARAMETER = 1;
    public static final String KEY_ERROR_CODE = "com.amazon.dcp.sso.ErrorCode";
    public static final String KEY_ERROR_MESSAGE = "com.amazon.dcp.sso.ErrorMessage";
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/api/TokenManagement.getSimpleName();
    public static final String TAG = com/amazon/identity/auth/device/api/TokenManagement.getName();
    public static final String VALUE_KEY = "value_key";
    private final Context mContext;
    private TokenManagementDefinition mTokenManagementImpl;

    public TokenManagement(Context context)
    {
        MAPInit.getInstance(context).initialize();
        mContext = ServiceWrappingContext.create(context);
    }

    private TokenManagementDefinition getTokenManagerDefinition()
    {
        this;
        JVM INSTR monitorenter ;
        TokenManagementDefinition tokenmanagementdefinition;
        if (mTokenManagementImpl == null)
        {
            mTokenManagementImpl = new CentralTokenManagementCommunication(mContext);
        }
        tokenmanagementdefinition = mTokenManagementImpl;
        this;
        JVM INSTR monitorexit ;
        return tokenmanagementdefinition;
        Exception exception;
        exception;
        throw exception;
    }

    public MAPFuture getCookies(String s, String s1, Bundle bundle, Callback callback)
    {
        Tracer tracer = Tracer.getNewTracer("TokenManagement:GetCookies");
        com.amazon.identity.platform.metric.PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getCookies");
        return getTokenManagerDefinition().getCookies(s, s1, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
    }

    public MAPFuture getToken(String s, String s1, Bundle bundle, Callback callback)
    {
        Tracer tracer = Tracer.getNewTracer("TokenManagement:GetToken");
        com.amazon.identity.platform.metric.PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getToken");
        return getTokenManagerDefinition().getToken(s, s1, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
    }

    public String getValue(String s, String s1, Bundle bundle, long l)
        throws MAPCallbackErrorException, InterruptedException, ExecutionException, TimeoutException
    {
        return ((Bundle)getToken(s, s1, bundle, null).get(l, TimeUnit.MILLISECONDS)).getString("value_key");
    }

    public MAPFuture peekCookies(String s, String s1, Callback callback)
    {
        Tracer tracer = Tracer.getNewTracer("TokenManagement:PeekCookies");
        if (TextUtils.isEmpty(s))
        {
            MAPLog.e(TAG, "Directed Id given was null. Cannot peek cookies for a deregistered device");
            throw new IllegalArgumentException("Directed Id given was null. Cannot peek cookies for a deregistered device");
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.amazon.identity.auth.device.internal.cookiekeys.options.ignorefresh", true);
            com.amazon.identity.platform.metric.PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "peekCookies");
            return getTokenManagerDefinition().getCookies(s, s1, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
        }
    }

}
