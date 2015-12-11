// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.offerup.android.dto.Sort;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            au

final class av
    implements android.widget.AdapterView.OnItemSelectedListener
{

    private au a;

    av(au au1)
    {
        a = au1;
        super();
    }

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        au.a(a).setText(((Sort)a.b.get(i)).getLongLabel());
        if (a.c != null)
        {
            a.c.setSelected(false);
        }
        ((Sort)a.b.get(i)).setSelected(true);
        a.c = (Sort)a.b.get(i);
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }
}
