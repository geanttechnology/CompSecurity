// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.rendering.mraid:
//            MraidMediaProcessor

public static final class g
{
    public static interface a
    {

        public abstract void a(double d1);
    }

    static final class b extends Handler
    {

        private WeakReference a;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                super.handleMessage(message);
                return;

            case 1: // '\001'
                message = (MraidMediaProcessor.a)a.get();
                break;
            }
            if (message != null)
            {
                MraidMediaProcessor.a.a(message);
            }
            message = Message.obtain();
            message.what = 1;
            sendMessageDelayed(message, 1000L);
        }

        public b(Looper looper, MraidMediaProcessor.a a1)
        {
            super(looper);
            a = new WeakReference(a1);
        }
    }


    private static final String a = com/inmobi/rendering/mraid/MraidMediaProcessor$a.getSimpleName();
    private static final int b[] = {
        8000, 11025, 22050, 44100
    };
    private static double f = 4.9406564584124654E-324D;
    private HandlerThread c;
    private b d;
    private AudioRecord e;
    private List g;
    private boolean h;

    public static double a()
    {
        return f;
    }

    static void a(f f1)
    {
        f1.e();
    }

    private void b()
    {
        Logger.a(com.inmobi.commons.core.utilities.l.INTERNAL, a, "Start sampling audio levels ...");
        c = new HandlerThread("audioSampler");
        c.start();
        d = new b(c.getLooper(), this);
        e = d();
        Message message = Message.obtain();
        message.what = 1;
        d.sendMessage(message);
    }

    private void c()
    {
        Logger.a(com.inmobi.commons.core.utilities.l.INTERNAL, a, "Stop sampling audio levels ...");
        if (e != null)
        {
            if (h)
            {
                h = false;
            }
            d.removeMessages(1);
            try
            {
                e.stop();
                e.release();
            }
            catch (IllegalStateException illegalstateexception)
            {
                Logger.a(com.inmobi.commons.core.utilities.l.INTERNAL, a, (new StringBuilder()).append("Invalid recorder state: ").append(illegalstateexception.getMessage()).toString());
            }
            c.getLooper().quit();
            c.interrupt();
            c = null;
        }
    }

    private AudioRecord d()
    {
        int ai[] = b;
        int l = ai.length;
        for (int i = 0; i < l; i++)
        {
            int i1 = ai[i];
            short aword0[] = new short[2];
            short[] _tmp = aword0;
            aword0[0] = 3;
            aword0[1] = 2;
            int j1 = aword0.length;
            for (int j = 0; j < j1; j++)
            {
                short word0 = aword0[j];
                short aword1[] = new short[2];
                short[] _tmp1 = aword1;
                aword1[0] = 16;
                aword1[1] = 12;
                int k1 = aword1.length;
                for (int k = 0; k < k1; k++)
                {
                    short word1 = aword1[k];
                    int l1 = AudioRecord.getMinBufferSize(i1, word1, word0);
                    if (l1 == -2)
                    {
                        continue;
                    }
                    AudioRecord audiorecord = new AudioRecord(0, i1, word1, word0, l1);
                    if (audiorecord.getState() == 1)
                    {
                        return audiorecord;
                    }
                }

            }

        }

        return null;
    }

    private void e()
    {
        if (e != null && 1 == e.getState())
        {
            short aword0[] = new short[512];
            float af[] = new float[3];
            h = true;
            e.startRecording();
            int j = e.read(aword0, 0, aword0.length);
            int i = 0;
            float f1;
            float f2;
            for (f1 = 0.0F; i < j; f1 = f2)
            {
                short word0 = (short)(aword0[i] | aword0[i + 1]);
                f2 = f1;
                if (word0 != 0)
                {
                    f2 = f1 + (float)(Math.abs(word0) / j);
                }
                i += 2;
            }

            af[0] = f1;
            i = 0;
            f1 = 0.0F;
            for (; i < 3; i++)
            {
                f1 += af[i];
            }

            f = f1 / (float)j / 32F;
            Iterator iterator = g.iterator();
            while (iterator.hasNext()) 
            {
                a a1 = (a)iterator.next();
                if (a1 != null)
                {
                    a1.a(f);
                }
            }
        }
    }

    public void a(a a1)
    {
        g.add(a1);
        if (1 == g.size())
        {
            b();
        }
    }

    public void b(a a1)
    {
        g.remove(a1);
        if (g.size() == 0)
        {
            c();
        }
    }


    public b.a()
    {
        g = new ArrayList();
    }
}
