// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.controllers.GetShopItemsListController;
import com.socialin.android.apiv3.model.ShopItemsListResponse;
import com.socialin.android.apiv3.request.GetShopItemsListParams;
import com.socialin.android.billing.d;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.e;
import com.socialin.asyncnet.Request;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.bp.a;
import myobfuscated.bp.b;
import myobfuscated.bp.c;

// Referenced classes of package com.stripe.android.picsart:
//            AliPayHelper

public class StripeIAPController
    implements d
{

    private static final int ALI_REQUEST_CODE = 11101;
    private static final String TAG = com/stripe/android/picsart/StripeIAPController.getSimpleName();
    private static volatile StripeIAPController stripeManager;
    private long MAX_SHOP_ITEMS_CACHE_TIME_MILLIS;
    private ArrayList afterInitQueue;
    private ArrayList allShopItems;
    private HashMap controllersMapping;
    private AliPayHelper iab;
    private long lastAllShopItemsRequestTime;
    private ArrayList paidItemsWithoutPrices;

    private StripeIAPController(Context context, String s)
    {
        afterInitQueue = new ArrayList();
        allShopItems = new ArrayList();
        lastAllShopItemsRequestTime = 0L;
        MAX_SHOP_ITEMS_CACHE_TIME_MILLIS = 0x124f80L;
        paidItemsWithoutPrices = new ArrayList();
        controllersMapping = new HashMap();
        iab = AliPayHelper.getInstance();
        if (afterInitQueue.size() > 0)
        {
            int j = afterInitQueue.size();
            for (int i = 0; i < j; i++)
            {
                ((ModernAsyncTask)afterInitQueue.remove(0)).execute(new Void[0]);
            }

        }
    }

    public static StripeIAPController getInstance(Context context, String s)
    {
        if (stripeManager == null)
        {
            stripeManager = new StripeIAPController(context, s);
        }
        return stripeManager;
    }

    private String getMapKeyForTypeAndTag(String s, String s1)
    {
        if (s == null)
        {
            return s1;
        }
        if (s1 == null)
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s).append(s1).toString();
        }
    }

    private ArrayList getShopItemPrices(ArrayList arraylist)
    {
        return arraylist;
    }

    public void getPurchasedItems(b b1)
    {
        b1.a(new ArrayList());
    }

    public void getShopItemPrice(Activity activity, Object obj, a a1)
    {
        if (obj instanceof com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)
        {
            activity = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)obj;
            a1.a((new StringBuilder("$ ")).append(String.valueOf(activity.getPrice())).toString());
        }
    }

    public boolean handleActivityResult(int i, int j, Intent intent)
    {
        return iab.handleActivityResult(i, j, intent);
    }

    public boolean isBillingSupported()
    {
        return true;
    }

    public void requestNotConsumedItems$54645b82(myobfuscated.b.b b1)
    {
    }

    public void requestPaidShopItemsWithPrices(boolean flag, final c listener, final int page)
    {
        GetShopItemsListController getshopitemslistcontroller = new GetShopItemsListController();
        if (paidItemsWithoutPrices == null || paidItemsWithoutPrices.size() == 0)
        {
            getshopitemslistcontroller.setRequestCompleteListener(new com.socialin.asyncnet.d() {

                final StripeIAPController this$0;
                final c val$listener;
                final int val$page;

                public void onCancelRequest(ShopItemsListResponse shopitemslistresponse, Request request)
                {
                }

                public volatile void onCancelRequest(Object obj, Request request)
                {
                    onCancelRequest((ShopItemsListResponse)obj, request);
                }

                public void onFailure(Exception exception, Request request)
                {
                }

                public transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public void onSuccess(ShopItemsListResponse shopitemslistresponse, Request request)
                {
                    paidItemsWithoutPrices = shopitemslistresponse.response;
                    (new ModernAsyncTask() {

                        final _cls3 this$1;

                        protected volatile Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient ArrayList doInBackground(Void avoid[])
                        {
                            avoid = new ArrayList();
                            int i;
                            int j;
                            if (paidItemsWithoutPrices == null)
                            {
                                i = 0;
                            } else
                            {
                                i = paidItemsWithoutPrices.size();
                            }
                            j = Math.min(i, page * 20 + 20);
                            if (i > page * 20)
                            {
                                for (i = page * 20; i < j; i++)
                                {
                                    avoid.add(paidItemsWithoutPrices.get(i));
                                }

                            }
                            return getShopItemPrices(avoid);
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((ArrayList)obj);
                        }

                        protected void onPostExecute(ArrayList arraylist)
                        {
                            super.onPostExecute(arraylist);
                            c c1 = listener;
                            paidItemsWithoutPrices.size();
                            paidItemsWithoutPrices.size();
                            c1.a(arraylist);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).execute(new Void[0]);
                }

                public volatile void onSuccess(Object obj, Request request)
                {
                    onSuccess((ShopItemsListResponse)obj, request);
                }

            
            {
                this$0 = StripeIAPController.this;
                page = i;
                listener = c1;
                super();
            }
            });
            listener = new GetShopItemsListParams();
            listener.price = "paid";
            getshopitemslistcontroller.doRequest("paidItems", listener);
            return;
        } else
        {
            (new ModernAsyncTask() {

                final StripeIAPController this$0;
                final c val$listener;
                final int val$page;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient ArrayList doInBackground(Void avoid[])
                {
                    avoid = new ArrayList();
                    int i;
                    int j;
                    if (paidItemsWithoutPrices == null)
                    {
                        i = 0;
                    } else
                    {
                        i = paidItemsWithoutPrices.size();
                    }
                    j = Math.min(i, page * 20 + 20);
                    if (i > page * 20)
                    {
                        for (i = page * 20; i < j; i++)
                        {
                            avoid.add(paidItemsWithoutPrices.get(i));
                        }

                    }
                    return getShopItemPrices(avoid);
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((ArrayList)obj);
                }

                protected void onPostExecute(ArrayList arraylist)
                {
                    super.onPostExecute(arraylist);
                    c c1 = listener;
                    paidItemsWithoutPrices.size();
                    paidItemsWithoutPrices.size();
                    c1.a(arraylist);
                }

            
            {
                this$0 = StripeIAPController.this;
                page = i;
                listener = c1;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void requestPurchase(Activity activity, String s, String s1, String s2, double d1, myobfuscated.bp.d d2)
    {
        iab.launchPurchase(activity, d2, 11101, s1, d1);
    }

    public void requestShopItems(boolean flag, final c listener)
    {
        if (allShopItems != null && allShopItems.size() > 0 && System.currentTimeMillis() - lastAllShopItemsRequestTime < MAX_SHOP_ITEMS_CACHE_TIME_MILLIS)
        {
            if (listener != null)
            {
                listener.a(allShopItems);
            }
            return;
        } else
        {
            GetShopItemsListController getshopitemslistcontroller = new GetShopItemsListController();
            getshopitemslistcontroller.setRequestCompleteListener(new com.socialin.asyncnet.d() {

                final StripeIAPController this$0;
                final c val$listener;

                public void onCancelRequest(ShopItemsListResponse shopitemslistresponse, Request request)
                {
                }

                public volatile void onCancelRequest(Object obj, Request request)
                {
                    onCancelRequest((ShopItemsListResponse)obj, request);
                }

                public void onFailure(Exception exception, Request request)
                {
                }

                public transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public void onSuccess(ShopItemsListResponse shopitemslistresponse, Request request)
                {
                    allShopItems = shopitemslistresponse.response;
                    lastAllShopItemsRequestTime = System.currentTimeMillis();
                    if (listener != null)
                    {
                        listener.a(allShopItems);
                    }
                }

                public volatile void onSuccess(Object obj, Request request)
                {
                    onSuccess((ShopItemsListResponse)obj, request);
                }

            
            {
                this$0 = StripeIAPController.this;
                listener = c1;
                super();
            }
            });
            getshopitemslistcontroller.doRequest("allShopItems", new GetShopItemsListParams());
            return;
        }
    }

    public void requestShopItemsForTypeAndTag(boolean flag, String s, String s1, final c listener, int i)
    {
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        String s2 = URLEncoder.encode(s1, e.a.name());
        s1 = s2;
        s2 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        s2 = URLEncoder.encode(s, e.a.name());
        s = s2;
_L2:
        GetShopItemsListController getshopitemslistcontroller1 = (GetShopItemsListController)controllersMapping.get(getMapKeyForTypeAndTag(s1, s));
        GetShopItemsListController getshopitemslistcontroller = getshopitemslistcontroller1;
        if (getshopitemslistcontroller1 == null)
        {
            getshopitemslistcontroller = new GetShopItemsListController();
            controllersMapping.put(getMapKeyForTypeAndTag(s1, s), getshopitemslistcontroller);
        }
        getshopitemslistcontroller.setRequestCompleteListener(new com.socialin.asyncnet.d() {

            final StripeIAPController this$0;
            final c val$listener;

            public void onCancelRequest(ShopItemsListResponse shopitemslistresponse, Request request)
            {
            }

            public volatile void onCancelRequest(Object obj, Request request)
            {
                onCancelRequest((ShopItemsListResponse)obj, request);
            }

            public void onFailure(Exception exception, Request request)
            {
            }

            public transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public void onSuccess(ShopItemsListResponse shopitemslistresponse, Request request)
            {
                listener.a(shopitemslistresponse.response);
            }

            public volatile void onSuccess(Object obj, Request request)
            {
                onSuccess((ShopItemsListResponse)obj, request);
            }

            
            {
                this$0 = StripeIAPController.this;
                listener = c1;
                super();
            }
        });
        listener = new GetShopItemsListParams();
        listener.price = s1;
        listener.tag = s;
        listener.limit = 20;
        listener.offset = i * 20;
        getshopitemslistcontroller.doRequest(s1, listener);
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
_L3:
        com.socialin.android.d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(unsupportedencodingexception.getMessage()).toString()
        });
        if (true) goto _L2; else goto _L1
_L1:
        unsupportedencodingexception;
          goto _L3
    }

    public void setActivity(Activity activity)
    {
    }




/*
    static ArrayList access$002(StripeIAPController stripeiapcontroller, ArrayList arraylist)
    {
        stripeiapcontroller.allShopItems = arraylist;
        return arraylist;
    }

*/


/*
    static long access$102(StripeIAPController stripeiapcontroller, long l)
    {
        stripeiapcontroller.lastAllShopItemsRequestTime = l;
        return l;
    }

*/



/*
    static ArrayList access$202(StripeIAPController stripeiapcontroller, ArrayList arraylist)
    {
        stripeiapcontroller.paidItemsWithoutPrices = arraylist;
        return arraylist;
    }

*/

}
