// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.safety;

import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;

// Referenced classes of package org.jsoup.safety:
//            Whitelist

public class Cleaner
{
    private static class ElementMeta
    {

        Element el;
        int numAttribsDiscarded;

        ElementMeta(Element element, int i)
        {
            el = element;
            numAttribsDiscarded = i;
        }
    }


    private Whitelist whitelist;

    public Cleaner(Whitelist whitelist1)
    {
        Validate.notNull(whitelist1);
        whitelist = whitelist1;
    }

    private int copySafeNodes(Element element, Element element1)
    {
        element = element.childNodes();
        int i = 0;
        element = element.iterator();
        do
        {
            if (!element.hasNext())
            {
                break;
            }
            Object obj = (Node)element.next();
            if (obj instanceof Element)
            {
                obj = (Element)obj;
                if (whitelist.isSafeTag(((Element) (obj)).tagName()))
                {
                    ElementMeta elementmeta = createSafeElement(((Element) (obj)));
                    Element element2 = elementmeta.el;
                    element1.appendChild(element2);
                    i = i + elementmeta.numAttribsDiscarded + copySafeNodes(((Element) (obj)), element2);
                } else
                {
                    i = i + 1 + copySafeNodes(((Element) (obj)), element1);
                }
            } else
            if (obj instanceof TextNode)
            {
                element1.appendChild(new TextNode(((TextNode)obj).getWholeText(), ((Node) (obj)).baseUri()));
            }
        } while (true);
        return i;
    }

    private ElementMeta createSafeElement(Element element)
    {
        String s = element.tagName();
        Attributes attributes = new Attributes();
        Element element1 = new Element(Tag.valueOf(s), element.baseUri(), attributes);
        int i = 0;
        for (Iterator iterator = element.attributes().iterator(); iterator.hasNext();)
        {
            Attribute attribute = (Attribute)iterator.next();
            if (whitelist.isSafeAttribute(s, element, attribute))
            {
                attributes.put(attribute);
            } else
            {
                i++;
            }
        }

        attributes.addAll(whitelist.getEnforcedAttributes(s));
        return new ElementMeta(element1, i);
    }

    public Document clean(Document document)
    {
        Validate.notNull(document);
        Document document1 = Document.createShell(document.baseUri());
        copySafeNodes(document.body(), document1.body());
        return document1;
    }

    public boolean isValid(Document document)
    {
        Validate.notNull(document);
        Document document1 = Document.createShell(document.baseUri());
        return copySafeNodes(document.body(), document1.body()) == 0;
    }
}
