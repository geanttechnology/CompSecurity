// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment.b;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.g.a;
import java.lang.annotation.Annotation;

public abstract class e
    implements com.target.ui.g.a
{
    public static interface a
        extends Annotation
    {
    }


    public static final int MODE_ADD = 1;
    public static final int MODE_EDIT = 2;

    public e()
    {
    }

    public abstract void a(Guest guest);

    public abstract void a(String s);

    public abstract void a(boolean flag);

    public abstract void b(Object obj);

    public abstract void b(String s);

    public abstract void c(String s);

    public abstract boolean c();

    public abstract void d();

    public abstract void d(String s);

    public abstract void e();

    public abstract void e(String s);

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();
}
