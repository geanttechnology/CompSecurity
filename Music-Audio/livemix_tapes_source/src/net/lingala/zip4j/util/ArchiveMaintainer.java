// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import net.lingala.zip4j.core.HeaderReader;
import net.lingala.zip4j.core.HeaderWriter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip64EndCentralDirLocator;
import net.lingala.zip4j.model.Zip64EndCentralDirRecord;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;

// Referenced classes of package net.lingala.zip4j.util:
//            Zip4jUtil, Raw

public class ArchiveMaintainer
{

    public ArchiveMaintainer()
    {
    }

    private long calculateTotalWorkForMergeOp(ZipModel zipmodel)
        throws ZipException
    {
        long l;
        long l1;
        l = 0L;
        l1 = l;
        if (!zipmodel.isSplitArchive()) goto _L2; else goto _L1
_L1:
        String s1;
        int i;
        int j;
        j = zipmodel.getEndCentralDirRecord().getNoOfThisDisk();
        s1 = zipmodel.getZipFile();
        i = 0;
_L6:
        if (i <= j) goto _L4; else goto _L3
_L3:
        l1 = l;
_L2:
        return l1;
_L4:
        String s;
        if (zipmodel.getEndCentralDirRecord().getNoOfThisDisk() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s = zipmodel.getZipFile();
_L7:
        l += Zip4jUtil.getFileLengh(new File(s));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (9 >= 0)
        {
            s = s1.substring(0, s1.lastIndexOf(".")) + ".z" + 1;
        } else
        {
            s = s1.substring(0, s1.lastIndexOf(".")) + ".z0" + 1;
        }
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
    }

    private long calculateTotalWorkForRemoveOp(ZipModel zipmodel, FileHeader fileheader)
        throws ZipException
    {
        return Zip4jUtil.getFileLengh(new File(zipmodel.getZipFile())) - fileheader.getCompressedSize();
    }

    private void copyFile(RandomAccessFile randomaccessfile, OutputStream outputstream, long l, long l1, ProgressMonitor progressmonitor)
        throws ZipException
    {
        if (randomaccessfile == null || outputstream == null)
        {
            throw new ZipException("input or output stream is null, cannot copy file");
        }
        if (l < 0L)
        {
            throw new ZipException("starting offset is negative, cannot copy file");
        }
        if (l1 < 0L)
        {
            throw new ZipException("end offset is negative, cannot copy file");
        }
        if (l > l1)
        {
            throw new ZipException("start offset is greater than end offset, cannot copy file");
        }
        if (l != l1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (progressmonitor.isCancelAllTasks())
        {
            progressmonitor.setResult(3);
            progressmonitor.setState(0);
            return;
        }
        byte abyte0[];
        int i;
        long l2;
        long l3;
        try
        {
            randomaccessfile.seek(l);
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            throw new ZipException(randomaccessfile);
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            throw new ZipException(randomaccessfile);
        }
        l2 = 0L;
        l3 = l1 - l;
        if (l1 - l >= 4096L) goto _L4; else goto _L3
_L3:
        abyte0 = new byte[(int)(l1 - l)];
        l = l2;
_L7:
        i = randomaccessfile.read(abyte0);
        if (i == -1) goto _L1; else goto _L5
_L5:
        outputstream.write(abyte0, 0, i);
        progressmonitor.updateWorkCompleted(i);
        if (progressmonitor.isCancelAllTasks())
        {
            progressmonitor.setResult(3);
            return;
        }
          goto _L6
_L4:
        abyte0 = new byte[4096];
        l = l2;
          goto _L7
_L6:
        l1 = l + (long)i;
        if (l1 == l3) goto _L1; else goto _L8
_L8:
        l = l1;
        if ((long)abyte0.length + l1 <= l3) goto _L7; else goto _L9
_L9:
        abyte0 = new byte[(int)(l3 - l1)];
        l = l1;
          goto _L7
    }

    private RandomAccessFile createFileHandler(ZipModel zipmodel, String s)
        throws ZipException
    {
        if (zipmodel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(zipmodel.getZipFile()))
        {
            throw new ZipException("input parameter is null in getFilePointer, cannot create file handler to remove file");
        }
        try
        {
            zipmodel = new RandomAccessFile(new File(zipmodel.getZipFile()), s);
        }
        // Misplaced declaration of an exception variable
        catch (ZipModel zipmodel)
        {
            throw new ZipException(zipmodel);
        }
        return zipmodel;
    }

    private RandomAccessFile createSplitZipFileHandler(ZipModel zipmodel, int i)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null, cannot create split file handler");
        }
        if (i < 0)
        {
            throw new ZipException("invlaid part number, cannot create split file handler");
        }
        Object obj = zipmodel.getZipFile();
        if (i != zipmodel.getEndCentralDirRecord().getNoOfThisDisk()) goto _L2; else goto _L1
_L1:
        zipmodel = zipmodel.getZipFile();
_L3:
        obj = new File(zipmodel);
        if (!Zip4jUtil.checkFileExists(((File) (obj))))
        {
            throw new ZipException("split file does not exist: " + zipmodel);
        }
        break MISSING_BLOCK_LABEL_183;
_L2:
label0:
        {
            if (i < 9)
            {
                break label0;
            }
            try
            {
                zipmodel = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf(".")) + ".z" + (i + 1);
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                throw new ZipException(zipmodel);
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                throw new ZipException(zipmodel);
            }
        }
          goto _L3
        zipmodel = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf(".")) + ".z0" + (i + 1);
          goto _L3
        zipmodel = new RandomAccessFile(((File) (obj)), "r");
        return zipmodel;
    }

    private void initMergeSplitZipFile(ZipModel zipmodel, File file, ProgressMonitor progressmonitor)
        throws ZipException
    {
        File file1;
        OutputStream outputstream;
        File file2;
        File file3;
        OutputStream outputstream1;
        OutputStream outputstream2;
        OutputStream outputstream3;
        Long long1;
        byte abyte0[];
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        ArrayList arraylist;
        long l;
        boolean flag1;
        if (zipmodel == null)
        {
            zipmodel = new ZipException("one of the input parameters is null, cannot merge split zip file");
            progressmonitor.endProgressMonitorError(zipmodel);
            throw zipmodel;
        }
        if (!zipmodel.isSplitArchive())
        {
            zipmodel = new ZipException("archive not a split zip file");
            progressmonitor.endProgressMonitorError(zipmodel);
            throw zipmodel;
        }
        obj = null;
        obj1 = null;
        outputstream3 = null;
        obj2 = null;
        long1 = null;
        obj3 = null;
        abyte0 = null;
        arraylist = new ArrayList();
        l = 0L;
        flag1 = false;
        file2 = abyte0;
        outputstream1 = outputstream3;
        file1 = obj2;
        outputstream = obj;
        file3 = obj3;
        outputstream2 = obj1;
        int k = zipmodel.getEndCentralDirRecord().getNoOfThisDisk();
        if (k > 0)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        file2 = abyte0;
        outputstream1 = outputstream3;
        file1 = obj2;
        outputstream = obj;
        file3 = obj3;
        outputstream2 = obj1;
        throw new ZipException("corrupt zip model, archive not a split zip file");
        zipmodel;
        file1 = file2;
        outputstream = outputstream1;
        progressmonitor.endProgressMonitorError(zipmodel);
        file1 = file2;
        outputstream = outputstream1;
        throw new ZipException(zipmodel);
        zipmodel;
        IOException ioexception;
        int i;
        int j;
        boolean flag;
        boolean flag2;
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        if (file1 != null)
        {
            try
            {
                file1.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        throw zipmodel;
        file2 = abyte0;
        outputstream1 = outputstream3;
        file1 = obj2;
        outputstream = obj;
        file3 = obj3;
        outputstream2 = obj1;
        outputstream3 = prepareOutputStreamForMerge(file);
        i = 0;
        file = long1;
_L7:
        if (i <= k) goto _L2; else goto _L1
_L1:
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        zipmodel = (ZipModel)zipmodel.clone();
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        zipmodel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(l);
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        updateSplitZipModel(zipmodel, arraylist, flag1);
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        (new HeaderWriter()).finalizeZipFileWithoutValidations(zipmodel, outputstream3);
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        progressmonitor.endProgressMonitorSuccess();
        if (outputstream3 != null)
        {
            try
            {
                outputstream3.close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel) { }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_417;
        }
        file.close();
_L3:
        return;
_L2:
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        file = createSplitZipFileHandler(zipmodel, i);
        flag = false;
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        long1 = new Long(file.length());
        flag2 = flag1;
        j = ((flag) ? 1 : 0);
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        flag2 = flag1;
        j = ((flag) ? 1 : 0);
        file3 = file;
        outputstream2 = outputstream3;
        if (zipmodel.getCentralDirectory() == null)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        flag2 = flag1;
        j = ((flag) ? 1 : 0);
        file3 = file;
        outputstream2 = outputstream3;
        if (zipmodel.getCentralDirectory().getFileHeaders() == null)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        flag2 = flag1;
        j = ((flag) ? 1 : 0);
        file3 = file;
        outputstream2 = outputstream3;
        if (zipmodel.getCentralDirectory().getFileHeaders().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        abyte0 = new byte[4];
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        file.seek(0L);
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        file.read(abyte0);
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        flag2 = flag1;
        j = ((flag) ? 1 : 0);
        file3 = file;
        outputstream2 = outputstream3;
        if ((long)Raw.readIntLittleEndian(abyte0, 0) == 0x8074b50L)
        {
            j = 4;
            flag2 = true;
        }
        if (i != k)
        {
            break MISSING_BLOCK_LABEL_787;
        }
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        long1 = new Long(zipmodel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        copyFile(file, outputstream3, j, long1.longValue(), progressmonitor);
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        l += long1.longValue() - (long)j;
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        if (!progressmonitor.isCancelAllTasks())
        {
            break MISSING_BLOCK_LABEL_960;
        }
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        progressmonitor.setResult(3);
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        progressmonitor.setState(0);
        if (outputstream3 != null)
        {
            try
            {
                outputstream3.close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel) { }
        }
        if (file != null)
        {
            try
            {
                file.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                return;
            }
        }
          goto _L3
        file2 = file;
        outputstream1 = outputstream3;
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        arraylist.add(long1);
        file1 = file;
        outputstream = outputstream3;
        file3 = file;
        outputstream2 = outputstream3;
        file.close();
_L5:
        i++;
        flag1 = flag2;
        continue; /* Loop/switch isn't completed */
        zipmodel;
        file1 = file3;
        outputstream = outputstream2;
        progressmonitor.endProgressMonitorError(zipmodel);
        file1 = file3;
        outputstream = outputstream2;
        throw new ZipException(zipmodel);
        ioexception;
        if (true) goto _L5; else goto _L4
_L4:
        zipmodel;
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private OutputStream prepareOutputStreamForMerge(File file)
        throws ZipException
    {
        if (file == null)
        {
            throw new ZipException("outFile is null, cannot create outputstream");
        }
        try
        {
            file = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new ZipException(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new ZipException(file);
        }
        return file;
    }

    private void restoreFileName(File file, String s)
        throws ZipException
    {
        if (file.delete())
        {
            if (!(new File(s)).renameTo(file))
            {
                throw new ZipException("cannot rename modified zip file");
            } else
            {
                return;
            }
        } else
        {
            throw new ZipException("cannot delete old zip file");
        }
    }

    private void updateSplitEndCentralDirectory(ZipModel zipmodel)
        throws ZipException
    {
        if (zipmodel == null)
        {
            try
            {
                throw new ZipException("zip model is null - cannot update end of central directory for split zip model");
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                throw zipmodel;
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                throw new ZipException(zipmodel);
            }
        }
        if (zipmodel.getCentralDirectory() == null)
        {
            throw new ZipException("corrupt zip model - getCentralDirectory, cannot update split zip model");
        }
        zipmodel.getEndCentralDirRecord().setNoOfThisDisk(0);
        zipmodel.getEndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
        zipmodel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDir(zipmodel.getCentralDirectory().getFileHeaders().size());
        zipmodel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipmodel.getCentralDirectory().getFileHeaders().size());
        return;
    }

    private void updateSplitFileHeader(ZipModel zipmodel, ArrayList arraylist, boolean flag)
        throws ZipException
    {
        int j;
        int k;
        int l;
        long l1;
        try
        {
            if (zipmodel.getCentralDirectory() == null)
            {
                throw new ZipException("corrupt zip model - getCentralDirectory, cannot update split zip model");
            }
        }
        // Misplaced declaration of an exception variable
        catch (ZipModel zipmodel)
        {
            throw zipmodel;
        }
        // Misplaced declaration of an exception variable
        catch (ZipModel zipmodel)
        {
            throw new ZipException(zipmodel);
        }
        l = zipmodel.getCentralDirectory().getFileHeaders().size();
        break MISSING_BLOCK_LABEL_33;
_L5:
        if (k < ((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(j)).getDiskNumberStart()) goto _L2; else goto _L1
_L1:
        ((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(j)).setOffsetLocalHeader((((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(j)).getOffsetLocalHeader() + l1) - (long)i);
        ((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(j)).setDiskNumberStart(0);
        j++;
          goto _L3
_L2:
        l2 = ((Long)arraylist.get(k)).longValue();
        l1 += l2;
        k++;
        continue; /* Loop/switch isn't completed */
        int i = 0;
        long l2;
        if (flag)
        {
            i = 4;
        }
        j = 0;
_L3:
        if (j >= l)
        {
            return;
        }
        l1 = 0L;
        k = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void updateSplitZip64EndCentralDirLocator(ZipModel zipmodel, ArrayList arraylist)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null, cannot update split Zip64 end of central directory locator");
        }
        if (zipmodel.getZip64EndCentralDirLocator() == null)
        {
            return;
        }
        zipmodel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(0);
        long l = 0L;
        int i = 0;
        do
        {
            if (i >= arraylist.size())
            {
                zipmodel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(zipmodel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec() + l);
                zipmodel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1);
                return;
            }
            l += ((Long)arraylist.get(i)).longValue();
            i++;
        } while (true);
    }

    private void updateSplitZip64EndCentralDirRec(ZipModel zipmodel, ArrayList arraylist)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null, cannot update split Zip64 end of central directory record");
        }
        if (zipmodel.getZip64EndCentralDirRecord() == null)
        {
            return;
        }
        zipmodel.getZip64EndCentralDirRecord().setNoOfThisDisk(0);
        zipmodel.getZip64EndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
        zipmodel.getZip64EndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipmodel.getEndCentralDirRecord().getTotNoOfEntriesInCentralDir());
        long l = 0L;
        int i = 0;
        do
        {
            if (i >= arraylist.size())
            {
                zipmodel.getZip64EndCentralDirRecord().setOffsetStartCenDirWRTStartDiskNo(zipmodel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo() + l);
                return;
            }
            l += ((Long)arraylist.get(i)).longValue();
            i++;
        } while (true);
    }

    private void updateSplitZipModel(ZipModel zipmodel, ArrayList arraylist, boolean flag)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null, cannot update split zip model");
        }
        zipmodel.setSplitArchive(false);
        updateSplitFileHeader(zipmodel, arraylist, flag);
        updateSplitEndCentralDirectory(zipmodel);
        if (zipmodel.isZip64Format())
        {
            updateSplitZip64EndCentralDirLocator(zipmodel, arraylist);
            updateSplitZip64EndCentralDirRec(zipmodel, arraylist);
        }
    }

    public void initProgressMonitorForMergeOp(ZipModel zipmodel, ProgressMonitor progressmonitor)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null, cannot calculate total work for merge op");
        } else
        {
            progressmonitor.setCurrentOperation(4);
            progressmonitor.setFileName(zipmodel.getZipFile());
            progressmonitor.setTotalWork(calculateTotalWorkForMergeOp(zipmodel));
            progressmonitor.setState(1);
            return;
        }
    }

    public void initProgressMonitorForRemoveOp(ZipModel zipmodel, FileHeader fileheader, ProgressMonitor progressmonitor)
        throws ZipException
    {
        if (zipmodel == null || fileheader == null || progressmonitor == null)
        {
            throw new ZipException("one of the input parameters is null, cannot calculate total work");
        } else
        {
            progressmonitor.setCurrentOperation(2);
            progressmonitor.setFileName(fileheader.getFileName());
            progressmonitor.setTotalWork(calculateTotalWorkForRemoveOp(zipmodel, fileheader));
            progressmonitor.setState(1);
            return;
        }
    }

    public HashMap initRemoveZipFile(ZipModel zipmodel, FileHeader fileheader, ProgressMonitor progressmonitor)
        throws ZipException
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        FileHeader fileheader1;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        HashMap hashmap;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        if (fileheader == null || zipmodel == null)
        {
            throw new ZipException("input parameters is null in maintain zip file, cannot remove file from archive");
        }
        obj13 = null;
        obj5 = null;
        obj8 = null;
        fileheader1 = null;
        obj14 = null;
        obj6 = null;
        obj9 = null;
        obj12 = null;
        obj11 = null;
        obj10 = null;
        obj7 = null;
        flag = false;
        flag6 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        flag1 = false;
        obj4 = null;
        obj15 = null;
        obj = null;
        hashmap = new HashMap();
        obj2 = obj;
        obj3 = obj4;
        obj1 = obj15;
        int i = Zip4jUtil.getIndexOfFileHeader(zipmodel, fileheader);
        if (i >= 0) goto _L2; else goto _L1
_L1:
        obj2 = obj;
        obj3 = obj4;
        obj1 = obj15;
        throw new ZipException("file header not found in zip model, cannot remove file");
        fileheader;
        obj4 = null;
        obj6 = fileheader1;
        obj = obj2;
        zipmodel = obj7;
_L5:
        obj1 = zipmodel;
        obj2 = obj4;
        flag = flag1;
        obj3 = obj;
        obj5 = obj6;
        progressmonitor.endProgressMonitorError(fileheader);
        obj1 = zipmodel;
        obj2 = obj4;
        flag = flag1;
        obj3 = obj;
        obj5 = obj6;
        throw fileheader;
        zipmodel;
        obj = obj3;
        obj3 = obj1;
_L7:
        long l;
        long l1;
        long l2;
        long l3;
        boolean flag7;
        if (obj3 != null)
        {
            try
            {
                ((RandomAccessFile) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                throw new ZipException("cannot close input stream or output stream when trying to delete a file from zip file");
            }
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        ((OutputStream) (obj2)).close();
        if (flag)
        {
            restoreFileName(((File) (obj5)), ((String) (obj)));
        } else
        {
            (new File(((String) (obj)))).delete();
        }
        throw zipmodel;
_L2:
        obj2 = obj;
        obj3 = obj4;
        obj1 = obj15;
        if (!zipmodel.isSplitArchive()) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        obj3 = obj4;
        obj1 = obj15;
        throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        fileheader;
        obj4 = null;
        obj6 = obj8;
        obj = obj3;
        flag1 = flag2;
        zipmodel = obj9;
_L20:
        obj1 = zipmodel;
        obj2 = obj4;
        flag = flag1;
        obj3 = obj;
        obj5 = obj6;
        progressmonitor.endProgressMonitorError(fileheader);
        obj1 = zipmodel;
        obj2 = obj4;
        flag = flag1;
        obj3 = obj;
        obj5 = obj6;
        throw new ZipException(fileheader);
_L4:
        obj2 = obj;
        obj3 = obj4;
        obj1 = obj15;
        l = System.currentTimeMillis();
        obj2 = obj;
        obj3 = obj4;
        obj1 = obj15;
        obj = zipmodel.getZipFile() + l % 1000L;
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        obj4 = new File(((String) (obj)));
_L6:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag7 = ((File) (obj4)).exists();
        if (flag7)
        {
            break MISSING_BLOCK_LABEL_637;
        }
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        obj4 = new SplitOutputStream(new File(((String) (obj))));
        obj1 = obj14;
        obj2 = obj4;
        obj3 = obj;
        obj5 = obj13;
        obj6 = new File(zipmodel.getZipFile());
        obj1 = obj12;
        flag = flag3;
        obj2 = obj11;
        flag1 = flag4;
        obj3 = obj10;
        flag2 = flag5;
        obj5 = createFileHandler(zipmodel, "r");
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if ((new HeaderReader(((RandomAccessFile) (obj5)))).readLocalFileHeader(fileheader) != null)
        {
            break MISSING_BLOCK_LABEL_761;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        throw new ZipException("invalid local file header, cannot remove file from archive");
        fileheader;
        zipmodel = ((ZipModel) (obj1));
        flag1 = flag;
          goto _L5
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        l = System.currentTimeMillis();
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        obj = zipmodel.getZipFile() + l % 1000L;
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        obj4 = new File(((String) (obj)));
          goto _L6
        zipmodel;
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        throw new ZipException(zipmodel);
        zipmodel;
        obj2 = null;
        obj3 = obj6;
        flag = flag6;
        obj = obj1;
          goto _L7
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l = fileheader.getOffsetLocalHeader();
        obj1 = obj5;
        flag = flag3;
        l1 = l;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (fileheader.getZip64ExtendedInfo() == null)
        {
            break MISSING_BLOCK_LABEL_901;
        }
        obj1 = obj5;
        flag = flag3;
        l1 = l;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (fileheader.getZip64ExtendedInfo().getOffsetLocalHeader() == -1L)
        {
            break MISSING_BLOCK_LABEL_901;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l1 = fileheader.getZip64ExtendedInfo().getOffsetLocalHeader();
        l = -1L;
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l3 = zipmodel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir();
        obj1 = obj5;
        flag = flag3;
        l2 = l3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (!zipmodel.isZip64Format())
        {
            break MISSING_BLOCK_LABEL_1042;
        }
        obj1 = obj5;
        flag = flag3;
        l2 = l3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (zipmodel.getZip64EndCentralDirRecord() == null)
        {
            break MISSING_BLOCK_LABEL_1042;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l2 = zipmodel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo();
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        fileheader = zipmodel.getCentralDirectory().getFileHeaders();
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (i != fileheader.size() - 1) goto _L9; else goto _L8
_L8:
        l = l2 - 1L;
          goto _L10
_L21:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        throw new ZipException("invalid offset for start and end of local file, cannot remove file");
_L9:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        fileheader1 = (FileHeader)fileheader.get(i + 1);
        if (fileheader1 == null) goto _L10; else goto _L11
_L11:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l3 = fileheader1.getOffsetLocalHeader() - 1L;
        obj1 = obj5;
        flag = flag3;
        l = l3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (fileheader1.getZip64ExtendedInfo() == null) goto _L10; else goto _L12
_L12:
        obj1 = obj5;
        flag = flag3;
        l = l3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (fileheader1.getZip64ExtendedInfo().getOffsetLocalHeader() == -1L) goto _L10; else goto _L13
_L13:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l = fileheader1.getZip64ExtendedInfo().getOffsetLocalHeader() - 1L;
          goto _L10
_L22:
        if (i != 0) goto _L15; else goto _L14
_L14:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (zipmodel.getCentralDirectory().getFileHeaders().size() <= 1)
        {
            break MISSING_BLOCK_LABEL_1428;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        copyFile(((RandomAccessFile) (obj5)), ((OutputStream) (obj4)), 1L + l, l2, progressmonitor);
_L17:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (!progressmonitor.isCancelAllTasks())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        progressmonitor.setResult(3);
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        progressmonitor.setState(0);
        if (obj5 != null)
        {
            try
            {
                ((RandomAccessFile) (obj5)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                throw new ZipException("cannot close input stream or output stream when trying to delete a file from zip file");
            }
        }
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_1537;
        }
        ((OutputStream) (obj4)).close();
        if (false)
        {
            restoreFileName(((File) (obj6)), ((String) (obj)));
        } else
        {
            (new File(((String) (obj)))).delete();
        }
        return null;
_L15:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (i != fileheader.size() - 1)
        {
            break MISSING_BLOCK_LABEL_1625;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        copyFile(((RandomAccessFile) (obj5)), ((OutputStream) (obj4)), 0L, l1, progressmonitor);
        continue; /* Loop/switch isn't completed */
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        copyFile(((RandomAccessFile) (obj5)), ((OutputStream) (obj4)), 0L, l1, progressmonitor);
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        copyFile(((RandomAccessFile) (obj5)), ((OutputStream) (obj4)), 1L + l, l2, progressmonitor);
        if (true) goto _L17; else goto _L16
_L16:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        zipmodel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(((SplitOutputStream)obj4).getFilePointer());
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        zipmodel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDir(zipmodel.getEndCentralDirRecord().getTotNoOfEntriesInCentralDir() - 1);
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        zipmodel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipmodel.getEndCentralDirRecord().getTotNoOfEntriesInCentralDirOnThisDisk() - 1);
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        zipmodel.getCentralDirectory().getFileHeaders().remove(i);
_L19:
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (i < zipmodel.getCentralDirectory().getFileHeaders().size())
        {
            break MISSING_BLOCK_LABEL_2038;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        (new HeaderWriter()).finalizeZipFile(zipmodel, ((OutputStream) (obj4)));
        flag1 = true;
        flag2 = true;
        flag = true;
        obj1 = obj5;
        obj2 = obj5;
        obj3 = obj5;
        hashmap.put("offsetCentralDir", Long.toString(zipmodel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir()));
        if (obj5 != null)
        {
            try
            {
                ((RandomAccessFile) (obj5)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipModel zipmodel)
            {
                throw new ZipException("cannot close input stream or output stream when trying to delete a file from zip file");
            }
        }
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_2023;
        }
        ((OutputStream) (obj4)).close();
        if (true)
        {
            restoreFileName(((File) (obj6)), ((String) (obj)));
            return hashmap;
        } else
        {
            (new File(((String) (obj)))).delete();
            return hashmap;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l3 = ((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(i)).getOffsetLocalHeader();
        obj1 = obj5;
        flag = flag3;
        l2 = l3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(i)).getZip64ExtendedInfo() == null)
        {
            break MISSING_BLOCK_LABEL_2234;
        }
        obj1 = obj5;
        flag = flag3;
        l2 = l3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        if (((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(i)).getZip64ExtendedInfo().getOffsetLocalHeader() == -1L)
        {
            break MISSING_BLOCK_LABEL_2234;
        }
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        l2 = ((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(i)).getZip64ExtendedInfo().getOffsetLocalHeader();
        obj1 = obj5;
        flag = flag3;
        obj2 = obj5;
        flag1 = flag4;
        obj3 = obj5;
        flag2 = flag5;
        ((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(i)).setOffsetLocalHeader(l2 - (l - l1) - 1L);
        i++;
        if (true) goto _L19; else goto _L18
_L18:
        fileheader;
        zipmodel = obj9;
        flag1 = flag2;
        obj6 = obj8;
          goto _L20
        fileheader;
        zipmodel = obj7;
        obj6 = fileheader1;
          goto _L5
_L10:
        if (l1 >= 0L && l >= 0L) goto _L22; else goto _L21
        fileheader;
        zipmodel = ((ZipModel) (obj2));
          goto _L20
        zipmodel;
        obj5 = obj6;
        obj2 = obj4;
        flag = flag2;
          goto _L7
    }

    public void mergeSplitZipFiles(ZipModel zipmodel, File file, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        if (flag)
        {
            (new _cls2(progressmonitor)).start();
            return;
        } else
        {
            initMergeSplitZipFile(zipmodel, file, progressmonitor);
            return;
        }
    }

    public HashMap removeZipFile(ZipModel zipmodel, FileHeader fileheader, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        if (flag)
        {
            (new _cls1(progressmonitor)).start();
            return null;
        } else
        {
            zipmodel = initRemoveZipFile(zipmodel, fileheader, progressmonitor);
            progressmonitor.endProgressMonitorSuccess();
            return zipmodel;
        }
    }

    public void setComment(ZipModel zipmodel, String s)
        throws ZipException
    {
        Object obj;
        String s1;
        int i;
        if (s == null)
        {
            throw new ZipException("comment is null, cannot update Zip file with comment");
        }
        if (zipmodel == null)
        {
            throw new ZipException("zipModel is null, cannot update Zip file with comment");
        }
        s1 = s;
        obj = s.getBytes();
        i = s.length();
        if (!Zip4jUtil.isSupportedCharset("windows-1254"))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s1 = new String(s.getBytes("windows-1254"), "windows-1254");
        obj = s1.getBytes("windows-1254");
        i = s1.length();
_L2:
        if (i > 65535)
        {
            throw new ZipException("comment length exceeds maximum length");
        }
        break; /* Loop/switch isn't completed */
        obj;
_L8:
        s1 = s;
        obj = s.getBytes();
        i = s.length();
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        zipmodel.getEndCentralDirRecord().setComment(s1);
        zipmodel.getEndCentralDirRecord().setCommentBytes(((byte []) (obj)));
        zipmodel.getEndCentralDirRecord().setCommentLength(i);
        obj = null;
        obj1 = null;
        s1 = null;
        s = ((String) (obj));
        HeaderWriter headerwriter = new HeaderWriter();
        s = ((String) (obj));
        obj = new SplitOutputStream(zipmodel.getZipFile());
        if (!zipmodel.isZip64Format())
        {
            break MISSING_BLOCK_LABEL_218;
        }
        ((SplitOutputStream) (obj)).seek(zipmodel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo());
_L3:
        headerwriter.finalizeZipFileWithoutValidations(zipmodel, ((OutputStream) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        ((SplitOutputStream) (obj)).close();
        return;
        ((SplitOutputStream) (obj)).seek(zipmodel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
          goto _L3
        zipmodel;
        s = ((String) (obj));
_L7:
        throw new ZipException(zipmodel);
        zipmodel;
_L4:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw zipmodel;
        zipmodel;
        s = obj1;
_L5:
        throw new ZipException(zipmodel);
        zipmodel;
        return;
        zipmodel;
        s = ((String) (obj));
          goto _L4
        zipmodel;
        s = ((String) (obj));
          goto _L5
        zipmodel;
        s = s1;
        if (true) goto _L7; else goto _L6
_L6:
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
          goto _L8
    }


    private class _cls2 extends Thread
    {

        final ArchiveMaintainer this$0;
        private final File val$outputZipFile;
        private final ProgressMonitor val$progressMonitor;
        private final ZipModel val$zipModel;

        public void run()
        {
            try
            {
                initMergeSplitZipFile(zipModel, outputZipFile, progressMonitor);
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
            this$0 = ArchiveMaintainer.this;
            zipModel = zipmodel;
            outputZipFile = file;
            progressMonitor = progressmonitor;
        }
    }


    private class _cls1 extends Thread
    {

        final ArchiveMaintainer this$0;
        private final FileHeader val$fileHeader;
        private final ProgressMonitor val$progressMonitor;
        private final ZipModel val$zipModel;

        public void run()
        {
            try
            {
                initRemoveZipFile(zipModel, fileHeader, progressMonitor);
                progressMonitor.endProgressMonitorSuccess();
                return;
            }
            catch (ZipException zipexception)
            {
                return;
            }
        }

        _cls1(ProgressMonitor progressmonitor)
        {
            super(final_s);
            this$0 = ArchiveMaintainer.this;
            zipModel = zipmodel;
            fileHeader = fileheader;
            progressMonitor = progressmonitor;
        }
    }

}
