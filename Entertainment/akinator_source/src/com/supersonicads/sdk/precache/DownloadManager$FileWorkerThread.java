// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.precache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.supersonicads.sdk.precache:
//            DownloadManager

public class mFolderName
    implements Callable
{

    private long mConnectionRetries;
    private String mDirectory;
    private String mFile;
    private String mFolderName;
    private String mLink;
    final DownloadManager this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public List call()
    {
        List list = null;
        if (mConnectionRetries == 0L)
        {
            mConnectionRetries = 1L;
        }
        for (int i = 0; (long)i < mConnectionRetries; i++)
        {
            new ArrayList();
            list = downloadContent(mLink, mDirectory, mFile, mFolderName, i);
            int j = ((Integer)list.get(1)).intValue();
            if (j != 1008 && j != 1009)
            {
                return list;
            }
        }

        return list;
    }

    public (String s, String s1, String s2, long l, String s3)
    {
        this$0 = DownloadManager.this;
        super();
        mLink = s;
        mDirectory = s1;
        mFile = s2;
        mConnectionRetries = l;
        mFolderName = s3;
    }
}
