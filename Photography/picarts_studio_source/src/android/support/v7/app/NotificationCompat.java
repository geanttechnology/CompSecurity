// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v7.internal.app.NotificationCompatImpl21;
import android.support.v7.internal.app.NotificationCompatImplBase;

public class NotificationCompat extends android.support.v4.app.NotificationCompat
{

    public NotificationCompat()
    {
    }

    private static void addBigMediaStyleToBuilderJellybean(Notification notification, android.support.v4.app.Builder builder)
    {
        if (builder.mStyle instanceof MediaStyle)
        {
            MediaStyle mediastyle = (MediaStyle)builder.mStyle;
            NotificationCompatImplBase.overrideBigContentView(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediastyle.mShowCancelButton, mediastyle.mCancelButtonIntent);
        }
    }

    private static void addMediaStyleToBuilderIcs(NotificationBuilderWithBuilderAccessor notificationbuilderwithbuilderaccessor, android.support.v4.app.Builder builder)
    {
        if (builder.mStyle instanceof MediaStyle)
        {
            MediaStyle mediastyle = (MediaStyle)builder.mStyle;
            NotificationCompatImplBase.overrideContentView(notificationbuilderwithbuilderaccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediastyle.mActionsToShowInCompact, mediastyle.mShowCancelButton, mediastyle.mCancelButtonIntent);
        }
    }

    private static void addMediaStyleToBuilderLollipop(NotificationBuilderWithBuilderAccessor notificationbuilderwithbuilderaccessor, android.support.v4.app.Style style)
    {
        if (style instanceof MediaStyle)
        {
            style = (MediaStyle)style;
            int ai[] = ((MediaStyle) (style)).mActionsToShowInCompact;
            if (((MediaStyle) (style)).mToken != null)
            {
                style = ((android.support.v4.app.Style) (((MediaStyle) (style)).mToken.getToken()));
            } else
            {
                style = null;
            }
            NotificationCompatImpl21.addMediaStyle(notificationbuilderwithbuilderaccessor, ai, style);
        }
    }




    private class MediaStyle extends android.support.v4.app.Style
    {

        int mActionsToShowInCompact[];
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        android.support.v4.media.session.MediaSessionCompat.Token mToken;

        public MediaStyle setCancelButtonIntent(PendingIntent pendingintent)
        {
            mCancelButtonIntent = pendingintent;
            return this;
        }

        public MediaStyle setMediaSession(android.support.v4.media.session.MediaSessionCompat.Token token)
        {
            mToken = token;
            return this;
        }

        public transient MediaStyle setShowActionsInCompactView(int ai[])
        {
            mActionsToShowInCompact = ai;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean flag)
        {
            mShowCancelButton = flag;
            return this;
        }

        public MediaStyle()
        {
            mActionsToShowInCompact = null;
        }

        public MediaStyle(android.support.v4.app.Builder builder)
        {
            mActionsToShowInCompact = null;
            setBuilder(builder);
        }
    }

}
