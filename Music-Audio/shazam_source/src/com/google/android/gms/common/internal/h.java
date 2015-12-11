// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.signin.e;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class h
{
    public static final class a
    {

        public final Set a;
        public final boolean b;
    }


    public final Account a;
    public final Set b;
    public final Set c;
    public final Map d;
    public final String e;
    final String f;
    public final e g;
    public Integer h;
    private final int i;
    private final View j;

    public h(Account account, Set set, Map map, int k, View view, String s, String s1, 
            e e1)
    {
        a = account;
        if (set == null)
        {
            account = Collections.EMPTY_SET;
        } else
        {
            account = Collections.unmodifiableSet(set);
        }
        b = account;
        account = map;
        if (map == null)
        {
            account = Collections.EMPTY_MAP;
        }
        d = account;
        j = view;
        i = k;
        e = s;
        f = s1;
        g = e1;
        account = new HashSet(b);
        for (set = d.values().iterator(); set.hasNext(); account.addAll(((a)set.next()).a)) { }
        c = Collections.unmodifiableSet(account);
    }

    public final Account a()
    {
        if (a != null)
        {
            return a;
        } else
        {
            return new Account("<<default account>>", "com.google");
        }
    }
}
