// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, k, j

public class a
    implements i
{

    public a()
    {
    }

    public void a(Context context, j j1)
    {
        if (!k.a("android.permission.GET_ACCOUNTS", context))
        {
            return;
        }
        Account aaccount[] = AccountManager.get(context).getAccounts();
        String s = "";
        context = "";
        int i1 = aaccount.length;
        for (int l = 0; l < i1; l++)
        {
            Account account = aaccount[l];
            context = (new StringBuilder()).append(context).append(s).append(account.type).append(":").append(k.a(account.name.getBytes())).toString();
            s = ", ";
        }

        j1.a("AACT", context);
    }
}
