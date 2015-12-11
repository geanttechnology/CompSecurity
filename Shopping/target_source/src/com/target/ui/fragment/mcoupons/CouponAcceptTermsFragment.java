// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.TargetWebFragment;
import com.target.ui.util.SpannableStringUtils;

public class CouponAcceptTermsFragment extends BaseNavigationFragment
{
    static class Views extends com.target.ui.view.a
    {

        Button mAgreeButton;
        TextView mAgreementText;

        Views(View view)
        {
            super(view);
        }
    }

    private static class a
    {

        private static final String PRIVACY = "file:///android_asset/htmls/privacy.html";
        private static final String TERMS = "file:///android_asset/htmls/terms.html";

        static String a(int i)
        {
            return b(i);
        }

        private static String b(int i)
        {
            switch (i)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("No URL found for key: ").append(i).toString());

            case 2131296930: 
                return "file:///android_asset/htmls/privacy.html";

            case 2131296931: 
                return "file:///android_asset/htmls/terms.html";
            }
        }
    }

    private class b
        implements com.target.ui.util.SpannableStringUtils.CustomUrlSpan.a
    {

        final CouponAcceptTermsFragment this$0;

        private void b(String s)
        {
            s = TargetWebFragment.a(true, s, " ");
            m().d(s);
        }

        public void a(String s)
        {
            b(s);
        }

        private b()
        {
            this$0 = CouponAcceptTermsFragment.this;
            super();
        }

    }

    public static interface c
    {

        public abstract void a();
    }


    public static final String TAG = com/target/ui/fragment/mcoupons/CouponAcceptTermsFragment.getSimpleName();
    private c mListener;
    private Views mViews;

    public CouponAcceptTermsFragment()
    {
    }

    public static CouponAcceptTermsFragment b(Fragment fragment)
    {
        CouponAcceptTermsFragment couponaccepttermsfragment = new CouponAcceptTermsFragment();
        couponaccepttermsfragment.setTargetFragment(fragment, 0);
        return couponaccepttermsfragment;
    }

    public void a()
    {
        mListener.a();
        m().b();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (c)getTargetFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f030054, viewgroup, false);
        mViews = new Views(viewgroup);
        mViews.mAgreeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponAcceptTermsFragment this$0;

            public void onClick(View view)
            {
                a();
            }

            
            {
                this$0 = CouponAcceptTermsFragment.this;
                super();
            }
        });
        layoutinflater = getString(0x7f0902a1);
        bundle = new int[2];
        Bundle _tmp = bundle;
        bundle[0] = 0x7f0902a3;
        bundle[1] = 0x7f0902a2;
        int j = bundle.length;
        for (int i = 0; i < j; i++)
        {
            Integer integer = Integer.valueOf(bundle[i]);
            layoutinflater = layoutinflater.replace(getString(integer.intValue()), a.a(integer.intValue()));
        }

        layoutinflater = new SpannableStringBuilder(Html.fromHtml(layoutinflater));
        SpannableStringUtils.a(layoutinflater, new b(), false);
        mViews.mAgreementText.setText(layoutinflater);
        mViews.mAgreementText.setMovementMethod(LinkMovementMethod.getInstance());
        return viewgroup;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}
