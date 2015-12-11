// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.manager;


// Referenced classes of package com.penthera.virtuososdk.manager:
//            FileDeletionThread

public class FileManager
{

    private static String LOG_TAG = com/penthera/virtuososdk/manager/FileManager.getName();

    public FileManager()
    {
    }

    public void remove(String s)
    {
        remove(new String[] {
            s
        });
    }

    public void remove(String as[])
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "Removing files from disk: ");
        FileDeletionThread filedeletionthread = new FileDeletionThread();
        filedeletionthread.setFilesToDelete(as);
        filedeletionthread.start();
    }

}
