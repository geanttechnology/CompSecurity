// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.pageconfiguration:
//            SIPageConfiguration

public class PageConfigurationResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SIPageConfiguration si;

    public PageConfigurationResponse()
    {
    }

    public SIPageConfiguration getSi()
    {
        return si;
    }

    public void setSi(SIPageConfiguration sipageconfiguration)
    {
        si = sipageconfiguration;
    }
}
