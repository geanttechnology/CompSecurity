// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import com.bestbuy.android.activities.home.HomeFragment;
import com.bestbuy.android.activities.home.SplashFragment;
import com.bestbuy.android.api.lib.models.releasemgt.SupportedVersionsResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class it extends ka
{

    private static int j = 0;
    protected nb a;
    private SupportedVersionsResponse k;

    public it(Activity activity, BBYBaseFragment bbybasefragment)
    {
        super(activity, bbybasefragment);
        k = null;
        a = nb.a();
    }

    static int a(int i)
    {
        j = i;
        return i;
    }

    static Activity a(it it1)
    {
        return it1.f;
    }

    static BBYBaseFragment b(it it1)
    {
        return it1.i;
    }

    static Activity c(it it1)
    {
        return it1.f;
    }

    static int f()
    {
        int i = j;
        j = i + 1;
        return i;
    }

    public void a()
    {
        k = fs.a(ft.a, f);
    }

    public void b()
    {
        if ((i instanceof HomeFragment) && i.isAdded())
        {
            if (nb.a().n().a(k, f))
            {
                ((HomeFragment)i).e();
            }
        } else
        if ((i instanceof SplashFragment) && i.isAdded())
        {
            if (nb.a().n().b(k, f))
            {
                nb.a().n().c(k, f).a();
                return;
            } else
            {
                ((SplashFragment)i).b();
                return;
            }
        }
    }

    public void c()
    {
        nm.a(f, new no() {

            final it a;

            public void a()
            {
                it.f();
                (new it(it.a(a), it.b(a))).executeOnExecutor(nb.h, new Void[0]);
            }

            
            {
                a = it.this;
                super();
            }
        }, new nn() {

            final it a;

            public void a()
            {
                it.a(0);
                it.c(a).finish();
            }

            
            {
                a = it.this;
                super();
            }
        }, e, j);
    }

}
