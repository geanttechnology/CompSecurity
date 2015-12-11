// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.a;

import com.target.mothership.model.guest.interfaces.AccountDetails;

public class a
{

    private static final int NAME_MAX_CHAR = 22;

    public static String a(AccountDetails accountdetails)
    {
        if (accountdetails == null)
        {
            return "";
        }
        String s = accountdetails.getFirstName();
        accountdetails = accountdetails.getLastName();
        if (s.length() + accountdetails.length() + 1 <= 22)
        {
            return a(s, ((String) (accountdetails)));
        } else
        {
            return a(s);
        }
    }

    private static final String a(String s)
    {
        if (s.length() <= 22)
        {
            return s;
        } else
        {
            return s.substring(0, 22);
        }
    }

    private static String a(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        stringbuilder.append(" ");
        stringbuilder.append(s1);
        return stringbuilder.toString();
    }
}
