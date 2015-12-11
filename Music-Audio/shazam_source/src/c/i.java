// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;


// Referenced classes of package c:
//            s, c, t

public abstract class i
    implements s
{

    private final s a;

    public i(s s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            a = s1;
            return;
        }
    }

    public long a(c c, long l)
    {
        return a.a(c, l);
    }

    public void close()
    {
        a.close();
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
