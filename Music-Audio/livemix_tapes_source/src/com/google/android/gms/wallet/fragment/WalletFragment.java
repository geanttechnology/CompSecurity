// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzri;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentInitParams, WalletFragmentStyle

public final class WalletFragment extends Fragment
{
    public static interface OnStateChangedListener
    {

        public abstract void onStateChanged(WalletFragment walletfragment, int i, int j, Bundle bundle);
    }

    static class zza extends com.google.android.gms.internal.zzrb.zza
    {

        private OnStateChangedListener zzaYd;
        private final WalletFragment zzaYe;

        public void zza(int i, int j, Bundle bundle)
        {
            if (zzaYd != null)
            {
                zzaYd.onStateChanged(zzaYe, i, j, bundle);
            }
        }

        public void zza(OnStateChangedListener onstatechangedlistener)
        {
            zzaYd = onstatechangedlistener;
        }

        zza(WalletFragment walletfragment)
        {
            zzaYe = walletfragment;
        }
    }

    private static class zzb
        implements LifecycleDelegate
    {

        private final zzra zzaXX;

        private int getState()
        {
            int i;
            try
            {
                i = zzaXX.getState();
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
            return i;
        }

        private void initialize(WalletFragmentInitParams walletfragmentinitparams)
        {
            try
            {
                zzaXX.initialize(walletfragmentinitparams);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WalletFragmentInitParams walletfragmentinitparams)
            {
                throw new RuntimeException(walletfragmentinitparams);
            }
        }

        private void onActivityResult(int i, int j, Intent intent)
        {
            try
            {
                zzaXX.onActivityResult(i, j, intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                throw new RuntimeException(intent);
            }
        }

        private void setEnabled(boolean flag)
        {
            try
            {
                zzaXX.setEnabled(flag);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedwallet)
        {
            try
            {
                zzaXX.updateMaskedWallet(maskedwallet);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MaskedWallet maskedwallet)
            {
                throw new RuntimeException(maskedwallet);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
        {
            try
            {
                zzaXX.updateMaskedWalletRequest(maskedwalletrequest);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MaskedWalletRequest maskedwalletrequest)
            {
                throw new RuntimeException(maskedwalletrequest);
            }
        }

        static int zza(zzb zzb1)
        {
            return zzb1.getState();
        }

        static void zza(zzb zzb1, int i, int j, Intent intent)
        {
            zzb1.onActivityResult(i, j, intent);
        }

        static void zza(zzb zzb1, MaskedWallet maskedwallet)
        {
            zzb1.updateMaskedWallet(maskedwallet);
        }

        static void zza(zzb zzb1, MaskedWalletRequest maskedwalletrequest)
        {
            zzb1.updateMaskedWalletRequest(maskedwalletrequest);
        }

        static void zza(zzb zzb1, WalletFragmentInitParams walletfragmentinitparams)
        {
            zzb1.initialize(walletfragmentinitparams);
        }

        static void zza(zzb zzb1, boolean flag)
        {
            zzb1.setEnabled(flag);
        }

        public void onCreate(Bundle bundle)
        {
            try
            {
                zzaXX.onCreate(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeException(bundle);
            }
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            try
            {
                layoutinflater = (View)com.google.android.gms.dynamic.zze.zzp(zzaXX.onCreateView(com.google.android.gms.dynamic.zze.zzx(layoutinflater), com.google.android.gms.dynamic.zze.zzx(viewgroup), bundle));
            }
            // Misplaced declaration of an exception variable
            catch (LayoutInflater layoutinflater)
            {
                throw new RuntimeException(layoutinflater);
            }
            return layoutinflater;
        }

        public void onDestroy()
        {
        }

        public void onDestroyView()
        {
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            bundle = (WalletFragmentOptions)bundle.getParcelable("extraWalletFragmentOptions");
            try
            {
                zzaXX.zza(com.google.android.gms.dynamic.zze.zzx(activity), bundle, bundle1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                throw new RuntimeException(activity);
            }
        }

        public void onLowMemory()
        {
        }

        public void onPause()
        {
            try
            {
                zzaXX.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onResume()
        {
            try
            {
                zzaXX.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            try
            {
                zzaXX.onSaveInstanceState(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeException(bundle);
            }
        }

        public void onStart()
        {
            try
            {
                zzaXX.onStart();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onStop()
        {
            try
            {
                zzaXX.onStop();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private zzb(zzra zzra1)
        {
            zzaXX = zzra1;
        }

    }

    private class zzc extends com.google.android.gms.dynamic.zza
        implements android.view.View.OnClickListener
    {

        final WalletFragment zzaYf;

        public void onClick(View view)
        {
            view = WalletFragment.zza(zzaYf).getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(view), view, -1);
        }

        protected void zza(FrameLayout framelayout)
        {
            Button button = new Button(WalletFragment.zza(zzaYf).getActivity());
            button.setText(com.google.android.gms.R.string.wallet_buy_button_place_holder);
            byte byte0 = -1;
            byte byte1 = -2;
            int j = byte1;
            int i = byte0;
            if (com.google.android.gms.wallet.fragment.WalletFragment.zze(zzaYf) != null)
            {
                WalletFragmentStyle walletfragmentstyle = com.google.android.gms.wallet.fragment.WalletFragment.zze(zzaYf).getFragmentStyle();
                j = byte1;
                i = byte0;
                if (walletfragmentstyle != null)
                {
                    android.util.DisplayMetrics displaymetrics = WalletFragment.zza(zzaYf).getResources().getDisplayMetrics();
                    i = walletfragmentstyle.zza("buyButtonWidth", displaymetrics, -1);
                    j = walletfragmentstyle.zza("buyButtonHeight", displaymetrics, -2);
                }
            }
            button.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, j));
            button.setOnClickListener(this);
            framelayout.addView(button);
        }

        protected void zza(zzf zzf1)
        {
            Object obj = WalletFragment.zza(zzaYf).getActivity();
            if (com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzaYf) == null && WalletFragment.zzc(zzaYf) && obj != null)
            {
                try
                {
                    obj = zzri.zza(((Activity) (obj)), WalletFragment.zzd(zzaYf), com.google.android.gms.wallet.fragment.WalletFragment.zze(zzaYf), com.google.android.gms.wallet.fragment.WalletFragment.zzf(zzaYf));
                    WalletFragment.zza(zzaYf, new zzb(((zzra) (obj))));
                    WalletFragment.zza(zzaYf, null);
                }
                // Misplaced declaration of an exception variable
                catch (zzf zzf1)
                {
                    return;
                }
                zzf1.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzaYf));
                if (WalletFragment.zzg(zzaYf) != null)
                {
                    zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzaYf), WalletFragment.zzg(zzaYf));
                    WalletFragment.zza(zzaYf, null);
                }
                if (WalletFragment.zzh(zzaYf) != null)
                {
                    zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzaYf), WalletFragment.zzh(zzaYf));
                    WalletFragment.zza(zzaYf, null);
                }
                if (WalletFragment.zzi(zzaYf) != null)
                {
                    zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzaYf), WalletFragment.zzi(zzaYf));
                    WalletFragment.zza(zzaYf, null);
                }
                if (WalletFragment.zzj(zzaYf) != null)
                {
                    zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzaYf), WalletFragment.zzj(zzaYf).booleanValue());
                    WalletFragment.zza(zzaYf, null);
                }
            }
        }

        private zzc()
        {
            zzaYf = WalletFragment.this;
            super();
        }

    }


    private boolean mCreated;
    private WalletFragmentOptions zzaXQ;
    private WalletFragmentInitParams zzaXR;
    private MaskedWalletRequest zzaXS;
    private MaskedWallet zzaXT;
    private Boolean zzaXU;
    private zzb zzaXZ;
    private final com.google.android.gms.dynamic.zzb zzaYa = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzaYb = new zzc();
    private zza zzaYc;
    private final Fragment zzamZ = this;

    public WalletFragment()
    {
        mCreated = false;
        zzaYc = new zza(this);
    }

    public static WalletFragment newInstance(WalletFragmentOptions walletfragmentoptions)
    {
        WalletFragment walletfragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletfragmentoptions);
        walletfragment.zzamZ.setArguments(bundle);
        return walletfragment;
    }

    static Fragment zza(WalletFragment walletfragment)
    {
        return walletfragment.zzamZ;
    }

    static MaskedWallet zza(WalletFragment walletfragment, MaskedWallet maskedwallet)
    {
        walletfragment.zzaXT = maskedwallet;
        return maskedwallet;
    }

    static MaskedWalletRequest zza(WalletFragment walletfragment, MaskedWalletRequest maskedwalletrequest)
    {
        walletfragment.zzaXS = maskedwalletrequest;
        return maskedwalletrequest;
    }

    static zzb zza(WalletFragment walletfragment, zzb zzb1)
    {
        walletfragment.zzaXZ = zzb1;
        return zzb1;
    }

    static WalletFragmentInitParams zza(WalletFragment walletfragment, WalletFragmentInitParams walletfragmentinitparams)
    {
        walletfragment.zzaXR = walletfragmentinitparams;
        return walletfragmentinitparams;
    }

    static WalletFragmentOptions zza(WalletFragment walletfragment, WalletFragmentOptions walletfragmentoptions)
    {
        walletfragment.zzaXQ = walletfragmentoptions;
        return walletfragmentoptions;
    }

    static Boolean zza(WalletFragment walletfragment, Boolean boolean1)
    {
        walletfragment.zzaXU = boolean1;
        return boolean1;
    }

    static zzb zzb(WalletFragment walletfragment)
    {
        return walletfragment.zzaXZ;
    }

    static boolean zzc(WalletFragment walletfragment)
    {
        return walletfragment.mCreated;
    }

    static com.google.android.gms.dynamic.zzb zzd(WalletFragment walletfragment)
    {
        return walletfragment.zzaYa;
    }

    static WalletFragmentOptions zze(WalletFragment walletfragment)
    {
        return walletfragment.zzaXQ;
    }

    static zza zzf(WalletFragment walletfragment)
    {
        return walletfragment.zzaYc;
    }

    static WalletFragmentInitParams zzg(WalletFragment walletfragment)
    {
        return walletfragment.zzaXR;
    }

    static MaskedWalletRequest zzh(WalletFragment walletfragment)
    {
        return walletfragment.zzaXS;
    }

    static MaskedWallet zzi(WalletFragment walletfragment)
    {
        return walletfragment.zzaXT;
    }

    static Boolean zzj(WalletFragment walletfragment)
    {
        return walletfragment.zzaXU;
    }

    public int getState()
    {
        if (zzaXZ != null)
        {
            return zzb.zza(zzaXZ);
        } else
        {
            return 0;
        }
    }

    public void initialize(WalletFragmentInitParams walletfragmentinitparams)
    {
        if (zzaXZ != null)
        {
            zzb.zza(zzaXZ, walletfragmentinitparams);
            zzaXR = null;
        } else
        if (zzaXR == null)
        {
            zzaXR = walletfragmentinitparams;
            if (zzaXS != null)
            {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (zzaXT != null)
            {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
                return;
            }
        } else
        {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (zzaXZ != null)
        {
            zzb.zza(zzaXZ, i, j, intent);
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
            if (zzaXR != null)
            {
                Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
            }
            zzaXR = walletfragmentinitparams;
        }
        if (zzaXS == null)
        {
            zzaXS = (MaskedWalletRequest)bundle.getParcelable("maskedWalletRequest");
        }
        if (zzaXT == null)
        {
            zzaXT = (MaskedWallet)bundle.getParcelable("maskedWallet");
        }
        if (bundle.containsKey("walletFragmentOptions"))
        {
            zzaXQ = (WalletFragmentOptions)bundle.getParcelable("walletFragmentOptions");
        }
        if (bundle.containsKey("enabled"))
        {
            zzaXU = Boolean.valueOf(bundle.getBoolean("enabled"));
        }
_L4:
        mCreated = true;
        zzaYb.onCreate(bundle);
        return;
_L2:
        if (zzamZ.getArguments() != null)
        {
            WalletFragmentOptions walletfragmentoptions = (WalletFragmentOptions)zzamZ.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletfragmentoptions != null)
            {
                walletfragmentoptions.zzaS(zzamZ.getActivity());
                zzaXQ = walletfragmentoptions;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return zzaYb.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        super.onDestroy();
        mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        if (zzaXQ == null)
        {
            zzaXQ = WalletFragmentOptions.zza(activity, attributeset);
        }
        attributeset = new Bundle();
        attributeset.putParcelable("attrKeyWalletFragmentOptions", zzaXQ);
        zzaYb.onInflate(activity, attributeset, bundle);
    }

    public void onPause()
    {
        super.onPause();
        zzaYb.onPause();
    }

    public void onResume()
    {
        super.onResume();
        zzaYb.onResume();
        FragmentManager fragmentmanager = zzamZ.getActivity().getFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag("GooglePlayServicesErrorDialog");
        if (fragment != null)
        {
            fragmentmanager.beginTransaction().remove(fragment).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzamZ.getActivity()), zzamZ.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        zzaYb.onSaveInstanceState(bundle);
        if (zzaXR != null)
        {
            bundle.putParcelable("walletFragmentInitParams", zzaXR);
            zzaXR = null;
        }
        if (zzaXS != null)
        {
            bundle.putParcelable("maskedWalletRequest", zzaXS);
            zzaXS = null;
        }
        if (zzaXT != null)
        {
            bundle.putParcelable("maskedWallet", zzaXT);
            zzaXT = null;
        }
        if (zzaXQ != null)
        {
            bundle.putParcelable("walletFragmentOptions", zzaXQ);
            zzaXQ = null;
        }
        if (zzaXU != null)
        {
            bundle.putBoolean("enabled", zzaXU.booleanValue());
            zzaXU = null;
        }
    }

    public void onStart()
    {
        super.onStart();
        zzaYb.onStart();
    }

    public void onStop()
    {
        super.onStop();
        zzaYb.onStop();
    }

    public void setEnabled(boolean flag)
    {
        if (zzaXZ != null)
        {
            zzb.zza(zzaXZ, flag);
            zzaXU = null;
            return;
        } else
        {
            zzaXU = Boolean.valueOf(flag);
            return;
        }
    }

    public void setOnStateChangedListener(OnStateChangedListener onstatechangedlistener)
    {
        zzaYc.zza(onstatechangedlistener);
    }

    public void updateMaskedWallet(MaskedWallet maskedwallet)
    {
        if (zzaXZ != null)
        {
            zzb.zza(zzaXZ, maskedwallet);
            zzaXT = null;
            return;
        } else
        {
            zzaXT = maskedwallet;
            return;
        }
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
    {
        if (zzaXZ != null)
        {
            zzb.zza(zzaXZ, maskedwalletrequest);
            zzaXS = null;
            return;
        } else
        {
            zzaXS = maskedwalletrequest;
            return;
        }
    }
}
