// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;

public class ye
{

    private final String a;

    public ye(String s)
    {
        a = s;
    }

    public String a()
    {
        return abq.e();
    }

    public boolean a(String s, int i, Intent intent)
    {
        if (s != null && intent != null)
        {
            String s1 = yc.b(intent);
            intent = yc.c(intent);
            if (s1 != null && intent != null)
            {
                if (!s.equals(yc.a(s1)))
                {
                    acb.e("Developer payload not match.");
                    return false;
                }
                if (a != null && !yf.a(a, s1, intent))
                {
                    acb.e("Fail to verify signature.");
                    return false;
                } else
                {
                    return true;
                }
            }
        }
        return false;
    }
}
