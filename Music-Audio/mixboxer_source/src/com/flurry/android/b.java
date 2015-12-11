// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            fp, FlurryAgent

final class b extends fp
{

    private Context j;
    private boolean k;
    private FlurryAgent l;

    b(FlurryAgent flurryagent, Context context, boolean flag)
    {
        l = flurryagent;
        j = context;
        k = flag;
        super();
    }

    public final void c()
    {
        if (!FlurryAgent.a(l))
        {
            FlurryAgent.a(l, j);
        }
        FlurryAgent.a(l, j, k);
    }
}
