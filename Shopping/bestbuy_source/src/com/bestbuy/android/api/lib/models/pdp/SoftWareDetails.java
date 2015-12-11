// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            Requirement

public class SoftWareDetails
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Requirement requirements;
    private ArrayList specifications;

    public SoftWareDetails()
    {
    }

    public Requirement getRequirements()
    {
        return requirements;
    }

    public ArrayList getSpecifications()
    {
        return specifications;
    }

    public void setRequirements(Requirement requirement)
    {
        requirements = requirement;
    }

    public void setSpecifications(ArrayList arraylist)
    {
        specifications = arraylist;
    }
}
