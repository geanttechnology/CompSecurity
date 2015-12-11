// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.indexing;

import android.os.Parcel;

// Referenced classes of package io.branch.indexing:
//            BranchUniversalObject

static final class 
    implements android.os.bject._cls1
{

    public BranchUniversalObject createFromParcel(Parcel parcel)
    {
        return new BranchUniversalObject(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public BranchUniversalObject[] newArray(int i)
    {
        return new BranchUniversalObject[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
