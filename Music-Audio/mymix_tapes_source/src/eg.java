// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public interface eg
{
    public static final class a
    {

        private String a;

        public final String toString()
        {
            return a;
        }

        private a(String s)
        {
            a = s;
        }

        a(String s, byte byte0)
        {
            this(s);
        }
    }


    public abstract void a()
        throws da, db;

    public abstract void a(bj.j j)
        throws da, db;

    
    {
        new a("ABORT_END", (byte)0);
        new a("ABORT_BACK", (byte)0);
        new a("ABORT_NEW", (byte)0);
        new a("STOPPED_TOO_SOON", (byte)0);
        new a("PREEMPTED", (byte)0);
    }
}
