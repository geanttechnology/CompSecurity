// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.WebResponseHeaders;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            CredentialStatus

public final class CredentialStatusChecker
{

    private CredentialStatusChecker()
    {
    }

    public static CredentialStatus checkResponse(WebResponseHeaders webresponseheaders)
    {
        CredentialStatus credentialstatus = CredentialStatus.CredentialStatusOK;
        String s = getErrorText(webresponseheaders);
        String s1 = getWarningText(webresponseheaders);
        if ("invalid_credentials".equals(s))
        {
            webresponseheaders = CredentialStatus.CredentialStatusInvalid;
        } else
        {
            if ("expired_credentials".equals(s))
            {
                return CredentialStatus.CredentialStatusInvalid;
            }
            if ("stale_credentials".equals(s1))
            {
                return CredentialStatus.CredentialStatusStale;
            }
            if (s != null && !s.equals(""))
            {
                return CredentialStatus.CredentialStatusUnknownError;
            }
            webresponseheaders = credentialstatus;
            if (s1 != null)
            {
                webresponseheaders = credentialstatus;
                if (!s1.equals(""))
                {
                    return CredentialStatus.CredentialStatusUnknownWarning;
                }
            }
        }
        return webresponseheaders;
    }

    public static String getErrorText(WebResponseHeaders webresponseheaders)
    {
        return webresponseheaders.getHeaderByName("X-ADP-Error");
    }

    public static String getWarningText(WebResponseHeaders webresponseheaders)
    {
        return webresponseheaders.getHeaderByName("X-ADP-Warn");
    }
}
