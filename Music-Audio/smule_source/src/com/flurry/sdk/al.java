// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.os.FileObserver;
import android.os.Handler;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.flurry.sdk:
//            ct, kb, gd, hp, 
//            ho, fp, hq

public class al
{

    private static final String a = com/flurry/sdk/al.getSimpleName();
    private final String b;
    private final long c;
    private final boolean d;
    private FileObserver e;
    private kb f;

    public al(String s, long l, boolean flag)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("The cache must have a name");
        } else
        {
            b = s;
            c = l;
            d = flag;
            return;
        }
    }

    static String a(al al1)
    {
        return al1.b;
    }

    static kb b(al al1)
    {
        return al1.f;
    }

    static String e()
    {
        return a;
    }

    public b a(String s)
    {
        while (f == null || s == null) 
        {
            return null;
        }
        Object obj;
        try
        {
            obj = f.a(ct.c(s));
        }
        catch (IOException ioexception)
        {
            gd.a(3, a, (new StringBuilder()).append("Exception during getReader for cache: ").append(b).append(" key: ").append(s).toString(), ioexception);
            hp.a(null);
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = new b(((kb.c) (obj)), d);
        s = ((String) (obj));
_L4:
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a()
    {
        Object obj;
        try
        {
            obj = new File(ct.a(b), "canary");
            if (!ho.a(((File) (obj))) || !((File) (obj)).exists() && !((File) (obj)).createNewFile())
            {
                throw new IOException("Could not create canary file.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            gd.a(3, a, (new StringBuilder()).append("Could not open cache: ").append(b).toString());
            return;
        }
        e = new FileObserver(((File) (obj)).getAbsolutePath()) {

            final al a;

            public void onEvent(int i, String s)
            {
                if ((i & 0x800) != 0 || (i & 0x400) != 0)
                {
                    fp.a().f().post(new hq(this) {

                        final _cls1 a;

                        public void safeRun()
                        {
                            if (al.b(a.a) == null)
                            {
                                return;
                            } else
                            {
                                a.a.b();
                                a.a.a();
                                return;
                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }
            }

            
            {
                a = al.this;
                super(s);
            }
        };
        e.startWatching();
        f = kb.a(ct.a(b), 1, 1, c);
        return;
    }

    public c b(String s)
    {
        while (f == null || s == null) 
        {
            return null;
        }
        Object obj;
        try
        {
            obj = f.b(ct.c(s));
        }
        catch (IOException ioexception)
        {
            gd.a(3, a, (new StringBuilder()).append("Exception during getWriter for cache: ").append(b).append(" key: ").append(s).toString(), ioexception);
            hp.a(null);
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = new c(((kb.a) (obj)), d);
        s = ((String) (obj));
_L4:
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void b()
    {
        if (e != null)
        {
            e.stopWatching();
            e = null;
        }
        hp.a(f);
    }

    public void c()
    {
        d();
        a();
    }

    public boolean c(String s)
    {
        while (f == null || s == null) 
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = f.c(ct.c(s));
        }
        catch (IOException ioexception)
        {
            gd.a(3, a, (new StringBuilder()).append("Exception during remove for cache: ").append(b).append(" key: ").append(s).toString(), ioexception);
            return false;
        }
        return flag;
    }

    public void d()
    {
        if (f == null)
        {
            return;
        }
        try
        {
            f.a();
            return;
        }
        catch (IOException ioexception)
        {
            gd.a(3, a, (new StringBuilder()).append("Exception during delete for cache: ").append(b).toString(), ioexception);
        }
    }

    public boolean d(String s)
    {
        boolean flag;
        for (flag = false; f == null || s == null;)
        {
            return false;
        }

        s = f.a(ct.c(s));
        if (s != null)
        {
            flag = true;
        }
        hp.a(s);
        return flag;
        s;
        gd.a(3, a, (new StringBuilder()).append("Exception during exists for cache: ").append(b).toString(), s);
        hp.a(null);
        return false;
        s;
        hp.a(null);
        throw s;
    }

    protected void finalize()
    {
        super.finalize();
        b();
    }


    private class b
        implements Closeable
    {

        final al a;
        private final kb.c b;
        private final InputStream c;
        private final GZIPInputStream d;
        private final BufferedInputStream e;
        private boolean f;

        public InputStream a()
        {
            return e;
        }

        public void close()
        {
            if (f)
            {
                return;
            } else
            {
                f = true;
                hp.a(e);
                hp.a(d);
                hp.a(c);
                hp.a(b);
                return;
            }
        }

        protected void finalize()
        {
            super.finalize();
            close();
        }

        private b(kb.c c1, boolean flag)
        {
            a = al.this;
            super();
            if (c1 == null)
            {
                throw new IllegalArgumentException("Snapshot cannot be null");
            }
            b = c1;
            c = b.a(0);
            if (c == null)
            {
                throw new IOException("Snapshot inputstream is null");
            }
            if (flag)
            {
                d = new GZIPInputStream(c);
                if (d == null)
                {
                    throw new IOException("Gzip inputstream is null");
                } else
                {
                    e = new BufferedInputStream(d);
                    return;
                }
            } else
            {
                d = null;
                e = new BufferedInputStream(c);
                return;
            }
        }

    }


    private class c
        implements Closeable
    {
        private class a extends BufferedOutputStream
        {

            private boolean a;

            private boolean a()
            {
                return a;
            }

            static boolean a(a a1)
            {
                return a1.a();
            }

            public void close()
            {
                try
                {
                    super.close();
                    return;
                }
                catch (IOException ioexception)
                {
                    a = true;
                    throw ioexception;
                }
            }

            public void flush()
            {
                try
                {
                    super.flush();
                    return;
                }
                catch (IOException ioexception)
                {
                    a = true;
                    throw ioexception;
                }
            }

            public void write(int i)
            {
                try
                {
                    super.write(i);
                    return;
                }
                catch (IOException ioexception)
                {
                    a = true;
                    throw ioexception;
                }
            }

            public void write(byte abyte0[])
            {
                try
                {
                    super.write(abyte0);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    a = true;
                }
                throw abyte0;
            }

            public void write(byte abyte0[], int i, int j)
            {
                try
                {
                    super.write(abyte0, i, j);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    a = true;
                }
                throw abyte0;
            }

            private a(OutputStream outputstream)
            {
                super(outputstream);
                a = false;
            }

        }


        final al a;
        private final kb.a b;
        private final OutputStream c;
        private final GZIPOutputStream d;
        private final a e;
        private boolean f;

        public OutputStream a()
        {
            return e;
        }

        public void close()
        {
            boolean flag = true;
            if (!f) goto _L2; else goto _L1
_L1:
            return;
_L2:
            f = true;
            hp.a(e);
            hp.a(d);
            hp.a(c);
            if (b == null) goto _L1; else goto _L3
_L3:
            if (e != null)
            {
                flag = a.a(e);
            }
            if (flag)
            {
                try
                {
                    b.b();
                    return;
                }
                catch (IOException ioexception)
                {
                    gd.a(3, al.e(), (new StringBuilder()).append("Exception closing editor for cache: ").append(al.a(a)).toString(), ioexception);
                }
                return;
            }
            b.a();
            return;
        }

        protected void finalize()
        {
            super.finalize();
            close();
        }

        private c(kb.a a1, boolean flag)
        {
            a = al.this;
            super();
            if (a1 == null)
            {
                throw new IllegalArgumentException("Editor cannot be null");
            }
            b = a1;
            c = b.a(0);
            if (c == null)
            {
                throw new IOException("Editor outputstream is null");
            }
            if (flag)
            {
                d = new GZIPOutputStream(c);
                if (d == null)
                {
                    throw new IOException("Gzip outputstream is null");
                } else
                {
                    e = new a(d);
                    return;
                }
            } else
            {
                d = null;
                e = new a(c);
                return;
            }
        }

    }

}
