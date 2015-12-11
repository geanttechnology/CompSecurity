// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            NotificationCompat

public static class mPeople
{

    ArrayList mActions;
    String mCategory;
    int mColor;
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    Context mContext;
    Bundle mExtras;
    PendingIntent mFullScreenIntent;
    String mGroupKey;
    boolean mGroupSummary;
    Bitmap mLargeIcon;
    boolean mLocalOnly;
    Notification mNotification;
    int mNumber;
    public ArrayList mPeople;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    Notification mPublicVersion;
    boolean mShowWhen;
    String mSortKey;
    mNotification mStyle;
    CharSequence mSubText;
    RemoteViews mTickerView;
    boolean mUseChronometer;
    int mVisibility;

    protected static CharSequence limitCharSequenceLength(CharSequence charsequence)
    {
        while (charsequence == null || charsequence.length() <= 5120) 
        {
            return charsequence;
        }
        return charsequence.subSequence(0, 5120);
    }

    public Notification build()
    {
        return NotificationCompat.access$200().build(this);
    }

    public  extend( )
    {
        .extend(this);
        return this;
    }

    public Bundle getExtras()
    {
        if (mExtras == null)
        {
            mExtras = new Bundle();
        }
        return mExtras;
    }

    public mExtras setColor(int i)
    {
        mColor = i;
        return this;
    }

    public mColor setContentIntent(PendingIntent pendingintent)
    {
        mContentIntent = pendingintent;
        return this;
    }

    public mContentIntent setContentText(CharSequence charsequence)
    {
        mContentText = limitCharSequenceLength(charsequence);
        return this;
    }

    public limitCharSequenceLength setContentTitle(CharSequence charsequence)
    {
        mContentTitle = limitCharSequenceLength(charsequence);
        return this;
    }

    public limitCharSequenceLength setSmallIcon(int i)
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

    public tBuilder setWhen(long l)
    {
        mNotification.when = l;
        return this;
    }

    public (Context context)
    {
        mShowWhen = true;
        mActions = new ArrayList();
        mLocalOnly = false;
        mColor = 0;
        mVisibility = 0;
        mNotification = new Notification();
        mContext = context;
        mNotification.when = System.currentTimeMillis();
        mNotification.audioStreamType = -1;
        mPriority = 0;
        mPeople = new ArrayList();
    }
}
