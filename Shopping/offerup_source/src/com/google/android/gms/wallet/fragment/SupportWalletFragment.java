// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.app.t;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentInitParams

public final class SupportWalletFragment extends Fragment
{

    private boolean mCreated;
    private final Fragment zzafl = this;
    private zzb zzbdU;
    private final zzh zzbdV = com.google.android.gms.dynamic.zzh.zza(this);
    private final zzc zzbdW = new zzc(null);
    private zza zzbdX;
    private WalletFragmentOptions zzbdY;
    private WalletFragmentInitParams zzbdZ;
    private MaskedWalletRequest zzbea;
    private MaskedWallet zzbeb;
    private Boolean zzbec;

    public SupportWalletFragment()
    {
        mCreated = false;
        zzbdX = new zza();
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions walletfragmentoptions)
    {
        SupportWalletFragment supportwalletfragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletfragmentoptions);
        supportwalletfragment.zzafl.setArguments(bundle);
        return supportwalletfragment;
    }

    static Fragment zza(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzafl;
    }

    static MaskedWallet zza(SupportWalletFragment supportwalletfragment, MaskedWallet maskedwallet)
    {
        supportwalletfragment.zzbeb = maskedwallet;
        return maskedwallet;
    }

    static MaskedWalletRequest zza(SupportWalletFragment supportwalletfragment, MaskedWalletRequest maskedwalletrequest)
    {
        supportwalletfragment.zzbea = maskedwalletrequest;
        return maskedwalletrequest;
    }

    static zzb zza(SupportWalletFragment supportwalletfragment, zzb zzb1)
    {
        supportwalletfragment.zzbdU = zzb1;
        return zzb1;
    }

    static WalletFragmentInitParams zza(SupportWalletFragment supportwalletfragment, WalletFragmentInitParams walletfragmentinitparams)
    {
        supportwalletfragment.zzbdZ = walletfragmentinitparams;
        return walletfragmentinitparams;
    }

    static WalletFragmentOptions zza(SupportWalletFragment supportwalletfragment, WalletFragmentOptions walletfragmentoptions)
    {
        supportwalletfragment.zzbdY = walletfragmentoptions;
        return walletfragmentoptions;
    }

    static Boolean zza(SupportWalletFragment supportwalletfragment, Boolean boolean1)
    {
        supportwalletfragment.zzbec = boolean1;
        return boolean1;
    }

    static zzb zzb(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbdU;
    }

    static boolean zzc(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.mCreated;
    }

    static zzh zzd(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbdV;
    }

    static WalletFragmentOptions zze(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbdY;
    }

    static zza zzf(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbdX;
    }

    static WalletFragmentInitParams zzg(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbdZ;
    }

    static MaskedWalletRequest zzh(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbea;
    }

    static MaskedWallet zzi(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbeb;
    }

    static Boolean zzj(SupportWalletFragment supportwalletfragment)
    {
        return supportwalletfragment.zzbec;
    }

    public final int getState()
    {
        if (zzbdU != null)
        {
            return com.google.android.gms.wallet.fragment.zzb.zza(zzbdU);
        } else
        {
            return 0;
        }
    }

    public final void initialize(WalletFragmentInitParams walletfragmentinitparams)
    {
        if (zzbdU != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbdU, walletfragmentinitparams);
            zzbdZ = null;
        } else
        if (zzbdZ == null)
        {
            zzbdZ = walletfragmentinitparams;
            if (zzbea != null)
            {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (zzbeb != null)
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

    public final void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (zzbdU != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbdU, i, j, intent);
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        WalletFragmentInitParams walletfragmentinitparams = (WalletFragmentInitParams)bundle.getParcelable("walletFragmentInitParams");
        if (walletfragmentinitparams != null)
        {
            if (zzbdZ != null)
            {
                Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
            }
            zzbdZ = walletfragmentinitparams;
        }
        if (zzbea == null)
        {
            zzbea = (MaskedWalletRequest)bundle.getParcelable("maskedWalletRequest");
        }
        if (zzbeb == null)
        {
            zzbeb = (MaskedWallet)bundle.getParcelable("maskedWallet");
        }
        if (bundle.containsKey("walletFragmentOptions"))
        {
            zzbdY = (WalletFragmentOptions)bundle.getParcelable("walletFragmentOptions");
        }
        if (bundle.containsKey("enabled"))
        {
            zzbec = Boolean.valueOf(bundle.getBoolean("enabled"));
        }
_L4:
        mCreated = true;
        zzbdW.onCreate(bundle);
        return;
_L2:
        if (zzafl.getArguments() != null)
        {
            WalletFragmentOptions walletfragmentoptions = (WalletFragmentOptions)zzafl.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletfragmentoptions != null)
            {
                walletfragmentoptions.zzaT(zzafl.getActivity());
                zzbdY = walletfragmentoptions;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return zzbdW.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        mCreated = false;
    }

    public final void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        if (zzbdY == null)
        {
            zzbdY = com.google.android.gms.wallet.fragment.WalletFragmentOptions.zza(activity, attributeset);
        }
        attributeset = new Bundle();
        attributeset.putParcelable("attrKeyWalletFragmentOptions", zzbdY);
        zzbdW.onInflate(activity, attributeset, bundle);
    }

    public final void onPause()
    {
        super.onPause();
        zzbdW.onPause();
    }

    public final void onResume()
    {
        super.onResume();
        zzbdW.onResume();
        aa aa1 = zzafl.getActivity().getSupportFragmentManager();
        Fragment fragment = aa1.a("GooglePlayServicesErrorDialog");
        if (fragment != null)
        {
            aa1.a().a(fragment).b();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzafl.getActivity()), zzafl.getActivity(), -1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        zzbdW.onSaveInstanceState(bundle);
        if (zzbdZ != null)
        {
            bundle.putParcelable("walletFragmentInitParams", zzbdZ);
            zzbdZ = null;
        }
        if (zzbea != null)
        {
            bundle.putParcelable("maskedWalletRequest", zzbea);
            zzbea = null;
        }
        if (zzbeb != null)
        {
            bundle.putParcelable("maskedWallet", zzbeb);
            zzbeb = null;
        }
        if (zzbdY != null)
        {
            bundle.putParcelable("walletFragmentOptions", zzbdY);
            zzbdY = null;
        }
        if (zzbec != null)
        {
            bundle.putBoolean("enabled", zzbec.booleanValue());
            zzbec = null;
        }
    }

    public final void onStart()
    {
        super.onStart();
        zzbdW.onStart();
    }

    public final void onStop()
    {
        super.onStop();
        zzbdW.onStop();
    }

    public final void setEnabled(boolean flag)
    {
        if (zzbdU != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbdU, flag);
            zzbec = null;
            return;
        } else
        {
            zzbec = Boolean.valueOf(flag);
            return;
        }
    }

    public final void setOnStateChangedListener(OnStateChangedListener onstatechangedlistener)
    {
        zzbdX.zza(onstatechangedlistener);
    }

    public final void updateMaskedWallet(MaskedWallet maskedwallet)
    {
        if (zzbdU != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbdU, maskedwallet);
            zzbeb = null;
            return;
        } else
        {
            zzbeb = maskedwallet;
            return;
        }
    }

    public final void updateMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
    {
        if (zzbdU != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbdU, maskedwalletrequest);
            zzbea = null;
            return;
        } else
        {
            zzbea = maskedwalletrequest;
            return;
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza
        implements android.view.View.OnClickListener
    {

        final SupportWalletFragment zzbeg;

        public void onClick(View view)
        {
            view = com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg).getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(view), view, -1);
        }

        protected void zza(FrameLayout framelayout)
        {
            byte byte0 = -1;
            byte byte1 = -2;
            Button button = new Button(com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg).getActivity());
            button.setText(com.google.android.gms.R.string.wallet_buy_button_place_holder);
            int j = byte1;
            int i = byte0;
            if (com.google.android.gms.wallet.fragment.SupportWalletFragment.zze(zzbeg) != null)
            {
                WalletFragmentStyle walletfragmentstyle = com.google.android.gms.wallet.fragment.SupportWalletFragment.zze(zzbeg).getFragmentStyle();
                j = byte1;
                i = byte0;
                if (walletfragmentstyle != null)
                {
                    android.util.DisplayMetrics displaymetrics = com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg).getResources().getDisplayMetrics();
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
            Object obj = com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg).getActivity();
            if (SupportWalletFragment.zzb(zzbeg) == null && SupportWalletFragment.zzc(zzbeg) && obj != null)
            {
                try
                {
                    obj = zzrp.zza(((Activity) (obj)), SupportWalletFragment.zzd(zzbeg), com.google.android.gms.wallet.fragment.SupportWalletFragment.zze(zzbeg), com.google.android.gms.wallet.fragment.SupportWalletFragment.zzf(zzbeg));
                    com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg, new zzb(((zzrh) (obj)), null));
                    com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg, null);
                }
                // Misplaced declaration of an exception variable
                catch (zzf zzf1)
                {
                    return;
                }
                zzf1.zza(SupportWalletFragment.zzb(zzbeg));
                if (SupportWalletFragment.zzg(zzbeg) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(SupportWalletFragment.zzb(zzbeg), SupportWalletFragment.zzg(zzbeg));
                    com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg, null);
                }
                if (com.google.android.gms.wallet.fragment.SupportWalletFragment.zzh(zzbeg) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(SupportWalletFragment.zzb(zzbeg), com.google.android.gms.wallet.fragment.SupportWalletFragment.zzh(zzbeg));
                    com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg, null);
                }
                if (SupportWalletFragment.zzi(zzbeg) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(SupportWalletFragment.zzb(zzbeg), SupportWalletFragment.zzi(zzbeg));
                    com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg, null);
                }
                if (SupportWalletFragment.zzj(zzbeg) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(SupportWalletFragment.zzb(zzbeg), SupportWalletFragment.zzj(zzbeg).booleanValue());
                    com.google.android.gms.wallet.fragment.SupportWalletFragment.zza(zzbeg, null);
                }
            }
        }

        private zzc()
        {
            zzbeg = SupportWalletFragment.this;
            super();
        }

        zzc(_cls1 _pcls1)
        {
            this();
        }
    }


    private class zza extends com.google.android.gms.internal.zzri.zza
    {

        private OnStateChangedListener zzbed;
        private final SupportWalletFragment zzbee;

        public void zza(int i, int j, Bundle bundle)
        {
            if (zzbed != null)
            {
                zzbed.onStateChanged(zzbee, i, j, bundle);
            }
        }

        public void zza(OnStateChangedListener onstatechangedlistener)
        {
            zzbed = onstatechangedlistener;
        }

        zza()
        {
            zzbee = SupportWalletFragment.this;
        }

        private class OnStateChangedListener
        {

            public abstract void onStateChanged(SupportWalletFragment supportwalletfragment, int i, int j, Bundle bundle);
        }

    }


    private class zzb
        implements LifecycleDelegate
    {

        private final zzrh zzbef;

        private int getState()
        {
            int i;
            try
            {
                i = zzbef.getState();
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
                zzbef.initialize(walletfragmentinitparams);
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
                zzbef.onActivityResult(i, j, intent);
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
                zzbef.setEnabled(flag);
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
                zzbef.updateMaskedWallet(maskedwallet);
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
                zzbef.updateMaskedWalletRequest(maskedwalletrequest);
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
                zzbef.onCreate(bundle);
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
                layoutinflater = (View)com.google.android.gms.dynamic.zze.zzp(zzbef.onCreateView(com.google.android.gms.dynamic.zze.zzy(layoutinflater), com.google.android.gms.dynamic.zze.zzy(viewgroup), bundle));
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
                zzbef.zza(com.google.android.gms.dynamic.zze.zzy(activity), bundle, bundle1);
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
                zzbef.onPause();
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
                zzbef.onResume();
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
                zzbef.onSaveInstanceState(bundle);
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
                zzbef.onStart();
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
                zzbef.onStop();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private zzb(zzrh zzrh1)
        {
            zzbef = zzrh1;
        }

        zzb(zzrh zzrh1, _cls1 _pcls1)
        {
            this(zzrh1);
        }
    }

}
