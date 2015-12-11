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
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzb;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentInitParams

public final class WalletFragment extends Fragment
{

    private boolean mCreated;
    private final Fragment zzapz = this;
    private WalletFragmentOptions zzbdY;
    private WalletFragmentInitParams zzbdZ;
    private MaskedWalletRequest zzbea;
    private MaskedWallet zzbeb;
    private Boolean zzbec;
    private zzb zzbeh;
    private final com.google.android.gms.dynamic.zzb zzbei = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzbej = new zzc(null);
    private zza zzbek;

    public WalletFragment()
    {
        mCreated = false;
        zzbek = new zza();
    }

    public static WalletFragment newInstance(WalletFragmentOptions walletfragmentoptions)
    {
        WalletFragment walletfragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletfragmentoptions);
        walletfragment.zzapz.setArguments(bundle);
        return walletfragment;
    }

    static Fragment zza(WalletFragment walletfragment)
    {
        return walletfragment.zzapz;
    }

    static MaskedWallet zza(WalletFragment walletfragment, MaskedWallet maskedwallet)
    {
        walletfragment.zzbeb = maskedwallet;
        return maskedwallet;
    }

    static MaskedWalletRequest zza(WalletFragment walletfragment, MaskedWalletRequest maskedwalletrequest)
    {
        walletfragment.zzbea = maskedwalletrequest;
        return maskedwalletrequest;
    }

    static zzb zza(WalletFragment walletfragment, zzb zzb1)
    {
        walletfragment.zzbeh = zzb1;
        return zzb1;
    }

    static WalletFragmentInitParams zza(WalletFragment walletfragment, WalletFragmentInitParams walletfragmentinitparams)
    {
        walletfragment.zzbdZ = walletfragmentinitparams;
        return walletfragmentinitparams;
    }

    static WalletFragmentOptions zza(WalletFragment walletfragment, WalletFragmentOptions walletfragmentoptions)
    {
        walletfragment.zzbdY = walletfragmentoptions;
        return walletfragmentoptions;
    }

    static Boolean zza(WalletFragment walletfragment, Boolean boolean1)
    {
        walletfragment.zzbec = boolean1;
        return boolean1;
    }

    static zzb zzb(WalletFragment walletfragment)
    {
        return walletfragment.zzbeh;
    }

    static boolean zzc(WalletFragment walletfragment)
    {
        return walletfragment.mCreated;
    }

    static zzb zzd(WalletFragment walletfragment)
    {
        return walletfragment.zzbei;
    }

    static WalletFragmentOptions zze(WalletFragment walletfragment)
    {
        return walletfragment.zzbdY;
    }

    static zza zzf(WalletFragment walletfragment)
    {
        return walletfragment.zzbek;
    }

    static WalletFragmentInitParams zzg(WalletFragment walletfragment)
    {
        return walletfragment.zzbdZ;
    }

    static MaskedWalletRequest zzh(WalletFragment walletfragment)
    {
        return walletfragment.zzbea;
    }

    static MaskedWallet zzi(WalletFragment walletfragment)
    {
        return walletfragment.zzbeb;
    }

    static Boolean zzj(WalletFragment walletfragment)
    {
        return walletfragment.zzbec;
    }

    public final int getState()
    {
        if (zzbeh != null)
        {
            return com.google.android.gms.wallet.fragment.zzb.zza(zzbeh);
        } else
        {
            return 0;
        }
    }

    public final void initialize(WalletFragmentInitParams walletfragmentinitparams)
    {
        if (zzbeh != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbeh, walletfragmentinitparams);
            zzbdZ = null;
        } else
        if (zzbdZ == null)
        {
            zzbdZ = walletfragmentinitparams;
            if (zzbea != null)
            {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (zzbeb != null)
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

    public final void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (zzbeh != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbeh, i, j, intent);
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
                Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        zzbej.onCreate(bundle);
        return;
_L2:
        if (zzapz.getArguments() != null)
        {
            WalletFragmentOptions walletfragmentoptions = (WalletFragmentOptions)zzapz.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletfragmentoptions != null)
            {
                walletfragmentoptions.zzaT(zzapz.getActivity());
                zzbdY = walletfragmentoptions;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return zzbej.onCreateView(layoutinflater, viewgroup, bundle);
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
        zzbej.onInflate(activity, attributeset, bundle);
    }

    public final void onPause()
    {
        super.onPause();
        zzbej.onPause();
    }

    public final void onResume()
    {
        super.onResume();
        zzbej.onResume();
        FragmentManager fragmentmanager = zzapz.getActivity().getFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag("GooglePlayServicesErrorDialog");
        if (fragment != null)
        {
            fragmentmanager.beginTransaction().remove(fragment).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzapz.getActivity()), zzapz.getActivity(), -1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        zzbej.onSaveInstanceState(bundle);
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
        zzbej.onStart();
    }

    public final void onStop()
    {
        super.onStop();
        zzbej.onStop();
    }

    public final void setEnabled(boolean flag)
    {
        if (zzbeh != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbeh, flag);
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
        zzbek.zza(onstatechangedlistener);
    }

    public final void updateMaskedWallet(MaskedWallet maskedwallet)
    {
        if (zzbeh != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbeh, maskedwallet);
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
        if (zzbeh != null)
        {
            com.google.android.gms.wallet.fragment.zzb.zza(zzbeh, maskedwalletrequest);
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

        final WalletFragment zzben;

        public void onClick(View view)
        {
            view = com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben).getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(view), view, -1);
        }

        protected void zza(FrameLayout framelayout)
        {
            byte byte0 = -1;
            byte byte1 = -2;
            Button button = new Button(com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben).getActivity());
            button.setText(com.google.android.gms.R.string.wallet_buy_button_place_holder);
            int j = byte1;
            int i = byte0;
            if (com.google.android.gms.wallet.fragment.WalletFragment.zze(zzben) != null)
            {
                WalletFragmentStyle walletfragmentstyle = com.google.android.gms.wallet.fragment.WalletFragment.zze(zzben).getFragmentStyle();
                j = byte1;
                i = byte0;
                if (walletfragmentstyle != null)
                {
                    android.util.DisplayMetrics displaymetrics = com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben).getResources().getDisplayMetrics();
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
            Object obj = com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben).getActivity();
            if (com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzben) == null && WalletFragment.zzc(zzben) && obj != null)
            {
                try
                {
                    obj = zzrp.zza(((Activity) (obj)), WalletFragment.zzd(zzben), com.google.android.gms.wallet.fragment.WalletFragment.zze(zzben), com.google.android.gms.wallet.fragment.WalletFragment.zzf(zzben));
                    com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben, new zzb(((zzrh) (obj)), null));
                    com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben, null);
                }
                // Misplaced declaration of an exception variable
                catch (zzf zzf1)
                {
                    return;
                }
                zzf1.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzben));
                if (WalletFragment.zzg(zzben) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzben), WalletFragment.zzg(zzben));
                    com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben, null);
                }
                if (WalletFragment.zzh(zzben) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzben), WalletFragment.zzh(zzben));
                    com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben, null);
                }
                if (WalletFragment.zzi(zzben) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzben), WalletFragment.zzi(zzben));
                    com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben, null);
                }
                if (WalletFragment.zzj(zzben) != null)
                {
                    com.google.android.gms.wallet.fragment.zzb.zza(com.google.android.gms.wallet.fragment.WalletFragment.zzb(zzben), WalletFragment.zzj(zzben).booleanValue());
                    com.google.android.gms.wallet.fragment.WalletFragment.zza(zzben, null);
                }
            }
        }

        private zzc()
        {
            zzben = WalletFragment.this;
            super();
        }

        zzc(_cls1 _pcls1)
        {
            this();
        }
    }


    private class zza extends com.google.android.gms.internal.zzri.zza
    {

        private OnStateChangedListener zzbel;
        private final WalletFragment zzbem;

        public void zza(int i, int j, Bundle bundle)
        {
            if (zzbel != null)
            {
                zzbel.onStateChanged(zzbem, i, j, bundle);
            }
        }

        public void zza(OnStateChangedListener onstatechangedlistener)
        {
            zzbel = onstatechangedlistener;
        }

        zza()
        {
            zzbem = WalletFragment.this;
        }

        private class OnStateChangedListener
        {

            public abstract void onStateChanged(WalletFragment walletfragment, int i, int j, Bundle bundle);
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
