// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import io.presage.model.Parameter;
import java.util.Iterator;
import java.util.List;

public abstract class NewAdViewerDescriptor
{

    private String a;
    private List b;

    public NewAdViewerDescriptor()
    {
    }

    public NewAdViewerDescriptor(String s, List list)
    {
        a = s;
        b = list;
    }

    public Parameter getParameter(String s)
    {
label0:
        {
            if (b == null)
            {
                break label0;
            }
            Iterator iterator = b.iterator();
            Parameter parameter;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                parameter = (Parameter)iterator.next();
            } while (parameter == null || !s.equals(parameter.getName()));
            return parameter;
        }
        return null;
    }

    public Object getParameterValue(String s, Class class1)
    {
        s = getParameter(s);
        if (s == null)
        {
            return null;
        } else
        {
            return s.get(class1);
        }
    }

    public List getParameters()
    {
        return b;
    }

    public String getType()
    {
        return a;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append(":").append(a).toString();
    }
}
