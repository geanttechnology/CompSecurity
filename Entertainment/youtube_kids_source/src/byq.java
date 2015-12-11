// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Iterator;

final class byq
    implements biq
{

    private byk a;

    byq(byk byk1)
    {
        a = byk1;
        super();
    }

    public final void a(Object obj, Object obj1, bid bid1)
    {
        obj = (cnz)obj1;
        cdu cdu1;
        Object obj2;
        for (obj1 = ((cpv)((cnz) (obj)).a).iterator(); ((Iterator) (obj1)).hasNext(); bid1.a(bzi.a(((android.net.Uri.Builder) (obj2)).build()), new cnz(cdu1, ((cnz) (obj)).b)))
        {
            cdu1 = (cdu)((Iterator) (obj1)).next();
            obj2 = a.a;
            obj2 = cdu1.c.buildUpon();
            bzl.a(((android.net.Uri.Builder) (obj2)), 1, 0);
        }

    }
}
