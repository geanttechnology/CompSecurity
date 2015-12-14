// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Notification;

// Referenced classes of package com.parse:
//            NotificationCompat

public static abstract class mSummaryTextSet
{

    CharSequence mBigContentTitle;
    le mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet;

    public Notification build()
    {
        Notification notification = null;
        if (mBuilder != null)
        {
            notification = mBuilder.mBuilder();
        }
        return notification;
    }

    public void setBuilder(mBuilder mbuilder)
    {
        if (mBuilder != mbuilder)
        {
            mBuilder = mbuilder;
            if (mBuilder != null)
            {
                mBuilder.le(this);
            }
        }
    }

    public ()
    {
        mSummaryTextSet = false;
    }
}
