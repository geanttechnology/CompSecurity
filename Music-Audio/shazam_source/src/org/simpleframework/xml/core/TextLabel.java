// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.q;

// Referenced classes of package org.simpleframework.xml.core:
//            en, bv, af, ai, 
//            ep, dg, be, ak, 
//            an

class TextLabel extends en
{

    private af contact;
    private boolean data;
    private bv detail;
    private String empty;
    private q label;
    private be path;
    private boolean required;
    private Class type;

    public TextLabel(af af1, q q1, i i)
    {
        detail = new bv(af1, this, i);
        required = q1.c();
        type = af1.C_();
        empty = q1.a();
        data = q1.b();
        contact = af1;
        label = q1;
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public af getContact()
    {
        return contact;
    }

    public ak getConverter(ai ai1)
    {
        String s = getEmpty(ai1);
        af af1 = getContact();
        if (!ai1.b(af1))
        {
            throw new ep("Cannot use %s to represent %s", new Object[] {
                af1, label
            });
        } else
        {
            return new dg(ai1, af1, s);
        }
    }

    public an getDecorator()
    {
        return null;
    }

    public volatile Object getEmpty(ai ai1)
    {
        return getEmpty(ai1);
    }

    public String getEmpty(ai ai1)
    {
        if (bv.a(empty))
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
        return "";
    }

    public String getOverride()
    {
        return contact.toString();
    }

    public String getPath()
    {
        return getExpression().e();
    }

    public Class getType()
    {
        return type;
    }

    public boolean isData()
    {
        return data;
    }

    public boolean isInline()
    {
        return true;
    }

    public boolean isRequired()
    {
        return required;
    }

    public boolean isText()
    {
        return true;
    }

    public String toString()
    {
        return detail.toString();
    }
}
