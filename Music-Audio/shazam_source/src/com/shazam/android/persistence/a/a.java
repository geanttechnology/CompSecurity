// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.shazam.model.account.EmailAddressAccessor;
import com.shazam.model.account.EmailValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
    implements EmailAddressAccessor
{

    private final AccountManager a;
    private final String b = null;
    private final EmailValidator c;

    public a(AccountManager accountmanager, EmailValidator emailvalidator)
    {
        a = accountmanager;
        c = emailvalidator;
    }

    private Collection a(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            String s = (String)collection.next();
            if (s != null && c.a(s))
            {
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }

    public final String a()
    {
        String as[] = b();
        String s = "";
        if (as.length > 0)
        {
            s = as[0];
        }
        return s;
    }

    public final String[] b()
    {
        Object obj1 = Arrays.asList(a.getAccountsByType(b));
        Object obj = new HashSet();
        for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((Set) (obj)).add(((Account)((Iterator) (obj1)).next()).name)) { }
        obj = a(((Collection) (obj)));
        return (String[])((Collection) (obj)).toArray(new String[((Collection) (obj)).size()]);
    }
}
