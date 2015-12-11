// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import com.smule.android.c.aa;
import java.util.Comparator;

// Referenced classes of package com.smule.android.network.models:
//            ListingV2, SongV2

public class b
    implements Comparator
{

    public b()
    {
    }

    public int a(ListingV2 listingv2, ListingV2 listingv2_1)
    {
        if (listingv2 == null || listingv2_1 == null || listingv2.song == null || listingv2_1.song == null)
        {
            aa.e(ListingV2.c(), "ListingComparatorByDisplayName - null elements passed in. Returning 0.");
            return 0;
        } else
        {
            return listingv2.song.title.replaceAll("\\p{Punct}", "").toLowerCase().compareTo(listingv2_1.song.title.replaceAll("\\p{Punct}", "").toLowerCase());
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return a((ListingV2)obj, (ListingV2)obj1);
    }
}
