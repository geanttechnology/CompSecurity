// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.amazon.device.ads:
//            co, cn

abstract class bl
    implements Closeable
{

    private static final String b = com/amazon/device/ads/bl.getSimpleName();
    File a;
    private final cn c;

    bl()
    {
        new co();
        c = co.a(b);
    }

    private boolean a(File file)
    {
        if (a())
        {
            if (file.getAbsolutePath().equals(a.getAbsolutePath()))
            {
                return true;
            } else
            {
                c.d("Another file is already set in this FileOutputHandler. Close the other file before opening a new one.", null);
                return false;
            }
        } else
        {
            a = file;
            return true;
        }
    }

    public final boolean a()
    {
        return a != null;
    }

    public final boolean a(File file, String s)
    {
        return a(new File(file, s));
    }

    public final boolean a(String s)
    {
        return a(new File(s));
    }

    public final boolean b()
    {
        if (!a())
        {
            throw new IllegalStateException("A file has not been set, yet.");
        } else
        {
            return a.exists();
        }
    }

    protected final void c()
    {
        Closeable closeable;
        closeable = e();
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        closeable.close();
_L1:
        return;
        IOException ioexception1;
        ioexception1;
        c.d("Could not close the %s. %s", new Object[] {
            closeable.getClass().getSimpleName(), ioexception1.getMessage()
        });
        Closeable closeable1 = d();
        if (closeable1 != null)
        {
            try
            {
                closeable1.close();
                return;
            }
            catch (IOException ioexception)
            {
                c.d("Could not close the stream. %s", new Object[] {
                    ioexception.getMessage()
                });
            }
            return;
        }
          goto _L1
    }

    protected abstract Closeable d();

    protected abstract Closeable e();

}
