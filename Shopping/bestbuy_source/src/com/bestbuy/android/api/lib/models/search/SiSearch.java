// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.search:
//            Si

public class SiSearch
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Si si;

    public SiSearch()
    {
    }

    public Si getSi()
    {
        return si;
    }

    public void setSi(Si si1)
    {
        si = si1;
    }
}
