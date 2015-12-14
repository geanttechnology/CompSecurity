// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cz
{
    public static final class a extends bw
    {

        public static final a a = new a((short)0);
        public static final a b = new a((short)1);
        public static final a c = new a((short)2);
        public static final a d = new a((short)3);
        public static final a e = new a((short)4);
        public static final a f = new a((short)5);
        public static final a g = new a((short)6);
        public static final a h = new a((short)7);
        public static final a i = new a((short)8);
        public static final a j = new a((short)9);

        public final String toString()
        {
            if (a(b))
            {
                return "nmsp";
            }
            if (a(c))
            {
                return "app";
            }
            if (a(d))
            {
                return "nss";
            }
            if (a(e))
            {
                return "slog";
            }
            if (a(f))
            {
                return "nsslog";
            }
            if (a(g))
            {
                return "gwlog";
            }
            if (a(h))
            {
                return "svsp";
            }
            if (a(i))
            {
                return "sip";
            }
            if (a(j))
            {
                return "sdp";
            }
            if (a(a))
            {
                return "sdk";
            } else
            {
                return null;
            }
        }


        private a(short word0)
        {
            super(word0);
        }
    }


    private String a;
    private Object b;
    private a c;

    public cz(String s, a a1)
    {
        a = s;
        b = new byte[0];
        c = a1;
    }

    public cz(String s, Object obj, a a1)
    {
        a = s;
        b = obj;
        c = a1;
    }

    public final String a()
    {
        return a;
    }

    public final byte[] b()
    {
        if (b instanceof byte[])
        {
            return (byte[])b;
        } else
        {
            return "THIS IS NOT A STRING PARAMETER!!!".getBytes();
        }
    }

    public final Object c()
    {
        return b;
    }

    public final Object clone()
        throws CloneNotSupportedException
    {
        return e();
    }

    public final a d()
    {
        return c;
    }

    public final cz e()
    {
        Object obj = b;
        if (b instanceof byte[])
        {
            byte abyte0[] = (byte[])b;
            obj = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, obj, 0, abyte0.length);
        }
        return new cz(a, obj, c);
    }
}
