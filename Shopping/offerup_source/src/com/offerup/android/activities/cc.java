// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.ItemList;
import java.util.Comparator;

// Referenced classes of package com.offerup.android.activities:
//            ExploreActivity

final class cc
    implements Comparator
{

    cc(ExploreActivity exploreactivity)
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        return ((ItemList)obj).compareTo((ItemList)obj1);
    }
}
