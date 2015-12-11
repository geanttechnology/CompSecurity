// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.DidYouMean;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class DidYouMeanEntity extends RetailSearchEntity
    implements DidYouMean
{

    private List correctedQuery;
    private List detailLabel;
    private List formattedLabel;
    private List formattedOriginalQueryLabel;
    private String label;

    public DidYouMeanEntity()
    {
    }

    public List getCorrectedQuery()
    {
        return correctedQuery;
    }

    public List getDetailLabel()
    {
        return detailLabel;
    }

    public List getFormattedLabel()
    {
        return formattedLabel;
    }

    public List getFormattedOriginalQueryLabel()
    {
        return formattedOriginalQueryLabel;
    }

    public String getLabel()
    {
        return label;
    }

    public void setCorrectedQuery(List list)
    {
        correctedQuery = list;
    }

    public void setDetailLabel(List list)
    {
        detailLabel = list;
    }

    public void setFormattedLabel(List list)
    {
        formattedLabel = list;
    }

    public void setFormattedOriginalQueryLabel(List list)
    {
        formattedOriginalQueryLabel = list;
    }

    public void setLabel(String s)
    {
        label = s;
    }
}
