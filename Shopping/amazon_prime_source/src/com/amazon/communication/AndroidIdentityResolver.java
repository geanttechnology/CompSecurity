// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.TCommServiceDownException;
import amazon.communication.connection.Purpose;
import amazon.communication.identity.IRServiceEndpoint;
import amazon.communication.identity.IdentityResolver;
import amazon.communication.identity.ServiceIdentity;
import android.content.Context;
import android.os.RemoteException;
import com.amazon.communication.ir.IIdentityResolver;
import com.amazon.dp.logger.DPLogger;

// Referenced classes of package com.amazon.communication:
//            AndroidTCommServiceConnection, ICommunicationService

public class AndroidIdentityResolver
    implements IdentityResolver
{

    private static final DPLogger log = new DPLogger("TComm.AndroidIdentityResolver");
    protected final AndroidTCommServiceConnection mServiceConnection;

    public AndroidIdentityResolver(Context context)
    {
        mServiceConnection = new AndroidTCommServiceConnection(context);
    }

    public void close()
    {
        mServiceConnection.unbindTCommService();
    }

    public IRServiceEndpoint getEndpointForServiceName(String s)
    {
        return getEndpointForServiceNameDomainAndRealm(s, null, null);
    }

    protected IRServiceEndpoint getEndpointForServiceNameDomainAndRealm(String s, String s1, String s2)
    {
        ICommunicationService icommunicationservice;
        try
        {
            mServiceConnection.bindTCommService();
            icommunicationservice = ICommunicationService.Stub.asInterface(mServiceConnection.getBinder());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        if (icommunicationservice != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        throw new TCommServiceDownException("Acquired null instance of ICommunicationService");
        s = icommunicationservice.getIdentityResolver().resolveServiceEndpoint(s, s1, s2);
        return s;
    }

    public IRServiceEndpoint resolveServiceEndpoint(ServiceIdentity serviceidentity)
    {
        return getEndpointForServiceNameDomainAndRealm(serviceidentity.getServiceName(), serviceidentity.getDomain(), serviceidentity.getRealm());
    }

    public IRServiceEndpoint resolveServiceEndpoint(ServiceIdentity serviceidentity, Purpose purpose)
    {
        log.warn("resolveServiceEndpoint", "Calling this method is discouraged! We'll ignore the Purpose in this impl.", new Object[] {
            "identity", serviceidentity, "purpose", purpose
        });
        return resolveServiceEndpoint(serviceidentity);
    }

}
