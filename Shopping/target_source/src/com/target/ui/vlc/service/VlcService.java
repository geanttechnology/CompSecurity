// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import com.target.ui.vlc.c;
import com.target.ui.vlc.d;

// Referenced classes of package com.target.ui.vlc.service:
//            a, b

public class VlcService extends Service
{
    public class a extends Binder
    {

        private static final long VLC_RESTART_DELAY_TIME_MILLISECONDS = 5000L;
        private boolean mEnabling;
        private b mVlc;
        private Handler mVlcDelayedRestartHandler;
        private d mVlcParams;
        final VlcService this$0;

        static b a(a a1, d d1, c c1)
        {
            return a1.b(d1, c1);
        }

        static b a(a a1, b b1)
        {
            a1.mVlc = b1;
            return b1;
        }

        static boolean a(a a1)
        {
            return a1.mEnabling;
        }

        static boolean a(a a1, boolean flag)
        {
            a1.mEnabling = flag;
            return flag;
        }

        private b b(d d1, c c1)
        {
            return new com.target.ui.vlc.service.a(d1.deviceId, c1, d1.siteInfo, getApplicationContext());
        }

        static b b(a a1)
        {
            return a1.mVlc;
        }

        private void c(final d vlcParams, c c1)
        {
            mVlc.a();
            mVlc.b();
            vlcParams = c1. new Runnable() {

                final a this$1;
                final c val$vlcListener;
                final d val$vlcParams;

                public void run()
                {
                    if (a.a(a.this))
                    {
                        a.a(a.this, a.a(a.this, vlcParams, vlcListener));
                        a.b(a.this).a(vlcParams.siteInfo);
                    }
                    a.a(a.this, false);
                }

            
            {
                this$1 = final_a1;
                vlcParams = d1;
                vlcListener = c.this;
                super();
            }
            };
            mVlcDelayedRestartHandler.postDelayed(vlcParams, 5000L);
        }

        public void a()
        {
            mEnabling = false;
            if (mVlc == null)
            {
                return;
            } else
            {
                mVlc.a();
                return;
            }
        }

        public void a(d d1, c c1)
        {
            if (!mEnabling)
            {
                if (mVlc == null)
                {
                    mVlcParams = d1;
                    mVlc = b(d1, c1);
                    mVlc.a(d1.siteInfo);
                    mEnabling = false;
                    return;
                }
                if (!d1.siteInfo.equals(mVlcParams.siteInfo))
                {
                    mEnabling = true;
                    c(d1, c1);
                    return;
                }
            }
        }

        public a()
        {
            this$0 = VlcService.this;
            super();
            mVlcDelayedRestartHandler = new Handler();
        }
    }


    protected IBinder mVlcBinder;

    public VlcService()
    {
        mVlcBinder = new a();
    }

    public IBinder onBind(Intent intent)
    {
        return mVlcBinder;
    }
}
