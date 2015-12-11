// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.tender;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class PromoTender
{

    private String code;

    public PromoTender()
    {
    }

    public static PromoTender loadData(Node node)
    {
        PromoTender promotender = new PromoTender();
        promotender.code = node.getAttributes().getNamedItem("code").getTextContent();
        return promotender;
    }

    public String getCode()
    {
        return code;
    }

    public String getXML()
    {
        return (new StringBuilder()).append("<promotionalcode code=\"").append(code).append("\"></promotionalcode>").toString();
    }
}
