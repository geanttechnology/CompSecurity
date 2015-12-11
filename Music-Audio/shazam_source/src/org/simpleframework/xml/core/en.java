// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.b.f;

// Referenced classes of package org.simpleframework.xml.core:
//            bx, bw

abstract class en
    implements bx
{

    private final bw builder = new bw(this);

    protected en()
    {
    }

    public f getDependent()
    {
        return null;
    }

    public String getEntry()
    {
        return null;
    }

    public Object getKey()
    {
        bw bw1 = builder;
        if (bw1.a.isAttribute())
        {
            return bw1.a(bw.b.b);
        } else
        {
            return bw1.a(bw.b.c);
        }
    }

    public bx getLabel(Class class1)
    {
        return this;
    }

    public String[] getNames()
    {
        return (new String[] {
            getPath(), getName()
        });
    }

    public String[] getPaths()
    {
        return (new String[] {
            getPath()
        });
    }

    public f getType(Class class1)
    {
        return getContact();
    }

    public boolean isAttribute()
    {
        return false;
    }

    public boolean isCollection()
    {
        return false;
    }

    public boolean isInline()
    {
        return false;
    }

    public boolean isText()
    {
        return false;
    }

    public boolean isTextList()
    {
        return false;
    }

    public boolean isUnion()
    {
        return false;
    }
}
