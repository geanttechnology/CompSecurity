// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ae;
import com.google.android.gms.d.cj;
import com.google.android.gms.d.ct;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            m

final class a
    implements com.google.android.gms.d.rnal.request.m._cls2._cls2
{

    final a a;

    public final void a()
    {
        m.c().a(a.a);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/google/android/gms/ads/internal/request/m$2

/* anonymous class */
    final class m._cls2
        implements Runnable
    {

        final JSONObject a;
        final String b;
        final m c;

        public final void run()
        {
            m.a(c, m.d().b());
            com.google.android.gms.ads.internal.request.m.b(c).a(new m._cls2._cls1(), new m._cls2._cls2(this));
        }

            
            {
                c = m1;
                a = jsonobject;
                b = s;
                super();
            }

        // Unreferenced inner class com/google/android/gms/ads/internal/request/m$2$1

/* anonymous class */
        final class m._cls2._cls1
            implements com.google.android.gms.d.hc.c
        {

            final m._cls2 a;

            public final void a(Object obj)
            {
                obj = (ae)obj;
                try
                {
                    ((ae) (obj)).a("AFMA_getAdapterLessMediationAd", a.a);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.google.android.gms.ads.internal.util.client.b.a("Error requesting an ad url", ((Throwable) (obj)));
                }
                m.c().a(a.b);
            }

                    
                    {
                        a = m._cls2.this;
                        super();
                    }
        }

    }

}
