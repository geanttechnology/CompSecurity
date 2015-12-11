// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.api.ext;

import android.content.Context;
import android.util.Log;
import com.sessionm.api.Activity;
import com.sessionm.core.Config;
import com.sessionm.core.f;
import com.sessionm.core.g;
import com.sessionm.core.i;
import java.util.concurrent.ExecutorService;

public class SessionM extends com.sessionm.api.SessionM
{

    public SessionM()
    {
    }

    public static SessionM getInstance()
    {
        com/sessionm/api/ext/SessionM;
        JVM INSTR monitorenter ;
        if (instance != null) goto _L2; else goto _L1
_L1:
        if (!i.isSupportedPlatform()) goto _L4; else goto _L3
_L3:
        instance = new SessionM();
_L5:
        Object obj = (SessionM)instance;
_L7:
        com/sessionm/api/ext/SessionM;
        JVM INSTR monitorexit ;
        return ((SessionM) (obj));
_L4:
        instance = new g();
          goto _L5
        obj;
        throw obj;
_L2:
        if (instance instanceof SessionM) goto _L5; else goto _L6
_L6:
        Log.e("SessionM", "Cannot use both public and extended SessionM accessors interchangeably. Ensure that your app is calling either com.sessionm.api.SessionM or com.sessionm.api.ext.SessionM getInstance()");
        obj = null;
          goto _L7
    }

    public Config getConfig()
    {
        return Config.h();
    }

    public ExecutorService getExecutorService()
    {
        return f.E().getExecutorService();
    }

    public int getFragmentFrameLayoutId()
    {
        return f.E().getFragmentFrameLayoutId();
    }

    public boolean isExpandedPresentationMode()
    {
        return f.E().isExpandedPresentationMode();
    }

    public boolean isHardwareAccelerationDisabled()
    {
        return f.E().isHardwareAccelerationDisabled();
    }

    public boolean isSessionAutoStartEnabled()
    {
        return f.E().isSessionAutoStartEnabled();
    }

    public void logPaymentTransaction(float f1)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("logPaymentTransaction called with amount: %f", new Object[] {
                Float.valueOf(f1)
            }), new Throwable());
        }
        f.E().logPaymentTransaction(f1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public transient boolean presentActivity(com.sessionm.api.ActivityType activitytype, Object aobj[])
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        f f1;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("present activity called with activityType %s %s", new Object[] {
                activitytype, aobj
            }), new Throwable());
        }
        f1 = f.E();
        if (f1.J() != null || f1.isExpandedPresentationMode()) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
        if (!Log.isLoggable("SessionM", 6))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        Log.e("SessionM", "SessionM activities must be presented on resumed (non-paused) activities. Activity cannot be presented because currently running Android activity is unknown. Ensure your activity properly calls SessionM.onActivityXXX() notification methods or extends com.sessionm.api.BaseActivity.");
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = f1.b(new Activity(activitytype), aobj);
        if (true) goto _L4; else goto _L3
_L3:
        activitytype;
        throw activitytype;
    }

    public void setExecutorService(ExecutorService executorservice)
    {
        f.E().setExecutorService(executorservice);
    }

    public void setExpandedPresentationMode(boolean flag)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set expanded presentation mode called with value: %b", new Object[] {
                Boolean.valueOf(flag)
            }), new Throwable());
        }
        f.E().setExpandedPresentationMode(flag);
    }

    public void setFragmentFrameLayoutId(int j)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set fragement layout id called with id: %d", new Object[] {
                Integer.valueOf(j)
            }), new Throwable());
        }
        f.E().setFragmentFrameLayoutId(j);
    }

    public void setHardwareAccelerationDisabled(boolean flag)
    {
        f.E().d(flag);
    }

    public void setSessionAutoStartEnabled(boolean flag)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set session auto start enabled called with value: %b", new Object[] {
                Boolean.valueOf(flag)
            }), new Throwable());
        }
        f.E().setSessionAutoStartEnabled(flag);
    }

    public void setSkipBlacklist(boolean flag)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set skip blacklist called with value: %d", new Object[] {
                Boolean.valueOf(flag)
            }), new Throwable());
        }
        f.E().setSkipBlacklist(flag);
    }

    public void startSession(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("explict start session called. appKey: %s", new Object[] {
                s
            }), new Throwable());
        }
        super.startSession(context, s);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public void stopSession()
    {
        f.E().stopSession();
    }
}
