// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.RemoveFavoritesResult;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RemoveFavoritesResultEntity extends RetailSearchEntity
    implements RemoveFavoritesResult
{

    private boolean customerRequired;
    private List errors;
    private boolean succeeded;

    public RemoveFavoritesResultEntity()
    {
    }

    public boolean getCustomerRequired()
    {
        return customerRequired;
    }

    public List getErrors()
    {
        return errors;
    }

    public boolean getSucceeded()
    {
        return succeeded;
    }

    public void setCustomerRequired(boolean flag)
    {
        customerRequired = flag;
    }

    public void setErrors(List list)
    {
        errors = list;
    }

    public void setSucceeded(boolean flag)
    {
        succeeded = flag;
    }
}
