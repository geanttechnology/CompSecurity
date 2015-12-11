// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.CancellationException;

// Referenced classes of package android.support.v7:
//            cu, cp, ct

static final class d
    implements Runnable
{

    final cp a;
    final _cls1.a b;
    final ct c;
    final cu d;

    public void run()
    {
        if (a != null && a.a())
        {
            b.c();
            return;
        }
        Object obj = (cu)c.then(d);
        if (obj == null)
        {
            try
            {
                b.b(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                b.c();
                return;
            }
            catch (Exception exception)
            {
                b.b(exception);
            }
            break MISSING_BLOCK_LABEL_87;
        }
        ((cu) (obj)).a(new ct() {

            final cu._cls7 a;

            public Void a(cu cu1)
            {
                if (a.a != null && a.a.a())
                {
                    a.b.c();
                    return null;
                }
                if (cu1.c())
                {
                    a.b.c();
                    return null;
                }
                if (cu1.d())
                {
                    a.b.b(cu1.f());
                    return null;
                } else
                {
                    a.b.b(cu1.e());
                    return null;
                }
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                a = cu._cls7.this;
                super();
            }
        });
        return;
    }

    _cls1.a(cp cp1, _cls1.a a1, ct ct1, cu cu1)
    {
        a = cp1;
        b = a1;
        c = ct1;
        d = cu1;
        super();
    }
}
