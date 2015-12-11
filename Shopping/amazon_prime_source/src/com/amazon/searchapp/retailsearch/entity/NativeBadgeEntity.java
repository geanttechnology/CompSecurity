// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.NativeBadge;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class NativeBadgeEntity extends RetailSearchEntity
    implements NativeBadge
{

    private List badgeText;
    private List label;

    public NativeBadgeEntity()
    {
    }

    public List getBadgeText()
    {
        return badgeText;
    }

    public List getLabel()
    {
        return label;
    }

    public void setBadgeText(List list)
    {
        badgeText = list;
    }

    public void setLabel(List list)
    {
        label = list;
    }
}
