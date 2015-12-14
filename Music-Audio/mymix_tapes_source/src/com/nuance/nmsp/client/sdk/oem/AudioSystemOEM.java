// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bi;
import bj;
import bm;
import bn;
import bq;
import cz;
import d;
import eo;
import java.util.Vector;

// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            EndPointerOEM

public class AudioSystemOEM
    implements bj, bn.b
{
    public static final class a extends Exception
    {

        public a(String s1)
        {
            super(s1);
        }
    }

    public static final class b
    {

        public static b a = new b();
        public static b b = new b();


        private b()
        {
        }
    }

    final class c extends Thread
        implements android.media.AudioTrack.OnPlaybackPositionUpdateListener
    {

        final AudioSystemOEM a;
        private bm b;
        private Handler c;
        private AudioTrack d;
        private byte e[];
        private short f[];
        private boolean g;
        private int h;
        private int i;
        private boolean j;
        private int k;
        private boolean l;
        private boolean m;
        private bj.a n;
        private bj.c o;
        private bj.m p;
        private int q;

        private int a(short aword0[], int i1, bj.i j1)
            throws a
        {
            if (i1 == 0)
            {
                return 0;
            }
            if (AudioSystemOEM.i(a) == b.a)
            {
                int k1 = AudioSystemOEM.e - AudioSystemOEM.d;
                if (k1 >= i1)
                {
                    System.arraycopy(AudioSystemOEM.l(a), AudioSystemOEM.d, aword0, 0, i1);
                    AudioSystemOEM.d += i1;
                    return i1;
                }
                if (k1 > 0)
                {
                    System.arraycopy(AudioSystemOEM.l(a), AudioSystemOEM.d, aword0, 0, k1);
                }
                AudioSystemOEM.d = 0;
                n.a(null, AudioSystemOEM.m(a), new bj.i(0), j1, null);
                if (j1.a > 0)
                {
                    synchronized (AudioSystemOEM.c)
                    {
                        i1 = AudioSystemOEM.decodeSpeex(AudioSystemOEM.m(a), j1.a, AudioSystemOEM.l(a), AudioSystemOEM.l(a).length);
                        AudioSystemOEM.e = i1;
                        if (i1 > AudioSystemOEM.l(a).length)
                        {
                            AudioSystemOEM.e = AudioSystemOEM.l(a).length;
                        }
                    }
                    if (i1 < 0)
                    {
                        throw new a((new StringBuilder("Call to decodeSpeex() failed with code: ")).append(AudioSystemOEM.speexCodeToString(i1)).toString());
                    }
                    if (b.b())
                    {
                        b.b((new StringBuilder("Obtained ")).append(i1).append(" shorts of PCM data after decoding SPEEX.").toString());
                    }
                }
                if (k1 > 0)
                {
                    return k1;
                }
            }
            return 0;
        }

        static Object a()
        {
            return null;
        }

        private void a(a a1)
        {
            Object obj = AudioSystemOEM.d();
            obj;
            JVM INSTR monitorenter ;
            if (b.e())
            {
                b.e(a1.getMessage());
            }
            if (d == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            if (d.getPlayState() != 1)
            {
                d.stop();
            }
            d.release();
            a1 = Looper.myLooper();
            if (a1 == null)
            {
                break MISSING_BLOCK_LABEL_71;
            }
            a1.quit();
            j = false;
            if (AudioSystemOEM.a(a) != null)
            {
                AudioSystemOEM.a(a).e();
                AudioSystemOEM.b(a);
            }
            o.a(bj.b.b, null);
            obj;
            JVM INSTR monitorexit ;
            return;
            a1;
            obj;
            JVM INSTR monitorexit ;
            throw a1;
        }

        static void a(c c1)
            throws a
        {
            c1.b();
        }

        static void a(c c1, a a1)
        {
            c1.a(a1);
        }

        private void b()
            throws a
        {
            int k1;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            long l1;
            l1 = 0L;
            k1 = 0;
            flag3 = false;
            flag1 = false;
            flag2 = false;
            flag4 = false;
            flag = false;
            Object obj = AudioSystemOEM.d();
            obj;
            JVM INSTR monitorenter ;
            if (b.b())
            {
                b.b("++++++++++++========== onPlay()");
            }
            if (AudioSystemOEM.i(a) != b.a) goto _L2; else goto _L1
_L1:
            if (!j) goto _L4; else goto _L3
_L3:
            Object obj1;
            short aword0[];
            obj1 = new bj.i(AudioSystemOEM.n(a));
            aword0 = new short[AudioSystemOEM.n(a)];
            int j1 = 0;
_L18:
            int i1 = j1;
            if (j1 >= AudioSystemOEM.n(a)) goto _L6; else goto _L5
_L5:
            Object obj2 = AudioSystemOEM.e();
            obj2;
            JVM INSTR monitorenter ;
            if (!l) goto _L8; else goto _L7
_L7:
            j = false;
            i1 = 0;
_L6:
            if (i1 <= 0) goto _L10; else goto _L9
_L9:
            if (i1 >= AudioSystemOEM.n(a)) goto _L10; else goto _L11
_L11:
            if (b.b())
            {
                b.b("Filling buffer with silence.");
            }
              goto _L12
_L14:
            if (j1 >= AudioSystemOEM.n(a)) goto _L10; else goto _L13
_L13:
            f[j1] = 0;
            j1++;
              goto _L14
_L8:
            obj2;
            JVM INSTR monitorexit ;
            i1 = a(aword0, AudioSystemOEM.n(a) - j1, ((bj.i) (obj1)));
            if (i1 != 0)
            {
                break MISSING_BLOCK_LABEL_236;
            }
            try
            {
                sleep(300L);
            }
            catch (InterruptedException interruptedexception) { }
            if (((bj.i) (obj1)).a != -1) goto _L16; else goto _L15
_L15:
            if (b.b())
            {
                b.b("No more data to playback.");
            }
            j = false;
            i1 = j1;
              goto _L6
            obj1;
            throw obj1;
            obj1;
            obj2;
            JVM INSTR monitorexit ;
            throw obj1;
_L16:
            if (((bj.i) (obj1)).a <= 0 || i1 <= 0) goto _L18; else goto _L17
_L17:
            System.arraycopy(aword0, 0, f, j1, i1);
            j1 += i1;
              goto _L18
_L19:
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_381;
            }
            k1 = d.write(f, j1, AudioSystemOEM.n(a));
            if (k1 <= 0)
            {
                break MISSING_BLOCK_LABEL_381;
            }
            i1 -= k1;
            j1 += k1;
            i = k1 + i;
              goto _L19
            i1 = d.setNotificationMarkerPosition(i);
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_424;
            }
            throw new a((new StringBuilder("Call to AudioTrack.setNotificationMarkerPosition() SPEEX 0 failed with code: ")).append(i1).toString());
            c.sendMessage(c.obtainMessage(1));
_L26:
            obj;
            JVM INSTR monitorexit ;
            return;
_L47:
            if (i < AudioSystemOEM.o(a))
            {
                j1 = AudioSystemOEM.o(a) - i;
                obj1 = new short[j1];
                break MISSING_BLOCK_LABEL_476;
            }
              goto _L20
_L48:
            i1 = d.write(((short []) (obj1)), 0, j1);
            if (i1 <= 0)
            {
                break MISSING_BLOCK_LABEL_512;
            }
            i = i1 + i;
            i1 = d.setNotificationMarkerPosition(i);
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_556;
            }
            throw new a((new StringBuilder("Call to AudioTrack.setNotificationMarkerPosition() SPEEX 1 failed with code: ")).append(i1).toString());
            c.sendMessage(c.obtainMessage(1));
            obj;
            JVM INSTR monitorexit ;
            return;
_L20:
            if (b.b())
            {
                b.b((new StringBuilder("onPlay() AudioTrack status is :")).append(d.getState()).toString());
            }
            if (d.getState() == 0) goto _L22; else goto _L21
_L21:
            j1 = d.getPlaybackHeadPosition();
            if (j1 != k) goto _L24; else goto _L23
_L23:
            i1 = i;
_L44:
            k = i1;
_L45:
            if (i1 < i && d.getState() != 0) goto _L26; else goto _L25
_L25:
            if (i1 <= j1)
            {
                break MISSING_BLOCK_LABEL_701;
            }
            l1 = ((i1 - j1) * 1000) / AudioSystemOEM.k(a);
            if (b.b())
            {
                b.b("calculating the delay......");
                b.b((new StringBuilder("parameter pos = ")).append(i1).toString());
                b.b((new StringBuilder("parameter prev_pos = ")).append(j1).toString());
                b.b((new StringBuilder("parameter delay = ")).append(l1).toString());
            }
            AudioSystemOEM.p(a).a(new bq(this) {

                private c a;

                public final void run()
                {
                    if (c.d(a).b())
                    {
                        c.d(a).b((new StringBuilder("++++++++++++========== stop mTrack: ")).append(c.e(a)).toString());
                    }
                    Object obj = AudioSystemOEM.e();
                    obj;
                    JVM INSTR monitorenter ;
                    if (c.f(a) || c.g(a)) goto _L2; else goto _L1
_L1:
                    Object obj1 = AudioSystemOEM.d();
                    obj1;
                    JVM INSTR monitorenter ;
                    if (c.e(a).getState() != 0)
                    {
                        c.e(a).stop();
                    }
                    c.e(a).flush();
                    c.e(a).release();
                    if (AudioSystemOEM.a(a.a) != null)
                    {
                        AudioSystemOEM.a(a.a).e();
                        AudioSystemOEM.b(a.a);
                    }
                    bj.c c1 = c.h(a);
                    bj.b b1 = bj.b.a;
                    c c2 = a;
                    c1.a(b1, c.a());
                    Object obj2 = AudioSystemOEM.c;
                    obj2;
                    JVM INSTR monitorenter ;
                    if (!AudioSystemOEM.a) goto _L4; else goto _L3
_L3:
                    AudioSystemOEM.decodeCleanupSpeex();
                    AudioSystemOEM.a(a.a, null);
                    AudioSystemOEM.a(a.a, null);
                    AudioSystemOEM.a = false;
_L6:
                    c.i(a).sendMessage(c.i(a).obtainMessage(3));
                    obj1;
                    JVM INSTR monitorexit ;
_L8:
                    obj;
                    JVM INSTR monitorexit ;
                    return;
_L4:
                    if (!c.d(a).b()) goto _L6; else goto _L5
_L5:
                    c.d(a).b("Speex was already cleaned up");
                      goto _L6
                    Exception exception2;
                    exception2;
                    obj2;
                    JVM INSTR monitorexit ;
                    throw exception2;
                    Exception exception1;
                    exception1;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    Exception exception;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception;
_L2:
                    if (!c.d(a).b()) goto _L8; else goto _L7
_L7:
                    c.d(a).b("AudioSystemOEM was already stopping");
                      goto _L8
                }

            
            {
                a = c1;
                super();
            }
            }, l1);
              goto _L26
_L2:
            if (!j) goto _L28; else goto _L27
_L27:
            obj1 = new bj.i(AudioSystemOEM.c(a));
            n.a(e, null, ((bj.i) (obj1)), new bj.i(0), null);
            i1 = ((bj.i) (obj1)).a;
            j1 = i1;
            if (!b.b())
            {
                break MISSING_BLOCK_LABEL_967;
            }
            obj1 = b;
            StringBuilder stringbuilder = new StringBuilder("PLAYBACK: Sample #");
            j1 = q;
            q = j1 + 1;
            ((bm) (obj1)).b(stringbuilder.append(j1).append(". Asked for ").append(AudioSystemOEM.c(a)).append(" bytes of data, ").append(i1).append(" bytes received.").toString());
            j1 = i1;
_L43:
            i1 = j1;
            if (j1 != 0) goto _L30; else goto _L29
_L29:
            i1 = j1;
            if (h >= AudioSystemOEM.c(a)) goto _L30; else goto _L31
_L31:
            if (b.b())
            {
                b.b("Filling buffer with silence.");
            }
            k1 = AudioSystemOEM.c(a) - h;
            j1 = 0;
_L33:
            i1 = k1;
            if (j1 >= k1) goto _L30; else goto _L32
_L32:
            e[j1] = 0;
            j1++;
              goto _L33
_L34:
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_1113;
            }
            k1 = d.write(e, j1, i1);
            if (k1 <= 0)
            {
                break MISSING_BLOCK_LABEL_1113;
            }
            i1 -= k1;
            j1 += k1;
            h = k1 + h;
              goto _L34
            i1 = d.setNotificationMarkerPosition(h / 2);
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_1159;
            }
            throw new a((new StringBuilder("Call to AudioTrack.setNotificationMarkerPosition() PCM 0 failed with code: ")).append(i1).toString());
            c.sendMessage(c.obtainMessage(1));
              goto _L26
_L50:
            if (h >= AudioSystemOEM.q(a)) goto _L36; else goto _L35
_L35:
            j1 = AudioSystemOEM.q(a) - h;
            obj1 = new byte[j1];
            i1 = ((flag4) ? 1 : 0);
            break MISSING_BLOCK_LABEL_1595;
_L51:
            i1 = d.write(((byte []) (obj1)), 0, j1);
            if (i1 <= 0)
            {
                break MISSING_BLOCK_LABEL_1247;
            }
            h = i1 + h;
            i1 = d.setNotificationMarkerPosition(h / 2);
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_1293;
            }
            throw new a((new StringBuilder("Call to AudioTrack.setNotificationMarkerPosition() PCM 1 failed with code: ")).append(i1).toString());
            c.sendMessage(c.obtainMessage(1));
            obj;
            JVM INSTR monitorexit ;
            return;
_L36:
            if (b.b())
            {
                b.b((new StringBuilder("onPlay() AudioTrack status is :")).append(d.getState()).toString());
            }
            if (d.getState() == 0)
            {
                break MISSING_BLOCK_LABEL_1503;
            }
            j1 = d.getPlaybackHeadPosition();
            if (j1 != k) goto _L38; else goto _L37
_L37:
            i1 = h / 2;
_L41:
            k = i1;
_L42:
            if (i1 < h / 2) goto _L26; else goto _L39
_L39:
            if (i1 <= j1)
            {
                break MISSING_BLOCK_LABEL_1490;
            }
            l1 = ((i1 - j1) * 1000) / AudioSystemOEM.k(a);
_L40:
            l2 = l1;
            if (l1 < (long)AudioSystemOEM.r(a))
            {
                l2 = AudioSystemOEM.r(a);
            }
            AudioSystemOEM.p(a).a(new bq(this) {

                private c a;

                public final void run()
                {
                    Object obj = AudioSystemOEM.d();
                    obj;
                    JVM INSTR monitorenter ;
                    Object obj1;
                    c.e(a).stop();
                    c.e(a).flush();
                    c.e(a).release();
                    if (AudioSystemOEM.a(a.a) != null)
                    {
                        AudioSystemOEM.a(a.a).e();
                        AudioSystemOEM.b(a.a);
                    }
                    obj1 = c.h(a);
                    bj.b b1 = bj.b.a;
                    c c1 = a;
                    ((bj.c) (obj1)).a(b1, c.a());
                    obj1 = Looper.myLooper();
                    if (obj1 == null)
                    {
                        break MISSING_BLOCK_LABEL_112;
                    }
                    ((Looper) (obj1)).quit();
                    c.j(a);
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                a = c1;
                super();
            }
            }, l2);
              goto _L26
            l1 = 0L;
              goto _L40
_L38:
            i1 = j1;
              goto _L41
            j1 = 0;
            i1 = ((flag1) ? 1 : 0);
              goto _L42
_L28:
            j1 = 0;
              goto _L43
_L24:
            i1 = j1;
              goto _L44
_L22:
            i1 = 0;
            j1 = k1;
              goto _L45
_L4:
            i1 = 0;
              goto _L6
_L12:
            j1 = i1;
              goto _L14
_L10:
            if (i1 <= 0) goto _L47; else goto _L46
_L46:
            j1 = ((flag) ? 1 : 0);
              goto _L19
            long l2;
            i1 = ((flag2) ? 1 : 0);
            while (i1 < j1) 
            {
                obj1[i1] = 0;
                i1++;
            }
              goto _L48
_L30:
            if (i1 == -1) goto _L50; else goto _L49
_L49:
            j1 = ((flag3) ? 1 : 0);
              goto _L34
            while (i1 < j1) 
            {
                obj1[i1] = 0;
                i1++;
            }
              goto _L51
        }

        static void b(c c1)
        {
            if (c1.b.b())
            {
                c1.b.b("Calling AudioSystemOEM.onStop()");
            }
            Object obj = AudioSystemOEM.d();
            obj;
            JVM INSTR monitorenter ;
            c1.d.stop();
_L7:
            c1.j = false;
            c1.d.flush();
            c1.d.release();
            if (AudioSystemOEM.a(c1.a) != null)
            {
                AudioSystemOEM.a(c1.a).e();
                AudioSystemOEM.b(c1.a);
            }
            if (AudioSystemOEM.i(c1.a) != b.a) goto _L2; else goto _L1
_L1:
            Object obj1 = AudioSystemOEM.c;
            obj1;
            JVM INSTR monitorenter ;
            if (!AudioSystemOEM.a) goto _L4; else goto _L3
_L3:
            AudioSystemOEM.decodeCleanupSpeex();
            AudioSystemOEM.a(c1.a, null);
            AudioSystemOEM.a(c1.a, null);
            AudioSystemOEM.a = false;
_L9:
            c1.p.a(bj.b.a);
            c1 = Looper.myLooper();
            if (c1 == null) goto _L2; else goto _L5
_L5:
            c1.quit();
_L2:
            obj;
            JVM INSTR monitorexit ;
            return;
            obj1;
            if (!c1.b.b()) goto _L7; else goto _L6
_L6:
            c1.b.b("Could not stop audioTrack.");
              goto _L7
            c1;
            throw c1;
_L4:
            if (!c1.b.b()) goto _L9; else goto _L8
_L8:
            c1.b.b("Attempting to cleanup speex decode while it is already stopped");
              goto _L9
            c1;
            obj1;
            JVM INSTR monitorexit ;
            throw c1;
              goto _L7
        }

        static boolean c(c c1)
        {
            c1.m = true;
            return true;
        }

        static bm d(c c1)
        {
            return c1.b;
        }

        static AudioTrack e(c c1)
        {
            return c1.d;
        }

        static boolean f(c c1)
        {
            return c1.l;
        }

        static boolean g(c c1)
        {
            return c1.m;
        }

        static bj.c h(c c1)
        {
            return c1.o;
        }

        static Handler i(c c1)
        {
            return c1.c;
        }

        static boolean j(c c1)
        {
            c1.j = false;
            return false;
        }

        public final void a(bj.a a1, bj.c c1)
            throws a
        {
            if (AudioSystemOEM.a(a) != null)
            {
                AudioSystemOEM.a(a).a();
            }
            this;
            JVM INSTR monitorenter ;
            q = 0;
            n = a1;
            o = c1;
            if (AudioSystemOEM.i(a) != b.a)
            {
                break MISSING_BLOCK_LABEL_157;
            }
            a1 = ((bj.a) (AudioSystemOEM.c));
            a1;
            JVM INSTR monitorenter ;
            int i1 = AudioSystemOEM.decodeInitSpeex(AudioSystemOEM.j(a), 0, AudioSystemOEM.k(a));
            if (i1 >= 0)
            {
                break MISSING_BLOCK_LABEL_117;
            }
            throw new a((new StringBuilder("decodeInitSpeex failed with code: ")).append(AudioSystemOEM.speexCodeToString(i1)).toString());
            c1;
            a1;
            JVM INSTR monitorexit ;
            throw c1;
            throw a1;
            AudioSystemOEM.a(a, new short[0x80000]);
            AudioSystemOEM.a(a, new byte[0x80000]);
            AudioSystemOEM.a = true;
            a1;
            JVM INSTR monitorexit ;
            AudioSystemOEM.d = 0;
            AudioSystemOEM.e = 0;
            start();
_L1:
            if (!isAlive())
            {
                break MISSING_BLOCK_LABEL_188;
            }
            a1 = c;
            if (a1 != null)
            {
                break MISSING_BLOCK_LABEL_188;
            }
            try
            {
                wait();
            }
            // Misplaced declaration of an exception variable
            catch (bj.a a1) { }
            finally
            {
                this;
            }
              goto _L1
            if (isAlive())
            {
                break MISSING_BLOCK_LABEL_198;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            if (c != null)
            {
                c.sendMessage(c.obtainMessage(1));
            }
            this;
            JVM INSTR monitorexit ;
        }

        public final void a(bj.m m1)
        {
            synchronized (AudioSystemOEM.e())
            {
                l = true;
            }
            synchronized (AudioSystemOEM.d())
            {
                j = false;
            }
            this;
            JVM INSTR monitorenter ;
            p = m1;
            if (isAlive() && !g)
            {
                break MISSING_BLOCK_LABEL_60;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            if (c != null)
            {
                c.sendMessage(c.obtainMessage(2));
            }
_L1:
            boolean flag;
            if (!isAlive())
            {
                break MISSING_BLOCK_LABEL_110;
            }
            flag = g;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            try
            {
                wait();
            }
            // Misplaced declaration of an exception variable
            catch (bj.m m1) { }
            finally
            {
                this;
            }
              goto _L1
            this;
            JVM INSTR monitorexit ;
            return;
            throw m1;
        }

        public final void onMarkerReached(AudioTrack audiotrack)
        {
            try
            {
                b();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AudioTrack audiotrack)
            {
                a(audiotrack);
            }
        }

        public final void onPeriodicNotification(AudioTrack audiotrack)
        {
        }

        public final void run()
        {
            Looper.prepare();
            this;
            JVM INSTR monitorenter ;
            c = new Handler(this) {

                private c a;

                public final void handleMessage(Message message)
                {
                    switch (message.what)
                    {
                    default:
                        return;

                    case 1: // '\001'
                        try
                        {
                            c.a(a);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Message message)
                        {
                            c.a(a, message);
                        }
                        return;

                    case 2: // '\002'
                        c.b(a);
                        return;

                    case 3: // '\003'
                        message = Looper.myLooper();
                        break;
                    }
                    if (message != null)
                    {
                        message.quit();
                    }
                    c.c(a);
                }

            
            {
                a = c1;
                super();
            }
            };
            Object obj = AudioSystemOEM.d();
            obj;
            JVM INSTR monitorenter ;
            if (b.b())
            {
                b.b("Creating Audio Track");
            }
            e = new byte[AudioSystemOEM.c(a)];
            f = new short[AudioSystemOEM.d(a)];
            try
            {
                k = 0;
                d = new AudioTrack(AudioSystemOEM.e(a), AudioSystemOEM.f(a), 2, 2, AudioSystemOEM.g(a), AudioSystemOEM.h(a));
                if (d == null || d.getState() != 1)
                {
                    throw new a("AudioTrack object has not been initialized correctly. One or several parameters used to create it must be wrong.");
                }
                break MISSING_BLOCK_LABEL_170;
            }
            catch (IllegalArgumentException illegalargumentexception) { }
            throw new a("Could not instanciate AudioTrack object.");
            Exception exception1;
            exception1;
            obj;
            JVM INSTR monitorexit ;
            throw exception1;
            obj;
            a(((a) (obj)));
            this;
            JVM INSTR monitorexit ;
            return;
            d.setPlaybackPositionUpdateListener(this);
            d.play();
            obj;
            JVM INSTR monitorexit ;
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            Looper.loop();
            this;
            JVM INSTR monitorenter ;
            g = true;
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            exception;
            throw exception;
        }

        private c()
        {
            a = AudioSystemOEM.this;
            super();
            b = d.a(getClass());
            j = true;
            l = false;
            m = false;
            n = null;
            o = null;
            p = null;
            q = 0;
        }

        c(byte byte0)
        {
            this();
        }
    }

    final class d
        implements android.media.AudioRecord.OnRecordPositionUpdateListener, bn.b
    {

        private bm a;
        private AudioRecord b;
        private boolean c;
        private bj.a d;
        private bj.d e;
        private bj.l f;
        private bj.e g;
        private bj.f h;
        private bj.m i;
        private bj.g j;
        private boolean k;
        private boolean l;
        private int m;
        private AudioSystemOEM n;

        private static float a(short aword0[])
        {
            double d1;
            long l1 = 0L;
            for (int i1 = 0; i1 < aword0.length; i1++)
            {
                long l2 = aword0[i1];
                l1 += l2 * l2 >> 9;
            }

            d1 = (double)l1 / 1073741824D;
            if (d1 >= 1.0000000000000001E-09D) goto _L2; else goto _L1
_L1:
            d1 = -90D;
_L4:
            return (float)d1;
_L2:
            double d2 = Math.log10(d1) * 10D;
            d1 = d2;
            if (d2 > 0.0D)
            {
                d1 = 0.0D;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void a(a a1)
        {
            if (a.e())
            {
                a.e(a1.getMessage());
            }
            if (c)
            {
                b.stop();
                synchronized (AudioSystemOEM.f())
                {
                    c = false;
                    b.release();
                    b = null;
                }
                j.d();
                if (AudioSystemOEM.i(n) == b.a)
                {
                    synchronized (AudioSystemOEM.b)
                    {
                        AudioSystemOEM.encodeCleanupSpeex();
                    }
                }
                if (AudioSystemOEM.a(n) != null)
                {
                    AudioSystemOEM.a(n).e();
                    AudioSystemOEM.b(n);
                }
                if (i != null)
                {
                    i.a(bj.b.b);
                    return;
                }
            }
        }

        static void a(d d1, a a1)
        {
            d1.a(a1);
        }

        public final void a(bj.e e1)
        {
            g = e1;
            e1 = AudioSystemOEM.p(n);
            Integer integer = AudioSystemOEM.g();
            Object obj = AudioSystemOEM.p(n).b();
            AudioSystemOEM.p(n).a();
            e1.a(((Object) (new Object[] {
                integer
            })), this, obj);
        }

        public final void a(bj.f f1)
        {
            h = f1;
            f1 = AudioSystemOEM.p(n);
            Integer integer = AudioSystemOEM.h();
            Object obj = AudioSystemOEM.p(n).b();
            AudioSystemOEM.p(n).a();
            f1.a(((Object) (new Object[] {
                integer
            })), this, obj);
        }

        public final void a(bj.m m1, bj.d d1)
        {
            boolean flag = false;
            if (!c) goto _L2; else goto _L1
_L1:
            Thread.sleep(AudioSystemOEM.C(n));
            if (c) goto _L4; else goto _L3
_L3:
            obj = AudioSystemOEM.f();
            obj;
            JVM INSTR monitorenter ;
            c = false;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            b.release();
            b = null;
            obj;
            JVM INSTR monitorexit ;
            if (!flag) goto _L2; else goto _L5
_L5:
            if (AudioSystemOEM.i(n) == b.a)
            {
                synchronized (AudioSystemOEM.b)
                {
                    AudioSystemOEM.encodeCleanupSpeex();
                }
            }
_L2:
            if (AudioSystemOEM.a(n) != null)
            {
                AudioSystemOEM.a(n).e();
                AudioSystemOEM.b(n);
            }
            if (d1 != null)
            {
                d1.a();
            }
            if (m1 != null)
            {
                m1.a(bj.b.a);
            }
            return;
_L4:
            b.stop();
            flag = true;
              goto _L3
            Exception exception1;
            exception1;
            obj;
            JVM INSTR monitorexit ;
            throw exception1;
            obj;
            if (a.b())
            {
                a.b("Could not stop audioRecord.");
            }
              goto _L2
            exception2;
            obj;
            JVM INSTR monitorexit ;
            throw exception2;
            Exception exception;
            exception;
              goto _L2
        }

        public final void a(Object obj, Object obj1)
        {
            obj = ((Object) ((Object[])obj));
            if (((Integer)obj[0]).intValue() != AudioSystemOEM.g().intValue()) goto _L2; else goto _L1
_L1:
            if (!k)
            {
                k = true;
                AudioSystemOEM.z(n).b();
                l = false;
                if (g != null)
                {
                    g.b();
                }
            }
_L4:
            return;
_L2:
            if (((Integer)obj[0]).intValue() != AudioSystemOEM.h().intValue())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k)
            {
                k = false;
                if (h != null)
                {
                    h.c();
                    return;
                }
            }
            continue; /* Loop/switch isn't completed */
            if (((Integer)obj[0]).intValue() != AudioSystemOEM.i().intValue()) goto _L4; else goto _L3
_L3:
            byte abyte0[];
            int k1;
            k1 = ((Integer)obj[1]).intValue();
            obj = obj[2];
            if (!c)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (AudioSystemOEM.i(n) != b.a)
            {
                continue; /* Loop/switch isn't completed */
            }
            abyte0 = new byte[AudioSystemOEM.y(n)];
            if (!c)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = (short[])obj;
            if (k1 < 0)
            {
                a(new a((new StringBuilder("Call to AudioRecord.read() failed with code: ")).append(k1).toString()));
                return;
            }
            if (k1 != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            if (a.b())
            {
                a.b("AudioRecorder has no audio.");
                return;
            }
            if (true) goto _L4; else goto _L5
_L5:
label0:
            {
                obj = EndPointerOEM.a.a;
                synchronized (AudioSystemOEM.b)
                {
                    if (c)
                    {
                        break label0;
                    }
                }
                return;
            }
            int l1;
            l1 = AudioSystemOEM.encodeSpeex(((short []) (obj1)), abyte0, AudioSystemOEM.y(n));
            if (k && !l)
            {
                obj = AudioSystemOEM.z(n).a();
            }
            obj2;
            JVM INSTR monitorexit ;
            if (l1 < 0)
            {
                a(new a((new StringBuilder("Call to encodeSpeex() failed with code: ")).append(AudioSystemOEM.speexCodeToString(l1)).toString()));
                return;
            }
            if (a.b())
            {
                bm bm1 = a;
                StringBuilder stringbuilder1 = new StringBuilder("RECORDING: Sample #");
                int i2 = m;
                m = i2 + 1;
                bm1.b(stringbuilder1.append(i2).append(". Got ").append(k1).append(" shorts from recorder, sending ").append(l1).append(" SPEEX vocoded bytes. ").toString());
            }
            float f1;
            bj.a a1;
            bj.i i1;
            bj.i j1;
            if (a.b())
            {
                if (obj == EndPointerOEM.a.b)
                {
                    a.b("ENDPOINTING SPEECH_END");
                } else
                if (obj == EndPointerOEM.a.c)
                {
                    a.b("ENDPOINTING SPEECH_START");
                }
            }
            StringBuilder stringbuilder;
            if (AudioSystemOEM.A(n))
            {
                f1 = (long)(a(((short []) (obj1))) + 90F);
            } else
            {
                f1 = -1F;
            }
            a1 = d;
            i1 = new bj.i(0);
            j1 = new bj.i(l1);
            if (f1 < 0.0F)
            {
                obj1 = null;
            } else
            {
                obj1 = Float.valueOf(f1);
            }
            a1.a(null, abyte0, i1, j1, ((Float) (obj1)));
            if (obj == EndPointerOEM.a.b)
            {
                l = true;
                if (!AudioSystemOEM.B(n))
                {
                    a(i, e);
                } else
                if (e != null)
                {
                    e.a();
                }
            }
            if (obj == EndPointerOEM.a.c)
            {
                f.e();
                return;
            }
            continue; /* Loop/switch isn't completed */
            if (!c) goto _L4; else goto _L6
_L6:
            obj = (byte[])obj;
            if (k1 < 0)
            {
                a(new a((new StringBuilder("Call to AudioRecord.read() failed with code: ")).append(k1).toString()));
                return;
            }
            if (k1 == 0)
            {
                if (a.b())
                {
                    a.b("AudioRecorder has no audio.");
                    return;
                }
            } else
            {
                if (a.b())
                {
                    obj1 = a;
                    stringbuilder = new StringBuilder("RECORDING: Sample #");
                    l1 = m;
                    m = l1 + 1;
                    ((bm) (obj1)).b(stringbuilder.append(l1).append(". Sending ").append(k1).append(" bytes from recorder.").toString());
                }
                obj1 = new bj.i(k1);
                d.a(((byte []) (obj)), null, ((bj.i) (obj1)), new bj.i(0), null);
                return;
            }
            if (true) goto _L4; else goto _L7
_L7:
        }

        public final void a(boolean flag, bj.a a1, bj.m m1, bj.g g1, bj.l l1, bj.d d1, bj.e e1, 
                bj.f f1)
            throws a
        {
            if (AudioSystemOEM.a(n) != null)
            {
                AudioSystemOEM.a(n).a();
            }
            Object obj = AudioSystemOEM.f();
            obj;
            JVM INSTR monitorenter ;
            m = 0;
            d = a1;
            e = d1;
            f = l1;
            g = e1;
            h = f1;
            i = m1;
            j = g1;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            a(g);
            if (AudioSystemOEM.i(n) != b.a)
            {
                break MISSING_BLOCK_LABEL_179;
            }
            int i1;
            synchronized (AudioSystemOEM.b)
            {
                i1 = AudioSystemOEM.encodeInitSpeex(AudioSystemOEM.j(n), AudioSystemOEM.k(n), 3, AudioSystemOEM.s(n), 1);
            }
            if (i1 >= 0)
            {
                break MISSING_BLOCK_LABEL_179;
            }
            throw new a((new StringBuilder("encodeInitSpeex failed with code:")).append(AudioSystemOEM.speexCodeToString(i1)).toString());
            a1;
            obj;
            JVM INSTR monitorexit ;
            throw a1;
            m1;
            a1;
            JVM INSTR monitorexit ;
            throw m1;
            try
            {
                b = new AudioRecord(AudioSystemOEM.t(n), AudioSystemOEM.u(n), 2, 2, AudioSystemOEM.v(n));
                if (b == null || b.getState() != 1)
                {
                    throw new a("AudioRecord object has not been initialized correctly. One or several parameters used to create it must be wrong.");
                }
                break MISSING_BLOCK_LABEL_254;
            }
            // Misplaced declaration of an exception variable
            catch (bj.a a1) { }
            throw new a("Could not instanciate AudioRecord object.");
            c = true;
            b.setRecordPositionUpdateListener(this);
            i1 = b.setPositionNotificationPeriod(AudioSystemOEM.w(n));
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_314;
            }
            throw new a((new StringBuilder("Call to AudioRecord.setPositionNotificationPeriod() failed with code:")).append(i1).toString());
            b.startRecording();
            i1 = 0;
            a1 = new short[AudioSystemOEM.w(n)];
_L2:
            int j1 = b.read(a1, i1, AudioSystemOEM.w(n) - i1);
            if (j1 != -3 && j1 != -2)
            {
                break MISSING_BLOCK_LABEL_408;
            }
            throw new a((new StringBuilder("Call to AudioRecord.read() failed with code:")).append(j1).toString());
            a1;
            throw new a("Call to AudioRecord.startRecording() failed.");
            if (j1 <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            j1 = i1 + j1;
            i1 = j1;
            if (j1 < AudioSystemOEM.w(n)) goto _L2; else goto _L1
_L1:
            obj;
            JVM INSTR monitorexit ;
        }

        public final void onMarkerReached(AudioRecord audiorecord)
        {
        }

        public final void onPeriodicNotification(AudioRecord audiorecord)
        {
            int i1;
            int j1;
            j1 = 0;
            i1 = 0;
            if (AudioSystemOEM.i(n) != b.a)
            {
                break MISSING_BLOCK_LABEL_201;
            }
            Object obj = AudioSystemOEM.f();
            obj;
            JVM INSTR monitorenter ;
            short aword0[];
            if (!c)
            {
                break MISSING_BLOCK_LABEL_193;
            }
            aword0 = new short[AudioSystemOEM.w(n)];
_L2:
            int k1 = audiorecord.read(aword0, i1, AudioSystemOEM.w(n) - i1);
            j1 = i1;
            if (k1 == -3)
            {
                break; /* Loop/switch isn't completed */
            }
            j1 = i1;
            if (k1 == -2)
            {
                break; /* Loop/switch isn't completed */
            }
            j1 = i1;
            if (k1 <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            j1 = i1 + k1;
            i1 = j1;
            if (j1 < AudioSystemOEM.w(n)) goto _L2; else goto _L1
_L1:
            audiorecord = AudioSystemOEM.p(n);
            Integer integer = AudioSystemOEM.i();
            Integer integer2 = new Integer(j1);
            Object obj1 = AudioSystemOEM.p(n).b();
            AudioSystemOEM.p(n).a();
            audiorecord.a(((Object) (new Object[] {
                integer, integer2, aword0
            })), this, obj1);
            obj;
            JVM INSTR monitorexit ;
            return;
            audiorecord;
            obj;
            JVM INSTR monitorexit ;
            throw audiorecord;
            obj = AudioSystemOEM.f();
            obj;
            JVM INSTR monitorenter ;
            if (!c)
            {
                break MISSING_BLOCK_LABEL_379;
            }
            aword0 = new byte[AudioSystemOEM.x(n)];
            i1 = j1;
_L4:
            k1 = audiorecord.read(aword0, i1, AudioSystemOEM.x(n) - i1);
            j1 = i1;
            if (k1 == -3)
            {
                break; /* Loop/switch isn't completed */
            }
            j1 = i1;
            if (k1 == -2)
            {
                break; /* Loop/switch isn't completed */
            }
            j1 = i1;
            if (k1 <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            j1 = i1 + k1;
            i1 = j1;
            if (j1 < AudioSystemOEM.x(n)) goto _L4; else goto _L3
_L3:
            audiorecord = AudioSystemOEM.p(n);
            Integer integer1 = AudioSystemOEM.i();
            Integer integer3 = new Integer(j1);
            Object obj2 = AudioSystemOEM.p(n).b();
            AudioSystemOEM.p(n).a();
            audiorecord.a(((Object) (new Object[] {
                integer1, integer3, aword0
            })), this, obj2);
            obj;
            JVM INSTR monitorexit ;
            return;
            audiorecord;
            obj;
            JVM INSTR monitorexit ;
            throw audiorecord;
        }

        private d()
        {
            n = AudioSystemOEM.this;
            super();
            a = d.a(getClass());
            d = null;
            e = null;
            f = null;
            g = null;
            h = null;
            i = null;
            j = null;
            k = false;
            l = false;
            m = 0;
        }

        d(byte byte0)
        {
            this();
        }
    }


    private static Object C = new Object();
    private static Object D = new Object();
    private static Object E = new Object();
    private static final Integer P = new Integer(1);
    private static final Integer Q = new Integer(2);
    private static final Integer R = new Integer(3);
    public static boolean a = false;
    public static Object b = new Object();
    public static Object c = new Object();
    public static int d = 0;
    public static int e = 0;
    private c A;
    private d B;
    private EndPointerOEM F;
    private short G[];
    private byte H[];
    private int I;
    private int J;
    private int K;
    private b L;
    private boolean M;
    private bn N;
    private boolean O;
    private Context S;
    private eo T;
    private bi U;
    private bm f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public AudioSystemOEM(bn bn, bi bi1, Vector vector)
    {
        f = d.a(getClass());
        F = null;
        M = false;
        O = false;
        S = null;
        T = null;
        U = bi1;
        a(bi1);
        N = bn;
        F = new EndPointerOEM();
        F.a(vector);
        if (vector != null)
        {
            int i1 = 0;
            while (i1 < vector.size()) 
            {
                bn = (cz)vector.get(i1);
                bi1 = bn.a();
                if (bn.d() == cz.a.a)
                {
                    if (bi1.equals("USE_ENERGY_LEVEL"))
                    {
                        if ((new String(bn.b())).equalsIgnoreCase("TRUE"))
                        {
                            if (f.b())
                            {
                                f.b("Use energy level is activated.");
                            }
                            M = true;
                        }
                    } else
                    if (bi1.equals("NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING"))
                    {
                        if ((new String(bn.b())).equalsIgnoreCase("TRUE"))
                        {
                            if (f.b())
                            {
                                f.b("_continuesOnEndPointerAndTimerStopping is activated.");
                            }
                            O = true;
                        }
                    } else
                    if (bi1.equals("NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER"))
                    {
                        if ((new String(bn.b())).equalsIgnoreCase("TRUE") && f.b())
                        {
                            f.b("_capturingContinuesOnEndPointer is activated.");
                        }
                    } else
                    if (bi1.equals("Android_Context"))
                    {
                        S = (Context)bn.c();
                        if (f.b())
                        {
                            f.b((new StringBuilder("NMSP_DEFINES_ANDROID_CONTEXT is passed in as")).append(S).toString());
                        }
                    }
                }
                i1++;
            }
        }
    }

    static boolean A(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.M;
    }

    static boolean B(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.O;
    }

    static int C(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.v;
    }

    static eo a(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.T;
    }

    private void a(bi bi1)
    {
        int i1;
        if (bi1 == bi.d)
        {
            break MISSING_BLOCK_LABEL_492;
        }
        int j1;
        if (bi1 == bi.e)
        {
            L = b.b;
            K = 11000;
            I = -1;
            J = -1;
        } else
        if (bi1 == bi.f)
        {
            L = b.b;
            K = 16000;
            I = -1;
            J = -1;
        } else
        if (bi1 == bi.g)
        {
            L = b.b;
            K = 32000;
            I = -1;
            J = -1;
        } else
        if (bi1 == bi.a)
        {
            L = b.a;
            K = 8000;
            J = 6;
            I = 0;
        } else
        if (bi1 == bi.b)
        {
            L = b.a;
            K = 16000;
            J = 8;
            I = 1;
        } else
        {
label0:
            {
                if (bi1 != bi.c)
                {
                    break label0;
                }
                L = b.a;
                K = 16000;
                J = 8;
                I = 1;
            }
        }
_L1:
        h = 1;
        i = K;
        q = 750;
        r = (q * i) / 1000;
        s = r << 1;
        j = 300;
        k = (i * j) / 1000;
        l = k << 1;
        i1 = l * 5;
        j1 = AudioTrack.getMinBufferSize(i, 2, 2);
        if (j1 != -2 && j1 != -1 && j1 > i1)
        {
            n = j1;
        } else
        {
            n = i1;
        }
        m = n / 2;
        o = 500;
        p = (i * o) / 1000;
        u = K;
        v = 100;
        w = (u * v) / 1000;
        x = w << 1;
        i1 = x * 3;
        j1 = AudioRecord.getMinBufferSize(u, 2, 2);
        if (j1 != -2 && j1 != -1 && j1 > i1)
        {
            y = j1;
        } else
        {
            y = i1;
        }
        z = x;
        return;
        if (f.e())
        {
            f.e((new StringBuilder("Codec ")).append(bi1).append(" is not handled, using PCM_16_8K by default.").toString());
        }
        L = b.b;
        K = 8000;
        I = -1;
        J = -1;
          goto _L1
    }

    static byte[] a(AudioSystemOEM audiosystemoem, byte abyte0[])
    {
        audiosystemoem.H = abyte0;
        return abyte0;
    }

    static short[] a(AudioSystemOEM audiosystemoem, short aword0[])
    {
        audiosystemoem.G = aword0;
        return aword0;
    }

    static void b(AudioSystemOEM audiosystemoem)
    {
        audiosystemoem.j();
    }

    static int c(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.l;
    }

    static int d(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.p;
    }

    static Object d()
    {
        return D;
    }

    public static native void decodeCleanupSpeex();

    public static native int decodeInitSpeex(int i1, int j1, int k1);

    public static native int decodeSpeex(byte abyte0[], int i1, short aword0[], int j1);

    static int e(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.g;
    }

    static Object e()
    {
        return E;
    }

    public static native void encodeCleanupSpeex();

    public static native int encodeInitSpeex(int i1, int j1, int k1, int l1, int i2);

    public static native int encodeSpeex(short aword0[], byte abyte0[], int i1);

    static int f(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.i;
    }

    static Object f()
    {
        return C;
    }

    static int g(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.m;
    }

    static Integer g()
    {
        return P;
    }

    static int h(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.h;
    }

    static Integer h()
    {
        return Q;
    }

    static b i(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.L;
    }

    static Integer i()
    {
        return R;
    }

    static int j(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.I;
    }

    private void j()
    {
        if (T != null)
        {
            T.c();
            T = null;
        }
    }

    static int k(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.K;
    }

    private void k()
    {
        if (U == bi.b || U == bi.c)
        {
            U = bi.a;
            a(U);
        } else
        if (U == bi.e || U == bi.f || U == bi.h || U == bi.g)
        {
            U = bi.d;
            a(U);
            return;
        }
    }

    static short[] l(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.G;
    }

    static byte[] m(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.H;
    }

    static int n(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.k;
    }

    static int o(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.r;
    }

    static bn p(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.N;
    }

    static int q(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.s;
    }

    static int r(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.q;
    }

    static int s(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.J;
    }

    public static native String speexCodeToString(int i1);

    static int t(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.t;
    }

    static int u(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.u;
    }

    static int v(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.y;
    }

    static int w(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.w;
    }

    static int x(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.x;
    }

    static int y(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.z;
    }

    static EndPointerOEM z(AudioSystemOEM audiosystemoem)
    {
        return audiosystemoem.F;
    }

    public final void a(bj.e e1)
    {
        if (f.b())
        {
            f.b("++++++++++++========== turnOnEndPointer()");
        }
        while (e1 == null || B == null) 
        {
            return;
        }
        B.a(e1);
    }

    public final void a(bj.f f1)
    {
        if (f.b())
        {
            f.b("++++++++++++========== turnOnEndPointer()");
        }
        while (f1 == null || B == null) 
        {
            return;
        }
        B.a(f1);
    }

    public final void a(bj.m m1)
    {
        if (f.b())
        {
            f.b("++++++++++++========== stopRecording()");
        }
        if (m1 == null)
        {
            return;
        }
        if (B == null)
        {
            m1.a(bj.b.a);
            return;
        } else
        {
            B.a(m1, null);
            return;
        }
    }

    public final void a(Object obj, Object obj1)
    {
        if (f.b())
        {
            f.b((new StringBuilder("---------------------- AudioSystemAndroid +++++ handleMessage() Thread:")).append(Thread.currentThread()).toString());
        }
    }

    public final boolean a()
    {
        f.c("++++++++++++========== pausePlayback() is not implemented");
        return false;
    }

    public final boolean a(bj.h h1, boolean flag, bj.a a1, bj.m m1, bj.g g1, bj.l l1, bj.d d1, 
            bj.e e1, bj.f f1)
    {
        if (f.b())
        {
            f.b("++++++++++++========== startRecording()");
        }
        if (B != null)
        {
            if (f.b())
            {
                f.b("previous recording still running!");
            }
            return false;
        }
        if (a1 == null)
        {
            if (f.e())
            {
                f.e("audioCallback cannot be null.");
            }
            return false;
        }
        if (S == null)
        {
            if (f.e())
            {
                f.e("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
            }
            return false;
        }
        T = eo.a(S);
        if (T.b())
        {
            k();
        }
        if (h1 != bj.h.a) goto _L2; else goto _L1
_L1:
        t = 6;
        j();
_L4:
        B = new d((byte)0);
        try
        {
            B.a(flag, a1, m1, g1, l1, d1, e1, f1);
        }
        // Misplaced declaration of an exception variable
        catch (bj.h h1)
        {
            d.a(B, h1);
            B = null;
            return false;
        }
        return true;
_L2:
        if (h1 != bj.h.c)
        {
            break; /* Loop/switch isn't completed */
        }
        t = T.g();
        if (!T.b())
        {
            j();
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (f.e())
        {
            f.e("Unexpected inputDevice.");
        }
        j();
        return false;
    }

    public final boolean a(bj.k k1, bj.a a1, bj.c c1)
    {
        if (f.b())
        {
            f.b("++++++++++++========== startPlayback()");
        }
        if (a1 != null) goto _L2; else goto _L1
_L1:
        if (f.e())
        {
            f.e("audioCallback cannot be null.");
        }
_L4:
        return false;
_L2:
        if (S != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (f.e())
        {
            f.e("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        T = eo.a(S);
        if (T.b())
        {
            k();
        }
        if (k1 != bj.k.a) goto _L6; else goto _L5
_L5:
        g = 3;
        j();
_L8:
        A = new c((byte)0);
        try
        {
            A.a(a1, c1);
        }
        // Misplaced declaration of an exception variable
        catch (bj.k k1)
        {
            c.a(A, k1);
            A = null;
            return false;
        }
        return true;
_L6:
        if (k1 != bj.k.c)
        {
            break; /* Loop/switch isn't completed */
        }
        g = T.f();
        if (!T.b())
        {
            j();
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (f.e())
        {
            f.e("Unexpected outputDevice.");
        }
        j();
        return false;
    }

    public final void b(bj.m m1)
    {
        if (f.b())
        {
            f.b("++++++++++++========== stopPlayback()");
        }
        if (A != null)
        {
            A.a(m1);
        }
        A = null;
    }

    public final boolean b()
    {
        f.c("++++++++++++========== previousPlayback() is not implemented");
        return false;
    }

    public final boolean c()
    {
        f.c("++++++++++++========== nextPlayback() is not implemented");
        return false;
    }

    static 
    {
        System.loadLibrary("nmsp_speex");
    }
}
