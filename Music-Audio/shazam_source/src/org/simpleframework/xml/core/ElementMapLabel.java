// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.b.f;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.h;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bv, do, bd, 
//            af, m, z, v, 
//            au, cc, bi, be, 
//            an, ai, ak

class ElementMapLabel extends en
{

    private be cache;
    private boolean data;
    private an decorator;
    private bv detail;
    private bd entry;
    private i format;
    private boolean inline;
    private Class items[];
    private h label;
    private String name;
    private String override;
    private String parent;
    private String path;
    private boolean required;
    private Class type;

    public ElementMapLabel(af af1, h h1, i j)
    {
        detail = new bv(af1, this, j);
        decorator = new do(af1);
        entry = new bd(af1, h1);
        required = h1.h();
        type = af1.C_();
        inline = h1.j();
        override = h1.a();
        data = h1.i();
        format = j;
        label = h1;
    }

    private f getMap()
    {
        return new m(type);
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
        f f = getMap();
        if (!label.j())
        {
            return new z(ai, entry, f);
        } else
        {
            return new v(ai, entry, f);
        }
    }

    public an getDecorator()
    {
        return decorator;
    }

    public f getDependent()
    {
        af af1 = getContact();
        if (items == null)
        {
            items = af1.c();
        }
        if (items == null)
        {
            throw new au("Unable to determine type for %s", new Object[] {
                af1
            });
        }
        if (items.length == 0)
        {
            return new m(java/lang/Object);
        } else
        {
            return new m(items[0]);
        }
    }

    public Object getEmpty(ai ai)
    {
        ai = new cc(ai, new m(type));
        if (!label.k())
        {
            return ai.a();
        } else
        {
            return null;
        }
    }

    public String getEntry()
    {
        as as1 = format.c;
        if (bv.a(parent))
        {
            parent = detail.a();
        }
        return as1.b(parent);
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
            as as1 = format.c;
            String s = entry.c();
            if (!label.j())
            {
                s = detail.b();
            }
            name = as1.b(s);
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
