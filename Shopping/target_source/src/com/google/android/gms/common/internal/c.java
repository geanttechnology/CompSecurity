// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.e;

// Referenced classes of package com.google.android.gms.common.internal:
//            a

public class c extends a.a
{

    int a;
    private Account b;
    private Context c;

    public static Account a(a a1)
    {
        Account account;
        long l;
        account = null;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        l = Binder.clearCallingIdentity();
        account = a1.a();
        Binder.restoreCallingIdentity(l);
        return account;
        a1;
        Log.w("AccountAccessor", "Remote account accessor probably died");
        Binder.restoreCallingIdentity(l);
        return null;
        a1;
        Binder.restoreCallingIdentity(l);
        throw a1;
    }

    public Account a()
    {
        int i = Binder.getCallingUid();
        if (i == a)
        {
            return b;
        }
        if (e.a(c, i))
        {
            a = i;
            return b;
        } else
        {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof c))
        {
            return false;
        } else
        {
            return b.equals(((c)obj).b);
        }
    }
}
