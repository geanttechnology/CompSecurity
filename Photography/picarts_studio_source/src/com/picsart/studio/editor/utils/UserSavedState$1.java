// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.utils;

import android.os.Parcel;

// Referenced classes of package com.picsart.studio.editor.utils:
//            UserSavedState

final class 
    implements android.os.r
{

    public final Object createFromParcel(Parcel parcel)
    {
        if (parcel.readParcelable(null) != null)
        {
            throw new IllegalStateException("superState must be null");
        } else
        {
            return UserSavedState.a();
        }
    }

    public final volatile Object[] newArray(int i)
    {
        return new UserSavedState[i];
    }

    ()
    {
    }
}
