// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmusic;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpmusic:
//            SIMusic

public class PDPMusicParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SIMusic si;

    public PDPMusicParent()
    {
    }

    public SIMusic getSi()
    {
        return si;
    }

    public void setSi(SIMusic simusic)
    {
        si = simusic;
    }
}
