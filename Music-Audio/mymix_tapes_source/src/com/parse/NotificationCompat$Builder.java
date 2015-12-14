// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;

// Referenced classes of package com.parse:
//            NotificationCompat

public static class mPriority
{
    public static class BigTextStyle extends Style
    {

        CharSequence mBigText;

        public BigTextStyle bigText(CharSequence charsequence)
        {
            mBigText = charsequence;
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charsequence)
        {
            mBigContentTitle = charsequence;
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charsequence)
        {
            mSummaryText = charsequence;
            mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle()
        {
        }

        public BigTextStyle(NotificationCompat.Builder builder)
        {
            setBuilder(builder);
        }
    }

    public static abstract class Style
    {

        CharSequence mBigContentTitle;
        NotificationCompat.Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        public Notification build()
        {
            Notification notification = null;
            if (mBuilder != null)
            {
                notification = mBuilder.build();
            }
            return notification;
        }

        public void setBuilder(NotificationCompat.Builder builder)
        {
            if (mBuilder != builder)
            {
                mBuilder = builder;
                if (mBuilder != null)
                {
                    mBuilder.setStyle(this);
                }
            }
        }

        public Style()
        {
            mSummaryTextSet = false;
        }
    }


    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    Context mContext;
    Bitmap mLargeIcon;
    Notification mNotification;
    int mPriority;
    Style mStyle;

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

    public Notification build()
    {
        return NotificationCompat.access$000().build(this);
    }

    public Notification getNotification()
    {
        return NotificationCompat.access$000().build(this);
    }

    public tionCompatImpl.build setAutoCancel(boolean flag)
    {
        setFlag(16, flag);
        return this;
    }

    public setFlag setContentIntent(PendingIntent pendingintent)
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

    public mContentTitle setDefaults(int i)
    {
        mNotification.defaults = i;
        if ((i & 4) != 0)
        {
            Notification notification = mNotification;
            notification.flags = notification.flags | 1;
        }
        return this;
    }

    public mNotification setDeleteIntent(PendingIntent pendingintent)
    {
        mNotification.deleteIntent = pendingintent;
        return this;
    }

    public  setLargeIcon(Bitmap bitmap)
    {
        mLargeIcon = bitmap;
        return this;
    }

    public mLargeIcon setPriority(int i)
    {
        mPriority = i;
        return this;
    }

    public mPriority setSmallIcon(int i)
    {
        mNotification.icon = i;
        return this;
    }

    public mNotification setSmallIcon(int i, int j)
    {
        mNotification.icon = i;
        mNotification.iconLevel = j;
        return this;
    }

    public Style setStyle(Style style)
    {
        if (mStyle != style)
        {
            mStyle = style;
            if (mStyle != null)
            {
                mStyle.setBuilder(this);
            }
        }
        return this;
    }

    public Style.setBuilder setWhen(long l)
    {
        mNotification.when = l;
        return this;
    }

    public BigTextStyle.setBuilder(Context context)
    {
        mNotification = new Notification();
        mContext = context;
        mNotification.when = System.currentTimeMillis();
        mNotification.audioStreamType = -1;
        mPriority = 0;
    }
}
