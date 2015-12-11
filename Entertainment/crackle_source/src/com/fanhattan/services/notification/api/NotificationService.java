// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.notification.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.fanhattan.services.api.BaseServiceBinder;

// Referenced classes of package com.fanhattan.services.notification.api:
//            INotificationService

public final class NotificationService extends BaseServiceBinder
{

    public static final long DURATION_LONG = 3000L;
    public static final long DURATION_SHORT = 1000L;
    public static final int PRIORITY_LOW = 50;
    public static final int PRIORITY_NORMAL = 100;
    private static final String TAG = "NotificationService";
    private final String mPackageName;

    public NotificationService(Context context)
    {
        super(context, false, "NotificationService");
        mPackageName = context.getPackageName();
    }

    protected INotificationService castService(IBinder ibinder)
    {
        return INotificationService.Stub.asInterface(ibinder);
    }

    protected volatile Object castService(IBinder ibinder)
    {
        return castService(ibinder);
    }

    protected Intent getIntent()
    {
        Intent intent = new Intent("notification");
        intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
        return intent;
    }

    public void notify(int i, String s, int j, long l)
    {
        INotificationService inotificationservice;
        inotificationservice = (INotificationService)getService();
        if (inotificationservice == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        inotificationservice.showNotificationImageResource(mPackageName, i, s, j, l);
        return;
        s;
        Log.e("NotificationService", (new StringBuilder()).append("Error in Fanhattan Services ").append(s.getMessage()).toString());
        return;
    }

    public void notify(String s, int i, long l)
    {
        INotificationService inotificationservice;
        inotificationservice = (INotificationService)getService();
        if (inotificationservice == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        inotificationservice.showNotification(mPackageName, s, i, l);
        return;
        s;
        Log.e("NotificationService", (new StringBuilder()).append("Error in Fanhattan Services ").append(s.getMessage()).toString());
        return;
    }

    public void notify(String s, String s1, int i, long l)
    {
        INotificationService inotificationservice;
        inotificationservice = (INotificationService)getService();
        if (inotificationservice == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        inotificationservice.showNotificationImageUrl(mPackageName, s, s1, i, l);
        return;
        s;
        Log.e("NotificationService", (new StringBuilder()).append("Error in Fanhattan Services ").append(s.getMessage()).toString());
        return;
    }

    public void onPause()
    {
        unbind();
    }

    public void onResume()
    {
        bind();
    }
}
