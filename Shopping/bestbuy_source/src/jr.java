// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.WishListSettingsFragment;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;

public class jr extends ka
{

    private static int k = 0;
    private WishListReqData a;
    private boolean j;

    public jr(Activity activity, BBYBaseFragment bbybasefragment, View view, WishListReqData wishlistreqdata)
    {
        super(activity, bbybasefragment);
        a = wishlistreqdata;
        g = view;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    public void a()
    {
        j = fs.b(fr.d(), a.getListType(), fr.b(), a);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j && (i instanceof WishListSettingsFragment) && i.isAdded())
        {
            ((WishListSettingsFragment)i).d();
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jr a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jr.this;
                super();
            }
        }, new nn() {

            final jr a;

            public void a()
            {
                jr.a(0);
            }

            
            {
                a = jr.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jr(f, i, g, a)).executeOnExecutor(nb.g, new Void[0]);
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
