// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;

import org.cybergarage.http.HTTPRequest;
import org.cybergarage.soap.SOAPRequest;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp.event:
//            Property, PropertyList, Subscription, Subscriber

public class NotifyRequest extends SOAPRequest
{

    private static final String PROPERTY = "property";
    private static final String PROPERTYSET = "propertyset";
    private static final String XMLNS = "e";

    public NotifyRequest()
    {
    }

    public NotifyRequest(HTTPRequest httprequest)
    {
        set(httprequest);
    }

    private Node createPropertySetNode(String s, String s1)
    {
        Node node = new Node("propertyset");
        node.setNameSpace("e", "urn:schemas-upnp-org:event-1-0");
        Node node1 = new Node("property");
        node.addNode(node1);
        s = new Node(s);
        s.setValue(s1);
        node1.addNode(s);
        return node;
    }

    private Property getProperty(Node node)
    {
        Property property = new Property();
        if (node == null)
        {
            return property;
        }
        String s1 = node.getName();
        int i = s1.lastIndexOf(':');
        String s = s1;
        if (i != -1)
        {
            s = s1.substring(i + 1);
        }
        property.setName(s);
        property.setValue(node.getValue());
        return property;
    }

    private Node getVariableNode()
    {
        Node node;
        node = getEnvelopeNode();
        break MISSING_BLOCK_LABEL_5;
        if (node != null && node.hasNodes())
        {
            node = node.getNode(0);
            if (node.hasNodes())
            {
                return node.getNode(0);
            }
        }
        return null;
    }

    public PropertyList getPropertyList()
    {
        PropertyList propertylist = new PropertyList();
        Node node = getEnvelopeNode();
        int i = 0;
        do
        {
            if (i >= node.getNNodes())
            {
                return propertylist;
            }
            Node node1 = node.getNode(i);
            if (node1 != null)
            {
                propertylist.add(getProperty(node1.getNode(0)));
            }
            i++;
        } while (true);
    }

    public long getSEQ()
    {
        return getLongHeaderValue("SEQ");
    }

    public String getSID()
    {
        return Subscription.getSID(getHeaderValue("SID"));
    }

    public void setNT(String s)
    {
        setHeader("NT", s);
    }

    public void setNTS(String s)
    {
        setHeader("NTS", s);
    }

    public boolean setRequest(Subscriber subscriber, String s, String s1)
    {
        subscriber.getDeliveryURL();
        String s2 = subscriber.getSID();
        long l = subscriber.getNotifyCount();
        String s3 = subscriber.getDeliveryHost();
        String s4 = subscriber.getDeliveryPath();
        int i = subscriber.getDeliveryPort();
        setMethod("NOTIFY");
        setURI(s4);
        setHost(s3, i);
        setNT("upnp:event");
        setNTS("upnp:propchange");
        setSID(s2);
        setSEQ(l);
        setContentType("text/xml; charset=\"utf-8\"");
        setContent(createPropertySetNode(s, s1));
        return true;
    }

    public void setSEQ(long l)
    {
        setHeader("SEQ", Long.toString(l));
    }

    public void setSID(String s)
    {
        setHeader("SID", Subscription.toSIDHeaderString(s));
    }
}
