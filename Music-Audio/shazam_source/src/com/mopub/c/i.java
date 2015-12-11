// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.v4.f.e;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.f;
import com.mopub.common.m;
import com.mopub.d.a.a;
import com.mopub.d.a.c;
import com.mopub.d.a.g;
import java.io.File;

// Referenced classes of package com.mopub.c:
//            j, d, l, h, 
//            f

public class i
{

    public static boolean a = false;
    private static final String b = System.getProperty("http.agent");
    private static volatile h c;
    private static volatile String d;
    private static volatile com.mopub.c.f e;

    public i()
    {
    }

    public static h a()
    {
        return c;
    }

    public static h a(Context context)
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        com/mopub/c/i;
        JVM INSTR monitorenter ;
        h h1 = c;
        obj = h1;
        if (h1 != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj = new j(f.a(context).c(), context);
        d d1 = com.mopub.c.d.a();
        obj = new a(new l(c(context.getApplicationContext()), ((com.mopub.d.a.f.a) (obj)), d1));
        context = new File((new StringBuilder()).append(context.getCacheDir().getPath()).append(File.separator).append("mopub-volley-cache").toString());
        obj = new h(new c(context, (int)com.mopub.common.d.c.a(context)), ((com.mopub.d.f) (obj)));
        c = ((h) (obj));
        ((h) (obj)).a();
        com/mopub/c/i;
        JVM INSTR monitorexit ;
        return ((h) (obj));
        context;
        com/mopub/c/i;
        JVM INSTR monitorexit ;
        throw context;
        return ((h) (obj));
    }

    public static g b(Context context)
    {
        com.mopub.c.f f1;
        f1 = e;
        if (f1 != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        com/mopub/c/i;
        JVM INSTR monitorenter ;
        com.mopub.c.f f2 = e;
        f1 = f2;
        if (f2 != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        f1 = new com.mopub.c.f(a(context), context, new com.mopub.d.a.g.b(new e(com.mopub.common.d.c.b(context)) {

            protected final int sizeOf(Object obj, Object obj1)
            {
                obj = (String)obj;
                obj1 = (Bitmap)obj1;
                if (obj1 != null)
                {
                    return ((Bitmap) (obj1)).getRowBytes() * ((Bitmap) (obj1)).getHeight();
                } else
                {
                    return super.sizeOf(obj, obj1);
                }
            }

        }) {

            final e a;

            public final Bitmap a(String s)
            {
                return (Bitmap)a.get(s);
            }

            public final void a(String s, Bitmap bitmap)
            {
                a.put(s, bitmap);
            }

            
            {
                a = e1;
                super();
            }
        });
        e = f1;
        com/mopub/c/i;
        JVM INSTR monitorexit ;
        return f1;
        context;
        com/mopub/c/i;
        JVM INSTR monitorexit ;
        throw context;
        return f1;
    }

    public static String b()
    {
        String s1 = d;
        String s = s1;
        if (s1 == null)
        {
            s = b;
        }
        return s;
    }

    private static String c(Context context)
    {
        Object obj;
        m.a(context);
        obj = d;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        com/mopub/c/i;
        JVM INSTR monitorenter ;
        String s = d;
        obj = s;
        if (s != null) goto _L2; else goto _L1
_L1:
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        context = (new WebView(context)).getSettings().getUserAgentString();
_L3:
        d = context;
        obj = context;
_L2:
        com/mopub/c/i;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        context = b;
          goto _L3
        context;
        com/mopub/c/i;
        JVM INSTR monitorexit ;
        throw context;
        return ((String) (obj));
    }

    public static boolean c()
    {
        return a;
    }

}
