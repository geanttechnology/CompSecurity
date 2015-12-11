// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.flurry.sdk:
//            r

public abstract class en
{

    static final String a = com/flurry/sdk/en.getSimpleName();
    private final WeakReference b;
    private final r c;

    public en(Context context, r r)
    {
        b = new WeakReference(context);
        c = r;
    }

    public abstract void a();

    public Context c()
    {
        return (Context)b.get();
    }

    public r d()
    {
        return c;
    }

}
