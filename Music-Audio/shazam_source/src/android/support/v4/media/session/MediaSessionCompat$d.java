// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.a;
import android.view.KeyEvent;
import java.util.List;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat, e, f, d, 
//            a, PlaybackStateCompat, ParcelableVolumeInfo

static final class v
    implements v
{
    private static final class a
    {

        public final String a;
        public final Bundle b;
        public final ResultReceiver c;

        public a(String s1, Bundle bundle, ResultReceiver resultreceiver)
        {
            a = s1;
            b = bundle;
            c = resultreceiver;
        }
    }

    final class b extends b.a
    {

        final MediaSessionCompat.d a;

        public final void a(int i1, int j1, String s1)
        {
            android.support.v4.media.session.MediaSessionCompat.d.a(a, i1, j1);
        }

        public final void a(long l1)
        {
            a.a.a(4, Long.valueOf(l1));
        }

        public final void a(RatingCompat ratingcompat)
        {
            a.a.a(12, ratingcompat);
        }

        public final void a(android.support.v4.media.session.a a1)
        {
            if (a.g)
            {
                try
                {
                    a1.a();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (android.support.v4.media.session.a a1)
                {
                    return;
                }
            } else
            {
                a.f.register(a1);
                return;
            }
        }

        public final void a(String s1, Bundle bundle)
        {
            a.a.a(2, s1, bundle);
        }

        public final void a(String s1, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultreceiverwrapper)
        {
            a.a.a(15, new a(s1, bundle, android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.a(resultreceiverwrapper)));
        }

        public final boolean a()
        {
            return (a.i & 2) != 0;
        }

        public final boolean a(KeyEvent keyevent)
        {
            boolean flag;
            if ((a.i & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                a.a.a(14, keyevent);
            }
            return flag;
        }

        public final String b()
        {
            return a.b;
        }

        public final void b(int i1, int j1, String s1)
        {
            MediaSessionCompat.d.b(a, i1, j1);
        }

        public final void b(long l1)
        {
            a.a.a(11, Long.valueOf(l1));
        }

        public final void b(android.support.v4.media.session.a a1)
        {
            a.f.unregister(a1);
        }

        public final void b(String s1, Bundle bundle)
        {
            a.a.a(3, s1, bundle);
        }

        public final String c()
        {
            return a.c;
        }

        public final void c(String s1, Bundle bundle)
        {
            a.a.a(13, s1, bundle);
        }

        public final PendingIntent d()
        {
            PendingIntent pendingintent;
            synchronized (a.e)
            {
                pendingintent = a.k;
            }
            return pendingintent;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final long e()
        {
            long l1;
            synchronized (a.e)
            {
                l1 = a.i;
            }
            return l1;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final ParcelableVolumeInfo f()
        {
            int i1 = 2;
            Object obj = a.e;
            obj;
            JVM INSTR monitorenter ;
            android.support.v4.media.a a1;
            int l1;
            int i2;
            l1 = a.p;
            i2 = a.q;
            a1 = a.r;
            if (l1 != 2)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            int j1;
            int k1;
            i1 = a1.a;
            j1 = a1.b;
            k1 = a1.c;
_L1:
            obj;
            JVM INSTR monitorexit ;
            return new ParcelableVolumeInfo(l1, i2, i1, j1, k1);
            j1 = a.d.getStreamMaxVolume(i2);
            k1 = a.d.getStreamVolume(i2);
              goto _L1
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void g()
        {
            a.a.a(1, null);
        }

        public final void h()
        {
            a.a.a(5, null);
        }

        public final void i()
        {
            a.a.a(6, null);
        }

        public final void j()
        {
            a.a.a(7, null);
        }

        public final void k()
        {
            a.a.a(8, null);
        }

        public final void l()
        {
            a.a.a(9, null);
        }

        public final void m()
        {
            a.a.a(10, null);
        }

        public final MediaMetadataCompat n()
        {
            return a.j;
        }

        public final PlaybackStateCompat o()
        {
            return a.c();
        }

        public final List p()
        {
            List list;
            synchronized (a.e)
            {
                list = a.l;
            }
            return list;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final CharSequence q()
        {
            return a.m;
        }

        public final Bundle r()
        {
            Bundle bundle;
            synchronized (a.e)
            {
                bundle = a.o;
            }
            return bundle;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final int s()
        {
            return a.n;
        }

        b()
        {
            a = MediaSessionCompat.d.this;
            super();
        }
    }

    private final class c extends Handler
    {

        final MediaSessionCompat.d a;

        public final void a(int i1, Object obj)
        {
            obtainMessage(i1, obj).sendToTarget();
        }

        public final void a(int i1, Object obj, Bundle bundle)
        {
            obj = obtainMessage(i1, obj);
            ((Message) (obj)).setData(bundle);
            ((Message) (obj)).sendToTarget();
        }

        public final void handleMessage(Message message)
        {
            if (a.h != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
                break;

            case 2: // '\002'
                Object obj = message.obj;
                message.getData();
                return;

            case 3: // '\003'
                Object obj1 = message.obj;
                message.getData();
                return;

            case 4: // '\004'
                ((Long)message.obj).longValue();
                return;

            case 11: // '\013'
                ((Long)message.obj).longValue();
                return;

            case 12: // '\f'
                message = ((Message) (message.obj));
                return;

            case 13: // '\r'
                Object obj2 = message.obj;
                message.getData();
                return;

            case 14: // '\016'
                message = (KeyEvent)message.obj;
                (new Intent("android.intent.action.MEDIA_BUTTON")).putExtra("android.intent.extra.KEY_EVENT", message);
                return;

            case 15: // '\017'
                message = ((Message) (message.obj));
                return;

            case 16: // '\020'
                android.support.v4.media.session.MediaSessionCompat.d.a(a, ((Integer)message.obj).intValue(), 0);
                return;

            case 17: // '\021'
                MediaSessionCompat.d.b(a, ((Integer)message.obj).intValue(), 0);
                break; /* Loop/switch isn't completed */
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public c(Looper looper)
        {
            a = MediaSessionCompat.d.this;
            super(looper);
        }
    }


    private boolean A;
    private PlaybackStateCompat B;
    private android.support.v4.media.Compat C;
    final c a = new c(Looper.myLooper());
    final String b;
    final String c;
    final AudioManager d;
    final Object e = new Object();
    final RemoteCallbackList f = new RemoteCallbackList();
    boolean g;
    c h;
    int i;
    MediaMetadataCompat j;
    PendingIntent k;
    List l;
    CharSequence m;
    int n;
    Bundle o;
    int p;
    int q;
    android.support.v4.media.a r;
    private final Context s;
    private final ComponentName t;
    private final PendingIntent u;
    private final Object v;
    private final b w = new b();
    private final ken x;
    private boolean y;
    private boolean z;

    static void a(c.a a1, int i1, int j1)
    {
        if (a1.p == 2)
        {
            if (a1.r == null);
            return;
        } else
        {
            a1.d.adjustStreamVolume(i1, a1.q, j1);
            return;
        }
    }

    static void b(q q1, int i1, int j1)
    {
        if (q1.p == 2)
        {
            if (q1.r == null);
            return;
        } else
        {
            q1.d.setStreamVolume(q1.q, i1, j1);
            return;
        }
    }

    private boolean d()
    {
        if (y)
        {
            if (android.os. >= 8)
            {
                if (!A && (i & 1) != 0)
                {
                    Context context1;
                    Object obj;
                    if (android.os. >= 18)
                    {
                        Context context = s;
                        PendingIntent pendingintent = u;
                        ((AudioManager)context.getSystemService("audio")).registerMediaButtonEventReceiver(pendingintent);
                    } else
                    {
                        Context context2 = s;
                        ComponentName componentname = t;
                        ((AudioManager)context2.getSystemService("audio")).registerMediaButtonEventReceiver(componentname);
                    }
                    A = true;
                } else
                if (A && (i & 1) == 0)
                {
                    if (android.os. >= 18)
                    {
                        android.support.v4.media.session.e.a(s, u);
                    } else
                    {
                        android.support.v4.media.session.f.a(s, t);
                    }
                    A = false;
                }
            }
            if (android.os. >= 14)
            {
                if (!z && (i & 2) != 0)
                {
                    context1 = s;
                    obj = v;
                    ((AudioManager)context1.getSystemService("audio")).registerRemoteControlClient((RemoteControlClient)obj);
                    z = true;
                    return true;
                }
                if (z && (i & 2) == 0)
                {
                    android.support.v4.media.session.d.a(s, v);
                    z = false;
                    return false;
                }
            }
        } else
        {
            if (A)
            {
                if (android.os. >= 18)
                {
                    android.support.v4.media.session.e.a(s, u);
                } else
                {
                    android.support.v4.media.session.f.a(s, t);
                }
                A = false;
            }
            if (z)
            {
                android.support.v4.media.session.d.a(s, v);
                z = false;
            }
        }
        return false;
    }

    public final void a()
    {
        if (!y)
        {
            y = true;
            if (d())
            {
                a(j);
                a(B);
                return;
            }
        }
    }

    public final void a(int i1)
    {
        synchronized (e)
        {
            i = i1;
        }
        d();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(PendingIntent pendingintent)
    {
    }

    public final void a(MediaMetadataCompat mediametadatacompat)
    {
        Object obj1 = null;
        Object obj = null;
        synchronized (e)
        {
            j = mediametadatacompat;
        }
        int i1 = f.beginBroadcast() - 1;
        while (i1 >= 0) 
        {
            obj2 = (android.support.v4.media.session.a)f.getBroadcastItem(i1);
            long l1;
            try
            {
                ((android.support.v4.media.session.a) (obj2)).a(mediametadatacompat);
            }
            catch (RemoteException remoteexception) { }
            i1--;
        }
        break MISSING_BLOCK_LABEL_74;
        mediametadatacompat;
        obj2;
        JVM INSTR monitorexit ;
        throw mediametadatacompat;
        f.finishBroadcast();
        if (y)
        {
            if (android.os. >= 19)
            {
                obj1 = v;
                if (mediametadatacompat == null)
                {
                    mediametadatacompat = ((MediaMetadataCompat) (obj));
                } else
                {
                    mediametadatacompat = mediametadatacompat.b;
                }
                if (B == null)
                {
                    l1 = 0L;
                } else
                {
                    l1 = B.e;
                }
                obj = ((RemoteControlClient)obj1).editMetadata(true);
                android.support.v4.media.session.d.a(mediametadatacompat, ((android.media.etadataEditor) (obj)));
                if (mediametadatacompat != null)
                {
                    if (mediametadatacompat.containsKey("android.media.metadata.YEAR"))
                    {
                        ((android.media.etadataEditor) (obj)).putLong(8, mediametadatacompat.getLong("android.media.metadata.YEAR"));
                    }
                    if (mediametadatacompat.containsKey("android.media.metadata.RATING"))
                    {
                        ((android.media.etadataEditor) (obj)).putObject(101, mediametadatacompat.getParcelable("android.media.metadata.RATING"));
                    }
                    if (mediametadatacompat.containsKey("android.media.metadata.USER_RATING"))
                    {
                        ((android.media.etadataEditor) (obj)).putObject(0x10000001, mediametadatacompat.getParcelable("android.media.metadata.USER_RATING"));
                    }
                }
                if ((l1 & 128L) != 0L)
                {
                    ((android.media.etadataEditor) (obj)).addEditableKey(0x10000001);
                }
                ((android.media.etadataEditor) (obj)).apply();
                return;
            }
            if (android.os. >= 14)
            {
                obj = v;
                if (mediametadatacompat == null)
                {
                    mediametadatacompat = ((MediaMetadataCompat) (obj1));
                } else
                {
                    mediametadatacompat = mediametadatacompat.b;
                }
                obj = ((RemoteControlClient)obj).editMetadata(true);
                android.support.v4.media.session.d.a(mediametadatacompat, ((android.media.etadataEditor) (obj)));
                ((android.media.etadataEditor) (obj)).apply();
                return;
            }
        }
        return;
    }

    public final void a(PlaybackStateCompat playbackstatecompat)
    {
        synchronized (e)
        {
            B = playbackstatecompat;
        }
        int i1 = f.beginBroadcast() - 1;
        while (i1 >= 0) 
        {
            obj = (android.support.v4.media.session.a)f.getBroadcastItem(i1);
            float f1;
            Object obj1;
            int j1;
            long l1;
            long l4;
            try
            {
                ((android.support.v4.media.session.a) (obj)).a(playbackstatecompat);
            }
            catch (RemoteException remoteexception) { }
            i1--;
        }
        break MISSING_BLOCK_LABEL_64;
        playbackstatecompat;
        obj;
        JVM INSTR monitorexit ;
        throw playbackstatecompat;
        f.finishBroadcast();
        if (y) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (playbackstatecompat != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (android.os. >= 14)
        {
            android.support.v4.media.session.d.a(v, 0);
            android.support.v4.media.session.d.a(v, 0L);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
label0:
        {
            {
                if (android.os. < 18)
                {
                    break label0;
                }
                obj1 = v;
                i1 = playbackstatecompat.a;
                long l3 = playbackstatecompat.b;
                f1 = playbackstatecompat.d;
                l1 = playbackstatecompat.g;
                l4 = SystemClock.elapsedRealtime();
                long l2;
                if (i1 == 3 && l3 > 0L)
                {
                    if (l1 > 0L)
                    {
                        l4 -= l1;
                        l2 = l4;
                        if (f1 > 0.0F)
                        {
                            l2 = l4;
                            if (f1 != 1.0F)
                            {
                                l2 = (long)((float)l4 * f1);
                            }
                        }
                    } else
                    {
                        l2 = 0L;
                    }
                    l2 += l3;
                } else
                {
                    l2 = l3;
                }
                i1 = android.support.v4.media.session.d.a(i1);
                ((RemoteControlClient)obj1).setPlaybackState(i1, l2, f1);
            }
            if (android.os. >= 19)
            {
                obj1 = v;
                l2 = playbackstatecompat.e;
                playbackstatecompat = (RemoteControlClient)obj1;
                j1 = android.support.v4.media.session.e.a(l2);
                i1 = j1;
                if ((l2 & 128L) != 0L)
                {
                    i1 = j1 | 0x200;
                }
                playbackstatecompat.setTransportControlFlags(i1);
                return;
            }
            break; /* Loop/switch isn't completed */
        }
        if (android.os. >= 14)
        {
            android.support.v4.media.session.d.a(v, playbackstatecompat.a);
        }
        if (true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_230;
_L4:
        if (android.os. >= 18)
        {
            obj1 = v;
            l2 = playbackstatecompat.e;
            ((RemoteControlClient)obj1).setTransportControlFlags(android.support.v4.media.session.e.a(l2));
            return;
        }
        if (android.os. >= 14)
        {
            android.support.v4.media.session.d.a(v, playbackstatecompat.e);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final ken b()
    {
        return x;
    }

    final PlaybackStateCompat c()
    {
        long l2 = -1L;
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        PlaybackStateCompat playbackstatecompat = B;
        long l1 = l2;
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        l1 = l2;
        if (j.b.containsKey("android.media.metadata.DURATION"))
        {
            l1 = j.a("android.media.metadata.DURATION");
        }
        obj;
        JVM INSTR monitorexit ;
        if (playbackstatecompat == null || playbackstatecompat.a != 3 && playbackstatecompat.a != 4 && playbackstatecompat.a != 5) goto _L2; else goto _L1
_L1:
        long l3;
        l2 = playbackstatecompat.g;
        l3 = SystemClock.elapsedRealtime();
        if (l2 <= 0L) goto _L2; else goto _L3
_L3:
        l2 = (long)(playbackstatecompat.d * (float)(l3 - l2)) + playbackstatecompat.b;
        Object obj1;
        Exception exception;
        if (l1 < 0L || l2 <= l1)
        {
            if (l2 < 0L)
            {
                l1 = 0L;
            } else
            {
                l1 = l2;
            }
        }
        obj = new (playbackstatecompat);
        (() (obj)).a(playbackstatecompat.a, l1, playbackstatecompat.d, l3);
        obj = (() (obj)).a();
_L5:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = playbackstatecompat;
        }
        return ((PlaybackStateCompat) (obj1));
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public _cls1.a(Context context, String s1, ComponentName componentname, PendingIntent pendingintent)
    {
        g = false;
        y = false;
        z = false;
        A = false;
        C = new android.support.v4.media.a.a() {

            final MediaSessionCompat.d a;

            
            {
                a = MediaSessionCompat.d.this;
                super();
            }
        };
        if (componentname == null)
        {
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }
        s = context;
        b = context.getPackageName();
        d = (AudioManager)context.getSystemService("audio");
        c = s1;
        t = componentname;
        u = pendingintent;
        x = new ken(w);
        n = 0;
        p = 1;
        q = 3;
        if (android.os. >= 14)
        {
            v = new RemoteControlClient(pendingintent);
            return;
        } else
        {
            v = null;
            return;
        }
    }
}
