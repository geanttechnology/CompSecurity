// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import java.util.Comparator;

// Referenced classes of package com.smule.android.network.managers:
//            ak

class a
    implements Comparator
{

    final ak a;

    public int a(ListingV2 listingv2, ListingV2 listingv2_1)
    {
        return listingv2.song.title.compareTo(listingv2_1.song.title);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((ListingV2)obj, (ListingV2)obj1);
    }

    V2(ak ak1)
    {
        a = ak1;
        super();
    }
}
