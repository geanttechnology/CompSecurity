// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.List;
import org.jsoup.nodes.Node;

// Referenced classes of package org.jsoup.select:
//            NodeVisitor

public class NodeTraversor
{

    private NodeVisitor visitor;

    public NodeTraversor(NodeVisitor nodevisitor)
    {
        visitor = nodevisitor;
    }

    public void traverse(Node node)
    {
        Node node1 = node;
        int i = 0;
        do
        {
            Node node2;
            int j;
label0:
            {
                if (node1 != null)
                {
                    visitor.head(node1, i);
                    j = i;
                    node2 = node1;
                    if (node1.childNodes().size() > 0)
                    {
                        node1 = node1.childNode(0);
                        i++;
                        continue;
                    }
                    for (; node2.nextSibling() == null && j > 0; j--)
                    {
                        visitor.tail(node2, j);
                        node2 = node2.parent();
                    }

                    visitor.tail(node2, j);
                    if (node2 != node)
                    {
                        break label0;
                    }
                }
                return;
            }
            node1 = node2.nextSibling();
            i = j;
        } while (true);
    }
}
