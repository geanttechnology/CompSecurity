// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import asv;
import asw;
import asx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import pu;
import ru;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentInitParams

public final class WalletFragment extends Fragment
{

    private asw a;
    private boolean b;
    private final ru c = ru.a(this);
    private final asx d = new asx(this);
    private asv e;
    private final Fragment f = this;
    private WalletFragmentOptions g;
    private WalletFragmentInitParams h;
    private MaskedWalletRequest i;
    private MaskedWallet j;
    private Boolean k;

    public WalletFragment()
    {
        b = false;
        e = new asv(this);
    }

    public static Fragment a(WalletFragment walletfragment)
    {
        return walletfragment.f;
    }

    public static asw a(WalletFragment walletfragment, asw asw1)
    {
        walletfragment.a = asw1;
        return asw1;
    }

    public static MaskedWallet a(WalletFragment walletfragment, MaskedWallet maskedwallet)
    {
        walletfragment.j = maskedwallet;
        return maskedwallet;
    }

    public static MaskedWalletRequest a(WalletFragment walletfragment, MaskedWalletRequest maskedwalletrequest)
    {
        walletfragment.i = maskedwalletrequest;
        return maskedwalletrequest;
    }

    public static WalletFragmentInitParams a(WalletFragment walletfragment, WalletFragmentInitParams walletfragmentinitparams)
    {
        walletfragment.h = walletfragmentinitparams;
        return walletfragmentinitparams;
    }

    public static WalletFragmentOptions a(WalletFragment walletfragment, WalletFragmentOptions walletfragmentoptions)
    {
        walletfragment.g = walletfragmentoptions;
        return walletfragmentoptions;
    }

    public static Boolean a(WalletFragment walletfragment, Boolean boolean1)
    {
        walletfragment.k = boolean1;
        return boolean1;
    }

    public static asw b(WalletFragment walletfragment)
    {
        return walletfragment.a;
    }

    public static boolean c(WalletFragment walletfragment)
    {
        return walletfragment.b;
    }

    public static ru d(WalletFragment walletfragment)
    {
        return walletfragment.c;
    }

    public static WalletFragmentOptions e(WalletFragment walletfragment)
    {
        return walletfragment.g;
    }

    public static asv f(WalletFragment walletfragment)
    {
        return walletfragment.e;
    }

    public static WalletFragmentInitParams g(WalletFragment walletfragment)
    {
        return walletfragment.h;
    }

    public static MaskedWalletRequest h(WalletFragment walletfragment)
    {
        return walletfragment.i;
    }

    public static MaskedWallet i(WalletFragment walletfragment)
    {
        return walletfragment.j;
    }

    public static Boolean j(WalletFragment walletfragment)
    {
        return walletfragment.k;
    }

    public void onActivityResult(int l, int i1, Intent intent)
    {
        super.onActivityResult(l, i1, intent);
        if (a != null)
        {
            asw.a(a, l, i1, intent);
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
                Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        FragmentManager fragmentmanager = f.getActivity().getFragmentManager();
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
