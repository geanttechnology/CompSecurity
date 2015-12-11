// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Fragment;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.wallet.fragment.WalletFragment;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public class asx extends rs
    implements android.view.View.OnClickListener
{

    final WalletFragment a;

    private asx(WalletFragment walletfragment)
    {
        a = walletfragment;
        super();
    }

    public asx(WalletFragment walletfragment, com.google.android.gms.wallet.fragment.WalletFragment._cls1 _pcls1)
    {
        this(walletfragment);
    }

    protected void a(FrameLayout framelayout)
    {
        Button button = new Button(WalletFragment.a(a).getActivity());
        button.setText(com.google.android.gms.R.string.wallet_buy_button_place_holder);
        byte byte0 = -1;
        byte byte1 = -2;
        int j = byte1;
        int i = byte0;
        if (WalletFragment.e(a) != null)
        {
            WalletFragmentStyle walletfragmentstyle = WalletFragment.e(a).c();
            j = byte1;
            i = byte0;
            if (walletfragmentstyle != null)
            {
                android.util.DisplayMetrics displaymetrics = WalletFragment.a(a).getResources().getDisplayMetrics();
                i = walletfragmentstyle.a("buyButtonWidth", displaymetrics, -1);
                j = walletfragmentstyle.a("buyButtonHeight", displaymetrics, -2);
            }
        }
        button.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, j));
        button.setOnClickListener(this);
        framelayout.addView(button);
    }

    protected void a(sc sc1)
    {
        Object obj = WalletFragment.a(a).getActivity();
        if (WalletFragment.b(a) == null && WalletFragment.c(a) && obj != null)
        {
            try
            {
                obj = agj.a(((android.app.Activity) (obj)), WalletFragment.d(a), WalletFragment.e(a), WalletFragment.f(a));
                WalletFragment.a(a, new asw(((aga) (obj)), null));
                WalletFragment.a(a, null);
            }
            // Misplaced declaration of an exception variable
            catch (sc sc1)
            {
                return;
            }
            sc1.a(WalletFragment.b(a));
            if (WalletFragment.g(a) != null)
            {
                asw.a(WalletFragment.b(a), WalletFragment.g(a));
                WalletFragment.a(a, null);
            }
            if (WalletFragment.h(a) != null)
            {
                asw.a(WalletFragment.b(a), WalletFragment.h(a));
                WalletFragment.a(a, null);
            }
            if (WalletFragment.i(a) != null)
            {
                asw.a(WalletFragment.b(a), WalletFragment.i(a));
                WalletFragment.a(a, null);
            }
            if (WalletFragment.j(a) != null)
            {
                asw.a(WalletFragment.b(a), WalletFragment.j(a).booleanValue());
                WalletFragment.a(a, null);
            }
        }
    }

    public void onClick(View view)
    {
        view = WalletFragment.a(a).getActivity();
        pu.a(pu.a(view), view, -1);
    }
}
