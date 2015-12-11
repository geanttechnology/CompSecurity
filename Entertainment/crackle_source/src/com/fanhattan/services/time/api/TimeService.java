// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.time.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.fanhattan.services.api.BaseServiceBinder;

// Referenced classes of package com.fanhattan.services.time.api:
//            ITimeService

public final class TimeService extends BaseServiceBinder
{

    private static final String TAG = "TimeService";
    public static final String TIME_ZONE_AUTO = "auto";
    private final String mPackageName;

    public TimeService(Context context)
    {
        super(context, false, "TimeService");
        mPackageName = context.getPackageName();
    }

    public boolean bind()
    {
        return super.bind();
    }

    protected ITimeService castService(IBinder ibinder)
    {
        return ITimeService.Stub.asInterface(ibinder);
    }

    protected volatile Object castService(IBinder ibinder)
    {
        return castService(ibinder);
    }

    protected Intent getIntent()
    {
        Intent intent = new Intent("time");
        intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
        return intent;
    }

    public String getTimeZone()
    {
        String s = null;
        ITimeService itimeservice = (ITimeService)getService();
        if (itimeservice != null)
        {
            try
            {
                s = itimeservice.getTimeZone(mPackageName);
            }
            catch (Exception exception)
            {
                Log.e("TimeService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return null;
            }
        }
        return s;
    }

    public boolean isAutoTimeZone()
    {
        boolean flag = false;
        ITimeService itimeservice = (ITimeService)getService();
        if (itimeservice != null)
        {
            try
            {
                flag = itimeservice.isAutoTimeZone();
            }
            catch (Exception exception)
            {
                Log.e("TimeService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return false;
            }
        }
        return flag;
    }

    public void setAutoTimeZone()
    {
        ITimeService itimeservice;
        itimeservice = (ITimeService)getService();
        if (itimeservice == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        itimeservice.setAutoTimeZone(mPackageName);
        return;
        Exception exception;
        exception;
        Log.e("TimeService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
        return;
    }

    public void setTimeZone(String s)
    {
        ITimeService itimeservice;
        itimeservice = (ITimeService)getService();
        if (itimeservice == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        itimeservice.setTimeZone(mPackageName, s);
        return;
        s;
        Log.e("TimeService", (new StringBuilder()).append("Error in Fanhattan Services ").append(s.getMessage()).toString());
        return;
    }

    public boolean unbind()
    {
        return super.unbind();
    }
}
