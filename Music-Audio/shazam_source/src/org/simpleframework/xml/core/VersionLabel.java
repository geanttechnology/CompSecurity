// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.s;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bv, do, af, 
//            ai, e, dg, be, 
//            an, ak

class VersionLabel extends en
{

    private an decorator;
    private bv detail;
    private i format;
    private s label;
    private String name;
    private be path;
    private boolean required;
    private Class type;

    public VersionLabel(af af1, s s1, i j)
    {
        detail = new bv(af1, this, j);
        decorator = new do(af1);
        required = s1.c();
        type = af1.C_();
        name = s1.a();
        format = j;
        label = s1;
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
        String s1 = getEmpty(ai1);
        af af1 = getContact();
        if (!ai1.a(af1))
        {
            throw new e("Cannot use %s to represent %s", new Object[] {
                label, af1
            });
        } else
        {
            return new dg(ai1, af1, s1);
        }
    }

    public an getDecorator()
    {
        return decorator;
    }

    public volatile Object getEmpty(ai ai1)
    {
        return getEmpty(ai1);
    }

    public String getEmpty(ai ai1)
    {
        return null;
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
