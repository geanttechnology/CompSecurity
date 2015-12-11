// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.techsupport;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.techsupport:
//            TechSupportDetailsResponse

public class PDPTechSupportParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private TechSupportDetailsResponse si;

    public PDPTechSupportParent()
    {
    }

    public TechSupportDetailsResponse getSi()
    {
        return si;
    }

    public void setSi(TechSupportDetailsResponse techsupportdetailsresponse)
    {
        si = techsupportdetailsresponse;
    }
}
