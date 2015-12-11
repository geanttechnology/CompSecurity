// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.webkit.WebView;
import com.target.mothership.a.a;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.util.o;
import com.target.ui.fragment.webview.TargetBaseWebViewFragment;
import com.target.ui.service.provider.c;
import com.target.ui.util.q;

public class PayPalWebFragment extends TargetBaseWebViewFragment
{
    public static interface a
    {

        public abstract void b(InitiatedPayPal initiatedpaypal);
    }

    private class b extends com.target.ui.fragment.webview.TargetBaseWebViewFragment.c
    {

        final PayPalWebFragment this$0;

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (com.target.ui.fragment.checkout.PayPalWebFragment.a(s))
            {
                webview = com.target.ui.fragment.checkout.PayPalWebFragment.a(PayPalWebFragment.this);
                getFragmentManager().c();
                PayPalWebFragment.b(PayPalWebFragment.this).b(webview);
                return true;
            }
            if (PayPalWebFragment.b(s))
            {
                getFragmentManager().c();
                return true;
            } else
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }

        private b()
        {
            this$0 = PayPalWebFragment.this;
            super(PayPalWebFragment.this);
        }

    }


    private static final String ARG_INITIATED_PAY_PAL = "proof that you've initiated the paypal process";
    public static final String TAG = com/target/ui/fragment/checkout/PayPalWebFragment.getSimpleName();
    private a mListener;

    public PayPalWebFragment()
    {
    }

    static InitiatedPayPal a(PayPalWebFragment paypalwebfragment)
    {
        return paypalwebfragment.n();
    }

    public static PayPalWebFragment a(InitiatedPayPal initiatedpaypal, Fragment fragment)
    {
        PayPalWebFragment paypalwebfragment = new PayPalWebFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("proof that you've initiated the paypal process", initiatedpaypal);
        paypalwebfragment.setArguments(bundle);
        paypalwebfragment.setTargetFragment(fragment, 0);
        return paypalwebfragment;
    }

    static boolean a(String s)
    {
        return c(s);
    }

    static a b(PayPalWebFragment paypalwebfragment)
    {
        return paypalwebfragment.mListener;
    }

    static boolean b(String s)
    {
        return f(s);
    }

    private static boolean c(String s)
    {
        q.d(TAG, (new StringBuilder()).append("testing url for PayPal validation: ").append(s).toString());
        String s1 = (new c()).a().d();
        return o.f(s) && s.contains(s1);
    }

    private static boolean f(String s)
    {
        q.d(TAG, (new StringBuilder()).append("testing url for PayPal cancellation: ").append(s).toString());
        String s1 = (new c()).a().e();
        return o.f(s) && s.contains(s1);
    }

    private InitiatedPayPal n()
    {
        return (InitiatedPayPal)getArguments().getParcelable("proof that you've initiated the paypal process");
    }

    public int a()
    {
        return 0x7f03006c;
    }

    public int b()
    {
        return 0x7f1001af;
    }

    public int c()
    {
        return 0x7f100230;
    }

    public int d()
    {
        return 0x7f1001ae;
    }

    public int e()
    {
        return 0x7f1001b0;
    }

    public int f()
    {
        return 0x7f100231;
    }

    protected com.target.ui.fragment.webview.TargetBaseWebViewFragment.c g()
    {
        return new b();
    }

    protected int h()
    {
        return 2;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (a)getTargetFragment();
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public void onResume()
    {
        super.onResume();
        e(n().a());
    }

}
