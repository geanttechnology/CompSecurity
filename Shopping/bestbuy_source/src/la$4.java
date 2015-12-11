// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mybby.MyBBYHomeActivity;
import com.bestbuy.android.activities.registry.RegistryFragmentContainer;
import java.util.HashMap;

class lang.Object
    implements android.view.OnClickListener
{

    final la a;

    public void onClick(View view)
    {
        a.dismiss();
        view = new HashMap();
        view.put("bb.prevPageLink", (new StringBuilder()).append(PDPFragment.f()).append("pdp: Create a Registry").toString());
        lu.a(lu.bf, view);
        if (fr.c() == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        la.a(a, (String)la.a(a).get("sku"));
        view = new RegistryFragmentContainer(true, la.d(a));
        if (!(la.f(a) instanceof HomeTabFragment)) goto _L2; else goto _L1
_L1:
        android.support.v4.app.Fragment fragment = ((HomeTabFragment)la.f(a)).e();
        if ((fragment instanceof HomeTabContainer) || (fragment instanceof ProductTabContainer))
        {
            ((HomeActivity)la.e(a)).addFragment(0x7f0c0033, view, "RegistryFragmentContainer");
        }
_L4:
        return;
_L2:
        if (!(la.f(a) instanceof PDPFragmentContainer)) goto _L4; else goto _L3
_L3:
        ((HomeActivity)la.e(a)).addFragment(0x7f0c0033, view, "RegistryFragmentContainer");
        return;
        nb.a().k((String)la.a(a).get("sku"));
        view = new Intent(la.e(a), com/bestbuy/android/activities/mybby/MyBBYHomeActivity);
        ((HomeActivity)la.e(a)).startActivityForResult(view, 7892);
        ((HomeActivity)la.e(a)).overridePendingTransition(0x7f04000e, 0x7f040005);
        return;
    }

    >(la la1)
    {
        a = la1;
        super();
    }
}
