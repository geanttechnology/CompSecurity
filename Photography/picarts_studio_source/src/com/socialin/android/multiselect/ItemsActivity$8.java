// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import com.socialin.android.dialog.g;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class a
    implements Runnable
{

    final g a;
    final ItemsActivity b;

    public final void run()
    {
        if (ItemsActivity.h(b))
        {
            ItemsActivity.a(b, false);
            return;
        } else
        {
    /* block-local class not found */
    class _cls1 {}

            b.runOnUiThread(new _cls1());
            return;
        }
    }

    _cls1(ItemsActivity itemsactivity, g g)
    {
        b = itemsactivity;
        a = g;
        super();
    }
}
