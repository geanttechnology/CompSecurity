// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.GenericIPCSender;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementDefinition

public class CentralTokenManagementCommunication
    implements TokenManagementDefinition
{
    public static class GetCookiesCommand
        implements IPCCommand
    {

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directed_id", s);
            bundle1.putString("domain", s1);
            bundle1.putBundle("options_key", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public GetCookiesCommand()
        {
        }
    }

    public static class GetTokenCommand
        implements IPCCommand
    {

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directed_id", s);
            bundle1.putString("token_key", s1);
            bundle1.putBundle("options_key", bundle);
            return bundle1;
        }

        public GetTokenCommand()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/token/CentralTokenManagementCommunication.getName();
    private final ServiceWrappingContext mContext;
    private final GenericIPCSender mGenericIpcSender;

    public CentralTokenManagementCommunication(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mGenericIpcSender = new GenericIPCSender(mContext, "com.amazon.dcp.sso.ErrorCode", "com.amazon.dcp.sso.ErrorMessage", Integer.valueOf(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value()));
    }

    public MAPFuture getCookies(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        callback = new CallbackFuture(callback);
        mGenericIpcSender.call(com/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetCookiesCommand, GetCookiesCommand.parametersToBundle(s, s1, bundle, tracer), callback);
        return callback;
    }

    public MAPFuture getToken(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        callback = new CallbackFuture(callback);
        mGenericIpcSender.call(com/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetTokenCommand, GetTokenCommand.parametersToBundle(s, s1, bundle), callback);
        return callback;
    }

}
