// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider

class AnonymousAuthenticationProvider
    implements ParseAuthenticationProvider
{

    AnonymousAuthenticationProvider()
    {
    }

    public void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback parseauthenticationcallback)
    {
        try
        {
            parseauthenticationcallback.onSuccess(getAuthData());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParseAuthenticationProvider.ParseAuthenticationCallback parseauthenticationcallback)
        {
            throw new RuntimeException(parseauthenticationcallback);
        }
    }

    public void cancel()
    {
    }

    public void deauthenticate()
    {
    }

    public JSONObject getAuthData()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", UUID.randomUUID());
        return jsonobject;
    }

    public String getAuthType()
    {
        return "anonymous";
    }

    public boolean restoreAuthentication(JSONObject jsonobject)
    {
        return true;
    }
}
