// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth.register;

import org.json.JSONObject;

public class PandaTokenExchangeRequest
{

    private final JSONObject mRequest;

    PandaTokenExchangeRequest(JSONObject jsonobject)
    {
        mRequest = jsonobject;
    }

    public JSONObject getRequest()
    {
        return mRequest;
    }
}
