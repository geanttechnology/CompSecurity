// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;

class NotificationCompat
{
    public static class Builder
    {

        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        Context mContext;
        Bitmap mLargeIcon;
        Notification mNotification;
        int mPriority;
        Style mStyle;

        protected static CharSequence limitCharSequenceLength(CharSequence charsequence)
        {
            while (charsequence == null || charsequence.length() <= 5120) 
            {
                return charsequence;
            }
            return charsequence.subSequence(0, 5120);
        }

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
            return NotificationCompat.IMPL.build(this);
        }

        public Notification getNotification()
        {
            return NotificationCompat.IMPL.build(this);
        }

        public Builder setAutoCancel(boolean flag)
        {
            setFlag(16, flag);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingintent)
        {
            mContentIntent = pendingintent;
            return this;
        }

        public Builder setContentText(CharSequence charsequence)
        {
            mContentText = limitCharSequenceLength(charsequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charsequence)
        {
            mContentTitle = limitCharSequenceLength(charsequence);
            return this;
        }

        public Builder setDefaults(int i)
        {
            mNotification.defaults = i;
            if ((i & 4) != 0)
            {
                Notification notification = mNotification;
                notification.flags = notification.flags | 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingintent)
        {
            mNotification.deleteIntent = pendingintent;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap)
        {
            mLargeIcon = bitmap;
            return this;
        }

        public Builder setPriority(int i)
        {
            mPriority = i;
            return this;
        }

        public Builder setSmallIcon(int i)
        {
            mNotification.icon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int j)
        {
            mNotification.icon = i;
            mNotification.iconLevel = j;
            return this;
        }

        public Builder setStyle(Style style)
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

        public Builder setTicker(CharSequence charsequence)
        {
            mNotification.tickerText = limitCharSequenceLength(charsequence);
            return this;
        }

        public Builder setWhen(long l)
        {
            mNotification.when = l;
            return this;
        }

        public Builder(Context context)
        {
            mNotification = new Notification();
            mContext = context;
            mNotification.when = System.currentTimeMillis();
            mNotification.audioStreamType = -1;
            mPriority = 0;
        }
    }

    public static class Builder.BigTextStyle extends Builder.Style
    {

        CharSequence mBigText;

        public Builder.BigTextStyle bigText(CharSequence charsequence)
        {
            mBigText = charsequence;
            return this;
        }

        public Builder.BigTextStyle setBigContentTitle(CharSequence charsequence)
        {
            mBigContentTitle = charsequence;
            return this;
        }

        public Builder.BigTextStyle setSummaryText(CharSequence charsequence)
        {
            mSummaryText = charsequence;
            mSummaryTextSet = true;
            return this;
        }

        public Builder.BigTextStyle()
        {
        }

        public Builder.BigTextStyle(Builder builder)
        {
            setBuilder(builder);
        }
    }

    public static abstract class Builder.Style
    {

        CharSequence mBigContentTitle;
        Builder mBuilder;
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

        public void setBuilder(Builder builder)
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

        public Builder.Style()
        {
            mSummaryTextSet = false;
        }
    }

    static interface NotificationCompatImpl
    {

        public abstract Notification build(Builder builder);
    }

    static class NotificationCompatImplBase
        implements NotificationCompatImpl
    {

        public Notification build(Builder builder)
        {
            Notification notification = builder.mNotification;
            notification.setLatestEventInfo(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentIntent);
            if (builder.mPriority > 0)
            {
                notification.flags = notification.flags | 0x80;
            }
            return notification;
        }

        NotificationCompatImplBase()
        {
        }
    }

    static class NotificationCompatPostJellyBean
        implements NotificationCompatImpl
    {

        private android.app.Notification.Builder postJellyBeanBuilder;

        public Notification build(Builder builder)
        {
            postJellyBeanBuilder = new android.app.Notification.Builder(builder.mContext);
            android.app.Notification.Builder builder1 = postJellyBeanBuilder.setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setTicker(builder.mNotification.tickerText).setSmallIcon(builder.mNotification.icon, builder.mNotification.iconLevel).setContentIntent(builder.mContentIntent).setDeleteIntent(builder.mNotification.deleteIntent);
            boolean flag;
            if ((builder.mNotification.flags & 0x10) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            builder1.setAutoCancel(flag).setLargeIcon(builder.mLargeIcon).setDefaults(builder.mNotification.defaults);
            if (builder.mStyle != null && (builder.mStyle instanceof Builder.BigTextStyle))
            {
                builder = (Builder.BigTextStyle)builder.mStyle;
                android.app.Notification.BigTextStyle bigtextstyle = (new android.app.Notification.BigTextStyle(postJellyBeanBuilder)).setBigContentTitle(((Builder.BigTextStyle) (builder)).mBigContentTitle).bigText(((Builder.BigTextStyle) (builder)).mBigText);
                if (((Builder.BigTextStyle) (builder)).mSummaryTextSet)
                {
                    bigtextstyle.setSummaryText(((Builder.BigTextStyle) (builder)).mSummaryText);
                }
            }
            return postJellyBeanBuilder.build();
        }

        NotificationCompatPostJellyBean()
        {
        }
    }


    public static final int FLAG_HIGH_PRIORITY = 128;
    private static final NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;

    NotificationCompat()
    {
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            IMPL = new NotificationCompatPostJellyBean();
        } else
        {
            IMPL = new NotificationCompatImplBase();
        }
    }

}
