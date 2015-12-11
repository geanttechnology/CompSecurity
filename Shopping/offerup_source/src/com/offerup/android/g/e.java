// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.res.Resources;
import android.view.View;
import android.widget.CheckedTextView;
import com.offerup.android.dto.Filter;

// Referenced classes of package com.offerup.android.g:
//            d

final class e
    implements android.view.View.OnClickListener
{

    private Filter a;
    private d b;

    e(d d1, Filter filter)
    {
        b = d1;
        a = filter;
        super();
    }

    public final void onClick(View view)
    {
        if (a.isSelected())
        {
            a.setSelected(false);
            d.a(b).setChecked(false);
            d.a(b).setTextColor(b.getResources().getColor(0x7f0e00e9));
            return;
        } else
        {
            a.setSelected(true);
            d.a(b).setChecked(true);
            d.a(b).setTextColor(b.getResources().getColor(0x7f0e0114));
            return;
        }
    }
}
