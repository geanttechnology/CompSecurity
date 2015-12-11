// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.content.Context;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.nautilus.domain.EbaySite;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

private static abstract class <init>
{

    public tType adType;
    public EbayCguidPersister cguidPersister;
    public boolean generateRequestContextOnly;
    public String iafToken;
    public EbaySite site;

    public abstract com.ebay.common.net.api.rtm.init> getRequest(Context context, String s, String s1);

    public abstract boolean validateResult(com.ebay.common.net.api.rtm.init> init>, List list);

    private tType()
    {
        adType = tType.NONE;
    }

    tType.NONE(tType.NONE none)
    {
        this();
    }
}
