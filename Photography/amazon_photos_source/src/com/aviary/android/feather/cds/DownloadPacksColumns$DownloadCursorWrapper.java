// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            DownloadPacksColumns

public static class  extends 
{

    long downloadId;
    int downloadStatus;
    long packId;

    public static  create(Cursor cursor)
    {
        if (isValid(cursor))
        {
              = new <init>(cursor.getLong(cursor.getColumnIndex("downloadId")));
            int i = cursor.getColumnIndex("download_refId");
            if (i > -1)
            {
                .downloadId = cursor.getLong(i);
            }
            i = cursor.getColumnIndex("download_packId");
            if (i > -1)
            {
                .packId = cursor.getLong(i);
            }
            i = cursor.getColumnIndex("download_status");
            if (i > -1)
            {
                .downloadStatus = cursor.getInt(i);
            }
            return ;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        downloadStatus downloadstatus = new <init>(id);
        downloadstatus.downloadId = downloadId;
        downloadstatus.packId = packId;
        downloadstatus.downloadStatus = downloadStatus;
        return downloadstatus;
    }

    public long getDownloadId()
    {
        return downloadId;
    }

    public int getDownloadStatus()
    {
        return downloadStatus;
    }

    public long getPackId()
    {
        return packId;
    }

    public (long l)
    {
        super(l);
    }
}
