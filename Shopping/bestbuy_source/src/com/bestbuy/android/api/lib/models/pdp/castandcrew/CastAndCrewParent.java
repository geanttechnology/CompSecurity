// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.castandcrew;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.castandcrew:
//            SICastAndCrewResponse

public class CastAndCrewParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SICastAndCrewResponse si;

    public CastAndCrewParent()
    {
    }

    public SICastAndCrewResponse getSi()
    {
        return si;
    }

    public void setSi(SICastAndCrewResponse sicastandcrewresponse)
    {
        si = sicastandcrewresponse;
    }
}
