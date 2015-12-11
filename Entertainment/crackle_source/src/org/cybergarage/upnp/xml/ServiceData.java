// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.xml;

import org.cybergarage.upnp.event.SubscriberList;
import org.cybergarage.util.ListenerList;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp.xml:
//            NodeData

public class ServiceData extends NodeData
{

    private ListenerList controlActionListenerList;
    private String descriptionURL;
    private Node scpdNode;
    private String sid;
    private SubscriberList subscriberList;
    private long timeout;

    public ServiceData()
    {
        controlActionListenerList = new ListenerList();
        scpdNode = null;
        subscriberList = new SubscriberList();
        descriptionURL = "";
        sid = "";
        timeout = 0L;
    }

    public ListenerList getControlActionListenerList()
    {
        return controlActionListenerList;
    }

    public String getDescriptionURL()
    {
        return descriptionURL;
    }

    public Node getSCPDNode()
    {
        return scpdNode;
    }

    public String getSID()
    {
        return sid;
    }

    public SubscriberList getSubscriberList()
    {
        return subscriberList;
    }

    public long getTimeout()
    {
        return timeout;
    }

    public void setDescriptionURL(String s)
    {
        descriptionURL = s;
    }

    public void setSCPDNode(Node node)
    {
        scpdNode = node;
    }

    public void setSID(String s)
    {
        sid = s;
    }

    public void setTimeout(long l)
    {
        timeout = l;
    }
}
