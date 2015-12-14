// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package my.googlemusic.play.services.notification:
//            TimerSchedule

public class NotificationService extends Service
{

    public NotificationService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        (new Thread(new Runnable() {

            final NotificationService this$0;

            public void run()
            {
                new TimerSchedule(NotificationService.this);
            }

            
            {
                this$0 = NotificationService.this;
                super();
            }
        })).start();
        return 1;
    }
}
