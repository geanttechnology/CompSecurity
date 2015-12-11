// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.EditionsMetadata;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class EditionsMetadataEntity extends RetailSearchEntity
    implements EditionsMetadata
{

    private List label;
    private List typesLabel;

    public EditionsMetadataEntity()
    {
    }

    public List getLabel()
    {
        return label;
    }

    public List getTypesLabel()
    {
        return typesLabel;
    }

    public void setLabel(List list)
    {
        label = list;
    }

    public void setTypesLabel(List list)
    {
        typesLabel = list;
    }
}
