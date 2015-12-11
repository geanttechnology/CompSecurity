// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.graphics.Bitmap;
import java.io.InputStream;

// Referenced classes of package com.g.c:
//            j

public static final class d
{

    final InputStream a;
    final Bitmap b;
    final boolean c;
    final long d;

    public tStream(InputStream inputstream, boolean flag)
    {
        this(inputstream, flag, -1L);
    }

    public ring(InputStream inputstream, boolean flag, long l)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Stream may not be null.");
        } else
        {
            a = inputstream;
            b = null;
            c = flag;
            d = l;
            return;
        }
    }
}
