// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Hashtable;

public final class cl
    implements cg
{
    public static interface a
    {

        public abstract void a(String s);
    }

    public static final class b
    {

        b()
        {
        }
    }


    private final cm a;
    private final Hashtable b = new Hashtable();
    private boolean c;

    private cl(cm cm1, a a1)
    {
        c = false;
        a = cm1;
        ((ch)a.c).a(cm1, a1);
    }

    static cl a(cj cj1, String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("eventName is null.");
        } else
        {
            return new cl(new ck(cj1, s), null);
        }
    }

    static cl a(cm cm1, String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("eventName is null.");
        } else
        {
            return new cl(new ci(cm1, s), null);
        }
    }

    public static cl a(cm cm1, String s, a a1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("eventName is null.");
        } else
        {
            return new cl(new cj(cm1, s), a1);
        }
    }

    static cl a(String s, String s1, String s2, int i, ch ch1, String s3)
    {
        if (s3 == null)
        {
            throw new IllegalArgumentException("eventName is null.");
        } else
        {
            return new cl(new ck(s, s1, s2, i, ch1, s3), null);
        }
    }

    public final ce a()
    {
        return a(null);
    }

    public final ce a(b b1)
    {
        if (!c)
        {
            a.a(b, b1);
            c = true;
        }
        return a;
    }

    public final cg a(String s, int i)
        throws cf
    {
        if (c)
        {
            throw new cf("SessionEvent is alreadt committed.");
        } else
        {
            b.put(s, new Integer(i));
            return this;
        }
    }

    public final cg a(String s, String s1)
        throws cf
    {
        if (c)
        {
            throw new cf("SessionEvent is alreadt committed.");
        } else
        {
            b.put(s, s1);
            return this;
        }
    }

    public final cg a(String s, boolean flag)
        throws cf
    {
        if (c)
        {
            throw new cf("SessionEvent is alreadt committed.");
        } else
        {
            b.put(s, new Boolean(flag));
            return this;
        }
    }

    public final ce b()
    {
        if (a instanceof cj)
        {
            ((cj)a).a = Boolean.valueOf(true);
        }
        if (!c)
        {
            a.a(b, null);
            c = true;
        }
        return a;
    }
}
