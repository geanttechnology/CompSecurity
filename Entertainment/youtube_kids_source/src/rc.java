// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.EnumMap;
import java.util.List;

public class rc extends Service
{

    private static final EnumMap k;
    private cun a;
    private rx b;
    private bje c;
    private bme d;
    private boolean e;
    private long f;
    private boolean g;
    private sm h;
    private cuw i;
    private cxc j;

    public rc()
    {
    }

    static long a(rc rc1)
    {
        return rc1.f;
    }

    static long a(rc rc1, long l)
    {
        rc1.f = 0L;
        return 0L;
    }

    static cuw a(rc rc1, cuw cuw)
    {
        rc1.i = cuw;
        return cuw;
    }

    static EnumMap a()
    {
        return k;
    }

    static rx b(rc rc1)
    {
        return rc1.b;
    }

    static cun c(rc rc1)
    {
        return rc1.a;
    }

    static bme d(rc rc1)
    {
        return rc1.d;
    }

    static cuw e(rc rc1)
    {
        return rc1.i;
    }

    static boolean f(rc rc1)
    {
        return rc1.e;
    }

    private void handlePlaybackServiceException(cse cse)
    {
        a.a(cut.f);
        stopForeground(false);
    }

    private void handleSequencerHasPreviousNextEvent(csx csx1)
    {
        a.a(csx1.a, csx1.b);
    }

    private void handleVideoStageEvent(ctd ctd1)
    {
        ctt ctt1 = ctd1.b;
        if (ctt1.a(new ctt[] {
    ctt.j
}))
        {
            stopForeground(false);
        } else
        if ((ctt1.a(new ctt[] {
    ctt.b
}) || g && ctt1.a(ctt.b)) && !TextUtils.isEmpty(bxb.a(ctd1.c.a)))
        {
            g = false;
            cun cun1 = a;
            bxb bxb1 = ctd1.c;
            b.a(bxb1);
            if (!bxb.a(bxb1.a).equals(cun1.d))
            {
                cun1.d = bxb.a(bxb1.a);
                cun1.c.a();
                cun1.d();
                if (cun1.a.a())
                {
                    ctd1 = bxb1.d().a;
                    if (ctd1.isEmpty())
                    {
                        ctd1 = null;
                    } else
                    {
                        ctd1 = ((btt)ctd1.get(ctd1.size() - 1)).a;
                    }
                    cun1.a(bxb.a(bxb1.a), bxb1.c(), bxb1.e() * 1000, ctd1);
                    return;
                } else
                {
                    cun1.b(cun1.d);
                    return;
                }
            }
        }
    }

    private void handleVideoTimeEvent(cte cte1)
    {
        f = cte1.a;
    }

    private void handleYouTubePlayerStateEvent(ctf ctf1)
    {
        boolean flag;
        if (ctf1.a == 2 || ctf1.a == 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        ctf1.a;
        JVM INSTR tableswitch 2 6: default 64
    //                   2 70
    //                   3 64
    //                   4 91
    //                   5 64
    //                   6 70;
           goto _L1 _L2 _L1 _L3 _L1 _L2
_L1:
        return;
_L2:
        if (b.c.c)
        {
            a.a();
            return;
        }
          goto _L1
_L3:
        stopForeground(false);
        return;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        Object obj = (sc)getApplication();
        bmf bmf1 = ((sc) (obj)).g();
        bgv bgv1 = ((sc) (obj)).c();
        obj = ((sc) (obj)).d();
        c = bgv1.d();
        a = new cun(getApplication(), bgv1.l(), bmf1.c(), ((cnq) (obj)).c(), bmf1.n(), bmf1.u(), bgv1.h(), bgv1.a(), null, new rf(this), 0x7f020197, null, bmf1.x(), (byte)0);
        b = bmf1.H();
        d = bmf1.r();
        h = new sm(getResources(), b, bgv1.d(), new re(this));
        j = bmf1.z();
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a.a(new rd(this));
        }
    }

    public void onDestroy()
    {
        c.b(this);
        c.b(a);
        c.b(h);
        if (b.c.c)
        {
            b.a(true);
        }
        a.b();
        a = null;
        i = null;
        h = null;
        j.a();
        j = null;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int l, int i1)
    {
        boolean flag = intent.getBooleanExtra("background_mode", false);
        d.a();
        if (flag)
        {
            g = true;
            c.a(this);
            c.a(h);
            b.p();
            if (e)
            {
                a.a();
            }
        } else
        {
            c.b(this);
            a.b();
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent)
    {
        b.b();
        stopSelf();
    }

    static 
    {
        EnumMap enummap = new EnumMap(cuv);
        k = enummap;
        enummap.put(cuv.a, cut.d);
        k.put(cuv.b, cut.c);
        k.put(cuv.c, cut.b);
        k.put(cuv.d, cut.a);
        k.put(cuv.g, cut.e);
        k.put(cuv.f, cut.f);
        k.put(cuv.e, cut.f);
    }
}
