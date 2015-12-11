// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.millennialmedia.android:
//            al, ab, ao, r, 
//            v, ak, ag, a, 
//            an, w, VideoAd, InterstitialAd, 
//            HttpMMHeaders

final class ac
    implements a.a
{
    private final class a
        implements Runnable
    {

        HttpMMHeaders a;
        String b;
        final ac c;

        private static void a(HttpResponse httpresponse)
        {
            httpresponse = httpresponse.getHeaders("Set-Cookie");
            int j = httpresponse.length;
            for (int i = 0; i < j; i++)
            {
                String s = httpresponse[i].getValue();
                int k = s.indexOf("MAC-ID=");
                if (k < 0)
                {
                    continue;
                }
                int l = s.indexOf(';', k);
                if (l > k)
                {
                    an.e = s.substring(k + 7, l);
                }
            }

        }

        private boolean a()
        {
            b = null;
            Object obj;
            Object obj1;
            Object obj2;
            if (c.c != null)
            {
                obj = (ab)c.c.get();
            } else
            {
                obj = null;
            }
            if (obj == null) goto _L2; else goto _L1
_L1:
            try
            {
                obj2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                ((ab) (obj)).a(((Map) (obj2)));
                an.a(((ab) (obj)).j(), ((Map) (obj2)));
                obj = (ab)((ab) (obj)).l.c.get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return a(new ag(((Exception) (obj))));
            }
            if (obj == null) goto _L4; else goto _L3
_L3:
            if (((ab) (obj)).j() == null) goto _L4; else goto _L5
_L5:
            obj = System.getProperty("http.agent");
_L7:
            obj1 = obj;
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj1 = Build.MODEL;
            }
            ((Map) (obj2)).put("ua", obj1);
            obj = new StringBuilder(v.a());
            ((Map) (obj2)).entrySet().toString();
            al.b();
            for (obj1 = ((Map) (obj2)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj)).append(String.format("%s=%s&", new Object[] {
        ((java.util.Map.Entry) (obj2)).getKey(), URLEncoder.encode((String)((java.util.Map.Entry) (obj2)).getValue(), "UTF-8")
    })))
            {
                obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
            }

            ((StringBuilder) (obj)).delete(((StringBuilder) (obj)).length() - 1, ((StringBuilder) (obj)).length());
            b = ((StringBuilder) (obj)).toString();
            String.format("Calling for an advertisement: %s", new Object[] {
                b
            });
            al.b();
            break; /* Loop/switch isn't completed */
_L2:
            b(new ag(25));
            break; /* Loop/switch isn't completed */
_L4:
            obj = null;
            if (true) goto _L7; else goto _L6
_L6:
            return true;
        }

        private boolean a(ag ag1)
        {
            al.a("MMAdImplController", ag1.getMessage());
            return c(ag1);
        }

        private boolean a(HttpEntity httpentity)
        {
            ab ab1;
            if (c.c != null)
            {
                ab1 = (ab)c.c.get();
            } else
            {
                ab1 = null;
            }
            if (ab1 != null)
            {
                if (ab1.q())
                {
                    return a(new ag("Millennial ad return unsupported format.", 15));
                }
                try
                {
                    httpentity = (VideoAd)r.a(w.a(httpentity.getContent()));
                }
                // Misplaced declaration of an exception variable
                catch (HttpEntity httpentity)
                {
                    httpentity.printStackTrace();
                    return b(new ag("Millennial ad return failed. Invalid response data.", httpentity));
                }
                // Misplaced declaration of an exception variable
                catch (HttpEntity httpentity)
                {
                    httpentity.printStackTrace();
                    return b(new ag((new StringBuilder("Millennial ad return failed. ")).append(httpentity).toString(), httpentity));
                }
                if (httpentity != null && httpentity.b())
                {
                    (new StringBuilder("Cached video ad JSON received: ")).append(((r) (httpentity)).a);
                    al.c();
                    if (httpentity.a())
                    {
                        al.c();
                        httpentity.b(ab1.j());
                        an.a.a(ab1, new ag(15));
                    } else
                    if (com.millennialmedia.android.a.c(ab1.j(), ab1.k()) != null)
                    {
                        al.c();
                        httpentity.b(ab1.j());
                        an.a.a(ab1, new ag(17));
                    } else
                    {
                        com.millennialmedia.android.a.a(ab1.j(), httpentity);
                        if (!httpentity.c(ab1.j()))
                        {
                            an.a.a(((VideoAd) (httpentity)).m);
                            al.b();
                            an.a.b(ab1);
                            httpentity.f = 3;
                            com.millennialmedia.android.a.a(ab1.j(), ab1.k(), httpentity, ab1.l);
                        } else
                        {
                            al.b();
                            com.millennialmedia.android.a.a(ab1.j(), ab1.k(), ((r) (httpentity)).a);
                            an.a.b(ab1);
                            an.a.f(ab1);
                        }
                    }
                }
            }
            return true;
        }

        private boolean b(ag ag1)
        {
            ag1.getMessage();
            al.c();
            return c(ag1);
        }

        private boolean b(HttpEntity httpentity)
        {
            ab ab1 = null;
            Object obj;
            HttpMMHeaders httpmmheaders;
            try
            {
                if (c.c != null)
                {
                    ab1 = (ab)c.c.get();
                }
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                return a(new ag((new StringBuilder("Exception raised in HTTP stream: ")).append(httpentity).toString(), httpentity));
            }
            if (ab1 == null)
            {
                break MISSING_BLOCK_LABEL_245;
            }
            if (!ab1.q())
            {
                obj = new InterstitialAd();
                obj.h = w.a(httpentity.getContent());
                obj.a = ab1.f;
                obj.i = b;
                obj.j = a;
                if (an.a >= 5)
                {
                    String.format("Received interstitial ad with url %s.", new Object[] {
                        ((InterstitialAd) (obj)).i
                    });
                    al.a();
                    httpentity = ((InterstitialAd) (obj)).h;
                    al.a();
                }
                com.millennialmedia.android.a.a(ab1.j(), ((r) (obj)));
                com.millennialmedia.android.a.a(ab1.j(), ab1.k(), ((r) (obj)).a);
                an.a.b(ab1);
                an.a.f(ab1);
                break MISSING_BLOCK_LABEL_245;
            }
            if (ab1.l != null)
            {
                obj = ab1.l;
                httpmmheaders = a;
                if (((ac) (obj)).b != null)
                {
                    ((ac) (obj)).b.n = httpmmheaders;
                }
                ab1.l.a(w.a(httpentity.getContent()), b);
            }
            an.a.f(ab1);
            return true;
        }

        private boolean c(ag ag1)
        {
            ab ab1 = null;
            if (c.c != null)
            {
                ab1 = (ab)c.c.get();
            }
            an.a.a(ab1, ag1);
            return false;
        }

        public final void run()
        {
            if (c.c == null) goto _L2; else goto _L1
_L1:
            Object obj = (ab)c.c.get();
            if (obj == null) goto _L4; else goto _L3
_L3:
            if (!an.a(((ab) (obj)).j())) goto _L4; else goto _L5
_L5:
            boolean flag1 = a();
            if (!flag1)
            {
                c.d = null;
                return;
            }
            obj = (new w()).a(b);
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_147;
            }
            a(new ag("HTTP response is null.", 14));
            c.d = null;
            return;
            obj;
            a(new ag((new StringBuilder("Ad request HTTP error. ")).append(((Exception) (obj)).getMessage()).toString(), 14));
            c.d = null;
            return;
            HttpEntity httpentity = ((HttpResponse) (obj)).getEntity();
            if (httpentity != null) goto _L7; else goto _L6
_L6:
            b(new ag("Null HTTP entity", 14));
            boolean flag = false;
_L24:
            if (!flag)
            {
                c.d = null;
                return;
            }
              goto _L2
_L7:
            if (httpentity.getContentLength() != 0L)
            {
                break MISSING_BLOCK_LABEL_226;
            }
            b(new ag("Millennial ad return failed. Zero content length returned.", 14));
            flag = false;
            continue; /* Loop/switch isn't completed */
            Header header;
            a(((HttpResponse) (obj)));
            header = httpentity.getContentType();
            if (header == null) goto _L9; else goto _L8
_L8:
            if (header.getValue() == null) goto _L9; else goto _L10
_L10:
            if (!header.getValue().toLowerCase().startsWith("application/json")) goto _L12; else goto _L11
_L11:
            a(httpentity);
              goto _L13
_L12:
            if (!header.getValue().toLowerCase().startsWith("text/html")) goto _L15; else goto _L14
_L14:
            header = ((HttpResponse) (obj)).getFirstHeader("X-MM-Video");
            a = new HttpMMHeaders(((HttpResponse) (obj)).getAllHeaders());
            if (header == null) goto _L17; else goto _L16
_L16:
            if (!header.getValue().equalsIgnoreCase("true")) goto _L17; else goto _L18
_L18:
            if (c.c == null) goto _L20; else goto _L19
_L19:
            obj = (ab)c.c.get();
_L22:
            if (obj == null) goto _L17; else goto _L21
_L21:
            Context context = ((ab) (obj)).j();
            v.a(context).a(context, ((ab) (obj)).f);
_L17:
            b(httpentity);
            break; /* Loop/switch isn't completed */
            obj;
            b(new ag("Request not filled, can't call for ads.", 14));
            c.d = null;
            return;
_L15:
            b(new ag("Millennial ad return failed. Invalid (JSON/HTML expected) mime type returned.", 15));
            flag = false;
            continue; /* Loop/switch isn't completed */
_L9:
            b(new ag("Millennial ad return failed. HTTP Header value null.", 15));
            flag = false;
            continue; /* Loop/switch isn't completed */
_L4:
            b(new ag("No network available, can't call for ads.", 11));
            c.d = null;
            return;
_L2:
            c.d = null;
            return;
            obj;
            c.d = null;
            throw obj;
_L20:
            obj = null;
            if (true) goto _L22; else goto _L13
_L13:
            flag = true;
            if (true) goto _L24; else goto _L23
_L23:
        }

        private a()
        {
            c = ac.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static final Map e = new ConcurrentHashMap();
    private static final Map f = new ConcurrentHashMap();
    volatile long a;
    volatile ao b;
    volatile WeakReference c;
    a d;

    private ac(ab ab1)
    {
        al.b();
        c = new WeakReference(ab1);
        if (ab1.o != 0L)
        {
            ab ab2 = a(ab1.o);
            if (ab2 != null)
            {
                a = ab1.o;
                ab2.l.a = ab1.h;
                ab2.o = ab1.h;
            }
            b = c(ab1);
        } else
        if (!(ab1 instanceof ah.a))
        {
            if (ab1.q())
            {
                b = new ao(ab1.j().getApplicationContext(), ab1.h);
                b.g = true;
                return;
            } else
            {
                b = new ao(ab1.j(), ab1.h);
                return;
            }
        }
    }

    static int a(ab ab1, r r1)
    {
        if (r1.a())
        {
            String.format("%s is expired.", new Object[] {
                r1.a
            });
            al.b();
            return 21;
        }
        if (!r1.c(ab1.j()))
        {
            String.format("%s is not on disk.", new Object[] {
                r1.a
            });
            al.b();
            return 22;
        }
        if (!v.a(ab1.j()).a(ab1.f, r1.d))
        {
            String.format("%s cannot be shown at this time.", new Object[] {
                r1.a
            });
            al.b();
            return 24;
        } else
        {
            return 100;
        }
    }

    static ab a(long l)
    {
        com/millennialmedia/android/ac;
        JVM INSTR monitorenter ;
        if (l != -4L) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        com/millennialmedia/android/ac;
        JVM INSTR monitorexit ;
        return ((ab) (obj));
_L2:
        ac ac1 = (ac)e.get(Long.valueOf(l));
        obj = ac1;
        if (ac1 != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        WeakReference weakreference = (WeakReference)f.get(Long.valueOf(l));
        obj = ac1;
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj = (ac)weakreference.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = (ab)((ac) (obj)).c.get();
        continue; /* Loop/switch isn't completed */
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void a(ab ab1)
    {
        com/millennialmedia/android/ac;
        JVM INSTR monitorenter ;
        if (ab1.l == null) goto _L2; else goto _L1
_L1:
        if (e.containsValue(ab1.l)) goto _L4; else goto _L3
_L3:
        if (!ab1.r()) goto _L6; else goto _L5
_L5:
        e.put(Long.valueOf(ab1.h), ab1.l);
        if (f.containsKey(Long.valueOf(ab1.h)))
        {
            f.remove(Long.valueOf(ab1.h));
        }
_L4:
        (new StringBuilder()).append(ab1).append(" - Has a controller");
        al.b();
_L8:
        com/millennialmedia/android/ac;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (f.containsKey(Long.valueOf(ab1.h))) goto _L4; else goto _L7
_L7:
        f.put(Long.valueOf(ab1.h), new WeakReference(ab1.l));
          goto _L4
        ab1;
        throw ab1;
_L2:
        ac ac1;
        (new StringBuilder("*****************************************assignAdViewController for ")).append(ab1);
        al.b();
        ac1 = (ac)e.get(Long.valueOf(ab1.h));
        Object obj;
        obj = ac1;
        if (ac1 != null)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        obj = (WeakReference)f.get(Long.valueOf(ab1.h));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        ac1 = (ac)((WeakReference) (obj)).get();
        obj = ac1;
        if (ac1 != null)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        obj = new ac(ab1);
        if (!ab1.r())
        {
            break MISSING_BLOCK_LABEL_314;
        }
        e.put(Long.valueOf(ab1.h), obj);
_L9:
        ab1.l = ((ac) (obj));
        obj.c = new WeakReference(ab1);
        if (((ac) (obj)).b != null && !(ab1 instanceof ah.a))
        {
            f(ab1);
        }
          goto _L8
        f.put(Long.valueOf(ab1.h), new WeakReference(obj));
          goto _L9
    }

    static String b()
    {
        return (new StringBuilder()).append(f.toString()).append(" SAVED:").append(e.toString()).toString();
    }

    static boolean b(ab ab1)
    {
        boolean flag1 = false;
        com/millennialmedia/android/ac;
        JVM INSTR monitorenter ;
        if (ab1 != null) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
_L4:
        com/millennialmedia/android/ac;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        ab ab2;
        (new StringBuilder("attachWebViewFromOverlay with ")).append(ab1);
        al.b();
        if (ab1.l != null && ab1.l.b != null)
        {
            ab1.l.b.d();
        }
        ab2 = a(ab1.o);
        flag = flag1;
        if (ab2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ab2.l == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ab2.l.b != null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        flag = flag1;
        if (ab1.l == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ab1.l.b == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ab2.l.b = ab1.l.b;
        ab1.a(ab1.l.b);
        ab1.l.b = null;
        ab2.l.b.k();
        ab2.l.b.setWebViewClient(ab2.c());
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        ab1;
        throw ab1;
    }

    static ao c(ab ab1)
    {
        Object obj = null;
        com/millennialmedia/android/ac;
        JVM INSTR monitorenter ;
        ab ab2;
        (new StringBuilder("getWebViewFromExistingLayout(")).append(ab1.h).append(" taking from ").append(ab1.o).append(")");
        al.c();
        ab2 = a(ab1.o);
        ab1 = obj;
        if (ab2 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        ab1 = obj;
        if (ab2.l != null)
        {
            ab1 = ab2.l.b;
            ab2.l.b = null;
        }
        com/millennialmedia/android/ac;
        JVM INSTR monitorexit ;
        return ab1;
        ab1;
        throw ab1;
    }

    static void c()
    {
        Iterator iterator = e.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (ac)((java.util.Map.Entry)iterator.next()).getValue();
            if (obj != null)
            {
                obj = (ab)((ac) (obj)).c.get();
                if (obj != null)
                {
                    obj = ((ab) (obj)).d();
                    if (obj != null && (obj instanceof ak))
                    {
                        ((ak)obj).d();
                    }
                }
            }
        } while (true);
    }

    static void d(ab ab1)
    {
        com/millennialmedia/android/ac;
        JVM INSTR monitorenter ;
        ac ac1 = ab1.l;
        if (ac1 != null) goto _L2; else goto _L1
_L1:
        com/millennialmedia/android/ac;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!ab1.r())
        {
            break; /* Loop/switch isn't completed */
        }
        e.put(Long.valueOf(ab1.h), ab1.l);
        if (f.get(Long.valueOf(ab1.h)) != null)
        {
            f.remove(Long.valueOf(ab1.h));
        }
_L4:
        (new StringBuilder("****************RemoveAdviewcontroller - ")).append(ab1);
        al.b();
        if (ab1.i)
        {
            e.remove(Long.valueOf(ab1.h));
            f.remove(Long.valueOf(ab1.h));
        }
        ac ac2 = ab1.l;
        ab1.l = null;
        (new StringBuilder("****************RemoveAdviewcontroller - controllers ")).append(b());
        al.b();
        if (ac2.b != null)
        {
            (new StringBuilder("****************RemoveAdviewcontroller - controller!=null, expanding=")).append(ac2.b.b);
            al.b();
            ab1.a(ac2.b);
            ac2.b.b = false;
            if (ab1.i && ab1.o == 0L)
            {
                ac2.b.loadData("<html></html>", "text/html", "UTF-8");
                ac2.b.d();
                ac2.b = null;
            }
        }
        if (true) goto _L1; else goto _L3
        ab1;
        throw ab1;
_L3:
        f.put(Long.valueOf(ab1.h), new WeakReference(ab1.l));
          goto _L4
    }

    private static void f(ab ab1)
    {
        com/millennialmedia/android/ac;
        JVM INSTR monitorenter ;
        ac ac1 = ab1.l;
        if (ac1.b == null) goto _L2; else goto _L1
_L1:
        ac1.b.setWebViewClient(ab1.c());
        if (ac1.b.a(ab1.h)) goto _L2; else goto _L3
_L3:
        if (!ab1.q()) goto _L5; else goto _L4
_L4:
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams = layoutparams1;
        if (!ac1.b.q())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        ac1.b.a(ab1);
        layoutparams = layoutparams1;
_L7:
        ac1.b.p();
        ab1.a(ac1.b, layoutparams);
_L2:
        com/millennialmedia/android/ac;
        JVM INSTR monitorexit ;
        return;
_L5:
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
        if (true) goto _L7; else goto _L6
_L6:
        ab1;
        throw ab1;
    }

    public final void a()
    {
    }

    public final void a(r r1, boolean flag)
    {
        ab ab1 = (ab)c.get();
        if (ab1 == null)
        {
            al.a("MMAdImplController", ag.a(25));
            return;
        }
        if (flag)
        {
            com.millennialmedia.android.a.a(ab1.j(), ab1.k(), r1.a);
        }
        if (flag)
        {
            an.a.f(ab1);
            return;
        } else
        {
            an.a.a(ab1, new ag(15));
            return;
        }
    }

    final void a(String s, String s1)
    {
        if (b != null)
        {
            b.a(s, s1, (ab)c.get());
        }
    }

    final boolean e(ab ab1)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Context context = ab1.j();
        if (!v.a(context).b(ab1.f)) goto _L2; else goto _L1
_L1:
        al.c();
        an.a.a(ab1, new ag(12));
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        r r1;
        al.b();
        r1 = com.millennialmedia.android.a.e(context, ab1.k());
        if (r1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        al.c();
        an.a.b(ab1);
        com.millennialmedia.android.a.a(context, ab1.k(), r1, this);
        continue; /* Loop/switch isn't completed */
        ab1;
        throw ab1;
        al.c();
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String toString()
    {
        ab ab1 = (ab)c.get();
        StringBuilder stringbuilder = new StringBuilder();
        if (ab1 != null)
        {
            stringbuilder.append((new StringBuilder()).append(ab1).append("-LinkInC=").append(a).toString());
        }
        return (new StringBuilder()).append(stringbuilder.toString()).append(" w/").append(b).toString();
    }

}
