// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.widget.HorizontalScrollView;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class a
    implements Runnable
{

    private ItemsActivity a;

    public final void run()
    {
        ItemsActivity.b(a).fullScroll(66);
        ItemsActivity.b(a).invalidate();
    }

    (ItemsActivity itemsactivity)
    {
        a = itemsactivity;
        super();
    }
}
