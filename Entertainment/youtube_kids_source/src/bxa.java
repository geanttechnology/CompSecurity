// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public final class bxa extends app
{

    public final String f;
    public final boolean g;

    public bxa(int i, String s, String s1, int j, int k, int l, int i1, 
            int j1, String s2, String s3, boolean flag)
    {
        if (TextUtils.isEmpty(s))
        {
            s = String.valueOf(i);
        } else
        {
            s2 = String.valueOf(String.valueOf(i));
            s = (new StringBuilder(String.valueOf(s2).length() + 1 + String.valueOf(s).length())).append(s2).append(":").append(s).toString();
        }
        super(s, s1, j, k, 0, 0, j1, null);
        f = s3;
        g = flag;
    }

    public static int a(String s)
    {
        s = s.split(":", 2);
        if (s.length == 0)
        {
            return -1;
        }
        int i;
        try
        {
            i = Integer.parseInt(s[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        return i;
    }

    public static String b(String s)
    {
        s = s.split(":", 2);
        if (s.length < 2)
        {
            return "";
        } else
        {
            return s[1];
        }
    }
}
