// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpaccessories;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpaccessories:
//            SIAccessories

public class PDPAccessoriesParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SIAccessories si;

    public PDPAccessoriesParent()
    {
    }

    public SIAccessories getSi()
    {
        return si;
    }

    public void setSi(SIAccessories siaccessories)
    {
        si = siaccessories;
    }
}
