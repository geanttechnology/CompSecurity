// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import android.widget.Spinner;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g:
//            au

final class aw
    implements android.view.View.OnClickListener
{

    private au a;

    aw(au au1)
    {
        a = au1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.a("ou_sort_dialogue", null);
        au.b(a).performClick();
    }
}
