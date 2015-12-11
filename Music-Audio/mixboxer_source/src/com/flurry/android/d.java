// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            fp, ce, FlurryAgent

final class d extends fp
{

    private FlurryAgent l;
    private Context n;
    private String o;

    d(FlurryAgent flurryagent, Context context, String s)
    {
        l = flurryagent;
        n = context;
        o = s;
        super();
    }

    public final void c()
    {
        l.bg = new ce(n, o, "150");
    }
}
