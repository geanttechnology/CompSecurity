// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.WeddingRegistrySettings;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;

public class jq extends ka
{

    private static int k = 0;
    private WeddingRegistryData a;
    private boolean j;

    public jq(Activity activity, BBYBaseFragment bbybasefragment, View view, WeddingRegistryData weddingregistrydata)
    {
        super(activity, bbybasefragment);
        a = weddingregistrydata;
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
        k = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j && (i instanceof WeddingRegistrySettings) && i.isAdded())
        {
            ((WeddingRegistrySettings)i).a(a);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jq a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jq.this;
                super();
            }
        }, new nn() {

            final jq a;

            public void a()
            {
                jq.a(0);
            }

            
            {
                a = jq.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jq(f, i, g, a)).executeOnExecutor(nb.g, new Void[0]);
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
