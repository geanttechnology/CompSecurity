// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit, AuthenticationType, DefaultAuthenticationMethod, CentralDcpAuthenticationMethod, 
//            InProcessAdpAuthenticationMethod, InProcessOauthAuthenticationMethod, AuthenticationMethod

public final class AuthenticationMethodFactory
{

    private static final String TAG = com/amazon/identity/auth/device/api/AuthenticationMethodFactory.getName();
    private final Context mContext;
    private final String mDirectedId;
    private String mPackageName;
    private final PlatformWrapper mPlatform;

    public AuthenticationMethodFactory(Context context)
    {
        this(context, null);
    }

    public AuthenticationMethodFactory(Context context, String s)
    {
        MAPInit.getInstance(context).initialize();
        mContext = ServiceWrappingContext.create(context);
        mDirectedId = s;
        mPackageName = mContext.getPackageName();
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
    }

    private boolean useCentralService()
    {
        while (!mPlatform.hasCentralApk() || mPlatform.isOtter()) 
        {
            return false;
        }
        if (mContext.getPackageName().equals(mPackageName))
        {
            return DeviceTypeHelpers.isLocalApplicationUsingDeviceCredentials(mContext);
        }
        if (mPackageName == null)
        {
            return true;
        }
        RemoteMapInfo remotemapinfo = MAPApplicationInformationQueryer.getInstance(mContext).getAppInfo(mPackageName);
        if (remotemapinfo == null)
        {
            throw new UnsupportedOperationException(String.format("Cannot sign request with %s credentials since it is not a map application", new Object[] {
                mPackageName
            }));
        }
        boolean flag;
        try
        {
            flag = DeviceTypeHelpers.areAppsWithDeviceTypeUsingDeviceCredentials(mContext, remotemapinfo.getDeviceType());
        }
        catch (RemoteMAPException remotemapexception)
        {
            MAPLog.w(TAG, (new StringBuilder("Couldn't determine device type for ")).append(mPackageName).toString(), remotemapexception);
            return false;
        }
        return flag;
    }

    public AuthenticationMethod newAuthenticationMethod(AuthenticationType authenticationtype)
    {
        if (authenticationtype == null)
        {
            return null;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[];

            static 
            {
                $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType = new int[AuthenticationType.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.ADPAuthenticator.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.DeviceAuthenticator.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.OAuth.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.None.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (useCentralService())
        {
            switch (_cls1..SwitchMap.com.amazon.identity.auth.device.api.AuthenticationType[authenticationtype.ordinal()])
            {
            default:
                return new DefaultAuthenticationMethod(mContext, mDirectedId);

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                return new CentralDcpAuthenticationMethod(mContext, mDirectedId, authenticationtype);
            }
        }
        switch (_cls1..SwitchMap.com.amazon.identity.auth.device.api.AuthenticationType[authenticationtype.ordinal()])
        {
        default:
            return new DefaultAuthenticationMethod(mContext, mDirectedId);

        case 1: // '\001'
        case 2: // '\002'
            return new InProcessAdpAuthenticationMethod(mContext, mDirectedId, mPackageName, authenticationtype);

        case 3: // '\003'
            return new InProcessOauthAuthenticationMethod(mContext, mDirectedId, mPackageName, authenticationtype);
        }
    }

    public AuthenticationMethod newAuthenticationMethod(String s)
    {
        AuthenticationType authenticationtype = AuthenticationType.parse(s);
        if (authenticationtype != null)
        {
            return newAuthenticationMethod(authenticationtype);
        }
        if (useCentralService())
        {
            return new CentralDcpAuthenticationMethod(mContext, mDirectedId, s);
        }
        if ("BustedIdentityADPAuthenticator".equals(s))
        {
            return new InProcessAdpAuthenticationMethod(mContext, mDirectedId, mPackageName, s);
        } else
        {
            throw new UnsupportedOperationException(String.format("Authentication Type %s is not supported on this build", new Object[] {
                s
            }));
        }
    }

    public void setPackageName(String s)
    {
        mPackageName = s;
    }

}
