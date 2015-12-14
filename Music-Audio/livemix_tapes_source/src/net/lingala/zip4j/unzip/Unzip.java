// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.unzip;

import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

// Referenced classes of package net.lingala.zip4j.unzip:
//            UnzipEngine

public class Unzip
{

    private ZipModel zipModel;

    public Unzip(ZipModel zipmodel)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("ZipModel is null");
        } else
        {
            zipModel = zipmodel;
            return;
        }
    }

    private long calculateTotalWork(ArrayList arraylist)
        throws ZipException
    {
        if (arraylist == null)
        {
            throw new ZipException("fileHeaders is null, cannot calculate total work");
        }
        long l = 0L;
        int i = 0;
        do
        {
            if (i >= arraylist.size())
            {
                return l;
            }
            FileHeader fileheader = (FileHeader)arraylist.get(i);
            if (fileheader.getZip64ExtendedInfo() != null && fileheader.getZip64ExtendedInfo().getUnCompressedSize() > 0L)
            {
                l += fileheader.getZip64ExtendedInfo().getCompressedSize();
            } else
            {
                l += fileheader.getCompressedSize();
            }
            i++;
        } while (true);
    }

    private void checkOutputDirectoryStructure(FileHeader fileheader, String s, String s1)
        throws ZipException
    {
        if (fileheader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("Cannot check output directory structure...one of the parameters was null");
        }
        fileheader = fileheader.getFileName();
        if (Zip4jUtil.isStringNotNullAndNotEmpty(s1))
        {
            fileheader = s1;
        }
        if (Zip4jUtil.isStringNotNullAndNotEmpty(fileheader))
        {
            fileheader = s + fileheader;
            try
            {
                fileheader = new File((new File(fileheader)).getParent());
                if (!fileheader.exists())
                {
                    fileheader.mkdirs();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (FileHeader fileheader)
            {
                throw new ZipException(fileheader);
            }
        }
    }

    private void initExtractAll(ArrayList arraylist, UnzipParameters unzipparameters, ProgressMonitor progressmonitor, String s)
        throws ZipException
    {
        int i = 0;
        do
        {
            if (i >= arraylist.size())
            {
                return;
            }
            initExtractFile((FileHeader)arraylist.get(i), s, unzipparameters, null, progressmonitor);
            if (progressmonitor.isCancelAllTasks())
            {
                progressmonitor.setResult(3);
                progressmonitor.setState(0);
                return;
            }
            i++;
        } while (true);
    }

    private void initExtractFile(FileHeader fileheader, String s, UnzipParameters unzipparameters, String s1, ProgressMonitor progressmonitor)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("fileHeader is null");
        }
        progressmonitor.setFileName(fileheader.getFileName());
        String s2 = s;
        boolean flag;
        if (!s.endsWith(InternalZipConstants.FILE_SEPARATOR))
        {
            s2 = s + InternalZipConstants.FILE_SEPARATOR;
        }
        flag = fileheader.isDirectory();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        fileheader = fileheader.getFileName();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(fileheader))
        {
            return;
        }
        fileheader = new File(s2 + fileheader);
        if (!fileheader.exists())
        {
            fileheader.mkdirs();
            return;
        }
        break MISSING_BLOCK_LABEL_213;
        fileheader;
        try
        {
            progressmonitor.endProgressMonitorError(fileheader);
            throw new ZipException(fileheader);
        }
        // Misplaced declaration of an exception variable
        catch (FileHeader fileheader)
        {
            progressmonitor.endProgressMonitorError(fileheader);
            throw fileheader;
        }
        // Misplaced declaration of an exception variable
        catch (FileHeader fileheader)
        {
            progressmonitor.endProgressMonitorError(fileheader);
        }
        break MISSING_BLOCK_LABEL_204;
        checkOutputDirectoryStructure(fileheader, s2, s1);
        fileheader = new UnzipEngine(zipModel, fileheader);
        try
        {
            fileheader.unzipFile(progressmonitor, s2, s1, unzipparameters);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FileHeader fileheader) { }
        progressmonitor.endProgressMonitorError(fileheader);
        throw new ZipException(fileheader);
        throw new ZipException(fileheader);
    }

    public void extractAll(UnzipParameters unzipparameters, String s, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        Object obj = zipModel.getCentralDirectory();
        if (obj == null || ((CentralDirectory) (obj)).getFileHeaders() == null)
        {
            throw new ZipException("invalid central directory in zipModel");
        }
        obj = ((CentralDirectory) (obj)).getFileHeaders();
        progressmonitor.setCurrentOperation(1);
        progressmonitor.setTotalWork(calculateTotalWork(((ArrayList) (obj))));
        progressmonitor.setState(1);
        if (flag)
        {
            (new _cls1(s)).start();
            return;
        } else
        {
            initExtractAll(((ArrayList) (obj)), unzipparameters, progressmonitor, s);
            return;
        }
    }

    public void extractFile(FileHeader fileheader, String s, UnzipParameters unzipparameters, String s1, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("fileHeader is null");
        }
        progressmonitor.setCurrentOperation(1);
        progressmonitor.setTotalWork(fileheader.getCompressedSize());
        progressmonitor.setState(1);
        progressmonitor.setPercentDone(0);
        progressmonitor.setFileName(fileheader.getFileName());
        if (flag)
        {
            (new _cls2(progressmonitor)).start();
            return;
        } else
        {
            initExtractFile(fileheader, s, unzipparameters, s1, progressmonitor);
            progressmonitor.endProgressMonitorSuccess();
            return;
        }
    }

    public ZipInputStream getInputStream(FileHeader fileheader)
        throws ZipException
    {
        return (new UnzipEngine(zipModel, fileheader)).getInputStream();
    }



    private class _cls1 extends Thread
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
                initExtractAll(fileHeaders, unzipParameters, progressMonitor, outPath);
                progressMonitor.endProgressMonitorSuccess();
                return;
            }
            catch (ZipException zipexception)
            {
                return;
            }
        }

        _cls1(String s1)
        {
            super(final_s);
            this$0 = Unzip.this;
            fileHeaders = arraylist;
            unzipParameters = unzipparameters;
            progressMonitor = progressmonitor;
            outPath = s1;
        }
    }


    private class _cls2 extends Thread
    {

        final Unzip this$0;
        private final FileHeader val$fileHeader;
        private final String val$newFileName;
        private final String val$outPath;
        private final ProgressMonitor val$progressMonitor;
        private final UnzipParameters val$unzipParameters;

        public void run()
        {
            try
            {
                initExtractFile(fileHeader, outPath, unzipParameters, newFileName, progressMonitor);
                progressMonitor.endProgressMonitorSuccess();
                return;
            }
            catch (ZipException zipexception)
            {
                return;
            }
        }

        _cls2(ProgressMonitor progressmonitor)
        {
            super(final_s);
            this$0 = Unzip.this;
            fileHeader = fileheader;
            outPath = s1;
            unzipParameters = unzipparameters;
            newFileName = s2;
            progressMonitor = progressmonitor;
        }
    }

}
