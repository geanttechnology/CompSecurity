// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import gu;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.bestbuy.android.api.lib.models.registry:
//            RegistryWishList

public class LoggedInUserProfile
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String access_token;
    private List entities;
    private String errorCode;
    private String expires_in;
    private boolean hasError;
    private boolean hasWeddingRegistry;
    private boolean isAttachedUser;
    private String refreshToken;
    private RegistryWishList registry;

    public LoggedInUserProfile()
    {
        isAttachedUser = false;
    }

    public String getAccess_token()
    {
        return access_token;
    }

    public List getEntities()
    {
        return entities;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public String getExpires_in()
    {
        return expires_in;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }

    public RegistryWishList getRegistry()
    {
        return registry;
    }

    public boolean isAttachedUser()
    {
        return isAttachedUser;
    }

    public boolean isHasError()
    {
        return hasError;
    }

    public boolean isHasWeddingRegistry()
    {
        return hasWeddingRegistry;
    }

    public void setAccess_token(String s)
    {
        access_token = s;
    }

    public void setAttachedUser(boolean flag)
    {
        isAttachedUser = flag;
    }

    public void setEntities(List list)
    {
        entities = list;
    }

    public void setErrorCode(String s)
    {
        errorCode = s;
    }

    public void setExpires_in(String s)
    {
        expires_in = s;
    }

    public void setHasError(boolean flag)
    {
        hasError = flag;
    }

    public void setHasWeddingRegistry(boolean flag)
    {
        hasWeddingRegistry = flag;
    }

    public void setRefreshToken(String s)
    {
        refreshToken = s;
    }

    public void setRegistry(RegistryWishList registrywishlist)
    {
        registry = registrywishlist;
    }
}
