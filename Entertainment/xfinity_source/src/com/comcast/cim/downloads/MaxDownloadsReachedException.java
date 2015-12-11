// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;


// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceException

public class MaxDownloadsReachedException extends DownloadServiceException
{

    public MaxDownloadsReachedException()
    {
    }

    public MaxDownloadsReachedException(String s)
    {
        super(s);
    }
}
