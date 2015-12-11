// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.legacy.orbitconfig:
//            ConfigIntentUri

public class AvailableUpdateDetails
    implements Serializable
{

    private ConfigIntentUri configIntentUri;
    private boolean notifyEnabled;
    private String statusBarText;
    private String statusItemBodyText;
    private String statusItemTitleText;

    private AvailableUpdateDetails()
    {
    }

    private AvailableUpdateDetails(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        notifyEnabled = Builder.access._mth000(builder);
        statusBarText = Builder.access._mth100(builder);
        statusItemTitleText = Builder.access._mth200(builder);
        statusItemBodyText = Builder.access._mth300(builder);
        configIntentUri = Builder.access._mth400(builder);
    }

    AvailableUpdateDetails(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public ConfigIntentUri getConfigIntentUri()
    {
        return configIntentUri;
    }

    public String getStatusBarText()
    {
        return statusBarText;
    }

    public String getStatusItemBodyText()
    {
        return statusItemBodyText;
    }

    public String getStatusItemTitleText()
    {
        return statusItemTitleText;
    }

    public boolean isNotifyEnabled()
    {
        return notifyEnabled;
    }
}
