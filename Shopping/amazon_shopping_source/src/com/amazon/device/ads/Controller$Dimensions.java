// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Parcel;

// Referenced classes of package com.amazon.device.ads:
//            Controller

public static class rcelable extends rcelable
{

    public static final android.os.ReflectedParcelable CREATOR = new android.os.Parcelable.Creator() {

        public Controller.Dimensions createFromParcel(Parcel parcel)
        {
            return new Controller.Dimensions(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Controller.Dimensions[] newArray(int i)
        {
            return new Controller.Dimensions[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int height;
    public int width;
    public int x;
    public int y;


    public _cls1()
    {
        x = -1;
        y = -1;
        width = -1;
        height = -1;
    }

    public height(Parcel parcel)
    {
        super(parcel);
    }
}
