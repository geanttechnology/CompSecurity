// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.content.Context;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

private static final class <init> extends <init>
{

    public String promoPlacementID;

    public com.ebay.common.net.api.rtm.init> getRequest(Context context, String s, String s1)
    {
        return new com.ebay.common.net.api.rtm.init>(context, promoPlacementID, s, site, NautilusKernel.getAppVersionName(context), s1);
    }

    public boolean validateResult(com.ebay.common.net.api.rtm.ite ite, List list)
    {
        return true;
    }

    private ()
    {
        super(null);
    }

    ( )
    {
        this();
    }
}
