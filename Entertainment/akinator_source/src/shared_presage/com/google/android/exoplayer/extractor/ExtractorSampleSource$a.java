// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor;

import android.net.Uri;
import shared_presage.com.google.android.exoplayer.upstream.Allocator;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor:
//            ExtractorSampleSource, PositionHolder, DefaultExtractorInput, Extractor, 
//            ExtractorInput

private static final class h
    implements shared_presage.com.google.android.exoplayer.upstream.
{

    private final Uri a;
    private final DataSource b;
    private final b c;
    private final Allocator d;
    private final int e;
    private final PositionHolder f = new PositionHolder();
    private volatile boolean g;
    private boolean h;

    public final void cancelLoad()
    {
        g = true;
    }

    public final boolean isLoadCanceled()
    {
        return g;
    }

    public final void load()
    {
        int i = 0;
_L4:
        if (i != 0 || g)
        {
            break; /* Loop/switch isn't completed */
        }
        long l1;
        long l2;
        l2 = f.position;
        l1 = b.open(new DataSpec(a, l2, -1L, null));
        long l;
        l = l1;
        if (l1 != -1L)
        {
            l = l1 + l2;
        }
        Object obj = new DefaultExtractorInput(b, l2, l);
        Object obj1;
        obj1 = c.a(((ExtractorInput) (obj)));
        if (h)
        {
            ((Extractor) (obj1)).seek();
            h = false;
        }
_L2:
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        int j;
        if (g)
        {
            break; /* Loop/switch isn't completed */
        }
        d.blockWhileTotalBytesAllocatedExceeds(e);
        j = ((Extractor) (obj1)).read(((ExtractorInput) (obj)), f);
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        if (i == 1)
        {
            i = 0;
        } else
        {
            f.position = ((ExtractorInput) (obj)).getPosition();
        }
        b.close();
        if (true) goto _L4; else goto _L3
        obj;
        obj1 = null;
_L6:
        if (i != 1 && obj1 != null)
        {
            f.position = ((ExtractorInput) (obj1)).getPosition();
        }
        b.close();
        throw obj;
_L3:
        return;
        Exception exception;
        exception;
        Object obj2 = obj;
        obj = exception;
        exception = ((Exception) (obj2));
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        exception = ((Exception) (obj));
        obj = exception1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public (Uri uri, DataSource datasource,  , Allocator allocator, int i, long l)
    {
        a = (Uri)Assertions.checkNotNull(uri);
        b = (DataSource)Assertions.checkNotNull(datasource);
        c = (c)Assertions.checkNotNull();
        d = (Allocator)Assertions.checkNotNull(allocator);
        e = i;
        f.position = l;
        h = true;
    }
}
