// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.ListOfAliasesFragment;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.base.BBYBaseFragment;

public class jl extends ka
{

    private static int j = 0;
    private String a;
    private String k;
    private SearchApi l;

    public jl(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1)
    {
        super(activity, bbybasefragment);
        a = s;
        g = view;
        k = s1;
    }

    static int a(int i)
    {
        j = i;
        return i;
    }

    public void a()
    {
        l = fs.a(a, "search", "130", null, null, false, false, 10, 1);
    }

    public void b()
    {
        j = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (l != null && (i instanceof ListOfAliasesFragment) && i.isAdded())
        {
            ((ListOfAliasesFragment)i).a(l.getSkuList(), k);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jl a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jl.this;
                super();
            }
        }, new nn() {

            final jl a;

            public void a()
            {
                jl.a(0);
            }

            
            {
                a = jl.this;
                super();
            }
        }, e, j);
    }

    public void d()
    {
        j++;
        (new jl(f, i, g, a, k)).executeOnExecutor(nb.h, new Void[0]);
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
