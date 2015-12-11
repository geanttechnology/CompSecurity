// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.net.api.ecas.AddItemToShoppingCartRequest;
import com.ebay.nautilus.domain.net.api.ecas.CreateCheckoutSessionRequest;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiContext;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiRequest;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiResponse;
import com.ebay.nautilus.domain.net.api.ecas.GetAndValidateShoppingCartByUserIdRequest;
import com.ebay.nautilus.domain.net.api.ecas.GetShoppingCartByUserIdRequest;
import com.ebay.nautilus.domain.net.api.ecas.MoveItemFromCartToSaveForLaterRequest;
import com.ebay.nautilus.domain.net.api.ecas.MoveItemFromSaveForLaterToCartRequest;
import com.ebay.nautilus.domain.net.api.ecas.RemoveItemFromSaveForLaterRequest;
import com.ebay.nautilus.domain.net.api.ecas.RemoveItemFromShoppingCartRequest;
import com.ebay.nautilus.domain.net.api.ecas.UpdateShoppingCartRequest;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasCheckoutResponse;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasCheckoutSessionAdapter;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCartMapper;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCartResponse;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetMultipleItemsRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetMultipleItemsResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase

public class EcasShoppingCartDataManager extends ShoppingCartDataManagerBase
{
    public final class AddToShoppingCartTask extends EcasShoppingCartTask
    {

        private final Long ebayItemId;
        private final int requestedQuantity;
        private final String storeLocationId;
        final EcasShoppingCartDataManager this$0;
        private final String variationId;

        protected EcasApiRequest createRequest()
        {
            return new AddItemToShoppingCartRequest(ecasApiContext, ebayItemId, variationId, storeLocationId, requestedQuantity);
        }

        public AddToShoppingCartTask(EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, Long long1, String s, String s1, int i, 
                String s2, String s3, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.ADD_TO_CART, ecasapicontext, ebayshoppingapi, s2, TextUtils.concat(new CharSequence[] {
                Long.toString(long1.longValue()), "-", s
            }).toString(), observer, s3);
            ebayItemId = long1;
            variationId = s;
            storeLocationId = s1;
            requestedQuantity = i;
        }
    }

    public final class CreateCheckoutSessionTask extends ShoppingCartDataManagerBase.ShoppingCartTask
    {

        private final EcasApiContext apiContext;
        private final Long cartId;
        Map clientAttributes;
        private final List shoppingCartLineItemIds;
        final EcasShoppingCartDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            avoid = new ResultStatusOwner();
            EcasApiResponse ecasapiresponse = (EcasApiResponse)safeSendRequest(new CreateCheckoutSessionRequest(apiContext, cartId, shoppingCartLineItemIds, clientAttributes), avoid);
            if (ecasapiresponse != null)
            {
                if (ecasapiresponse.hasSuccessResponseCode() && ecasapiresponse.casResponse != null)
                {
                    avoid = EcasCheckoutSessionAdapter.toContentModel((EcasCheckoutResponse)ecasapiresponse.casResponse);
                    invalidateCache();
                    return avoid;
                } else
                {
                    return new Content(ecasapiresponse.getResultStatus());
                }
            } else
            {
                return new Content(avoid.getResultStatus());
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            outstandingTasks.remove(this);
            if (!content.getStatus().hasError() && content.getData() != null)
            {
                cancelOutstandingTasks();
                if (caller != null)
                {
                    caller.onCheckoutSessionComplete(EcasShoppingCartDataManager.this, content);
                    return;
                } else
                {
                    ((ShoppingCartDataManagerBase.Observer)).onCheckoutSessionComplete(EcasShoppingCartDataManager.this, content);
                    return;
                }
            }
            if (caller != null)
            {
                caller.onCheckoutSessionComplete(EcasShoppingCartDataManager.this, new Content(content.getStatus()));
                return;
            } else
            {
                ((ShoppingCartDataManagerBase.Observer)).onCheckoutSessionComplete(EcasShoppingCartDataManager.this, new Content(content.getStatus()));
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public CreateCheckoutSessionTask(EcasApiContext ecasapicontext, Long long1, List list, ShoppingCartDataManagerBase.Observer observer, Map map)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(EcasShoppingCartDataManager.this, ShoppingCartDataManagerBase.Action.CREATE_CHECKOUT_SESSION, null, null, null, observer);
            cartId = long1;
            shoppingCartLineItemIds = list;
            apiContext = ecasapicontext;
            clientAttributes = map;
        }
    }

    public abstract class EcasShoppingCartTask extends ShoppingCartDataManagerBase.ShoppingCartTask
    {

        protected final EcasApiContext ecasApiContext;
        protected final EbayShoppingApi shoppingApiContext;
        final EcasShoppingCartDataManager this$0;

        protected abstract EcasApiRequest createRequest();

        protected transient Content doInBackground(Void avoid[])
        {
            avoid = new ResultStatusOwner();
            EcasApiResponse ecasapiresponse = (EcasApiResponse)safeSendRequest(createRequest(), avoid);
            if (ecasapiresponse != null && !avoid.getResultStatus().hasError() && ecasapiresponse.casResponse != null)
            {
                return new Content(ecasapiresponse.casResponse, ecasapiresponse.getResultStatus());
            } else
            {
                return new Content(avoid.getResultStatus());
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            if ((!content.getStatus().hasError() || action.isCacheable) && content.getData() != null)
            {
                EcasShoppingCartResponse ecasshoppingcartresponse = (EcasShoppingCartResponse)content.getData();
                if (ecasshoppingcartresponse != null && ecasshoppingcartresponse.shoppingCart != null)
                {
                    content = ecasshoppingcartresponse.shoppingCart.getItemIds();
                } else
                {
                    content = Collections.emptyList();
                }
                content = new ArrayList(content);
                if (!content.isEmpty() && action.needsAdditionalData)
                {
                    outstandingTasks.add(DataManager.executeOnThreadPool(new GetMultipleItemsTask(shoppingApiContext, ecasshoppingcartresponse, siteId, itemId, userId, action, caller), content.toArray(new Long[0])));
                } else
                {
                    outstandingTasks.add(DataManager.executeOnThreadPool(new TranslateWireModelTask(ecasshoppingcartresponse, Collections.emptyList(), siteId, itemId, userId, action, caller), new Void[0]));
                }
                outstandingTasks.remove(this);
                return;
            }
            outstandingTasks.remove(this);
            if (caller != null)
            {
                caller.onShoppingCartChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
                return;
            } else
            {
                ((ShoppingCartDataManagerBase.Observer)EcasShoppingCartDataManager.this.doInBackground).onShoppingCartChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (caller != null)
            {
                caller.onShoppingCartLoading(EcasShoppingCartDataManager.this, action);
                return;
            } else
            {
                ((ShoppingCartDataManagerBase.Observer)EcasShoppingCartDataManager.this.doInBackground).onShoppingCartLoading(EcasShoppingCartDataManager.this, action);
                return;
            }
        }

        protected EcasShoppingCartTask(ShoppingCartDataManagerBase.Action action, EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, String s, String s1, ShoppingCartDataManagerBase.Observer observer, 
                String s2)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(EcasShoppingCartDataManager.this, action, s, s1, s2, observer);
            ecasApiContext = ecasapicontext;
            shoppingApiContext = ebayshoppingapi;
        }
    }

    public final class GetMultipleItemsTask extends ShoppingCartDataManagerBase.ShoppingCartTask
    {

        private final EcasShoppingCartResponse ecasShoppingCart;
        private final EbayShoppingApi shoppingApiContext;
        final EcasShoppingCartDataManager this$0;

        protected transient Content doInBackground(Long along[])
        {
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            LinkedList linkedlist = new LinkedList();
            double d = along.length;
            double d1 = Math.ceil(d / 20D);
            for (int i = 0; (double)i < d1;)
            {
                Long along1[];
                GetMultipleItemsResponse getmultipleitemsresponse;
                int j;
                if ((double)(i + 1) == d1)
                {
                    j = Double.valueOf(d).intValue();
                } else
                {
                    j = (i + 1) * 20;
                }
                along1 = (Long[])Arrays.copyOfRange(along, i * 20, j);
                getmultipleitemsresponse = (GetMultipleItemsResponse)safeSendRequest(new GetMultipleItemsRequest(shoppingApiContext, Arrays.asList(along1), "Details"), resultstatusowner);
                if (getmultipleitemsresponse != null && getmultipleitemsresponse.items != null)
                {
                    linkedlist.addAll(getmultipleitemsresponse.items);
                    i++;
                } else
                {
                    return new Content(resultstatusowner.getResultStatus());
                }
            }

            return new Content(linkedlist, resultstatusowner.getResultStatus());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Long[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            if (content.getData() != null)
            {
                outstandingTasks.add(DataManager.executeOnThreadPool(new TranslateWireModelTask(ecasShoppingCart, (List)content.getData(), siteId, itemId, userId, action, caller), new Void[0]));
                outstandingTasks.remove(this);
                return;
            }
            outstandingTasks.remove(this);
            if (caller != null)
            {
                caller.onShoppingCartChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
                return;
            } else
            {
                ((ShoppingCartDataManagerBase.Observer)EcasShoppingCartDataManager.this.<init>).onShoppingCartChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetMultipleItemsTask(EbayShoppingApi ebayshoppingapi, EcasShoppingCartResponse ecasshoppingcartresponse, String s, String s1, String s2, ShoppingCartDataManagerBase.Action action, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(EcasShoppingCartDataManager.this, action, s, s1, s2, observer);
            shoppingApiContext = ebayshoppingapi;
            ecasShoppingCart = ecasshoppingcartresponse;
        }
    }

    public class GetShoppingCartByUserIdTask extends EcasShoppingCartTask
    {

        final EcasShoppingCartDataManager this$0;

        protected EcasApiRequest createRequest()
        {
            if (action.hasValidation)
            {
                return new GetAndValidateShoppingCartByUserIdRequest(ecasApiContext);
            } else
            {
                return new GetShoppingCartByUserIdRequest(ecasApiContext);
            }
        }

        public GetShoppingCartByUserIdTask(EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, String s, String s1, boolean flag, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            ShoppingCartDataManagerBase.Action action;
            if (flag)
            {
                action = ShoppingCartDataManagerBase.Action.GET_AND_VALIDATE_CART;
            } else
            {
                action = ShoppingCartDataManagerBase.Action.GET_CART;
            }
            super(action, ecasapicontext, ebayshoppingapi, s, null, observer, s1);
        }
    }

    public final class MoveToSaveForLaterTask extends EcasShoppingCartTask
    {

        private final long shoppingCartItemId;
        final EcasShoppingCartDataManager this$0;

        protected EcasApiRequest createRequest()
        {
            return new MoveItemFromCartToSaveForLaterRequest(ecasApiContext, shoppingCartItemId);
        }

        public MoveToSaveForLaterTask(EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, long l, String s, String s1, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.MOVE_TO_SAVE_FOR_LATER, ecasapicontext, ebayshoppingapi, s, Long.toString(l), observer, s1);
            shoppingCartItemId = l;
        }
    }

    public final class MoveToShoppingCartTask extends EcasShoppingCartTask
    {

        private final long shoppingCartItemId;
        final EcasShoppingCartDataManager this$0;

        protected EcasApiRequest createRequest()
        {
            return new MoveItemFromSaveForLaterToCartRequest(ecasApiContext, Long.valueOf(shoppingCartItemId));
        }

        public MoveToShoppingCartTask(EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, long l, String s, String s1, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.MOVE_TO_CART, ecasapicontext, ebayshoppingapi, s, Long.toString(l), observer, s1);
            shoppingCartItemId = l;
        }
    }

    public final class RemoveFromSaveForLaterTask extends EcasShoppingCartTask
    {

        private final long shoppingCartLineId;
        final EcasShoppingCartDataManager this$0;

        protected EcasApiRequest createRequest()
        {
            return new RemoveItemFromSaveForLaterRequest(ecasApiContext, shoppingCartLineId);
        }

        public RemoveFromSaveForLaterTask(EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, long l, String s, String s1, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.REMOVE_FROM_SAVE_FOR_LATER, ecasapicontext, ebayshoppingapi, s, Long.toString(l), observer, s1);
            shoppingCartLineId = l;
        }
    }

    public final class RemoveFromShoppingCartTask extends EcasShoppingCartTask
    {

        private final long shoppingCartLineId;
        final EcasShoppingCartDataManager this$0;

        protected EcasApiRequest createRequest()
        {
            return new RemoveItemFromShoppingCartRequest(ecasApiContext, shoppingCartLineId);
        }

        public RemoveFromShoppingCartTask(EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, long l, String s, String s1, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.REMOVE_FROM_CART, ecasapicontext, ebayshoppingapi, s, Long.toString(l), observer, s1);
            shoppingCartLineId = l;
        }
    }

    public final class SetItemQuantityTask extends EcasShoppingCartTask
    {

        private final int requestedQuantity;
        private final long shoppingCartItemId;
        final EcasShoppingCartDataManager this$0;

        protected EcasApiRequest createRequest()
        {
            return new UpdateShoppingCartRequest(ecasApiContext, Long.valueOf(shoppingCartItemId), Integer.valueOf(requestedQuantity));
        }

        public SetItemQuantityTask(long l, int i, String s, String s1, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.SET_ITEM_QUANTITY, getCasApiContext(), getShoppingApiContext(), s, Long.toString(l), observer, s1);
            shoppingCartItemId = l;
            requestedQuantity = i;
        }
    }

    public final class TranslateWireModelTask extends ShoppingCartDataManagerBase.ShoppingCartTask
    {

        private final List ebayItems;
        private final EcasShoppingCartResponse ecasShoppingCart;
        final EcasShoppingCartDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            avoid = (new EcasShoppingCartMapper(ecasShoppingCart, EcasShoppingCartDataManager.listToMap(ebayItems), action, itemId)).toContentModel();
            ShoppingCartDataManagerBase.cacheManager.clear();
            if (action.isCacheable && avoid != null && avoid.getData() != null)
            {
                ShoppingCartDataManagerBase.cacheManager.put(ShoppingCartDataManagerBase.getCacheKey(siteId, userId, action.hasValidation), avoid.getData());
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Content content)
        {
label0:
            {
label1:
                {
                    super.onPostExecute(content);
                    outstandingTasks.remove(this);
                    if (content != null)
                    {
                        if (content.getData() == null || content.getStatus().hasError() && !action.isCacheable)
                        {
                            break label0;
                        }
                        ShoppingCartDataManagerBase.setBuyableItemCount(((ShoppingCart)content.getData()).summary.totalBuyableItems);
                        if (caller == null)
                        {
                            break label1;
                        }
                        caller.onShoppingCartChanged(EcasShoppingCartDataManager.this, action, content);
                    }
                    return;
                }
                ((ShoppingCartDataManagerBase.Observer)).onShoppingCartChanged(EcasShoppingCartDataManager.this, action, content);
                return;
            }
            if (caller != null)
            {
                caller.onShoppingCartChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
                return;
            } else
            {
                ((ShoppingCartDataManagerBase.Observer)).onShoppingCartChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public TranslateWireModelTask(EcasShoppingCartResponse ecasshoppingcartresponse, List list, String s, String s1, String s2, ShoppingCartDataManagerBase.Action action, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = EcasShoppingCartDataManager.this;
            super(EcasShoppingCartDataManager.this, action, s, s1, s2, observer);
            ecasShoppingCart = ecasshoppingcartresponse;
            ebayItems = list;
        }
    }


    private static final int GET_MULTIPLE_ITEMS_BATCH_SIZE = 20;
    private static final String GET_MULTIPLE_ITEMS_SELECTOR = "Details";
    public static final ShoppingCartDataManagerBase.KeyParams KEY;

    protected EcasShoppingCartDataManager(EbayContext ebaycontext, ShoppingCartDataManagerBase.KeyParams keyparams)
    {
        super(ebaycontext, keyparams);
    }

    private EcasApiContext getCasApiContext()
    {
        return new EcasApiContext(site, iafToken, config.isBopisEnabled());
    }

    private EbayShoppingApi getShoppingApiContext()
    {
        return new EbayShoppingApi(site);
    }

    private static Map listToMap(List list)
    {
        HashMap hashmap = new HashMap(list.size());
        EbayItem ebayitem;
        for (list = list.iterator(); list.hasNext(); hashmap.put(Long.valueOf(ebayitem.id), ebayitem))
        {
            ebayitem = (EbayItem)list.next();
        }

        return hashmap;
    }

    public void addItemToCart(Long long1, String s, String s1, int i, ShoppingCartDataManagerBase.Observer observer)
    {
        NautilusKernel.verifyMain();
        observer = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            outstandingTasks.add(executeOnThreadPool(new AddToShoppingCartTask(getCasApiContext(), getShoppingApiContext(), long1, s, s1, i, site.idString, userId, observer), new Void[0]));
            return;
        }
    }

    protected boolean canRequestCart()
    {
        return config.isShoppingCartEnabled() && site != null && !TextUtils.isEmpty(iafToken);
    }

    public void createCheckoutSession(Long long1, List list, ShoppingCartDataManagerBase.Observer observer, String s)
    {
        NautilusKernel.verifyMain();
        observer = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("paymentRiskCorrelationId", s);
            outstandingTasks.add(executeOnThreadPool(new CreateCheckoutSessionTask(getCasApiContext(), long1, list, observer, hashmap), new Void[0]));
            return;
        }
    }

    public void getCartAsync(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (canRequestCart()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (outstandingTasks.isEmpty())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (!flag) goto _L1; else goto _L3
_L3:
        Iterator iterator = outstandingTasks.iterator();
        AsyncTask asynctask;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_77;
            }
            asynctask = (AsyncTask)iterator.next();
        } while (!(asynctask instanceof ShoppingCartDataManagerBase.ShoppingCartTask) || !((ShoppingCartDataManagerBase.ShoppingCartTask)asynctask).action.hasValidation);
        return;
        outstandingTasks.add(executeOnThreadPool(new GetShoppingCartByUserIdTask(getCasApiContext(), getShoppingApiContext(), site.idString, userId, flag, null), new Void[0]));
        return;
    }

    public void moveToCart(long l, ShoppingCartDataManagerBase.Observer observer)
    {
        NautilusKernel.verifyMain();
        observer = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            outstandingTasks.add(executeOnThreadPool(new MoveToShoppingCartTask(getCasApiContext(), getShoppingApiContext(), l, site.idString, userId, observer), new Void[0]));
            return;
        }
    }

    public void removeItemFromCart(long l, ShoppingCartDataManagerBase.Observer observer)
    {
        NautilusKernel.verifyMain();
        observer = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            outstandingTasks.add(executeOnThreadPool(new RemoveFromShoppingCartTask(getCasApiContext(), getShoppingApiContext(), l, site.idString, userId, observer), new Void[0]));
            return;
        }
    }

    public void removeItemFromSaveForLater(long l, ShoppingCartDataManagerBase.Observer observer)
    {
        NautilusKernel.verifyMain();
        observer = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            outstandingTasks.add(executeOnThreadPool(new RemoveFromSaveForLaterTask(getCasApiContext(), getShoppingApiContext(), l, site.idString, userId, observer), new Void[0]));
            return;
        }
    }

    public void saveForLater(long l, ShoppingCartDataManagerBase.Observer observer)
    {
        NautilusKernel.verifyMain();
        observer = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            outstandingTasks.add(executeOnThreadPool(new MoveToSaveForLaterTask(getCasApiContext(), getShoppingApiContext(), l, site.idString, userId, observer), new Void[0]));
            return;
        }
    }

    public void setItemQuantity(Long long1, int i, ShoppingCartDataManagerBase.Observer observer)
    {
        NautilusKernel.verifyMain();
        observer = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            outstandingTasks.add(executeOnThreadPool(new SetItemQuantityTask(long1.longValue(), i, site.idString, userId, observer), new Void[0]));
            return;
        }
    }

    static 
    {
        KEY = new ShoppingCartDataManagerBase.KeyParams(ShoppingCartDataManagerBase.ServiceApi.ECAS);
    }













}
