// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.util;

import java.io.File;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;

// Referenced classes of package net.lingala.zip4j.util:
//            ArchiveMaintainer

class val.progressMonitor extends Thread
{

    final ArchiveMaintainer this$0;
    private final File val$outputZipFile;
    private final ProgressMonitor val$progressMonitor;
    private final ZipModel val$zipModel;

    public void run()
    {
        try
        {
            ArchiveMaintainer.access$0(ArchiveMaintainer.this, val$zipModel, val$outputZipFile, val$progressMonitor);
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
        val$outputZipFile = File.this;
        val$progressMonitor = progressmonitor;
    }
}
