// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.f;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bv, do, af, 
//            ai, x, dl, u, 
//            dj, au, m, n, 
//            bi, be, an, ak

class ElementListLabel extends en
{

    private be cache;
    private boolean data;
    private an decorator;
    private bv detail;
    private String entry;
    private i format;
    private boolean inline;
    private Class item;
    private f label;
    private String name;
    private String override;
    private String path;
    private boolean required;
    private Class type;

    public ElementListLabel(af af1, f f1, i j)
    {
        detail = new bv(af1, this, j);
        decorator = new do(af1);
        required = f1.e();
        type = af1.C_();
        override = f1.a();
        inline = f1.f();
        entry = f1.b();
        data = f1.d();
        item = f1.c();
        format = j;
        label = f1;
    }

    private ak getConverter(ai ai1, String s)
    {
        org.simpleframework.xml.b.f f1 = getDependent();
        af af1 = getContact();
        if (!ai1.b(f1))
        {
            return new x(ai1, af1, f1, s);
        } else
        {
            return new dl(ai1, af1, f1, s);
        }
    }

    private ak getInlineConverter(ai ai1, String s)
    {
        org.simpleframework.xml.b.f f1 = getDependent();
        af af1 = getContact();
        if (!ai1.b(f1))
        {
            return new u(ai1, af1, f1, s);
        } else
        {
            return new dj(ai1, af1, f1, s);
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
        String s = getEntry();
        if (!label.f())
        {
            return getConverter(ai1, s);
        } else
        {
            return getInlineConverter(ai1, s);
        }
    }

    public an getDecorator()
    {
        return decorator;
    }

    public org.simpleframework.xml.b.f getDependent()
    {
        af af1 = getContact();
        if (item == Void.TYPE)
        {
            item = af1.b();
        }
        if (item == null)
        {
            throw new au("Unable to determine generic type for %s", new Object[] {
                af1
            });
        } else
        {
            return new m(item);
        }
    }

    public Object getEmpty(ai ai1)
    {
        ai1 = new n(ai1, new m(type));
        if (!label.g())
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
