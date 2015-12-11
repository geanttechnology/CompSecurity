// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.b;

import com.google.a.a.e;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.b.k;
import com.target.mothership.model.cart.b.l;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.CartProductShippingModeDetails;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.RewardOptions;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.cart.interfaces.UsableShippingModeDetails;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.service.a;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
    public static interface a
    {

        public abstract void l();
    }


    public static final String TAG = com/target/ui/helper/b/b.getSimpleName();
    private final com.target.ui.service.b mCartDataService = com.target.ui.service.b.a();
    private CartDetails mCartDetails;
    private a mListener;
    private final String mRequestTag = String.valueOf(hashCode());
    private Map mRewardOptionsMap;
    private Map mRushDeliveryProductMap;

    public b()
    {
    }

    private UsableShipMode a(CartProductShippingModeDetails cartproductshippingmodedetails)
    {
        cartproductshippingmodedetails = cartproductshippingmodedetails.a().iterator();
        UsableShipMode usableshipmode;
label0:
        do
        {
            if (cartproductshippingmodedetails.hasNext())
            {
                Object obj = (UsableShippingModeDetails)cartproductshippingmodedetails.next();
                if (((UsableShippingModeDetails) (obj)).a() != f.ShipToHome)
                {
                    continue;
                }
                obj = ((UsableShippingModeDetails) (obj)).b().iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue label0;
                    }
                    usableshipmode = (UsableShipMode)((Iterator) (obj)).next();
                } while (!com.target.mothership.common.a.b.Standard.equals(usableshipmode.a()));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return usableshipmode;
    }

    static UsableShipMode a(b b1, CartProductShippingModeDetails cartproductshippingmodedetails)
    {
        return b1.a(cartproductshippingmodedetails);
    }

    static String a(b b1)
    {
        return b1.mRequestTag;
    }

    private void a(CartProduct cartproduct)
    {
        b(cartproduct);
        if (mRushDeliveryProductMap.isEmpty())
        {
            c();
        }
    }

    private void a(GiftProduct giftproduct)
    {
        b(giftproduct);
        if (mRewardOptionsMap.isEmpty())
        {
            c();
        }
    }

    private void a(final Guest guest, final CartProduct product)
    {
        d d1 = new d() {

            final b this$0;
            final Guest val$guest;
            final CartProduct val$product;
            final d val$updateShipMethodReceiver;

            public void a(CartProductShippingModeDetails cartproductshippingmodedetails)
            {
                cartproductshippingmodedetails = com.target.ui.helper.b.b.a(b.this, cartproductshippingmodedetails);
                if (cartproductshippingmodedetails == null)
                {
                    com.target.ui.helper.b.b.a(b.this, product);
                    return;
                } else
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(new k(product, cartproductshippingmodedetails));
                    cartproductshippingmodedetails = new l(arraylist);
                    b.b(b.this).a(guest, cartproductshippingmodedetails, updateShipMethodReceiver);
                    return;
                }
            }

            public void a(com.target.mothership.model.cart.interfaces.a.k k1)
            {
                com.target.ui.helper.b.b.a(b.this, product);
            }

            public volatile void a(Object obj)
            {
                a((CartProductShippingModeDetails)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.k)obj);
            }

            
            {
                this$0 = b.this;
                product = cartproduct;
                guest = guest1;
                updateShipMethodReceiver = d1;
                super();
            }
        };
        mCartDataService.c(guest, product, d1);
    }

    private void a(Guest guest, final GiftProduct product)
    {
        mCartDataService.a(guest, product, new d() {

            final b this$0;
            final GiftProduct val$product;

            public String a()
            {
                return com.target.ui.helper.b.b.a(b.this);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.f f1)
            {
                com.target.ui.helper.b.b.a(b.this, product);
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.b.b.a(b.this, product);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.f)obj);
            }

            
            {
                this$0 = b.this;
                product = giftproduct;
                super();
            }
        });
    }

    static void a(b b1, CartProduct cartproduct)
    {
        b1.a(cartproduct);
    }

    static void a(b b1, GiftProduct giftproduct)
    {
        b1.a(giftproduct);
    }

    private Guest b()
    {
        return (Guest)com.target.ui.service.a.a().c().d();
    }

    static com.target.ui.service.b b(b b1)
    {
        return b1.mCartDataService;
    }

    private void b(CartProduct cartproduct)
    {
        if (!mRushDeliveryProductMap.isEmpty())
        {
            mRushDeliveryProductMap.remove(cartproduct.a());
        }
    }

    private void b(GiftProduct giftproduct)
    {
        if (!mRewardOptionsMap.isEmpty())
        {
            mRewardOptionsMap.remove(giftproduct.m_());
        }
    }

    private void c()
    {
        if (mRewardOptionsMap.isEmpty() && mRushDeliveryProductMap.isEmpty())
        {
            mListener.l();
        } else
        {
            if (!mRewardOptionsMap.isEmpty())
            {
                f();
                return;
            }
            if (!mRushDeliveryProductMap.isEmpty())
            {
                g();
                return;
            }
        }
    }

    private void d()
    {
        Iterator iterator;
        mRewardOptionsMap = new ConcurrentHashMap();
        iterator = mCartDetails.a().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (CartProduct)iterator.next();
        if (((CartProduct) (obj)).x().isEmpty()) goto _L4; else goto _L3
_L3:
        Iterator iterator1 = ((CartProduct) (obj)).x().iterator();
_L7:
        if (!iterator1.hasNext()) goto _L4; else goto _L5
_L5:
        obj = (RewardOptions)iterator1.next();
        if (((RewardOptions) (obj)).a() == null || ((RewardOptions) (obj)).a().size() == 0) goto _L7; else goto _L6
_L6:
        Iterator iterator2;
        List list = ((RewardOptions) (obj)).a();
        obj = null;
        iterator2 = list.iterator();
_L10:
        GiftProduct giftproduct;
        if (!iterator2.hasNext())
        {
            break MISSING_BLOCK_LABEL_216;
        }
        giftproduct = (GiftProduct)iterator2.next();
        if (!giftproduct.l_()) goto _L9; else goto _L8
_L8:
        boolean flag = true;
_L11:
        if (!flag && obj != null)
        {
            mRewardOptionsMap.put(((GiftProduct) (obj)).m_(), obj);
        }
          goto _L7
_L9:
        if (giftproduct.c() == com.target.mothership.common.a.b.Email)
        {
            obj = giftproduct;
        }
          goto _L10
_L2:
        return;
        flag = false;
          goto _L11
    }

    private void e()
    {
        mRushDeliveryProductMap = new ConcurrentHashMap();
        Iterator iterator = mCartDetails.a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CartProduct cartproduct = (CartProduct)iterator.next();
            if (cartproduct.c() == com.target.mothership.common.a.b.Rush)
            {
                mRushDeliveryProductMap.put(cartproduct.a(), cartproduct);
            }
        } while (true);
    }

    private void f()
    {
        Guest guest = b();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null");
        } else
        {
            Iterator iterator = mRewardOptionsMap.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                a(guest, (GiftProduct)((java.util.Map.Entry)iterator.next()).getValue());
            }
        }
    }

    private void g()
    {
        Guest guest = b();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null");
        } else
        {
            Iterator iterator = mRushDeliveryProductMap.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                a(guest, (CartProduct)((java.util.Map.Entry)iterator.next()).getValue());
            }
        }
    }

    public void a()
    {
        mCartDataService.a(mRequestTag);
    }

    public void a(CartDetails cartdetails, a a1)
    {
        mCartDetails = cartdetails;
        mListener = a1;
        d();
        e();
        c();
    }


    // Unreferenced inner class com/target/ui/helper/b/b$2

/* anonymous class */
    class _cls2 extends d
    {

        final b this$0;
        final CartProduct val$product;

        public String a()
        {
            return com.target.ui.helper.b.b.a(b.this);
        }

        public void a(com.target.mothership.model.cart.interfaces.a.a a1)
        {
            com.target.ui.helper.b.b.a(b.this, product);
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            com.target.ui.helper.b.b.a(b.this, product);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.cart.interfaces.a.a)obj);
        }

            
            {
                this$0 = b.this;
                product = cartproduct;
                super();
            }
    }

}
