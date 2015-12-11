// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.techsupport;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.techsupport:
//            TechSupportDetails

public class TechSupportDetailsChild
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private TechSupportDetails techSupportDetails;

    public TechSupportDetailsChild()
    {
    }

    public TechSupportDetails getTechSupportDetails()
    {
        return techSupportDetails;
    }

    public void setTechSupportDetails(TechSupportDetails techsupportdetails)
    {
        techSupportDetails = techsupportdetails;
    }
}
