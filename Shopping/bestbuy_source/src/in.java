// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPSourceProductAvailabilityFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.registry.BuyerRegistryAndWishListFragment;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.api.lib.models.cart.CartResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class in extends ka
{

    private String a;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private CartResponse q;
    private String r;

    public in(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1)
    {
        super(activity, bbybasefragment);
        r = "";
        g = view;
        a = s;
        l = s1;
    }

    public in(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1, String s2, String s3)
    {
        super(activity, bbybasefragment);
        r = "";
        g = view;
        a = s;
        n = s1;
        o = s2;
        p = s3;
    }

    public in(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1, String s2, String s3, 
            String s4)
    {
        super(activity, bbybasefragment);
        r = "";
        g = view;
        a = s;
        j = s1;
        k = s2;
        l = s3;
        m = s4;
    }

    public void a()
    {
        q = fs.b(a, j, k, l, m, n, o, p);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (q == null) goto _L2; else goto _L1
_L1:
        if (!q.isError()) goto _L4; else goto _L3
_L3:
        r = q.getMsg();
        c();
_L6:
        return;
_L4:
        Object obj;
        nb.a().e(false);
        int i = q.getQuantity();
        nb.a().b().edit().putInt(f.getResources().getString(0x7f080031), i).commit();
        if (!(f instanceof HomeActivity))
        {
            break MISSING_BLOCK_LABEL_331;
        }
        obj = ((HomeActivity)f).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(obj instanceof HomeTabFragment))
        {
            break MISSING_BLOCK_LABEL_331;
        }
        obj = (HomeTabFragment)obj;
_L7:
        if (obj != null)
        {
            ((HomeTabFragment) (obj)).d();
        }
        if ((this.i instanceof PDPFragment) && this.i.isAdded())
        {
            ((PDPFragment)this.i).d();
            return;
        }
        if ((this.i instanceof PDPSourceProductAvailabilityFragment) && this.i.isAdded())
        {
            ((PDPSourceProductAvailabilityFragment)this.i).b();
            return;
        }
        if ((this.i instanceof BuyerRegistryAndWishListFragment) && this.i.isAdded())
        {
            g.setVisibility(8);
            ((BuyerRegistryAndWishListFragment)this.i).a(a);
            return;
        }
        if ((this.i instanceof WishListWithProductsFragment) && this.i.isAdded())
        {
            g.setVisibility(8);
            ((WishListWithProductsFragment)this.i).b(a);
            return;
        }
        if (!(this.i instanceof ProductAvailabilityFragment) || !this.i.isAdded()) goto _L6; else goto _L5
_L5:
        ((ProductAvailabilityFragment)this.i).b();
        return;
_L2:
        c();
        return;
        obj = null;
          goto _L7
    }

    public void c()
    {
        if (r != null)
        {
            r = r.replaceAll("\\<[^>]*>", "");
        }
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof PDPFragment) && i.isAdded())
        {
            ((PDPFragment)i).a(r);
        } else
        {
            if ((i instanceof PDPSourceProductAvailabilityFragment) && i.isAdded())
            {
                ((PDPSourceProductAvailabilityFragment)i).b(r);
                return;
            }
            if ((i instanceof BuyerRegistryAndWishListFragment) && i.isAdded())
            {
                ((BuyerRegistryAndWishListFragment)i).b(r);
                return;
            }
            if ((i instanceof WishListWithProductsFragment) && i.isAdded())
            {
                ((WishListWithProductsFragment)i).c(r);
                return;
            }
            if ((i instanceof ProductAvailabilityFragment) && i.isAdded())
            {
                ((ProductAvailabilityFragment)i).d(r);
                return;
            }
        }
    }
}
