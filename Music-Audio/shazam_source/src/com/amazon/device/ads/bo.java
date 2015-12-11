// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// Referenced classes of package com.amazon.device.ads:
//            bl, co, cn

class bo extends bl
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/bo$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("APPEND", 0);
            b = new a("OVERWRITE", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String d = com/amazon/device/ads/bo.getSimpleName();
    OutputStream b;
    BufferedWriter c;
    private final cn e;
    private a f;

    bo()
    {
        new co();
        e = co.a(d);
    }

    public final boolean a(a a1)
    {
        if (a == null)
        {
            e.d("A file must be set before it can be opened.", null);
            return false;
        }
        if (b != null)
        {
            e.d("The file is already open.", null);
            return false;
        }
        FileOutputStream fileoutputstream;
        try
        {
            fileoutputstream = new FileOutputStream(a, a.a.equals(a1));
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            return false;
        }
        f = a1;
        b = new BufferedOutputStream(fileoutputstream);
        c = new BufferedWriter(new OutputStreamWriter(b));
        return true;
    }

    public void close()
    {
        if (b != null)
        {
            try
            {
                b.flush();
            }
            catch (IOException ioexception)
            {
                e.d("Could not flush the OutputStream. %s", new Object[] {
                    ioexception.getMessage()
                });
            }
        }
        if (c != null)
        {
            try
            {
                c.flush();
            }
            catch (IOException ioexception1)
            {
                e.d("Could not flush the BufferedWriter. %s", new Object[] {
                    ioexception1.getMessage()
                });
            }
        }
        c();
        c = null;
        b = null;
    }

    protected final Closeable d()
    {
        return b;
    }

    protected final Closeable e()
    {
        return c;
    }

    final void f()
    {
        if (c == null)
        {
            throw new IllegalStateException("Could not write to the file because no file has been opened yet. Please set the file, then call open() before attempting to write.");
        } else
        {
            return;
        }
    }

}
