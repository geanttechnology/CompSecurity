// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.storage.DataStorage;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DMSSubAuthenticator

class ntials extends AccountCredentials
{

    final DMSSubAuthenticator this$0;
    final String val$directedId;

    public String getPrivateKey()
    {
        String s = DMSSubAuthenticator.access$700(DMSSubAuthenticator.this).getToken(val$directedId, DMSSubAuthenticator.access$800(DMSSubAuthenticator.this).deviceTypeInvariantForm);
        if (s != null)
        {
            return s;
        } else
        {
            return DMSSubAuthenticator.access$700(DMSSubAuthenticator.this).getToken(val$directedId, DMSSubAuthenticator.access$800(DMSSubAuthenticator.this).legacyToken);
        }
    }

    public String getToken()
    {
        String s = DMSSubAuthenticator.access$700(DMSSubAuthenticator.this).getToken(val$directedId, DMSSubAuthenticator.access$600(DMSSubAuthenticator.this).deviceTypeInvariantForm);
        if (s != null)
        {
            return s;
        } else
        {
            return DMSSubAuthenticator.access$700(DMSSubAuthenticator.this).getToken(val$directedId, DMSSubAuthenticator.access$600(DMSSubAuthenticator.this).legacyToken);
        }
    }

    public boolean isStale$faab209()
    {
        return false;
    }

    taKey()
    {
        this$0 = final_dmssubauthenticator;
        val$directedId = String.this;
        super();
    }
}
