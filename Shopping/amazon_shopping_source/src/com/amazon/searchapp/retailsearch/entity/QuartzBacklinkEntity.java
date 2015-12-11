// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.QuartzBacklink;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class QuartzBacklinkEntity extends RetailSearchEntity
    implements QuartzBacklink
{

    private List formattedLabel;

    public QuartzBacklinkEntity()
    {
    }

    public List getFormattedLabel()
    {
        return formattedLabel;
    }

    public void setFormattedLabel(List list)
    {
        formattedLabel = list;
    }
}
