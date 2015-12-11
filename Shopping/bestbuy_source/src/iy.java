// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.bbyscan.CaptureQRCodeActivity;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.registry.RecentlyViewedListCard;
import com.bestbuy.android.activities.registry.RegistryAdditionalOptions;
import com.bestbuy.android.activities.registry.ScannedItemCustomerAlsoViewedFragment;
import com.bestbuy.android.activities.registry.ScannedItemFragment;
import com.bestbuy.android.activities.registry.WishlistAdditionalOptions;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class iy extends ka
{

    private static int n = 0;
    private String a;
    private String j;
    private String k;
    private String l;
    private ArrayList m;
    private nb o;

    public iy(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1, String s2, String s3)
    {
        super(activity, bbybasefragment);
        g = view;
        a = s;
        j = s1;
        l = s3;
        k = s2;
        o = nb.a();
    }

    static int a(int i)
    {
        n = i;
        return i;
    }

    public void a()
    {
        String s = fr.d();
        m = fs.a(s, a, j, k, l, s, s, fr.b());
    }

    public void b()
    {
        n = 0;
        o.b(true);
        o.e(a);
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (!(i instanceof HomeTabFragment) || !i.isAdded()) goto _L2; else goto _L1
_L1:
        if (((HomeTabFragment)i).e() instanceof BaseTabContainer)
        {
            Object obj = ((BaseTabContainer)((HomeTabFragment)i).e()).b();
            if (obj instanceof PDPFragmentContainer)
            {
                obj = (PDPFragment)((PDPFragmentContainer)obj).b();
                if (obj instanceof PDPFragment)
                {
                    ((PDPFragment) (obj)).a(true);
                }
            }
        }
_L4:
        return;
_L2:
        if ((i instanceof ScannedItemFragment) && i.isAdded())
        {
            ((ScannedItemFragment)i).b(m);
            return;
        }
        if ((i instanceof RecentlyViewedListCard) && i.isAdded())
        {
            ((RecentlyViewedListCard)i).c();
            return;
        }
        if ((i instanceof ScannedItemCustomerAlsoViewedFragment) && i.isAdded())
        {
            ((ScannedItemCustomerAlsoViewedFragment)i).b();
            return;
        }
        if (!(i instanceof PDPFragmentContainer) || !i.isAdded())
        {
            break; /* Loop/switch isn't completed */
        }
        PDPFragment pdpfragment = (PDPFragment)((PDPFragmentContainer)i).b();
        if ((pdpfragment instanceof PDPFragment) && i.isAdded())
        {
            pdpfragment.a(true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if ((i instanceof WishlistAdditionalOptions) && i.isAdded())
        {
            ((WishlistAdditionalOptions)i).a(true);
            return;
        }
        if (f instanceof CaptureQRCodeActivity)
        {
            ((CaptureQRCodeActivity)f).e();
            return;
        }
        if ((i instanceof RegistryAdditionalOptions) && i.isAdded())
        {
            ((RegistryAdditionalOptions)i).a(true);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final iy a;

            public void a()
            {
                a.d();
            }

            
            {
                a = iy.this;
                super();
            }
        }, new nn() {

            final iy a;

            public void a()
            {
                iy.a(0);
            }

            
            {
                a = iy.this;
                super();
            }
        }, e, n);
    }

    public void d()
    {
        n++;
        (new iy(f, i, g, a, j, k, l)).executeOnExecutor(nb.g, new Void[0]);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
