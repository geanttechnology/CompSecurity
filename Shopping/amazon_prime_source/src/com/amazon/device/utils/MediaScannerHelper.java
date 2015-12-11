// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.io.File;

public class MediaScannerHelper
{

    private final Context mContext;

    public MediaScannerHelper(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            mContext = context;
            return;
        }
    }

    public void scanDirectory(File file)
    {
        file = file.listFiles();
        if (file != null)
        {
            int j = file.length;
            for (int i = 0; i < j; i++)
            {
                File file1 = file[i];
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file1));
                mContext.sendBroadcast(intent);
                Log.d("offLoadLogsAsync", (new StringBuilder()).append("Updating media scanner for file: ").append(file1.getPath()).toString());
            }

        }
    }
}
