// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.Context;
import android.view.View;
import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            am

static final class c
    implements Runnable
{

    final View a;
    final Context b;
    final String c;

    public final void run()
    {
        byte abyte0[] = am.a(am.a(a));
        com.appnexus.opensdk.b.b.b(b.b, (new StringBuilder("PITBULL image size: ")).append(abyte0.length).append(" bytes").toString());
        am.a(b, c, abyte0);
    }

    (View view, Context context, String s)
    {
        a = view;
        b = context;
        c = s;
        super();
    }
}
