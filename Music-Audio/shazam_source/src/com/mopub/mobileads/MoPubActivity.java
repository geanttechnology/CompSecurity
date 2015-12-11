// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.mopub.common.d.c;
import com.mopub.common.h;
import com.mopub.mobileads.a.f;

// Referenced classes of package com.mopub.mobileads:
//            g, f, o, p, 
//            s

public class MoPubActivity extends g
{
    final class a
        implements m.a
    {

        final MoPubActivity a;

        public final void a()
        {
            MoPubActivity.a(a).loadUrl(g.a.a.a());
        }

        public final void a(s s)
        {
            o.a(a, ((g) (a)).c.longValue(), "com.mopub.action.interstitial.fail");
            a.finish();
        }

        public final void b()
        {
        }

        public final void c()
        {
            o.a(a, ((g) (a)).c.longValue(), "com.mopub.action.interstitial.click");
        }

        public final void d()
        {
        }

        a()
        {
            a = MoPubActivity.this;
            super();
        }
    }


    private p d;

    public MoPubActivity()
    {
    }

    static p a(MoPubActivity mopubactivity)
    {
        return mopubactivity.d;
    }

    public final View a()
    {
        Object obj = getIntent();
        boolean flag = ((Intent) (obj)).getBooleanExtra("Scrollable", false);
        String s = ((Intent) (obj)).getStringExtra("Redirect-Url");
        String s1 = ((Intent) (obj)).getStringExtra("Clickthrough-Url");
        obj = ((Intent) (obj)).getStringExtra("Html-Response-Body");
        d = f.a(getApplicationContext(), a, new a(), flag, s, s1);
        d.loadDataWithBaseURL("http://ads.mopub.com/", ((String) (obj)), "text/html", "utf-8", null);
        return d;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getSerializableExtra("com_mopub_orientation");
        if (bundle == null || !(bundle instanceof h))
        {
            bundle = h.c;
        } else
        {
            bundle = (h)bundle;
        }
        if (com.mopub.common.m.a.a(bundle) && com.mopub.common.m.a.a(this)) goto _L2; else goto _L1
_L1:
        o.a(this, super.c.longValue(), "com.mopub.action.interstitial.show");
        return;
_L2:
        int i;
        i = c.a(((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation(), getResources().getConfiguration().orientation);
        if (h.a != bundle)
        {
            break; /* Loop/switch isn't completed */
        }
        if (9 == i)
        {
            i = 9;
        } else
        {
            i = 1;
        }
_L5:
        setRequestedOrientation(i);
        if (true) goto _L1; else goto _L3
_L3:
        if (h.b != bundle) goto _L1; else goto _L4
_L4:
        if (8 == i)
        {
            i = 8;
        } else
        {
            i = 0;
        }
          goto _L5
    }

    protected void onDestroy()
    {
        d.loadUrl(g.a.b.a());
        d.destroy();
        o.a(this, super.c.longValue(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }
}
