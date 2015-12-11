// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataForm, MicrodataFormValue

public class MicrodataFormImpl
    implements MicrodataForm
{

    private final String id;
    private final boolean isCollection;
    private final List values;

    public MicrodataFormImpl(String s, MicrodataFormValue microdataformvalue)
    {
        id = s;
        values = new ArrayList();
        values.add(microdataformvalue);
        isCollection = false;
    }

    public MicrodataFormImpl(String s, List list)
    {
        id = s;
        values = list;
        isCollection = true;
    }

    public String getId()
    {
        return id;
    }

    public MicrodataFormValue getValue()
    {
        if (values.isEmpty())
        {
            return null;
        } else
        {
            return (MicrodataFormValue)values.get(0);
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
        simpletostringbuilder.append("id", id);
        simpletostringbuilder.append("values", values);
        return simpletostringbuilder.toString();
    }
}
