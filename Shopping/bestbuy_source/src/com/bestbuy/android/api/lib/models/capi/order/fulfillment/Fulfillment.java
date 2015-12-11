// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.fulfillment;

import com.bestbuy.android.api.lib.models.capi.user.CAPIAddress;

public abstract class Fulfillment
{

    protected String ffId;
    protected String itemId;

    public Fulfillment()
    {
    }

    protected String getCAPIAddressGuts(CAPIAddress capiaddress)
    {
        String s;
        try
        {
            s = (new StringBuilder()).append("").append("<firstname>").append(capiaddress.getFirstName()).append("</firstname>").toString();
            if (capiaddress.getMiddleName() != null)
            {
                s = (new StringBuilder()).append(s).append("<middlename>").append(capiaddress.getMiddleName()).append("</middlename>").toString();
            } else
            {
                s = (new StringBuilder()).append(s).append("<middlename/>").toString();
            }
            s = (new StringBuilder()).append(s).append("<lastname>").append(capiaddress.getLastName()).append("</lastname>").toString();
            s = (new StringBuilder()).append(s).append("<address1>").append(capiaddress.getAddress1()).append("</address1>").toString();
        }
        // Misplaced declaration of an exception variable
        catch (CAPIAddress capiaddress)
        {
            throw capiaddress;
        }
        if (capiaddress.getAddress2() == null)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        s = (new StringBuilder()).append(s).append("<address2>").append(capiaddress.getAddress2()).append("</address2>").toString();
        s = (new StringBuilder()).append(s).append("<city>").append(capiaddress.getCity()).append("</city>").toString();
        s = (new StringBuilder()).append(s).append("<state>").append(capiaddress.getState()).append("</state>").toString();
        s = (new StringBuilder()).append(s).append("<postalcode>").append(capiaddress.getZip()).append("</postalcode>").toString();
        s = (new StringBuilder()).append(s).append("<phonenumber>").append(capiaddress.getPhoneNumber()).append("</phonenumber>").toString();
        return (new StringBuilder()).append(s).append("<country>").append(capiaddress.getCountry()).append("</country>").toString();
        s = (new StringBuilder()).append(s).append("<address2/>").toString();
        break MISSING_BLOCK_LABEL_175;
    }

    public String getFfId()
    {
        return ffId;
    }

    public String getItemId()
    {
        return itemId;
    }

    public abstract String getXML();

    public void setItemId(String s)
    {
        itemId = s;
    }
}
