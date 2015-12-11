// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Savings;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SavingsEntity extends RetailSearchEntity
    implements Savings
{

    private String amountSaved;
    private int percentageSaved;
    private List savedMessage;

    public SavingsEntity()
    {
    }

    public String getAmountSaved()
    {
        return amountSaved;
    }

    public int getPercentageSaved()
    {
        return percentageSaved;
    }

    public List getSavedMessage()
    {
        return savedMessage;
    }

    public void setAmountSaved(String s)
    {
        amountSaved = s;
    }

    public void setPercentageSaved(int i)
    {
        percentageSaved = i;
    }

    public void setSavedMessage(List list)
    {
        savedMessage = list;
    }
}
