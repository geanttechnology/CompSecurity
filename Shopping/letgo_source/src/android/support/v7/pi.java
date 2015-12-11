// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.api.f;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            ul

public abstract class pi
    implements f
{

    protected ul a;

    public pi(ul ul)
    {
        a = ul;
    }

    public abstract void a();

    protected void a(String s, String s1)
    {
        zza.zzIy.post(new Runnable(s, s1) {

            final String a;
            final String b;
            final pi c;

            public void run()
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
                c = pi.this;
                a = s;
                b = s1;
                super();
            }
        });
    }

    protected void a(String s, String s1, int i)
    {
        zza.zzIy.post(new Runnable(s, s1, i) {

            final String a;
            final String b;
            final int c;
            final pi d;

            public void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("event", "precacheComplete");
                hashmap.put("src", a);
                hashmap.put("cachedSrc", b);
                hashmap.put("totalBytes", Integer.toString(c));
                d.a.a("onPrecacheEvent", hashmap);
            }

            
            {
                d = pi.this;
                a = s;
                b = s1;
                c = i;
                super();
            }
        });
    }

    protected void a(String s, String s1, int i, int j, boolean flag)
    {
        zza.zzIy.post(new Runnable(s, s1, i, j, flag) {

            final String a;
            final String b;
            final int c;
            final int d;
            final boolean e;
            final pi f;

            public void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("event", "precacheProgress");
                hashmap.put("src", a);
                hashmap.put("cachedSrc", b);
                hashmap.put("bytesLoaded", Integer.toString(c));
                hashmap.put("totalBytes", Integer.toString(d));
                String s2;
                if (e)
                {
                    s2 = "1";
                } else
                {
                    s2 = "0";
                }
                hashmap.put("cacheReady", s2);
                f.a.a("onPrecacheEvent", hashmap);
            }

            
            {
                f = pi.this;
                a = s;
                b = s1;
                c = i;
                d = j;
                e = flag;
                super();
            }
        });
    }

    public abstract boolean a(String s);

    protected String b(String s)
    {
        return zzk.zzcE().zzaB(s);
    }

    public void b()
    {
    }
}
