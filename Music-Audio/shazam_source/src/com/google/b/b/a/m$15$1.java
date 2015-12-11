// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;
import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package com.google.b.b.a:
//            m

final class a extends x
{

    final x a;
    final a b;

    public final Object a(a a1)
    {
        a1 = (Date)a.a(a1);
        if (a1 != null)
        {
            return new Timestamp(a1.getTime());
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

    ( , x x1)
    {
        b = ;
        a = x1;
        super();
    }

    // Unreferenced inner class com/google/b/b/a/m$15

/* anonymous class */
    static final class m._cls15
        implements y
    {

        public final x a(f f1, com.google.b.c.a a1)
        {
            if (a1.a != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return new m._cls15._cls1(this, f1.a(java/util/Date));
            }
        }

    }

}
