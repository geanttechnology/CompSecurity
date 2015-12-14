// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.socialin.android.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            MemboxItemsActivity, f

final class a
    implements Runnable
{

    private boolean a;
    private MemboxItemsActivity b;

    public final void run()
    {
        try
        {
            if (a && MemboxItemsActivity.a(b).getAdapter() != null && (MemboxItemsActivity.a(b).getAdapter() instanceof f))
            {
                ((f)MemboxItemsActivity.a(b).getAdapter()).b();
                ((f)MemboxItemsActivity.a(b).getAdapter()).a();
            }
            if (MemboxItemsActivity.c(b) != null)
            {
                MemboxItemsActivity.c(b).setText(0x7f0803d8);
                MemboxItemsActivity.c(b).setVisibility(0);
            }
            return;
        }
        catch (Exception exception)
        {
            d.a(MemboxItemsActivity.a(), exception);
        }
    }

    I(MemboxItemsActivity memboxitemsactivity, boolean flag)
    {
        b = memboxitemsactivity;
        a = true;
        super();
    }
}
