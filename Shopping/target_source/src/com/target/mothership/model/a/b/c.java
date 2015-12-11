// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.a.b;

import com.target.mothership.services.aa;
import com.target.mothership.services.e.b.b.a;
import com.target.mothership.services.e.b.b.b;

public class c
    implements aa
{

    public c()
    {
    }

    public com.target.mothership.model.a.c.a a(final a data)
    {
        return new com.target.mothership.model.a.c.a() {

            final c this$0;
            final a val$data;

            public int a()
            {
                if (data.b() == null)
                {
                    return -1;
                }
                int i;
                try
                {
                    i = Integer.parseInt(data.b().b());
                }
                catch (NumberFormatException numberformatexception)
                {
                    return -1;
                }
                return i;
            }

            public String b()
            {
                if (data.b() == null)
                {
                    return data.a();
                } else
                {
                    return data.b().a();
                }
            }

            public String c()
            {
                return data.a();
            }

            
            {
                this$0 = c.this;
                data = a1;
                super();
            }
        };
    }

    public volatile Object a(Object obj)
    {
        return a((a)obj);
    }
}
