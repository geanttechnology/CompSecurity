// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataLink, MicrodataLinkValue

public class MicrodataLinkImpl
    implements MicrodataLink
{

    private final boolean isCollection;
    private final String relation;
    private final List values;

    public MicrodataLinkImpl(String s, MicrodataLinkValue microdatalinkvalue)
    {
        relation = s;
        values = new ArrayList();
        values.add(microdatalinkvalue);
        isCollection = false;
    }

    public MicrodataLinkImpl(String s, List list)
    {
        relation = s;
        values = list;
        isCollection = true;
    }

    public String getRelation()
    {
        return relation;
    }

    public MicrodataLinkValue getValue()
    {
        if (values.isEmpty())
        {
            return null;
        } else
        {
            return (MicrodataLinkValue)values.get(0);
        }
    }

    public List getValues()
    {
        return values;
    }

    public boolean isCollection()
    {
        return isCollection;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("relation", relation);
        simpletostringbuilder.append("values", values);
        return simpletostringbuilder.toString();
    }
}
