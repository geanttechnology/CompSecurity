// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.recentlyviewed.RecentlyViewedHomeCard;
import com.bestbuy.android.activities.registry.RecentlyViewedListCard;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hl extends ka
{

    private static int k = 0;
    boolean a;
    private ArrayList j;

    public hl(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment);
        a = false;
        g = view;
    }

    public void a()
    {
        j = fs.a(f);
    }

    public void b()
    {
        k = 0;
        if (i.isDetached()) goto _L2; else goto _L1
_L1:
        if (j != null && (j == null || !j.isEmpty())) goto _L4; else goto _L3
_L3:
        if (!(i instanceof RecentlyViewedHomeCard) || !i.isAdded()) goto _L6; else goto _L5
_L5:
        ((RecentlyViewedHomeCard)i).b();
_L2:
        return;
_L6:
        if ((i instanceof RecentlyViewedListCard) && i.isAdded())
        {
            ((RecentlyViewedListCard)i).b();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ((i instanceof RecentlyViewedHomeCard) && i.isAdded())
        {
            ((RecentlyViewedHomeCard)i).a(j);
            return;
        }
        if ((i instanceof RecentlyViewedListCard) && i.isAdded())
        {
            ((RecentlyViewedListCard)i).a(j);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void c()
    {
        if (!i.isDetached())
        {
            if ((i instanceof RecentlyViewedHomeCard) && i.isAdded())
            {
                ((RecentlyViewedHomeCard)i).b();
            } else
            if ((i instanceof RecentlyViewedListCard) && i.isAdded())
            {
                ((RecentlyViewedListCard)i).b();
                return;
            }
        }
    }

    public void d()
    {
        k++;
        (new hl(f, i, g)).executeOnExecutor(nb.h, new Void[0]);
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
