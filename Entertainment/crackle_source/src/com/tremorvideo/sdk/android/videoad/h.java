// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Process;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tremorvideo.sdk.android.richmedia.a;
import com.tremorvideo.sdk.android.richmedia.a.f;
import com.tremorvideo.sdk.android.richmedia.b.c;
import com.tremorvideo.sdk.android.richmedia.d;
import com.tremorvideo.sdk.android.richmedia.l;
import com.tremorvideo.sdk.android.richmedia.m;
import com.tremorvideo.sdk.android.richmedia.n;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            a, s, y, ax, 
//            aw, ad, bu, br, 
//            Playvideo, ab

public class h extends com.tremorvideo.sdk.android.videoad.a
    implements com.tremorvideo.sdk.android.richmedia.n.a, ax.a, ax.c, bu.a
{
    private class a
        implements Runnable
    {

        ArrayList a;
        final h b;
        private int c;
        private android.widget.RelativeLayout.LayoutParams d;
        private com.tremorvideo.sdk.android.richmedia.a.h e;

        public void run()
        {
            if (c != 1) goto _L2; else goto _L1
_L1:
            if (d != null && e != null)
            {
                b.b(d, e);
            }
_L4:
            return;
_L2:
            if (c != 2)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (a == null) goto _L4; else goto _L3
_L3:
            b.b(a);
            return;
            if (c != 3 || e == null) goto _L4; else goto _L5
_L5:
            b.b(e);
            return;
        }

        public a(int i1, android.widget.RelativeLayout.LayoutParams layoutparams, com.tremorvideo.sdk.android.richmedia.a.h h2, ArrayList arraylist)
        {
            b = h.this;
            super();
            c = i1;
            d = layoutparams;
            e = h2;
            a = arraylist;
        }
    }

    private class b
        implements Runnable
    {

        final h a;
        private com.tremorvideo.sdk.android.videoad.a b;

        public void run()
        {
            a.d.a(b);
        }

        public b(com.tremorvideo.sdk.android.videoad.a a1)
        {
            a = h.this;
            super();
            b = a1;
        }
    }

    private class c
        implements Runnable
    {

        final h a;
        private int b;
        private android.widget.RelativeLayout.LayoutParams c;

        private void a()
        {
            if (a.h != null)
            {
                if (a.h.getParent() == a.g)
                {
                    a.g.removeView(a.h);
                }
                a.h.clearView();
            }
        }

        private void a(android.widget.RelativeLayout.LayoutParams layoutparams)
        {
            boolean flag = false;
            if (a.h != null)
            {
                a.h.setVisibility(0);
                if (a.g == a.h.getParent())
                {
                    flag = true;
                }
                if (!flag)
                {
                    a.g.addView(a.h, layoutparams);
                } else
                {
                    a.h.setLayoutParams(layoutparams);
                    a.h.requestLayout();
                }
                a.g.requestLayout();
            }
        }

        public void run()
        {
            if (b == 1)
            {
                a(c);
            } else
            if (b == 2)
            {
                a();
                return;
            }
        }

        public c(int i1, android.widget.RelativeLayout.LayoutParams layoutparams)
        {
            a = h.this;
            super();
            b = i1;
            c = layoutparams;
        }
    }


    s b;
    n e;
    d f;
    RelativeLayout g;
    com.tremorvideo.sdk.android.richmedia.b.d h;
    ax i;
    boolean j;
    int k;
    int l;
    boolean m;
    boolean n;
    l o[];

    public h(a.a a1, Activity activity, s s1)
    {
        int i1 = 0;
        super(a1, activity);
        j = false;
        k = 0;
        l = -1;
        m = false;
        n = false;
        b = s1;
        o = b.I();
        s1 = o;
        for (int j1 = s1.length; i1 < j1; i1++)
        {
            l l1 = s1[i1];
            if (!l1.f())
            {
                l1.a(com.tremorvideo.sdk.android.videoad.y.a(activity.getFilesDir(), l1.e()).getAbsolutePath());
            }
        }

        f = new d(c, b.H());
        e = new n(c, f, b.H(), b.F(), b.G(), o, b.D());
        e.a(this);
        f.a(e.f());
        i = new ax(activity, a1, b.q());
        i.a(this);
        i.a(this);
        b.H().a(i);
        a1 = b.a(aw.b.I);
        if (a1 != null)
        {
            activity = a1.a("zip", "");
            s1 = a1.a("movie", "");
            String s2 = a1.a("movie-date", "");
            b.H().s();
            b.H().b(activity);
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            if (s2 != null && s2.length() > 0)
            {
                try
                {
                    Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(s2);
                    if (date.after(gregoriancalendar.getTime()))
                    {
                        gregoriancalendar.setTime(date);
                    }
                }
                catch (Exception exception)
                {
                    com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Invalid TMS date: ").append(s2).toString());
                }
            }
            b.H().a(gregoriancalendar);
            i.a(activity);
            i.a(ad.k());
            i.a(ad.k());
            ad.k().a(activity, s1, a1.j(), gregoriancalendar);
            ad.k().a(this);
            ad.k().a();
        }
        a1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        g = new RelativeLayout(c);
        g.setBackgroundColor(0xff000000);
        g.addView(f, a1);
        g.addView(e.l(), a1);
        g.addView(e, a1);
        a1 = b.a(aw.b.am);
        if (a1 != null)
        {
            h = new com.tremorvideo.sdk.android.richmedia.b.d(c);
            a1 = a1.a("query-url", "");
            b.r = new com.tremorvideo.sdk.android.richmedia.b.c(this, h, a1);
            b.H().a(b.r);
            h.a(b.r);
        }
        b.s = new f(c, this);
        b.H().a(b.s);
        if (e.r())
        {
            e();
        } else
        {
            e.a(this);
            n = true;
        }
        a1 = b.B();
        if (a1 != null)
        {
            i.a(a1);
        }
        c.requestWindowFeature(1);
        c.getWindow().setFlags(1024, 1024);
        com.tremorvideo.sdk.android.videoad.ad.a(c.getWindow());
        c.setContentView(g);
    }

    private void e()
    {
        int i1 = d.i();
        if (b.H().i())
        {
            if (i1 == 0)
            {
                if (b.f().a("lock-orientation"))
                {
                    com.tremorvideo.sdk.android.videoad.ad.d(c);
                    l = 0;
                }
                if (b.H().j() != null)
                {
                    e.a(b.H().j());
                    return;
                } else
                {
                    e.a(b.H().k());
                    return;
                }
            }
            if (b.f().a("lock-orientation"))
            {
                com.tremorvideo.sdk.android.videoad.ad.c(c);
                l = 1;
            }
            if (b.H().k() != null)
            {
                e.a(b.H().k());
                return;
            } else
            {
                e.a(b.H().j());
                return;
            }
        }
        if (i1 == 0)
        {
            if (b.H().j() == null)
            {
                i1 = 1;
            }
        } else
        if (b.H().k() == null)
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            l = 0;
            com.tremorvideo.sdk.android.videoad.ad.d(c);
            e.a(b.H().j());
            d.b(l);
            return;
        } else
        {
            l = 1;
            com.tremorvideo.sdk.android.videoad.ad.c(c);
            e.a(b.H().k());
            d.b(l);
            return;
        }
    }

    public void a()
    {
        j = false;
        if (i.b())
        {
            i.e();
            i.b(null);
        }
    }

    public void a(int i1, int j1, int k1)
    {
        e.f().a(i1, j1, k1);
    }

    public void a(Configuration configuration)
    {
        if (l == -1)
        {
            e.a(false);
            return;
        } else
        {
            e.a(true);
            return;
        }
    }

    public void a(android.widget.RelativeLayout.LayoutParams layoutparams)
    {
        c.runOnUiThread(new c(1, layoutparams));
    }

    public void a(android.widget.RelativeLayout.LayoutParams layoutparams, com.tremorvideo.sdk.android.richmedia.a.h h1)
    {
        c.runOnUiThread(new a(1, layoutparams, h1, null));
    }

    public void a(com.tremorvideo.sdk.android.richmedia.a.h h1)
    {
        c.runOnUiThread(new a(3, null, h1, null));
    }

    public void a(m m1, boolean flag)
    {
        ad.k().a(null);
        ad.k().b();
        i.a();
        b.H().a(null);
        m = flag;
        if (!m)
        {
            m1 = b.C();
            if (m1 != null)
            {
                i.a(m1);
            }
            e.h();
        }
        c.runOnUiThread(new b(this));
    }

    public void a(aw.b b1, int i1, int j1, int k1)
    {
label0:
        {
            if (b1 == aw.b.L)
            {
                b1 = b.a(b1);
                if (b1 != null)
                {
                    int l1 = b1.a("age", 0);
                    b1 = new GregorianCalendar();
                    GregorianCalendar gregoriancalendar = new GregorianCalendar(i1, j1, k1);
                    gregoriancalendar.roll(1, l1);
                    if (!gregoriancalendar.before(b1))
                    {
                        break label0;
                    }
                    e.f().a(com.tremorvideo.sdk.android.richmedia.c.n);
                }
            }
            return;
        }
        e.f().a(com.tremorvideo.sdk.android.richmedia.c.o);
    }

    public void a(aw.b b1, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        b1 = b.a(b1);
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        int i1 = d.a(b1);
        d.a(i1);
        b1 = new Intent(c, com/tremorvideo/sdk/android/videoad/Playvideo);
        b1.putExtra("tremorVideoType", "webview");
        b1.putExtra("tremorVideoURL", s1);
        c.startActivityForResult(b1, 3232);
        this;
        JVM INSTR monitorexit ;
        return;
        b1;
        throw b1;
    }

    public void a(aw aw1)
    {
        if (aw1 == null) goto _L2; else goto _L1
_L1:
        if (aw1.a() != aw.b.w) goto _L4; else goto _L3
_L3:
        k = k + 1;
_L2:
        if (aw1 == null || !aw1.p())
        {
            e.i();
        }
        return;
_L4:
        if (aw1.a() == aw.b.v)
        {
            e.h();
            d.a(this);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void a(aw aw1, int i1)
    {
        a(aw1, i1, ((String) (null)));
    }

    public void a(aw aw1, int i1, String s1)
    {
label0:
        {
label1:
            {
                if (aw1 != null)
                {
                    if (!aw1.m())
                    {
                        break label0;
                    }
                    if (aw1.a() != aw.b.as || !j)
                    {
                        break label1;
                    }
                }
                return;
            }
            i.a(aw1, i1, s1);
            return;
        }
        aw1 = new ab(c, b.q(), com.tremorvideo.sdk.android.videoad.ab.a.a, new ab.b() {

            final h a;

            public void a(boolean flag)
            {
                a.e.j();
            }

            
            {
                a = h.this;
                super();
            }
        });
        aw1.setCanceledOnTouchOutside(false);
        aw1.setTitle("Unsupported Feature");
        aw1.a("Sorry, that feature is not supported on your device.");
        aw1.a("OK", "");
        aw1.show();
        e.i();
    }

    public void a(String s1)
    {
        e.f().a(s1);
    }

    public void a(String s1, int i1)
    {
        if (s1 == "adchoices")
        {
            s1 = b.a(aw.b.H);
        } else
        {
            s1 = b.c(s1);
        }
        if (s1 != null)
        {
            a(((aw) (s1)), i1, ((String) (null)));
        }
    }

    public void a(String s1, aw.b b1, int i1, String s2)
    {
        Object obj;
        if (s1 != null)
        {
            s1 = b.c(s1);
        } else
        {
            s1 = null;
        }
        obj = s1;
        if (s1 == null)
        {
            obj = s1;
            if (b1 == aw.b.as)
            {
                obj = new aw(aw.b.as, null, null);
            }
        }
        if (obj != null)
        {
            a(((aw) (obj)), i1, s2);
        }
    }

    public void a(ArrayList arraylist)
    {
        c.runOnUiThread(new a(2, null, null, arraylist));
    }

    public void a(JSONObject jsonobject)
    {
        e.f().a(jsonobject);
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            return true;
        } else
        {
            return super.a(i1, keyevent);
        }
    }

    public void b()
    {
        j = true;
        e.g();
    }

    public void b(android.widget.RelativeLayout.LayoutParams layoutparams, com.tremorvideo.sdk.android.richmedia.a.h h1)
    {
        if (h1 != null)
        {
            h1.setVisibility(0);
            boolean flag;
            if (g == h1.getParent())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(layoutparams.width, layoutparams.height);
                layoutparams1.leftMargin = 0;
                layoutparams1.topMargin = 0;
                g.addView(h1, layoutparams1);
                h1.a(layoutparams.leftMargin, layoutparams.topMargin);
            } else
            {
                android.widget.RelativeLayout.LayoutParams layoutparams2 = (android.widget.RelativeLayout.LayoutParams)h1.getLayoutParams();
                if (layoutparams2.width != layoutparams.width || layoutparams2.height != layoutparams.height)
                {
                    layoutparams2.width = layoutparams.width;
                    layoutparams2.height = layoutparams.height;
                    h1.setLayoutParams(layoutparams2);
                }
                h1.a(layoutparams.leftMargin, layoutparams.topMargin);
            }
            g.requestLayout();
        }
    }

    public void b(com.tremorvideo.sdk.android.richmedia.a.h h1)
    {
        if (h1 != null)
        {
            h1.setVisibility(4);
        }
    }

    public void b(aw aw1)
    {
        if (aw1 == null || !aw1.p())
        {
            e.j();
        }
    }

    public void b(String s1)
    {
        aw aw1 = b.a(aw.b.ap);
        if (aw1 != null)
        {
            d.a(aw1);
        }
        try
        {
            i.c(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
    }

    public void b(String s1, List list)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = b.c(s1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        i.a(s1, -1, list);
        i.b(s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void b(ArrayList arraylist)
    {
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.tremorvideo.sdk.android.richmedia.a.h h1 = (com.tremorvideo.sdk.android.richmedia.a.h)iterator.next();
            if (h1 != null)
            {
                if (h1.getParent() == g)
                {
                    g.removeView(h1);
                }
                h1.clearView();
            }
        } while (true);
        arraylist.clear();
    }

    public void c()
    {
        j = false;
        if (!((KeyguardManager)c.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
        {
            e.b(i.f());
        }
    }

    public void c(com.tremorvideo.sdk.android.richmedia.a.h h1)
    {
        i.a(aw.b.au, h1, null, null);
    }

    public void d()
    {
        super.d();
        Iterator iterator = ((ActivityManager)c.getSystemService("activity")).getRunningAppProcesses().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        if (runningappprocessinfo.pid != Process.myPid()) goto _L4; else goto _L3
_L3:
        int i1 = runningappprocessinfo.importance;
        if (i1 != 100) goto _L2; else goto _L5
_L5:
        boolean flag = true;
_L7:
        if (flag)
        {
            c();
        }
        return;
        Exception exception;
        exception;
        com.tremorvideo.sdk.android.videoad.ad.a(exception);
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public o.a g()
    {
        aw aw1 = b.a(aw.b.H);
        if (aw1 == null)
        {
            return com.tremorvideo.sdk.android.videoad.o.a.f;
        }
        int i1 = aw1.a("location", -1);
        if (i1 == -1)
        {
            return com.tremorvideo.sdk.android.videoad.o.a.f;
        } else
        {
            return com.tremorvideo.sdk.android.videoad.o.a.values()[i1];
        }
    }

    public void h()
    {
        e.f().a(null);
    }

    public void i()
    {
        if (n)
        {
            n = false;
            e();
        }
    }

    public boolean m()
    {
        return !i.d();
    }

    public a.b n()
    {
        if (m)
        {
            return com.tremorvideo.sdk.android.videoad.a.b.d;
        } else
        {
            return a.b.b;
        }
    }

    public void o()
    {
        if (b != null)
        {
            b.d();
        }
    }

    public void p()
    {
        c.runOnUiThread(new c(2, null));
    }

    public void q()
    {
        if (h != null)
        {
            h.setVisibility(4);
        }
    }

    public s r()
    {
        return b;
    }

    public int s()
    {
        if (e != null)
        {
            return e.s();
        } else
        {
            return -1;
        }
    }

    public int t()
    {
        byte byte0 = -1;
        if (o == null || o.length <= 0) goto _L2; else goto _L1
_L1:
        l al[];
        int i1;
        int k1;
        al = o;
        k1 = al.length;
        i1 = 0;
_L3:
        Object obj;
        MediaPlayer mediaplayer;
label0:
        {
            int j1 = byte0;
            if (i1 < k1)
            {
                obj = al[i1];
                if (!((l) (obj)).c().equals("video-1"))
                {
                    break MISSING_BLOCK_LABEL_153;
                }
                if (ad.q() < 10)
                {
                    break label0;
                }
                MediaMetadataRetriever mediametadataretriever = new MediaMetadataRetriever();
                mediametadataretriever.setDataSource(((l) (obj)).e());
                obj = mediametadataretriever.extractMetadata(9);
                j1 = byte0;
                if (obj != null)
                {
                    j1 = Integer.parseInt(((String) (obj)));
                }
            }
            return j1;
        }
        mediaplayer = new MediaPlayer();
        mediaplayer.setDataSource(((l) (obj)).e());
        mediaplayer.prepare();
        i1 = mediaplayer.getDuration();
        mediaplayer.release();
        return i1;
        Object obj1;
        obj1;
        com.tremorvideo.sdk.android.videoad.ad.a(((Throwable) (obj1)));
        mediaplayer.release();
        return -1;
        obj1;
        mediaplayer.release();
        throw obj1;
        i1++;
        if (true) goto _L3; else goto _L2
_L2:
        return b.A();
    }
}
