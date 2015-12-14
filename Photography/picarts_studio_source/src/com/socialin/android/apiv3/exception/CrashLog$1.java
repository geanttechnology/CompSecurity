// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.exception;

import android.os.Parcel;

// Referenced classes of package com.socialin.android.apiv3.exception:
//            CrashLog

final class 
    implements android.os.Creator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new CrashLog(parcel, null);
    }

    public final volatile Object[] newArray(int i)
    {
        return new CrashLog[i];
    }

    ()
    {
    }
}
