// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.LEBannerHomeCard;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;
import java.util.List;

public class hp extends ka
{

    private static int k = 0;
    boolean a;
    private List j;

    public hp(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment);
        a = false;
        g = view;
    }

    public void a()
    {
        j = fs.b();
    }

    public void b()
    {
        if (i.isDetached()) goto _L2; else goto _L1
_L1:
        if (j == null || j.size() <= 0) goto _L4; else goto _L3
_L3:
        k = 0;
        if ((i instanceof LEBannerHomeCard) && !i.isDetached())
        {
            ((LEBannerHomeCard)i).a(j);
        }
_L2:
        if (g != null)
        {
            g.setVisibility(8);
        }
        return;
_L4:
        if ((i instanceof LEBannerHomeCard) && !i.isDetached())
        {
            ((LEBannerHomeCard)i).b();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof LEBannerHomeCard) && !i.isDetached())
        {
            ((LEBannerHomeCard)i).b();
        }
    }

    public void d()
    {
        k++;
        (new hp(f, i, g)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
        j = new ArrayList();
    }

}
