// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.model;

import android.os.Parcel;

// Referenced classes of package com.target.ui.vlc.model:
//            VlcPositionInfo

static final class 
    implements android.os.
{

    public VlcPositionInfo a(Parcel parcel)
    {
        return new VlcPositionInfo(parcel);
    }

    public VlcPositionInfo[] a(int i)
    {
        return new VlcPositionInfo[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
