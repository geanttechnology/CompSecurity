// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.ProductBrand;
import com.cyberlink.beautycircle.model.ProductFeature;
import com.cyberlink.beautycircle.model.ProductPrice;
import com.cyberlink.beautycircle.model.ProductType;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, d

public class r
{

    public static j a()
    {
        return NetworkManager.a(NetworkManager.b).a(new j() {

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.listTypes == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    return new u(networkmanager.e.product.listTypes);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/ProductType, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(int i, int k, long l, long l1, long l2, 
            int i1, int j1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(i, k, l, l1, l2) {

            final int a;
            final int b;
            final long c;
            final long d;
            final long e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.listProducts == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    networkmanager = null;
                } else
                {
                    u u1 = new u(networkmanager.e.product.listProducts);
                    u1.a("offset", Integer.valueOf(a));
                    u1.a("limit", Integer.valueOf(b));
                    if (c > 0L)
                    {
                        u1.a("brandId", Long.valueOf(c));
                    }
                    if (d > 0L)
                    {
                        u1.a("typeId", Long.valueOf(d));
                    }
                    networkmanager = u1;
                    if (e > 0L)
                    {
                        u1.a("priceRangeId", Long.valueOf(e));
                        return u1;
                    }
                }
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = i;
                b = k;
                c = l;
                d = l1;
                e = l2;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/Product, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(int i, int k, long l, Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(i, k, l, long1) {

            final int a;
            final int b;
            final long c;
            final Long d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.listComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.product.listComment);
                    networkmanager.a("offset", Integer.valueOf(a));
                    networkmanager.a("limit", Integer.valueOf(b));
                    networkmanager.a("productId", Long.valueOf(c));
                    networkmanager.a("userId", d);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = i;
                b = k;
                c = l;
                d = long1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected com.cyberlink.beautycircle.model.ProductComment.ProductCommentResult a(String s)
            {
                return (com.cyberlink.beautycircle.model.ProductComment.ProductCommentResult)Model.a(com/cyberlink/beautycircle/model/ProductComment$ProductCommentResult, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(int i, int k, String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(i, k, s) {

            final int a;
            final int b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.listProdByText == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.product.listProdByText);
                    networkmanager.a("offset", Integer.valueOf(a));
                    networkmanager.a("limit", Integer.valueOf(b));
                    networkmanager.a("keyword", c);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = i;
                b = k;
                c = s;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                return new d(com/cyberlink/beautycircle/model/Product, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(long l, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, i, k) {

            final long a;
            final int b;
            final int c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.listProductFeatureByUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.product.listProductFeatureByUser);
                    networkmanager.a("userId", Long.valueOf(a));
                    networkmanager.a("offset", Integer.valueOf(b));
                    networkmanager.a("limit", Integer.valueOf(c));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = l;
                b = i;
                c = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/ProductFeature, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(long l, Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, long1) {

            final long a;
            final Long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.queryProdInfo == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.product.queryProdInfo);
                    networkmanager.a("productId", Long.valueOf(a));
                    networkmanager.a("userId", b);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = l;
                b = long1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/Product, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, long l)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l) {

            final String a;
            final long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.deleteComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.product.deleteComment);
                    networkmanager.a("token", a);
                    networkmanager.a("commentId", Long.valueOf(b));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = l;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j a(String s, long l, String s1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l, s1) {

            final String a;
            final long b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.reportProdComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.product.reportProdComment);
                    networkmanager.a("token", a);
                    networkmanager.a("commentId", Long.valueOf(b));
                    networkmanager.a("reason", c);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = l;
                c = s1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s2)
            {
                return null;
            }

        });
    }

    public static j a(String s, long l, String s1, float f)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l, s1, f) {

            final String a;
            final long b;
            final String c;
            final float d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.createComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.product.createComment);
                networkmanager.a("token", a);
                networkmanager.a("productId", Long.valueOf(b));
                if (c != null && !c.trim().isEmpty())
                {
                    networkmanager.a("comment", c);
                }
                networkmanager.a("rating", Float.valueOf(d));
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = l;
                c = s1;
                d = f;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s2)
            {
                return null;
            }

        });
    }

    public static j b()
    {
        return NetworkManager.a(NetworkManager.b).a(new j() {

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.listBrands == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    return new u(networkmanager.e.product.listBrands);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/ProductBrand, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j b(String s, long l, String s1, float f)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l, s1, f) {

            final String a;
            final long b;
            final String c;
            final float d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.updateComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.product.updateComment);
                    networkmanager.a("token", a);
                    networkmanager.a("productId", Long.valueOf(b));
                    networkmanager.a("comment", c);
                    networkmanager.a("rating", Float.valueOf(d));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = l;
                c = s1;
                d = f;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s2)
            {
                return null;
            }

        });
    }

    public static j c()
    {
        return NetworkManager.a(NetworkManager.b).a(new j() {

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.product.listPriceRangAndName == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    return new u(networkmanager.e.product.listPriceRangAndName);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/ProductPrice, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }
}
