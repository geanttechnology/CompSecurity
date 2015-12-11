// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.CouponOffer;
import com.target.ui.analytics.a.ba;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.helper.f.a;
import com.target.ui.util.q;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            a, CouponsErrorDialogFragment, CouponOnDemandFragment, CouponsEntryFragment, 
//            CouponDetailFragment

public class CouponListFragment extends BaseNavigationFragment
    implements CouponOnDemandFragment.a, com.target.ui.fragment.mcoupons.a, com.target.ui.helper.f.a.a
{
    private class a
        implements android.widget.AdapterView.OnItemClickListener
    {

        final CouponListFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int k, long l)
        {
            adapterview = (CouponOffer)adapterview.getItemAtPosition(k);
            m().d(com.target.ui.fragment.mcoupons.CouponDetailFragment.a(adapterview.a()));
        }

        private a()
        {
            this$0 = CouponListFragment.this;
            super();
        }

    }

    private static class b
    {

        ListView listView;

        public b(View view)
        {
            listView = (ListView)view.findViewById(0x7f100168);
        }
    }


    private static final String COUPON_CODE_KEY = "COUPON_CODE_KEY";
    private static final String COUPON_COMPLETED_SIGN_UP_PARCELABLE_KEY = "COUPON_COMPLETED_SIGN_UP_PARCELABLE_KEY";
    private static final String LOG_TAG = com/target/ui/fragment/mcoupons/CouponListFragment.getSimpleName();
    private com.target.ui.adapter.c.a mAdapter;
    private CompletedSignUp mCompletedSignUp;
    private com.target.ui.helper.f.a mCouponDataHelper;
    private b mViews;

    public CouponListFragment()
    {
    }

    public static CouponListFragment a(CompletedSignUp completedsignup)
    {
        CouponListFragment couponlistfragment = new CouponListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("COUPON_COMPLETED_SIGN_UP_PARCELABLE_KEY", completedsignup);
        couponlistfragment.setArguments(bundle);
        return couponlistfragment;
    }

    public static CouponListFragment a(CompletedSignUp completedsignup, String s)
    {
        CouponListFragment couponlistfragment = new CouponListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("COUPON_COMPLETED_SIGN_UP_PARCELABLE_KEY", completedsignup);
        bundle.putString("COUPON_CODE_KEY", s);
        couponlistfragment.setArguments(bundle);
        return couponlistfragment;
    }

    private void a()
    {
        String s = d();
        if (s == null)
        {
            q.a(TAG, "Stored coupon code is null");
            return;
        } else
        {
            b(s);
            return;
        }
    }

    private void b(com.target.mothership.model.coupons.interfaces.a.a a1)
    {
        a1 = com.target.ui.fragment.mcoupons.CouponsErrorDialogFragment.a(getActivity(), a1);
        a1.setCancelable(false);
        a1.show(getFragmentManager(), CouponsErrorDialogFragment.TAG);
    }

    private void b(com.target.mothership.model.coupons.interfaces.a.c c1)
    {
        c1 = com.target.ui.fragment.mcoupons.CouponsErrorDialogFragment.a(getActivity(), c1);
        c1.setCancelable(false);
        c1.show(getFragmentManager(), CouponsErrorDialogFragment.TAG);
    }

    private void b(String s)
    {
        o(true);
        mCouponDataHelper.a(mCompletedSignUp, s);
    }

    private void b(List list)
    {
        mAdapter = new com.target.ui.adapter.c.a(getActivity(), list);
        mViews.listView.setAdapter(mAdapter);
    }

    private boolean c()
    {
        return getArguments().containsKey("COUPON_CODE_KEY");
    }

    private String d()
    {
        return getArguments().getString("COUPON_CODE_KEY", null);
    }

    private void e()
    {
        getArguments().remove("COUPON_CODE_KEY");
    }

    private void f()
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.mcoupons.CouponsErrorDialogFragment.a(getString(0x7f0902b7), getString(0x7f0902b6)).show(getFragmentManager(), CouponsErrorDialogFragment.TAG);
            return;
        }
    }

    private void g()
    {
        o(true);
        mCouponDataHelper.a(mCompletedSignUp);
    }

    private void h()
    {
        o(true);
        mCouponDataHelper.b(mCompletedSignUp);
    }

    private void i()
    {
        com.target.ui.fragment.mcoupons.CouponOnDemandFragment.a(this).show(getFragmentManager(), CouponOnDemandFragment.TAG);
    }

    private void j()
    {
        Object obj;
        if (c())
        {
            obj = d();
            if (obj == null)
            {
                q.a(TAG, "Stored coupon code is null");
                return;
            }
            obj = com.target.ui.fragment.mcoupons.CouponsEntryFragment.a(((String) (obj)));
        } else
        {
            obj = com.target.ui.fragment.mcoupons.CouponsEntryFragment.c();
        }
        m().e(((android.support.v4.app.Fragment) (obj)));
    }

    public void a(com.target.mothership.model.coupons.interfaces.a.a a1)
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
        } else
        {
            o(false);
            if (c())
            {
                e();
                g();
                return;
            }
            if (!Z())
            {
                b(a1);
                return;
            }
        }
    }

    public void a(com.target.mothership.model.coupons.interfaces.a.c c1)
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
        } else
        {
            o(false);
            if (!Z())
            {
                if (c1.e() == com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_INSTANCE_KEY || c1.e() == com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_UNKNOWN || c1.e() == com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_EXECUTION_FAILED)
                {
                    (new com.target.mothership.model.coupons.c()).b();
                    j();
                    return;
                } else
                {
                    b(c1);
                    return;
                }
            }
        }
    }

    public void a(String s)
    {
        b(s);
    }

    public void a(Void void1)
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
            return;
        }
        o(false);
        if (c())
        {
            e();
            h();
            return;
        } else
        {
            g();
            return;
        }
    }

    public void a(List list)
    {
        o(false);
        if (list.isEmpty())
        {
            q.a(LOG_TAG, "Assigned offers is null!");
            return;
        }
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
            return;
        } else
        {
            b(list);
            return;
        }
    }

    public void b()
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
            return;
        } else
        {
            o(false);
            f();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mCouponDataHelper = new com.target.ui.helper.f.a(this);
        mCompletedSignUp = (CompletedSignUp)getArguments().getParcelable("COUPON_COMPLETED_SIGN_UP_PARCELABLE_KEY");
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            j("");
            menuinflater.inflate(0x7f120001, menu);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030057, viewgroup, false);
        mViews = new b(layoutinflater);
        mViews.listView.setOnItemClickListener(new a());
        com.target.ui.service.c.a().a(this);
        if (c())
        {
            a();
            return layoutinflater;
        } else
        {
            h();
            return layoutinflater;
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        com.target.ui.service.c.a().b(this);
        mViews = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756540: 
            i();
            break;
        }
        return true;
    }

    public void onResume()
    {
        super.onResume();
        ba.a(this).e();
    }

}
