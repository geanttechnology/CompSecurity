// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ErrorElement

private static final class Value extends com.ebay.nautilus.kernel.util.alue
{
    static final class Value extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final int index;
        private final ArrayList parameters;

        public void text(String s)
            throws SAXException
        {
            if (index != -1)
            {
                parameters.set(index, s);
                return;
            } else
            {
                parameters.add(s);
                return;
            }
        }

        public Value(ArrayList arraylist, int i)
        {
            parameters = arraylist;
            index = i;
        }
    }


    private final String namespace;
    private final Value value;

    public com.ebay.nautilus.kernel.util.alue.parameters get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (namespace.equals(s) && "Value".equals(s1))
        {
            return value;
        } else
        {
            return super.alue(s, s1, s2, attributes);
        }
    }

    public Value.index(String s, ArrayList arraylist, Attributes attributes)
    {
        namespace = s;
        int i = -1;
        byte byte0 = i;
        if (attributes != null)
        {
            int l = attributes.getLength();
            int k = 0;
            do
            {
                byte0 = i;
                if (k >= l)
                {
                    break;
                }
                s = attributes.getLocalName(k);
                String s1 = attributes.getValue(k);
                if ("ParamID".equals(s))
                {
                    i = Integer.parseInt(s1);
                }
                k++;
            } while (true);
        }
        value = new Value(arraylist, byte0);
        if (byte0 != -1)
        {
            int j = byte0 + 1;
            arraylist.ensureCapacity(j);
            for (; arraylist.size() < j; arraylist.add("")) { }
        }
    }
}
