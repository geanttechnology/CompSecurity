// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import org.cybergarage.xml.Node;

public class Icon
{

    private static final String DEPTH = "depth";
    public static final String ELEM_NAME = "icon";
    private static final String HEIGHT = "height";
    private static final String MIME_TYPE = "mimeType";
    private static final String URL = "url";
    private static final String WIDTH = "width";
    private Node iconNode;
    private Object userData;

    public Icon(Node node)
    {
        userData = null;
        iconNode = node;
    }

    public static boolean isIconNode(Node node)
    {
        return "icon".equals(node.getName());
    }

    public String getDepth()
    {
        return getIconNode().getNodeValue("depth");
    }

    public int getHeight()
    {
        int i;
        try
        {
            i = Integer.parseInt(getIconNode().getNodeValue("height"));
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    public Node getIconNode()
    {
        return iconNode;
    }

    public String getMimeType()
    {
        return getIconNode().getNodeValue("mimeType");
    }

    public String getURL()
    {
        return getIconNode().getNodeValue("url");
    }

    public Object getUserData()
    {
        return userData;
    }

    public int getWidth()
    {
        int i;
        try
        {
            i = Integer.parseInt(getIconNode().getNodeValue("width"));
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    public void setDepth(String s)
    {
        getIconNode().setNode("depth", s);
    }

    public void setHeight(int i)
    {
        try
        {
            setHeight(Integer.toString(i));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void setHeight(String s)
    {
        getIconNode().setNode("height", s);
    }

    public void setMimeType(String s)
    {
        getIconNode().setNode("mimeType", s);
    }

    public void setURL(String s)
    {
        getIconNode().setNode("url", s);
    }

    public void setUserData(Object obj)
    {
        userData = obj;
    }

    public void setWidth(int i)
    {
        try
        {
            setWidth(Integer.toString(i));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void setWidth(String s)
    {
        getIconNode().setNode("width", s);
    }
}
