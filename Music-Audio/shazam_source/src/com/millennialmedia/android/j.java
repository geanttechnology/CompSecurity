// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            ai, a, VideoAd, aj, 
//            w, al, ao, MMActivity, 
//            av, r

final class j extends ai
    implements a.a
{

    private boolean a;

    j()
    {
    }

    private aj a(Map map)
    {
        Context context = (Context)b.get();
        map = (String)map.get("videoId");
        if (map != null && context != null)
        {
            VideoAd videoad = (VideoAd)com.millennialmedia.android.a.f(context, map);
            if (videoad != null && videoad.c(context) && !videoad.a())
            {
                return aj.a(map);
            }
        }
        return null;
    }

    private aj b(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Context context;
        context = (Context)b.get();
        map = (String)map.get("url");
        if (map == null || context == null) goto _L2; else goto _L1
_L1:
        Object obj = (new w()).a(map);
        if (obj != null) goto _L4; else goto _L3
_L3:
        al.c();
        map = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return map;
_L4:
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        al.b();
        map = null;
          goto _L5
        map;
        al.a("BridgeMMCachedVideo", "HTTP error: ", map);
        map = null;
          goto _L5
        if (((HttpEntity) (obj)).getContentLength() != 0L)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        al.b();
        map = null;
          goto _L5
        Header header = ((HttpEntity) (obj)).getContentType();
        if (header == null) goto _L2; else goto _L6
_L6:
        if (header.getValue() == null) goto _L2; else goto _L7
_L7:
        boolean flag = header.getValue().equalsIgnoreCase("application/json");
        if (!flag) goto _L2; else goto _L8
_L8:
        obj = new VideoAd(w.a(((HttpEntity) (obj)).getContent()));
        if (!((VideoAd) (obj)).b()) goto _L2; else goto _L9
_L9:
        obj.f = 3;
        flag = com.millennialmedia.android.a.a(context, null, ((r) (obj)), this);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        wait();
        if (!a)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        map = aj.a(String.format("Cached video(%s)", new Object[] {
            map
        }));
        notify();
          goto _L5
        map;
        throw map;
        map;
        al.a("BridgeMMCachedVideo", "Millennial ad return failed. Invalid response data.", map);
        map = null;
          goto _L5
        map;
        al.a("BridgeMMCachedVideo", "Millennial ad return failed. Invalid response data.", map);
        map = null;
          goto _L5
        notify();
_L2:
        map = null;
          goto _L5
        map;
        al.a("BridgeMMCachedVideo", "Caching interrupted: ", map);
        notify();
          goto _L2
        map;
        notify();
        throw map;
        map = aj.b(String.format("Unable to start download for Cached video(%s)", new Object[] {
            map
        }));
          goto _L5
    }

    private av c()
    {
        if (c != null && c.get() != null && (((ao)c.get()).g() instanceof MMActivity))
        {
            Object obj = (ao)c.get();
            if (obj != null)
            {
                obj = ((ao) (obj)).g();
                if (obj != null && (obj instanceof MMActivity))
                {
                    obj = (MMActivity)obj;
                    if (((MMActivity) (obj)).a != null && (((MMActivity) (obj)).a instanceof av))
                    {
                        return (av)((MMActivity) (obj)).a;
                    }
                }
            }
        }
        return null;
    }

    final aj a(String s, Map map)
    {
        Object obj = null;
        if (!"availableCachedVideos".equals(s)) goto _L2; else goto _L1
_L1:
        String s1;
        s = (Context)b.get();
        if (s != null)
        {
            map = new JSONArray();
            com.millennialmedia.android.a.a(s, 2, new a.b(s, map) {

                final Context a;
                final JSONArray b;
                final j c;

                final boolean a(r r1)
                {
                    if ((r1 instanceof VideoAd) && r1.c(a) && !r1.a())
                    {
                        b.put(r1.a);
                    }
                    return true;
                }

            
            {
                c = j.this;
                a = context;
                b = jsonarray;
                super();
            }
            });
            s = new aj();
            s.c = 1;
            s.d = map;
        } else
        {
            s = null;
        }
        s1 = s;
_L4:
        return s1;
_L2:
        if ("cacheVideo".equals(s))
        {
            return b(map);
        }
        if (!"endVideo".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = c();
        s1 = obj;
        if (s != null)
        {
            return a(new Callable(s) {

                final av a;
                final j b;

                public final Object call()
                {
                    a.i();
                    return aj.a("Success.");
                }

            
            {
                b = j.this;
                a = av1;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!"pauseVideo".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = c();
        s1 = obj;
        if (s != null)
        {
            return a(new Callable(s) {

                final av a;
                final j b;

                public final Object call()
                {
                    a.k();
                    return aj.a("Success.");
                }

            
            {
                b = j.this;
                a = av1;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (!"playCachedVideo".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        String s2 = (String)map.get("videoId");
        s1 = obj;
        if (s2 != null)
        {
            s1 = obj;
            if (s != null)
            {
                VideoAd videoad = (VideoAd)com.millennialmedia.android.a.f(s, s2);
                s1 = obj;
                if (videoad != null)
                {
                    s1 = obj;
                    if (videoad.a(s, null, false))
                    {
                        videoad.a(s, a((String)map.get("PROPERTY_EXPANDING")));
                        return aj.a(String.format("Playing Video(%s)", new Object[] {
                            s2
                        }));
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (!"playVideo".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = c();
        s1 = obj;
        if (s != null)
        {
            return a(new Callable(s) {

                final av a;
                final j b;

                public final Object call()
                {
                    a.l();
                    return aj.a("Success.");
                }

            
            {
                b = j.this;
                a = av1;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L7
_L7:
        if (!"restartVideo".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = c();
        s1 = obj;
        if (s != null)
        {
            return a(new Callable(s) {

                final av a;
                final j b;

                public final Object call()
                {
                    a.h();
                    return aj.a("Success.");
                }

            
            {
                b = j.this;
                a = av1;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L8
_L8:
        s1 = obj;
        if ("videoIdExists".equals(s))
        {
            return a(map);
        }
        if (true) goto _L4; else goto _L9
_L9:
    }

    public final void a()
    {
    }

    public final void a(r r, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Context context = (Context)b.get();
        if (!flag || context == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        com.millennialmedia.android.a.a(context, r);
        a = flag;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        r;
        this;
        JVM INSTR monitorexit ;
        throw r;
    }
}
