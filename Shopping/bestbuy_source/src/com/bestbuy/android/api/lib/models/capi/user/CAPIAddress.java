// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.user;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class CAPIAddress
{

    private String address1;
    private String address2;
    private String altPhone;
    private String city;
    private String country;
    private String email;
    private String firstName;
    private String fulfillmentId;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String state;
    private String type;
    private boolean verified;
    private String zip;

    public CAPIAddress()
    {
    }

    public static CAPIAddress loadData(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, String s10)
    {
        CAPIAddress capiaddress = new CAPIAddress();
        capiaddress.type = s;
        capiaddress.firstName = s1;
        capiaddress.lastName = s2;
        capiaddress.address1 = s3;
        capiaddress.address2 = s4;
        capiaddress.city = s5;
        capiaddress.state = s6;
        capiaddress.zip = s7;
        capiaddress.country = s8;
        capiaddress.email = s9;
        capiaddress.phoneNumber = s10;
        return capiaddress;
    }

    public static CAPIAddress loadData(Node node)
    {
        CAPIAddress capiaddress = new CAPIAddress();
        node = node.getAttributes();
        Node node1 = node.getNamedItem("type");
        if (node1 != null)
        {
            capiaddress.type = node1.getNodeValue();
        }
        node1 = node.getNamedItem("firstname");
        if (node1 != null)
        {
            capiaddress.firstName = node1.getNodeValue();
        }
        node1 = node.getNamedItem("middlename");
        if (node1 != null)
        {
            capiaddress.middleName = node1.getNodeValue();
        }
        node1 = node.getNamedItem("lastname");
        if (node1 != null)
        {
            capiaddress.lastName = node1.getNodeValue();
        }
        node1 = node.getNamedItem("address1");
        if (node1 != null)
        {
            capiaddress.address1 = node1.getNodeValue();
        }
        node1 = node.getNamedItem("address2");
        if (node1 != null)
        {
            capiaddress.address2 = node1.getNodeValue();
        }
        node1 = node.getNamedItem("city");
        if (node1 != null)
        {
            capiaddress.city = node1.getNodeValue();
        }
        node1 = node.getNamedItem("state");
        if (node1 != null)
        {
            capiaddress.state = node1.getNodeValue();
        }
        node1 = node.getNamedItem("postalcode");
        if (node1 != null)
        {
            capiaddress.zip = node1.getNodeValue();
        }
        node1 = node.getNamedItem("country");
        if (node1 != null)
        {
            capiaddress.country = node1.getNodeValue();
        }
        node1 = node.getNamedItem("phonenumber");
        if (node1 != null)
        {
            capiaddress.phoneNumber = node1.getNodeValue();
        }
        node1 = node.getNamedItem("email");
        if (node1 != null)
        {
            capiaddress.email = node1.getNodeValue();
        }
        node = node.getNamedItem("fulfillment-id");
        if (node != null)
        {
            capiaddress.fulfillmentId = node.getNodeValue();
        }
        return capiaddress;
    }

    public String getAddress1()
    {
        return address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public String getAltPhone()
    {
        return altPhone;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountry()
    {
        return country;
    }

    public String getEmail()
    {
        return email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getFulfillmentId()
    {
        return fulfillmentId;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getState()
    {
        return state;
    }

    public String getType()
    {
        return type;
    }

    public Document getXML()
    {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("address");
        if (type != null && type.compareTo("") != 0)
        {
            element.setAttribute("type", type);
        }
        document.appendChild(element);
        Element element1 = document.createElement("firstname");
        element1.setTextContent(firstName);
        element.appendChild(element1);
        element1 = document.createElement("lastname");
        element1.setTextContent(lastName);
        element.appendChild(element1);
        element1 = document.createElement("address1");
        element1.setTextContent(address1);
        element.appendChild(element1);
        element1 = document.createElement("address2");
        element1.setTextContent(address2);
        element.appendChild(element1);
        element1 = document.createElement("city");
        element1.setTextContent(city);
        element.appendChild(element1);
        element1 = document.createElement("state");
        element1.setTextContent(state);
        element.appendChild(element1);
        element1 = document.createElement("country");
        element1.setTextContent(country);
        element.appendChild(element1);
        element1 = document.createElement("postalcode");
        element1.setTextContent(zip);
        element.appendChild(element1);
        element1 = document.createElement("phonenumber");
        element1.setTextContent(phoneNumber);
        element.appendChild(element1);
        element1 = document.createElement("otherphone");
        element1.setTextContent(altPhone);
        element.appendChild(element1);
        if (fulfillmentId != null)
        {
            Element element2 = document.createElement("fulfillment-id");
            element2.setTextContent(fulfillmentId);
            element.appendChild(element2);
        }
        return document;
    }

    public String getZip()
    {
        return zip;
    }

    public boolean isVerified()
    {
        return verified;
    }
}
