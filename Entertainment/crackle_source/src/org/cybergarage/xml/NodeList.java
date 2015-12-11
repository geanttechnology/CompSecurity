// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml;

import java.util.Vector;

// Referenced classes of package org.cybergarage.xml:
//            Node

public class NodeList extends Vector
{

    public NodeList()
    {
    }

    public Node getEndsWith(String s)
    {
        int i;
        int j;
        if (s == null)
        {
            return null;
        }
        j = size();
        i = 0;
_L2:
        Node node;
        String s1;
        if (i >= j)
        {
            return null;
        }
        node = getNode(i);
        s1 = node.getName();
          goto _L1
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s1 == null || !s1.endsWith(s)) goto _L4; else goto _L3
_L3:
        return node;
    }

    public Node getNode(int i)
    {
        return (Node)get(i);
    }

    public Node getNode(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        Node node = null;
_L4:
        return node;
_L2:
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return null;
            }
            Node node1 = getNode(i);
            node = node1;
            if (s.compareTo(node1.getName()) == 0)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
