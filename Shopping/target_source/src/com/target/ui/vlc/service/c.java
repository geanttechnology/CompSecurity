// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.target.ui.vlc.d;

// Referenced classes of package com.target.ui.vlc.service:
//            VlcService

public class c
    implements ServiceConnection
{
    public static interface a
    {

        public abstract void d();

        public abstract void e();
    }

    public static class b extends Exception
    {

        public b(String s)
        {
            super(s);
        }
    }


    private boolean mBound;
    private boolean mEnableVlcOnConnected;
    private a mServiceConnectionListener;
    private VlcService.a mVlcBinder;
    private com.target.ui.vlc.c mVlcListener;
    private d mVlcParams;

    public c(d d, com.target.ui.vlc.c c1, a a1)
    {
        mServiceConnectionListener = a1;
        mVlcParams = d;
        mVlcListener = c1;
    }

    private void b()
    {
        mVlcBinder.a(mVlcParams, mVlcListener);
    }

    private void c()
    {
        mBound = false;
        mVlcBinder = null;
        mServiceConnectionListener.e();
    }

    public void a()
    {
        if (mVlcBinder == null)
        {
            return;
        } else
        {
            mVlcBinder.a();
            return;
        }
    }

    public void a(Context context)
    {
        if (!mBound)
        {
            return;
        } else
        {
            a();
            context.stopService(new Intent(context, com/target/ui/vlc/service/VlcService));
            context.unbindService(this);
            c();
            return;
        }
    }

    public void a(Context context, boolean flag)
    {
        if (mBound)
        {
            return;
        } else
        {
            mEnableVlcOnConnected = flag;
            context.bindService(new Intent(context, com/target/ui/vlc/service/VlcService), this, 1);
            mBound = true;
            return;
        }
    }

    public void a(d d)
        throws b
    {
        if (mVlcBinder == null)
        {
            throw new b("Vlc service is not yet connected!");
        } else
        {
            mVlcParams = d;
            b();
            return;
        }
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        mBound = true;
        mVlcBinder = (VlcService.a)ibinder;
        if (mEnableVlcOnConnected)
        {
            b();
        }
        if (mServiceConnectionListener != null)
        {
            mServiceConnectionListener.d();
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        c();
    }
}
