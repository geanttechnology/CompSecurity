// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.b.f;

// Referenced classes of package org.simpleframework.xml.core:
//            bx, be, an, af, 
//            ai, ak

final class g
    implements bx
{

    private final Annotation a;
    private final be b;
    private final an c;
    private final af d;
    private final String e[];
    private final String f[];
    private final Class g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final bx l;
    private final Object m;
    private final f n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final boolean v;

    public g(bx bx1)
    {
        a = bx1.getAnnotation();
        b = bx1.getExpression();
        c = bx1.getDecorator();
        r = bx1.isAttribute();
        t = bx1.isCollection();
        d = bx1.getContact();
        n = bx1.getDependent();
        s = bx1.isRequired();
        j = bx1.getOverride();
        v = bx1.isTextList();
        u = bx1.isInline();
        q = bx1.isUnion();
        e = bx1.getNames();
        f = bx1.getPaths();
        i = bx1.getPath();
        g = bx1.getType();
        k = bx1.getName();
        h = bx1.getEntry();
        o = bx1.isData();
        p = bx1.isText();
        m = bx1.getKey();
        l = bx1;
    }

    public final Annotation getAnnotation()
    {
        return a;
    }

    public final af getContact()
    {
        return d;
    }

    public final ak getConverter(ai ai)
    {
        return l.getConverter(ai);
    }

    public final an getDecorator()
    {
        return c;
    }

    public final f getDependent()
    {
        return n;
    }

    public final Object getEmpty(ai ai)
    {
        return l.getEmpty(ai);
    }

    public final String getEntry()
    {
        return h;
    }

    public final be getExpression()
    {
        return b;
    }

    public final Object getKey()
    {
        return m;
    }

    public final bx getLabel(Class class1)
    {
        return l.getLabel(class1);
    }

    public final String getName()
    {
        return k;
    }

    public final String[] getNames()
    {
        return e;
    }

    public final String getOverride()
    {
        return j;
    }

    public final String getPath()
    {
        return i;
    }

    public final String[] getPaths()
    {
        return f;
    }

    public final Class getType()
    {
        return g;
    }

    public final f getType(Class class1)
    {
        return l.getType(class1);
    }

    public final boolean isAttribute()
    {
        return r;
    }

    public final boolean isCollection()
    {
        return t;
    }

    public final boolean isData()
    {
        return o;
    }

    public final boolean isInline()
    {
        return u;
    }

    public final boolean isRequired()
    {
        return s;
    }

    public final boolean isText()
    {
        return p;
    }

    public final boolean isTextList()
    {
        return v;
    }

    public final boolean isUnion()
    {
        return q;
    }

    public final String toString()
    {
        return l.toString();
    }
}
