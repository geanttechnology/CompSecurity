// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.examples;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;

// Referenced classes of package org.jsoup.examples:
//            HtmlToPlainText

private class <init>
    implements NodeVisitor
{

    private static final int maxWidth = 80;
    private StringBuilder accum;
    final HtmlToPlainText this$0;
    private int width;

    private void append(String s)
    {
        if (s.startsWith("\n"))
        {
            width = 0;
        }
        if (!s.equals(" ") || accum.length() != 0 && !StringUtil.in(accum.substring(accum.length() - 1), new String[] {
    " ", "\n"
}))
        {
            if (s.length() + width > 80)
            {
                String as[] = s.split("\\s+");
                int i = 0;
                while (i < as.length) 
                {
                    String s1 = as[i];
                    boolean flag;
                    if (i == as.length - 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    s = s1;
                    if (!flag)
                    {
                        s = (new StringBuilder()).append(s1).append(" ").toString();
                    }
                    if (s.length() + width > 80)
                    {
                        accum.append("\n").append(s);
                        width = s.length();
                    } else
                    {
                        accum.append(s);
                        width = width + s.length();
                    }
                    i++;
                }
            } else
            {
                accum.append(s);
                width = width + s.length();
                return;
            }
        }
    }

    public void head(Node node, int i)
    {
        String s = node.nodeName();
        if (node instanceof TextNode)
        {
            append(((TextNode)node).text());
        } else
        if (s.equals("li"))
        {
            append("\n * ");
            return;
        }
    }

    public void tail(Node node, int i)
    {
        String s = node.nodeName();
        if (s.equals("br"))
        {
            append("\n");
        } else
        {
            if (StringUtil.in(s, new String[] {
    "p", "h1", "h2", "h3", "h4", "h5"
}))
            {
                append("\n\n");
                return;
            }
            if (s.equals("a"))
            {
                append(String.format(" <%s>", new Object[] {
                    node.absUrl("href")
                }));
                return;
            }
        }
    }

    public String toString()
    {
        return accum.toString();
    }

    private ()
    {
        this$0 = HtmlToPlainText.this;
        super();
        width = 0;
        accum = new StringBuilder();
    }

    accum(accum accum1)
    {
        this();
    }
}
