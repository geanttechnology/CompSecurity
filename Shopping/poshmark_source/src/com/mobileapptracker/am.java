// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Patterns;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, MATParameters

final class am
    implements Runnable
{

    final boolean a;
    final MobileAppTracker b;

    am(MobileAppTracker mobileapptracker, boolean flag)
    {
        b = mobileapptracker;
        a = flag;
        super();
    }

    public final void run()
    {
        boolean flag = false;
        int i;
        if (b.mContext.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") == 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (a && i != 0)
        {
            Object aobj[] = AccountManager.get(b.mContext).getAccountsByType("com.google");
            if (aobj.length > 0)
            {
                b.params.setUserEmail(aobj[0].name);
            }
            Object obj = new HashMap();
            Account aaccount[] = AccountManager.get(b.mContext).getAccounts();
            int j = aaccount.length;
            for (i = ((flag) ? 1 : 0); i < j; i++)
            {
                Account account = aaccount[i];
                if (Patterns.EMAIL_ADDRESS.matcher(account.name).matches())
                {
                    ((HashMap) (obj)).put(account.name, account.type);
                }
            }

            obj = ((HashMap) (obj)).keySet();
            obj = (String[])((Set) (obj)).toArray(new String[((Set) (obj)).size()]);
            b.params.setUserEmails(((String []) (obj)));
            return;
        } else
        {
            b.params.setUserEmail(null);
            return;
        }
    }
}
