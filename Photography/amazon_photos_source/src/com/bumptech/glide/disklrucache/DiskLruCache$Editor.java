// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.disklrucache;

import java.io.File;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.disklrucache:
//            DiskLruCache

public final class <init>
{

    private boolean committed;
    private final this._cls0 entry;
    final DiskLruCache this$0;
    private final boolean written[];

    public void abort()
        throws IOException
    {
        DiskLruCache.access$2000(DiskLruCache.this, this, false);
    }

    public void abortUnlessCommitted()
    {
        if (committed)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        abort();
        return;
        IOException ioexception;
        ioexception;
    }

    public void commit()
        throws IOException
    {
        DiskLruCache.access$2000(DiskLruCache.this, this, true);
        committed = true;
    }

    public File getFile(int i)
        throws IOException
    {
        DiskLruCache disklrucache = DiskLruCache.this;
        disklrucache;
        JVM INSTR monitorenter ;
        if (ccess._mth700(entry) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
        File file;
        if (!ccess._mth600(entry))
        {
            written[i] = true;
        }
        file = entry.etDirtyFile(i);
        if (!DiskLruCache.access$1900(DiskLruCache.this).exists())
        {
            DiskLruCache.access$1900(DiskLruCache.this).mkdirs();
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return file;
    }



    private _cls9(_cls9 _pcls9)
    {
        this$0 = DiskLruCache.this;
        super();
        entry = _pcls9;
        if (ccess._mth600(_pcls9))
        {
            disklrucache = null;
        } else
        {
            disklrucache = new boolean[DiskLruCache.access$1800(DiskLruCache.this)];
        }
        written = DiskLruCache.this;
    }

    written(written written1, written written2)
    {
        this(written1);
    }
}
