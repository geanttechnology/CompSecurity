// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.offerup.android.dto.Filter;
import com.offerup.android.dto.FilterOption;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            ax

final class ay
    implements android.widget.AdapterView.OnItemSelectedListener
{

    private ax a;

    ay(ax ax1)
    {
        a = ax1;
        super();
    }

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        ax.b(a).setText(((FilterOption)ax.a(a).getOptions().get(i)).getLongLabel());
        ax.c(a).setSelected(false);
        ((FilterOption)ax.a(a).getOptions().get(i)).setSelected(true);
        ax.a(a, (FilterOption)ax.a(a).getOptions().get(i));
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }
}
