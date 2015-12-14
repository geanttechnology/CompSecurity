// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.NoCredentialsException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            HttpConfig, Endpoint, UserManager

public class EndpointManager
{

    private static final String TAG = com/amazon/gallery/framework/network/http/rest/account/EndpointManager.getName();
    private final AuthenticationManager authenticationManager;
    protected HttpConfig config;
    protected Endpoint endpoint;
    protected final ConcurrentHashMap endpointMap = new ConcurrentHashMap();
    protected RestClient restClient;
    private UserManager userManager;

    public EndpointManager(RestClient restclient, HttpConfig httpconfig, UserManager usermanager, AuthenticationManager authenticationmanager)
    {
        restClient = restclient;
        config = httpconfig;
        userManager = usermanager;
        authenticationManager = authenticationmanager;
        GlobalMessagingBus.register(this);
    }

    private Endpoint fetchEndpoint(String s)
        throws TerminalException
    {
        Endpoint endpoint1;
        int i;
        endpoint1 = null;
        i = 1;
_L2:
        Endpoint endpoint2;
        if (endpoint1 != null && validateEndpoint(endpoint1))
        {
            break; /* Loop/switch isn't completed */
        }
        GLogger.d(TAG, "Fetching Endpoint from server...", new Object[0]);
        endpoint2 = config.getDefaultEndpoint(s, i);
        if (endpoint2 == null)
        {
            throw new TerminalException("Error contacting Senna while retrieving the customer's endpoint");
        }
        Object obj;
        obj = restClient.getEndpointOperation(endpoint2);
        obj = (Endpoint)NetworkExecutor.getInstance().execute(((com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation) (obj)));
        endpoint1 = ((Endpoint) (obj));
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        TerminalException terminalexception;
        terminalexception;
        GLogger.e(TAG, "Error contacting senna for endpoint discovery; endpoint = %s", new Object[] {
            endpoint2
        });
          goto _L3
_L1:
        return endpoint1;
    }

    private boolean validateEndpoint(Endpoint endpoint1)
    {
        if (endpoint1 == null || endpoint1.getHttpHostString() == null || endpoint1.getHttpPath() == null)
        {
            userManager.removeEndpointSharedPreferences(authenticationManager.getAccountId());
            return false;
        } else
        {
            return true;
        }
    }

    public Endpoint getCachedEndpoint()
    {
        String s = authenticationManager.getAccountId();
        if (s != null)
        {
            return getCachedEndpoint(s);
        } else
        {
            return null;
        }
    }

    public Endpoint getCachedEndpoint(String s)
    {
        return userManager.getStoredEndpointFromSharedPreferences(s);
    }

    public Endpoint getEndpoint()
        throws TerminalException
    {
        return getEndpoint(authenticationManager.getAccountId());
    }

    public Endpoint getEndpoint(String s)
        throws TerminalException
    {
        Endpoint endpoint2;
        boolean flag;
        if (s == null)
        {
            throw new NoCredentialsException();
        }
        flag = true;
        Endpoint endpoint1;
        Endpoint endpoint3;
        if (config.isDefaultEndpointSticky())
        {
            endpoint1 = config.getDefaultEndpoint(s, 1);
        } else
        {
            endpoint1 = (Endpoint)endpointMap.get(s);
        }
        if (endpoint1 != null)
        {
            endpoint2 = endpoint1;
            if (validateEndpoint(endpoint1))
            {
                break MISSING_BLOCK_LABEL_171;
            }
        }
        this;
        JVM INSTR monitorenter ;
        GLogger.d(TAG, "No in memory endpoint...", new Object[0]);
        endpoint3 = getCachedEndpoint(s);
        if (endpoint3 == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        endpoint2 = endpoint3;
        if (validateEndpoint(endpoint3))
        {
            break MISSING_BLOCK_LABEL_109;
        }
        GLogger.d(TAG, "No cached Endpoint...", new Object[0]);
        endpoint2 = fetchEndpoint(s);
        if (!validateEndpoint(endpoint2))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        GLogger.d(TAG, "Fetched Endpoint is Valid...", new Object[0]);
        endpoint3 = (Endpoint)endpointMap.putIfAbsent(s, endpoint2);
        endpoint1 = endpoint3;
        if (endpoint3 != null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        userManager.storeEndpointInSharedPreferences(s, endpoint2);
        endpoint1 = endpoint2;
        this;
        JVM INSTR monitorexit ;
        flag = false;
        endpoint2 = endpoint1;
        if (endpoint2 == null)
        {
            throw new TerminalException("Error retrieving the customer's endpoint");
        } else
        {
            GlobalMessagingBus.post(new EndpointLoadedEvent(flag, endpoint2));
            return endpoint2;
        }
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public EndpointLoadedEvent produceEndpointLoad()
    {
        return new EndpointLoadedEvent(true, getCachedEndpoint());
    }

    public void removeEndpoint()
    {
        userManager.removeEndpointSharedPreferences(authenticationManager.getAccountId());
        endpointMap.remove(authenticationManager.getAccountId());
        GlobalMessagingBus.post(new EndpointLoadedEvent(false, null));
    }

    public void setConfig(HttpConfig httpconfig)
    {
        config = httpconfig;
        endpoint = null;
    }

}
