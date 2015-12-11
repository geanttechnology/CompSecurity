// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list.a;

import android.view.Menu;
import android.view.View;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.model.list.ListDetailItem;
import java.util.List;

public interface a
{

    public abstract void a(int i1, String s, String s1);

    public abstract void a(Menu menu, boolean flag);

    public abstract void a(Tcin tcin, Store store);

    public abstract void a(ListItem listitem);

    public abstract void a(ListItem listitem, int i1);

    public abstract void a(ListItem listitem, ListSummary listsummary);

    public abstract void a(Store store, ListSummary listsummary, List list, ListDetailItem listdetailitem);

    public abstract void a(Store store, ListSummary listsummary, List list, ListDetailItem listdetailitem, View view);

    public abstract void a(List list);

    public abstract void a(List list, List list1);

    public abstract void a(boolean flag, boolean flag1);

    public abstract void b(int i1);

    public abstract void b(Menu menu, boolean flag);

    public abstract void b(ListCollectionItem listcollectionitem);

    public abstract void b(ListDetailCompletedItem listdetailcompleteditem);

    public abstract void b(List list);

    public abstract void c(int i1);

    public abstract void c(String s);

    public abstract void c(boolean flag);

    public abstract void d(ListDetailItem listdetailitem, int i1);

    public abstract void d(String s);

    public abstract void d(boolean flag);

    public abstract void e();

    public abstract void e(ListDetailItem listdetailitem);

    public abstract void e(ListDetailItem listdetailitem, int i1);

    public abstract void e(String s);

    public abstract void e(boolean flag);

    public abstract void f();

    public abstract void f(ListDetailItem listdetailitem);

    public abstract void f(ListDetailItem listdetailitem, int i1);

    public abstract void f(String s);

    public abstract void g();

    public abstract void g(ListDetailItem listdetailitem);

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();
}
