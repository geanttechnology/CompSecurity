// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            GHPLarge, GHPSmall

public class GHPBanner
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xef281485df2b55ddL;
    private GHPLarge large;
    private GHPSmall small;

    public GHPBanner()
    {
    }

    public GHPLarge getLarge()
    {
        return large;
    }

    public GHPSmall getSmall()
    {
        return small;
    }

    public void setLarge(GHPLarge ghplarge)
    {
        large = ghplarge;
    }

    public void setSmall(GHPSmall ghpsmall)
    {
        small = ghpsmall;
    }
}
