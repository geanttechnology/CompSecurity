// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import org.cybergarage.xml.Node;

public class AllowedValue
{

    public static final String ELEM_NAME = "allowedValue";
    private Node allowedValueNode;

    public AllowedValue(String s)
    {
        allowedValueNode = new Node("allowedValue");
        setValue(s);
    }

    public AllowedValue(Node node)
    {
        allowedValueNode = node;
    }

    public static boolean isAllowedValueNode(Node node)
    {
        return "allowedValue".equals(node.getName());
    }

    public Node getAllowedValueNode()
    {
        return allowedValueNode;
    }

    public String getValue()
    {
        return getAllowedValueNode().getValue();
    }

    public void setValue(String s)
    {
        getAllowedValueNode().setValue(s);
    }
}
