// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import asr;
import ass;
import ast;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import pu;
import sf;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentInitParams

public final class SupportWalletFragment extends Fragment
{

    private ass a;
    private boolean b;
    private final sf c = sf.a(this);
    private final ast d = new ast(this);
    private asr e;
    private final Fragment f = this;
    private WalletFragmentOptions g;
    private WalletFragmentInitParams h;
    private MaskedWalletRequest i;
    private MaskedWallet j;
    private Boolean k;

    public SupportWalletFragment()
    {
        b = false;
        e = new asr(this);
    }

    public static Fragment a(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.f;
    }

    public static ass a(SupportWalletFragment supportwalletfragment, ass ass1)
    {
        supportwalletfragment.a = ass1;
        return ass1;
    }

    public static MaskedWallet a(SupportWalletFragment supportwalletfragment, MaskedWallet maskedwallet)
    {
        supportwalletfragment.j = maskedwallet;
        return maskedwallet;
    }

    public static MaskedWalletRequest a(SupportWalletFragment supportwalletfragment, MaskedWalletRequest maskedwalletrequest)
    {
        supportwalletfragment.i = maskedwalletrequest;
        return maskedwalletrequest;
    }

    public static WalletFragmentInitParams a(SupportWalletFragment supportwalletfragment, WalletFragmentInitParams walletfragmentinitparams)
    {
        supportwalletfragment.h = walletfragmentinitparams;
        return walletfragmentinitparams;
    }

    public static WalletFragmentOptions a(SupportWalletFragment supportwalletfragment, WalletFragmentOptions walletfragmentoptions)
    {
        supportwalletfragment.g = walletfragmentoptions;
        return walletfragmentoptions;
    }

    public static Boolean a(SupportWalletFragment supportwalletfragment, Boolean boolean1)
    {
        supportwalletfragment.k = boolean1;
        return boolean1;
    }

    public static ass b(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.a;
    }

    public static boolean c(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.b;
    }

    public static sf d(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.c;
    }

    public static WalletFragmentOptions e(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.g;
    }

    public static asr f(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.e;
    }

    public static WalletFragmentInitParams g(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.h;
    }

    public static MaskedWalletRequest h(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.i;
    }

    public static MaskedWallet i(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.j;
    }

    public static Boolean j(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.k;
    }

    public void onActivityResult(int l, int i1, Intent intent)
    {
        super.onActivityResult(l, i1, intent);
        if (a != null)
        {
            ass.a(a, l, i1, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        WalletFragmentInitParams walletfragmentinitparams = (WalletFragmentInitParams)bundle.getParcelable("walletFragmentInitParams");
        if (walletfragmentinitparams != null)
        {
            if (h != null)
            {
                Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
            }
            h = walletfragmentinitparams;
        }
        if (i == null)
        {
            i = (MaskedWalletRequest)bundle.getParcelable("maskedWalletRequest");
        }
        if (j == null)
        {
            j = (MaskedWallet)bundle.getParcelable("maskedWallet");
        }
        if (bundle.containsKey("walletFragmentOptions"))
        {
            g = (WalletFragmentOptions)bundle.getParcelable("walletFragmentOptions");
        }
        if (bundle.containsKey("enabled"))
        {
            k = Boolean.valueOf(bundle.getBoolean("enabled"));
        }
_L4:
        b = true;
        d.a(bundle);
        return;
_L2:
        if (f.getArguments() != null)
        {
            WalletFragmentOptions walletfragmentoptions = (WalletFragmentOptions)f.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletfragmentoptions != null)
            {
                walletfragmentoptions.a(f.getActivity());
                g = walletfragmentoptions;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return d.a(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        super.onDestroy();
        b = false;
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        if (g == null)
        {
            g = WalletFragmentOptions.a(activity, attributeset);
        }
        attributeset = new Bundle();
        attributeset.putParcelable("attrKeyWalletFragmentOptions", g);
        d.a(activity, attributeset, bundle);
    }

    public void onPause()
    {
        super.onPause();
        d.d();
    }

    public void onResume()
    {
        super.onResume();
        d.c();
        FragmentManager fragmentmanager = f.getActivity().getSupportFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag("GooglePlayServicesErrorDialog");
        if (fragment != null)
        {
            fragmentmanager.beginTransaction().remove(fragment).commit();
            pu.a(pu.a(f.getActivity()), f.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        d.b(bundle);
        if (h != null)
        {
            bundle.putParcelable("walletFragmentInitParams", h);
            h = null;
        }
        if (i != null)
        {
            bundle.putParcelable("maskedWalletRequest", i);
            i = null;
        }
        if (j != null)
        {
            bundle.putParcelable("maskedWallet", j);
            j = null;
        }
        if (g != null)
        {
            bundle.putParcelable("walletFragmentOptions", g);
            g = null;
        }
        if (k != null)
        {
            bundle.putBoolean("enabled", k.booleanValue());
            k = null;
        }
    }

    public void onStart()
    {
        super.onStart();
        d.b();
    }

    public void onStop()
    {
        super.onStop();
        d.e();
    }
}
