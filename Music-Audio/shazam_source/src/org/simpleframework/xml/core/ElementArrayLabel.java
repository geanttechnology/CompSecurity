// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.b.f;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.e;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bv, do, af, 
//            ai, t, dh, bs, 
//            m, c, bi, be, 
//            an, ak

class ElementArrayLabel extends en
{

    private boolean data;
    private an decorator;
    private bv detail;
    private String entry;
    private i format;
    private e label;
    private String name;
    private be path;
    private boolean required;
    private Class type;

    public ElementArrayLabel(af af1, e e1, i j)
    {
        detail = new bv(af1, this, j);
        decorator = new do(af1);
        required = e1.d();
        type = af1.C_();
        entry = e1.b();
        data = e1.c();
        name = e1.a();
        format = j;
        label = e1;
    }

    private ak getConverter(ai ai1, String s)
    {
        f f = getDependent();
        af af1 = getContact();
        if (!ai1.b(f))
        {
            return new t(ai1, af1, f, s);
        } else
        {
            return new dh(ai1, af1, f, s);
        }
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
        String s = getEntry();
        if (!type.isArray())
        {
            throw new bs("Type is not an array %s for %s", new Object[] {
                type, af1
            });
        } else
        {
            return getConverter(ai1, s);
        }
    }

    public an getDecorator()
    {
        return decorator;
    }

    public f getDependent()
    {
        Class class1 = type.getComponentType();
        if (class1 == null)
        {
            return new m(type);
        } else
        {
            return new m(class1);
        }
    }

    public Object getEmpty(ai ai1)
    {
        ai1 = new c(ai1, new m(type));
        if (!label.e())
        {
            return ai1.a();
        } else
        {
            return null;
        }
    }

    public String getEntry()
    {
        as as1 = format.c;
        if (bv.a(entry))
        {
            entry = detail.a();
        }
        return as1.b(entry);
    }

    public be getExpression()
    {
        if (path == null)
        {
            path = detail.c();
        }
        return path;
    }

    public String getName()
    {
        return format.c.b(detail.b());
    }

    public String getOverride()
    {
        return name;
    }

    public String getPath()
    {
        return getExpression().a(getName());
    }

    public Class getType()
    {
        return type;
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
