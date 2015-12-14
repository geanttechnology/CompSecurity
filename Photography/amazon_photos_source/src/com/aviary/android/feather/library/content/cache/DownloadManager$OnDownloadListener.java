// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content.cache;

import java.io.InputStream;

// Referenced classes of package com.aviary.android.feather.library.content.cache:
//            DownloadManager

public static interface Y
{

    public abstract void onDownloadComplete(String s, int i, InputStream inputstream);

    public abstract void onDownloadError(String s, int i, Throwable throwable);

    public abstract void onDownloadStarted(String s, int i);
}
