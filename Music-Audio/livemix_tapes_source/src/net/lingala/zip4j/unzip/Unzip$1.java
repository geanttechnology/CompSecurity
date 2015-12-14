// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.unzip;

import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;

// Referenced classes of package net.lingala.zip4j.unzip:
//            Unzip

class val.outPath extends Thread
{

    final Unzip this$0;
    private final ArrayList val$fileHeaders;
    private final String val$outPath;
    private final ProgressMonitor val$progressMonitor;
    private final UnzipParameters val$unzipParameters;

    public void run()
    {
        try
        {
            Unzip.access$0(Unzip.this, val$fileHeaders, val$unzipParameters, val$progressMonitor, val$outPath);
            val$progressMonitor.endProgressMonitorSuccess();
            return;
        }
        catch (ZipException zipexception)
        {
            return;
        }
    }

    essMonitor(String s1)
    {
        super(final_s);
        this$0 = final_unzip;
        val$fileHeaders = arraylist;
        val$unzipParameters = unzipparameters;
        val$progressMonitor = ProgressMonitor.this;
        val$outPath = s1;
    }
}
