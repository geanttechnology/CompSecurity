// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.google.a.a.e;
import com.target.mothership.common.a.g;
import com.target.mothership.common.a.j;
import com.target.mothership.common.registries.c;
import com.target.mothership.model.cart.interfaces.AddToCart;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.a.i;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.service.b;
import com.target.ui.util.q;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.helper.product:
//            b

public class com.target.ui.helper.product.a
{
    private class a extends com.target.mothership.model.d
    {

        private final Guest mGuest;
        private final boolean mIsAgeRestrictionAccepted;
        private final com.target.ui.helper.product.b mItemType;
        private b mListener;
        private final g mPickUpItemType;
        private final ProductDetails mProduct;
        private final Store mStoreToPickUp;
        final com.target.ui.helper.product.a this$0;

        static com.target.ui.helper.product.b a(a a1)
        {
            return a1.mItemType;
        }

        static ProductDetails b(a a1)
        {
            return a1.mProduct;
        }

        static b c(a a1)
        {
            return a1.mListener;
        }

        public String a()
        {
            return com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this);
        }

        public void a(ExpressOrderReview expressorderreview)
        {
            com.target.mothership.model.d d1 = expressorderreview. new com.target.mothership.model.d() {

                final a this$1;
                final ExpressOrderReview val$expressOrderReview;

                public void a(AppliedTenders appliedtenders)
                {
                    com.target.ui.helper.product.a.c(a.this).a(a.a(a.this), com.target.ui.helper.product.a.b(a.this), expressOrderReview, appliedtenders);
                }

                public void a(i k)
                {
                    com.target.ui.helper.product.a.c(a.this).a(a.a(a.this), com.target.ui.helper.product.a.b(a.this), expressOrderReview, null);
                }

                public volatile void a(Object obj)
                {
                    a((AppliedTenders)obj);
                }

                public void b(Object obj)
                {
                    a((i)obj);
                }

            
            {
                this$1 = final_a1;
                expressOrderReview = ExpressOrderReview.this;
                super();
            }
            };
            com.target.ui.helper.product.a.b(com.target.ui.helper.product.a.this).e(mGuest, expressorderreview, d1);
        }

        public void a(com.target.mothership.model.cart.interfaces.a.b b1)
        {
            for (Iterator iterator = b1.f().iterator(); iterator.hasNext();)
            {
                com.target.mothership.model.cart.interfaces.a.b.a a1 = (com.target.mothership.model.cart.interfaces.a.b.a)iterator.next();
                q.a(com.target.ui.helper.product.a.b(), (new StringBuilder()).append("Error adding to cart : ").append(a1).toString());
                if (com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this, a1))
                {
                    com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this, mGuest, (o)c().d(), mProduct, mItemType, mIsAgeRestrictionAccepted, mListener, mStoreToPickUp, mPickUpItemType);
                    return;
                }
            }

            mListener.a(mItemType, b1, mStoreToPickUp);
        }

        public volatile void a(Object obj)
        {
            a((ExpressOrderReview)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.cart.interfaces.a.b)obj);
        }

        a(Guest guest, ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
                g g)
        {
            this$0 = com.target.ui.helper.product.a.this;
            super();
            mGuest = guest;
            mProduct = productdetails;
            mItemType = b1;
            mStoreToPickUp = store;
            mPickUpItemType = g;
            mIsAgeRestrictionAccepted = flag;
            mListener = b2;
        }
    }

    public static interface b
    {

        public abstract void a(com.target.ui.helper.product.b b1, com.target.mothership.model.cart.interfaces.a.b b2, Store store);

        public abstract void a(com.target.ui.helper.product.b b1, Guest guest, o o);

        public abstract void a(com.target.ui.helper.product.b b1, ProductDetails productdetails, ExpressOrderReview expressorderreview, AppliedTenders appliedtenders);

        public abstract void a(com.target.ui.helper.product.b b1, Store store);
    }

    private class c extends com.target.mothership.model.d
    {

        private final Guest mGuest;
        private final boolean mIsAgeRestrictionAccepted;
        private final com.target.ui.helper.product.b mItemType;
        private b mListener;
        private final g mPickUpItemType;
        private final ProductDetails mProduct;
        private final Store mStoreToPickUp;
        final com.target.ui.helper.product.a this$0;

        public String a()
        {
            return com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this);
        }

        public void a(AddToCart addtocart)
        {
            mListener.a(mItemType, mStoreToPickUp);
        }

        public void a(com.target.mothership.model.cart.interfaces.a.b b1)
        {
            for (Iterator iterator = b1.f().iterator(); iterator.hasNext();)
            {
                com.target.mothership.model.cart.interfaces.a.b.a a1 = (com.target.mothership.model.cart.interfaces.a.b.a)iterator.next();
                q.a(com.target.ui.helper.product.a.b(), (new StringBuilder()).append("Error adding to cart : ").append(a1).toString());
                if (com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this, a1))
                {
                    com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this, mGuest, (o)c().d(), mProduct, mItemType, mIsAgeRestrictionAccepted, mListener, mStoreToPickUp, mPickUpItemType);
                    return;
                }
            }

            mListener.a(mItemType, b1, mStoreToPickUp);
        }

        public volatile void a(Object obj)
        {
            a((AddToCart)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.cart.interfaces.a.b)obj);
        }

        c(Guest guest, ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
                g g)
        {
            this$0 = com.target.ui.helper.product.a.this;
            super();
            mGuest = guest;
            mProduct = productdetails;
            mItemType = b1;
            mPickUpItemType = g;
            mStoreToPickUp = store;
            mIsAgeRestrictionAccepted = flag;
            mListener = b2;
        }
    }

    private class d extends h
    {

        private final boolean mIsAgeRestrictionAccepted;
        private final com.target.ui.helper.product.b mItemType;
        private final b mListener;
        private final g mPickUpItemType;
        private final ProductDetails mProductDetails;
        private final RegistryDetails mRegistryDetails;
        private final Store mStore;
        final com.target.ui.helper.product.a this$0;

        public String a()
        {
            return com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this);
        }

        public void a(Guest guest)
        {
            if (mRegistryDetails != null)
            {
                com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this, guest, mProductDetails, mRegistryDetails, mItemType, mIsAgeRestrictionAccepted, mListener, mStore, mPickUpItemType);
                return;
            } else
            {
                com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this, guest, mProductDetails, mItemType, mIsAgeRestrictionAccepted, mListener, mStore, mPickUpItemType);
                return;
            }
        }

        public void a(x x1)
        {
            mListener.a(mItemType, null, mStore);
            if (x1 == null)
            {
                x1 = "";
            } else
            {
                x1 = x1.getMessage();
            }
            q.a(com.target.ui.helper.product.a.b(), (new StringBuilder()).append("Unable to get the guest session :").append(x1).toString());
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        d(ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
                g g)
        {
            this$0 = com.target.ui.helper.product.a.this;
            super();
            mProductDetails = productdetails;
            mItemType = b1;
            mPickUpItemType = g;
            mStore = store;
            mIsAgeRestrictionAccepted = flag;
            mListener = b2;
            mRegistryDetails = registrydetails;
        }

        d(ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, g g)
        {
            this$0 = com.target.ui.helper.product.a.this;
            super();
            mProductDetails = productdetails;
            mItemType = b1;
            mPickUpItemType = g;
            mStore = store;
            mIsAgeRestrictionAccepted = flag;
            mListener = b2;
            mRegistryDetails = null;
        }
    }


    private static final int ADD_TO_CART_DEFAULT_QUANTITY = 1;
    private static final String TAG = com/target/ui/helper/product/a.getSimpleName();
    private final com.target.ui.service.b mCartDataService = com.target.ui.service.b.a();
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.product.a()
    {
    }

    private j a(com.target.mothership.common.registries.c c1)
    {
        if (c1.equals(com.target.mothership.common.registries.c.TARGET_LIST))
        {
            return j.LIST;
        } else
        {
            return j.REGISTRY;
        }
    }

    private com.target.mothership.model.cart.b.a a(ProductDetails productdetails, RegistryDetails registrydetails, boolean flag, Store store, g g)
    {
        return new com.target.mothership.model.cart.b.a(productdetails, 1, store, g, a(registrydetails.g()), registrydetails.b(), flag);
    }

    private com.target.mothership.model.cart.b.a a(ProductDetails productdetails, boolean flag, Store store, g g)
    {
        if (store != null)
        {
            return new com.target.mothership.model.cart.b.a(productdetails, 1, store, g, flag);
        } else
        {
            return new com.target.mothership.model.cart.b.a(productdetails, 1, flag);
        }
    }

    static String a(com.target.ui.helper.product.a a1)
    {
        return a1.mRequestTag;
    }

    private void a(Guest guest, ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
            g g)
    {
        b1 = new a(guest, productdetails, b1, flag, b2, store, g);
        mCartDataService.b(guest, a(productdetails, registrydetails, flag, store, g), b1);
    }

    private void a(Guest guest, ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, g g)
    {
        Store store1 = null;
        if (b1.equals(com.target.ui.helper.product.b.PICK_UP))
        {
            store1 = store;
        }
        if (b1.equals(com.target.ui.helper.product.b.EXPRESS_CHECKOUT))
        {
            b(guest, productdetails, b1, flag, b2, store1, g);
            return;
        } else
        {
            b1 = new c(guest, productdetails, b1, flag, b2, store1, g);
            mCartDataService.a(guest, a(productdetails, flag, store1, g), b1);
            return;
        }
    }

    private void a(Guest guest, o o, ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
            g g)
    {
        if (!guest.isAnonymous())
        {
            b2.a(b1, guest, o);
            return;
        } else
        {
            c(guest, productdetails, b1, flag, b2, store, g);
            return;
        }
    }

    static void a(com.target.ui.helper.product.a a1, Guest guest, ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
            g g)
    {
        a1.b(guest, productdetails, registrydetails, b1, flag, b2, store, g);
    }

    static void a(com.target.ui.helper.product.a a1, Guest guest, ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, g g)
    {
        a1.a(guest, productdetails, b1, flag, b2, store, g);
    }

    static void a(com.target.ui.helper.product.a a1, Guest guest, o o, ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
            g g)
    {
        a1.a(guest, o, productdetails, b1, flag, b2, store, g);
    }

    private boolean a(com.target.mothership.model.cart.interfaces.a.b.a a1)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason = new int[com.target.mothership.model.cart.interfaces.a.b.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_TOKEN_EXPIRED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_ACCOUNT_IN_USE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_REAUTH_REQUIRED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.mothership.model.cart.interfaces.error.AddToCartFailure.AddToCartFailureReason[a1.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return true;
        }
    }

    static boolean a(com.target.ui.helper.product.a a1, com.target.mothership.model.cart.interfaces.a.b.a a2)
    {
        return a1.a(a2);
    }

    static com.target.ui.service.b b(com.target.ui.helper.product.a a1)
    {
        return a1.mCartDataService;
    }

    static String b()
    {
        return TAG;
    }

    private void b(Guest guest, ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, 
            g g)
    {
        Store store1 = null;
        if (b1.equals(com.target.ui.helper.product.b.PICK_UP))
        {
            store1 = store;
        }
        if (b1.equals(com.target.ui.helper.product.b.EXPRESS_CHECKOUT))
        {
            a(guest, productdetails, registrydetails, b1, flag, b2, store1, g);
            return;
        } else
        {
            b1 = new c(guest, productdetails, b1, flag, b2, store1, g);
            mCartDataService.a(guest, a(productdetails, registrydetails, flag, store1, g), b1);
            return;
        }
    }

    private void b(Guest guest, ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, g g)
    {
        b1 = new a(guest, productdetails, b1, flag, b2, store, g);
        mCartDataService.b(guest, a(productdetails, flag, store, g), b1);
    }

    private void c(Guest guest, final ProductDetails product, final com.target.ui.helper.product.b itemType, final boolean isAgeRestrictionAccepted, final b listener, final Store storeToPickUp, final g type)
    {
        com.target.ui.service.a.a().a(guest, new h() {

            final com.target.ui.helper.product.a this$0;
            final boolean val$isAgeRestrictionAccepted;
            final com.target.ui.helper.product.b val$itemType;
            final b val$listener;
            final ProductDetails val$product;
            final Store val$storeToPickUp;
            final g val$type;

            public String a()
            {
                return com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this);
            }

            public void a(Guest guest1)
            {
                com.target.ui.helper.product.a.a(com.target.ui.helper.product.a.this, guest1, product, itemType, isAgeRestrictionAccepted, listener, storeToPickUp, type);
            }

            public void a(x x1)
            {
                listener.a(itemType, null, storeToPickUp);
                if (x1 == null)
                {
                    x1 = "";
                } else
                {
                    x1 = x1.getMessage();
                }
                q.a(com.target.ui.helper.product.a.b(), (new StringBuilder()).append("Unable to refresh the guest session :").append(x1).toString());
            }

            public volatile void a(Object obj)
            {
                a((Guest)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.product.a.this;
                product = productdetails;
                itemType = b1;
                isAgeRestrictionAccepted = flag;
                listener = b2;
                storeToPickUp = store;
                type = g;
                super();
            }
        });
    }

    public void a()
    {
        q.c(TAG, "AddToCartDataHelper : Cancel Requested");
        mCartDataService.a(mRequestTag);
    }

    public void a(ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, g g)
    {
        productdetails = new d(productdetails, registrydetails, b1, flag, b2, store, g);
        com.target.ui.service.a.a().a(productdetails);
    }

    public void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, boolean flag, b b2, Store store, g g)
    {
        productdetails = new d(productdetails, b1, flag, b2, store, g);
        com.target.ui.service.a.a().a(productdetails);
    }

}
