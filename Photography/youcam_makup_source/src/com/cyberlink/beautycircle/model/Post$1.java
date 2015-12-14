// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.model.database.a.a;
import com.cyberlink.beautycircle.model.database.b;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            Post

final class a extends j
{

    final long a;

    protected Post a(Void void1)
    {
        void1 = b.c().a(a);
        if (void1 != null)
        {
            return void1;
        } else
        {
            return null;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    e.a.a(long l)
    {
        a = l;
        super();
    }
}
