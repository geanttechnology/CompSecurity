// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

// Referenced classes of package com.google.android.gms.internal:
//            dw, ec, is

public class iu extends dw
{
    final class a extends it.a
    {

        final iu Hl;
        private final int oZ;

        public void a(int i, FullWallet fullwallet, Bundle bundle)
        {
            PendingIntent pendingintent = null;
            if (bundle != null)
            {
                pendingintent = (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            bundle = new ConnectionResult(i, pendingintent);
            if (bundle.hasResolution())
            {
                try
                {
                    bundle.startResolutionForResult(iu.b(Hl), oZ);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (FullWallet fullwallet)
                {
                    Log.w("WalletClientImpl", "Exception starting pending intent", fullwallet);
                }
                return;
            }
            byte byte0;
            if (bundle.isSuccess())
            {
                byte0 = -1;
                bundle = new Intent();
                bundle.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", fullwallet);
                fullwallet = bundle;
            } else
            {
                if (i == 408)
                {
                    byte0 = 0;
                } else
                {
                    byte0 = 1;
                }
                fullwallet = new Intent();
                fullwallet.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", i);
            }
            fullwallet = iu.b(Hl).createPendingResult(oZ, fullwallet, 0x40000000);
            if (fullwallet == null)
            {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try
            {
                fullwallet.send(byte0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (FullWallet fullwallet)
            {
                Log.w("WalletClientImpl", "Exception setting pending result", fullwallet);
            }
        }

        public void a(int i, MaskedWallet maskedwallet, Bundle bundle)
        {
            PendingIntent pendingintent = null;
            if (bundle != null)
            {
                pendingintent = (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            bundle = new ConnectionResult(i, pendingintent);
            if (bundle.hasResolution())
            {
                try
                {
                    bundle.startResolutionForResult(iu.b(Hl), oZ);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (MaskedWallet maskedwallet)
                {
                    Log.w("WalletClientImpl", "Exception starting pending intent", maskedwallet);
                }
                return;
            }
            byte byte0;
            if (bundle.isSuccess())
            {
                byte0 = -1;
                bundle = new Intent();
                bundle.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", maskedwallet);
                maskedwallet = bundle;
            } else
            {
                if (i == 408)
                {
                    byte0 = 0;
                } else
                {
                    byte0 = 1;
                }
                maskedwallet = new Intent();
                maskedwallet.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", i);
            }
            maskedwallet = iu.b(Hl).createPendingResult(oZ, maskedwallet, 0x40000000);
            if (maskedwallet == null)
            {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try
            {
                maskedwallet.send(byte0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MaskedWallet maskedwallet)
            {
                Log.w("WalletClientImpl", "Exception setting pending result", maskedwallet);
            }
        }

        public void a(int i, boolean flag, Bundle bundle)
        {
            bundle = new Intent();
            bundle.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", flag);
            bundle = iu.b(Hl).createPendingResult(oZ, bundle, 0x40000000);
            if (bundle == null)
            {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try
            {
                bundle.send(-1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.w("WalletClientImpl", "Exception setting pending result", bundle);
            }
        }

        public a(int i)
        {
            Hl = iu.this;
            super();
            oZ = i;
        }
    }


    private final int Hi;
    private final Activity gs;
    private final String jG;
    private final int mTheme;

    public iu(Activity activity, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, int i, String s, int j)
    {
        this(activity, ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new dw.c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new dw.g(onconnectionfailedlistener))), i, s, j);
    }

    public iu(Activity activity, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, int i, String s, int j)
    {
        super(activity, connectioncallbacks, onconnectionfailedlistener, new String[0]);
        gs = activity;
        Hi = i;
        jG = s;
        mTheme = j;
    }

    static Activity b(iu iu1)
    {
        return iu1.gs;
    }

    private Bundle fT()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", Hi);
        bundle.putString("androidPackageName", gs.getPackageName());
        if (!TextUtils.isEmpty(jG))
        {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(jG, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", mTheme);
        return bundle;
    }

    protected void a(ec ec1, dw.e e)
        throws RemoteException
    {
        ec1.a(e, 0x40ba50);
    }

    protected is aB(IBinder ibinder)
    {
        return is.a.az(ibinder);
    }

    protected String am()
    {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String an()
    {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void changeMaskedWallet(String s, String s1, int i)
    {
        Bundle bundle = fT();
        a a1 = new a(i);
        try
        {
            ((is)bQ()).a(s, s1, bundle, a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", s);
        }
        a1.a(8, null, null);
    }

    public void checkForPreAuthorization(int i)
    {
        Bundle bundle = fT();
        a a1 = new a(i);
        try
        {
            ((is)bQ()).a(bundle, a1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", remoteexception);
        }
        a1.a(8, false, null);
    }

    public void loadFullWallet(FullWalletRequest fullwalletrequest, int i)
    {
        a a1 = new a(i);
        Bundle bundle = fT();
        try
        {
            ((is)bQ()).a(fullwalletrequest, bundle, a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FullWalletRequest fullwalletrequest)
        {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", fullwalletrequest);
        }
        a1.a(8, null, null);
    }

    public void loadMaskedWallet(MaskedWalletRequest maskedwalletrequest, int i)
    {
        Bundle bundle = fT();
        a a1 = new a(i);
        try
        {
            ((is)bQ()).a(maskedwalletrequest, bundle, a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MaskedWalletRequest maskedwalletrequest)
        {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", maskedwalletrequest);
        }
        a1.a(8, null, null);
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        Bundle bundle = fT();
        try
        {
            ((is)bQ()).a(notifytransactionstatusrequest, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (NotifyTransactionStatusRequest notifytransactionstatusrequest)
        {
            return;
        }
    }

    protected IInterface p(IBinder ibinder)
    {
        return aB(ibinder);
    }
}
