// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp.a;

import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.target.mothership.common.a.g;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.c.d.d;
import com.target.ui.common.ProductHeaderOptions;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.helper.product.b;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.view.ToolbarSpinner;
import java.util.List;

public interface a
{

    public abstract void a();

    public abstract void a(float f1);

    public abstract void a(int k);

    public abstract void a(int k, int l);

    public abstract void a(int k, int l, boolean flag, boolean flag1);

    public abstract void a(int k, List list);

    public abstract void a(Uri uri, Store store);

    public abstract void a(Menu menu, MenuInflater menuinflater, int k);

    public abstract void a(MenuItem menuitem, boolean flag);

    public abstract void a(PageItem pageitem, List list, PageItemHierarchy pageitemhierarchy, Store store);

    public abstract void a(ProductDetails productdetails, Store store);

    public abstract void a(ProductDetails productdetails, PageItemHierarchy pageitemhierarchy);

    public abstract void a(ProductDetails productdetails, b b1, Store store, g g1);

    public abstract void a(ProductSummary productsummary, long l);

    public abstract void a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, long l);

    public abstract void a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, PageItemHierarchy pageitemhierarchy, long l);

    public abstract void a(com.target.ui.analytics.a.ah.a a1);

    public abstract void a(d d1);

    public abstract void a(ProductHeaderOptions productheaderoptions);

    public abstract void a(ProductRefineModel productrefinemodel, ProductSummaryParam productsummaryparam);

    public abstract void a(ToolbarSpinner toolbarspinner, List list, PageItemHierarchy pageitemhierarchy);

    public abstract void a(String s);

    public abstract void a(String s, Store store);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(float f1);

    public abstract void b(int k, int l);

    public abstract void b(ProductHeaderOptions productheaderoptions);

    public abstract void b(String s);

    public abstract void b(List list);

    public abstract void c();

    public abstract void c(float f1);

    public abstract void c(List list);

    public abstract void c(boolean flag);

    public abstract void d();

    public abstract void d(boolean flag);

    public abstract void e();

    public abstract void e(boolean flag);

    public abstract void f();

    public abstract void f(boolean flag);

    public abstract void g();

    public abstract void g(boolean flag);

    public abstract void h();

    public abstract void h(boolean flag);

    public abstract void i();

    public abstract void j();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();
}
