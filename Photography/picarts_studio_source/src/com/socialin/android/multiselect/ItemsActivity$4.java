// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.os.Handler;
import android.view.View;
import com.picsart.shop.v;
import com.socialin.android.util.Utils;
import java.util.List;
import myobfuscated.by.a;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class a
    implements v
{

    final ItemsActivity a;

    public final transient void a(int i)
    {
        if (ItemsActivity.c(a).size() >= ItemsActivity.d(a) && ItemsActivity.d(a) != -1)
        {
            Utils.a(a, 0x7f080442);
            return;
        } else
        {
            ItemsActivity.e(a).setVisibility(0);
            com.socialin.android.multiselect.ItemsActivity.a(a, ItemsActivity.f(a).a(i));
    /* block-local class not found */
    class _cls1 {}

            (new Handler()).postDelayed(new _cls1(), 100L);
            return;
        }
    }

    _cls1(ItemsActivity itemsactivity)
    {
        a = itemsactivity;
        super();
    }
}
