// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            SupportWalletFragment, WalletFragmentOptions, WalletFragmentInitParams

private static class <init>
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

    static int zza(zzaXX zzaxx)
    {
        return zzaxx.getState();
    }

    static void zza(getState getstate, int i, int j, Intent intent)
    {
        getstate.onActivityResult(i, j, intent);
    }

    static void zza(onActivityResult onactivityresult, MaskedWallet maskedwallet)
    {
        onactivityresult.updateMaskedWallet(maskedwallet);
    }

    static void zza(updateMaskedWallet updatemaskedwallet, MaskedWalletRequest maskedwalletrequest)
    {
        updatemaskedwallet.updateMaskedWalletRequest(maskedwalletrequest);
    }

    static void zza(updateMaskedWalletRequest updatemaskedwalletrequest, WalletFragmentInitParams walletfragmentinitparams)
    {
        updatemaskedwalletrequest.initialize(walletfragmentinitparams);
    }

    static void zza(initialize initialize1, boolean flag)
    {
        initialize1.setEnabled(flag);
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
            layoutinflater = (View)zze.zzp(zzaXX.onCreateView(zze.zzx(layoutinflater), zze.zzx(viewgroup), bundle));
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
            zzaXX.zza(zze.zzx(activity), bundle, bundle1);
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

    private (zzra zzra1)
    {
        zzaXX = zzra1;
    }

    zzaXX(zzra zzra1, zzaXX zzaxx)
    {
        this(zzra1);
    }
}
