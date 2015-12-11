// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.api.lib.models.registry.Recommendations;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class jh extends ka
{

    private String a;
    private View j;
    private ArrayList k;
    private int l;
    private int m;
    private Recommendations n;

    public jh(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, int i)
    {
        super(activity, bbybasefragment);
        j = view;
        a = s;
        m = i;
    }

    public void a()
    {
        n = fs.a(a, m);
    }

    public void b()
    {
        if (j != null)
        {
            j.setVisibility(8);
        }
        if ((i instanceof PLPFragment) && i.isAdded())
        {
            k = n.getSkuList();
            l = n.getTotal();
            ((PLPFragment)i).a(k, l);
        }
    }

    public void onPreExecute()
    {
        super.onPreExecute();
        if (j != null)
        {
            j.setVisibility(0);
        }
    }
}
