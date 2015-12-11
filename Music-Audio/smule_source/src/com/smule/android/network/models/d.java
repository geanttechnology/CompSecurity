// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import java.util.Comparator;

// Referenced classes of package com.smule.android.network.models:
//            StoreSectionV2

public class d
    implements Comparator
{

    public d()
    {
    }

    public int a(StoreSectionV2 storesectionv2, StoreSectionV2 storesectionv2_1)
    {
        if (storesectionv2.order == storesectionv2_1.order)
        {
            return !storesectionv2.sectionId.equals("my_songs") ? 1 : -1;
        } else
        {
            return storesectionv2.order - storesectionv2_1.order;
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return a((StoreSectionV2)obj, (StoreSectionV2)obj1);
    }
}
