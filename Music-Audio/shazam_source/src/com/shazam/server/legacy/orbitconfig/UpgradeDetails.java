// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.legacy.orbitconfig:
//            ConfigIntentUri

public class UpgradeDetails
    implements Serializable
{

    private ConfigIntentUri configIntentUri;

    private UpgradeDetails()
    {
    }

    private UpgradeDetails(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        configIntentUri = Builder.access._mth000(builder);
    }

    UpgradeDetails(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public ConfigIntentUri getConfigIntentUri()
    {
        return configIntentUri;
    }
}
