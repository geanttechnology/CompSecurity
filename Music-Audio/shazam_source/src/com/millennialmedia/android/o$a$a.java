// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.SoundPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.millennialmedia.android:
//            o

private abstract class d
{

    ArrayList b;
    Timer c;
    SoundPool d;
    final c e;

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
            c.scheduleAtFixedRate(new TimerTask() {

                final o.a.a a;

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
                        int j = a.d.play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                        if (j != 0)
                        {
                            a.d.stop(j);
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
                a = o.a.a.this;
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

    public _cls1.a(_cls1.a a1, SoundPool soundpool)
    {
        e = a1;
        super();
        b = new ArrayList();
        d = soundpool;
    }
}
