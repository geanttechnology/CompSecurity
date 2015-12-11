// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            HomeFragmentResponseData

public class HomeFragmentResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x858fc98fee789e36L;
    private HomeFragmentResponseData si;

    public HomeFragmentResponse()
    {
    }

    public HomeFragmentResponseData getSi()
    {
        return si;
    }

    public void setSi(HomeFragmentResponseData homefragmentresponsedata)
    {
        si = homefragmentresponsedata;
    }
}
