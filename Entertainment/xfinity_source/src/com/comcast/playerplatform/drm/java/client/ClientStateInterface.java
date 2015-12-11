// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.client;


// Referenced classes of package com.comcast.playerplatform.drm.java.client:
//            SecurityToken, SecurityTokenType

public interface ClientStateInterface
{

    public abstract void addSecurityToken(SecurityToken securitytoken);

    public abstract void deleteAllSecurityTokens();

    public abstract SecurityToken retrieveSecurityToken(SecurityTokenType securitytokentype);
}
