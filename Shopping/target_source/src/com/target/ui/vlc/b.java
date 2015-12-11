// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc;

import android.os.Handler;
import android.os.Looper;
import com.target.ui.analytics.a.r;
import com.target.ui.vlc.model.VlcPositionInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.vlc:
//            c

public class b
    implements c
{

    private static final int REPORT_INTERVAL_MS = 15000;
    private boolean mDestroyed;
    private Handler mHandler;
    private List mPositionInfoList;
    private Runnable mPublishRunnable;
    private boolean mRunning;

    public b()
    {
        mDestroyed = false;
        mRunning = false;
        mHandler = new Handler(Looper.getMainLooper());
        mPositionInfoList = new ArrayList();
        mPublishRunnable = new Runnable() {

            final b this$0;

            public void run()
            {
                if (b.a(b.this).size() > 0)
                {
                    com.target.ui.analytics.a.r.a(b.a(b.this)).e();
                    b.a(b.this).clear();
                }
                if (b.b(b.this))
                {
                    return;
                } else
                {
                    b.c(b.this);
                    return;
                }
            }

            
            {
                this$0 = b.this;
                super();
            }
        };
    }

    static List a(b b1)
    {
        return b1.mPositionInfoList;
    }

    private void b()
    {
        mHandler.postDelayed(mPublishRunnable, 15000L);
    }

    static boolean b(b b1)
    {
        return b1.mDestroyed;
    }

    static void c(b b1)
    {
        b1.b();
    }

    public void a()
    {
        mDestroyed = true;
    }

    public void a(VlcPositionInfo vlcpositioninfo)
    {
        mPositionInfoList.add(vlcpositioninfo);
        if (!mRunning)
        {
            b();
            mRunning = true;
        }
    }

    public void p()
    {
    }

    public void q()
    {
    }

    public void r()
    {
    }

    public void s()
    {
    }
}
