// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.service.core.AbTestService;

public class GoogleSignInAbTestHelper
{

    public static final String PREVIOUS_GOOGLE_EXPERIENCE_PREFIX = "previous_";
    private AbTestService abTestService;

    public GoogleSignInAbTestHelper()
    {
    }

    public boolean isCurrentGoogleLoginUSCA1508Bottom()
    {
        return abTestService.isVariantEnabledAndUSCA("googleLoginUSCA1508", "Bottom_Google");
    }

    public boolean isCurrentGoogleLoginUSCA1508Enabled()
    {
        return isCurrentGoogleLoginUSCA1508Bottom() || isCurrentGoogleLoginUSCA1508Top();
    }

    public boolean isCurrentGoogleLoginUSCA1508Top()
    {
        return abTestService.isVariantEnabledAndUSCA("googleLoginUSCA1508", "Top_Google");
    }

    public boolean isGoogleLoginUSCA1508Bottom()
    {
        return isCurrentGoogleLoginUSCA1508Bottom() || !isCurrentGoogleLoginUSCA1508Enabled() && isPreviouslyGoogleLoginUSCA1508Bottom();
    }

    public boolean isGoogleLoginUSCA1508Enabled()
    {
        return isGoogleLoginUSCA1508Bottom() || isGoogleLoginUSCA1508Top();
    }

    public boolean isGoogleLoginUSCA1508Top()
    {
        return isCurrentGoogleLoginUSCA1508Top() || !isCurrentGoogleLoginUSCA1508Enabled() && isPreviouslyGoogleLoginUSCA1508Top();
    }

    public boolean isPreviouslyGoogleLoginUSCA1508Bottom()
    {
        return abTestService.isVariantEnabledAndUSCA("previous_googleLoginUSCA1508", "Bottom_Google");
    }

    public boolean isPreviouslyGoogleLoginUSCA1508Top()
    {
        return abTestService.isVariantEnabledAndUSCA("previous_googleLoginUSCA1508", "Top_Google");
    }
}
