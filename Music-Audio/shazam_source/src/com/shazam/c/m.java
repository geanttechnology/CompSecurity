// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;
import com.shazam.server.response.actions.Actions;
import java.util.List;

// Referenced classes of package com.shazam.c:
//            i

public final class m
    implements a
{

    private final i a;

    public m(i j)
    {
        a = j;
    }

    public final Object a(Object obj)
    {
        obj = (Actions)obj;
        obj = (List)a.a(((Actions) (obj)).actions);
        com.shazam.model.Actions.Builder builder = com.shazam.model.Actions.Builder.a();
        builder.actions = ((List) (obj));
        return builder.b();
    }
}
