// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.f;
import org.simpleframework.xml.g;

// Referenced classes of package org.simpleframework.xml.core:
//            en, ElementListLabel, bp, bx, 
//            eu, y, af, be, 
//            ai, ak, an

class ElementListUnionLabel extends en
{

    private af contact;
    private bp extractor;
    private bx label;
    private be path;

    public ElementListUnionLabel(af af, g g, f f, i i)
    {
        label = new ElementListLabel(af, f, i);
        extractor = new bp(af, g, i);
        contact = af;
    }

    public Annotation getAnnotation()
    {
        return label.getAnnotation();
    }

    public af getContact()
    {
        return contact;
    }

    public ak getConverter(ai ai)
    {
        be be = getExpression();
        af af = getContact();
        if (af == null)
        {
            throw new eu("Union %s was not declared on a field or method", new Object[] {
                label
            });
        } else
        {
            return new y(ai, extractor, be, af);
        }
    }

    public an getDecorator()
    {
        return label.getDecorator();
    }

    public org.simpleframework.xml.b.f getDependent()
    {
        return label.getDependent();
    }

    public Object getEmpty(ai ai)
    {
        return label.getEmpty(ai);
    }

    public String getEntry()
    {
        return label.getEntry();
    }

    public be getExpression()
    {
        if (path == null)
        {
            path = label.getExpression();
        }
        return path;
    }

    public bx getLabel(Class class1)
    {
        return this;
    }

    public String getName()
    {
        return label.getName();
    }

    public String[] getNames()
    {
        return extractor.d();
    }

    public String getOverride()
    {
        return label.getOverride();
    }

    public String getPath()
    {
        return label.getPath();
    }

    public String[] getPaths()
    {
        return extractor.e();
    }

    public Class getType()
    {
        return label.getType();
    }

    public org.simpleframework.xml.b.f getType(Class class1)
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

    public boolean isTextList()
    {
        return extractor.a.b != null;
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
