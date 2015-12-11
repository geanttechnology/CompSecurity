// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Patterns;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{

    private final Context a;

    public a(Context context)
    {
        a = context.getApplicationContext();
    }

    protected List a()
    {
        Object obj1 = AccountManager.get(a);
        Object obj = new ArrayList();
        if (obj1 != null)
        {
            obj = ((AccountManager) (obj1)).getAccounts();
            obj1 = new HashSet();
            int j = obj.length;
            for (int i = 0; i < j; i++)
            {
                Object obj2 = obj[i];
                if (Patterns.EMAIL_ADDRESS.matcher(((Account) (obj2)).name).matches())
                {
                    ((Set) (obj1)).add(((Account) (obj2)).name);
                }
            }

            obj = new ArrayList(((java.util.Collection) (obj1)));
        }
        return ((List) (obj));
    }
}
