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

final class a extends Thread
{

    final Preference a;
    private d b;

    public final void run()
    {
        SocialinV3 socialinv3 = SocialinV3.getInstance();
        if (socialinv3.getAppProps().getData().api != null && socialinv3.getAppProps().getData().api.retryUrl != null)
        {
            long l = d.a(socialinv3.getAppProps().getData().api.retryUrl);
            if (b.getActivity() != null)
            {
                b.getActivity().runOnUiThread(new Runnable(socialinv3, l) {

                    private SocialinV3 a;
                    private long b;
                    private d._cls18 c;

                    public final void run()
                    {
                        c.a.setSummary((new StringBuilder()).append(a.getAppProps().getData().api.retryUrl).append(" latency: ").append(b).toString());
                    }

            
            {
                c = d._cls18.this;
                a = socialinv3;
                b = l;
                super();
            }
                });
                return;
            }
        }
    }

    _cls1.b(d d1, Preference preference)
    {
        b = d1;
        a = preference;
        super();
    }
}
