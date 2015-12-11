// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand

static abstract class T
{

    private String httpPath;
    private String installationId;
    private JSONObject jsonParameters;
    private String localId;
    public String masterKey;
    private self method;
    private String operationSetUUID;
    private String sessionToken;

    public T httpPath(String s)
    {
        httpPath = s;
        return self();
    }

    public self installationId(String s)
    {
        installationId = s;
        return self();
    }

    public self jsonParameters(JSONObject jsonobject)
    {
        jsonParameters = jsonobject;
        return self();
    }

    public self localId(String s)
    {
        localId = s;
        return self();
    }

    public self masterKey(String s)
    {
        masterKey = s;
        return self();
    }

    public self method(self self1)
    {
        method = self1;
        return self();
    }

    public self operationSetUUID(String s)
    {
        operationSetUUID = s;
        return self();
    }

    abstract self self();

    public self sessionToken(String s)
    {
        sessionToken = s;
        return self();
    }








    ()
    {
        method = T;
    }
}
