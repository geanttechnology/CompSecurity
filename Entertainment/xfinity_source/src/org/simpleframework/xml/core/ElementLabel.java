// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Qualifier, Contact, 
//            Context, Primitive, Composite, Expression, 
//            OverrideType, Decorator, Converter

class ElementLabel extends TemplateLabel
{

    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private Format format;
    private Element label;
    private String name;
    private Class override;
    private Expression path;
    private boolean required;
    private Class type;

    public ElementLabel(Contact contact, Element element, Format format1)
    {
        detail = new Introspector(contact, this, format1);
        decorator = new Qualifier(contact);
        required = element.required();
        type = contact.getType();
        override = element.type();
        data = element.data();
        name = element.name();
        format = format1;
        label = element;
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public Contact getContact()
    {
        return detail.getContact();
    }

    public Converter getConverter(Context context)
        throws Exception
    {
        Contact contact = getContact();
        if (context.isPrimitive(contact))
        {
            return new Primitive(context, contact);
        }
        if (override == Void.TYPE)
        {
            return new Composite(context, contact);
        } else
        {
            return new Composite(context, contact, override);
        }
    }

    public Decorator getDecorator()
        throws Exception
    {
        return decorator;
    }

    public Object getEmpty(Context context)
    {
        return null;
    }

    public Expression getExpression()
        throws Exception
    {
        if (path == null)
        {
            path = detail.getExpression();
        }
        return path;
    }

    public String getName()
        throws Exception
    {
        return format.getStyle().getElement(detail.getName());
    }

    public String getOverride()
    {
        return name;
    }

    public String getPath()
        throws Exception
    {
        return getExpression().getElement(getName());
    }

    public Class getType()
    {
        if (override == Void.TYPE)
        {
            return type;
        } else
        {
            return override;
        }
    }

    public Type getType(Class class1)
    {
        class1 = getContact();
        if (override == Void.TYPE)
        {
            return class1;
        } else
        {
            return new OverrideType(class1, override);
        }
    }

    public boolean isData()
    {
        return data;
    }

    public boolean isRequired()
    {
        return required;
    }

    public String toString()
    {
        return detail.toString();
    }
}
