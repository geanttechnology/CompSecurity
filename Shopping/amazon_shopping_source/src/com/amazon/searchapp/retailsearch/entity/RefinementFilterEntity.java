// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.RefinementFilter;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RefinementFilterEntity extends RetailSearchEntity
    implements RefinementFilter
{

    private List ancestry;
    private RefinementLink clearLink;
    private String detail;
    private String group;
    private String id;
    private String label;
    private boolean removesSiblings;
    private String type;
    private List values;

    public RefinementFilterEntity()
    {
    }

    public List getAncestry()
    {
        return ancestry;
    }

    public RefinementLink getClearLink()
    {
        return clearLink;
    }

    public String getDetail()
    {
        return detail;
    }

    public String getGroup()
    {
        return group;
    }

    public String getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public boolean getRemovesSiblings()
    {
        return removesSiblings;
    }

    public String getType()
    {
        return type;
    }

    public List getValues()
    {
        return values;
    }

    public void setAncestry(List list)
    {
        ancestry = list;
    }

    public void setClearLink(RefinementLink refinementlink)
    {
        clearLink = refinementlink;
    }

    public void setDetail(String s)
    {
        detail = s;
    }

    public void setGroup(String s)
    {
        group = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setRemovesSiblings(boolean flag)
    {
        removesSiblings = flag;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setValues(List list)
    {
        values = list;
    }
}
