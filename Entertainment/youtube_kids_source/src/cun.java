// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.media.RemoteControlClient;
import android.net.Uri;
import android.os.Handler;
import com.google.android.libraries.youtube.player.notification.ExternalPlaybackControllerV14;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class cun
{

    public final bkn a;
    public final List b;
    public final cus c;
    public String d;
    private final Handler e;
    private final bzg f;
    private final blu g;
    private final qs h;
    private final crt i;
    private final cur j;
    private bhx k;
    private bhx l;
    private boolean m;
    private cuq n;

    public cun(Context context, Handler handler, bzg bzg1, blu blu1, qs qs1, crt crt1, bkn bkn1, 
            String s, Class class1, cur cur1, int i1, cuj cuj, cuk cuk)
    {
        this(context, handler, bzg1, blu1, qs1, crt1, bkn1, s, class1, cur1, i1, cuj, cuk, (byte)0);
    }

    public cun(Context context, Handler handler, bzg bzg1, blu blu1, qs qs1, crt crt1, bkn bkn1, 
            String s, Class class1, cur cur1, int i1, cuj cuj, cuk cuk, byte byte0)
    {
        b.a(context);
        b.a(cuk);
        e = (Handler)b.a(handler);
        f = (bzg)b.a(bzg1);
        g = (blu)b.a(blu1);
        h = (qs)b.a(qs1);
        i = (crt)b.a(crt1);
        a = bkn1;
        j = (cur)b.a(cur1);
        c = new cus();
        new Handler();
        b = new LinkedList();
        b.add(new cul(context, s, class1, cur1, cuk, i1));
        n = new ExternalPlaybackControllerV14(context, cur1, cuj);
        b.add(n);
    }

    public static void a(cun cun1, ced ced1)
    {
        b.a(ced1);
        Uri uri;
        if (ced1.e != null)
        {
            uri = ced1.e;
        } else
        {
            uri = ced1.d;
        }
        cun1.a(ced1.b, ced1.f, ced1.g * 1000, uri);
    }

    public final void a()
    {
        m = true;
        c();
    }

    public final void a(android.media.RemoteControlClient.OnGetPlaybackPositionListener ongetplaybackpositionlistener)
    {
        if (n != null && (n instanceof ExternalPlaybackControllerV14))
        {
            ExternalPlaybackControllerV14 externalplaybackcontrollerv14 = (ExternalPlaybackControllerV14)n;
            externalplaybackcontrollerv14.d = ongetplaybackpositionlistener;
            externalplaybackcontrollerv14.c.setOnGetPlaybackPositionListener(ongetplaybackpositionlistener);
        }
    }

    public final void a(cut cut)
    {
        c.b = cut;
        c();
    }

    public final void a(String s)
    {
label0:
        {
            b.a(s);
            if (!s.equals(d))
            {
                d = s;
                d();
                if (!a.a())
                {
                    break label0;
                }
                k = bhx.a(new cuo(this));
                f.a(s, bhy.a(e, k));
            }
            return;
        }
        b(s);
    }

    public void a(String s, String s1, long l1, Uri uri)
    {
        c.a = s1;
        s = c;
        c.f = l1;
        c();
        j.a();
        l = bhx.a(new cup(this));
        if (uri != null)
        {
            g.a(uri, bhy.a(e, l));
        }
    }

    public final void a(boolean flag)
    {
label0:
        {
            if (n != null)
            {
                if (!flag)
                {
                    break label0;
                }
                if (!b.contains(n))
                {
                    b.add(n);
                }
            }
            return;
        }
        b.remove(n);
    }

    public final void a(boolean flag, boolean flag1)
    {
        c.c = flag;
        c.d = flag1;
        c();
    }

    public final void b()
    {
        m = false;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((cuq)iterator.next()).a()) { }
    }

    public void b(String s)
    {
        if (!h.a())
        {
            return;
        } else
        {
            s = i;
            h.b();
            s.a();
            return;
        }
    }

    public final void b(boolean flag)
    {
        c.g = flag;
        c();
    }

    void c()
    {
        if (m)
        {
            boolean flag;
            if (c.a != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                for (Iterator iterator = b.iterator(); iterator.hasNext(); ((cuq)iterator.next()).a(c)) { }
            }
        }
    }

    public void d()
    {
        c.a();
        if (l != null)
        {
            l.a = true;
        }
        if (k != null)
        {
            k.a = true;
        }
    }
}
