// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.c.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;
import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package com.google.b.b.a:
//            m

static final class _cls1.a
    implements y
{

    public final x a(f f1, a a1)
    {
        if (a1.a != java/sql/Timestamp)
        {
            return null;
        } else
        {
            return new x(f1.a(java/util/Date)) {

                final x a;
                final m._cls15 b;

                public final Object a(com.google.b.d.a a2)
                {
                    a2 = (Date)a.a(a2);
                    if (a2 != null)
                    {
                        return new Timestamp(a2.getTime());
                    } else
                    {
                        return null;
                    }
                }

                public final volatile void a(c c, Object obj)
                {
                    obj = (Timestamp)obj;
                    a.a(c, obj);
                }

            
            {
                b = m._cls15.this;
                a = x1;
                super();
            }
            };
        }
    }

    _cls1.a()
    {
    }
}
