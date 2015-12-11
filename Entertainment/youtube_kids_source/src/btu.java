// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class btu
{

    public final List a;

    public btu()
    {
        a = Collections.emptyList();
    }

    public btu(Uri uri)
    {
        b.a(uri);
        a = Collections.singletonList(new btt(uri));
    }

    public btu(dzp dzp1)
    {
        if (dzp1 != null)
        {
            a = new ArrayList(dzp1.b.length);
            dzp1 = dzp1.b;
            int j = dzp1.length;
            for (int i = 0; i < j; i++)
            {
                dzq dzq = dzp1[i];
                a.add(new btt(dzq));
            }

        } else
        {
            a = Collections.emptyList();
        }
    }

    public final btt a(int i)
    {
        while (!a() || !a()) 
        {
            return null;
        }
        return (btt)a.get(0);
    }

    public final boolean a()
    {
        return a.size() > 0;
    }
}
