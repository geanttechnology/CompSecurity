// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp:
//            AllowedValue

public class AllowedValueList extends Vector
{

    public static final String ELEM_NAME = "allowedValueList";

    public AllowedValueList()
    {
    }

    public AllowedValueList(String as[])
    {
        int i = 0;
        do
        {
            if (i >= as.length)
            {
                return;
            }
            add(new AllowedValue(as[i]));
            i++;
        } while (true);
    }

    public AllowedValue getAllowedValue(int i)
    {
        return (AllowedValue)get(i);
    }

    public boolean isAllowed(String s)
    {
        Iterator iterator = iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }
        } while (!((AllowedValue)iterator.next()).getValue().equals(s));
        return true;
    }
}
