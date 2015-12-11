// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.aio.downloader.utils:
//            ProgressWheel

static class <init> extends android.view.lSavedState
{

    public static final android.os.eelSavedState.fillRadius CREATOR = new android.os.Parcelable.Creator() {

        public ProgressWheel.WheelSavedState createFromParcel(Parcel parcel)
        {
            return new ProgressWheel.WheelSavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ProgressWheel.WheelSavedState[] newArray(int i)
        {
            return new ProgressWheel.WheelSavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    int barColor;
    int barWidth;
    int circleRadius;
    boolean fillRadius;
    boolean isSpinning;
    boolean linearProgress;
    float mProgress;
    float mTargetProgress;
    int rimColor;
    int rimWidth;
    float spinSpeed;

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        super.cel(parcel, i);
        parcel.writeFloat(mProgress);
        parcel.writeFloat(mTargetProgress);
        if (isSpinning)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeFloat(spinSpeed);
        parcel.writeInt(barWidth);
        parcel.writeInt(barColor);
        parcel.writeInt(rimWidth);
        parcel.writeInt(rimColor);
        parcel.writeInt(circleRadius);
        if (linearProgress)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (fillRadius)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }


    private _cls1(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        mProgress = parcel.readFloat();
        mTargetProgress = parcel.readFloat();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSpinning = flag;
        spinSpeed = parcel.readFloat();
        barWidth = parcel.readInt();
        barColor = parcel.readInt();
        rimWidth = parcel.readInt();
        rimColor = parcel.readInt();
        circleRadius = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        linearProgress = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        fillRadius = flag;
    }

    fillRadius(Parcel parcel, fillRadius fillradius)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
