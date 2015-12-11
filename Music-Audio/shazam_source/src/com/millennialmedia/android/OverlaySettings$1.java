// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;

// Referenced classes of package com.millennialmedia.android:
//            OverlaySettings

static final class 
    implements android.os.
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new OverlaySettings(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new OverlaySettings[i];
    }

    ()
    {
    }
}
