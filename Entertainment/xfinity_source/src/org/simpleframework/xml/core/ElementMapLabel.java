// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Qualifier, Entry, 
//            Contact, ClassType, CompositeMap, CompositeInlineMap, 
//            ElementException, MapFactory, Factory, Expression, 
//            Decorator, Context, Converter

class ElementMapLabel extends TemplateLabel
{

    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private Entry entry;
    private Format format;
    private boolean inline;
    private Class items[];
    private ElementMap label;
    private String name;
    private String parent;
    private Expression path;
    private boolean required;
    private Class type;

    public ElementMapLabel(Contact contact, ElementMap elementmap, Format format1)
    {
        detail = new Introspector(contact, this, format1);
        decorator = new Qualifier(contact);
        entry = new Entry(contact, elementmap);
        required = elementmap.required();
        type = contact.getType();
        inline = elementmap.inline();
        name = elementmap.name();
        data = elementmap.data();
        format = format1;
        label = elementmap;
    }

    private Type getMap()
    {
        return new ClassType(type);
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
        Type type1 = getMap();
        if (!label.inline())
        {
            return new CompositeMap(context, entry, type1);
        } else
        {
            return new CompositeInlineMap(context, entry, type1);
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
        if (items == null)
        {
            items = contact.getDependents();
        }
        if (items == null)
        {
            throw new ElementException("Unable to determine type for %s", new Object[] {
                contact
            });
        }
        if (items.length == 0)
        {
            return new ClassType(java/lang/Object);
        } else
        {
            return new ClassType(items[0]);
        }
    }

    public Object getEmpty(Context context)
        throws Exception
    {
        context = new MapFactory(context, new ClassType(type));
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
        if (detail.isEmpty(parent))
        {
            parent = detail.getEntry();
        }
        return style.getElement(parent);
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
        Style style = format.getStyle();
        String s = entry.getEntry();
        if (!label.inline())
        {
            s = detail.getName();
        }
        return style.getElement(s);
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
