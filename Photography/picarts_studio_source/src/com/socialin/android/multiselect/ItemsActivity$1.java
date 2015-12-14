// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.support.v7.widget.RecyclerView;
import com.bumptech.glide.k;
import java.util.Iterator;
import java.util.Set;
import myobfuscated.ad.m;
import myobfuscated.aj.j;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class stener extends android.support.v7.widget.crollListener
{

    private ItemsActivity a;

    public final void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        super.onScrollStateChanged(recyclerview, i);
        if (i == 0)
        {
            recyclerview = ItemsActivity.a(a);
            j.a();
            recyclerview.c();
            for (recyclerview = ((k) (recyclerview)).c.a().iterator(); recyclerview.hasNext(); ((k)recyclerview.next()).c()) { }
        } else
        {
            ItemsActivity.a(a).b();
        }
    }

    stener(ItemsActivity itemsactivity)
    {
        a = itemsactivity;
        super();
    }
}
