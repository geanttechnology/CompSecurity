// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.pointinside.maps.Location;
import com.pointinside.products.BaseProduct;
import com.pointinside.products.LookupResult;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.h;
import com.target.mothership.model.product.c;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.mothership.util.b;
import com.target.ui.analytics.a.n;
import com.target.ui.util.q;
import com.target.ui.util.w;
import java.util.Iterator;
import java.util.List;

public class g
{
    public static interface a
    {

        public abstract void t_();
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(Location location);
    }

    public static interface c
        extends a
    {

        public abstract void a(ProductDetailsWrapper productdetailswrapper);

        public abstract void a(x x);
    }

    public static interface d
    {

        public abstract void a(ProductRecommendations productrecommendations);

        public abstract void d(x x);

        public abstract void o();
    }

    public static interface e
        extends a
    {

        public abstract void a(ProductSummaryWrapper productsummarywrapper);

        public abstract void a(x x);
    }


    private static final String TAG = com/target/ui/helper/product/g.getSimpleName();
    private final boolean GET_STORE_INFO_WITHOUT_TIME_OUT = true;
    private boolean mIsProductSummaryRequested;
    private final com.target.mothership.model.product.c mProductManager = new com.target.mothership.model.product.c();
    private final String mRequestTag = String.valueOf(hashCode());

    public g()
    {
        mIsProductSummaryRequested = false;
    }

    static String a(g g1)
    {
        return g1.mRequestTag;
    }

    private void a(o o1)
    {
        o1.a(true);
        o1.a();
    }

    static void a(g g1, o o1)
    {
        g1.a(o1);
    }

    private boolean a(ProductDetailsWrapper productdetailswrapper)
    {
        while (productdetailswrapper == null || !productdetailswrapper.a().equals(z.PARTIAL_CONTENT)) 
        {
            return false;
        }
        return true;
    }

    static boolean a(g g1, ProductDetailsWrapper productdetailswrapper)
    {
        return g1.a(productdetailswrapper);
    }

    static boolean a(g g1, boolean flag)
    {
        g1.mIsProductSummaryRequested = flag;
        return flag;
    }

    static String c()
    {
        return TAG;
    }

    public void a()
    {
        q.c(TAG, "ProductDataHelper : Cancel Requested");
        mIsProductSummaryRequested = false;
        mProductManager.a(mRequestTag);
    }

    public void a(ProductRecommendationsParam productrecommendationsparam, final d listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o();
            return;
        } else
        {
            mProductManager.a(productrecommendationsparam, new h() {

                final g this$0;
                final d val$listener;

                public String a()
                {
                    return g.a(g.this);
                }

                public void a(ProductRecommendations productrecommendations)
                {
                    listener.a(productrecommendations);
                }

                public void a(x x1)
                {
                    String s;
                    if (x1 == null)
                    {
                        s = "";
                    } else
                    {
                        s = x1.getMessage();
                    }
                    q.a(com.target.ui.helper.product.g.c(), (new StringBuilder()).append("Error getting product recommendations: ").append(s).toString());
                    listener.d(x1);
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
                this$0 = g.this;
                listener = d1;
                super();
            }
            });
            return;
        }
    }

    public void a(ProductSummaryParam productsummaryparam, final e listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.t_();
            return;
        } else
        {
            mIsProductSummaryRequested = true;
            mProductManager.b(productsummaryparam, new h() {

                final g this$0;
                final e val$listener;

                public String a()
                {
                    return g.a(g.this);
                }

                public void a(ProductSummaryWrapper productsummarywrapper)
                {
                    g.a(g.this, false);
                    listener.a(productsummarywrapper);
                }

                public void a(x x1)
                {
                    String s;
                    if (x1 == null)
                    {
                        s = "";
                    } else
                    {
                        s = x1.getMessage();
                    }
                    q.a(com.target.ui.helper.product.g.c(), (new StringBuilder()).append("Error getting product summary: ").append(s).toString());
                    g.a(g.this, false);
                    listener.a(x1);
                    n.a(x1).e();
                }

                public volatile void a(Object obj)
                {
                    a((ProductSummaryWrapper)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = g.this;
                listener = e1;
                super();
            }
            });
            return;
        }
    }

    public void a(ProductIdentifier productidentifier, Store store, final c listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.t_();
            return;
        } else
        {
            mProductManager.a(store, productidentifier, true, new h() {

                final g this$0;
                final c val$listener;

                public String a()
                {
                    return g.a(g.this);
                }

                public void a(ProductDetailsWrapper productdetailswrapper)
                {
                    if (c().b() && g.a(g.this, productdetailswrapper))
                    {
                        g.a(g.this, (o)c().c());
                        return;
                    } else
                    {
                        listener.a(productdetailswrapper);
                        return;
                    }
                }

                public void a(x x1)
                {
                    String s;
                    if (x1 == null)
                    {
                        s = "";
                    } else
                    {
                        s = x1.getMessage();
                    }
                    q.a(com.target.ui.helper.product.g.c(), (new StringBuilder()).append("Error getting product details: ").append(s).toString());
                    listener.a(x1);
                    n.a(x1).e();
                }

                public volatile void a(Object obj)
                {
                    a((ProductDetailsWrapper)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = g.this;
                listener = c1;
                super();
            }
            });
            return;
        }
    }

    public void a(Product product, Store store, final c listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.t_();
            return;
        } else
        {
            mProductManager.a(store, product, true, new h() {

                final g this$0;
                final c val$listener;

                public String a()
                {
                    return g.a(g.this);
                }

                public void a(ProductDetailsWrapper productdetailswrapper)
                {
                    if (c().b() && g.a(g.this, productdetailswrapper))
                    {
                        g.a(g.this, (o)c().c());
                        return;
                    } else
                    {
                        listener.a(productdetailswrapper);
                        return;
                    }
                }

                public void a(x x1)
                {
                    String s;
                    if (x1 == null)
                    {
                        s = "";
                    } else
                    {
                        s = x1.getMessage();
                    }
                    q.a(com.target.ui.helper.product.g.c(), (new StringBuilder()).append("Error getting product details: ").append(s).toString());
                    listener.a(x1);
                    n.a(x1).e();
                }

                public volatile void a(Object obj)
                {
                    a((ProductDetailsWrapper)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = g.this;
                listener = c1;
                super();
            }
            });
            return;
        }
    }

    public void a(String s, Store store, final b listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.a();
        } else
        if (store == null)
        {
            if (listener != null)
            {
                listener.a();
                return;
            }
        } else
        {
            w.a(s, store, new com.target.ui.util.w.b() {

                final g this$0;
                final b val$listener;

                public void a(Exception exception)
                {
                    if (exception == null)
                    {
                        exception = "";
                    } else
                    {
                        exception = exception.getMessage();
                    }
                    q.a(com.target.ui.helper.product.g.c(), (new StringBuilder()).append("Error getting PI location: ").append(exception).toString());
                    listener.a();
                }

                public void a(List list)
                {
                    if (listener != null) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    Iterator iterator;
                    if (list == null || list.isEmpty())
                    {
                        listener.a();
                        return;
                    }
                    iterator = list.iterator();
_L3:
                    if (!iterator.hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    list = (LookupResult)iterator.next();
                    list = com.target.ui.util.f.a.b(((LookupResult) (list)).product.locations);
label0:
                    {
                        if (list == null)
                        {
                            break label0;
                        }
                        try
                        {
                            listener.a(list);
                        }
                        // Misplaced declaration of an exception variable
                        catch (List list)
                        {
                            if (list == null)
                            {
                                list = "";
                            } else
                            {
                                list = list.getMessage();
                            }
                            q.a(com.target.ui.helper.product.g.c(), (new StringBuilder()).append("Error getting PI location: ").append(list).toString());
                            listener.a();
                        }
                    }
                      goto _L3
                    listener.a();
                      goto _L3
                    if (true) goto _L1; else goto _L4
_L4:
                }

            
            {
                this$0 = g.this;
                listener = b1;
                super();
            }
            }).a();
            return;
        }
    }

    public void a(List list, Store store, final e listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.t_();
            return;
        } else
        {
            mIsProductSummaryRequested = true;
            mProductManager.a(store, list, false, new h() {

                final g this$0;
                final e val$listener;

                public String a()
                {
                    return g.a(g.this);
                }

                public void a(ProductSummaryWrapper productsummarywrapper)
                {
                    g.a(g.this, false);
                    listener.a(productsummarywrapper);
                }

                public void a(x x1)
                {
                    String s;
                    if (x1 == null)
                    {
                        s = "";
                    } else
                    {
                        s = x1.getMessage();
                    }
                    q.a(com.target.ui.helper.product.g.c(), (new StringBuilder()).append("Error getting product summary: ").append(s).toString());
                    g.a(g.this, false);
                    listener.a(x1);
                    n.a(x1).e();
                }

                public volatile void a(Object obj)
                {
                    a((ProductSummaryWrapper)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = g.this;
                listener = e1;
                super();
            }
            });
            return;
        }
    }

    public boolean b()
    {
        return mIsProductSummaryRequested;
    }

}
