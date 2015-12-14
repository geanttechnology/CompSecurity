// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.os.Parcel;
import com.socialin.android.photo.AbstractItem;

public class LensFlare extends AbstractItem
{

    public int describeContents()
    {
        return 0;
    }

    public float getHeight()
    {
        return 0.0F;
    }

    public int getOpacity()
    {
        throw new NullPointerException();
    }

    public float getScaleX()
    {
        return 0.0F;
    }

    public float getScaleY()
    {
        return 0.0F;
    }

    public float getWidth()
    {
        return 1.0F;
    }

    public float getX()
    {
        throw new NullPointerException();
    }

    public float getY()
    {
        throw new NullPointerException();
    }

    public void setDrawHandle(boolean flag)
    {
        super.setDrawHandle(flag);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    static 
    {
        com/socialin/android/photo/lensflare/LensFlare.getSimpleName();
    }
}
