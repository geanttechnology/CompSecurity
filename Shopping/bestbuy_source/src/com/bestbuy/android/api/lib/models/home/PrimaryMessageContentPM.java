// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            GHPBanner

public class PrimaryMessageContentPM
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x36bdf215f792db74L;
    private GHPBanner GHP;

    public PrimaryMessageContentPM()
    {
    }

    public GHPBanner getGHP()
    {
        return GHP;
    }

    public void setGHP(GHPBanner ghpbanner)
    {
        GHP = ghpbanner;
    }
}
