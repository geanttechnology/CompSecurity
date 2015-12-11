// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.client;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.drm.java.client:
//            ClientStateInterface, SecurityToken, SecurityTokenType

public class ClientState
    implements ClientStateInterface
{

    private Map tokens;

    public ClientState()
    {
        tokens = new HashMap();
    }

    public void addSecurityToken(SecurityToken securitytoken)
    {
        synchronized (tokens)
        {
            tokens.put(securitytoken.getType(), securitytoken);
        }
        return;
        securitytoken;
        map;
        JVM INSTR monitorexit ;
        throw securitytoken;
    }

    public void deleteAllSecurityTokens()
    {
        tokens = new HashMap();
    }

    public Map getTokens()
    {
        return tokens;
    }

    public SecurityToken retrieveSecurityToken(SecurityTokenType securitytokentype)
    {
        synchronized (tokens)
        {
            securitytokentype = (SecurityToken)tokens.get(securitytokentype);
        }
        return securitytokentype;
        securitytokentype;
        map;
        JVM INSTR monitorexit ;
        throw securitytokentype;
    }

    public void setTokens(Map map)
    {
        tokens = map;
    }
}
