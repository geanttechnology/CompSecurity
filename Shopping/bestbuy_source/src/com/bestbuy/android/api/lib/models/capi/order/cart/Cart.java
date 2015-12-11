// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.cart;

import com.bestbuy.android.api.lib.models.capi.order.fulfillment.Fulfillment;
import gs;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.order.cart:
//            CartItemProduct, CartItemWarranty

public class Cart
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/order/cart/Cart.getSimpleName();
    ArrayList cartItemProducts;
    ArrayList cartItemWarranties;

    public Cart()
    {
    }

    public static String getXML(Cart cart)
    {
        Object obj;
        Object obj1;
        ArrayList arraylist;
        int i;
        if (cart.cartItemProducts != null)
        {
            Iterator iterator = cart.cartItemProducts.iterator();
            String s = "<list id=\"list-1\"><items>";
            do
            {
                obj = s;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (CartItemProduct)iterator.next();
                s = (new StringBuilder()).append(s).append(((CartItemProduct) (obj)).getXML()).toString();
            } while (true);
        } else
        {
            obj = "<list id=\"list-1\"><items>";
        }
        obj1 = obj;
        if (cart.cartItemWarranties != null)
        {
            Iterator iterator1 = cart.cartItemWarranties.iterator();
            do
            {
                obj1 = obj;
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj1 = (CartItemWarranty)iterator1.next();
                obj = (new StringBuilder()).append(((String) (obj))).append(((CartItemWarranty) (obj1)).getXML()).toString();
            } while (true);
        }
        obj = (new StringBuilder()).append(((String) (obj1))).append("</items></list>").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append("<fulfillment>").toString();
        obj1 = new ArrayList();
        arraylist = new ArrayList();
        i = 0;
_L7:
        Fulfillment fulfillment;
        int j;
        if (i >= cart.cartItemProducts.size())
        {
            break MISSING_BLOCK_LABEL_343;
        }
        fulfillment = ((CartItemProduct)cart.cartItemProducts.get(i)).getFulfillment();
        if (!arraylist.contains(fulfillment.getFfId()))
        {
            break MISSING_BLOCK_LABEL_323;
        }
        j = 0;
_L5:
        if (j >= ((ArrayList) (obj1)).size()) goto _L2; else goto _L1
_L1:
        Fulfillment fulfillment1 = (Fulfillment)((ArrayList) (obj1)).get(j);
        if (fulfillment1.getFfId().compareTo(fulfillment.getFfId()) != 0) goto _L4; else goto _L3
_L3:
        fulfillment1.setItemId((new StringBuilder()).append(fulfillment1.getItemId()).append(", ").append(fulfillment.getItemId()).toString());
_L2:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        j++;
          goto _L5
        arraylist.add(fulfillment.getFfId());
        ((ArrayList) (obj1)).add(fulfillment);
          goto _L2
        obj1 = ((ArrayList) (obj1)).iterator();
        for (cart = ((Cart) (obj)); ((Iterator) (obj1)).hasNext(); cart = (new StringBuilder()).append(cart).append(((Fulfillment) (obj)).getXML()).toString())
        {
            obj = (Fulfillment)((Iterator) (obj1)).next();
        }

        return (new StringBuilder()).append(cart).append("</fulfillment>").toString();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static Cart loadData(ArrayList arraylist, ArrayList arraylist1)
    {
        Cart cart = new Cart();
        cart.cartItemProducts = arraylist;
        cart.cartItemWarranties = arraylist1;
        return cart;
    }

    public static Cart loadData(Node node, ArrayList arraylist)
    {
        Cart cart;
        int i;
        cart = new Cart();
        cart.cartItemProducts = new ArrayList();
        cart.cartItemWarranties = new ArrayList();
        node = node.getChildNodes();
        i = 0;
_L13:
        if (i >= node.getLength()) goto _L2; else goto _L1
_L1:
        Object obj = node.item(i);
        if (((Node) (obj)).getNodeName().compareTo("item") != 0) goto _L4; else goto _L3
_L3:
        Object obj1;
        int j;
        obj1 = ((Node) (obj)).getChildNodes();
        j = 0;
_L14:
        Node node1;
        if (j >= ((NodeList) (obj1)).getLength())
        {
            break MISSING_BLOCK_LABEL_314;
        }
        node1 = ((NodeList) (obj1)).item(j);
        if (node1.getNodeName().compareTo("shipping-cost") != 0 && node1.getNodeName().compareTo("delivery-charge") != 0) goto _L6; else goto _L5
_L5:
        j = 1;
_L17:
        if (j == 0) goto _L8; else goto _L7
_L7:
        obj = CartItemProduct.loadData(((Node) (obj)));
        j = 0;
_L15:
        if (j >= arraylist.size()) goto _L10; else goto _L9
_L9:
        obj1 = (Fulfillment)arraylist.get(j);
        if (((Fulfillment) (obj1)).getItemId().compareToIgnoreCase(((CartItemProduct) (obj)).itemId) != 0) goto _L12; else goto _L11
_L11:
        ((CartItemProduct) (obj)).setFulfillment(((Fulfillment) (obj1)));
_L10:
        cart.cartItemProducts.add(obj);
_L16:
        i++;
          goto _L13
_L6:
        j++;
          goto _L14
_L12:
        j++;
          goto _L15
_L8:
        try
        {
            obj = CartItemWarranty.loadData(((Node) (obj)));
            cart.cartItemWarranties.add(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            gs.d(TAG, (new StringBuilder()).append("Error parsing Cart Item Warranty - Skipping: ").append(node.getLocalizedMessage()).toString());
            throw node;
        }
          goto _L16
_L4:
        gs.d(TAG, (new StringBuilder()).append("Unknown XML item while parsing Cart Items, skipping: ").append(((Node) (obj)).getNodeName()).toString());
          goto _L16
_L2:
        return cart;
        j = 0;
          goto _L17
    }

    public ArrayList getCartItemProducts()
    {
        return cartItemProducts;
    }

    public ArrayList getCartItemWarranties()
    {
        return cartItemWarranties;
    }

}
