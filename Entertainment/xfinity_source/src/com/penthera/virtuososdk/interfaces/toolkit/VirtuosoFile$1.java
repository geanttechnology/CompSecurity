// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.os.Parcel;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoFile

class 
    implements android.os.tor
{

    public VirtuosoFile createFromParcel(Parcel parcel)
    {
        return new VirtuosoFile(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public VirtuosoFile[] newArray(int i)
    {
        return new VirtuosoFile[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
