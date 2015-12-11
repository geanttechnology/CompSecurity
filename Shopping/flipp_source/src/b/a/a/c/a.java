// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.c;
import java.io.Serializable;
import java.util.Locale;

// Referenced classes of package b.a.a.c:
//            g

public abstract class a
    implements Serializable
{

    public a()
    {
    }

    private int d()
    {
        return a().a(b());
    }

    public abstract c a();

    public final String a(Locale locale)
    {
        return a().a(b(), locale);
    }

    public abstract long b();

    public final String b(Locale locale)
    {
        return a().b(b(), locale);
    }

    public b.a.a.a c()
    {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof a))
            {
                return false;
            }
            obj = (a)obj;
            if (d() != ((a) (obj)).d() || !a().a().equals(((a) (obj)).a().a()) || !g.a(c(), ((a) (obj)).c()))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return d() * 17 + a().a().hashCode() + c().hashCode();
    }

    public String toString()
    {
        return (new StringBuilder("Property[")).append(a().b()).append("]").toString();
    }
}
