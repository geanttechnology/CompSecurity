// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.notification;

import android.content.Context;
import android.util.SparseArray;

// Referenced classes of package my.googlemusic.play.utils.notification:
//            NotificationCreator

public class Notification
{

    private static Notification instance;
    private Context context;
    private SparseArray notificationList;

    private Notification(Context context1)
    {
        context = context1.getApplicationContext();
        notificationList = new SparseArray();
    }

    public static Notification with(Context context1)
    {
        if (instance == null)
        {
            instance = new Notification(context1.getApplicationContext());
        }
        return instance;
    }

    public void cancel(int i)
    {
        NotificationCreator notificationcreator = (NotificationCreator)notificationList.get(i);
        if (notificationcreator != null)
        {
            notificationcreator.cancel();
            notificationList.remove(i);
        }
    }

    public NotificationCreator load(int i)
    {
        if (notificationList.get(i) == null)
        {
            notificationList.put(i, new NotificationCreator(context, i));
        }
        return (NotificationCreator)notificationList.get(i);
    }
}
