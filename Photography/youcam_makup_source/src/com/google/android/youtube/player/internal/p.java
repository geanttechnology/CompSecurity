// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.youtube.player.YouTubeThumbnailView;

// Referenced classes of package com.google.android.youtube.player.internal:
//            a, ac, b, k

public final class p extends a
{

    private final Handler a = new Handler(Looper.getMainLooper());
    private b b;
    private k c;
    private boolean d;
    private boolean e;

    public p(b b1, YouTubeThumbnailView youtubethumbnailview)
    {
        super(youtubethumbnailview);
        b = (b)ac.a(b1, "connectionClient cannot be null");
        c = b1.a(new a((byte)0));
    }

    static Handler a(p p1)
    {
        return p1.a;
    }

    static boolean a(p p1, boolean flag)
    {
        p1.d = flag;
        return flag;
    }

    static boolean b(p p1, boolean flag)
    {
        p1.e = flag;
        return flag;
    }

    public final void a(String s)
    {
        try
        {
            c.a(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException(s);
        }
    }

    public final void a(String s, int i)
    {
        try
        {
            c.a(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException(s);
        }
    }

    protected final boolean a()
    {
        return super.a() && c != null;
    }

    public final void b()
    {
        try
        {
            c.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
    }

    public final void c()
    {
        try
        {
            c.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
    }

    public final void d()
    {
        try
        {
            c.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
    }

    public final boolean e()
    {
        return e;
    }

    public final boolean f()
    {
        return d;
    }

    public final void g()
    {
        try
        {
            c.d();
        }
        catch (RemoteException remoteexception) { }
        b.d();
        c = null;
        b = null;
    }

    private class a extends j.a
    {

        final p a;

        public final void a(Bitmap bitmap, String s, boolean flag, boolean flag1)
        {
            p.a(a).post(new Runnable(flag, flag1, bitmap, s) {

                final boolean a;
                final boolean b;
                final Bitmap c;
                final String d;
                final a e;

                public final void run()
                {
                    p.a(e.a, a);
                    p.b(e.a, b);
                    e.a.a(c, d);
                }

                
                {
                    e = a.this;
                    a = flag;
                    b = flag1;
                    c = bitmap;
                    d = s;
                    super();
                }
            });
        }

        public final void a(String s, boolean flag, boolean flag1)
        {
            p.a(a).post(new Runnable(flag, flag1, s) {

                final boolean a;
                final boolean b;
                final String c;
                final a d;

                public final void run()
                {
                    p.a(d.a, a);
                    p.b(d.a, b);
                    d.a.b(c);
                }

                
                {
                    d = a.this;
                    a = flag;
                    b = flag1;
                    c = s;
                    super();
                }
            });
        }

        private a()
        {
            a = p.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

}
