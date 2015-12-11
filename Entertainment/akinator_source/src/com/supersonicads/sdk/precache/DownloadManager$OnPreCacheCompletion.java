// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.precache;

import com.supersonicads.sdk.data.SSAFile;

// Referenced classes of package com.supersonicads.sdk.precache:
//            DownloadManager

public static interface I
{

    public abstract void onFileDownloadFail(SSAFile ssafile);

    public abstract void onFileDownloadSuccess(SSAFile ssafile);
}
