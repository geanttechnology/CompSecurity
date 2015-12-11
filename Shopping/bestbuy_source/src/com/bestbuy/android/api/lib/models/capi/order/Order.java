// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order;

import com.bestbuy.android.api.lib.models.capi.order.cart.Cart;
import com.bestbuy.android.api.lib.models.capi.order.fulfillment.FulfillmentDelivery;
import com.bestbuy.android.api.lib.models.capi.order.fulfillment.FulfillmentShipping;
import com.bestbuy.android.api.lib.models.capi.order.fulfillment.FulfillmentStore;
import com.bestbuy.android.api.lib.models.capi.order.tender.Tender;
import com.bestbuy.android.api.lib.models.capi.user.CAPIAddress;
import gs;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Order
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/order/Order.getSimpleName();
    private Cart cart;
    private double certAmount;
    private ArrayList extraFees;
    private double orderCost;
    private double productCost;
    private double promoAmount;
    private double salesTax;
    private double shipCost;
    private double svcAmount;
    private String taxMessage;
    private Tender tender;

    public Order()
    {
    }

    public static Order loadData(Cart cart1, Tender tender1)
    {
        Order order = new Order();
        order.cart = cart1;
        order.tender = tender1;
        return order;
    }

    public static Order loadData(Node node)
    {
        Order order;
        ArrayList arraylist;
        Object obj1;
        int i;
        order = new Order();
        node = node.getChildNodes();
        obj1 = new ArrayList();
        i = 0;
        do
        {
            if (i >= node.getLength())
            {
                break;
            }
            Object obj = node.item(i);
            if (((Node) (obj)).getNodeName().compareTo("addresses") == 0)
            {
                obj = ((Node) (obj)).getChildNodes();
                for (i = 0; i < ((NodeList) (obj)).getLength(); i++)
                {
                    ((ArrayList) (obj1)).add(CAPIAddress.loadData(((NodeList) (obj)).item(i)));
                }

                break;
            }
            i++;
        } while (true);
        arraylist = new ArrayList();
        i = 0;
_L11:
        Object obj2;
        if (i >= node.getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = node.item(i);
        if (((Node) (obj2)).getNodeName().compareTo("fulfillment") != 0)
        {
            break MISSING_BLOCK_LABEL_439;
        }
        obj2 = ((Node) (obj2)).getChildNodes();
        i = 0;
_L7:
        Object obj3;
        if (i >= ((NodeList) (obj2)).getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = ((NodeList) (obj2)).item(i);
        if (((Node) (obj3)).getNodeName().compareTo("homedelivery-fulfillment") != 0) goto _L2; else goto _L1
_L1:
        int j;
        obj3 = FulfillmentDelivery.loadData(((Node) (obj3)));
        j = 0;
_L8:
        if (j >= ((ArrayList) (obj1)).size()) goto _L4; else goto _L3
_L3:
        CAPIAddress capiaddress = (CAPIAddress)((ArrayList) (obj1)).get(j);
        if (((FulfillmentDelivery) (obj3)).getFfId().compareTo(capiaddress.getFulfillmentId()) != 0) goto _L6; else goto _L5
_L5:
        ((FulfillmentDelivery) (obj3)).setAddress(capiaddress);
        arraylist.add(obj3);
_L4:
        i++;
          goto _L7
_L6:
        j++;
          goto _L8
_L2:
        if (((Node) (obj3)).getNodeName().compareTo("address-fulfillment") != 0)
        {
            break MISSING_BLOCK_LABEL_377;
        }
        obj3 = FulfillmentShipping.loadData(((Node) (obj3)));
        j = 0;
_L9:
        if (j < ((ArrayList) (obj1)).size())
        {
label0:
            {
                CAPIAddress capiaddress1 = (CAPIAddress)((ArrayList) (obj1)).get(j);
                if (((FulfillmentShipping) (obj3)).getFfId().compareTo(capiaddress1.getFulfillmentId()) != 0)
                {
                    break label0;
                }
                ((FulfillmentShipping) (obj3)).setAddress(capiaddress1);
                arraylist.add(obj3);
            }
        }
          goto _L4
        j++;
          goto _L9
        if (((Node) (obj3)).getNodeName().compareTo("store-fulfillment") == 0)
        {
            arraylist.add(FulfillmentStore.loadData(((Node) (obj3))));
        } else
        {
            gs.d(TAG, (new StringBuilder()).append("Unknown fulfillment XML, skipping: ").append(((Node) (obj3)).getNodeName()).toString());
        }
          goto _L4
        i++;
        if (true) goto _L11; else goto _L10
_L10:
        i = 0;
_L18:
        if (i >= node.getLength()) goto _L13; else goto _L12
_L12:
        obj1 = node.item(i);
        if (((Node) (obj1)).getNodeName().compareToIgnoreCase("cart") != 0)
        {
            break MISSING_BLOCK_LABEL_893;
        }
        obj1 = ((Node) (obj1)).getChildNodes();
        j = 0;
_L15:
        if (j >= ((NodeList) (obj1)).getLength())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = ((NodeList) (obj1)).item(j);
        if (((Node) (obj2)).getNodeName().compareToIgnoreCase("items") != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        order.cart = Cart.loadData(((Node) (obj2)), arraylist);
_L17:
        j++;
        if (true) goto _L15; else goto _L14
_L14:
        if (((Node) (obj2)).getNodeName().compareToIgnoreCase("total") != 0) goto _L17; else goto _L16
_L16:
        obj2 = ((Node) (obj2)).getChildNodes();
        int k = 0;
        while (k < ((NodeList) (obj2)).getLength()) 
        {
            Node node1 = ((NodeList) (obj2)).item(k);
            if (node1.getNodeName().compareToIgnoreCase("product-cost") == 0)
            {
                order.productCost = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("sales-tax") == 0)
            {
                order.salesTax = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("shipping-cost") == 0)
            {
                order.shipCost = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("tax-message") == 0)
            {
                order.taxMessage = node1.getTextContent();
            } else
            if (node1.getNodeName().compareToIgnoreCase("order-cost") == 0)
            {
                order.orderCost = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("svc-amount") == 0)
            {
                order.svcAmount = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("promocode-amount") == 0)
            {
                order.promoAmount = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("rwz-cert-amount") == 0)
            {
                order.certAmount = Double.parseDouble(node1.getTextContent());
            } else
            {
                gs.d(TAG, (new StringBuilder()).append("Unknown XML value found while parsing orderNodeList, skipping:").append(node1.getNodeName()).toString());
            }
            k++;
        }
          goto _L17
        if (((Node) (obj1)).getNodeName().compareToIgnoreCase("tender") == 0)
        {
            order.tender = Tender.loadData(((Node) (obj1)));
        } else
        {
            gs.d(TAG, (new StringBuilder()).append("Unknown XML value found while parsing Order, skipping:").append(((Node) (obj1)).getNodeName()).toString());
        }
        i++;
          goto _L18
_L13:
        return order;
    }

    public Cart getCart()
    {
        return cart;
    }

    public double getCertAmount()
    {
        return certAmount;
    }

    public ArrayList getExtraFees()
    {
        return extraFees;
    }

    public double getOrderCost()
    {
        return orderCost;
    }

    public double getProductCost()
    {
        return productCost;
    }

    public double getPromoAmount()
    {
        return promoAmount;
    }

    public double getSalesTax()
    {
        return salesTax;
    }

    public double getShipCost()
    {
        return shipCost;
    }

    public double getSvcAmount()
    {
        return svcAmount;
    }

    public String getTaxMessage()
    {
        return taxMessage;
    }

    public Tender getTender()
    {
        return tender;
    }

    public String getXML(String s, boolean flag)
    {
        Object obj = (new StringBuilder()).append("<order id=\"").append(s).append("\" reviewable=\"");
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        obj = ((StringBuilder) (obj)).append(s).append("\" > ").toString();
        s = ((String) (obj));
        if (cart != null)
        {
            s = (new StringBuilder()).append(((String) (obj))).append(Cart.getXML(cart)).toString();
        }
        obj = s;
        if (tender != null)
        {
            obj = (new StringBuilder()).append(s).append(Tender.getXML(tender)).toString();
        }
        return (new StringBuilder()).append(((String) (obj))).append("</order>").toString();
    }

}
