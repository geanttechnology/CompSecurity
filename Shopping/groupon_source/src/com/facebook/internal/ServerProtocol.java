// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.Collection;

// Referenced classes of package com.facebook.internal:
//            Utility

public final class ServerProtocol
{

    private static final String TAG = com/facebook/internal/ServerProtocol.getName();
    public static final Collection errorsProxyAuthDisabled = Utility.unmodifiableCollection(new String[] {
        "service_disabled", "AndroidAuthKillSwitchException"
    });
    public static final Collection errorsUserCanceled = Utility.unmodifiableCollection(new String[] {
        "access_denied", "OAuthAccessDeniedException"
    });

    public ServerProtocol()
    {
    }

    public static final String getAPIVersion()
    {
        return "v2.3";
    }

    public static final String getDialogAuthority()
    {
        return String.format("m.%s", new Object[] {
            FacebookSdk.getFacebookDomain()
        });
    }

    public static final String getGraphUrlBase()
    {
        return String.format("https://graph.%s", new Object[] {
            FacebookSdk.getFacebookDomain()
        });
    }

    public static final String getGraphVideoUrlBase()
    {
        return String.format("https://graph-video.%s", new Object[] {
            FacebookSdk.getFacebookDomain()
        });
    }

}
