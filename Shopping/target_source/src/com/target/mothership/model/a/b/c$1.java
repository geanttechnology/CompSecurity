// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.a.b;

import com.target.mothership.model.a.c.a;
import com.target.mothership.services.e.b.b.b;

// Referenced classes of package com.target.mothership.model.a.b:
//            c

class .a
    implements a
{

    final c this$0;
    final com.target.mothership.services.e.b.b.a val$data;

    public int a()
    {
        if (val$data.b() == null)
        {
            return -1;
        }
        int i;
        try
        {
            i = Integer.parseInt(val$data.b().b());
        }
        catch (NumberFormatException numberformatexception)
        {
            return -1;
        }
        return i;
    }

    public String b()
    {
        if (val$data.b() == null)
        {
            return val$data.a();
        } else
        {
            return val$data.b().a();
        }
    }

    public String c()
    {
        return val$data.a();
    }

    .a()
    {
        this$0 = final_c1;
        val$data = com.target.mothership.services.e.b.b.a.this;
        super();
    }
}
