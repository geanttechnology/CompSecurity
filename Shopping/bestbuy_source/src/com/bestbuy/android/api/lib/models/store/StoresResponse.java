// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store:
//            Si

public class StoresResponse
    implements gu, Serializable
{

    private Si si;

    public StoresResponse()
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

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [si = ").append(si).append("]").toString();
    }
}
