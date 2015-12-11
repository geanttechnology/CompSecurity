// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.g.c:
//            r

public interface j
{
    public static final class a
    {

        final InputStream a;
        final Bitmap b;
        final boolean c;
        final long d;

        public a(InputStream inputstream, boolean flag)
        {
            this(inputstream, flag, -1L);
        }

        public a(InputStream inputstream, boolean flag, long l)
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

    public static final class b extends IOException
    {

        final boolean a;
        final int b;

        public b(String s, int i, int k)
        {
            super(s);
            a = r.c(i);
            b = k;
        }
    }


    public abstract a a(Uri uri, int i);
}
