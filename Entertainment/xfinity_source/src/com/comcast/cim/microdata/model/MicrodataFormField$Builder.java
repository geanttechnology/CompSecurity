// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataFormField, FormFieldType

public static class name
{

    private String defaultValue;
    private String label;
    private String maximum;
    private String minimum;
    private String name;
    private List options;
    private int order;
    private FormFieldType type;

    public MicrodataFormField build()
    {
        return new MicrodataFormField(this, null);
    }

    public name defaultValue(String s)
    {
        defaultValue = s;
        return this;
    }

    public defaultValue label(String s)
    {
        label = s;
        return this;
    }

    public label maximum(String s)
    {
        maximum = s;
        return this;
    }

    public maximum minimum(String s)
    {
        minimum = s;
        return this;
    }

    public minimum options(List list)
    {
        options = list;
        return this;
    }

    public options order(int i)
    {
        order = i;
        return this;
    }

    public order type(FormFieldType formfieldtype)
    {
        type = formfieldtype;
        return this;
    }









    public (String s)
    {
        name = s;
    }
}
