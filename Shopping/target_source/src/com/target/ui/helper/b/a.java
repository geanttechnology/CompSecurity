// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.b;

import com.google.a.a.e;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.b.k;
import com.target.mothership.model.cart.b.l;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.UpdatedFulfillment;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.cart.interfaces.a.i;
import com.target.mothership.model.cart.interfaces.a.u;
import com.target.mothership.model.cart.interfaces.a.w;
import com.target.mothership.model.cart.interfaces.a.y;
import com.target.mothership.model.cart.interfaces.a.z;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.c;
import com.target.ui.service.b;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.List;

public class com.target.ui.helper.b.a extends com.target.ui.helper.a
{
    public static interface a
        extends b, com.target.ui.helper.c
    {

        public abstract void a(AppliedTenders appliedtenders);

        public abstract void a(ExpressOrderReview expressorderreview);

        public abstract void a(FreeShippingPromotion freeshippingpromotion);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.a a1);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.f f1);

        public abstract void a(i i1);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.j j1);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.o o);

        public abstract void a(u u);

        public abstract void a(w w);

        public abstract void a(y y);

        public abstract void a(z z);

        public abstract void a(ProductRecommendations productrecommendations);

        public abstract void a(x x);

        public abstract void b(CartDetails cartdetails);

        public abstract void b(Guest guest);

        public abstract void b(x x);

        public abstract void c(CartDetails cartdetails);

        public abstract void d(CartDetails cartdetails);

        public abstract void e(CartDetails cartdetails);

        public abstract void h();

        public abstract void i();

        public abstract void j();
    }

    public static interface b
    {

        public abstract void k();
    }

    public static interface c
    {

        public abstract void a(ProductRecommendations productrecommendations);

        public abstract void a(x x);
    }


    private static final String LOG_TAG = com/target/ui/helper/b/a.getSimpleName();
    private static int PRIMARY_REASON_INDEX = 0;
    private com.target.ui.service.a mAccountService;
    private com.target.ui.service.b mCartDataService;
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.b.a()
    {
        mCartDataService = com.target.ui.service.b.a();
        mAccountService = com.target.ui.service.a.a();
    }

    static String a(com.target.ui.helper.b.a a1)
    {
        return a1.mRequestTag;
    }

    private void a(final Guest guest, final CartProduct cartProduct, final boolean isApplyShippingModePending, final UsableShipMode usableShipMode, final a listener)
    {
        mCartDataService.a(guest, cartProduct, null, new d() {

            final com.target.ui.helper.b.a this$0;
            final CartProduct val$cartProduct;
            final Guest val$guest;
            final boolean val$isApplyShippingModePending;
            final a val$listener;
            final UsableShipMode val$usableShipMode;

            public String a()
            {
                return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
            }

            public void a(UpdatedFulfillment updatedfulfillment)
            {
                if (isApplyShippingModePending)
                {
                    updatedfulfillment = (Guest)com.target.ui.service.a.a().c().a(guest);
                    com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this, updatedfulfillment, cartProduct, usableShipMode, listener);
                    return;
                } else
                {
                    listener.j();
                    return;
                }
            }

            public void a(w w1)
            {
                if (com.target.ui.helper.b.a.i(com.target.ui.helper.b.a.this, 0, listener, (j)w1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                {
                    return;
                } else
                {
                    listener.a(w1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((UpdatedFulfillment)obj);
            }

            public void b(Object obj)
            {
                a((w)obj);
            }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                isApplyShippingModePending = flag;
                guest = guest1;
                cartProduct = cartproduct;
                usableShipMode = usableshipmode;
                listener = a2;
                super();
            }
        });
    }

    static void a(com.target.ui.helper.b.a a1, Guest guest, CartProduct cartproduct, UsableShipMode usableshipmode, a a2)
    {
        a1.b(guest, cartproduct, usableshipmode, a2);
    }

    static boolean a(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static int b()
    {
        return PRIMARY_REASON_INDEX;
    }

    static com.target.ui.service.b b(com.target.ui.helper.b.a a1)
    {
        return a1.mCartDataService;
    }

    private void b(final Guest guest, CartProduct cartproduct, UsableShipMode usableshipmode, final a listener)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new k(cartproduct, usableshipmode));
        cartproduct = new l(arraylist);
        mCartDataService.a(guest, cartproduct, new d() {

            final com.target.ui.helper.b.a this$0;
            final Guest val$guest;
            final a val$listener;

            public String a()
            {
                return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.a a1)
            {
                if (com.target.ui.helper.b.a.f(com.target.ui.helper.b.a.this, 0, listener, (j)a1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                {
                    return;
                } else
                {
                    listener.a(a1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                listener.h();
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
        });
    }

    static boolean b(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static String c()
    {
        return LOG_TAG;
    }

    static boolean c(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean d(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean e(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean f(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean g(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean h(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean i(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean j(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    static boolean k(com.target.ui.helper.b.a a1, int i1, com.target.ui.helper.c c1, j j1, Guest guest, o o)
    {
        return a1.a(i1, c1, j1, guest, o);
    }

    public void a()
    {
        mAccountService.a(mRequestTag);
        mCartDataService.a(mRequestTag);
    }

    public void a(CartDetails cartdetails, final c productRecommendationsListener, b b1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            b1.k();
            return;
        } else
        {
            mCartDataService.a(cartdetails, new h() {

                final com.target.ui.helper.b.a this$0;
                final c val$productRecommendationsListener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(ProductRecommendations productrecommendations)
                {
                    productRecommendationsListener.a(productrecommendations);
                }

                public void a(x x1)
                {
                    productRecommendationsListener.a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((ProductRecommendations)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                productRecommendationsListener = c1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, CartProduct cartproduct, int i1, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.a(guest, cartproduct, i1, new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(CartDetails cartdetails)
                {
                    listener.c(cartdetails);
                }

                public void a(y y1)
                {
                    if (com.target.ui.helper.b.a.b(com.target.ui.helper.b.a.this, 0, listener, (j)y1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(y1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((CartDetails)obj);
                }

                public void b(Object obj)
                {
                    a((y)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(Guest guest, CartProduct cartproduct, UsableShipMode usableshipmode, a a1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            a1.k();
            return;
        }
        boolean flag;
        if (cartproduct.d() == f.ShipToHome || cartproduct.d() == f.Special)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b(guest, cartproduct, usableshipmode, a1);
            return;
        } else
        {
            a(guest, cartproduct, true, usableshipmode, a1);
            return;
        }
    }

    public void a(final Guest guest, CartProduct cartproduct, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.a(guest, cartproduct, new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(CartDetails cartdetails)
                {
                    listener.d(cartdetails);
                }

                public void a(u u1)
                {
                    if (com.target.ui.helper.b.a.c(com.target.ui.helper.b.a.this, 0, listener, (j)u1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(u1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((CartDetails)obj);
                }

                public void b(Object obj)
                {
                    a((u)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, CartProduct cartproduct, com.target.ui.model.a a1, f f1, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.a(guest, cartproduct, a1.a().getStoreId(), f1, new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(UpdatedFulfillment updatedfulfillment)
                {
                    listener.j();
                }

                public void a(w w1)
                {
                    if (com.target.ui.helper.b.a.h(com.target.ui.helper.b.a.this, 0, listener, (j)w1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(w1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((UpdatedFulfillment)obj);
                }

                public void b(Object obj)
                {
                    a((w)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, GiftProduct giftproduct, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.a(guest, giftproduct, new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.f f1)
                {
                    if (com.target.ui.helper.b.a.g(com.target.ui.helper.b.a.this, 0, listener, (j)f1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(f1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.i();
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.f)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, InitiatedCheckout initiatedcheckout, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.e(guest, initiatedcheckout, new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(AppliedTenders appliedtenders)
                {
                    listener.a(appliedtenders);
                }

                public void a(i i1)
                {
                    if (com.target.ui.helper.b.a.k(com.target.ui.helper.b.a.this, 0, listener, (j)i1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(i1);
                        return;
                    }
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
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(Guest guest, final o requestRetryable, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mAccountService.a(guest, new h() {

                final com.target.ui.helper.b.a this$0;
                final a val$listener;
                final o val$requestRetryable;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(Guest guest1)
                {
                    requestRetryable.a(guest1);
                    requestRetryable.a();
                }

                public void a(x x1)
                {
                    listener.b(x1);
                    if (x1 != null)
                    {
                        x1 = x1.getMessage();
                    } else
                    {
                        x1 = "";
                    }
                    q.a(com.target.ui.helper.b.a.c(), (new StringBuilder()).append("Unable to refresh a new anonymous guest session:").append(x1).toString());
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
                this$0 = com.target.ui.helper.b.a.this;
                requestRetryable = o1;
                listener = a2;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.a(guest, new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(CartDetails cartdetails)
                {
                    listener.b(cartdetails);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.j j1)
                {
                    if (com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this, 1, listener, (j)j1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(j1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((CartDetails)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.j)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.a(new h() {

                final com.target.ui.helper.b.a this$0;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(ProductRecommendations productrecommendations)
                {
                    listener.a(productrecommendations);
                }

                public void a(x x1)
                {
                    listener.a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((ProductRecommendations)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                super();
            }
            });
            return;
        }
    }

    public void b(final Guest guest, CartProduct cartproduct, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.b(guest, cartproduct, new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(z z1)
                {
                    if (com.target.ui.helper.b.a.e(com.target.ui.helper.b.a.this, 0, listener, (j)z1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(z1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    com.target.ui.helper.b.a.b(com.target.ui.helper.b.a.this).a(guest, new d() {

                        final _cls10 this$1;

                        public String a()
                        {
                            return com.target.ui.helper.b.a.a(_fld0);
                        }

                        public void a(CartDetails cartdetails)
                        {
                            listener.e(cartdetails);
                        }

                        public void a(com.target.mothership.model.cart.interfaces.a.j j1)
                        {
                            if (com.target.ui.helper.b.a.d(_fld0, 0, listener, (j)j1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                            {
                                return;
                            } else
                            {
                                listener.a(j1);
                                return;
                            }
                        }

                        public volatile void a(Object obj)
                        {
                            a((CartDetails)obj);
                        }

                        public void b(Object obj)
                        {
                            a((com.target.mothership.model.cart.interfaces.a.j)obj);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                }

                public void b(Object obj)
                {
                    a((z)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                guest = guest1;
                listener = a2;
                super();
            }
            });
            return;
        }
    }

    public void b(final Guest guest, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            listener = new d() {

                final com.target.ui.helper.b.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(ExpressOrderReview expressorderreview)
                {
                    listener.a(expressorderreview);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.o o1)
                {
                    if (com.target.ui.helper.b.a.j(com.target.ui.helper.b.a.this, 0, listener, (j)o1.f().get(com.target.ui.helper.b.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(o1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((ExpressOrderReview)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.o)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                guest = guest1;
                super();
            }
            };
            mCartDataService.c(guest, listener);
            return;
        }
    }

    public void b(final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mCartDataService.b(new h() {

                final com.target.ui.helper.b.a this$0;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(FreeShippingPromotion freeshippingpromotion)
                {
                    listener.a(freeshippingpromotion);
                }

                public void a(x x1)
                {
                    q.a(com.target.ui.helper.b.a.c(), "Unable to fetch the Free Shipping threshold value");
                }

                public volatile void a(Object obj)
                {
                    a((FreeShippingPromotion)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                super();
            }
            });
            return;
        }
    }

    public void c(Guest guest, CartProduct cartproduct, a a1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            a1.k();
            return;
        } else
        {
            a(guest, cartproduct, false, ((UsableShipMode) (null)), a1);
            return;
        }
    }

    public void c(final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mAccountService.a(new h() {

                final com.target.ui.helper.b.a this$0;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.a.a(com.target.ui.helper.b.a.this);
                }

                public void a(Guest guest)
                {
                    listener.b(guest);
                }

                public void a(x x1)
                {
                    listener.b(x1);
                    if (x1 != null)
                    {
                        x1 = x1.getMessage();
                    } else
                    {
                        x1 = "";
                    }
                    q.a(com.target.ui.helper.b.a.c(), (new StringBuilder()).append("Unable to refresh the anonymous guest session:").append(x1).toString());
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
                this$0 = com.target.ui.helper.b.a.this;
                listener = a2;
                super();
            }
            });
            return;
        }
    }

}
