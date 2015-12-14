// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import com.nuance.nmsp.client.sdk.oem.e;
import java.io.IOException;

public final class d
    implements ba
{

    private MediaPlayer a;
    private az b;
    private Object c;
    private boolean d;
    private boolean e;
    private AssetFileDescriptor f;

    public d()
    {
        b = null;
        c = null;
        a = null;
        d = false;
        f = null;
        e = false;
    }

    static MediaPlayer a(d d1)
    {
        return d1.a;
    }

    static MediaPlayer a(d d1, MediaPlayer mediaplayer)
    {
        d1.a = mediaplayer;
        return mediaplayer;
    }

    public static bm a(Class class1)
    {
        return new e(class1);
    }

    static void a(d d1, boolean flag)
    {
        ax.a(d1. new Runnable(flag) {

            private boolean a;
            private d b;

            public final void run()
            {
                if (d.a(b) == null || d.b(b))
                {
                    return;
                }
                if (a)
                {
                    d.a(b).release();
                    d.a(b, null);
                    d.a(b, d.c(b));
                    if (d.a(b) == null)
                    {
                        if (d.d(b) != null)
                        {
                            d.d(b).a(d.e(b));
                            d.f(b);
                            d.g(b);
                        }
                        b.c();
                        return;
                    }
                }
                if (d.h(b))
                {
                    d.i(b);
                    return;
                }
                if (d.d(b) != null)
                {
                    if (a)
                    {
                        d.d(b).a(d.e(b));
                    } else
                    {
                        d.d(b).c(d.e(b));
                    }
                }
                d.f(b);
                d.g(b);
            }

            
            {
                b = d.this;
                a = flag;
                super();
            }
        });
    }

    static boolean b(d d1)
    {
        return d1.e;
    }

    static MediaPlayer c(d d1)
    {
        return d1.e();
    }

    static az d(d d1)
    {
        return d1.b;
    }

    private void d()
    {
        d = false;
        a.start();
        b.b(c);
    }

    private MediaPlayer e()
    {
        MediaPlayer mediaplayer = new MediaPlayer();
        long l;
        long l1;
        try
        {
            l = f.getStartOffset();
            l1 = f.getLength();
        }
        catch (Exception exception1)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Unable to create MediaPlayer for audio prompt", exception1);
            try
            {
                mediaplayer.release();
            }
            catch (Exception exception) { }
            return null;
        }
        if (l1 != -1L)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Attempting to initialize MediaPlayer with asset file of unknown length");
        mediaplayer.setDataSource(f.getFileDescriptor());
_L1:
        mediaplayer.prepare();
        mediaplayer.getDuration();
        mediaplayer.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            private d a;

            public final boolean onError(MediaPlayer mediaplayer1, int j, int k)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.c(a, (new StringBuilder()).append("Error during audio prompt: ").append(j).toString());
                d.a(a, true);
                return true;
            }

            
            {
                a = d.this;
                super();
            }
        });
        mediaplayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            private d a;

            public final void onCompletion(MediaPlayer mediaplayer1)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(a, "Audio prompt completed");
                d.a(a, false);
            }

            
            {
                a = d.this;
                super();
            }
        });
        return mediaplayer;
        mediaplayer.setDataSource(f.getFileDescriptor(), l, l1);
          goto _L1
    }

    static Object e(d d1)
    {
        return d1.c;
    }

    static az f(d d1)
    {
        d1.b = null;
        return null;
    }

    static Object g(d d1)
    {
        d1.c = null;
        return null;
    }

    static boolean h(d d1)
    {
        return d1.d;
    }

    static void i(d d1)
    {
        d1.d();
    }

    public final void a()
    {
        if (a != null)
        {
            d = false;
            if (a.isPlaying())
            {
                try
                {
                    a.stop();
                }
                catch (Throwable throwable)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error stopping player", throwable);
                }
                a.release();
                a = null;
                a = e();
                if (a == null)
                {
                    c();
                    return;
                }
            }
        }
    }

    public final void a(AssetFileDescriptor assetfiledescriptor)
    {
        f = assetfiledescriptor;
        a = e();
        if (a == null)
        {
            c();
        }
    }

    public final void a(Object obj, az az1, Object obj1)
    {
        if (a == null || e)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Can't start disposed audio prompt");
            az1.a(obj1);
            return;
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Starting audio prompt");
        b = az1;
        c = obj1;
        if (a.isPlaying())
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Audio prompt is already playing. Stopping to restart.");
            a.stop();
            d = true;
            return;
        } else
        {
            d();
            return;
        }
    }

    public final boolean b()
    {
        return e;
    }

    public final void c()
    {
        e = true;
        if (a != null)
        {
            a.release();
            a = null;
        }
        if (f != null)
        {
            try
            {
                f.close();
            }
            catch (IOException ioexception)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error closing audio prompt file", ioexception);
            }
            f = null;
        }
        if (b != null)
        {
            b.a(c);
            b = null;
        }
        c = null;
    }
}
