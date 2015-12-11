// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class aw
{

    aw()
    {
    }

    public static Drawable a(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return context.getDrawable(i);
        } else
        {
            return context.getResources().getDrawable(i);
        }
    }

    public Notification a(au au1)
    {
        Notification notification = au1.i;
        notification.setLatestEventInfo(au1.a, null, null, au1.b);
        return notification;
    }
}
