// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.net.Uri;
import android.os.RemoteException;
import com.amazon.dcp.sso.IAmazonAccountAuthenticator;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponseParser;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            ChildApplicationRegistrar, ChildApplicationRegistrarCallback

public class SubAuthChildApplicationRegistrar
    implements ChildApplicationRegistrar
{

    private static final String TAG = com/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar.getName();
    private final IAmazonAccountAuthenticator mAuthenticator;

    public SubAuthChildApplicationRegistrar(IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        mAuthenticator = iamazonaccountauthenticator;
    }

    public void registerChild(String s, WebRequest webrequest, final ChildApplicationRegistrarCallback callback, Tracer tracer)
    {
        String s1;
        HashMap hashmap;
        int j;
        s = mAuthenticator;
        tracer = Uri.parse(webrequest.getUrl());
        s1 = webrequest.getVerbAsString();
        j = webrequest.getNumHeaders();
        hashmap = new HashMap(j);
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap.put(webrequest.getHeaderName(i), webrequest.getHeaderValue(i));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            s.callGetCredentialsWebservice(tracer, s1, hashmap, webrequest.getBodyBytes(), new com.amazon.dcp.sso.IWebserviceCallback.Stub() {

                final SubAuthChildApplicationRegistrar this$0;
                final ChildApplicationRegistrarCallback val$callback;

                public void onAuthenticationFailed()
                    throws RemoteException
                {
                    callback.onAuthenticationFailed();
                }

                public void onBadResponse()
                    throws RemoteException
                {
                    callback.onBadResponse();
                }

                public void onInvalidRequest()
                    throws RemoteException
                {
                    callback.onInvalidRequest();
                }

                public void onNetworkError()
                    throws RemoteException
                {
                    callback.onNetworkError();
                }

                public void onResponseReceived(long l, Map map, byte abyte0[])
                    throws RemoteException
                {
                    map = this = new RegisterDeviceResponseParser();
                    callback.onRegisterChildApplicationComplete(map);
                }

            
            {
                this$0 = SubAuthChildApplicationRegistrar.this;
                callback = childapplicationregistrarcallback;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "RemoteException calling AmazonAccountAuthenticator.callGetCredentialsWebservice");
        }
        return;
    }



/*
    static RegisterDeviceResponse access$000(SubAuthChildApplicationRegistrar subauthchildapplicationregistrar, long l, Map map, byte abyte0[])
    {
        subauthchildapplicationregistrar = new RegisterDeviceResponseParser();
        WebResponseHeaders webresponseheaders = new WebResponseHeaders();
        webresponseheaders.setStatusCode(l);
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); webresponseheaders.addHeader((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        subauthchildapplicationregistrar.beginParse(webresponseheaders);
        if (subauthchildapplicationregistrar.shouldParseBody())
        {
            subauthchildapplicationregistrar.parseBodyChunk(abyte0, abyte0.length);
        }
        subauthchildapplicationregistrar.endParse();
        return subauthchildapplicationregistrar.getParsedResponse();
    }

*/
}
