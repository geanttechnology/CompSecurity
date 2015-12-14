// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.util;

import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;

// Referenced classes of package net.lingala.zip4j.util:
//            ArchiveMaintainer

class val.progressMonitor extends Thread
{

    final ArchiveMaintainer this$0;
    private final FileHeader val$fileHeader;
    private final ProgressMonitor val$progressMonitor;
    private final ZipModel val$zipModel;

    public void run()
    {
        try
        {
            initRemoveZipFile(val$zipModel, val$fileHeader, val$progressMonitor);
            val$progressMonitor.endProgressMonitorSuccess();
            return;
        }
        catch (ZipException zipexception)
        {
            return;
        }
    }

    (ProgressMonitor progressmonitor)
    {
        super(final_s);
        this$0 = final_archivemaintainer;
        val$zipModel = zipmodel;
        val$fileHeader = FileHeader.this;
        val$progressMonitor = progressmonitor;
    }
}
