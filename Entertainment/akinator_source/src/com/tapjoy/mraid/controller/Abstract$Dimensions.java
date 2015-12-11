// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.os.Parcel;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract

public static class rcelable extends rcelable
{

    public static final android.os.tract.ReflectedParcelable CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new Abstract.Dimensions(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new Abstract.Dimensions[i];
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

    protected height(Parcel parcel)
    {
        super(parcel);
    }
}
