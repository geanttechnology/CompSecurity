// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class boa
{

    public static final Set a;
    public final String b;
    public final String c;
    private AccountManager d;

    protected boa()
    {
        d = null;
        c = a(Collections.singleton("http://gdata.youtube.com"));
        b = "";
    }

    public boa(Context context, Set set)
    {
        d = AccountManager.get(context);
        c = a(set);
        b = "com.google";
    }

    private static String a(Set set)
    {
        set = String.valueOf(TextUtils.join(" ", set));
        if (set.length() != 0)
        {
            return "oauth2:".concat(set);
        } else
        {
            return new String("oauth2:");
        }
    }

    public final Account[] a()
    {
        return d.getAccountsByType(b);
    }

    static 
    {
        HashSet hashset = new HashSet();
        hashset.add("https://www.googleapis.com/auth/youtube");
        hashset.add("https://www.googleapis.com/auth/youtube.force-ssl");
        hashset.add("https://www.googleapis.com/auth/plus.me");
        hashset.add("https://www.googleapis.com/auth/plus.stream.read");
        hashset.add("https://www.googleapis.com/auth/plus.stream.write");
        hashset.add("https://www.googleapis.com/auth/plus.pages.manage");
        a = Collections.unmodifiableSet(hashset);
    }
}
