// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.a;
import android.view.KeyEvent;
import java.util.List;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat, a, ParcelableVolumeInfo, PlaybackStateCompat

final class a extends a
{

    final a a;

    public final void a(int i1, int j1, String s1)
    {
        android.support.v4.media.session.a(a, i1, j1);
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
        if (a.a)
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
            a.a.register(a1);
            return;
        }
    }

    public final void a(String s1, Bundle bundle)
    {
        a.a.a(2, s1, bundle);
    }

    public final void a(String s1, Bundle bundle, ltReceiverWrapper ltreceiverwrapper)
    {
        a.a.a(15, new <init>(s1, bundle, android.support.v4.media.session.ltReceiverWrapper.a(ltreceiverwrapper)));
    }

    public final boolean a()
    {
        return (a.a & 2) != 0;
    }

    public final boolean a(KeyEvent keyevent)
    {
        boolean flag;
        if ((a.a & 1) != 0)
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
        return a.a;
    }

    public final void b(int i1, int j1, String s1)
    {
        a(a, i1, j1);
    }

    public final void b(long l1)
    {
        a.a.a(11, Long.valueOf(l1));
    }

    public final void b(android.support.v4.media.session.a a1)
    {
        a.a.unregister(a1);
    }

    public final void b(String s1, Bundle bundle)
    {
        a.a.a(3, s1, bundle);
    }

    public final String c()
    {
        return a.a;
    }

    public final void c(String s1, Bundle bundle)
    {
        a.a.a(13, s1, bundle);
    }

    public final PendingIntent d()
    {
        PendingIntent pendingintent;
        synchronized (a.a)
        {
            pendingintent = a.a;
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
        synchronized (a.a)
        {
            l1 = a.a;
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
        Object obj = a.a;
        obj;
        JVM INSTR monitorenter ;
        a a1;
        int l1;
        int i2;
        l1 = a.a;
        i2 = a.a;
        a1 = a.a;
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
        j1 = a.a.getStreamMaxVolume(i2);
        k1 = a.a.getStreamVolume(i2);
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
        return a.a;
    }

    public final PlaybackStateCompat o()
    {
        return a.a();
    }

    public final List p()
    {
        List list;
        synchronized (a.a)
        {
            list = a.a;
        }
        return list;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final CharSequence q()
    {
        return a.a;
    }

    public final Bundle r()
    {
        Bundle bundle;
        synchronized (a.a)
        {
            bundle = a.a;
        }
        return bundle;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int s()
    {
        return a.a;
    }

    ltReceiverWrapper(ltReceiverWrapper ltreceiverwrapper)
    {
        a = ltreceiverwrapper;
        super();
    }
}
