// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class a
    implements android.view.ener
{

    private String a;
    private ItemsActivity b;

    public final void onClick(View view)
    {
        ItemsActivity.i(b).removeView(view);
        ItemsActivity.c(b).remove(a);
        if (ItemsActivity.c(b).isEmpty())
        {
            ItemsActivity.e(b).setVisibility(8);
        }
        ((TextView)b.findViewById(0x7f10072e)).setText((new StringBuilder()).append(ItemsActivity.c(b).size()).toString());
    }

    (ItemsActivity itemsactivity, String s)
    {
        b = itemsactivity;
        a = s;
        super();
    }
}
