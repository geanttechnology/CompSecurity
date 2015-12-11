// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.google.android.gms.common.internal:
//            q

public final class a extends q.a
{

    int a;
    private Account b;
    private Context c;

    public static Account a(q q1)
    {
        Account account = null;
        if (q1 != null)
        {
            long l = Binder.clearCallingIdentity();
            try
            {
                account = q1.a();
            }
            // Misplaced declaration of an exception variable
            catch (q q1)
            {
                Binder.restoreCallingIdentity(l);
                return null;
            }
            finally
            {
                Binder.restoreCallingIdentity(l);
            }
            Binder.restoreCallingIdentity(l);
        }
        return account;
        throw q1;
    }

    public final Account a()
    {
        int i = Binder.getCallingUid();
        if (i == a)
        {
            return b;
        }
        if (GooglePlayServicesUtil.zze(c, i))
        {
            a = i;
            return b;
        } else
        {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof a))
        {
            return false;
        } else
        {
            return b.equals(((a)obj).b);
        }
    }
}
