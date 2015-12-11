// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments.safetytips;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v4.view.ViewPager;
import android.support.v7.hy;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.ui.widgets.LetgoPageIndicator;
import com.abtnprojects.ambatana.ui.widgets.d;

public class TipContainerDialogFragment extends f
{
    public static interface a
    {

        public abstract void D();
    }


    hy aj;
    d ak;
    LetgoPageIndicator al;
    a am;
    ImageView ivNextTip;
    ImageView ivPrevTip;
    ViewPager pager;
    LinearLayoutCompat tipIndicatorContainer;

    public TipContainerDialogFragment()
    {
    }

    public static TipContainerDialogFragment Q()
    {
        return new TipContainerDialogFragment();
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f04003f, viewgroup);
        ButterKnife.bind(this, layoutinflater);
        aj = new hy(m());
        ak = new d(ivPrevTip, ivNextTip, tipIndicatorContainer, aj.b(), j());
        pager.setAdapter(aj);
        pager.a(ak);
        pager.a(al);
        pager.a(0, false);
        return layoutinflater;
    }

    public void a(a a1)
    {
        am = a1;
    }

    public Dialog c(Bundle bundle)
    {
        bundle = super.c(bundle);
        bundle.requestWindowFeature(1);
        return bundle;
    }

    public void g()
    {
        super.g();
        pager.b();
        ButterKnife.unbind(this);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (am != null)
        {
            am.D();
        }
    }

    protected void onDoneTap(View view)
    {
        if (am != null)
        {
            am.D();
        }
        a();
    }

    protected void onNextTap(View view)
    {
        int i = pager.getCurrentItem();
        if (i < aj.b())
        {
            pager.a(i + 1, true);
        }
    }

    protected void onPrevTap(View view)
    {
        int i = pager.getCurrentItem();
        if (i > 0)
        {
            pager.a(i - 1, true);
        }
    }
}
