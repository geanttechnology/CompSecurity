// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;

// Referenced classes of package com.flurry.sdk:
//            fz, fp, gd, ai, 
//            aj, fy, fi, fx, 
//            hq, fj

public class k
{

    private static final String a = com/flurry/sdk/k.getSimpleName();
    private final fy b = new fy() {

        final k a;

        public void a(fi fi1)
        {
            if (fi1.a)
            {
                k.a(a);
            }
        }

        public void notify(fx fx)
        {
            a((fi)fx);
        }

            
            {
                a = k.this;
                super();
            }
    };
    private final File c = fp.a().c().getFileStreamPath(".flurryads.mediaassets");
    private final File d = fp.a().c().getFileStreamPath(".flurryads.mediaassets.tmp");
    private String e;
    private int f;
    private ai g;

    public k()
    {
        fz.a().a("com.flurry.android.sdk.NetworkStateEvent", b);
    }

    static ai a(k k1, ai ai1)
    {
        k1.g = ai1;
        return ai1;
    }

    static void a(k k1)
    {
        k1.e();
    }

    static File b(k k1)
    {
        return k1.d;
    }

    static File c(k k1)
    {
        return k1.c;
    }

    static int d(k k1)
    {
        int i = k1.f;
        k1.f = i + 1;
        return i;
    }

    static String d()
    {
        return a;
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(e);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SharedPreferences sharedpreferences;
        sharedpreferences = fp.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        String s = sharedpreferences.getString("flurry_last_media_asset_url", null);
        if (e.equals(s) && a())
        {
            gd.a(3, a, "Media player assets: download not necessary");
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_75;
        Exception exception;
        exception;
        throw exception;
        String s1;
        if (f >= 3)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (new StringBuilder()).append(e).append("android.zip").toString();
_L5:
        if (g != null)
        {
            g.e();
        }
        d.delete();
        gd.a(3, a, (new StringBuilder()).append("Media player assets: attempting download from url: ").append(s1).toString());
        g = new aj(d);
        g.a(s1);
        g.a(30000);
        g.a(new ai.a(sharedpreferences, s1) {

            final SharedPreferences a;
            final String b;
            final k c;

            public void a(ai ai1)
            {
                if (ai1.a() && k.b(c).exists())
                {
                    k.c(c).delete();
                    if (k.b(c).renameTo(k.c(c)))
                    {
                        gd.a(3, k.d(), "Media player assets: download successful");
                        ai1 = a.edit();
                        ai1.putString("flurry_last_media_asset_url", b);
                        ai1.commit();
                    } else
                    {
                        gd.a(3, k.d(), "Media player assets: couldn't rename tmp file (giving up)");
                    }
                } else
                {
                    gd.a(3, k.d(), "Media player assets: download failed");
                    if (fj.a().c())
                    {
                        k.d(c);
                    }
                    fp.a().a(new hq(this) {

                        final _cls3 a;

                        public void safeRun()
                        {
                            k.a(a.c);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    }, 10000L);
                }
                k.a(c, null);
            }

            
            {
                c = k.this;
                a = sharedpreferences;
                b = s;
                super();
            }
        });
        g.d();
        if (true) goto _L1; else goto _L3
_L3:
        s1 = "http://flurry.cachefly.net/vast/videocontrols/v1/android.zip";
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            e = s;
            return;
        }
    }

    public boolean a()
    {
        return c.exists();
    }

    public File b()
    {
        if (a())
        {
            return c;
        } else
        {
            return null;
        }
    }

    public void c()
    {
        f = 0;
        fp.a().b(new hq() {

            final k a;

            public void safeRun()
            {
                k.a(a);
            }

            
            {
                a = k.this;
                super();
            }
        });
    }

}
