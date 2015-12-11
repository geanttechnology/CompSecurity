// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;

// Referenced classes of package com.target.mothership.util:
//            g

static final class reIdentifier
    implements Store
{

    public int describeContents()
    {
        return 0;
    }

    public StoreIdentifier getStoreId()
    {
        return new StoreIdentifier("52");
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    reIdentifier()
    {
    }
}
