// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.view.View;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.util.z;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            MemboxItemsActivity

final class a
    implements Runnable
{

    private MemboxItemsActivity a;

    public final void run()
    {
        int ai[] = new int[2];
        a.findViewById(0x7f1009d6).getLocationOnScreen(ai);
        z z1 = a.a;
        int i = ai[1];
        d.b("spen", new Object[] {
            (new StringBuilder("top offset :: ")).append(i).toString()
        });
        z1.i = i;
    }

    I(MemboxItemsActivity memboxitemsactivity)
    {
        a = memboxitemsactivity;
        super();
    }
}
