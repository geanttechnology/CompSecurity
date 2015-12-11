// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            NotificationCompat

public static class mPriority
{

    ArrayList mActions;
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    Context mContext;
    PendingIntent mFullScreenIntent;
    Bitmap mLargeIcon;
    Notification mNotification;
    int mNumber;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    mNotification mStyle;
    CharSequence mSubText;
    RemoteViews mTickerView;
    boolean mUseChronometer;

    private void setFlag(int i, boolean flag)
    {
        if (flag)
        {
            Notification notification = mNotification;
            notification.flags = notification.flags | i;
            return;
        } else
        {
            Notification notification1 = mNotification;
            notification1.flags = notification1.flags & ~i;
            return;
        }
    }

    public mNotification addAction(int i, CharSequence charsequence, PendingIntent pendingintent)
    {
        mActions.add(new init>(i, charsequence, pendingintent));
        return this;
    }

    public Notification build()
    {
        return NotificationCompat.access$000().build(this);
    }

    public tionCompatImpl.build setAutoCancel(boolean flag)
    {
        setFlag(16, flag);
        return this;
    }

    public setFlag setContent(RemoteViews remoteviews)
    {
        mNotification.contentView = remoteviews;
        return this;
    }

    public mNotification setContentIntent(PendingIntent pendingintent)
    {
        mContentIntent = pendingintent;
        return this;
    }

    public mContentIntent setContentText(CharSequence charsequence)
    {
        mContentText = charsequence;
        return this;
    }

    public mContentText setContentTitle(CharSequence charsequence)
    {
        mContentTitle = charsequence;
        return this;
    }

    public mContentTitle setOngoing(boolean flag)
    {
        setFlag(2, flag);
        return this;
    }

    public setFlag setOnlyAlertOnce(boolean flag)
    {
        setFlag(8, flag);
        return this;
    }

    public setFlag setSmallIcon(int i)
    {
        mNotification.icon = i;
        return this;
    }

    public mNotification setStyle(mNotification mnotification)
    {
        if (mStyle != mnotification)
        {
            mStyle = mnotification;
            if (mStyle != null)
            {
                mStyle.tBuilder(this);
            }
        }
        return this;
    }

    public tBuilder setTicker(CharSequence charsequence)
    {
        mNotification.tickerText = charsequence;
        return this;
    }

    public mNotification setWhen(long l)
    {
        mNotification.when = l;
        return this;
    }

    public tionCompatImpl(Context context)
    {
        mActions = new ArrayList();
        mNotification = new Notification();
        mContext = context;
        mNotification.when = System.currentTimeMillis();
        mNotification.audioStreamType = -1;
        mPriority = 0;
    }
}
