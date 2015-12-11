// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IFileFragment;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoFile;
import com.penthera.virtuososdk.client.IVirtuosoHLSFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadMetaData

public class DownloadFile
{

    protected volatile IVirtuosoAsset asset;
    protected final DownloadMetaData metaData;

    public DownloadFile(IVirtuosoAsset ivirtuosoasset, DownloadMetaData downloadmetadata)
    {
        Validate.notNull(ivirtuosoasset);
        asset = ivirtuosoasset;
        metaData = downloadmetadata;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof DownloadFile)
        {
            obj = (DownloadFile)obj;
            if (asset.uuid().equals(((DownloadFile) (obj)).getAsset().uuid()))
            {
                return true;
            }
        }
        return false;
    }

    public IVirtuosoAsset getAsset()
    {
        return asset;
    }

    public int getCurrentFileSizeInMb()
    {
        return (int)(asset.currentSize() / 1048576D);
    }

    public DownloadMetaData getDownloadMetaData()
    {
        return metaData;
    }

    public int getExpectedFileSizeInMb()
    {
        return (int)(asset.expectedSize() / 1048576D);
    }

    public String getFileDirectory()
    {
        if (asset instanceof IVirtuosoFile)
        {
            String s = ((IVirtuosoFile)asset).filePath();
            return s.substring(0, s.lastIndexOf("/"));
        } else
        {
            return ((IVirtuosoHLSFile)asset).localBaseDir();
        }
    }

    public String getFileURI()
    {
        if (asset instanceof IVirtuosoFile)
        {
            return (new StringBuilder()).append("file://").append(((IVirtuosoFile)asset).filePath()).toString();
        } else
        {
            return null;
        }
    }

    public List getFileURIList()
    {
        Object obj;
        if (asset instanceof IVirtuosoHLSFile)
        {
            obj = ((IVirtuosoHLSFile)asset).fragments();
            ArrayList arraylist = new ArrayList(((List) (obj)).size());
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                obj = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                arraylist.add(((IFileFragment)iterator.next()).filePath());
            } while (true);
        } else
        {
            obj = null;
        }
        return ((List) (obj));
    }

    public double getFractionComplete()
    {
        return asset.fractionComplete();
    }

    public int getPercentComplete()
    {
        return (int)(asset.fractionComplete() * 100D);
    }

    public int hashCode()
    {
        return asset.uuid().hashCode();
    }

    public boolean isDownloadComplete()
    {
        return asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete || asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired;
    }

    public boolean isDownloadInError()
    {
        return asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Reachability_Error || asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error || asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Corrupt || asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Mime_Mismatch || asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Size_Mismatch || asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_HLS_Fragment_Copy_Error || asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Network_Error;
    }

    public boolean isDownloadInProgress()
    {
        return asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading;
    }

    public boolean isDownloadPending()
    {
        return asset.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending;
    }

    public boolean isFileURICurrentlyAccessible()
    {
        boolean flag1 = false;
        boolean flag;
        if (asset instanceof IVirtuosoFile)
        {
            flag = (new File(((IVirtuosoFile)asset).filePath())).canRead();
        } else
        {
            flag = flag1;
            if (asset instanceof IVirtuosoAsset)
            {
                List list = getFileURIList();
                flag = flag1;
                if (!list.isEmpty())
                {
                    return (new File((String)list.get(0))).canRead();
                }
            }
        }
        return flag;
    }

    public void setAsset(IVirtuosoAsset ivirtuosoasset)
    {
        asset = ivirtuosoasset;
    }
}
