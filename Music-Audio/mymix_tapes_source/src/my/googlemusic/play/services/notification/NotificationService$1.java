// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.notification;


// Referenced classes of package my.googlemusic.play.services.notification:
//            NotificationService, TimerSchedule

class this._cls0
    implements Runnable
{

    final NotificationService this$0;

    public void run()
    {
        new TimerSchedule(NotificationService.this);
    }

    ()
    {
        this$0 = NotificationService.this;
        super();
    }
}
