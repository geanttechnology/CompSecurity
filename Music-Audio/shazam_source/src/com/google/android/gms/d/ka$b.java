// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.e.aj;
import java.util.Map;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.d:
//            kn, ka, ke, jy, 
//            ii, kh, kd, kb

public final class b extends kn
{

    final ka a;
    private final b b;

    protected final void a(ke ke1)
    {
        byte abyte0[] = ke1.a;
        Object obj = a;
        Object obj2 = ((a) (abyte0)).e.a;
        Object obj1 = ((e) (abyte0)).a;
        api.Status status = ((a) (abyte0)).f;
        if (((ka) (obj)).d.containsKey(obj2))
        {
            obj2 = (f)((ka) (obj)).d.get(obj2);
            obj2.c = ((ka) (obj)).b.a();
            if (obj1 == Status.a)
            {
                obj2.a = ((Status) (obj1));
                obj2.b = status;
            }
        } else
        {
            ((ka) (obj)).d.put(obj2, new <init>(((Status) (obj1)), status, ((ka) (obj)).b.a()));
        }
        if (((api.Status) (abyte0)).a == Status.a && ((api.Status.a) (abyte0)).b == a.a && ((a.a) (abyte0)).c != null && ((c) (abyte0)).c.length > 0)
        {
            obj = a.a;
            obj1 = ((a) (abyte0)).e.a();
            abyte0 = ((e) (abyte0)).c;
            ((kh) (obj)).d.execute(new <init>(((kh) (obj)), ((String) (obj1)), abyte0));
            aj.d();
            b.a(ke1);
            return;
        }
        obj = new StringBuilder("Response status: ");
        if ((() (abyte0)).a.b())
        {
            ke1 = "SUCCESS";
        } else
        {
            ke1 = "FAILURE";
        }
        ((StringBuilder) (obj)).append(ke1);
        aj.d();
        if ((() (abyte0)).a.b())
        {
            (new StringBuilder("Response source: ")).append((() (abyte0)).b.toString());
            aj.d();
            (new StringBuilder("Response size: ")).append((() (abyte0)).c.length);
            aj.d();
        }
        a.a(((a) (abyte0)).e, b);
    }

    public ervice(ka ka1, kd kd, kb kb, ervice ervice)
    {
        a = ka1;
        super(kd, kb);
        b = ervice;
    }
}
