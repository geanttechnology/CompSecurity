// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.mopub.b.h;

// Referenced classes of package com.mopub.mobileads:
//            h, i, an, o

public class MraidVideoPlayerActivity extends com.mopub.mobileads.h
    implements i.a
{

    private i a;
    private long b;

    public MraidVideoPlayerActivity()
    {
    }

    public final void a()
    {
        finish();
    }

    public final void a(int j)
    {
        setRequestedOrientation(j);
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        if (a != null)
        {
            a.a(j, k);
        }
    }

    public void onBackPressed()
    {
        if (a != null && a.g())
        {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (a != null)
        {
            a.f();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        b = getIntent().getLongExtra("broadcastIdentifier", -1L);
        String s;
        s = getIntent().getStringExtra("video_view_class_name");
        if (!"vast".equals(s))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        bundle = new an(this, getIntent().getExtras(), bundle, b, this);
_L1:
        a = bundle;
        a.a();
        return;
        try
        {
            if (!"mraid".equals(s))
            {
                break MISSING_BLOCK_LABEL_136;
            }
            bundle = new h(this, getIntent().getExtras(), this);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            o.a(this, b, "com.mopub.action.interstitial.fail");
            finish();
            return;
        }
          goto _L1
        throw new IllegalStateException((new StringBuilder("Unsupported video type: ")).append(s).toString());
    }

    protected void onDestroy()
    {
        if (a != null)
        {
            a.e();
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        if (a != null)
        {
            a.c();
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (a != null)
        {
            a.d();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (a != null)
        {
            a.a(bundle);
        }
    }

    public void onSetContentView(View view)
    {
        setContentView(view);
    }
}
