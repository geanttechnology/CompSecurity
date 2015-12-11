// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import java.util.Date;
import java.util.HashSet;

public final class wt
{

    public static nw a(int i)
    {
        switch (i)
        {
        default:
            return nw.a;

        case 2: // '\002'
            return nw.c;

        case 1: // '\001'
            return nw.b;
        }
    }

    public static nx a(ay ay1)
    {
        int i = 0;
        nx anx[] = new nx[6];
        anx[0] = nx.a;
        anx[1] = nx.b;
        anx[2] = nx.c;
        anx[3] = nx.d;
        anx[4] = nx.e;
        anx[5] = nx.f;
        for (; i < anx.length; i++)
        {
            if (anx[i].a() == ay1.f && anx[i].b() == ay1.c)
            {
                return anx[i];
            }
        }

        return new nx(oq.a(ay1.f, ay1.c, ay1.b));
    }

    public static ny a(av av1)
    {
        HashSet hashset;
        if (av1.e != null)
        {
            hashset = new HashSet(av1.e);
        } else
        {
            hashset = null;
        }
        return new ny(new Date(av1.b), a(av1.d), hashset, av1.f, av1.k);
    }
}
