// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.a;

import android.text.Spanned;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import java.util.List;

public interface a
{

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(int i, String s);

    public abstract void a(Spanned spanned);

    public abstract void a(Tcin tcin, Dpci dpci, Upc upc);

    public abstract void a(String s);

    public abstract void a(List list);

    public abstract void b();

    public abstract void b(List list);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();
}
