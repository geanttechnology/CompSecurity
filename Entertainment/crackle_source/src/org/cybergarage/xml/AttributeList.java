// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml;

import java.util.Vector;

// Referenced classes of package org.cybergarage.xml:
//            Attribute

public class AttributeList extends Vector
{

    public AttributeList()
    {
    }

    public Attribute getAttribute(int i)
    {
        return (Attribute)get(i);
    }

    public Attribute getAttribute(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        Attribute attribute = null;
_L4:
        return attribute;
_L2:
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return null;
            }
            Attribute attribute1 = getAttribute(i);
            attribute = attribute1;
            if (s.compareTo(attribute1.getName()) == 0)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
