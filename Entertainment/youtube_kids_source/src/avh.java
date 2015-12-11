// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.List;

final class avh
    implements awo
{

    private final long a;
    private avg b;

    avh(avg avg1, long l)
    {
        b = avg1;
        super();
        a = l;
    }

    public final void a(awn awn)
    {
        awn = (Status)awn;
        if (!awn.a())
        {
            azw azw1 = b.b.b;
            long l = a;
            int i = ((Status) (awn)).e;
            for (awn = azw1.d.iterator(); awn.hasNext(); ((baa)awn.next()).a(l, i, null)) { }
        }
    }
}
