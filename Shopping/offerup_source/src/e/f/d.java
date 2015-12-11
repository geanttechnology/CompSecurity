// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.f;

import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package e.f:
//            e, a, b, c, 
//            f

public final class d
{

    private static final d a = new d();
    private static a e = new e();
    private final AtomicReference b = new AtomicReference();
    private final AtomicReference c = new AtomicReference();
    private final AtomicReference d = new AtomicReference();

    d()
    {
    }

    public static d a()
    {
        return a;
    }

    private static Object a(Class class1)
    {
        String s = class1.getSimpleName();
        String s1 = System.getProperty((new StringBuilder("rxjava.plugin.")).append(s).append(".implementation").toString());
        if (s1 != null)
        {
            try
            {
                class1 = ((Class) (Class.forName(s1).asSubclass(class1).newInstance()));
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RuntimeException((new StringBuilder()).append(s).append(" implementation is not an instance of ").append(s).append(": ").append(s1).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RuntimeException((new StringBuilder()).append(s).append(" implementation class not found: ").append(s1).toString(), class1);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RuntimeException((new StringBuilder()).append(s).append(" implementation not able to be instantiated: ").append(s1).toString(), class1);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RuntimeException((new StringBuilder()).append(s).append(" implementation not able to be accessed: ").append(s1).toString(), class1);
            }
            return class1;
        } else
        {
            return null;
        }
    }

    public final a b()
    {
        if (b.get() == null)
        {
            Object obj = a(e/f/a);
            if (obj == null)
            {
                b.compareAndSet(null, e);
            } else
            {
                b.compareAndSet(null, (a)obj);
            }
        }
        return (a)b.get();
    }

    public final b c()
    {
        if (c.get() == null)
        {
            Object obj = a(e/f/b);
            if (obj == null)
            {
                c.compareAndSet(null, e.f.c.a());
            } else
            {
                c.compareAndSet(null, (b)obj);
            }
        }
        return (b)c.get();
    }

    public final f d()
    {
        if (d.get() == null)
        {
            Object obj = a(e/f/f);
            if (obj == null)
            {
                d.compareAndSet(null, f.d());
            } else
            {
                d.compareAndSet(null, (f)obj);
            }
        }
        return (f)d.get();
    }

}
