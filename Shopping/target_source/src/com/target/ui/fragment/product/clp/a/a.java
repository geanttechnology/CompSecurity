// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.clp.a;

import android.graphics.Bitmap;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.target.mothership.common.a.g;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.c.d.d;
import com.target.ui.helper.product.b;
import java.net.URL;
import java.util.List;

public interface a
{

    public abstract void a(int k);

    public abstract void a(int k, int l, URL url);

    public abstract void a(int k, int l, boolean flag);

    public abstract void a(Bitmap bitmap, String s, String s1);

    public abstract void a(Parcelable parcelable);

    public abstract void a(Menu menu, MenuInflater menuinflater, int k);

    public abstract void a(MenuItem menuitem, boolean flag);

    public abstract void a(ProductDetails productdetails);

    public abstract void a(ProductDetails productdetails, Store store);

    public abstract void a(ProductDetails productdetails, b b1, Store store, g g1);

    public abstract void a(ProductPromotion productpromotion);

    public abstract void a(d d1);

    public abstract void a(com.target.ui.common.d d1, boolean flag);

    public abstract void a(String s);

    public abstract void a(List list, boolean flag);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();
}
