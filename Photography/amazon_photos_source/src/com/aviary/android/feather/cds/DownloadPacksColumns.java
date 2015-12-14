// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

public final class DownloadPacksColumns
{
    public static class DownloadCursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        long downloadId;
        int downloadStatus;
        long packId;

        public static DownloadCursorWrapper create(Cursor cursor)
        {
            if (isValid(cursor))
            {
                DownloadCursorWrapper downloadcursorwrapper = new DownloadCursorWrapper(cursor.getLong(cursor.getColumnIndex("downloadId")));
                int i = cursor.getColumnIndex("download_refId");
                if (i > -1)
                {
                    downloadcursorwrapper.downloadId = cursor.getLong(i);
                }
                i = cursor.getColumnIndex("download_packId");
                if (i > -1)
                {
                    downloadcursorwrapper.packId = cursor.getLong(i);
                }
                i = cursor.getColumnIndex("download_status");
                if (i > -1)
                {
                    downloadcursorwrapper.downloadStatus = cursor.getInt(i);
                }
                return downloadcursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            DownloadCursorWrapper downloadcursorwrapper = new DownloadCursorWrapper(id);
            downloadcursorwrapper.downloadId = downloadId;
            downloadcursorwrapper.packId = packId;
            downloadcursorwrapper.downloadStatus = downloadStatus;
            return downloadcursorwrapper;
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

        public DownloadCursorWrapper(long l)
        {
            super(l);
        }
    }


    public static final String DOWNLOAD_REF_ID = "download_refId";
    public static final String DOWNLOAD_STATUS = "download_status";
    public static final String PACK_ID = "download_packId";
    public static final String TABLE_NAME = "packs_download_table";
    public static final String _ID = "downloadId";

    private DownloadPacksColumns()
    {
    }
}
