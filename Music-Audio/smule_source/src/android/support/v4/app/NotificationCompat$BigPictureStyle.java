// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Bitmap;

public class setBuilder extends setBuilder
{

    Bitmap mBigLargeIcon;
    boolean mBigLargeIconSet;
    Bitmap mPicture;

    public setBuilder bigLargeIcon(Bitmap bitmap)
    {
        mBigLargeIcon = bitmap;
        mBigLargeIconSet = true;
        return this;
    }

    public mBigLargeIconSet bigPicture(Bitmap bitmap)
    {
        mPicture = bitmap;
        return this;
    }

    public mPicture setBigContentTitle(CharSequence charsequence)
    {
        mBigContentTitle = rSequenceLength(charsequence);
        return this;
    }

    public rSequenceLength setSummaryText(CharSequence charsequence)
    {
        mSummaryText = rSequenceLength(charsequence);
        mSummaryTextSet = true;
        return this;
    }

    public ()
    {
    }

    public ( )
    {
        setBuilder();
    }
}
