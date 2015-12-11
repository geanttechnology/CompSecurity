// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.os.Parcel;

// Referenced classes of package com.penthera.virtuososdk.download:
//            VirtuosoDownloadEngineStatus

class 
    implements android.os.DownloadEngineStatus._cls1
{

    public VirtuosoDownloadEngineStatus createFromParcel(Parcel parcel)
    {
        return new VirtuosoDownloadEngineStatus(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public VirtuosoDownloadEngineStatus[] newArray(int i)
    {
        return new VirtuosoDownloadEngineStatus[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
