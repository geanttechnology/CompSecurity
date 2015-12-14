// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.identity.intents.UserAddressRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznz

public class zznx extends zzj
{
    public static final class zza extends zzny.zza
    {

        private Activity mActivity;
        private final int zzadi;

        private void setActivity(Activity activity)
        {
            mActivity = activity;
        }

        static void zza(zza zza1, Activity activity)
        {
            zza1.setActivity(activity);
        }

        public void zzh(int i, Bundle bundle)
        {
            if (i != 1) goto _L2; else goto _L1
_L1:
            Intent intent = new Intent();
            intent.putExtras(bundle);
            bundle = mActivity.createPendingResult(zzadi, intent, 0x40000000);
            if (bundle != null) goto _L4; else goto _L3
_L3:
            return;
_L4:
            try
            {
                bundle.send(1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.w("AddressClientImpl", "Exception settng pending result", bundle);
            }
            return;
_L2:
            PendingIntent pendingintent = null;
            if (bundle != null)
            {
                pendingintent = (PendingIntent)bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            bundle = new ConnectionResult(i, pendingintent);
            if (bundle.hasResolution())
            {
                try
                {
                    bundle.startResolutionForResult(mActivity, zzadi);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Log.w("AddressClientImpl", "Exception starting pending intent", bundle);
                }
                return;
            }
            bundle = mActivity.createPendingResult(zzadi, new Intent(), 0x40000000);
            if (bundle != null)
            {
                try
                {
                    bundle.send(1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Log.w("AddressClientImpl", "Exception setting pending result", bundle);
                }
                return;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public zza(int i, Activity activity)
        {
            zzadi = i;
            mActivity = activity;
        }
    }


    private Activity mActivity;
    private final int mTheme;
    private final String zzQE;
    private zza zzaAB;

    public zznx(Activity activity, Looper looper, zzf zzf1, int i, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(activity, looper, 12, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzQE = zzf1.getAccountName();
        mActivity = activity;
        mTheme = i;
    }

    public void disconnect()
    {
        super.disconnect();
        if (zzaAB != null)
        {
            zza.zza(zzaAB, null);
            zzaAB = null;
        }
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzbS(ibinder);
    }

    public void zza(UserAddressRequest useraddressrequest, int i)
    {
        zzvw();
        zzaAB = new zza(i, mActivity);
        try
        {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(zzQE))
            {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(zzQE, "com.google"));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", mTheme);
            zzvv().zza(zzaAB, useraddressrequest, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (UserAddressRequest useraddressrequest)
        {
            Log.e("AddressClientImpl", "Exception requesting user address", useraddressrequest);
        }
        useraddressrequest = new Bundle();
        useraddressrequest.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
        zzaAB.zzh(1, useraddressrequest);
    }

    protected zznz zzbS(IBinder ibinder)
    {
        return zznz.zza.zzbU(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public boolean zzoC()
    {
        return true;
    }

    protected zznz zzvv()
        throws DeadObjectException
    {
        return (zznz)super.zzoA();
    }

    protected void zzvw()
    {
        super.zzoz();
    }
}
