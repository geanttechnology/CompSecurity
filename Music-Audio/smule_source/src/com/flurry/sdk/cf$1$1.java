// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.widget.Toast;
import com.flurry.android.impl.ads.protocol.v13.SdkLogResponse;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            fp, cf, gk, gh, 
//            gd

class >
    implements Runnable
{

    final how a;

    public void run()
    {
        Toast.makeText(fp.a().c(), "Ad log report sent", 0).show();
    }

    >(> >)
    {
        a = >;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/cf$1

/* anonymous class */
    class cf._cls1
        implements gk.a
    {

        final String a;
        final String b;
        final cf c;

        public volatile void a(gk gk1, Object obj)
        {
            a(gk1, (byte[])obj);
        }

        public void a(gk gk1, byte abyte0[])
        {
            int i = gk1.e();
            if (!gk1.c() || abyte0 == null) goto _L2; else goto _L1
_L1:
            gk1 = (SdkLogResponse)cf.a(c).d(abyte0);
_L4:
            if (gk1 != null && ((SdkLogResponse) (gk1)).result.equals("success"))
            {
                gd.a(5, cf.b(c), (new StringBuilder()).append("FlurryAdLogsManager: ad report ").append(a).append(" sent. HTTP response: ").append(i).toString());
                if (gd.c() <= 3 && gd.d())
                {
                    fp.a().a(new cf._cls1._cls1(this));
                }
                cf.a(c, a, b, i);
                cf.c(c);
                return;
            }
            break; /* Loop/switch isn't completed */
            gk1;
            gd.a(5, cf.a(), (new StringBuilder()).append("Failed to decode sdk log response: ").append(gk1).toString());
_L2:
            gk1 = null;
            if (true) goto _L4; else goto _L3
_L3:
            if (gk1 != null)
            {
                for (gk1 = ((SdkLogResponse) (gk1)).errors.iterator(); gk1.hasNext(); gd.a(6, cf.d(c), abyte0))
                {
                    abyte0 = (String)gk1.next();
                }

            }
            cf.a(c, a, b);
            return;
        }

            
            {
                c = cf1;
                a = s;
                b = s1;
                super();
            }
    }

}
