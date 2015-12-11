// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.manager;

import android.text.TextUtils;
import java.io.File;

class FileDeletionThread extends Thread
{

    private static final String LOG_TAG = com/penthera/virtuososdk/manager/FileDeletionThread.getName();
    private String filesToDelete[];

    FileDeletionThread()
    {
        filesToDelete = null;
    }

    private void deleteDirectoryContent(File file)
    {
        file = file.listFiles();
        if (file != null)
        {
            int i = 0;
            while (i < file.length) 
            {
                String s = file[i].getPath();
                if (file[i].isDirectory())
                {
                    deleteDirectoryContent(file[i]);
                }
                if (!file[i].delete())
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("File deletion failed for: ")).append(s).toString());
                } else
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("File deletion succeeded for: ")).append(s).toString());
                }
                i++;
            }
        }
    }

    void delete(File file, String s)
    {
        if (!file.canWrite())
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("File deletion failed for: ")).append(s).append(" not writable").toString());
            return;
        }
        if ("/".equalsIgnoreCase(s))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("File deletion failed for: ")).append(s).append(" cannot delete root").toString());
            return;
        }
        if (file.isDirectory())
        {
            deleteDirectoryContent(file);
        }
        if (!file.delete())
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("File deletion failed for: ")).append(s).toString());
            return;
        } else
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("File deletion succeeded for: ")).append(s).toString());
            return;
        }
    }

    public void run()
    {
        int i;
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "FileDeletionThread: run()");
        if (filesToDelete == null || filesToDelete.length == 0)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "File to delete not set or empty.  Returning");
            return;
        }
        i = 0;
_L2:
        if (i >= filesToDelete.length)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "FileDeletionThread: finished...");
            return;
        }
        if (!TextUtils.isEmpty(filesToDelete[i]))
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("FileDeletionThread: attempting deleted on ")).append(filesToDelete[i]).toString());
        File file = new File(filesToDelete[i]);
        if (!file.exists())
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("File deletion failed because it doesn't exist: ")).append(filesToDelete[i]).toString());
        } else
        if (!filesToDelete[i].contains("virtuoso/media"))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("Not an SDK file. File deletion failed for ")).append(filesToDelete[i]).toString());
        } else
        {
            delete(file, filesToDelete[i]);
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void setFilesToDelete(String as[])
    {
        filesToDelete = as;
    }

}
