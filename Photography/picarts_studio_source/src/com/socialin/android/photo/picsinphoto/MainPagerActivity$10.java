// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import com.socialin.android.apiv3.util.PublicSyncInventory;
import java.util.Iterator;
import java.util.List;
import myobfuscated.bp.b;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class A
    implements b
{

    public final void a()
    {
        PublicSyncInventory.setAdsState(false);
    }

    public final void a(List list)
    {
        PublicSyncInventory.setAdsState(false);
        list = list.iterator();
        do
        {
label0:
            {
                if (list.hasNext())
                {
                    if (!"ad_remover".equals((String)list.next()))
                    {
                        break label0;
                    }
                    PublicSyncInventory.setAdsState(true);
                }
                return;
            }
            PublicSyncInventory.setAdsState(false);
        } while (true);
    }

    A()
    {
    }
}
