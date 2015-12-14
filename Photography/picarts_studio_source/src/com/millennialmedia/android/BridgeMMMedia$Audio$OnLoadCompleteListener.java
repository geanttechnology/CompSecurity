// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.SoundPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

abstract class c
{

    private ArrayList a;
    private Timer b;
    private SoundPool c;

    static ArrayList a(c c1)
    {
        return c1.a;
    }

    static SoundPool b(a a1)
    {
        return a1.c;
    }

    static Timer c(c c1)
    {
        return c1.b;
    }

    final void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != null)
        {
            b.cancel();
            b.purge();
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
        a.add(Integer.valueOf(i));
        if (a.size() == 1)
        {
            b = new Timer();
            b.scheduleAtFixedRate(new TimerTask() {

                private BridgeMMMedia.Audio.OnLoadCompleteListener a;

                public void run()
                {
                    ArrayList arraylist = new ArrayList();
                    Iterator iterator = BridgeMMMedia.Audio.OnLoadCompleteListener.a(a).iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        Integer integer = (Integer)iterator.next();
                        int j = BridgeMMMedia.Audio.OnLoadCompleteListener.b(a).play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                        if (j != 0)
                        {
                            BridgeMMMedia.Audio.OnLoadCompleteListener.b(a).stop(j);
                            a.onLoadComplete(BridgeMMMedia.Audio.OnLoadCompleteListener.b(a), integer.intValue(), 0);
                            arraylist.add(integer);
                        }
                    } while (true);
                    BridgeMMMedia.Audio.OnLoadCompleteListener.a(a).removeAll(arraylist);
                    if (BridgeMMMedia.Audio.OnLoadCompleteListener.a(a).size() == 0)
                    {
                        BridgeMMMedia.Audio.OnLoadCompleteListener.c(a).cancel();
                        BridgeMMMedia.Audio.OnLoadCompleteListener.c(a).purge();
                    }
                }

            
            {
                a = BridgeMMMedia.Audio.OnLoadCompleteListener.this;
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

    abstract void onLoadComplete(SoundPool soundpool, int i, int j);

    public _cls1.a(_cls1.a a1, SoundPool soundpool)
    {
        a = new ArrayList();
        c = soundpool;
    }
}
