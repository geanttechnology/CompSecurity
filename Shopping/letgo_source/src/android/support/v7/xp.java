// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.x;
import java.util.List;

// Referenced classes of package android.support.v7:
//            vo, xf, abo, xa, 
//            xg, xd, vn

public abstract class xp
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(android/support/v7/xp$a, s);
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

    public class b
    {

        private final Object a;
        private final xg.a.a b;
        private final long c;

        public Object a()
        {
            return a;
        }

        public xg.a.a b()
        {
            return b;
        }

        public long c()
        {
            return c;
        }
    }


    private xf a;
    private xd b;
    private vn c;

    public xp(xf xf1, xd xd1)
    {
        this(xf1, xd1, vo.d());
    }

    public xp(xf xf1, xd xd1, vn vn1)
    {
        boolean flag = true;
        super();
        if (xf1.a().size() != 1)
        {
            flag = false;
        }
        x.b(flag);
        a = xf1;
        b = xd1;
        c = vn1;
    }

    protected abstract b a(xa xa1);

    protected abstract void a(xg xg1);

    public void a(a a1)
    {
        abo.a((new StringBuilder()).append("ResourceManager: Failed to download a resource: ").append(a1.name()).toString());
        a1 = (xa)a.a().get(0);
        b b1 = a(((xa) (a1)));
        if (b1 != null && (b1.a() instanceof xh.c))
        {
            a1 = new xg.a(Status.a, a1, null, (xh.c)b1.a(), b1.b(), b1.c());
        } else
        {
            a1 = new xg.a(Status.c, a1, xg.a.a.a);
        }
        a(new xg(a1));
    }

    public void a(byte abyte0[])
    {
        Object obj;
        xg.a.a a1;
        xg.a.a a2;
        xa xa1;
        long l;
        long l1;
        abo.d((new StringBuilder()).append("ResourceManager: Resource downloaded from Network: ").append(a.b()).toString());
        xa1 = (xa)a.a().get(0);
        a2 = xg.a.a.a;
        obj = null;
        l1 = 0L;
        l = l1;
        a1 = a2;
        Object obj1 = b.a(abyte0);
        l = l1;
        obj = obj1;
        a1 = a2;
        l1 = c.a();
        l = l1;
        obj = obj1;
        a1 = a2;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        l = l1;
        obj = obj1;
        a1 = a2;
        abo.c("Parsed resource from network is null");
        l = l1;
        obj = obj1;
        a1 = a2;
        b b2 = a(xa1);
        l = l1;
        obj = obj1;
        a1 = a2;
        if (b2 == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        l = l1;
        obj = obj1;
        a1 = a2;
        obj1 = b2.a();
        l = l1;
        obj = obj1;
        a1 = a2;
        a2 = b2.b();
        l = l1;
        obj = obj1;
        a1 = a2;
        l1 = b2.c();
        l = l1;
        a1 = a2;
        obj = obj1;
_L1:
        xh.g g;
        b b1;
        if (obj != null)
        {
            abyte0 = new xg.a(Status.a, xa1, abyte0, (xh.c)obj, a1, l);
        } else
        {
            abyte0 = new xg.a(Status.c, xa1, xg.a.a.a);
        }
        a(new xg(abyte0));
        return;
        g;
        abo.c("Resource from network is corrupted");
        b1 = a(xa1);
        if (b1 != null)
        {
            obj = b1.a();
            a1 = b1.b();
        }
          goto _L1
    }
}
