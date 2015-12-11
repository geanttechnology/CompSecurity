// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package com.flurry.sdk:
//            is, jv, jw, ia, 
//            ir, jx, jz

final class it>
    implements is
{

    public ir a(ia ia1, jw jw1)
    {
        if (jw1.a() != java/sql/Timestamp)
        {
            return null;
        } else
        {
            return new ir(ia1.a(java/util/Date)) {

                final ir a;
                final jv._cls15 b;

                public Timestamp a(jx jx)
                {
                    jx = (Date)a.b(jx);
                    if (jx != null)
                    {
                        return new Timestamp(jx.getTime());
                    } else
                    {
                        return null;
                    }
                }

                public volatile void a(jz jz, Object obj)
                {
                    a(jz, (Timestamp)obj);
                }

                public void a(jz jz, Timestamp timestamp)
                {
                    a.a(jz, timestamp);
                }

                public Object b(jx jx)
                {
                    return a(jx);
                }

            
            {
                b = jv._cls15.this;
                a = ir1;
                super();
            }
            };
        }
    }

    it>()
    {
    }
}
