// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdResponse;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.ConfigurationUnion;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapResponseInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            hq, ci, gk, gd, 
//            gh, cg, fz, az, 
//            i, ba, ap, fp

class t> extends hq
{

    final a a;

    public void safeRun()
    {
        ci.g(a.a);
    }

    >(> >)
    {
        a = >;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/ci$4

/* anonymous class */
    class ci._cls4
        implements gk.a
    {

        final ci a;

        public volatile void a(gk gk1, Object obj)
        {
            a(gk1, (byte[])obj);
        }

        public void a(gk gk1, byte abyte0[])
        {
            List list;
            gd.a(3, ci.c(), (new StringBuilder()).append("AdRequest: HTTP status code is:").append(gk1.e()).toString());
            ci.a(a, new ArrayList());
            list = Collections.emptyList();
            if (!gk1.c() || abyte0 == null) goto _L2; else goto _L1
_L1:
            gk1 = null;
            abyte0 = (AdResponse)ci.d(a).d(abyte0);
            gk1 = abyte0;
_L3:
            if (gk1 != null)
            {
                abyte0 = ((AdResponse) (gk1)).configuration;
                if (abyte0 != null)
                {
                    abyte0 = ((ConfigurationUnion) (abyte0)).configuration;
                    if (abyte0 != null)
                    {
                        gd.a(3, ci.c(), "Ad server responded with configuration.");
                        cg cg1 = new cg();
                        cg1.a = abyte0;
                        fz.a().a(cg1);
                    }
                }
                if (((AdResponse) (gk1)).frequencyCapResponseInfoList != null)
                {
                    az az1;
                    for (abyte0 = ((AdResponse) (gk1)).frequencyCapResponseInfoList.iterator(); abyte0.hasNext(); i.a().k().a(az1))
                    {
                        az1 = new az((FrequencyCapResponseInfo)abyte0.next());
                    }

                }
                break MISSING_BLOCK_LABEL_220;
            }
            break; /* Loop/switch isn't completed */
            abyte0;
            gd.a(5, ci.c(), (new StringBuilder()).append("Failed to decode ad response: ").append(abyte0).toString());
            if (true) goto _L3; else goto _L2
            if (((AdResponse) (gk1)).errors.size() > 0)
            {
                gd.b(ci.c(), "Ad server responded with the following error(s):");
                String s;
                for (abyte0 = ((AdResponse) (gk1)).errors.iterator(); abyte0.hasNext(); gd.b(ci.c(), s))
                {
                    s = (String)abyte0.next();
                }

            }
            if (((AdResponse) (gk1)).adUnits != null)
            {
                gk1 = ((AdResponse) (gk1)).adUnits;
            } else
            {
                gk1 = list;
            }
            abyte0 = gk1;
            if (!TextUtils.isEmpty(ci.e(a)))
            {
                abyte0 = gk1;
                if (gk1.size() == 0)
                {
                    gd.b(ci.c(), "Ad server responded but sent no ad units.");
                    abyte0 = gk1;
                }
            }
_L5:
            gk1 = abyte0.iterator();
            do
            {
                if (!gk1.hasNext())
                {
                    break;
                }
                abyte0 = (AdUnit)gk1.next();
                if (((AdUnit) (abyte0)).adFrames.size() != 0)
                {
                    abyte0 = new ap(abyte0);
                    ci.f(a).add(abyte0);
                }
            } while (true);
            ci.a(a, ci.a.e);
            fp.a().b(new ci._cls4._cls1(this));
            return;
_L2:
            abyte0 = list;
            if (true) goto _L5; else goto _L4
_L4:
        }

            
            {
                a = ci1;
                super();
            }
    }

}
