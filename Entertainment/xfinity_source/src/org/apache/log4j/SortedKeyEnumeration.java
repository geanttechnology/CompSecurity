// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class SortedKeyEnumeration
    implements Enumeration
{

    private Enumeration e;

    public SortedKeyEnumeration(Hashtable hashtable)
    {
        Enumeration enumeration = hashtable.keys();
        hashtable = new Vector(hashtable.size());
        int i = 0;
label0:
        do
        {
            if (enumeration.hasMoreElements())
            {
                String s = (String)enumeration.nextElement();
                int j = 0;
                do
                {
                    if (j >= i || s.compareTo((String)hashtable.get(j)) <= 0)
                    {
                        hashtable.add(j, s);
                        i++;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            e = hashtable.elements();
            return;
        } while (true);
    }

    public boolean hasMoreElements()
    {
        return e.hasMoreElements();
    }

    public Object nextElement()
    {
        return e.nextElement();
    }
}
