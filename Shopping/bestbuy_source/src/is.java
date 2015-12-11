// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.home.HomeFragment;
import com.bestbuy.android.api.lib.models.home.HomeFragmentResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class is extends ka
{

    private String a;
    private HomeFragmentResponse j;
    private int k;

    public is(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment);
        a = is.getSimpleName();
        k = 0;
        g = view;
    }

    static int a(is is1)
    {
        int i = is1.k;
        is1.k = i + 1;
        return i;
    }

    static int a(is is1, int i)
    {
        is1.k = i;
        return i;
    }

    static Activity b(is is1)
    {
        return is1.f;
    }

    static BBYBaseFragment c(is is1)
    {
        return is1.i;
    }

    static Activity d(is is1)
    {
        return is1.f;
    }

    public void a()
    {
        j = gq.a(f);
    }

    public void b()
    {
        if ((i instanceof HomeFragment) && i.isAdded())
        {
            ((HomeFragment)i).a(j);
        }
    }

    public void c()
    {
        nm.a(f, new no() {

            final is a;

            public void a()
            {
                is.a(a);
                new is(is.b(a), is.c(a), null);
            }

            
            {
                a = is.this;
                super();
            }
        }, new nn() {

            final is a;

            public void a()
            {
                is.a(a, 0);
                is.d(a).finish();
            }

            
            {
                a = is.this;
                super();
            }
        }, e, k);
    }
}
