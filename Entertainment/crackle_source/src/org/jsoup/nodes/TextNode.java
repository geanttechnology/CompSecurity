// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;

// Referenced classes of package org.jsoup.nodes:
//            Node, Entities, Attributes, Element

public class TextNode extends Node
{

    private static final String TEXT_KEY = "text";
    String text;

    public TextNode(String s, String s1)
    {
        baseUri = s1;
        text = s;
    }

    public static TextNode createFromEncoded(String s, String s1)
    {
        return new TextNode(Entities.unescape(s), s1);
    }

    private void ensureAttributes()
    {
        if (attributes == null)
        {
            attributes = new Attributes();
            attributes.put("text", text);
        }
    }

    static boolean lastCharIsWhitespace(StringBuilder stringbuilder)
    {
        return stringbuilder.length() != 0 && stringbuilder.charAt(stringbuilder.length() - 1) == ' ';
    }

    static String normaliseWhitespace(String s)
    {
        return StringUtil.normaliseWhitespace(s);
    }

    static String stripLeadingWhitespace(String s)
    {
        return s.replaceFirst("^\\s+", "");
    }

    public String absUrl(String s)
    {
        ensureAttributes();
        return super.absUrl(s);
    }

    public String attr(String s)
    {
        ensureAttributes();
        return super.attr(s);
    }

    public Node attr(String s, String s1)
    {
        ensureAttributes();
        return super.attr(s, s1);
    }

    public Attributes attributes()
    {
        ensureAttributes();
        return super.attributes();
    }

    public String getWholeText()
    {
        if (attributes == null)
        {
            return text;
        } else
        {
            return attributes.get("text");
        }
    }

    public boolean hasAttr(String s)
    {
        ensureAttributes();
        return super.hasAttr(s);
    }

    public boolean isBlank()
    {
        return StringUtil.isBlank(getWholeText());
    }

    public String nodeName()
    {
        return "#text";
    }

    void outerHtmlHead(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        String s1 = Entities.escape(getWholeText(), outputsettings);
        String s = s1;
        if (outputsettings.prettyPrint())
        {
            s = s1;
            if (parent() instanceof Element)
            {
                s = s1;
                if (!((Element)parent()).preserveWhitespace())
                {
                    s = normaliseWhitespace(s1);
                }
            }
        }
        if (outputsettings.prettyPrint() && siblingIndex() == 0 && (parentNode instanceof Element) && ((Element)parentNode).tag().formatAsBlock() && !isBlank())
        {
            indent(stringbuilder, i, outputsettings);
        }
        stringbuilder.append(s);
    }

    void outerHtmlTail(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
    }

    public Node removeAttr(String s)
    {
        ensureAttributes();
        return super.removeAttr(s);
    }

    public TextNode splitText(int i)
    {
        Object obj;
        String s;
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Split offset must be not be negative");
        if (i < text.length())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Split offset must not be greater than current text length");
        obj = getWholeText().substring(0, i);
        s = getWholeText().substring(i);
        text(((String) (obj)));
        obj = new TextNode(s, baseUri());
        if (parent() != null)
        {
            parent().addChildren(siblingIndex() + 1, new Node[] {
                obj
            });
        }
        return ((TextNode) (obj));
    }

    public String text()
    {
        return normaliseWhitespace(getWholeText());
    }

    public TextNode text(String s)
    {
        text = s;
        if (attributes != null)
        {
            attributes.put("text", s);
        }
        return this;
    }

    public String toString()
    {
        return outerHtml();
    }
}
