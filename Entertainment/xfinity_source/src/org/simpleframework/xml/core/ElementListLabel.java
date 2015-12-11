// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Qualifier, Contact, 
//            Context, CompositeList, PrimitiveList, CompositeInlineList, 
//            PrimitiveInlineList, ElementException, ClassType, CollectionFactory, 
//            Factory, Expression, Decorator, Converter

class ElementListLabel extends TemplateLabel
{

    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private String entry;
    private Format format;
    private boolean inline;
    private Class item;
    private ElementList label;
    private String name;
    private Expression path;
    private boolean required;
    private Class type;

    public ElementListLabel(Contact contact, ElementList elementlist, Format format1)
    {
        detail = new Introspector(contact, this, format1);
        decorator = new Qualifier(contact);
        required = elementlist.required();
        type = contact.getType();
        inline = elementlist.inline();
        entry = elementlist.entry();
        data = elementlist.data();
        item = elementlist.type();
        name = elementlist.name();
        format = format1;
        label = elementlist;
    }

    private Converter getConverter(Context context, String s)
        throws Exception
    {
        Type type1 = getDependent();
        Contact contact = getContact();
        if (!context.isPrimitive(type1))
        {
            return new CompositeList(context, contact, type1, s);
        } else
        {
            return new PrimitiveList(context, contact, type1, s);
        }
    }

    private Converter getInlineConverter(Context context, String s)
        throws Exception
    {
        Type type1 = getDependent();
        Contact contact = getContact();
        if (!context.isPrimitive(type1))
        {
            return new CompositeInlineList(context, contact, type1, s);
        } else
        {
            return new PrimitiveInlineList(context, contact, type1, s);
        }
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
        String s = getEntry();
        if (!label.inline())
        {
            return getConverter(context, s);
        } else
        {
            return getInlineConverter(context, s);
        }
    }

    public Decorator getDecorator()
        throws Exception
    {
        return decorator;
    }

    public Type getDependent()
        throws Exception
    {
        Contact contact = getContact();
        if (item == Void.TYPE)
        {
            item = contact.getDependent();
        }
        if (item == null)
        {
            throw new ElementException("Unable to determine generic type for %s", new Object[] {
                contact
            });
        } else
        {
            return new ClassType(item);
        }
    }

    public Object getEmpty(Context context)
        throws Exception
    {
        context = new CollectionFactory(context, new ClassType(type));
        if (!label.empty())
        {
            return context.getInstance();
        } else
        {
            return null;
        }
    }

    public String getEntry()
        throws Exception
    {
        Style style = format.getStyle();
        if (detail.isEmpty(entry))
        {
            entry = detail.getEntry();
        }
        return style.getElement(entry);
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
        return type;
    }

    public boolean isCollection()
    {
        return true;
    }

    public boolean isData()
    {
        return data;
    }

    public boolean isInline()
    {
        return inline;
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
