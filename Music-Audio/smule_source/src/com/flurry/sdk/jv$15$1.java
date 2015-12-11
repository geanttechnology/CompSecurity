// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package com.flurry.sdk:
//            ir, jx, jz, is, 
//            jv, jw, ia

class > extends ir
{

    final ir a;
    final a b;

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

    ( , ir ir1)
    {
        b = ;
        a = ir1;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/jv$15

/* anonymous class */
    final class jv._cls15
        implements is
    {

        public ir a(ia ia1, jw jw1)
        {
            if (jw1.a() != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return new jv._cls15._cls1(this, ia1.a(java/util/Date));
            }
        }

    }

}
