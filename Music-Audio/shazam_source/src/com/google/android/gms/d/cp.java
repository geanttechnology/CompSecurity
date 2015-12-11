// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.common.api.f;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            he

public abstract class cp
    implements f
{

    protected he a;

    public cp(he he)
    {
        a = he;
    }

    public abstract void a();

    protected final void a(String s, String s1)
    {
        a.a.post(new Runnable(s, s1) {

            final String a;
            final String b;
            final cp c;

            public final void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("event", "precacheCanceled");
                hashmap.put("src", a);
                if (b != null)
                {
                    hashmap.put("cachedSrc", b);
                }
                c.a.a("onPrecacheEvent", hashmap);
            }

            
            {
                c = cp.this;
                a = s;
                b = s1;
                super();
            }
        });
    }

    protected final void a(String s, String s1, int i)
    {
        a.a.post(new Runnable(s, s1, i) {

            final String a;
            final String b;
            final int c;
            final cp d;

            public final void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("event", "precacheComplete");
                hashmap.put("src", a);
                hashmap.put("cachedSrc", b);
                hashmap.put("totalBytes", Integer.toString(c));
                d.a.a("onPrecacheEvent", hashmap);
            }

            
            {
                d = cp.this;
                a = s;
                b = s1;
                c = i;
                super();
            }
        });
    }

    public abstract boolean a(String s);

    public final void b()
    {
    }

    // Unreferenced inner class com/google/android/gms/d/cp$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final String a;
        final String b;
        final int c;
        final int d;
        final boolean e = false;
        final cp f;

        public final void run()
        {
            HashMap hashmap = new HashMap();
            hashmap.put("event", "precacheProgress");
            hashmap.put("src", a);
            hashmap.put("cachedSrc", b);
            hashmap.put("bytesLoaded", Integer.toString(c));
            hashmap.put("totalBytes", Integer.toString(d));
            String s;
            if (e)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            hashmap.put("cacheReady", s);
            f.a.a("onPrecacheEvent", hashmap);
        }

            
            {
                f = cp.this;
                a = s;
                b = s1;
                c = i;
                d = j;
                super();
            }
    }

}
