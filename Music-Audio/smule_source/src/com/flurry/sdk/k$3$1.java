// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.SharedPreferences;
import java.io.File;

// Referenced classes of package com.flurry.sdk:
//            hq, k, ai, gd, 
//            fj, fp

class it> extends hq
{

    final a a;

    public void safeRun()
    {
        k.a(a.a);
    }

    t>(t> t>)
    {
        a = t>;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/k$3

/* anonymous class */
    class k._cls3
        implements ai.a
    {

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
                fp.a().a(new k._cls3._cls1(this), 10000L);
            }
            k.a(c, null);
        }

            
            {
                c = k1;
                a = sharedpreferences;
                b = s;
                super();
            }
    }

}
