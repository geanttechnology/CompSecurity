// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            l, a, b, n, 
//            aw

public class k
    implements a.a, l
{

    public static n a;
    public static a.a b;
    a c;
    Activity d;
    a.a e;
    n f;

    public k()
    {
    }

    public int a(aw aw)
    {
        return e.a(aw);
    }

    public int a(aw aw, int i1)
    {
        return e.a(aw, i1);
    }

    public int a(aw aw, int i1, List list)
    {
        return e.a(aw, i1, list);
    }

    public void a()
    {
        c.a();
    }

    public void a(float f1, float f2, int i1)
    {
    }

    public void a(int i1)
    {
        e.a(i1);
    }

    public void a(int i1, int j1, Intent intent)
    {
    }

    public void a(Configuration configuration)
    {
        c.a(configuration);
    }

    public void a(Bundle bundle, Activity activity)
    {
        f = a;
        e = b;
        a = null;
        b = null;
        d = activity;
        d.requestWindowFeature(1);
        d.getWindow().setFlags(1024, 1024);
        c = new b(this, d, f, false);
    }

    public void a(a a1)
    {
        int i1 = d.getIntent().getIntExtra("curEventID", -1);
        a1 = new Intent();
        if (i1 > -1)
        {
            a1.putExtra("endEventId", i1);
        }
        d.setResult(100, a1);
        d.finish();
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        return c.a(i1, keyevent);
    }

    public void b()
    {
        c.b();
    }

    public void b(int i1)
    {
    }

    public void c()
    {
        c.c();
    }

    public boolean d()
    {
        return false;
    }

    public void e()
    {
    }

    public void f()
    {
    }

    public n g()
    {
        return f;
    }

    public Context h()
    {
        return d;
    }

    public int i()
    {
        return Resources.getSystem().getConfiguration().orientation != 2 ? 1 : 0;
    }

    public int j()
    {
        return -1;
    }
}
