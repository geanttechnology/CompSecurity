// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.tender;

import com.bestbuy.android.api.lib.models.capi.user.CAPIAddress;
import gs;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class CreditCardTender
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender.getSimpleName();
    private CAPIAddress address;
    private String addressId;
    private boolean ccDefault;
    String ccNumber;
    private String ccType;
    private String cid;
    private String editID;
    private String expMonth;
    private String expYear;
    private String lastFour;

    public CreditCardTender()
    {
    }

    public static CreditCardTender loadData(Node node)
    {
        CreditCardTender creditcardtender = new CreditCardTender();
        node = node.getAttributes();
        Object obj = node.getNamedItem("default");
        if (obj != null)
        {
            if (((Node) (obj)).getNodeValue().compareToIgnoreCase("true") == 0)
            {
                creditcardtender.ccDefault = true;
            } else
            {
                creditcardtender.ccDefault = false;
            }
        }
        obj = node.getNamedItem("name");
        if (obj != null)
        {
            creditcardtender.ccType = ((Node) (obj)).getNodeValue();
        }
        obj = node.getNamedItem("last-four");
        if (obj != null)
        {
            creditcardtender.lastFour = ((Node) (obj)).getNodeValue();
        }
        obj = node.getNamedItem("exp-date");
        if (obj != null)
        {
            obj = ((Node) (obj)).getNodeValue();
            creditcardtender.expMonth = ((String) (obj)).substring(0, 2);
            creditcardtender.expYear = ((String) (obj)).substring(3, 5);
        }
        node = node.getNamedItem("addressRef");
        if (node != null)
        {
            creditcardtender.addressId = node.getNodeValue();
        }
        return creditcardtender;
    }

    public static CreditCardTender loadData(boolean flag, String s, String s1, String s2, String s3, String s4, CAPIAddress capiaddress)
    {
        CreditCardTender creditcardtender = new CreditCardTender();
        creditcardtender.ccDefault = flag;
        creditcardtender.ccType = s;
        creditcardtender.ccNumber = s1;
        creditcardtender.cid = s2;
        creditcardtender.expMonth = s3;
        creditcardtender.expYear = s4;
        creditcardtender.address = capiaddress;
        return creditcardtender;
    }

    public CAPIAddress getAddress()
    {
        return address;
    }

    public String getAddressId()
    {
        return addressId;
    }

    public String getCcNumber()
    {
        return ccNumber;
    }

    public String getCcType()
    {
        return ccType;
    }

    public String getCid()
    {
        return cid;
    }

    public String getEditID()
    {
        return editID;
    }

    public String getExpMonth()
    {
        return expMonth;
    }

    public String getExpYear()
    {
        return expYear;
    }

    public String getLastFour()
    {
        return lastFour;
    }

    public String getXML()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("").append("<credit-card default=\"");
        Object obj;
        if (ccDefault)
        {
            obj = "true";
        } else
        {
            obj = "false";
        }
        obj = stringbuilder.append(((String) (obj))).append("\">\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<cc-type>").append(ccType).append("</cc-type>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<cid>").append(cid).append("</cid>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<cc-number>").append(ccNumber).append("</cc-number>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<exp-month>").append(expMonth).append("</exp-month>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<exp-year>").append(expYear).append("</exp-year>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<address type=\"").append(address.getType()).append("\">\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<firstname>").append(address.getFirstName()).append("</firstname>\n").toString();
        if (address.getMiddleName() != null)
        {
            obj = (new StringBuilder()).append(((String) (obj))).append("<middlename>").append(address.getMiddleName()).append("</middlename>\n").toString();
        } else
        {
            obj = (new StringBuilder()).append(((String) (obj))).append("<middlename/>\n").toString();
        }
        obj = (new StringBuilder()).append(((String) (obj))).append("<lastname>").append(address.getLastName()).append("</lastname>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<email>").append(address.getEmail()).append("</email>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<address1>").append(address.getAddress1()).append("</address1>\n").toString();
        if (address.getAddress2() == null) goto _L2; else goto _L1
_L1:
        obj = (new StringBuilder()).append(((String) (obj))).append("<address2>").append(address.getAddress2()).append("</address2>\n").toString();
_L3:
        obj = (new StringBuilder()).append(((String) (obj))).append("<city>").append(address.getCity()).append("</city>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<state>").append(address.getState()).append("</state>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<country>").append(address.getCountry()).append("</country>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<postalcode>").append(address.getZip()).append("</postalcode>\n").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<phonenumber>").append(address.getPhoneNumber()).append("</phonenumber>\n").toString();
        if (address.getAltPhone() == null)
        {
            break MISSING_BLOCK_LABEL_773;
        }
        obj = (new StringBuilder()).append(((String) (obj))).append("<otherphone>").append(address.getAltPhone()).append("</otherphone>\n").toString();
_L4:
        obj = (new StringBuilder()).append(((String) (obj))).append("</address>\n").toString();
        return (new StringBuilder()).append(((String) (obj))).append("</credit-card>\n").toString();
_L2:
        try
        {
            obj = (new StringBuilder()).append(((String) (obj))).append("<address2/>\n").toString();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            gs.e(TAG, (new StringBuilder()).append("Could not create XML for a Credit Card Object: ").append(((Exception) (obj)).getLocalizedMessage()).toString());
            throw obj;
        }
          goto _L3
        obj = (new StringBuilder()).append(((String) (obj))).append("<otherphone/>\n").toString();
          goto _L4
    }

    public boolean isCcDefault()
    {
        return ccDefault;
    }

}
