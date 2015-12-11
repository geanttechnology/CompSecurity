// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.appnexus.opensdk:
//            t, v, d

final class a
    implements android.view..OnClickListener
{

    final t a;

    public final void onClick(View view)
    {
        if (a.a != null)
        {
            if (a.b != null && a.b.getAdDispatcher() != null)
            {
                a.b.getAdDispatcher().b();
            }
            a.a.finish();
        }
    }

    Listener(t t1)
    {
        a = t1;
        super();
    }
}
