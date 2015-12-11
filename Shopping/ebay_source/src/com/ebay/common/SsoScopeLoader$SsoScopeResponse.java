// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import org.json.JSONObject;

// Referenced classes of package com.ebay.common:
//            SsoResponse, SsoScopeLoader

private static final class <init> extends SsoResponse
{

    public String errorCode;
    public String errorDescription;
    public String idToken;

    public void parse(JSONObject jsonobject)
        throws com.ebay.nautilus.kernel.net.tion
    {
        if (SsoScopeLoader.log.ion)
        {
            SsoScopeLoader.log.ion((new StringBuilder()).append("SSO response: ").append(jsonobject).toString());
        }
        idToken = jsonobject.optString("id_token", null);
        errorDescription = jsonobject.optString("error_description", null);
        errorCode = jsonobject.optString("error_code", null);
    }

    private onseDataException()
    {
    }

    onseDataException(onseDataException onsedataexception)
    {
        this();
    }
}
