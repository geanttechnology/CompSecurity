// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.preference.Preference;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;

// Referenced classes of package com.socialin.android.preference:
//            d

final class b
    implements Runnable
{

    private SocialinV3 a;
    private long b;
    private b c;

    public final void run()
    {
        c.c.setSummary((new StringBuilder()).append(a.getAppProps().getData().api.baseUrl).append(" latency: ").append(b).toString());
    }

    ps.Api(ps.Api api, SocialinV3 socialinv3, long l)
    {
        c = api;
        a = socialinv3;
        b = l;
        super();
    }

    // Unreferenced inner class com/socialin/android/preference/d$17

/* anonymous class */
    final class d._cls17 extends Thread
    {

        final Preference a;
        private d b;

        public final void run()
        {
            SocialinV3 socialinv3 = SocialinV3.getInstance();
            if (socialinv3.getAppProps().getData().api != null && socialinv3.getAppProps().getData().api.baseUrl != null)
            {
                long l = d.a(socialinv3.getAppProps().getData().api.baseUrl);
                if (b.getActivity() != null)
                {
                    b.getActivity().runOnUiThread(new d._cls17._cls1(this, socialinv3, l));
                    return;
                }
            }
        }

            
            {
                b = d1;
                a = preference;
                super();
            }
    }

}
