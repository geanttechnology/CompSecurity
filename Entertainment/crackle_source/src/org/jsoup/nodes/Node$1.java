// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import org.jsoup.select.NodeVisitor;

// Referenced classes of package org.jsoup.nodes:
//            Node

class 
    implements NodeVisitor
{

    final Node this$0;
    final String val$baseUri;

    public void head(Node node, int i)
    {
        node.baseUri = val$baseUri;
    }

    public void tail(Node node, int i)
    {
    }

    sitor()
    {
        this$0 = final_node;
        val$baseUri = String.this;
        super();
    }
}
