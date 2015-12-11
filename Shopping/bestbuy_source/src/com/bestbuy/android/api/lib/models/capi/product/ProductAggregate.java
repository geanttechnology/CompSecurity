// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.product;

import gs;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.product:
//            ProductAvailability, PriceResponse, ShippingOptions, StoreAvailability

public class ProductAggregate
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/product/ProductAggregate.getSimpleName();
    ArrayList deliveryDates;
    private ProductAvailability productAvailability;
    private ShippingOptions shippingOptions;
    ArrayList stores;
    private PriceResponse tax;
    private PriceResponse unitPrice;

    public ProductAggregate()
    {
    }

    public static ProductAggregate loadData(Node node)
    {
        ProductAggregate productaggregate = new ProductAggregate();
        if (node.getNodeName().compareTo("productservice-response") == 0)
        {
            node = node.getChildNodes();
            int i = 0;
            while (i < node.getLength()) 
            {
                Object obj = node.item(i);
                if (((Node) (obj)).getNodeName().compareTo("availability-query") == 0)
                {
                    productaggregate.productAvailability = ProductAvailability.loadData(((Node) (obj)));
                } else
                if (((Node) (obj)).getNodeName().compareTo("price-response") == 0)
                {
                    productaggregate.unitPrice = PriceResponse.loadPriceData(((Node) (obj)));
                } else
                if (((Node) (obj)).getNodeName().compareTo("estimated-tax") == 0)
                {
                    productaggregate.tax = PriceResponse.loadTaxData(((Node) (obj)));
                } else
                if (((Node) (obj)).getNodeName().compareTo("shipping-options") == 0)
                {
                    productaggregate.shippingOptions = ShippingOptions.loadData(((Node) (obj)));
                } else
                if (((Node) (obj)).getNodeName().compareTo("deliverydate-response") == 0)
                {
                    productaggregate.deliveryDates = new ArrayList();
                    SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
                    obj = ((Node) (obj)).getChildNodes();
                    int j = 0;
                    while (j < ((NodeList) (obj)).getLength()) 
                    {
                        Node node1 = ((NodeList) (obj)).item(j);
                        if (node1.getNodeName().compareTo("deliverydate") == 0)
                        {
                            try
                            {
                                productaggregate.deliveryDates.add(simpledateformat.parse(node1.getTextContent()));
                            }
                            catch (Exception exception)
                            {
                                gs.d(TAG, (new StringBuilder()).append("Could not parse delivery date: ").append(exception.getLocalizedMessage()).toString());
                            }
                        }
                        j++;
                    }
                } else
                if (((Node) (obj)).getNodeName().compareTo("stores") == 0)
                {
                    productaggregate.stores = new ArrayList();
                    NodeList nodelist = ((Node) (obj)).getChildNodes();
                    int k = 0;
                    while (k < nodelist.getLength()) 
                    {
                        obj = nodelist.item(k);
                        if (((Node) (obj)).getNodeName().compareTo("store") == 0)
                        {
                            obj = StoreAvailability.loadData(((Node) (obj)));
                            productaggregate.stores.add(obj);
                        } else
                        {
                            gs.d(TAG, (new StringBuilder()).append("Unknown elements found in while parsing ProductAggregate's store availability: ").append(((Node) (obj)).getNodeName()).toString());
                        }
                        k++;
                    }
                } else
                {
                    gs.d(TAG, (new StringBuilder()).append("Unknown elements found in while parsing ProductAggregate: ").append(((Node) (obj)).getNodeName()).toString());
                }
                i++;
            }
        }
        return productaggregate;
    }

    public ArrayList getDeliveryDates()
    {
        return deliveryDates;
    }

    public ProductAvailability getProductAvailability()
    {
        return productAvailability;
    }

    public ShippingOptions getShippingOptions()
    {
        return shippingOptions;
    }

    public ArrayList getStores()
    {
        return stores;
    }

    public PriceResponse getTax()
    {
        return tax;
    }

    public PriceResponse getUnitPrice()
    {
        return unitPrice;
    }

}
