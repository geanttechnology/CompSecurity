// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.BitmapFactory;
import java.io.InputStream;

// Referenced classes of package com.tapjoy.internal:
//            bh, w, bj

final class a
    implements bh
{

    final InputStream a;
    final w b;

    public final Object call()
    {
        if (a instanceof bj)
        {
            return BitmapFactory.decodeStream(a);
        } else
        {
            return BitmapFactory.decodeStream(new bj(a));
        }
    }

    actory(w w1, InputStream inputstream)
    {
        b = w1;
        a = inputstream;
        super();
    }
}
