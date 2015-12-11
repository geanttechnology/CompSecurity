// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class jg extends ka
{

    private static int k = 0;
    private ArrayList a;
    private String j;

    public jg(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        g = view;
        j = s;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    static BBYBaseFragment a(jg jg1)
    {
        return jg1.i;
    }

    static Activity b(jg jg1)
    {
        return jg1.f;
    }

    public void a()
    {
        a = fs.b(fr.d(), fr.b());
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (f instanceof HomeActivity)
        {
            ((HomeActivity)f).showWishListData(a, j);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jg a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jg.this;
                super();
            }
        }, new nn() {

            final jg a;

            public void a()
            {
                jg.a(0);
                if (!(jg.a(a) instanceof PDPFragment))
                {
                    ((HomeActivity)jg.b(a)).onBackPressed();
                }
            }

            
            {
                a = jg.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jg(f, i, g, j)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
            g.bringToFront();
        }
    }

}
