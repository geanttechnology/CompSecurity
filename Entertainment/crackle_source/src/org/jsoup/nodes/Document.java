// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

// Referenced classes of package org.jsoup.nodes:
//            Element, Node, TextNode

public class Document extends Element
{
    public static class OutputSettings
        implements Cloneable
    {

        private Charset charset;
        private CharsetEncoder charsetEncoder;
        private Entities.EscapeMode escapeMode;
        private int indentAmount;
        private boolean prettyPrint;

        public Charset charset()
        {
            return charset;
        }

        public OutputSettings charset(String s)
        {
            charset(Charset.forName(s));
            return this;
        }

        public OutputSettings charset(Charset charset1)
        {
            charset = charset1;
            charsetEncoder = charset1.newEncoder();
            return this;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public OutputSettings clone()
        {
            OutputSettings outputsettings;
            try
            {
                outputsettings = (OutputSettings)super.clone();
            }
            catch (CloneNotSupportedException clonenotsupportedexception)
            {
                throw new RuntimeException(clonenotsupportedexception);
            }
            outputsettings.charset(charset.name());
            outputsettings.escapeMode = Entities.EscapeMode.valueOf(escapeMode.name());
            return outputsettings;
        }

        CharsetEncoder encoder()
        {
            return charsetEncoder;
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapemode)
        {
            escapeMode = escapemode;
            return this;
        }

        public Entities.EscapeMode escapeMode()
        {
            return escapeMode;
        }

        public int indentAmount()
        {
            return indentAmount;
        }

        public OutputSettings indentAmount(int i)
        {
            boolean flag;
            if (i >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Validate.isTrue(flag);
            indentAmount = i;
            return this;
        }

        public OutputSettings prettyPrint(boolean flag)
        {
            prettyPrint = flag;
            return this;
        }

        public boolean prettyPrint()
        {
            return prettyPrint;
        }

        public OutputSettings()
        {
            escapeMode = Entities.EscapeMode.base;
            charset = Charset.forName("UTF-8");
            charsetEncoder = charset.newEncoder();
            prettyPrint = true;
            indentAmount = 1;
        }
    }

    public static final class QuirksMode extends Enum
    {

        private static final QuirksMode $VALUES[];
        public static final QuirksMode limitedQuirks;
        public static final QuirksMode noQuirks;
        public static final QuirksMode quirks;

        public static QuirksMode valueOf(String s)
        {
            return (QuirksMode)Enum.valueOf(org/jsoup/nodes/Document$QuirksMode, s);
        }

        public static QuirksMode[] values()
        {
            return (QuirksMode[])$VALUES.clone();
        }

        static 
        {
            noQuirks = new QuirksMode("noQuirks", 0);
            quirks = new QuirksMode("quirks", 1);
            limitedQuirks = new QuirksMode("limitedQuirks", 2);
            $VALUES = (new QuirksMode[] {
                noQuirks, quirks, limitedQuirks
            });
        }

        private QuirksMode(String s, int i)
        {
            super(s, i);
        }
    }


    private OutputSettings outputSettings;
    private QuirksMode quirksMode;

    public Document(String s)
    {
        super(Tag.valueOf("#root"), s);
        outputSettings = new OutputSettings();
        quirksMode = QuirksMode.noQuirks;
    }

    public static Document createShell(String s)
    {
        Validate.notNull(s);
        s = new Document(s);
        Element element = s.appendElement("html");
        element.appendElement("head");
        element.appendElement("body");
        return s;
    }

    private Element findFirstElementByTagName(String s, Node node)
    {
        if (node.nodeName().equals(s))
        {
            return (Element)node;
        }
        for (node = node.childNodes.iterator(); node.hasNext();)
        {
            Element element = findFirstElementByTagName(s, (Node)node.next());
            if (element != null)
            {
                return element;
            }
        }

        return null;
    }

    private void normaliseStructure(String s, Element element)
    {
        Elements elements = getElementsByTag(s);
        s = elements.first();
        if (elements.size() > 1)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 1; i < elements.size(); i++)
            {
                Element element1 = elements.get(i);
                for (Iterator iterator1 = ((Node) (element1)).childNodes.iterator(); iterator1.hasNext(); arraylist.add((Node)iterator1.next())) { }
                element1.remove();
            }

            for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); s.appendChild((Node)iterator.next())) { }
        }
        if (!s.parent().equals(element))
        {
            element.appendChild(s);
        }
    }

    private void normaliseTextNodes(Element element)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = element.childNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (Node)iterator.next();
            if (obj instanceof TextNode)
            {
                obj = (TextNode)obj;
                if (!((TextNode) (obj)).isBlank())
                {
                    arraylist.add(obj);
                }
            }
        } while (true);
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            Node node = (Node)arraylist.get(i);
            element.removeChild(node);
            body().prependChild(new TextNode(" ", ""));
            body().prependChild(node);
        }

    }

    public Element body()
    {
        return findFirstElementByTagName("body", this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Document clone()
    {
        Document document = (Document)super.clone();
        document.outputSettings = outputSettings.clone();
        return document;
    }

    public volatile Element clone()
    {
        return clone();
    }

    public volatile Node clone()
    {
        return clone();
    }

    public Element createElement(String s)
    {
        return new Element(Tag.valueOf(s), baseUri());
    }

    public Element head()
    {
        return findFirstElementByTagName("head", this);
    }

    public String nodeName()
    {
        return "#document";
    }

    public Document normalise()
    {
        Element element1 = findFirstElementByTagName("html", this);
        Element element = element1;
        if (element1 == null)
        {
            element = appendElement("html");
        }
        if (head() == null)
        {
            element.prependElement("head");
        }
        if (body() == null)
        {
            element.appendElement("body");
        }
        normaliseTextNodes(head());
        normaliseTextNodes(element);
        normaliseTextNodes(this);
        normaliseStructure("head", element);
        normaliseStructure("body", element);
        return this;
    }

    public String outerHtml()
    {
        return super.html();
    }

    public OutputSettings outputSettings()
    {
        return outputSettings;
    }

    public QuirksMode quirksMode()
    {
        return quirksMode;
    }

    public Document quirksMode(QuirksMode quirksmode)
    {
        quirksMode = quirksmode;
        return this;
    }

    public Element text(String s)
    {
        body().text(s);
        return this;
    }

    public String title()
    {
        Element element = getElementsByTag("title").first();
        if (element != null)
        {
            return element.text().trim();
        } else
        {
            return "";
        }
    }

    public void title(String s)
    {
        Validate.notNull(s);
        Element element = getElementsByTag("title").first();
        if (element == null)
        {
            head().appendElement("title").text(s);
            return;
        } else
        {
            element.text(s);
            return;
        }
    }
}
