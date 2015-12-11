// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.rhythmnewmedia.sdk.video.RhythmVideoView;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            f, p, q, w, 
//            y, D

public class RhythmActivity extends f
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    public static final int ACTIVITY_DISPLAYLANDINGPAGE = 1;
    public static final int ACTIVITY_INTERSTITIAL = 2;
    public static final String ACTIVITY_TYPE = "rnmdActivityType";
    public static final int ACTIVITY_VIDEO = 3;
    public static final int ACTIVITY_VIDEOLANDINGPAGE = 4;
    public static final String EXTRA_ADID = "rnmdAdId";
    public static final String EXTRA_BACKGROUND_COLOR = "backgroundColor";
    public static final String EXTRA_REQUESTID = "rnmdRequestId";
    private a a;

    public RhythmActivity()
    {
        a = null;
    }

    protected View getContentView()
    {
        switch (getIntent().getIntExtra("rnmdActivityType", -1))
        {
        default:
            return null;

        case 1: // '\001'
            p p1 = new p(this, getIntent().getStringExtra("rnmdRequestId"), getIntent().getStringExtra("rnmdAdId"));
            p1.a(getIntent());
            return p1;

        case 2: // '\002'
            q q1 = new q(this, getIntent().getStringExtra("rnmdRequestId"), getIntent().getStringExtra("rnmdAdId"));
            q1.a(getIntent());
            return q1;

        case 3: // '\003'
            Object aobj[] = w.a(getIntent().getStringExtra("ipckey"));
            if (aobj == null || aobj.length <= 0)
            {
                y.b("video activity expected 1 parameter", new Object[0]);
                return null;
            } else
            {
                RhythmVideoView rhythmvideoview = (RhythmVideoView)aobj[0];
                rhythmvideoview.setBackgroundColor(0xff000000);
                rhythmvideoview.setFullscreenActivity(this);
                return rhythmvideoview;
            }

        case 4: // '\004'
            D d = new D(this, getIntent().getStringExtra("rnmdRequestId"), getIntent().getStringExtra("rnmdAdId"));
            d.a(getIntent());
            return d;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (contentView == null)
        {
            y.b("Unknown activity type %d", new Object[] {
                Integer.valueOf(getIntent().getIntExtra("rnmdActivityType", -1))
            });
            finish();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        if (a != null)
        {
            a.a();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (a != null)
        {
            a.b();
        }
    }

    public void setActivityListener(a a1)
    {
        a = a1;
    }
}
