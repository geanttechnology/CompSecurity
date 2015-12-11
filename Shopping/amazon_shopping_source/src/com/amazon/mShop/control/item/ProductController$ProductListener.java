// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.Dimension;
import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;
import com.amazon.rio.j2me.client.services.mShop.ExtraProductInfo;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.MultiImage;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickShippingOffers;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;
import com.amazon.rio.j2me.client.services.mShop.ProductRequest;
import com.amazon.rio.j2me.client.services.mShop.ProductResponseListener;
import com.amazon.rio.j2me.client.services.mShop.Savings;
import com.amazon.rio.j2me.client.services.mShop.VariationProductInfo;
import com.amazon.rio.j2me.client.services.mShop.VisualBucket;
import com.amazon.rio.j2me.client.services.mShop.WebLink;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController, Variations

private class <init>
    implements ProductResponseListener
{

    private boolean cancelled;
    private Dimension dimensions[];
    private ServiceCall productServiceCall;
    private int receiveArraySize;
    final ProductController this$0;
    private VariationProductInfo variationProductInfos[];
    private VisualBucket visualBuckets[];

    private void cancel()
    {
        cancelled = true;
        productServiceCall.cancel();
    }

    private void start(ProductRequest productrequest)
    {
        if (ProductController.access$1100(ProductController.this) == null)
        {
            CustomClientFields.setCustomHeaderFields("product_v32", false, ProductController.access$1200(ProductController.this));
        } else
        {
            CustomClientFields.setCustomHeaderFields("product_v32", ProductController.access$1200(ProductController.this), "pageReplacement");
        }
        productServiceCall = ServiceController.getMShopService().product(productrequest, this);
    }

    public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
    {
        receiveArraySize = i;
    }

    public void cancelled(ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;

            public void run()
            {
                ProductController.access$1800(this$0);
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                super();
            }
        });
    }

    public void completed(ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;

            public void run()
            {
                if (!cancelled)
                {
                    ProductController.access$1900(this$0, true);
                    ProductController.access$700(this$0);
                    if (!Util.isEmpty(dimensions) && !Util.isEmpty(variationProductInfos))
                    {
                        ProductController.access$2202(this$0, new Variations(this$0, dimensions, variationProductInfos, visualBuckets));
                        ProductController.access$1102(this$0, ProductController.access$2400(this$0, dimensions, variationProductInfos, visualBuckets));
                    }
                }
                if (getDealId() == null)
                {
                    if (ProductController.access$2500(this$0) != null)
                    {
                        ProductController.access$2500(this$0).cancel();
                    }
                    setDeal(null);
                }
                ProductController.access$2602(this$0, null);
                ProductController.access$800(this$0);
                ProductController.access$900(this$0);
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                super();
            }
        });
    }

    public void error(final Exception e, final ServiceCall sc)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final Exception val$e;
            final ServiceCall val$sc;

            public void run()
            {
                ProductController.access$1000(this$0, e, sc);
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                e = exception;
                sc = servicecall;
                super();
            }
        });
    }

    public void receivedBasicOffer(final BasicOfferListing value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final BasicOfferListing val$value;

            public void run()
            {
                if (!cancelled)
                {
                    ProductController.access$1500(this$0, value);
                    ProductController.access$700(this$0);
                }
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = basicofferlisting;
                super();
            }
        });
    }

    public void receivedBasicProduct(final BasicProductInfo value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final BasicProductInfo val$value;

            public void run()
            {
                if (!cancelled)
                {
                    ProductController.access$1400(this$0, value);
                    if (!Util.isEmpty(value.getImageUrl()))
                    {
                        ProductController.access$500(this$0);
                    }
                }
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = basicproductinfo;
                super();
            }
        });
    }

    public void receivedDealId(final String value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final String val$value;

            public void run()
            {
                setDealId(value);
                if (!Util.isEmpty(value))
                {
                    if (!value.equals(ProductController.access$2600(this$0)))
                    {
                        requestDeal(getDealId());
                    } else
                    {
                        ProductController.access$3100(this$0);
                    }
                }
                ProductController.access$2602(this$0, null);
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = s;
                super();
            }
        });
    }

    public void receivedDimension(Dimension dimension, int i, ServiceCall servicecall)
    {
        if (dimensions.length != receiveArraySize)
        {
            dimensions = new Dimension[receiveArraySize];
        }
        dimensions[i] = dimension;
    }

    public void receivedExternalBuyLink(WebLink weblink, ServiceCall servicecall)
    {
        ProductController.access$3002(ProductController.this, weblink);
    }

    public void receivedExtraOffer(final ExtraOfferListing value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final ExtraOfferListing val$value;

            public void run()
            {
                if (!cancelled)
                {
                    setExtraOfferListing(value);
                    ProductController.access$700(this$0);
                }
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = extraofferlisting;
                super();
            }
        });
    }

    public void receivedExtraProduct(final ExtraProductInfo value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final ExtraProductInfo val$value;

            public void run()
            {
                if (!cancelled)
                {
                    ProductController.access$1700(this$0, value);
                    ProductController.access$700(this$0);
                }
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = extraproductinfo;
                super();
            }
        });
    }

    public void receivedImage(final byte value[], ServiceCall servicecall)
    {
        if (!Util.isEmpty(value))
        {
            com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

                final ProductController.ProductListener this$1;
                final byte val$value[];

                public void run()
                {
                    if (!cancelled)
                    {
                        setEncodedLargeImage(value);
                        ProductController.access$500(this$0);
                    }
                }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = abyte0;
                super();
            }
            });
        }
    }

    public void receivedMultiImage(final MultiImage value, final int index, ServiceCall servicecall)
    {
        if (value != null)
        {
            com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

                final ProductController.ProductListener this$1;
                final int val$index;
                final MultiImage val$value;

                public void run()
                {
                    if (!cancelled)
                    {
                        if (index == 0)
                        {
                            ProductController.access$2700(this$0);
                        }
                        ProductController.access$2800(this$0, value);
                        if (index == 0)
                        {
                            ProductController.access$500(this$0);
                        }
                    }
                }

            
            {
                this$1 = ProductController.ProductListener.this;
                index = i;
                value = multiimage;
                super();
            }
            });
        }
    }

    public void receivedPrimeOneClickShippingOffers(final PrimeOneClickShippingOffers value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ingOffers().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final PrimeOneClickShippingOffers val$value;

            public void run()
            {
                if (!cancelled)
                {
                    ProductController.access$1600(this$0, value);
                    ProductController.access$700(this$0);
                }
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = primeoneclickshippingoffers;
                super();
            }
        });
    }

    public void receivedPrimeOneClickStatus(final PrimeOneClickStatus value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.s().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final PrimeOneClickStatus val$value;

            public void run()
            {
                if (!cancelled)
                {
                    User.setPrimeOneClickStatus(value);
                }
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = primeoneclickstatus;
                super();
            }
        });
    }

    public void receivedSavings(final Savings value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.ProductListener this$1;
            final Savings val$value;

            public void run()
            {
                if (!cancelled)
                {
                    setProductSavings(value);
                }
            }

            
            {
                this$1 = ProductController.ProductListener.this;
                value = savings;
                super();
            }
        });
    }

    public void receivedVariationProductInfo(VariationProductInfo variationproductinfo, int i, ServiceCall servicecall)
    {
        if (variationProductInfos.length != receiveArraySize)
        {
            variationProductInfos = new VariationProductInfo[receiveArraySize];
        }
        variationProductInfos[i] = variationproductinfo;
    }

    public void receivedVisualBucket(VisualBucket visualbucket, int i, ServiceCall servicecall)
    {
        if (visualBuckets.length != receiveArraySize)
        {
            visualBuckets = new VisualBucket[receiveArraySize];
        }
        visualBuckets[i] = visualbucket;
    }

    public void receivedWebLink(WebLink weblink, int i, ServiceCall servicecall)
    {
        ProductController.access$2900(ProductController.this).put(weblink.getName(), weblink);
    }

    public void replay()
    {
        if (productServiceCall != null)
        {
            CustomClientFields.setCustomHeaderFields("product_v32", ProductController.access$1200(ProductController.this), "pageReplacement");
            productServiceCall.replay();
        }
    }







    private _cls9.this._cls1()
    {
        this$0 = ProductController.this;
        super();
        cancelled = false;
        dimensions = new Dimension[0];
        variationProductInfos = new VariationProductInfo[0];
        visualBuckets = new VisualBucket[0];
        receiveArraySize = -1;
    }

    receiveArraySize(receiveArraySize receivearraysize)
    {
        this();
    }
}
