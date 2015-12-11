// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import org.w3c.dom.Element;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.XMLElement;

public class Visitor
{

    public int bandwidth;
    public String bandwidthSource;
    public String caller;
    public String customId;
    public TreeMap httpHeaders;
    public String ipV4Address;
    protected Logger logger;

    public Visitor(String s)
    {
        logger = Logger.getLogger(this);
        httpHeaders = new TreeMap();
        caller = (new StringBuilder()).append("android-").append(s).toString();
    }

    private XMLElement buildBandwidthInfoElement()
    {
        XMLElement xmlelement = new XMLElement("bandwidthInfo");
        xmlelement.setAttribute("bandwidth", bandwidth);
        xmlelement.setAttribute("source", bandwidthSource);
        return xmlelement;
    }

    private XMLElement buildHttpHeadersElement()
    {
        XMLElement xmlelement = new XMLElement("httpHeaders");
        XMLElement xmlelement1;
        for (Iterator iterator = httpHeaders.keySet().iterator(); iterator.hasNext(); xmlelement.appendChild(xmlelement1))
        {
            xmlelement1 = new XMLElement("httpHeader");
            String s = (String)iterator.next();
            xmlelement1.setAttribute("name", s);
            xmlelement1.setAttribute("value", (String)httpHeaders.get(s));
        }

        return xmlelement;
    }

    public XMLElement buildXMLElement()
    {
        XMLElement xmlelement = new XMLElement("visitor");
        xmlelement.setAttribute("customId", customId);
        xmlelement.setAttribute("caller", caller);
        xmlelement.setAttribute("ipV4Address", ipV4Address);
        if (httpHeaders.size() > 0)
        {
            xmlelement.appendChild(buildHttpHeadersElement());
        }
        if (bandwidth > 0)
        {
            xmlelement.appendChild(buildBandwidthInfoElement());
        }
        return xmlelement;
    }

    public void parse(Element element)
    {
    }
}
