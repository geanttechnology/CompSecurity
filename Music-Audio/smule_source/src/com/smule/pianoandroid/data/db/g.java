// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import com.smule.android.c.aa;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.android.network.models.StoreSectionV2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.data.db:
//            c, i

public class g
{

    public String a;
    public int b;
    public String c;
    public ArrayList d;

    public g()
    {
        d = new ArrayList();
    }

    public g(StoreSectionV2 storesectionv2)
    {
        HashSet hashset;
        Iterator iterator;
        int j;
        d = new ArrayList();
        hashset = new HashSet();
        a = storesectionv2.displayName;
        b = storesectionv2.order;
        c = storesectionv2.sectionId;
        iterator = storesectionv2.listings.iterator();
        j = 0;
_L3:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        storesectionv2 = (ListingV2)iterator.next();
        if (hashset.add(((ListingV2) (storesectionv2)).song.songId))
        {
            ListingV2 listingv2 = ak.a().f(((ListingV2) (storesectionv2)).song.songId);
            if (listingv2 == null)
            {
                aa.b(c.f, "no listing found for in storeManager, using existing listing");
            } else
            {
                storesectionv2 = listingv2;
            }
            d.add(new i(j, storesectionv2));
            j++;
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    public g(String s, int j)
    {
        d = new ArrayList();
        a = s;
        b = j;
    }
}
