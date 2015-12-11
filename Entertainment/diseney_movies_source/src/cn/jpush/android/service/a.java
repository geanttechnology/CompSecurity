// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.data.d;
import cn.jpush.android.util.g;
import cn.jpush.android.util.k;
import cn.jpush.android.util.m;
import cn.jpush.android.util.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package cn.jpush.android.service:
//            b, c, DownloadService

public final class a
{

    public static boolean b;
    private static final String z[];
    public boolean a;
    private b c;
    private long d;
    private long e;
    private Bundle f;

    public a(Context context, d d1, Bundle bundle, c c1, int i)
    {
        i = 0;
        super();
        c = null;
        d = 0L;
        e = 0L;
        a = false;
        x.b();
        a = false;
        f = bundle;
        c = new b(this, context.getMainLooper(), c1);
        c.sendEmptyMessageDelayed(0, 2000L);
_L7:
        if (b) goto _L2; else goto _L1
_L1:
        x.d();
        c.removeCallbacksAndMessages(null);
        a = true;
        c1.a(1);
_L4:
        return;
_L2:
        if (a)
        {
            x.d();
            c.removeCallbacksAndMessages(null);
            c1.a(1);
            return;
        }
        if (d1.P != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        x.e();
        if (c1 != null)
        {
            a = true;
            DownloadService.a.remove(d1);
            c.removeCallbacksAndMessages(null);
            c1.a(2);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i < 3)
        {
            break; /* Loop/switch isn't completed */
        }
        x.e();
        if (c1 != null)
        {
            a = true;
            DownloadService.a.remove(d1);
            c.removeCallbacksAndMessages(null);
            c1.a(2);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        int j;
        j = a(context, c1, d1);
        d1.P = d1.P - 1;
        if (j == -1)
        {
            (new StringBuilder(z[3])).append(d1.P).toString();
            x.c();
            try
            {
                Thread.sleep(3000L);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            continue; /* Loop/switch isn't completed */
        }
        if (j == 0)
        {
            (new StringBuilder(z[2])).append(d1.P).toString();
            x.c();
            try
            {
                Thread.sleep(3000L);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            continue; /* Loop/switch isn't completed */
        }
        if (j == 1)
        {
            x.c();
            c.removeCallbacksAndMessages(null);
            a = true;
            return;
        }
        if (j != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        (new StringBuilder(z[1])).append(d1.P).toString();
        x.c();
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        if (j == -3)
        {
            a = true;
            DownloadService.a.remove(d1);
            c.removeCallbacksAndMessages(null);
            c1.a(3);
            return;
        } else
        {
            x.c();
            a = true;
            DownloadService.a.remove(d1);
            c.removeCallbacksAndMessages(null);
            c1.a(2);
            return;
        }
    }

    private static int a(long l)
    {
        l /= 0xa00000L;
        int i;
        if (l < 1L)
        {
            i = 10;
        } else
        if (l > 5L)
        {
            i = 50;
        } else
        {
            i = (int)(l * 10L);
        }
        return (int)((double)i * 1.1000000000000001D);
    }

    private int a(Context context, c c1, d d1)
    {
        Object obj;
        Object obj1;
        String s;
        String s1;
        s1 = d1.d();
        s = d1.g();
        obj1 = "";
        obj = "";
        if (!d1.a()) goto _L2; else goto _L1
_L1:
        obj1 = k.b(context);
        obj = (new StringBuilder()).append(d1.c).append(z[19]).toString();
_L60:
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(((CharSequence) (obj1))) || TextUtils.isEmpty(((CharSequence) (obj)))) goto _L4; else goto _L3
_L3:
        Object obj2;
        Object obj3;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        File file;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        File file1;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        Object obj22;
        Object obj23;
        Object obj24;
        Object obj25;
        Object obj26;
        Object obj27;
        Object obj28;
        Object obj29;
        Object obj30;
        Object obj31;
        Object obj32;
        Object obj33;
        Object obj34;
        Object obj35;
        Object obj36;
        Object obj37;
        Object obj38;
        Object obj39;
        Object obj40;
        Object obj41;
        Object obj42;
        Object obj43;
        Object obj44;
        Object obj45;
        Object obj46;
        Object obj47;
        Object obj48;
        Object obj49;
        Object obj50;
        Object obj51;
        Object obj52;
        Object obj53;
        Object obj54;
        Object obj55;
        Object obj56;
        Object obj57;
        Object obj58;
        Object obj59;
        long l;
        long l3;
        (new StringBuilder(z[20])).append(s1).append(z[11]).append(((String) (obj1))).append(z[10]).append(((String) (obj))).toString();
        x.d();
        context = new File(((String) (obj1)));
        if (!context.isDirectory())
        {
            context.mkdirs();
        }
        l3 = f.getLong(s1, -1L);
        l = 0L;
        obj44 = null;
        obj45 = null;
        obj46 = null;
        obj47 = null;
        obj48 = null;
        context = null;
        obj43 = null;
        obj38 = null;
        obj39 = null;
        obj40 = null;
        obj41 = null;
        obj5 = null;
        obj31 = null;
        obj32 = null;
        obj33 = null;
        obj34 = null;
        obj35 = null;
        obj36 = null;
        obj49 = null;
        obj37 = null;
        obj59 = null;
        obj42 = null;
        obj23 = null;
        obj24 = null;
        obj25 = null;
        obj26 = null;
        file1 = null;
        obj27 = null;
        obj28 = null;
        obj18 = null;
        obj19 = null;
        obj20 = null;
        obj21 = null;
        obj50 = null;
        obj29 = null;
        obj3 = null;
        obj30 = null;
        obj8 = null;
        obj9 = null;
        obj10 = null;
        obj11 = null;
        obj7 = null;
        obj15 = null;
        obj16 = null;
        file = null;
        obj12 = null;
        obj13 = null;
        obj14 = null;
        obj51 = null;
        obj17 = null;
        obj2 = null;
        obj22 = null;
        obj52 = null;
        obj53 = null;
        obj54 = null;
        obj55 = null;
        obj56 = null;
        obj57 = null;
        obj58 = null;
        obj6 = null;
        if (l3 > 0L) goto _L6; else goto _L5
_L5:
        file = new File(((String) (obj1)), ((String) (obj)));
        if (file.exists() && file.length() > 0L) goto _L8; else goto _L7
_L7:
        x.b();
        context = a(s1, -1L);
        obj = a();
        context = ((DefaultHttpClient) (obj)).execute(context);
        if (context == null) goto _L10; else goto _L9
_L9:
        int i = context.getStatusLine().getStatusCode();
        if (i != 200) goto _L12; else goto _L11
_L11:
        obj = context.getEntity();
        if (!((HttpEntity) (obj)).isStreaming()) goto _L14; else goto _L13
_L13:
        long l1;
        l1 = a(((HttpResponse) (context)));
        f.putLong(s1, l1);
        d1.P = a(l1);
        obj1 = ((HttpEntity) (obj)).getContent();
        if (obj1 == null) goto _L16; else goto _L15
_L15:
        obj6 = obj;
        obj5 = obj59;
        d1 = ((d) (obj1));
        context = new BufferedInputStream(((InputStream) (obj1)));
        file.delete();
        file.createNewFile();
        d1 = new FileOutputStream(file);
        obj2 = new BufferedOutputStream(d1);
        obj3 = new byte[1024];
_L20:
        i = context.read(((byte []) (obj3)));
        if (i == -1) goto _L18; else goto _L17
_L17:
        if (a)
        {
            x.e();
            throw new cn.jpush.android.d(z[14]);
        }
          goto _L19
        c1;
        obj3 = d1;
        d1 = ((d) (obj1));
        c1 = context;
        context = ((Context) (obj3));
_L58:
        x.j();
        a(((InputStream) (d1)), ((BufferedInputStream) (c1)), ((FileOutputStream) (context)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (obj)));
        return -2;
_L2:
        if (d1.b())
        {
            obj1 = k.c(context);
            obj = d1.c;
        } else
        if (d1.f())
        {
            obj1 = k.b(context, d1.c);
            obj = (new StringBuilder()).append(d1.c).append(m.b(d1.d())).toString();
        }
        continue; /* Loop/switch isn't completed */
_L19:
        ((BufferedOutputStream) (obj2)).write(((byte []) (obj3)), 0, i);
        l += i;
        d = l;
        e = l1;
          goto _L20
        c1;
        c1 = d1;
        obj7 = obj2;
_L57:
        obj6 = obj;
        obj2 = obj7;
        obj3 = c1;
        obj5 = context;
        d1 = ((d) (obj1));
        x.j();
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (c1)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj)));
        return -2;
_L18:
        ((BufferedOutputStream) (obj2)).flush();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_841;
        }
        if (file.length() != l1 || !g.a(s, file))
        {
            break MISSING_BLOCK_LABEL_841;
        }
        f.remove(s1);
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_828;
        }
        c1.a(file.getAbsolutePath(), false);
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (d1)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (obj)));
        return 1;
        x.e();
        if (file.delete())
        {
            break MISSING_BLOCK_LABEL_869;
        }
        x.f();
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (d1)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (obj)));
        return -2;
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (d1)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (obj)));
        return 2;
_L16:
        obj6 = obj;
        obj5 = obj59;
        d1 = ((d) (obj1));
        x.e();
        a(((InputStream) (obj1)), null, null, null, ((HttpEntity) (obj)));
        return 0;
_L14:
        x.f();
        a(null, null, null, null, ((HttpEntity) (obj)));
        return -2;
_L12:
        if (i != 404)
        {
            break MISSING_BLOCK_LABEL_967;
        }
        (new StringBuilder(z[21])).append(s1).toString();
        x.c();
        a(null, null, null, null, null);
        return -3;
        (new StringBuilder(z[15])).append(i).toString();
        x.e();
        a(null, null, null, null, null);
        return -2;
_L10:
        x.e();
        a(null, null, null, null, null);
        return 0;
        context;
        obj = null;
        obj1 = null;
        context = obj38;
        c1 = obj23;
        obj7 = obj8;
_L56:
        obj6 = obj;
        obj2 = obj7;
        obj3 = c1;
        obj5 = context;
        d1 = ((d) (obj1));
        x.j();
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (c1)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj)));
        return -2;
        context;
        obj = null;
        obj1 = null;
        context = obj39;
        c1 = obj24;
        obj7 = obj9;
_L54:
        obj6 = obj;
        obj2 = obj7;
        obj3 = c1;
        obj5 = context;
        d1 = ((d) (obj1));
        x.j();
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (c1)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj)));
        return -2;
        context;
        obj = null;
        obj1 = null;
        context = obj40;
        c1 = obj25;
        obj7 = obj10;
_L52:
        obj6 = obj;
        obj2 = obj7;
        obj3 = c1;
        obj5 = context;
        d1 = ((d) (obj1));
        x.h();
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (c1)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj)));
        return -1;
        context;
        obj = null;
        obj1 = null;
        context = obj41;
        c1 = obj26;
        obj7 = obj11;
_L50:
        obj6 = obj;
        obj2 = obj7;
        obj3 = c1;
        obj5 = context;
        d1 = ((d) (obj1));
        x.i();
        a(((InputStream) (obj1)), ((BufferedInputStream) (context)), ((FileOutputStream) (c1)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj)));
        return -2;
        context;
        d1 = null;
        obj3 = file1;
        obj2 = obj7;
        c1 = ((c) (obj6));
_L48:
        a(((InputStream) (d1)), ((BufferedInputStream) (obj5)), ((FileOutputStream) (obj3)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (c1)));
        throw context;
_L8:
        if (file.length() <= 0L)
        {
            break MISSING_BLOCK_LABEL_1400;
        }
        context = a(s1, -1L);
        d1 = a();
        l = a(d1.execute(context));
        if (file.length() != l || !g.a(s, file))
        {
            break MISSING_BLOCK_LABEL_1322;
        }
        x.c();
        if (c1 != null)
        {
            try
            {
                c1.a(file.getAbsolutePath(), true);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                x.j();
                return -2;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                x.h();
                return -1;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                x.i();
                return -2;
            }
        }
        break; /* Loop/switch isn't completed */
        (new StringBuilder(z[18])).append(file.length()).append(z[16]).append(l).toString();
        x.d();
        if (file.delete())
        {
            break MISSING_BLOCK_LABEL_1378;
        }
        x.f();
        return -2;
        return 2;
        x.f();
        return -2;
_L6:
        x.d();
        file1 = new File(((String) (obj1)), ((String) (obj)));
        long l2;
        if (file1.exists())
        {
            x.b();
            l2 = file1.length();
            l = l2;
        } else
        {
            x.b();
            l2 = 0L;
            try
            {
                file1.createNewFile();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                x.j();
                return -2;
            }
        }
        (new StringBuilder(z[17])).append(l2).toString();
        x.d();
        if (d1.P == -1)
        {
            x.c();
            d1.P = a(l3);
        }
        obj = a(s1, l2);
        obj22 = a();
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        obj22 = ((DefaultHttpClient) (obj22)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        if (obj22 == null) goto _L22; else goto _L21
_L21:
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        i = ((HttpResponse) (obj22)).getStatusLine().getStatusCode();
        if (i != 200 && i != 206) goto _L24; else goto _L23
_L23:
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        obj = ((HttpResponse) (obj22)).getEntity();
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        if (!((HttpEntity) (obj)).isStreaming()) goto _L26; else goto _L25
_L25:
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        if (a(((HttpResponse) (obj22))) + l != l3) goto _L28; else goto _L27
_L27:
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        context = ((HttpEntity) (obj)).getContent();
        if (context == null) goto _L30; else goto _L29
_L29:
        d1 = new BufferedInputStream(context);
        obj1 = new FileOutputStream(file1, true);
        obj2 = new BufferedOutputStream(((java.io.OutputStream) (obj1)));
        obj3 = new byte[1024];
_L34:
        i = d1.read(((byte []) (obj3)));
        if (i == -1) goto _L32; else goto _L31
_L31:
        if (a)
        {
            x.e();
            throw new cn.jpush.android.d(z[14]);
        }
          goto _L33
        c1;
        c1 = d1;
        obj6 = obj1;
        obj7 = obj2;
_L46:
        d1 = ((d) (obj));
        obj1 = obj7;
        obj2 = obj6;
        obj3 = context;
        obj5 = c1;
        x.j();
        a(((InputStream) (context)), ((BufferedInputStream) (c1)), ((FileOutputStream) (obj6)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj)));
        return -2;
_L33:
        ((BufferedOutputStream) (obj2)).write(((byte []) (obj3)), 0, i);
        l += i;
        d = l;
        e = l3;
          goto _L34
        c1;
        c1 = d1;
        obj6 = obj1;
        obj7 = obj2;
_L45:
        d1 = ((d) (obj));
        obj1 = obj7;
        obj2 = obj6;
        obj3 = context;
        obj5 = c1;
        x.j();
        a(((InputStream) (context)), ((BufferedInputStream) (c1)), ((FileOutputStream) (obj6)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj)));
        return -2;
_L32:
        ((BufferedOutputStream) (obj2)).flush();
        x.c();
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_2138;
        }
        if (file1.length() != l3 || !g.a(s, file1))
        {
            break MISSING_BLOCK_LABEL_2138;
        }
        f.remove(s1);
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_2125;
        }
        c1.a(file1.getAbsolutePath(), false);
        a(((InputStream) (context)), ((BufferedInputStream) (d1)), ((FileOutputStream) (obj1)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (obj)));
        return 1;
        x.e();
        if (file1.delete())
        {
            break MISSING_BLOCK_LABEL_2166;
        }
        x.f();
        a(((InputStream) (context)), ((BufferedInputStream) (d1)), ((FileOutputStream) (obj1)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (obj)));
        return -2;
        a(((InputStream) (context)), ((BufferedInputStream) (d1)), ((FileOutputStream) (obj1)), ((BufferedOutputStream) (obj2)), ((HttpEntity) (obj)));
        return 2;
_L30:
        x.e();
        a(((InputStream) (context)), null, null, null, ((HttpEntity) (obj)));
        return 0;
_L28:
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        x.f();
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        f.remove(s1);
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        if (file1.delete())
        {
            break MISSING_BLOCK_LABEL_2384;
        }
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        x.f();
        a(null, null, null, null, ((HttpEntity) (obj)));
        return 0;
_L26:
        obj6 = obj;
        obj7 = obj;
        obj8 = obj;
        obj9 = obj;
        d1 = ((d) (obj));
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj;
        obj11 = obj;
        x.f();
        a(null, null, null, null, ((HttpEntity) (obj)));
        return -2;
_L24:
        if (i != 416)
        {
            break MISSING_BLOCK_LABEL_2661;
        }
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        x.f();
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        f.remove(s1);
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        if (file1.delete())
        {
            break MISSING_BLOCK_LABEL_2651;
        }
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        x.f();
        a(null, null, null, null, null);
        return 0;
        if (i != 404)
        {
            break MISSING_BLOCK_LABEL_2789;
        }
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        (new StringBuilder(z[21])).append(s1).toString();
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        x.c();
        a(null, null, null, null, null);
        return -3;
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        (new StringBuilder(z[15])).append(i).toString();
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        x.e();
        a(null, null, null, null, null);
        return -2;
_L22:
        obj6 = obj52;
        obj7 = obj53;
        obj8 = obj54;
        obj9 = obj55;
        d1 = obj56;
        obj1 = obj51;
        obj2 = obj50;
        obj3 = context;
        obj5 = obj49;
        obj10 = obj57;
        obj11 = obj58;
        x.e();
        a(null, null, null, null, null);
        return 0;
        context;
        c1 = obj33;
        context = obj45;
        obj = obj18;
        obj7 = file;
_L44:
        d1 = ((d) (obj6));
        obj1 = obj7;
        obj2 = obj;
        obj3 = context;
        obj5 = c1;
        x.j();
        a(((InputStream) (context)), ((BufferedInputStream) (c1)), ((FileOutputStream) (obj)), ((BufferedOutputStream) (obj7)), ((HttpEntity) (obj6)));
        return -2;
        context;
        c1 = obj34;
        context = obj46;
        obj = obj19;
        obj6 = obj12;
_L42:
        d1 = ((d) (obj7));
        obj1 = obj6;
        obj2 = obj;
        obj3 = context;
        obj5 = c1;
        x.j();
        a(((InputStream) (context)), ((BufferedInputStream) (c1)), ((FileOutputStream) (obj)), ((BufferedOutputStream) (obj6)), ((HttpEntity) (obj7)));
        return -2;
        context;
        c1 = obj35;
        context = obj47;
        obj = obj20;
        obj6 = obj13;
_L40:
        d1 = ((d) (obj8));
        obj1 = obj6;
        obj2 = obj;
        obj3 = context;
        obj5 = c1;
        x.h();
        a(((InputStream) (context)), ((BufferedInputStream) (c1)), ((FileOutputStream) (obj)), ((BufferedOutputStream) (obj6)), ((HttpEntity) (obj8)));
        return -1;
        context;
        c1 = obj36;
        context = obj48;
        obj = obj21;
        obj6 = obj14;
_L38:
        d1 = ((d) (obj9));
        obj1 = obj6;
        obj2 = obj;
        obj3 = context;
        obj5 = c1;
        x.i();
        a(((InputStream) (context)), ((BufferedInputStream) (c1)), ((FileOutputStream) (obj)), ((BufferedOutputStream) (obj6)), ((HttpEntity) (obj9)));
        return -2;
        context;
_L36:
        a(((InputStream) (obj3)), ((BufferedInputStream) (obj5)), ((FileOutputStream) (obj2)), ((BufferedOutputStream) (obj1)), ((HttpEntity) (d1)));
        throw context;
_L4:
        (new StringBuilder(z[22])).append(s1).append(z[13]).append(((String) (obj1))).append(z[12]).append(((String) (obj))).toString();
        x.f();
        return -2;
        c1;
        obj3 = context;
        context = c1;
        d1 = ((d) (obj));
        obj1 = obj17;
        obj2 = obj29;
        obj5 = obj37;
        continue; /* Loop/switch isn't completed */
        c1;
        obj5 = d1;
        obj3 = context;
        context = c1;
        d1 = ((d) (obj));
        obj1 = obj17;
        obj2 = obj29;
        continue; /* Loop/switch isn't completed */
        c1;
        obj2 = obj1;
        obj5 = d1;
        obj3 = context;
        context = c1;
        d1 = ((d) (obj));
        obj1 = obj17;
        continue; /* Loop/switch isn't completed */
        obj3;
        c1 = ((c) (obj1));
        obj5 = d1;
        d1 = ((d) (obj3));
        obj3 = context;
        context = d1;
        d1 = ((d) (obj));
        obj1 = obj2;
        obj2 = c1;
        if (true) goto _L36; else goto _L35
_L35:
        c1;
        obj9 = obj;
        obj6 = obj14;
        obj = obj21;
        c1 = obj36;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj9 = obj;
        obj6 = obj14;
        obj = obj21;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj9 = obj;
        obj6 = obj14;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj9 = obj;
        obj6 = obj2;
        obj = obj1;
        if (true) goto _L38; else goto _L37
_L37:
        c1;
        obj8 = obj;
        obj6 = obj13;
        obj = obj20;
        c1 = obj35;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj8 = obj;
        obj6 = obj13;
        obj = obj20;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj8 = obj;
        obj6 = obj13;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj8 = obj;
        obj6 = obj2;
        obj = obj1;
        if (true) goto _L40; else goto _L39
_L39:
        c1;
        obj7 = obj;
        obj6 = obj12;
        obj = obj19;
        c1 = obj34;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj;
        obj6 = obj12;
        obj = obj19;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj;
        obj6 = obj12;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj;
        obj6 = obj2;
        obj = obj1;
        if (true) goto _L42; else goto _L41
_L41:
        c1;
        obj6 = obj;
        obj7 = file;
        obj = obj18;
        c1 = obj33;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj6 = obj;
        obj7 = file;
        obj = obj18;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj6 = obj;
        obj7 = file;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj6 = obj;
        obj7 = obj2;
        obj = obj1;
        if (true) goto _L44; else goto _L43
_L43:
        context;
        obj = obj10;
        obj7 = obj16;
        obj6 = obj28;
        context = obj44;
        c1 = obj32;
          goto _L45
        c1;
        obj7 = obj16;
        obj6 = obj28;
        c1 = obj32;
          goto _L45
        c1;
        c1 = d1;
        obj7 = obj16;
        obj6 = obj28;
          goto _L45
        c1;
        c1 = d1;
        obj7 = obj16;
        obj6 = obj1;
          goto _L45
        context;
        obj = obj11;
        obj7 = obj15;
        obj6 = obj27;
        context = obj43;
        c1 = obj31;
          goto _L46
        c1;
        obj7 = obj15;
        obj6 = obj27;
        c1 = obj31;
          goto _L46
        c1;
        c1 = d1;
        obj7 = obj15;
        obj6 = obj27;
          goto _L46
        c1;
        c1 = d1;
        obj7 = obj15;
        obj6 = obj1;
          goto _L46
        context;
        c1 = ((c) (obj));
        d1 = null;
        obj2 = obj7;
        obj3 = file1;
        continue; /* Loop/switch isn't completed */
        context;
        c1 = ((c) (obj6));
        continue; /* Loop/switch isn't completed */
        d1;
        c1 = ((c) (obj));
        obj5 = context;
        context = d1;
        obj2 = obj7;
        obj3 = file1;
        d1 = ((d) (obj1));
        continue; /* Loop/switch isn't completed */
        obj2;
        obj5 = context;
        c1 = ((c) (obj));
        context = ((Context) (obj2));
        obj2 = obj7;
        obj3 = d1;
        d1 = ((d) (obj1));
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj5 = context;
        c1 = ((c) (obj));
        context = exception;
        exception = d1;
        d1 = ((d) (obj1));
        continue; /* Loop/switch isn't completed */
        obj1;
        exception = context;
        obj5 = c1;
        c1 = ((c) (obj));
        context = ((Context) (obj1));
        if (true) goto _L48; else goto _L47
_L47:
        break; /* Loop/switch isn't completed */
        context;
        obj1 = null;
        obj7 = obj11;
        c1 = obj26;
        context = obj41;
        continue; /* Loop/switch isn't completed */
        context;
        obj7 = obj11;
        c1 = obj26;
        context = obj41;
        continue; /* Loop/switch isn't completed */
        c1;
        obj7 = obj11;
        c1 = obj26;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj11;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj2;
        if (true) goto _L50; else goto _L49
_L49:
        break; /* Loop/switch isn't completed */
        context;
        obj1 = null;
        obj7 = obj10;
        c1 = obj25;
        context = obj40;
        continue; /* Loop/switch isn't completed */
        context;
        obj7 = obj10;
        c1 = obj25;
        context = obj40;
        continue; /* Loop/switch isn't completed */
        c1;
        obj7 = obj10;
        c1 = obj25;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj10;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj2;
        if (true) goto _L52; else goto _L51
_L51:
        break; /* Loop/switch isn't completed */
        context;
        obj1 = null;
        obj7 = obj9;
        c1 = obj24;
        context = obj39;
        continue; /* Loop/switch isn't completed */
        context;
        obj7 = obj9;
        c1 = obj24;
        context = obj39;
        continue; /* Loop/switch isn't completed */
        c1;
        obj7 = obj9;
        c1 = obj24;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj9;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj2;
        if (true) goto _L54; else goto _L53
_L53:
        break; /* Loop/switch isn't completed */
        context;
        obj1 = null;
        obj7 = obj8;
        c1 = obj23;
        context = obj38;
        continue; /* Loop/switch isn't completed */
        context;
        obj7 = obj8;
        c1 = obj23;
        context = obj38;
        continue; /* Loop/switch isn't completed */
        c1;
        obj7 = obj8;
        c1 = obj23;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj8;
        continue; /* Loop/switch isn't completed */
        c1;
        c1 = d1;
        obj7 = obj2;
        if (true) goto _L56; else goto _L55
        context;
        obj = null;
        obj1 = null;
        obj7 = obj22;
        c1 = obj30;
        context = obj42;
          goto _L57
        context;
        obj1 = null;
        obj7 = obj22;
        c1 = obj30;
        context = obj42;
          goto _L57
        context;
        obj7 = obj22;
        c1 = obj30;
        context = obj42;
          goto _L57
        c1;
        obj7 = obj22;
        c1 = obj30;
          goto _L57
        c1;
        c1 = d1;
        obj7 = obj22;
          goto _L57
        context;
        obj = null;
        obj2 = null;
        context = null;
        c1 = null;
        d1 = null;
          goto _L58
        context;
        obj2 = null;
        context = null;
        c1 = null;
        d1 = null;
          goto _L58
        context;
        obj2 = null;
        context = null;
        c1 = null;
        d1 = ((d) (obj1));
          goto _L58
        c1;
        obj2 = null;
        Object obj4 = null;
        c1 = context;
        d1 = ((d) (obj1));
        context = obj4;
          goto _L58
        c1;
        obj2 = null;
        c1 = context;
        context = d1;
        d1 = ((d) (obj1));
          goto _L58
_L55:
        return 1;
        if (true) goto _L60; else goto _L59
_L59:
    }

    static long a(a a1)
    {
        return a1.d;
    }

    private static long a(HttpResponse httpresponse)
    {
        long l = Long.valueOf(httpresponse.getFirstHeader(z[23]).getValue()).longValue();
        if (l <= 0L)
        {
            throw new cn.jpush.android.d(z[24]);
        } else
        {
            return l;
        }
    }

    private static HttpGet a(String s, long l)
    {
        s = new HttpGet(s);
        s.addHeader(z[9], z[7]);
        s.addHeader(z[5], z[4]);
        if (l >= 0L)
        {
            s.addHeader(z[8], (new StringBuilder(z[6])).append(l).append("-").toString());
        }
        return s;
    }

    private static DefaultHttpClient a()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, z[0]);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 30000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 30000);
        return new DefaultHttpClient(basichttpparams);
    }

    private static void a(InputStream inputstream, BufferedInputStream bufferedinputstream, FileOutputStream fileoutputstream, BufferedOutputStream bufferedoutputstream, HttpEntity httpentity)
    {
        if (bufferedoutputstream != null)
        {
            try
            {
                bufferedoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedOutputStream bufferedoutputstream) { }
        }
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (FileOutputStream fileoutputstream) { }
        }
        if (bufferedinputstream != null)
        {
            try
            {
                bufferedinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedInputStream bufferedinputstream) { }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream) { }
        }
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        httpentity.consumeContent();
        return;
        inputstream;
    }

    public static boolean a(int i)
    {
        return 2 == i || 3 == i;
    }

    static long b(a a1)
    {
        return a1.e;
    }

    static b c(a a1)
    {
        return a1.c;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[25];
        i = 0;
        obj1 = "DZ/TV";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int l;
        int i1;
        int j1;
        byte byte2;
        int k1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        j1 = 0;
        l = 0;
        byte2 = byte0;
        obj1 = ac;
        k1 = i;
        as1 = ((String []) (obj));
        i1 = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        i1 = l;
_L9:
        obj1 = obj;
        j1 = obj1[l];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 823
    //                   1 830
    //                   2 837
    //                   3 844;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_844;
_L3:
        byte0 = 110;
_L13:
label0:
        {
            obj1[l] = (char)(byte0 ^ j1);
            i1++;
            if (j != 0)
            {
                break label0;
            }
            l = j;
        }
        if (true) goto _L9; else goto _L8
        j1 = i1;
        i1 = j;
        as1 = as2;
        k1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = k1;
        as2 = as1;
        j = i1;
        l = j1;
        if (i1 > j1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[k1] = ((String) (obj));
            i = 1;
            obj1 = "|j\\Y\ryk\n\022Nt|\033\026\034=.\035\013\0271o\016\030\007\177.DY";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            i = 2;
            obj1 = "Ua\036\027\002~o\rY\017vo\000\027B1z\033\000Nck\032\rN<.";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            i = 3;
            obj1 = "Ra\007\027\013rzI\r\007|kI\026\033e\"I\r\034h.\033\034\035e.DY";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            i = 4;
            obj1 = "[^\034\n\006<]-2";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            i = 5;
            obj1 = "D}\f\013CPi\f\027\032";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            i = 6;
            obj1 = "sw\035\034\035,";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[k1] = ((String) (obj));
            i = 7;
            obj1 = "Rb\006\n\013";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[k1] = ((String) (obj));
            i = 8;
            obj1 = "Co\007\036\013";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[k1] = ((String) (obj));
            i = 9;
            obj1 = "Ra\007\027\013rz\000\026\0";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[k1] = ((String) (obj));
            i = 10;
            obj1 = "=.\017\020\002t@\b\024\013+";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[k1] = ((String) (obj));
            i = 11;
            obj1 = "=.\032\030\030tH\000\025\013Ao\035\021T";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[k1] = ((String) (obj));
            i = 12;
            obj1 = "1h\000\025\013_o\004\034T";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[k1] = ((String) (obj));
            i = 13;
            obj1 = "1}\b\017\013wg\005\034>pz\001C";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[k1] = ((String) (obj));
            i = 14;
            obj1 = "bz\006\tNua\036\027\002~o\rY\fh.\034\n\013c ";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[k1] = ((String) (obj));
            i = 15;
            obj1 = "\177k\035\016\001ceI\032\001\177`\f\032\0321}\035\030\032d}I\032\001ukI\f\000tv\031\034\rek\rYC1";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[k1] = ((String) (obj));
            i = 16;
            obj1 = "=.\017\020\002tZ\006\r\017}B\f\027\tefS";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[k1] = ((String) (obj));
            i = 17;
            obj1 = "bz\b\013\032Aa\032\r\007~`SY";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[k1] = ((String) (obj));
            i = 18;
            obj1 = "Tv\032\020\0321h\000\025\0131b\f\027\tefS";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[k1] = ((String) (obj));
            i = 19;
            obj1 = "?o\031\022";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[k1] = ((String) (obj));
            i = 20;
            obj1 = "pm\035\020\001\1774\r\026\031\177b\006\030\n1#I\f\034}4";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[k1] = ((String) (obj));
            i = 21;
            obj1 = "Ef\fY\034t}\006\f\034rkI\035\001t}I\027\001e.\f\001\007bzITN";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[k1] = ((String) (obj));
            i = 22;
            obj1 = "Ao\033\030\0031k\033\013\001c.HXNd|\005C";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[k1] = ((String) (obj));
            i = 23;
            obj1 = "Ra\007\r\013\177zD5\013\177i\035\021";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[k1] = ((String) (obj));
            i = 24;
            obj1 = "vk\035Y\032ykI\037\007}kI\r\001eo\005Y\002t`\016\r\0061h\033\026\0031f\035\r\0361g\032Y^?";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[k1] = ((String) (obj));
            z = as;
            b = true;
            return;
        }
          goto _L12
_L8:
        byte0 = 17;
          goto _L13
_L5:
        byte0 = 14;
          goto _L13
_L6:
        byte0 = 105;
          goto _L13
        byte0 = 121;
          goto _L13
    }
}
