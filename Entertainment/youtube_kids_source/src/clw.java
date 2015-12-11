// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class clw
    implements art
{

    private static final String a = clw.getSimpleName();
    private final asq b;
    private final String c;
    private final clv d;
    private final boolean e;
    private final cmh f;
    private InputStream g;
    private cio h;
    private s i;

    public clw(String s, atj atj, asq asq1, clv clv1, cmh cmh1, boolean flag, Context context)
    {
        h = null;
        i = null;
        c = a.c(s);
        b.a(atj);
        b = (asq)b.a(asq1);
        d = (clv)b.a(clv1);
        f = (cmh)b.a(cmh1);
        e = flag;
        s = (ConnectivityManager)context.getSystemService("connectivity");
        ciy.a().a = s;
    }

    public final int a(byte abyte0[], int j, int k)
    {
        if (g == null)
        {
            cio cio1 = h;
            if (!cio1.k && cio1.d.a.f)
            {
                cio1.m = new Thread(cio1.g);
                cio1.m.start();
                cio1.k = true;
            }
            if (!cio1.l && cio1.d.a.g != 1)
            {
                cio1.n = new Thread(cio1.h);
                cio1.n.start();
                cio1.l = true;
            }
            g = cio1.e;
        }
        j = g.read(abyte0, j, k);
        if (j > 0 && b != null)
        {
            b.a(j);
        }
        return j;
    }

    public final long a(arx arx1)
    {
        byte byte0 = 3;
        int j = 1;
        Object obj = a;
        Object obj2 = f;
        Object obj1 = arx1.a.toString();
        obj = new cmi();
        boolean flag;
        if (!((cmh) (obj2)).c.getNetworkInfo(1).isConnected())
        {
            obj.a = new URL(((String) (obj1)));
            obj.b = null;
            obj.c = ciz.a;
            obj.d = ciz.c;
            obj.e = 0;
            obj.f = 0;
        } else
        {
            int k = ((cmh) (obj2)).b.a();
            if (k <= 0)
            {
                obj2 = cmh.a;
            } else
            if (k > 50000)
            {
                obj2 = cmh.a;
            } else
            {
                String s = cmh.a;
                j = 0;
            }
            if (j != 0)
            {
                obj2 = new URL(((String) (obj1)));
                obj.a = new URL(((String) (obj1)));
                obj.b = new URL(((URL) (obj2)).getProtocol(), "redirector.googlevideo.com", ((URL) (obj2)).getPort(), ((URL) (obj2)).getFile());
                obj.c = ciz.b;
                obj.d = ciz.a;
                obj.e = 3;
                obj.f = 50000;
            } else
            {
                obj1 = new URL(((String) (obj1)));
                obj.a = new URL(((URL) (obj1)).getProtocol(), "redirector.googlevideo.com", ((URL) (obj1)).getPort(), ((URL) (obj1)).getFile());
                obj.b = new URL(((URL) (obj1)).getProtocol(), "redirector-alt.googlevideo.com", ((URL) (obj1)).getPort(), ((URL) (obj1)).getFile());
                obj.c = ciz.a;
                obj.d = ciz.b;
                obj.e = 0;
                obj.f = 0;
            }
        }
        obj1 = new cmj();
        if (e)
        {
            j = byte0;
        } else
        {
            j = 2;
        }
        obj1.b = j;
        obj2 = new ciq();
        flag = ((cmj) (obj1)).a;
        ((ciq) (obj2)).a.f = flag;
        j = ((cmj) (obj1)).b;
        ((ciq) (obj2)).a.g = j;
        ((ciq) (obj2)).a.h = 0;
        ((ciq) (obj2)).a.i = 0;
        obj1 = ((ciq) (obj2)).a(((cmi) (obj)).e, ((cmi) (obj)).f).a();
        h = new cio(((cmi) (obj)).a, ((cmi) (obj)).c, ((cmi) (obj)).b, ((cmi) (obj)).d, ((cip) (obj1)));
        h.i = c;
        if (arx1.e == -1L)
        {
            throw new IOException("Unimplemented.");
        } else
        {
            h.j = new cix(arx1.d, (arx1.d + arx1.e) - 1L);
            h = h;
            b.b();
            return arx1.e;
        }
    }

    public final void a()
    {
        boolean flag2 = true;
        String s = a;
        Exception exception;
        InterruptedException interruptedexception;
        String s1;
        boolean flag;
        boolean flag1;
        if (h != null)
        {
            Object obj1 = h.b;
            Object obj = h.c;
            String s2;
            long l;
            long l1;
            boolean flag3;
            if (obj1 == ciz.b || obj == ciz.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (obj1 == ciz.b && h.f.a() || obj == ciz.b)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (h.f.b.a <= 0L)
            {
                flag2 = false;
            }
            s2 = a;
            obj1 = String.valueOf(obj1);
            obj = String.valueOf(obj);
            l = h.f.a.a;
            l1 = h.f.b.a;
            (new StringBuilder(String.valueOf(obj1).length() + 213 + String.valueOf(obj).length())).append("BothendsInfo: wifiExists=").append(flag).append("; wifiWeak=").append(flag1).append("; bothNetworksActivated=").append(flag2).append("; primaryNetworkType=").append(((String) (obj1))).append("; secondaryNetworkType=").append(((String) (obj))).append("; primaryTransferredBytes=").append(l).append("; secondaryTransferredBytes=").append(l1);
        } else
        {
            flag2 = false;
            flag1 = false;
            flag = false;
        }
        if (g != null)
        {
            try
            {
                g.close();
            }
            catch (IOException ioexception)
            {
                Log.e(a, "Got an IOException when closing the inputStream.");
            }
            g = null;
        }
        if (h == null) goto _L2; else goto _L1
_L1:
        obj = h;
        ((cio) (obj)).a();
        ((cio) (obj)).b();
        flag3 = ((cio) (obj)).k;
        if (!flag3) goto _L4; else goto _L3
_L3:
        ((cio) (obj)).m.join();
_L7:
        obj.k = false;
_L4:
        flag3 = ((cio) (obj)).l;
        if (!flag3) goto _L6; else goto _L5
_L5:
        ((cio) (obj)).n.join();
_L8:
        obj.l = false;
_L6:
        f.a(h);
_L9:
        h = null;
_L2:
        b.c();
        d.a(flag, flag1, flag2);
        return;
        interruptedexception;
        s1 = cio.a;
          goto _L7
        s1;
        Log.e(cio.a, "workerSecondary.join() got an interrupted exception.");
          goto _L8
        exception;
        Log.e(a, "Got an Exception when closing the connection.");
          goto _L9
    }

}
