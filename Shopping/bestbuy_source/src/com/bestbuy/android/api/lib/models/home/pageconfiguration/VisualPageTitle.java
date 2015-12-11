// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.pageconfiguration:
//            TallName, ShortName

public class VisualPageTitle
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private TallName Tall;
    private ShortName shortName;

    public VisualPageTitle()
    {
    }

    public ShortName getShortName()
    {
        return shortName;
    }

    public TallName getTall()
    {
        return Tall;
    }

    public void setShortName(ShortName shortname)
    {
        shortName = shortname;
    }

    public void setTall(TallName tallname)
    {
        Tall = tallname;
    }
}
