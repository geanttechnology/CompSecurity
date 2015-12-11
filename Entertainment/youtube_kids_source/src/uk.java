// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.text.TextUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class uk
    implements Runnable
{

    volatile boolean a;
    volatile boolean b;
    final ug c;
    private final cto d;
    private volatile Runnable e;
    private final boolean f;

    public uk(ug ug1, cto cto1, boolean flag)
    {
        c = ug1;
        super();
        b = true;
        d = cto1;
        f = flag;
    }

    private crf a()
    {
        crf crf1 = crf.a();
        cud cud1 = c.n;
        cto cto1 = d;
        cud1.a(cto1.a.a, cto1.a.c, cto1.a.d, cto1.a.e, cto1.e(), crf1);
        return crf1;
    }

    private void a(Exception exception)
    {
        c.o.post(new um(this, exception));
    }

    private void b(Exception exception)
    {
        c.o.post(new up(this, exception));
    }

    public final boolean a(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        if (!b)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        e = runnable;
        this;
        JVM INSTR monitorexit ;
        return true;
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public final void run()
    {
        Object obj9 = null;
        Object obj10 = null;
        Object obj8 = null;
        c.d.c(new csv());
        Object obj = d.a.a;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        if (f && TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj2 = a();
            android.net.Uri uri;
            byte abyte0[];
            String s;
            String s1;
            int i;
            try
            {
                obj = ((bum)((crf) (obj2)).get()).e;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                a(((Exception) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                a(((Exception) (obj)));
                return;
            }
        } else
        {
            obj2 = null;
        }
        if (!f) goto _L2; else goto _L1
_L1:
        b.a(obj);
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        if (c.m == null) goto _L4; else goto _L3
_L3:
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        if (d.f() == null) goto _L4; else goto _L5
_L5:
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        obj7 = c.m;
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        uri = d.f();
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        abyte0 = d.e();
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        s = d.a.l;
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        s1 = d.a.c;
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        i = d.a.d;
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        ((cuf) (obj7)).c.a(((String) (obj)), uri);
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        obj7 = ((cuf) (obj7)).b.a(((String) (obj)), abyte0, s, s1, i, -1);
_L6:
        obj = obj2;
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        obj = obj2;
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        if (c.p.n())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        obj = a();
        obj3 = obj;
        obj5 = obj;
        obj6 = obj;
        obj2 = (bxb)((crf) (obj7)).get(ctx.b, TimeUnit.MILLISECONDS);
        b = false;
        c.o.postAtFrontOfQueue(new ul(this, ((bxb) (obj2))));
_L7:
        obj3 = obj;
        if (obj == null)
        {
            obj3 = a();
        }
        try
        {
            obj = (bum)((crf) (obj3)).get();
            c.o.post(new uo(this, ((bum) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            b(((Exception) (obj1)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            b(((Exception) (obj1)));
            return;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        c.o.post(new un(this));
        this;
        JVM INSTR monitorenter ;
        b = true;
        if (e != null)
        {
            c.o.post(e);
        }
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        obj3 = obj2;
        obj5 = obj2;
        obj6 = obj2;
        obj7 = c.a.a(((String) (obj)), d.e(), d.a.l, d.a.c, d.a.d, -1);
          goto _L6
        obj5;
        obj2 = obj8;
        obj = obj3;
        obj3 = obj5;
_L10:
        a(((Exception) (obj3)));
          goto _L7
        obj4;
        obj2 = obj9;
        obj = obj5;
_L9:
        a(((Exception) (obj4)));
          goto _L7
        obj4;
        obj2 = obj10;
        obj = obj6;
_L8:
        a(((Exception) (obj4)));
          goto _L7
_L2:
        obj4 = c.h;
        obj = obj2;
        obj2 = obj4;
          goto _L7
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
        obj4;
          goto _L8
        obj4;
          goto _L9
        obj4;
          goto _L10
    }
}
