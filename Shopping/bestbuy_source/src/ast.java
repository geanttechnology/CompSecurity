// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.wallet.fragment.SupportWalletFragment;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public class ast extends rs
    implements android.view.View.OnClickListener
{

    final SupportWalletFragment a;

    private ast(SupportWalletFragment supportwalletfragment)
    {
        a = supportwalletfragment;
        super();
    }

    public ast(SupportWalletFragment supportwalletfragment, com.google.android.gms.wallet.fragment.SupportWalletFragment._cls1 _pcls1)
    {
        this(supportwalletfragment);
    }

    protected void a(FrameLayout framelayout)
    {
        Button button = new Button(SupportWalletFragment.a(a).getActivity());
        button.setText(com.google.android.gms.R.string.wallet_buy_button_place_holder);
        byte byte0 = -1;
        byte byte1 = -2;
        int j = byte1;
        int i = byte0;
        if (SupportWalletFragment.e(a) != null)
        {
            WalletFragmentStyle walletfragmentstyle = SupportWalletFragment.e(a).c();
            j = byte1;
            i = byte0;
            if (walletfragmentstyle != null)
            {
                android.util.DisplayMetrics displaymetrics = SupportWalletFragment.a(a).getResources().getDisplayMetrics();
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
        Object obj = SupportWalletFragment.a(a).getActivity();
        if (SupportWalletFragment.b(a) == null && SupportWalletFragment.c(a) && obj != null)
        {
            try
            {
                obj = agj.a(((android.app.Activity) (obj)), SupportWalletFragment.d(a), SupportWalletFragment.e(a), SupportWalletFragment.f(a));
                SupportWalletFragment.a(a, new ass(((aga) (obj)), null));
                SupportWalletFragment.a(a, null);
            }
            // Misplaced declaration of an exception variable
            catch (sc sc1)
            {
                return;
            }
            sc1.a(SupportWalletFragment.b(a));
            if (SupportWalletFragment.g(a) != null)
            {
                ass.a(SupportWalletFragment.b(a), SupportWalletFragment.g(a));
                SupportWalletFragment.a(a, null);
            }
            if (SupportWalletFragment.h(a) != null)
            {
                ass.a(SupportWalletFragment.b(a), SupportWalletFragment.h(a));
                SupportWalletFragment.a(a, null);
            }
            if (SupportWalletFragment.i(a) != null)
            {
                ass.a(SupportWalletFragment.b(a), SupportWalletFragment.i(a));
                SupportWalletFragment.a(a, null);
            }
            if (SupportWalletFragment.j(a) != null)
            {
                ass.a(SupportWalletFragment.b(a), SupportWalletFragment.j(a).booleanValue());
                SupportWalletFragment.a(a, null);
            }
        }
    }

    public void onClick(View view)
    {
        view = SupportWalletFragment.a(a).getActivity();
        pu.a(pu.a(view), view, -1);
    }
}
