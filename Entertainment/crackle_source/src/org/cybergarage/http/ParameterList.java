// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.util.Vector;

// Referenced classes of package org.cybergarage.http:
//            Parameter

public class ParameterList extends Vector
{

    public ParameterList()
    {
    }

    public Parameter at(int i)
    {
        return (Parameter)get(i);
    }

    public Parameter getParameter(int i)
    {
        return (Parameter)get(i);
    }

    public Parameter getParameter(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        Parameter parameter = null;
_L4:
        return parameter;
_L2:
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return null;
            }
            Parameter parameter1 = at(i);
            parameter = parameter1;
            if (s.compareTo(parameter1.getName()) == 0)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getValue(String s)
    {
        s = getParameter(s);
        if (s == null)
        {
            return "";
        } else
        {
            return s.getValue();
        }
    }
}
