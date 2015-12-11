// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.util.MicrodataCollectionUtils;
import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.model:
//            FormFieldType

public class MicrodataFormField
{
    public static class Builder
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
            return new MicrodataFormField(this);
        }

        public Builder defaultValue(String s)
        {
            defaultValue = s;
            return this;
        }

        public Builder label(String s)
        {
            label = s;
            return this;
        }

        public Builder maximum(String s)
        {
            maximum = s;
            return this;
        }

        public Builder minimum(String s)
        {
            minimum = s;
            return this;
        }

        public Builder options(List list)
        {
            options = list;
            return this;
        }

        public Builder order(int i)
        {
            order = i;
            return this;
        }

        public Builder type(FormFieldType formfieldtype)
        {
            type = formfieldtype;
            return this;
        }









        public Builder(String s)
        {
            name = s;
        }
    }


    private final String defaultValue;
    private final String label;
    private final String maximum;
    private final String minimum;
    private final String name;
    private final List options;
    private final int order;
    private final FormFieldType type;

    private MicrodataFormField(Builder builder)
    {
        name = builder.name;
        label = builder.label;
        defaultValue = builder.defaultValue;
        options = MicrodataCollectionUtils.unmodifiableList(builder.options);
        type = getType(builder);
        order = builder.order;
        minimum = builder.minimum;
        maximum = builder.maximum;
    }


    private FormFieldType getType(Builder builder)
    {
        if (builder.type == null)
        {
            if (builder.options != null && builder.options.size() > 0)
            {
                return FormFieldType.SELECT;
            } else
            {
                return FormFieldType.TEXT;
            }
        } else
        {
            return builder.type;
        }
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public String getLabel()
    {
        return label;
    }

    public String getMaximum()
    {
        return maximum;
    }

    public String getMinimum()
    {
        return minimum;
    }

    public String getName()
    {
        return name;
    }

    public List getOptions()
    {
        return options;
    }

    public int getOrder()
    {
        return order;
    }

    public FormFieldType getType()
    {
        return type;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("name", name);
        simpletostringbuilder.append("label", label);
        simpletostringbuilder.append("order", order);
        simpletostringbuilder.append("defaultValue", defaultValue);
        simpletostringbuilder.append("options", options);
        return simpletostringbuilder.toString();
    }
}
