// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.a;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.i;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bv, do, af, 
//            dg, be, an, ai, 
//            ak

class AttributeLabel extends en
{

    private an decorator;
    private bv detail;
    private String empty;
    private i format;
    private a label;
    private String name;
    private be path;
    private boolean required;
    private Class type;

    public AttributeLabel(af af1, a a1, i j)
    {
        detail = new bv(af1, this, j);
        decorator = new do(af1);
        required = a1.c();
        type = af1.C_();
        empty = a1.b();
        name = a1.a();
        format = j;
        label = a1;
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public af getContact()
    {
        return detail.a;
    }

    public ak getConverter(ai ai)
    {
        String s = getEmpty(ai);
        return new dg(ai, getContact(), s);
    }

    public an getDecorator()
    {
        return decorator;
    }

    public volatile Object getEmpty(ai ai)
    {
        return getEmpty(ai);
    }

    public String getEmpty(ai ai)
    {
        if (org.simpleframework.xml.core.bv.a(empty))
        {
            return null;
        } else
        {
            return empty;
        }
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
        return format.c.a(detail.b());
    }

    public String getOverride()
    {
        return name;
    }

    public String getPath()
    {
        return getExpression().b(getName());
    }

    public Class getType()
    {
        return type;
    }

    public boolean isAttribute()
    {
        return true;
    }

    public boolean isData()
    {
        return false;
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
