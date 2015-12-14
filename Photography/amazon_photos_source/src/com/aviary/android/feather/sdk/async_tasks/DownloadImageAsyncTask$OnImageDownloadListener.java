// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.async_tasks;

import android.graphics.Bitmap;
import com.aviary.android.feather.library.utils.ImageInfo;

// Referenced classes of package com.aviary.android.feather.sdk.async_tasks:
//            DownloadImageAsyncTask

public static interface 
{

    public abstract void onDownloadComplete(Bitmap bitmap, ImageInfo imageinfo);

    public abstract void onDownloadError(String s);

    public abstract void onDownloadStart();
}
