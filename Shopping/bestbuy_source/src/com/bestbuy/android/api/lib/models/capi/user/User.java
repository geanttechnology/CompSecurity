// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.user;

import com.bestbuy.android.api.lib.models.capi.order.tender.CreditCardTender;
import hb;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.user:
//            CAPIAddress, FriendsFamily

public class User
{

    private ArrayList addresses;
    private ArrayList agents;
    private ArrayList creditCards;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String userID;
    private String zip;

    public User()
    {
    }

    public static User loadData(Node node)
    {
        User user;
        int i;
        user = new User();
        node = node.getChildNodes();
        i = 0;
_L1:
        Object obj;
        if (i >= node.getLength())
        {
            break MISSING_BLOCK_LABEL_426;
        }
        obj = node.item(i);
        if (((Node) (obj)).getNodeName().compareTo("firstname") == 0)
        {
            user.firstName = ((Node) (obj)).getTextContent();
        } else
        if (((Node) (obj)).getNodeName().compareTo("lastname") == 0)
        {
            user.lastName = ((Node) (obj)).getTextContent();
        } else
        if (((Node) (obj)).getNodeName().compareTo("emailaddress") == 0)
        {
            user.emailAddress = ((Node) (obj)).getTextContent();
        } else
        if (((Node) (obj)).getNodeName().compareTo("postalcode") == 0)
        {
            user.zip = ((Node) (obj)).getTextContent();
        } else
        if (((Node) (obj)).getNodeName().compareTo("addresses") == 0)
        {
            user.addresses = new ArrayList();
            obj = ((Node) (obj)).getChildNodes();
            int j = 0;
            while (j < ((NodeList) (obj)).getLength()) 
            {
                Node node1 = ((NodeList) (obj)).item(j);
                if (node1.getNodeName().compareTo("address") == 0)
                {
                    user.addresses.add(CAPIAddress.loadData(node1));
                }
                j++;
            }
        } else
        {
            if (((Node) (obj)).getNodeName().compareTo("creditcards") != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            hb.b(((Node) (obj)));
            user.creditCards = new ArrayList();
            obj = ((Node) (obj)).getChildNodes();
            int k = 0;
            while (k < ((NodeList) (obj)).getLength()) 
            {
                Node node2 = ((NodeList) (obj)).item(k);
                if (node2.getNodeName().compareTo("creditcard") == 0)
                {
                    user.creditCards.add(CreditCardTender.loadData(node2));
                }
                k++;
            }
        }
_L3:
        i++;
          goto _L1
        if (((Node) (obj)).getNodeName().compareTo("agents") != 0) goto _L3; else goto _L2
_L2:
        user.agents = new ArrayList();
        obj = ((Node) (obj)).getChildNodes();
        int l = 0;
        while (l < ((NodeList) (obj)).getLength()) 
        {
            Node node3 = ((NodeList) (obj)).item(l);
            if (node3.getNodeName().compareTo("friends-family-details") == 0)
            {
                user.agents.add(FriendsFamily.loadData(node3));
            }
            l++;
        }
          goto _L3
        return user;
    }

    public ArrayList getAddresses()
    {
        return addresses;
    }

    public ArrayList getAgents()
    {
        return agents;
    }

    public ArrayList getCreditCards()
    {
        return creditCards;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getUserID()
    {
        return userID;
    }

    public String getZip()
    {
        return zip;
    }
}
