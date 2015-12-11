// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.b.f;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.d;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bv, do, af, 
//            ai, dg, s, be, 
//            cu, an, ak

class ElementLabel extends en
{

    private be cache;
    private boolean data;
    private an decorator;
    private bv detail;
    private Class expect;
    private i format;
    private d label;
    private String name;
    private String override;
    private String path;
    private boolean required;
    private Class type;

    public ElementLabel(af af1, d d1, i j)
    {
        detail = new bv(af1, this, j);
        decorator = new do(af1);
        required = d1.c();
        type = af1.C_();
        override = d1.a();
        expect = d1.d();
        data = d1.b();
        format = j;
        label = d1;
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public af getContact()
    {
        return detail.a;
    }

    public ak getConverter(ai ai1)
    {
        af af1 = getContact();
        if (ai1.b(af1))
        {
            return new dg(ai1, af1);
        }
        if (expect == Void.TYPE)
        {
            return new s(ai1, af1);
        } else
        {
            return new s(ai1, af1, expect);
        }
    }

    public an getDecorator()
    {
        return decorator;
    }

    public Object getEmpty(ai ai1)
    {
        return null;
    }

    public be getExpression()
    {
        if (cache == null)
        {
            cache = detail.c();
        }
        return cache;
    }

    public String getName()
    {
        if (name == null)
        {
            name = format.c.b(detail.b());
        }
        return name;
    }

    public String getOverride()
    {
        return override;
    }

    public String getPath()
    {
        if (path == null)
        {
            path = getExpression().a(getName());
        }
        return path;
    }

    public Class getType()
    {
        if (expect == Void.TYPE)
        {
            return type;
        } else
        {
            return expect;
        }
    }

    public f getType(Class class1)
    {
        class1 = getContact();
        if (expect == Void.TYPE)
        {
            return class1;
        } else
        {
            return new cu(class1, expect);
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
