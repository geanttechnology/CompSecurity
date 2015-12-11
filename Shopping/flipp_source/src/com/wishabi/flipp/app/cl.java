// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import com.wishabi.flipp.b.ag;

// Referenced classes of package com.wishabi.flipp.app:
//            HelpActivity

final class cl extends ag
{

    final HelpActivity a;

    cl(HelpActivity helpactivity, Context context)
    {
        a = helpactivity;
        super(context);
    }

    protected final void a(String s)
    {
        if (s != null && s.length() >= 5)
        {
            HelpActivity.a(a, s);
        }
    }
}
