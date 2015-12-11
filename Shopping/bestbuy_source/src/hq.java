// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import com.bestbuy.android.activities.home.GHPBannersHomeCard;
import com.bestbuy.android.api.lib.models.offers.Offer;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;
import java.util.List;

public class hq extends ka
{

    private static int l = 0;
    boolean a;
    private List j;
    private View k;

    public hq(Activity activity, Fragment fragment, View view)
    {
        super(activity, (BBYBaseFragment)fragment);
        a = false;
        k = view;
    }

    public void a()
    {
        j = fs.a();
    }

    public void b()
    {
        if (j != null)
        {
            for (int i = 0; i < j.size(); i++)
            {
                Offer offer = (Offer)j.get(i);
                if (offer.getRzLevels() != null && offer.getRzLevels().size() > 0 && !a)
                {
                    j.remove(i);
                }
            }

        }
        if (j == null || j.size() <= 0) goto _L2; else goto _L1
_L1:
        l = 0;
        if ((this.i instanceof GHPBannersHomeCard) && !this.i.isDetached())
        {
            ((GHPBannersHomeCard)this.i).a(j);
        }
_L4:
        if (k != null)
        {
            k.setVisibility(8);
        }
        return;
_L2:
        if ((this.i instanceof GHPBannersHomeCard) && !this.i.isDetached())
        {
            ((GHPBannersHomeCard)this.i).b();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void c()
    {
        if (k != null)
        {
            k.setVisibility(8);
        }
        if ((i instanceof GHPBannersHomeCard) && !i.isDetached())
        {
            ((GHPBannersHomeCard)i).b();
        }
    }

    public void d()
    {
        l++;
        (new hq(f, i, k)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (k != null)
        {
            k.setVisibility(0);
        }
        j = new ArrayList();
    }

}
