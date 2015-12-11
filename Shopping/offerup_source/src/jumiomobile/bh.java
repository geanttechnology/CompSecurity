// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Locale;

public class bh
{

    private String a;
    private String b;

    public bh(String s, String s1)
    {
        a = a(s);
        b = s1;
    }

    private String a(String s)
    {
        s = s.trim().split(" ");
        if (s.length > 1)
        {
            return (new StringBuilder()).append(s[0].trim()).append(" ").append(s[s.length - 1].trim()).toString();
        } else
        {
            return null;
        }
    }

    public int a()
    {
        if (a == null || b == null)
        {
            return -1;
        }
        a = a.toLowerCase(Locale.getDefault());
        b = b.toLowerCase(Locale.getDefault());
        int ai[] = new int[b.length() + 1];
        for (int i = 0; i < ai.length; i++)
        {
            ai[i] = i;
        }

        for (int k = 1; k <= a.length(); k++)
        {
            ai[0] = k;
            int j = k - 1;
            int l = 1;
            while (l <= b.length()) 
            {
                int i1 = Math.min(ai[l], ai[l - 1]);
                if (a.charAt(k - 1) != b.charAt(l - 1))
                {
                    j++;
                }
                i1 = Math.min(i1 + 1, j);
                j = ai[l];
                ai[l] = i1;
                l++;
            }
        }

        return ai[b.length()];
    }

    public boolean b()
    {
        while (a == null || b == null || Math.round((float)Math.min(a.length(), b.length()) * 0.2F) < a()) 
        {
            return false;
        }
        return true;
    }
}
