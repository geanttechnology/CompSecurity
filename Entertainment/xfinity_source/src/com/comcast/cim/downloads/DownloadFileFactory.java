// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IVirtuosoAsset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadFile

public abstract class DownloadFileFactory
{

    private final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/downloads/DownloadFileFactory);

    public DownloadFileFactory()
    {
    }

    public abstract DownloadFile create(IVirtuosoAsset ivirtuosoasset);
}
