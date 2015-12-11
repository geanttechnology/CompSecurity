// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.model.TrackCategory;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.shazam.android.af.b:
//            i, k, e, f, 
//            b, d

public final class com.shazam.android.af.b.a
    implements i, k
{
    private final class a
        implements Runnable
    {

        final com.shazam.android.af.b.a a;
        private final MediaPlayer b;

        public final void run()
        {
            b.release();
        }

        public a(MediaPlayer mediaplayer)
        {
            a = com.shazam.android.af.b.a.this;
            super();
            b = mediaplayer;
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        private static final b c[];
        private final String b;

        static String a(b b1)
        {
            return b1.b;
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/shazam/android/af/b/a$b, s1);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("TRACK_DETAILS_SCREEN", "tagresult");
            c = (new b[] {
                a
            });
        }

        private b(String s1, String s2)
        {
            super(s1, 0);
            b = s2;
        }
    }


    public static final SparseArray b = new SparseArray() {

            
            {
                put(200, "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK");
                put(100, "MEDIA_ERROR_SERVER_DIED");
                put(1, "MEDIA_ERROR_UNKNOWN");
            }
    };
    public static final SparseArray c = new SparseArray() {

            
            {
                put(800, "MEDIA_INFO_BAD_INTERLEAVING");
                put(801, "MEDIA_INFO_NOT_SEEKABLE");
                put(1, "MEDIA_INFO_UNKNOWN");
                put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
            }
    };
    public boolean a;
    private MediaPlayer e;
    private volatile f f;
    private volatile int g;
    private volatile boolean h;
    private final String i;
    private e j;
    private final Handler k;
    private final String l;
    private final TrackCategory m;
    private final String n;
    private final com.shazam.android.af.b.b o;
    private final Executor p = Executors.newSingleThreadExecutor(com.shazam.i.q.a.b("DefaultStatefulStreamPlayer-%d").b());
    private final b q;
    private final EventAnalytics r;
    private final Runnable s = new Runnable() {

        final com.shazam.android.af.b.a a;

        public final void run()
        {
            synchronized (a)
            {
                if (com.shazam.android.af.b.a.a(a))
                {
                    com.shazam.android.af.b.a.c(a).postDelayed(com.shazam.android.af.b.a.b(a), 150L);
                }
            }
            return;
            exception;
            a1;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                a = com.shazam.android.af.b.a.this;
                super();
            }
    };

    public com.shazam.android.af.b.a(String s1, String s2, Looper looper, com.shazam.android.af.b.b b1, b b2, TrackCategory trackcategory, EventAnalytics eventanalytics)
    {
        g = 0;
        h = false;
        a = false;
        j = e.a;
        if (com.shazam.b.e.a.a(s1))
        {
            throw new IllegalArgumentException("DefaultStatefulStreamPlayer expects a nonempty non null stream url");
        } else
        {
            l = s2;
            n = null;
            i = s1;
            m = trackcategory;
            q = b2;
            f = f.a;
            o = b1;
            k = new Handler(looper);
            r = eventanalytics;
            return;
        }
    }

    static boolean a(com.shazam.android.af.b.a a1)
    {
        return a1.h;
    }

    static Runnable b(com.shazam.android.af.b.a a1)
    {
        return a1.s;
    }

    static Handler c(com.shazam.android.af.b.a a1)
    {
        return a1.k;
    }

    static void d(com.shazam.android.af.b.a a1)
    {
        a1.g();
    }

    private void g()
    {
        j.a(i, l, true);
    }

    private void h()
    {
        this;
        JVM INSTR monitorenter ;
        if (e != null)
        {
            e.setOnBufferingUpdateListener(this);
            e.setOnCompletionListener(this);
            e.setOnErrorListener(this);
            e.setOnInfoListener(this);
            e.setOnPreparedListener(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (e != null)
        {
            e.setOnBufferingUpdateListener(null);
            e.setOnCompletionListener(null);
            e.setOnErrorListener(null);
            e.setOnInfoListener(null);
            e.setOnPreparedListener(null);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        f.a(d1, this);
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        throw d1;
    }

    public final void a(e e1)
    {
        j = e1;
    }

    public final void a(f f1)
    {
        this;
        JVM INSTR monitorenter ;
        f = f1;
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        e = o.a();
        (new StringBuilder("Setting media player data source to : ")).append(i);
        h();
        e.setDataSource(i);
        e.prepareAsync();
        boolean flag = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        Object obj;
        obj;
        g();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (e != null)
        {
            i();
            p.execute(new a(e));
            e = null;
        }
        h = false;
        g = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean c()
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        if (e == null || e.isPlaying()) goto _L2; else goto _L1
_L1:
        a = false;
        e.start();
        Object obj = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "previewplay").putNotEmptyOrNullParameter(DefinedEventParameterKey.PREVIEW_URL, i).putNotEmptyOrNullParameter(DefinedEventParameterKey.MATCH_CATEGORY, m.toString()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, n).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, b.a(q)).build();
        obj = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(((com.shazam.android.analytics.event.EventParameters) (obj))).build();
        r.logEvent(((com.shazam.android.analytics.event.Event) (obj)));
        boolean flag = flag1;
        if (h)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        h = true;
        k.postDelayed(s, 150L);
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (e != null)
        {
            e.pause();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void e()
    {
        h = false;
    }

    public final f f()
    {
        this;
        JVM INSTR monitorenter ;
        f f1 = f;
        this;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onBufferingUpdate(MediaPlayer mediaplayer, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        int j1 = g;
        if (j1 != 100) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (i1 > g)
        {
            g = i1;
        }
        if (i1 != 100)
        {
            continue; /* Loop/switch isn't completed */
        }
        k.postDelayed(new Runnable() {

            final com.shazam.android.af.b.a a;

            public final void run()
            {
                f f1 = a.f();
                if (f1 != f.d && f1 != f.e)
                {
                    a.a(d.d);
                    com.shazam.android.af.b.a.d(a);
                }
            }

            
            {
                a = com.shazam.android.af.b.a.this;
                super();
            }
        }, 300L);
        if (true) goto _L1; else goto _L3
_L3:
        mediaplayer;
        throw mediaplayer;
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a = true;
        a(d.c);
        j.a(i, l, false);
    }

    public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        this;
        JVM INSTR monitorenter ;
        mediaplayer = (String)b.get(i1);
        if (mediaplayer == null)
        {
            mediaplayer = "Unknown error.";
        }
        a(d.d);
        g();
        this;
        JVM INSTR monitorexit ;
        return true;
        mediaplayer;
        throw mediaplayer;
    }

    public final boolean onInfo(MediaPlayer mediaplayer, int i1, int j1)
    {
        mediaplayer = (String)c.get(i1);
        if (mediaplayer != null)
        {
            mediaplayer = (new StringBuilder("Media Player info: ")).append(mediaplayer).toString();
        } else
        {
            mediaplayer = "Unknown warning.";
        }
        return true;
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        a(d.b);
    }

}
