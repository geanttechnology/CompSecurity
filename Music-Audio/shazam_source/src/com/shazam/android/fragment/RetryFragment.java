// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.shazam.android.analytics.session.SessionCancellationPolicy;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.ConfigurablePage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.fragment.news.d;
import com.shazam.android.fragment.news.o;
import com.shazam.i.b.w.c.a;

// Referenced classes of package com.shazam.android.fragment:
//            e

public class RetryFragment extends BaseFragment
    implements SessionCancellationPolicy, SessionConfigurable
{

    private final d a = new o(com.shazam.i.b.w.c.a.a());

    public RetryFragment()
    {
    }

    public static RetryFragment a(String s)
    {
        RetryFragment retryfragment = new RetryFragment();
        retryfragment.setArguments(new Bundle());
        retryfragment.getArguments().putString("pageName", s);
        return retryfragment;
    }

    private String a()
    {
        return getArguments().getString("pageName");
    }

    private void a(LayoutInflater layoutinflater, FrameLayout framelayout)
    {
        framelayout.removeAllViewsInLayout();
        layoutinflater = layoutinflater.inflate(0x7f030052, framelayout).findViewById(0x7f11017d);
        int i = a.a();
        layoutinflater.setBackgroundColor(getResources().getColor(i));
        framelayout = getParentFragment();
        if (framelayout instanceof e)
        {
            a(((View) (layoutinflater)), (e)framelayout);
        } else
        if (getActivity() instanceof e)
        {
            a(((View) (layoutinflater)), (e)getActivity());
            return;
        }
    }

    private void a(View view, e e1)
    {
        view = view.findViewById(0x7f11026e);
        if (view != null)
        {
            view.setOnClickListener(new _cls1(e1));
        }
    }

    public void configureWith(Page page)
    {
        ((ConfigurablePage)page).setPageName(a());
    }

    public boolean isSessionCanceled(Object obj)
    {
        return com.shazam.b.e.a.a(a());
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a(LayoutInflater.from(getActivity()), (FrameLayout)getView());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = new FrameLayout(getActivity());
        viewgroup.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        a(layoutinflater, viewgroup);
        return viewgroup;
    }

    /* member class not found */
    class _cls1 {}

}
