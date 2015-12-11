// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import org.xmlpull.v1.XmlSerializer;

public class XMLElement
{

    private TreeMap attributes;
    private ArrayList children;
    private boolean isCDATASection;
    private String name;
    private String value;

    public XMLElement(String s)
    {
        isCDATASection = false;
        name = s;
        attributes = new TreeMap();
        children = new ArrayList();
    }

    public void appendChild(XMLElement xmlelement)
    {
        if (xmlelement != null)
        {
            children.add(xmlelement);
        }
    }

    public void setAttribute(String s, double d)
    {
        setAttribute(s, String.valueOf(d));
    }

    public void setAttribute(String s, double d, boolean flag)
    {
        if (flag && d <= 0.0D)
        {
            return;
        } else
        {
            setAttribute(s, d);
            return;
        }
    }

    public void setAttribute(String s, int i)
    {
        setAttribute(s, String.valueOf(i));
    }

    public void setAttribute(String s, int i, boolean flag)
    {
        if (flag && i <= 0)
        {
            return;
        } else
        {
            setAttribute(s, i);
            return;
        }
    }

    public void setAttribute(String s, String s1)
    {
        while (s == null || s1 == null || s.trim().length() == 0) 
        {
            return;
        }
        attributes.put(s, s1);
    }

    public void setAttribute(String s, boolean flag)
    {
        setAttribute(s, String.valueOf(flag));
    }

    public void setText(String s)
    {
        value = s;
    }

    public void toXML(XmlSerializer xmlserializer)
        throws IllegalArgumentException, IllegalStateException, IOException
    {
        xmlserializer.startTag("", name);
        String s;
        for (Iterator iterator = attributes.keySet().iterator(); iterator.hasNext(); xmlserializer.attribute("", s, (String)attributes.get(s)))
        {
            s = (String)iterator.next();
        }

        Iterator iterator1;
        if (value != null)
        {
            if (isCDATASection)
            {
                xmlserializer.cdsect(value);
            } else
            {
                xmlserializer.text(value);
            }
        }
        for (iterator1 = children.iterator(); iterator1.hasNext(); ((XMLElement)iterator1.next()).toXML(xmlserializer)) { }
        xmlserializer.endTag("", name);
    }
}
