// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.a.b:
//            s, h, ai, ak

public final class af
{

    final Context a;
    s b;
    ExecutorService c;
    h d;
    ai e;
    ak f;
    boolean g;

    public af(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            a = context.getApplicationContext();
            return;
        }
    }
}
