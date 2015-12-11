// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

// Referenced classes of package com.google.android.gms.internal:
//            iu

final class oZ extends oZ
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

    public eption(iu iu1, int i)
    {
        Hl = iu1;
        super();
        oZ = i;
    }
}
