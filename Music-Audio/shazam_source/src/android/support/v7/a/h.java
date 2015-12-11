// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.e.a;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v7.a:
//            k, j, l, g, 
//            a

public abstract class h
{

    h()
    {
    }

    static h a(Context context, Window window, g g1)
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        if (i1 >= 14)
        {
            return new k(context, window, g1);
        }
        if (i1 >= 11)
        {
            return new j(context, window, g1);
        } else
        {
            return new l(context, window, g1);
        }
    }

    public abstract android.support.v7.a.a a();

    public abstract a a(android.support.v7.e.a.a a1);

    public abstract void a(int i1);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(Toolbar toolbar);

    public abstract void a(View view);

    public abstract void a(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void a(CharSequence charsequence);

    public abstract MenuInflater b();

    public abstract void b(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract boolean b(int i1);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract c.a h();

    public abstract void i();
}
