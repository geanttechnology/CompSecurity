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
import org.w3c.dom.NodeList;

public class FriendsFamily
{

    private String email;
    private boolean ffDefault;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public FriendsFamily()
    {
    }

    public static FriendsFamily loadData(Node node)
    {
        int i = 0;
        FriendsFamily friendsfamily = new FriendsFamily();
        Node node1 = node.getAttributes().getNamedItem("default");
        if (node1 != null)
        {
            if (node1.getNodeValue().compareToIgnoreCase("true") == 0)
            {
                friendsfamily.ffDefault = true;
            } else
            {
                friendsfamily.ffDefault = false;
            }
        }
        node = node.getChildNodes();
        while (i < node.getLength()) 
        {
            Node node2 = node.item(i);
            if (node2.getNodeName().compareToIgnoreCase("firstname") == 0)
            {
                friendsfamily.firstName = node2.getTextContent();
            } else
            if (node2.getNodeName().compareToIgnoreCase("lastname") == 0)
            {
                friendsfamily.lastName = node2.getTextContent();
            } else
            if (node2.getNodeName().compareToIgnoreCase("emailaddress") == 0)
            {
                friendsfamily.email = node2.getTextContent();
            } else
            if (node2.getNodeName().compareToIgnoreCase("phonenumber") == 0)
            {
                friendsfamily.phoneNumber = node2.getTextContent();
            }
            i++;
        }
        return friendsfamily;
    }

    public static FriendsFamily loadData(boolean flag, String s, String s1, String s2, String s3)
    {
        FriendsFamily friendsfamily = new FriendsFamily();
        friendsfamily.ffDefault = flag;
        friendsfamily.firstName = s;
        friendsfamily.lastName = s1;
        friendsfamily.email = s2;
        friendsfamily.phoneNumber = s3;
        return friendsfamily;
    }

    public String getEmail()
    {
        return email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public Document getXML()
    {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("friends-family-details");
        Object obj;
        if (ffDefault)
        {
            obj = "true";
        } else
        {
            obj = "false";
        }
        element.setAttribute("default", ((String) (obj)));
        document.appendChild(element);
        obj = document.createElement("firstname");
        ((Node) (obj)).setTextContent(firstName);
        element.appendChild(((Node) (obj)));
        obj = document.createElement("lastname");
        ((Node) (obj)).setTextContent(lastName);
        element.appendChild(((Node) (obj)));
        obj = document.createElement("emailaddress");
        ((Node) (obj)).setTextContent(email);
        element.appendChild(((Node) (obj)));
        obj = document.createElement("phonenumber");
        ((Node) (obj)).setTextContent(phoneNumber);
        element.appendChild(((Node) (obj)));
        return document;
    }

    public boolean isFfDefault()
    {
        return ffDefault;
    }
}
