// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.ShareURL;
import com.bestbuy.android.base.BBYBaseFragment;

public class jt extends ka
{

    private static int k = 0;
    private ShareURL a;
    private String j;
    private boolean l;

    public jt(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, boolean flag)
    {
        super(activity, bbybasefragment);
        j = s;
        g = view;
        l = flag;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    static int f()
    {
        int i = k;
        k = i + 1;
        return i;
    }

    public void a()
    {
        k = 0;
        a = fs.n(j);
    }

    public void b()
    {
        k = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a != null && (f instanceof HomeActivity))
        {
            ((HomeActivity)f).postOnTwitter(a.getUrl(), l);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jt a;

            public void a()
            {
                jt.f();
                a.d();
            }

            
            {
                a = jt.this;
                super();
            }
        }, new nn() {

            final jt a;

            public void a()
            {
                jt.a(0);
            }

            
            {
                a = jt.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jt(f, i, g, j, l)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
