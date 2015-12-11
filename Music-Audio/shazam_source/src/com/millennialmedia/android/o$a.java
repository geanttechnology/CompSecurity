// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.millennialmedia.android:
//            o, an, aj, al

static final class cationContext
    implements android.media.aPlayer.OnCompletionListener
{
    private abstract class a
    {

        ArrayList b;
        Timer c;
        SoundPool d;
        final o.a e;

        final void a()
        {
            this;
            JVM INSTR monitorenter ;
            if (c != null)
            {
                c.cancel();
                c.purge();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        final void a(int i)
        {
            this;
            JVM INSTR monitorenter ;
            b.add(Integer.valueOf(i));
            if (b.size() == 1)
            {
                c = new Timer();
                c.scheduleAtFixedRate(new TimerTask(this) {

                    final a a;

                    public final void run()
                    {
                        ArrayList arraylist = new ArrayList();
                        Iterator iterator = a.b.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            Integer integer = (Integer)iterator.next();
                            int i = a.d.play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                            if (i != 0)
                            {
                                a.d.stop(i);
                                a.a(a.d, integer.intValue());
                                arraylist.add(integer);
                            }
                        } while (true);
                        a.b.removeAll(arraylist);
                        if (a.b.size() == 0)
                        {
                            a.c.cancel();
                            a.c.purge();
                        }
                    }

            
            {
                a = a1;
                super();
            }
                }, 0L, 100L);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        abstract void a(SoundPool soundpool, int i);

        public a(SoundPool soundpool)
        {
            e = o.a.this;
            super();
            b = new ArrayList();
            d = soundpool;
        }
    }

    static interface b
    {

        public abstract void a(int i);
    }


    private static f d;
    CopyOnWriteArrayList a;
    CopyOnWriteArrayList b;
    Runnable c = new Runnable() {

        final o.a a;

        public final void run()
        {
            if (o.a.a(a) != null)
            {
                if (o.a.a(a).isPlaying())
                {
                    int i = o.a.a(a).getCurrentPosition();
                    if (a.b != null)
                    {
                        for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((b)iterator.next()).a(i)) { }
                    }
                }
                an.a(this, 500L);
            }
        }

            
            {
                a = o.a.this;
                super();
            }
    };
    private WeakReference e;
    private MediaPlayer f;
    private SoundPool g;
    private a h;

    static MediaPlayer a(b b1)
    {
        return b1.f;
    }

    static f a(Context context)
    {
        com/millennialmedia/android/o$a;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new <init>(context);
        }
        context = d;
        com/millennialmedia/android/o$a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static WeakReference b(d d1)
    {
        return d1.e;
    }

    final aj a(Uri uri, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (f != null)
        {
            f.release();
            f = null;
        }
        f = MediaPlayer.create((Context)e.get(), uri);
        f.setLooping(flag);
        f.start();
        f.setOnCompletionListener(this);
        an.a(c);
_L1:
        uri = aj.a("Audio playback started");
        this;
        JVM INSTR monitorexit ;
        return uri;
        uri;
        al.a("BridgeMMMedia", "Exception in playAudio method", uri.getCause());
          goto _L1
        uri;
        throw uri;
    }

    final aj a(File file)
    {
        this;
        JVM INSTR monitorenter ;
        try
        {
            if (g == null)
            {
                g = new SoundPool(4, 3, 0);
                h = new a(g) {

                    final o.a a;

                    public final void a(SoundPool soundpool, int i)
                    {
                        this;
                        JVM INSTR monitorenter ;
                        if (soundpool == null)
                        {
                            break MISSING_BLOCK_LABEL_67;
                        }
                        Object obj = (Context)o.a.b(a).get();
                        if (obj == null)
                        {
                            break MISSING_BLOCK_LABEL_67;
                        }
                        obj = (AudioManager)((Context) (obj)).getSystemService("audio");
                        float f1 = ((float)((AudioManager) (obj)).getStreamVolume(3) + 0.0F) / (float)((AudioManager) (obj)).getStreamMaxVolume(3);
                        soundpool.play(i, f1, f1, 1, 0, 1.0F);
                        this;
                        JVM INSTR monitorexit ;
                        return;
                        soundpool;
                        throw soundpool;
                    }

            
            {
                a = o.a.this;
                super(soundpool);
            }
                };
            }
            h.a(g.load(file.getAbsolutePath(), 1));
        }
        // Misplaced declaration of an exception variable
        catch (File file) { }
        file = aj.a("Sound playback started");
        this;
        JVM INSTR monitorexit ;
        return file;
        file;
        throw file;
    }

    final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        if (f == null) goto _L2; else goto _L1
_L1:
        boolean flag = f.isPlaying();
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    final aj b()
    {
        this;
        JVM INSTR monitorenter ;
        aj aj1;
        if (f != null)
        {
            onCompletion(f);
        }
        if (g != null)
        {
            g.release();
            g = null;
        }
        if (h != null)
        {
            h.a();
            h = null;
        }
        aj1 = aj.a("Audio stopped");
        this;
        JVM INSTR monitorexit ;
        return aj1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        this;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            for (mediaplayer = a.iterator(); mediaplayer.hasNext(); ((android.media.aPlayer.OnCompletionListener)mediaplayer.next()).onCompletion(f)) { }
        }
        break MISSING_BLOCK_LABEL_52;
        mediaplayer;
        throw mediaplayer;
        if (f != null)
        {
            f.release();
            f = null;
        }
        this;
        JVM INSTR monitorexit ;
    }

    private a()
    {
    }

    private a(Context context)
    {
        e = new WeakReference(context.getApplicationContext());
    }
}
