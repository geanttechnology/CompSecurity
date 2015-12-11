// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.xip.XipResponseHandler;
import com.comcast.cim.model.user.AuthKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class AuthResponseHandler extends XipResponseHandler
{

    private AuthKeys authKeys;
    private ObjectMapper objectMapper;

    public AuthResponseHandler(ObjectMapper objectmapper)
    {
        authKeys = null;
        objectMapper = objectmapper;
    }

    public AuthKeys getAuthKeys()
    {
        return authKeys;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        try
        {
            authKeys = (AuthKeys)objectMapper.readValue(inputstream, com/comcast/cim/model/user/AuthKeys);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimException(inputstream);
        }
    }
}
