// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RadioGroup;

// Referenced classes of package com.picsart.filters:
//            c

final class b
    implements android.widget.oGroup.OnCheckedChangeListener
{

    private Activity a;
    private ViewGroup b;
    private c c;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        i = c.a(i);
        com.picsart.filters.c.a(c, a, i, b);
    }

    p(c c1, Activity activity, ViewGroup viewgroup)
    {
        c = c1;
        a = activity;
        b = viewgroup;
        super();
    }
}
