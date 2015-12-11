// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import com.smule.android.network.managers.ak;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.magicpiano.a.g;

public class i
{

    public int a;
    private ListingV2 b;
    private SongV2 c;

    public i(int j, ListingV2 listingv2)
    {
        a = j;
        b = listingv2;
    }

    public i(int j, SongV2 songv2, ListingV2 listingv2)
    {
        b = listingv2;
        a = j;
        c = songv2;
    }

    public ListingV2 a()
    {
        if (b != null)
        {
            return b;
        } else
        {
            return ak.a().f(c.songId);
        }
    }

    public SongV2 b()
    {
        if (c != null)
        {
            return c;
        }
        if (b != null)
        {
            return ak.a().a(b.productId);
        } else
        {
            return null;
        }
    }

    public Boolean c()
    {
        boolean flag;
        if (b() != null && com.smule.android.network.managers.i.a().c(b().songId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public Boolean d()
    {
        boolean flag;
        if (b() != null && g.a().b(b().songId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }
}
