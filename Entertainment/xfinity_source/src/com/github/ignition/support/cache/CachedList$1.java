// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.cache;

import android.os.Parcel;
import java.io.IOException;

// Referenced classes of package com.github.ignition.support.cache:
//            CachedList

static final class 
    implements android.os.eator
{

    public CachedList createFromParcel(Parcel parcel)
    {
        try
        {
            parcel = new CachedList(parcel);
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
            return null;
        }
        return parcel;
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CachedList[] newArray(int i)
    {
        return new CachedList[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
