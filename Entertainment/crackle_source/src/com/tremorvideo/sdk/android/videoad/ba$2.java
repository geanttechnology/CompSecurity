// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.a.b;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ba, ad

static final class b
    implements Runnable
{

    final b a;
    final Context b;

    public void run()
    {
        try
        {
            a.a(b);
            return;
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
    }

    (b b1, Context context)
    {
        a = b1;
        b = context;
        super();
    }
}
