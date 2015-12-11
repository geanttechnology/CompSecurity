// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.e.aj;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            ij, kd, jy, ke, 
//            kb, ii

public abstract class kn
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/android/gms/d/kn$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("NOT_AVAILABLE", 0);
            b = new a("IO_ERROR", 1);
            c = new a("SERVER_ERROR", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private kd a;
    private kb b;
    private ii c;

    public kn(kd kd1, kb kb1)
    {
        this(kd1, kb1, ij.d());
    }

    private kn(kd kd1, kb kb1, ii ii1)
    {
        boolean flag = true;
        super();
        if (kd1.a.size() != 1)
        {
            flag = false;
        }
        w.b(flag);
        a = kd1;
        b = kb1;
        c = ii1;
    }

    protected abstract void a(ke ke1);

    public final void a(a a1)
    {
        aj.a((new StringBuilder("ResourceManager: Failed to download a resource: ")).append(a1.name()).toString());
        a1 = (jy)a.a.get(0);
        a(new ke(new ke.a(Status.c, a1, ke.a.a.a)));
    }

    public final void a(byte abyte0[])
    {
        Object obj;
        jy jy1;
        ke.a.a a1;
        long l;
        long l1;
        (new StringBuilder("ResourceManager: Resource downloaded from Network: ")).append(a.a());
        aj.d();
        jy1 = (jy)a.a.get(0);
        a1 = ke.a.a.a;
        obj = null;
        l1 = 0L;
        l = l1;
        Object obj1 = b.a(abyte0);
        l = l1;
        obj = obj1;
        l1 = c.a();
        if (obj1 == null)
        {
            l = l1;
            obj = obj1;
            try
            {
                aj.c();
            }
            catch (kf.g g)
            {
                aj.c();
                g = ((kf.g) (obj));
                l1 = l;
            }
        }
        if (obj1 != null)
        {
            abyte0 = new ke.a(Status.a, jy1, abyte0, (kf.c)obj1, a1, l1);
        } else
        {
            abyte0 = new ke.a(Status.c, jy1, ke.a.a.a);
        }
        a(new ke(abyte0));
        return;
    }
}
