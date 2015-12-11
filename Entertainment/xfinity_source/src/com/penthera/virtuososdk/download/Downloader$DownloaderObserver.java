// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.os.Bundle;
import android.os.Parcelable;

// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

static interface e
{

    public abstract void downloadUpdate(Downloader downloader, com.penthera.virtuososdk.utility.pe pe, Parcelable parcelable);

    public abstract void fragmentsComplete(Downloader downloader, Bundle bundle);

    public abstract void hdsProgressUpdate(Downloader downloader, Bundle bundle);

    public abstract void quotaUpdate(Downloader downloader, Bundle bundle);

    public abstract void saveFileState(Downloader downloader, Bundle bundle);
}
