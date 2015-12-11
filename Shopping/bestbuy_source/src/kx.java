// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.stores.StoreTabContainer;
import com.bestbuy.android.base.BaseFragmentContainer;

public class kx extends Dialog
    implements android.view.View.OnClickListener
{

    private Context a;

    public kx(Context context)
    {
        super(context, 0x7f0e002b);
        a = context;
    }

    public void onClick(View view)
    {
        if (view.getId() != 0x7f0c01cd) goto _L2; else goto _L1
_L1:
        dismiss();
        ((HomeActivity)a).closeSideMenu();
        android.support.v4.app.Fragment fragment = ((HomeActivity)a).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        MdotWebFragment mdotwebfragment;
        Bundle bundle;
        if (fragment instanceof HomeTabFragment)
        {
            view = (HomeTabFragment)fragment;
        } else
        {
            view = null;
        }
        mdotwebfragment = new MdotWebFragment(true, true);
        bundle = new Bundle();
        bundle.putString("mDotURL", "https://www-ssl.bestbuy.com/profile/c/myaccount");
        mdotwebfragment.setArguments(bundle);
        if (view == null) goto _L4; else goto _L3
_L3:
        view = view.getChildFragmentManager().findFragmentByTag(view.b().getCurrentTabTag());
        if (view != null)
        {
            if (view instanceof HomeTabContainer)
            {
                ((HomeTabContainer)view).a(mdotwebfragment, true);
            }
            if (view instanceof ProductTabContainer)
            {
                ((ProductTabContainer)view).a(mdotwebfragment, true);
            }
            if (view instanceof StoreTabContainer)
            {
                ((StoreTabContainer)view).a(mdotwebfragment, true);
            }
            if (view instanceof CartTabContainer)
            {
                ((CartTabContainer)view).a(mdotwebfragment, true);
            }
        }
_L6:
        return;
_L4:
        if (fragment instanceof BaseFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(mdotwebfragment, true);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (view.getId() == 0x7f0c01ce)
        {
            (new hr((Activity)a)).execute(new Void[0]);
            fr.a();
            nb.a().d(false);
            nb.a().e(true);
            nb.a().a(".bestbuy.com", a);
            ((HomeActivity)a).buildSideMenu();
            nb.a().a(null);
            ((HomeActivity)a).recreateHomeScreen(true);
            dismiss();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03007a);
        findViewById(0x7f0c01cd).setOnClickListener(this);
        findViewById(0x7f0c01ce).setOnClickListener(this);
        setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final kx a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.dismiss();
            }

            
            {
                a = kx.this;
                super();
            }
        });
    }
}
