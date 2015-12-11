// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;


// Referenced classes of package c:
//            r, c, t

public abstract class h
    implements r
{

    private final r a;

    public h(r r1)
    {
        if (r1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            a = r1;
            return;
        }
    }

    public void a_(c c, long l)
    {
        a.a_(c, l);
    }

    public void close()
    {
        a.close();
    }

    public void flush()
    {
        a.flush();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(a.toString()).append(")").toString();
    }

    public final t w_()
    {
        return a.w_();
    }
}
