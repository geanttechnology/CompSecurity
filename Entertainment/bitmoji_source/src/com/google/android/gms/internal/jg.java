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
import android.os.Looper;
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
//            eh, en, je, er

public class jg extends eh
{
    final class a extends jf.a
    {

        private final int Bq;
        final jg Zz;

        public void a(int i, FullWallet fullwallet, Bundle bundle)
        {
            Object obj = null;
            if (bundle != null)
            {
                obj = (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            bundle = new ConnectionResult(i, ((PendingIntent) (obj)));
            if (bundle.hasResolution())
            {
                try
                {
                    bundle.startResolutionForResult(jg.b(Zz), Bq);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (FullWallet fullwallet)
                {
                    Log.w("WalletClientImpl", "Exception starting pending intent", fullwallet);
                }
                return;
            }
            obj = new Intent();
            byte byte0;
            if (bundle.isSuccess())
            {
                byte0 = -1;
                ((Intent) (obj)).putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", fullwallet);
            } else
            {
                if (i == 408)
                {
                    byte0 = 0;
                } else
                {
                    byte0 = 1;
                }
                ((Intent) (obj)).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", i);
            }
            fullwallet = jg.b(Zz).createPendingResult(Bq, ((Intent) (obj)), 0x40000000);
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
            Object obj = null;
            if (bundle != null)
            {
                obj = (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            bundle = new ConnectionResult(i, ((PendingIntent) (obj)));
            if (bundle.hasResolution())
            {
                try
                {
                    bundle.startResolutionForResult(jg.b(Zz), Bq);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (MaskedWallet maskedwallet)
                {
                    Log.w("WalletClientImpl", "Exception starting pending intent", maskedwallet);
                }
                return;
            }
            obj = new Intent();
            byte byte0;
            if (bundle.isSuccess())
            {
                byte0 = -1;
                ((Intent) (obj)).putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", maskedwallet);
            } else
            {
                if (i == 408)
                {
                    byte0 = 0;
                } else
                {
                    byte0 = 1;
                }
                ((Intent) (obj)).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", i);
            }
            maskedwallet = jg.b(Zz).createPendingResult(Bq, ((Intent) (obj)), 0x40000000);
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
            bundle = jg.b(Zz).createPendingResult(Bq, bundle, 0x40000000);
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

        public void e(int i, Bundle bundle)
        {
            er.b(bundle, "Bundle should not be null");
            bundle = new ConnectionResult(i, (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (bundle.hasResolution())
            {
                try
                {
                    bundle.startResolutionForResult(jg.b(Zz), Bq);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Log.w("WalletClientImpl", "Exception starting pending intent", bundle);
                }
                return;
            }
            Log.e("WalletClientImpl", (new StringBuilder()).append("Create Wallet Objects confirmation UI will not be shown connection result: ").append(bundle).toString());
            bundle = new Intent();
            bundle.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
            bundle = jg.b(Zz).createPendingResult(Bq, bundle, 0x40000000);
            if (bundle == null)
            {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try
            {
                bundle.send(1);
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
            Zz = jg.this;
            super();
            Bq = i;
        }
    }


    private final int Zw;
    private final int mTheme;
    private final Activity nd;
    private final String vi;

    public jg(Activity activity, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, int i, String s, int j)
    {
        super(activity, looper, connectioncallbacks, onconnectionfailedlistener, new String[0]);
        nd = activity;
        Zw = i;
        vi = s;
        mTheme = j;
    }

    public jg(Activity activity, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, int i, String s, int j)
    {
        this(activity, activity.getMainLooper(), ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new eh.c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new eh.g(onconnectionfailedlistener))), i, s, j);
    }

    static Activity b(jg jg1)
    {
        return jg1.nd;
    }

    private Bundle kx()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", Zw);
        bundle.putString("androidPackageName", nd.getPackageName());
        if (!TextUtils.isEmpty(vi))
        {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(vi, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", mTheme);
        return bundle;
    }

    protected void a(en en1, eh.e e)
        throws RemoteException
    {
        en1.a(e, 0x41f6b8);
    }

    protected je aE(IBinder ibinder)
    {
        return je.a.aC(ibinder);
    }

    protected String aF()
    {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String aG()
    {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void changeMaskedWallet(String s, String s1, int i)
    {
        Bundle bundle = kx();
        a a1 = new a(i);
        try
        {
            ((je)eb()).a(s, s1, bundle, a1);
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
        Bundle bundle = kx();
        a a1 = new a(i);
        try
        {
            ((je)eb()).a(bundle, a1);
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
        Bundle bundle = kx();
        try
        {
            ((je)eb()).a(fullwalletrequest, bundle, a1);
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
        Bundle bundle = kx();
        a a1 = new a(i);
        try
        {
            ((je)eb()).a(maskedwalletrequest, bundle, a1);
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
        Bundle bundle = kx();
        try
        {
            ((je)eb()).a(notifytransactionstatusrequest, bundle);
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
        return aE(ibinder);
    }
}
