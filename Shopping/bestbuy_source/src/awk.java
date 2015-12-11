// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.io.InputStream;

public class awk
    implements atu
{

    private final Status a;
    private volatile ParcelFileDescriptor b;
    private volatile InputStream c;
    private volatile boolean d;

    public awk(Status status, ParcelFileDescriptor parcelfiledescriptor)
    {
        d = false;
        a = status;
        b = parcelfiledescriptor;
    }

    public void a()
    {
        if (b == null)
        {
            return;
        }
        if (d)
        {
            throw new IllegalStateException("releasing an already released result.");
        }
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        c.close();
_L1:
        d = true;
        b = null;
        c = null;
        return;
        try
        {
            b.close();
        }
        catch (IOException ioexception)
        {
            return;
        }
          goto _L1
    }

    public Status b()
    {
        return a;
    }

    public InputStream c()
    {
        if (d)
        {
            throw new IllegalStateException("Cannot access the input stream after release().");
        }
        if (b == null)
        {
            return null;
        }
        if (c == null)
        {
            c = new android.os.ParcelFileDescriptor.AutoCloseInputStream(b);
        }
        return c;
    }
}
