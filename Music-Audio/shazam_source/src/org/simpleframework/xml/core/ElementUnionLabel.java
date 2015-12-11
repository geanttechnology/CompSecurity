// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.b.f;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.d;
import org.simpleframework.xml.j;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bp, ElementLabel, bx, 
//            eu, ab, cu, af, 
//            be, ai, ak, an

class ElementUnionLabel extends en
{

    private af contact;
    private bp extractor;
    private bx label;
    private be path;
    private j union;

    public ElementUnionLabel(af af, j j, d d, i i)
    {
        extractor = new bp(af, j, i);
        label = new ElementLabel(af, d, i);
        contact = af;
        union = j;
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
            return new ab(ai, extractor, be, af);
        }
    }

    public an getDecorator()
    {
        return label.getDecorator();
    }

    public f getDependent()
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
        af af = getContact();
        if (!extractor.b(class1))
        {
            throw new eu("No type matches %s in %s for %s", new Object[] {
                class1, union, af
            });
        } else
        {
            return extractor.a(class1);
        }
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

    public f getType(Class class1)
    {
        af af = getContact();
        if (!extractor.b(class1))
        {
            throw new eu("No type matches %s in %s for %s", new Object[] {
                class1, union, af
            });
        }
        if (extractor.a.containsKey(class1))
        {
            return new cu(af, class1);
        } else
        {
            return af;
        }
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
