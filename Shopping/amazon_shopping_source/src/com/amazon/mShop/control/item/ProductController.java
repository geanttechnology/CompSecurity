// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.VariationsSelectionAdapter;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.platform.Resources;
import com.amazon.mShop.ui.ListingSelectionListener;
import com.amazon.mShop.ui.resources.BadgeType;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Badge;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.CartItem;
import com.amazon.rio.j2me.client.services.mShop.ConditionalOffersSummary;
import com.amazon.rio.j2me.client.services.mShop.Deal;
import com.amazon.rio.j2me.client.services.mShop.DealRequest;
import com.amazon.rio.j2me.client.services.mShop.DealResponseListener;
import com.amazon.rio.j2me.client.services.mShop.Dimension;
import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;
import com.amazon.rio.j2me.client.services.mShop.ExtraProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.MerchantInfo;
import com.amazon.rio.j2me.client.services.mShop.MultiImage;
import com.amazon.rio.j2me.client.services.mShop.OffersSummary;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickShippingOffers;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;
import com.amazon.rio.j2me.client.services.mShop.ProductRequest;
import com.amazon.rio.j2me.client.services.mShop.ProductResponseListener;
import com.amazon.rio.j2me.client.services.mShop.Savings;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.ShippingOffer;
import com.amazon.rio.j2me.client.services.mShop.VariationProductInfo;
import com.amazon.rio.j2me.client.services.mShop.VisualBucket;
import com.amazon.rio.j2me.client.services.mShop.WebLink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.control.item:
//            Product, ClickStreamTag, Variations, ProductSubscriber

public class ProductController
    implements VariationsSelectionAdapter, Product, ListingSelectionListener
{
    private class DealListener
        implements DealResponseListener
    {

        private ServiceCall dealServiceCall;
        final ProductController this$0;

        public void cancel()
        {
            if (dealServiceCall != null)
            {
                dealServiceCall.cancel();
                dealServiceCall = null;
            }
        }

        public void cancelled(ServiceCall servicecall)
        {
        }

        public void completed(ServiceCall servicecall)
        {
        }

        public void error(Exception exception, final ServiceCall sc)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(exception. new Runnable() {

                final DealListener this$1;
                final Exception val$e;
                final ServiceCall val$sc;

                public void run()
                {
                    if (sc == dealServiceCall)
                    {
                        notifyError(e, sc);
                    }
                }

            
            {
                this$1 = final_deallistener;
                sc = servicecall;
                e = Exception.this;
                super();
            }
            });
        }

        public void receivedDeal(Deal deal, final ServiceCall sc)
        {
            if (deal.getMsToStart() != null)
            {
                deal.setMsToStart(Integer.valueOf((int)(System.currentTimeMillis() / 1000L + (long)(deal.getMsToStart().intValue() / 1000))));
            }
            if (deal.getMsToEnd() != null)
            {
                deal.setMsToEnd(Integer.valueOf((int)(System.currentTimeMillis() / 1000L + (long)(deal.getMsToEnd().intValue() / 1000))));
            }
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(deal. new Runnable() {

                final DealListener this$1;
                final ServiceCall val$sc;
                final Deal val$value;

                public void run()
                {
                    if (sc == dealServiceCall)
                    {
                        setDeal(value);
                        notifyDealBlockUpdated();
                    }
                }

            
            {
                this$1 = final_deallistener;
                sc = servicecall;
                value = Deal.this;
                super();
            }
            });
        }

        public void requestDeal(String s)
        {
            cancel();
            DealRequest dealrequest = new DealRequest();
            dealrequest.setDealId(s);
            dealrequest.setShowVariations(Boolean.valueOf(true));
            dealrequest.setAsin(asin);
            CustomClientFields.setCustomHeaderFields("deal_v32", true, mRequestId);
            dealServiceCall = ServiceController.getMShopService().deal(dealrequest, this);
        }


        private DealListener()
        {
            this$0 = ProductController.this;
            super();
        }

    }

    private class ProductListener
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
            if (selectedChild == null)
            {
                CustomClientFields.setCustomHeaderFields("product_v32", false, mRequestId);
            } else
            {
                CustomClientFields.setCustomHeaderFields("product_v32", mRequestId, "pageReplacement");
            }
            productServiceCall = ServiceController.getMShopService().product(productrequest, this);
        }

        public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
        {
            receiveArraySize = i;
        }

        public void cancelled(ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final ProductListener this$1;

                public void run()
                {
                    notifyCancelled();
                }

            
            {
                this$1 = ProductListener.this;
                super();
            }
            });
        }

        public void completed(ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final ProductListener this$1;

                public void run()
                {
                    if (!cancelled)
                    {
                        setPrimeOneClickShippineOffersReceived(true);
                        notifyProductUpdated();
                        if (!Util.isEmpty(dimensions) && !Util.isEmpty(variationProductInfos))
                        {
                            variations = new Variations(_fld0, dimensions, variationProductInfos, visualBuckets);
                            selectedChild = getPreselectedVariationChild(dimensions, variationProductInfos, visualBuckets);
                        }
                    }
                    if (getDealId() == null)
                    {
                        if (mDealListener != null)
                        {
                            mDealListener.cancel();
                        }
                        setDeal(null);
                    }
                    mPendingDealId = null;
                    notifyServiceCallComplete();
                    productRequestEnded();
                }

            
            {
                this$1 = ProductListener.this;
                super();
            }
            });
        }

        public void error(final Exception e, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(servicecall. new Runnable() {

                final ProductListener this$1;
                final Exception val$e;
                final ServiceCall val$sc;

                public void run()
                {
                    notifyError(e, sc);
                }

            
            {
                this$1 = final_productlistener;
                e = exception;
                sc = ServiceCall.this;
                super();
            }
            });
        }

        public void receivedBasicOffer(BasicOfferListing basicofferlisting, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(basicofferlisting. new Runnable() {

                final ProductListener this$1;
                final BasicOfferListing val$value;

                public void run()
                {
                    if (!cancelled)
                    {
                        setBasicOffer(value);
                        notifyProductUpdated();
                    }
                }

            
            {
                this$1 = final_productlistener;
                value = BasicOfferListing.this;
                super();
            }
            });
        }

        public void receivedBasicProduct(BasicProductInfo basicproductinfo, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(basicproductinfo. new Runnable() {

                final ProductListener this$1;
                final BasicProductInfo val$value;

                public void run()
                {
                    if (!cancelled)
                    {
                        setBasicProduct(value);
                        if (!Util.isEmpty(value.getImageUrl()))
                        {
                            notifyImageChanged();
                        }
                    }
                }

            
            {
                this$1 = final_productlistener;
                value = BasicProductInfo.this;
                super();
            }
            });
        }

        public void receivedDealId(String s, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(s. new Runnable() {

                final ProductListener this$1;
                final String val$value;

                public void run()
                {
                    setDealId(value);
                    if (!Util.isEmpty(value))
                    {
                        if (!value.equals(mPendingDealId))
                        {
                            requestDeal(getDealId());
                        } else
                        {
                            notifyDealBlockUpdated();
                        }
                    }
                    mPendingDealId = null;
                }

            
            {
                this$1 = final_productlistener;
                value = String.this;
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
            externalBuyLink = weblink;
        }

        public void receivedExtraOffer(ExtraOfferListing extraofferlisting, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(extraofferlisting. new Runnable() {

                final ProductListener this$1;
                final ExtraOfferListing val$value;

                public void run()
                {
                    if (!cancelled)
                    {
                        setExtraOfferListing(value);
                        notifyProductUpdated();
                    }
                }

            
            {
                this$1 = final_productlistener;
                value = ExtraOfferListing.this;
                super();
            }
            });
        }

        public void receivedExtraProduct(ExtraProductInfo extraproductinfo, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(extraproductinfo. new Runnable() {

                final ProductListener this$1;
                final ExtraProductInfo val$value;

                public void run()
                {
                    if (!cancelled)
                    {
                        setExtraProduct(value);
                        notifyProductUpdated();
                    }
                }

            
            {
                this$1 = final_productlistener;
                value = ExtraProductInfo.this;
                super();
            }
            });
        }

        public void receivedImage(byte abyte0[], ServiceCall servicecall)
        {
            if (!Util.isEmpty(abyte0))
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(abyte0. new Runnable() {

                    final ProductListener this$1;
                    final byte val$value[];

                    public void run()
                    {
                        if (!cancelled)
                        {
                            setEncodedLargeImage(value);
                            notifyImageChanged();
                        }
                    }

            
            {
                this$1 = final_productlistener;
                value = _5B_B.this;
                super();
            }
                });
            }
        }

        public void receivedMultiImage(MultiImage multiimage, final int index, ServiceCall servicecall)
        {
            if (multiimage != null)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(multiimage. new Runnable() {

                    final ProductListener this$1;
                    final int val$index;
                    final MultiImage val$value;

                    public void run()
                    {
                        if (!cancelled)
                        {
                            if (index == 0)
                            {
                                clearMultiImages();
                            }
                            setMultiImages(value);
                            if (index == 0)
                            {
                                notifyImageChanged();
                            }
                        }
                    }

            
            {
                this$1 = final_productlistener;
                index = i;
                value = MultiImage.this;
                super();
            }
                });
            }
        }

        public void receivedPrimeOneClickShippingOffers(PrimeOneClickShippingOffers primeoneclickshippingoffers, ServiceCall servicecall)
        {
            