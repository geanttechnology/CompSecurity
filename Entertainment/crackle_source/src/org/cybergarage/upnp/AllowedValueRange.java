// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import org.cybergarage.xml.Node;

public class AllowedValueRange
{

    public static final String ELEM_NAME = "allowedValueRange";
    private static final String MAXIMUM = "maximum";
    private static final String MINIMUM = "minimum";
    private static final String STEP = "step";
    private Node allowedValueRangeNode;

    public AllowedValueRange()
    {
        allowedValueRangeNode = new Node("allowedValueRange");
    }

    public AllowedValueRange(Number number, Number number1, Number number2)
    {
        allowedValueRangeNode = new Node("allowedValueRange");
        if (number != null)
        {
            setMaximum(number.toString());
        }
        if (number1 != null)
        {
            setMinimum(number1.toString());
        }
        if (number2 != null)
        {
            setStep(number2.toString());
        }
    }

    public AllowedValueRange(Node node)
    {
        allowedValueRangeNode = node;
    }

    public static boolean isAllowedValueRangeNode(Node node)
    {
        return "allowedValueRange".equals(node.getName());
    }

    public Node getAllowedValueRangeNode()
    {
        return allowedValueRangeNode;
    }

    public String getMaximum()
    {
        return getAllowedValueRangeNode().getNodeValue("maximum");
    }

    public String getMinimum()
    {
        return getAllowedValueRangeNode().getNodeValue("minimum");
    }

    public String getStep()
    {
        return getAllowedValueRangeNode().getNodeValue("step");
    }

    public void setMaximum(String s)
    {
        getAllowedValueRangeNode().setNode("maximum", s);
    }

    public void setMinimum(String s)
    {
        getAllowedValueRangeNode().setNode("minimum", s);
    }

    public void setStep(String s)
    {
        getAllowedValueRangeNode().setNode("step", s);
    }
}
