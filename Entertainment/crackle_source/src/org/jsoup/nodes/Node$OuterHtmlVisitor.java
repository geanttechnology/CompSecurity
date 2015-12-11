// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import org.jsoup.select.NodeVisitor;

// Referenced classes of package org.jsoup.nodes:
//            Node

private static class out
    implements NodeVisitor
{

    private StringBuilder accum;
    private s out;

    public void head(Node node, int i)
    {
        node.outerHtmlHead(accum, i, out);
    }

    public void tail(Node node, int i)
    {
        if (!node.nodeName().equals("#text"))
        {
            node.outerHtmlTail(accum, i, out);
        }
    }

    s(StringBuilder stringbuilder, s s)
    {
        accum = stringbuilder;
        out = s;
    }
}
