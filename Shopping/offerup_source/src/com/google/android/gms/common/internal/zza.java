// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzp

public class zza extends zzp.zza
{

    private Context mContext;
    private Account zzQd;
    int zzaeG;

    public static Account zzb(zzp zzp1)
    {
        Account account;
        long l;
        account = null;
        if (zzp1 == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        l = Binder.clearCallingIdentity();
        account = zzp1.getAccount();
        Binder.restoreCallingIdentity(l);
        return account;
        zzp1;
        Log.w("AccountAccessor", "Remote account accessor probably died");
        Binder.restoreCallingIdentity(l);
        return null;
        zzp1;
        Binder.restoreCallingIdentity(l);
        throw zzp1;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof zza))
        {
            return false;
        } else
        {
            return zzQd.equals(((zza)obj).zzQd);
        }
    }

    public Account getAccount()
    {
        int i = Binder.getCallingUid();
        if (i == zzaeG)
        {
            return zzQd;
        }
        if (GooglePlayServicesUtil.zze(mContext, i))
        {
            zzaeG = i;
            return zzQd;
        } else
        {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }
}
