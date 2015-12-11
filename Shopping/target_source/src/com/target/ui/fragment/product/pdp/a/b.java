// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.target.mothership.common.a.g;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.c.d.d;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.common.a;
import com.target.ui.common.e;
import com.target.ui.common.f;
import com.target.ui.common.h;
import com.target.ui.model.product.ProductVariationModel;
import java.net.URL;
import java.util.Date;
import java.util.List;

public interface b
{

    public abstract void A();

    public abstract void B();

    public abstract void a(int k, int l, URL url);

    public abstract void a(int k, int l, boolean flag);

    public abstract void a(int k, Bundle bundle);

    public abstract void a(Bitmap bitmap, String s1, String s2);

    public abstract void a(Uri uri, Store store);

    public abstract void a(Menu menu, MenuInflater menuinflater, int k);

    public abstract void a(MenuItem menuitem, boolean flag);

    public abstract void a(DvmDataResponse dvmdataresponse, boolean flag);

    public abstract void a(ProductDetails productdetails);

    public abstract void a(ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel);

    public abstract void a(ProductDetails productdetails, Store store);

    public abstract void a(ProductDetails productdetails, com.target.ui.analytics.a.al.a a1);

    public abstract void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel);

    public abstract void a(ProductDetails productdetails, ProductVariationModel productvariationmodel, Store store);

    public abstract void a(ProductDetails productdetails, boolean flag);

    public abstract void a(ProductGuestReview productguestreview, boolean flag);

    public abstract void a(ProductImage productimage, boolean flag);

    public abstract void a(ProductPromotion productpromotion);

    public abstract void a(ProductRecommendations productrecommendations, boolean flag);

    public abstract void a(d d1);

    public abstract void a(ProductFulfillmentOptions productfulfillmentoptions);

    public abstract void a(ProductFulfillmentOptions productfulfillmentoptions, boolean flag);

    public abstract void a(a a1, boolean flag);

    public abstract void a(com.target.ui.common.b b1, boolean flag);

    public abstract void a(e e1, boolean flag);

    public abstract void a(f f1, boolean flag);

    public abstract void a(com.target.ui.common.g g1, boolean flag);

    public abstract void a(h h1, boolean flag);

    public abstract void a(ProductVariationModel productvariationmodel, boolean flag);

    public abstract void a(String s1);

    public abstract void a(String s1, int k);

    public abstract void a(Date date, boolean flag);

    public abstract void a(List list, boolean flag);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(ProductDetails productdetails);

    public abstract void b(ProductDetails productdetails, Store store);

    public abstract void b(String s1);

    public abstract void c();

    public abstract void c(ProductDetails productdetails);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void u();

    public abstract void v();

    public abstract void w();

    public abstract void x();

    public abstract void y();

    public abstract void z();
}
