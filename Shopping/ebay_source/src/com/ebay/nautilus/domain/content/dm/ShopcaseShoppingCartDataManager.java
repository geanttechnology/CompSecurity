// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.domain.net.api.shopcase.AddToCartRequest;
import com.ebay.nautilus.domain.net.api.shopcase.CreateCheckoutSessionRequest;
import com.ebay.nautilus.domain.net.api.shopcase.GetShoppingCartRequest;
import com.ebay.nautilus.domain.net.api.shopcase.MoveFromSaveForLaterRequest;
import com.ebay.nautilus.domain.net.api.shopcase.MoveToSaveForLaterRequest;
import com.ebay.nautilus.domain.net.api.shopcase.RemoveLineItemRequest;
import com.ebay.nautilus.domain.net.api.shopcase.SetQuantityRequest;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseCartResponse;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseCheckoutSessionMapper;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseCheckoutSessionResponse;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseErrorHandler;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseShoppingCartMapper;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase

public final class ShopcaseShoppingCartDataManager extends ShoppingCartDataManagerBase
{
    public final class ShopcaseAddToCartTask extends ShopcaseShoppingCartTask
    {

        private final long ebayItemId;
        private final int requestedQuantity;
        final ShopcaseShoppingCartDataManager this$0;
        private final String variationId;

        protected EbayCosRequest createRequest()
        {
            return new AddToCartRequest(iafToken, site, ebayItemId, variationId, requestedQuantity);
        }

        public ShopcaseAddToCartTask(long l, String s, int i, String s1, String s2, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.ADD_TO_CART, s1, null, TextUtils.concat(new CharSequence[] {
                Long.toString(l), "-", s
            }).toString(), s2, observer);
            ebayItemId = l;
            variationId = s;
            requestedQuantity = i;
        }
    }

    public final class ShopcaseCreateCheckoutSessionTask extends ShoppingCartDataManagerBase.ShoppingCartTask
    {

        Map clientAttributes;
        private final Collection itemReferenceIds;
        final ShopcaseShoppingCartDataManager this$0;
        private final boolean useProx;

        protected transient Content doInBackground(Void avoid[])
        {
            try
            {
                avoid = new CreateCheckoutSessionRequest(iafToken, site, itemReferenceIds, useProx, clientAttributes);
                avoid = (ShopcaseCheckoutSessionResponse)sendRequest(avoid);
                if (avoid.hasSuccessResponseCode() && ((ShopcaseCheckoutSessionResponse) (avoid)).checkoutSession != null)
                {
                    invalidateCache();
                    return (new ShopcaseCheckoutSessionMapper(((ShopcaseCheckoutSessionResponse) (avoid)).checkoutSession)).toContentModel();
                }
                avoid = new Content(null, avoid.getResultStatus());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return new Content(ResultStatus.CANCELED);
            }
            return avoid;
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
                    caller.onCheckoutSessionComplete(ShopcaseShoppingCartDataManager.this, content);
                    return;
                } else
                {
                    ((ShoppingCartDataManagerBase.Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public ShopcaseCreateCheckoutSessionTask(Collection collection, String s, String s1, ShoppingCartDataManagerBase.Observer observer, Map map)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            super(ShopcaseShoppingCartDataManager.this, ShoppingCartDataManagerBase.Action.CREATE_CHECKOUT_SESSION, s, null, s1, observer);
            itemReferenceIds = collection;
            clientAttributes = map;
            useProx = DeviceConfiguration.getAsync().get(DcsNautilusBoolean.PROX);
        }
    }

    public final class ShopcaseGetShoppingCartTask extends ShopcaseShoppingCartTask
    {

        final ShopcaseShoppingCartDataManager this$0;

        protected EbayCosRequest createRequest()
        {
            return new GetShoppingCartRequest(iafToken, site, action.hasValidation);
        }

        public ShopcaseGetShoppingCartTask(String s, String s1, boolean flag, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            ShoppingCartDataManagerBase.Action action;
            if (flag)
            {
                action = ShoppingCartDataManagerBase.Action.GET_AND_VALIDATE_CART;
            } else
            {
                action = ShoppingCartDataManagerBase.Action.GET_CART;
            }
            super(action, s, null, null, s1, observer);
        }
    }

    public final class ShopcaseMoveToCartTask extends ShopcaseShoppingCartTask
    {

        final ShopcaseShoppingCartDataManager this$0;

        protected EbayCosRequest createRequest()
        {
            return new MoveFromSaveForLaterRequest(iafToken, site, itemReferenceId.longValue());
        }

        public ShopcaseMoveToCartTask(long l, String s, String s1, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.MOVE_TO_CART, s, Long.valueOf(l), Long.toString(l), s1, observer);
        }
    }

    public final class ShopcaseMoveToSaveForLaterTask extends ShopcaseShoppingCartTask
    {

        final ShopcaseShoppingCartDataManager this$0;

        protected EbayCosRequest createRequest()
        {
            return new MoveToSaveForLaterRequest(iafToken, site, itemReferenceId.longValue());
        }

        public ShopcaseMoveToSaveForLaterTask(long l, String s, String s1, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.MOVE_TO_SAVE_FOR_LATER, s, Long.valueOf(l), Long.toString(l), s1, observer);
        }
    }

    public final class ShopcaseRemoveLineItemTask extends ShopcaseShoppingCartTask
    {

        final ShopcaseShoppingCartDataManager this$0;

        protected EbayCosRequest createRequest()
        {
            return new RemoveLineItemRequest(iafToken, site, itemReferenceId.longValue());
        }

        public ShopcaseRemoveLineItemTask(boolean flag, long l, String s, String s1, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            ShoppingCartDataManagerBase.Action action;
            if (flag)
            {
                action = ShoppingCartDataManagerBase.Action.REMOVE_FROM_CART;
            } else
            {
                action = ShoppingCartDataManagerBase.Action.REMOVE_FROM_SAVE_FOR_LATER;
            }
            super(action, s, Long.valueOf(l), Long.toString(l), s1, observer);
        }
    }

    public final class ShopcaseSetItemQuantityTask extends ShopcaseShoppingCartTask
    {

        private final int requestedQuantity;
        final ShopcaseShoppingCartDataManager this$0;

        protected EbayCosRequest createRequest()
        {
            return new SetQuantityRequest(iafToken, site, itemReferenceId.longValue(), requestedQuantity);
        }

        public ShopcaseSetItemQuantityTask(long l, int i, String s, String s1, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            super(ShoppingCartDataManagerBase.Action.SET_ITEM_QUANTITY, s, Long.valueOf(l), Long.toString(l), s1, observer);
            requestedQuantity = i;
        }
    }

    public abstract class ShopcaseShoppingCartTask extends ShoppingCartDataManagerBase.ShoppingCartTask
    {

        protected final Long itemReferenceId;
        final ShopcaseShoppingCartDataManager this$0;

        protected abstract EbayCosRequest createRequest();

        protected transient Content doInBackground(Void avoid[])
        {
            try
            {
                avoid = (ShopcaseCartResponse)sendRequest(createRequest());
                avoid = new Content(((ShopcaseCartResponse) (avoid)).shopCart, avoid.getResultStatus());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return new Content(ResultStatus.CANCELED);
            }
            return avoid;
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
                outstandingTasks.add(DataManager.executeOnThreadPool(new ShopcaseTranslateModelTask((ShopCart)content.getData(), siteId, itemReferenceId, itemId, userId, action, caller), new Void[0]));
                outstandingTasks.remove(this);
                return;
            }
            outstandingTasks.remove(this);
            if (caller != null)
            {
                caller.onShoppingCartChanged(ShopcaseShoppingCartDataManager.this, action, new Content(content.getStatus()));
                return;
            } else
            {
                ((ShoppingCartDataManagerBase.Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        protected void onPreExecute()
        {
            onPreExecute();
            if (caller != null)
            {
                caller.onShoppingCartLoading(ShopcaseShoppingCartDataManager.this, action);
                return;
            } else
            {
                ((ShoppingCartDataManagerBase.Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected ShopcaseShoppingCartTask(ShoppingCartDataManagerBase.Action action, String s, Long long1, String s1, String s2, ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            super(ShopcaseShoppingCartDataManager.this, action, s, s1, s2, observer);
            itemReferenceId = long1;
        }
    }

    public final class ShopcaseTranslateModelTask extends ShoppingCartDataManagerBase.ShoppingCartTask
    {

        private final Long itemReferenceId;
        private final ShopCart shopCaseModel;
        final ShopcaseShoppingCartDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            avoid = (new ShopcaseShoppingCartMapper(shopCaseModel, new ShopcaseErrorHandler(action, itemId, itemReferenceId))).toContentModel();
            ShoppingCartDataManagerBase.cacheManager.clear();
            if (action.isCacheable && avoid.getData() != null)
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
            onPostExecute(content);
            outstandingTasks.remove(this);
            ResultStatus resultstatus = content.getStatus();
            if (content.getData() != null && (!resultstatus.hasError() || action.isCacheable))
            {
                ShoppingCartDataManagerBase.setBuyableItemCount(((ShoppingCart)content.getData()).summary.totalBuyableItems);
                if (caller != null)
                {
                    caller.onShoppingCartChanged(ShopcaseShoppingCartDataManager.this, action, content);
                    return;
                } else
                {
                    ((ShoppingCartDataManagerBase.Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public ShopcaseTranslateModelTask(ShopCart shopcart, String s, Long long1, String s1, String s2, ShoppingCartDataManagerBase.Action action, 
                ShoppingCartDataManagerBase.Observer observer)
        {
            this$0 = ShopcaseShoppingCartDataManager.this;
            super(ShopcaseShoppingCartDataManager.this, action, s, s1, s2, observer);
            shopCaseModel = shopcart;
            itemReferenceId = long1;
        }
    }


    public static final ShoppingCartDataManagerBase.KeyParams KEY;

    protected ShopcaseShoppingCartDataManager(EbayContext ebaycontext, ShoppingCartDataManagerBase.KeyParams keyparams)
    {
        ShoppingCartDataManagerBase(ebaycontext, keyparams);
    }

    public void addItemToCart(Long long1, String s, String s1, int i, ShoppingCartDataManagerBase.Observer observer)
    {
        NautilusKernel.verifyMain();
        s1 = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            outstandingTasks.add(executeOnThreadPool(new ShopcaseAddToCartTask(long1.longValue(), s, i, site.idString, userId, s1), new Void[0]));
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
        long1 = (ShoppingCartDataManagerBase.Observer)getSafeCallback(observer);
        if (!outstandingTasks.isEmpty() || !canRequestCart())
        {
            return;
        } else
        {
            observer = new HashMap();
            observer.put("paymentRiskCorrelationId", s);
            outstandingTasks.add(executeOnThreadPool(new ShopcaseCreateCheckoutSessionTask(list, site.idString, userId, long1, observer), new Void[0]));
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
        outstandingTasks.add(executeOnThreadPool(new ShopcaseGetShoppingCartTask(site.idString, userId, flag, null), new Void[0]));
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
            outstandingTasks.add(executeOnThreadPool(new ShopcaseMoveToCartTask(l, site.idString, userId, observer), new Void[0]));
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
            outstandingTasks.add(executeOnThreadPool(new ShopcaseRemoveLineItemTask(true, l, site.idString, userId, observer), new Void[0]));
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
            outstandingTasks.add(executeOnThreadPool(new ShopcaseRemoveLineItemTask(false, l, site.idString, userId, observer), new Void[0]));
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
            outstandingTasks.add(executeOnThreadPool(new ShopcaseMoveToSaveForLaterTask(l, site.idString, userId, observer), new Void[0]));
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
            outstandingTasks.add(executeOnThreadPool(new ShopcaseSetItemQuantityTask(long1.longValue(), i, site.idString, userId, observer), new Void[0]));
            return;
        }
    }

    static 
    {
        KEY = new KeyParams(ShoppingCartDataManagerBase.ServiceApi.SHOPCASE);
    }








}
