// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, GroupExtractor, ElementMapLabel, Label, 
//            UnionException, CompositeMapUnion, Contact, Expression, 
//            Context, Converter, Decorator

class ElementMapUnionLabel extends TemplateLabel
{

    private Contact contact;
    private GroupExtractor extractor;
    private Label label;
    private Expression path;

    public ElementMapUnionLabel(Contact contact1, ElementMapUnion elementmapunion, ElementMap elementmap, Format format)
        throws Exception
    {
        extractor = new GroupExtractor(contact1, elementmapunion, format);
        label = new ElementMapLabel(contact1, elementmap, format);
        contact = contact1;
    }

    public Annotation getAnnotation()
    {
        return label.getAnnotation();
    }

    public Contact getContact()
    {
        return contact;
    }

    public Converter getConverter(Context context)
        throws Exception
    {
        Expression expression = getExpression();
        Contact contact1 = getContact();
        if (contact1 == null)
        {
            throw new UnionException("Union %s was not declared on a field or method", new Object[] {
                label
            });
        } else
        {
            return new CompositeMapUnion(context, extractor, expression, contact1);
        }
    }

    public Decorator getDecorator()
        throws Exception
    {
        return label.getDecorator();
    }

    public Type getDependent()
        throws Exception
    {
        return label.getDependent();
    }

    public Object getEmpty(Context context)
        throws Exception
    {
        return label.getEmpty(context);
    }

    public String getEntry()
        throws Exception
    {
        return label.getEntry();
    }

    public Expression getExpression()
        throws Exception
    {
        if (path == null)
        {
            path = label.getExpression();
        }
        return path;
    }

    public Label getLabel(Class class1)
    {
        return this;
    }

    public String getName()
        throws Exception
    {
        return label.getName();
    }

    public String[] getNames()
        throws Exception
    {
        return extractor.getNames();
    }

    public String getOverride()
    {
        return label.getOverride();
    }

    public String getPath()
        throws Exception
    {
        return label.getPath();
    }

    public String[] getPaths()
        throws Exception
    {
        return extractor.getPaths();
    }

    public Class getType()
    {
        return label.getType();
    }

    public Type getType(Class class1)
    {
        return getContact();
    }

    public boolean isCollection()
    {
        return label.isCollection();
    }

    public boolean isData()
    {
        return label.isData();
    }

    public boolean isInline()
    {
        return label.isInline();
    }

    public boolean isRequired()
    {
        return label.isRequired();
    }

    public boolean isUnion()
    {
        return true;
    }

    public String toString()
    {
        return label.toString();
    }
}
