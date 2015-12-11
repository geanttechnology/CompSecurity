// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            akv

public interface ako
{
    public static class a
    {

        final InputStream a;
        final Bitmap b;
        final boolean c;
        final long d;

        public InputStream a()
        {
            return a;
        }

        public Bitmap b()
        {
            return b;
        }

        public long c()
        {
            return d;
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

    public static class b extends IOException
    {

        final boolean a;
        final int b;

        public b(String s, int i, int j)
        {
            super(s);
            a = akv.c(i);
            b = j;
        }
    }


    public abstract a a(Uri uri, int i)
        throws IOException;
}
