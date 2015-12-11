// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.a.e;
import com.facebook.b.t;
import com.facebook.b.u;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            k, a, GraphRequest, q, 
//            o, r, AccessToken, p

final class b
{
    private static final class a
    {

        public String a;
        public int b;

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static volatile b d;
    final com.facebook.a a;
    AccessToken b;
    Date c;
    private final e e;
    private AtomicBoolean f;

    private b(e e1, com.facebook.a a1)
    {
        f = new AtomicBoolean(false);
        c = new Date(0L);
        u.a(e1, "localBroadcastManager");
        u.a(a1, "accessTokenCache");
        e = e1;
        a = a1;
    }

    static b a()
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        com/facebook/b;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new b(android.support.v4.a.e.a(k.g()), new com.facebook.a());
        }
        com/facebook/b;
        JVM INSTR monitorexit ;
_L2:
        return d;
        Exception exception;
        exception;
        com/facebook/b;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(b b1)
    {
        b1.c();
    }

    static AtomicBoolean b(b b1)
    {
        return b1.f;
    }

    private void c()
    {
        Object obj;
        for (obj = b; obj == null || !f.compareAndSet(false, true);)
        {
            return;
        }

        u.a();
        c = new Date();
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        AtomicBoolean atomicboolean = new AtomicBoolean(false);
        a a1 = new a((byte)0);
        Object obj1 = new GraphRequest.b(atomicboolean, hashset, hashset1) {

            final AtomicBoolean a;
            final Set b;
            final Set c;
            final b d;

            public final void a(p p1)
            {
                p1 = p1.a;
                if (p1 != null)
                {
                    if ((p1 = p1.optJSONArray("data")) != null)
                    {
                        a.set(true);
                        int i = 0;
                        while (i < p1.length()) 
                        {
                            Object obj2 = p1.optJSONObject(i);
                            if (obj2 != null)
                            {
                                String s = ((JSONObject) (obj2)).optString("permission");
                                obj2 = ((JSONObject) (obj2)).optString("status");
                                if (!t.a(s) && !t.a(((String) (obj2))))
                                {
                                    obj2 = ((String) (obj2)).toLowerCase(Locale.US);
                                    if (((String) (obj2)).equals("granted"))
                                    {
                                        b.add(s);
                                    } else
                                    if (((String) (obj2)).equals("declined"))
                                    {
                                        c.add(s);
                                    }
                                }
                            }
                            i++;
                        }
                    }
                }
            }

            
            {
                d = b.this;
                a = atomicboolean;
                b = set;
                c = set1;
                super();
            }
        };
        obj1 = new GraphRequest(((AccessToken) (obj)), "me/permissions", new Bundle(), q.a, ((GraphRequest.b) (obj1)));
        GraphRequest.b b1 = new GraphRequest.b(a1) {

            final a a;
            final b b;

            public final void a(p p1)
            {
                p1 = p1.a;
                if (p1 == null)
                {
                    return;
                } else
                {
                    a.a = p1.optString("access_token");
                    a.b = p1.optInt("expires_at");
                    return;
                }
            }

            
            {
                b = b.this;
                a = a1;
                super();
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        obj1 = new o(new GraphRequest[] {
            obj1, new GraphRequest(((AccessToken) (obj)), "oauth/access_token", bundle, q.a, b1)
        });
        obj = new o.a(((AccessToken) (obj)), atomicboolean, a1, hashset, hashset1) {

            final AccessToken a;
            final AtomicBoolean b;
            final a c;
            final Set d;
            final Set e;
            final b f;

            public final void a()
            {
                if (b.a().b == null || b.a().b.h != a.h)
                {
                    return;
                }
                int i;
                if (b.get() || c.a != null)
                {
                    break MISSING_BLOCK_LABEL_75;
                }
                i = c.b;
                if (i == 0)
                {
                    b.b(f).set(false);
                    return;
                }
                if (c.a == null) goto _L2; else goto _L1
_L1:
                Object obj2 = c.a;
_L9:
                String s;
                String s1;
                s = a.g;
                s1 = a.h;
                if (!b.get()) goto _L4; else goto _L3
_L3:
                Set set = d;
_L10:
                if (!b.get()) goto _L6; else goto _L5
_L5:
                Set set1 = e;
_L11:
                c c1 = a.e;
                if (c.b == 0) goto _L8; else goto _L7
_L7:
                Date date = new Date((long)c.b * 1000L);
_L12:
                obj2 = new AccessToken(((String) (obj2)), s, s1, set, set1, c1, date, new Date());
                b.a().a(((AccessToken) (obj2)), true);
                b.b(f).set(false);
                return;
_L2:
                obj2 = a.d;
                  goto _L9
_L4:
                set = a.b;
                  goto _L10
_L6:
                set1 = a.c;
                  goto _L11
_L8:
                date = a.a;
                  goto _L12
                Exception exception;
                exception;
                b.b(f).set(false);
                throw exception;
                  goto _L9
            }

            
            {
                f = b.this;
                a = accesstoken;
                b = atomicboolean;
                c = a1;
                d = set;
                e = set1;
                super();
            }
        };
        if (!((o) (obj1)).e.contains(obj))
        {
            ((o) (obj1)).e.add(obj);
        }
        GraphRequest.b(((o) (obj1)));
    }

    final void a(AccessToken accesstoken, boolean flag)
    {
        AccessToken accesstoken1 = b;
        b = accesstoken;
        f.set(false);
        c = new Date(0L);
        if (flag)
        {
            if (accesstoken != null)
            {
                a.a(accesstoken);
            } else
            {
                com.facebook.a a1 = a;
                a1.a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
                if (k.d())
                {
                    a1.b().b();
                }
                t.b(k.g());
            }
        }
        if (!t.a(accesstoken1, accesstoken))
        {
            Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accesstoken1);
            intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accesstoken);
            e.a(intent);
        }
    }

    final void b()
    {
        if (Looper.getMainLooper().equals(Looper.myLooper()))
        {
            c();
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final b a;

                public final void run()
                {
                    b.a(a);
                }

            
            {
                a = b.this;
                super();
            }
            });
            return;
        }
    }
}
