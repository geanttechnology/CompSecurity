// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.millennialmedia.android:
//            MMActivity

class ae
{

    MMActivity d;

    ae()
    {
    }

    public void a()
    {
        d.f();
    }

    public final void a(int i)
    {
        d.setRequestedOrientation(i);
    }

    public void a(Configuration configuration)
    {
        d.a(configuration);
    }

    protected void a(Bundle bundle)
    {
        d.a(bundle);
    }

    public final void a(View view)
    {
        d.setContentView(view);
    }

    public final void a(Runnable runnable)
    {
        d.runOnUiThread(runnable);
    }

    public boolean a(int i, KeyEvent keyevent)
    {
        return d.a(i, keyevent);
    }

    protected void b()
    {
        d.c();
    }

    public final void b(int i)
    {
        d.setTheme(i);
    }

    protected void b(Bundle bundle)
    {
        d.b(bundle);
    }

    public void b(boolean flag)
    {
        d.a(flag);
    }

    protected void c()
    {
        d.d();
    }

    protected void c(Bundle bundle)
    {
        d.c(bundle);
    }

    protected void d()
    {
        d.a();
    }

    protected void e()
    {
        d.b();
    }

    public Object f()
    {
        return d.e();
    }

    public final boolean g()
    {
        return d.requestWindowFeature(1);
    }
}
