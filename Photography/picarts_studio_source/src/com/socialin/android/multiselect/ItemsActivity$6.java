// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class a
    implements android.view.ener
{

    private ItemsActivity a;

    public final void onClick(View view)
    {
        ItemsActivity.c(a).clear();
        ((LinearLayout)a.findViewById(0x7f100733)).removeAllViews();
        ItemsActivity.e(a).setVisibility(8);
    }

    (ItemsActivity itemsactivity)
    {
        a = itemsactivity;
        super();
    }
}
