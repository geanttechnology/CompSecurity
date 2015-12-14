// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzri;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentInitParams, WalletFragmentStyle

public final class SupportWalletFragment extends Fragment
{
    public static interface OnStateChangedListener
    {

        public abstract void onStateChanged(SupportWalletFragment supportwalletfragment, int i, int j, Bundle bundle);
    }

    static class zza extends com.google.android.gms.internal.zzrb.zza
    {

        private OnStateChangedListener zzaXV;
        private final SupportWalletFragment zzaXW;

        public void zza(int i, int j, Bundle bundle)
        {
            if (zzaXV != null)
            {
                zzaXV.onStateChanged(zzaXW, i, j, bundle);
            }
        }

        public void zza(OnStateChangedListener onstatechangedlistener)
        {
            zzaXV = onstatechangedlistener;
        }

        zza(SupportWalletFragment supportwalletfragment)
        {
            zzaXW = supportwalletfragment;
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

        final SupportWalletFragment zzaXY;

        public void onClick(View view)
        {
            view = SupportWalletFragment.zza(zzaXY).getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(view), view, -1);
        }

        protected void zza(FrameLayout framelayout)
        {
            Button button = new Button(SupportWalletFragment.zza(zzaXY).getActivity());
            button.setText(com.google.android.gms.R.string.wallet_buy_button_place_holder);
            byte byte0 = -1;
            byte byte1 = -2;
            int j = byte1;
            int i = byte0;
            if (com.google.android.gms.wallet.fragment.SupportWalletFragment.zze(zzaXY) != null)
            {
                WalletFragmentStyle walletfragmentstyle = com.google.android.gms.wallet.fragment.SupportWalletFragment.zze(zzaXY).getFragmentStyle();
                j = byte1;
                i = byte0;
                if (walletfragmentstyle != null)
                {
                    android.util.DisplayMetrics displaymetrics = SupportWalletFragment.zza(zzaXY).getResources().getDisplayMetrics();
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
            Object obj = SupportWalletFragment.zza(zzaXY).getActivity();
            if (SupportWalletFragment.zzb(zzaXY) == null && SupportWalletFragment.zzc(zzaXY) && obj != null)
            {
                try
                {
                    obj = zzri.zza(((Activity) (obj)), SupportWalletFragment.zzd(zzaXY), com.google.android.gms.wallet.fragment.SupportWalletFragment.zze(zzaXY), com.google.android.gms.wallet.fragment.SupportWalletFragment.zzf(zzaXY));
                    SupportWalletFragment.zza(zzaXY, new zzb(((zzra) (obj))));
                    SupportWalletFragment.zza(zzaXY, null);
                }
                // Misplaced declaration of an exception variable
                catch (zzf zzf1)
                {
                    return;
                }
                zzf1.zza(SupportWalletFragment.zzb(zzaXY));
                if (SupportWalletFragment.zzg(zzaXY) != null)
                {
                    zzb.zza(SupportWalletFragment.zzb(zzaXY), SupportWalletFragment.zzg(zzaXY));
                    SupportWalletFragment.zza(zzaXY, null);
                }
                if (com.google.android.gms.wallet.fragment.SupportWalletFragment.zzh(zzaXY) != null)
                {
                    zzb.zza(SupportWalletFragment.zzb(zzaXY), com.google.android.gms.wallet.fragment.SupportWalletFragment.zzh(zzaXY));
                    SupportWalletFragment.zza(zzaXY, null);
                }
                if (SupportWalletFragment.zzi(zzaXY) != null)
                {
                    zzb.zza(SupportWalletFragment.zzb(zzaXY), SupportWalletFragment.zzi(zzaXY));
                    SupportWalletFragment.zza(zzaXY, null);
                }
                if (SupportWalletFragment.zzj(zzaXY) != null)
                {
                    zzb.zza(SupportWalletFragment.zzb(zzaXY), SupportWalletFragment.zzj(zzaXY).booleanValue());
                    SupportWalletFragment.zza(zzaXY, null);
                }
            }
        }

        private zzc()
        {
            zzaXY = SupportWalletFragment.this;
            super();
        }

    }


    private boolean mCreated;
    private zzb zzaXM;
    private final zzh zzaXN = com.google.android.gms.dynamic.zzh.zza(this);
    private final zzc zzaXO = new zzc();
    private zza zzaXP;
    private WalletFragmentOptions zzaXQ;
    private WalletFragmentInitParams zzaXR;
    private MaskedWalletRequest zzaXS;
    private MaskedWallet zzaXT;
    private Boolean zzaXU;
    private final Fragment zzadh = this;

    public SupportWalletFragment()
    {
        mCreated = false;
        zzaXP = new zza(this);
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions walletfragmentoptions)
    {
        SupportWalletFragment supportwalletfragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletfragmentoptions);
        supportwalletfragment.zzadh.setArguments(bundle);
        return supportwalletfragment;
    }

    static Fragment zza(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzadh;
    }

    static MaskedWallet zza(SupportWalletFragment supportwalletfragment, MaskedWallet maskedwallet)
    {
        supportwalletfragment.zzaXT = maskedwallet;
        return maskedwallet;
    }

    static MaskedWalletRequest zza(SupportWalletFragment supportwalletfragment, MaskedWalletRequest maskedwalletrequest)
    {
        supportwalletfragment.zzaXS = maskedwalletrequest;
        return maskedwalletrequest;
    }

    static zzb zza(SupportWalletFragment supportwalletfragment, zzb zzb1)
    {
        supportwalletfragment.zzaXM = zzb1;
        return zzb1;
    }

    static WalletFragmentInitParams zza(SupportWalletFragment supportwalletfragment, WalletFragmentInitParams walletfragmentinitparams)
    {
        supportwalletfragment.zzaXR = walletfragmentinitparams;
        return walletfragmentinitparams;
    }

    static WalletFragmentOptions zza(SupportWalletFragment supportwalletfragment, WalletFragmentOptions walletfragmentoptions)
    {
        supportwalletfragment.zzaXQ = walletfragmentoptions;
        return walletfragmentoptions;
    }

    static Boolean zza(SupportWalletFragment supportwalletfragment, Boolean boolean1)
    {
        supportwalletfragment.zzaXU = boolean1;
        return boolean1;
    }

    static zzb zzb(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXM;
    }

    static boolean zzc(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.mCreated;
    }

    static zzh zzd(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXN;
    }

    static WalletFragmentOptions zze(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXQ;
    }

    static zza zzf(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXP;
    }

    static WalletFragmentInitParams zzg(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXR;
    }

    static MaskedWalletRequest zzh(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXS;
    }

    static MaskedWallet zzi(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXT;
    }

    static Boolean zzj(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzaXU;
    }

    public int getState()
    {
        if (zzaXM != null)
        {
            return zzb.zza(zzaXM);
        } else
        {
            return 0;
        }
    }

    public void initialize(WalletFragmentInitParams walletfragmentinitparams)
    {
        if (zzaXM != null)
        {
            zzb.zza(zzaXM, walletfragmentinitparams);
            zzaXR = null;
        } else
        if (zzaXR == null)
        {
            zzaXR = walletfragmentinitparams;
            if (zzaXS != null)
            {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (zzaXT != null)
            {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
                return;
            }
        } else
        {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (zzaXM != null)
        {
            zzb.zza(zzaXM, i, j, intent);
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
                Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        zzaXO.onCreate(bundle);
        return;
_L2:
        if (zzadh.getArguments() != null)
        {
            WalletFragmentOptions walletfragmentoptions = (WalletFragmentOptions)zzadh.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletfragmentoptions != null)
            {
                walletfragmentoptions.zzaS(zzadh.getActivity());
                zzaXQ = walletfragmentoptions;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return zzaXO.onCreateView(layoutinflater, viewgroup, bundle);
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
        zzaXO.onInflate(activity, attributeset, bundle);
    }

    public void onPause()
    {
        super.onPause();
        zzaXO.onPause();
    }

    public void onResume()
    {
        super.onResume();
        zzaXO.onResume();
        FragmentManager fragmentmanager = zzadh.getActivity().getSupportFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag("GooglePlayServicesErrorDialog");
        if (fragment != null)
        {
            fragmentmanager.beginTransaction().remove(fragment).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzadh.getActivity()), zzadh.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        zzaXO.onSaveInstanceState(bundle);
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
        zzaXO.onStart();
    }

    public void onStop()
    {
        super.onStop();
        zzaXO.onStop();
    }

    public void setEnabled(boolean flag)
    {
        if (zzaXM != null)
        {
            zzb.zza(zzaXM, flag);
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
        zzaXP.zza(onstatechangedlistener);
    }

    public void updateMaskedWallet(MaskedWallet maskedwallet)
    {
        if (zzaXM != null)
        {
            zzb.zza(zzaXM, maskedwallet);
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
        if (zzaXM != null)
        {
            zzb.zza(zzaXM, maskedwalletrequest);
            zzaXS = null;
            return;
        } else
        {
            zzaXS = maskedwalletrequest;
            return;
        }
    }
}
