// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import io.presage.model.Zone;
import io.presage.try.b;
import io.presage.try.h;
import io.presage.utils.n;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.for:
//            b

final class i
    implements Runnable
{

    final String a;
    final io.presage.for.b b;

    i(io.presage.for.b b1, String s)
    {
        b = b1;
        a = s;
        super();
    }

    public final void run()
    {
        Object obj = (Zone)(new Gson()).fromJson(a, io/presage/model/Zone);
        if (((Zone) (obj)).isVideo())
        {
            obj = io.presage.try.b.a(io.presage.for.b.a(b).getContext(), ((Zone) (obj)));
        } else
        {
            obj = n.a(io.presage.for.b.a(b).getContext(), ((Zone) (obj)));
        }
        io.presage.for.b.a(b).a(((io.presage.try.a) (obj)));
    }
}
