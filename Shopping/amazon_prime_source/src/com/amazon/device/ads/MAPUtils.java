// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.amazon.identity.auth.device.api.MAPAccountManager;

// Referenced classes of package com.amazon.device.ads:
//            ReflectionUtils, DebugProperties, StringUtils, MobileAdsInfoStore

public class MAPUtils
{

    private final DebugProperties debugProperties;
    private String directedId;
    private final boolean isMAPAvailable;

    public MAPUtils()
    {
        this(new ReflectionUtils(), DebugProperties.getInstance(), null);
    }

    public MAPUtils(ReflectionUtils reflectionutils, DebugProperties debugproperties, String s)
    {
        isMAPAvailable = reflectionutils.isClassAvailable("com.amazon.identity.auth.device.api.MAPAccountManager");
        debugProperties = debugproperties;
        directedId = s;
    }

    private boolean isDirectedIdAvailable()
    {
        if (StringUtils.isNullOrEmpty(directedId) && isMAPAvailable)
        {
            directedId = (new MAPAccountManager(MobileAdsInfoStore.getInstance().getApplicationContext())).getAccount();
        }
        return !StringUtils.isNullOrEmpty(directedId) || debugProperties.getDebugPropertyAsString("debug.directedId", null) != null;
    }

    public String getDirectedId()
    {
        if (isDirectedIdAvailable())
        {
            return debugProperties.getDebugPropertyAsString("debug.directedId", directedId);
        } else
        {
            return null;
        }
    }

    public boolean isMAPAvailable()
    {
        return isMAPAvailable;
    }
}
