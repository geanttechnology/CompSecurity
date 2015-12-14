// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.CRCUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipEngine
{

    private ZipModel zipModel;

    public ZipEngine(ZipModel zipmodel)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null in ZipEngine constructor");
        } else
        {
            zipModel = zipmodel;
            return;
        }
    }

    private long calculateTotalWork(ArrayList arraylist, ZipParameters zipparameters)
        throws ZipException
    {
        if (arraylist == null)
        {
            throw new ZipException("file list is null, cannot calculate total work");
        }
        long l1 = 0L;
        int i = 0;
        do
        {
            if (i >= arraylist.size())
            {
                return l1;
            }
            long l = l1;
            if (arraylist.get(i) instanceof File)
            {
                l = l1;
                if (((File)arraylist.get(i)).exists())
                {
                    if (zipparameters.isEncryptFiles() && zipparameters.getEncryptionMethod() == 0)
                    {
                        l1 += Zip4jUtil.getFileLengh((File)arraylist.get(i)) * 2L;
                    } else
                    {
                        l1 += Zip4jUtil.getFileLengh((File)arraylist.get(i));
                    }
                    l = l1;
                    if (zipModel.getCentralDirectory() != null)
                    {
                        l = l1;
                        if (zipModel.getCentralDirectory().getFileHeaders() != null)
                        {
                            l = l1;
                            if (zipModel.getCentralDirectory().getFileHeaders().size() > 0)
                            {
                                Object obj = Zip4jUtil.getRelativeFileName(((File)arraylist.get(i)).getAbsolutePath(), zipparameters.getRootFolderInZip(), zipparameters.getDefaultFolderPath());
                                obj = Zip4jUtil.getFileHeader(zipModel, ((String) (obj)));
                                l = l1;
                                if (obj != null)
                                {
                                    l = l1 + (Zip4jUtil.getFileLengh(new File(zipModel.getZipFile())) - ((FileHeader) (obj)).getCompressedSize());
                                }
                            }
                        }
                    }
                }
            }
            i++;
            l1 = l;
        } while (true);
    }

    private void checkParameters(ZipParameters zipparameters)
        throws ZipException
    {
        if (zipparameters == null)
        {
            throw new ZipException("cannot validate zip parameters");
        }
        if (zipparameters.getCompressionMethod() != 0 && zipparameters.getCompressionMethod() != 8)
        {
            throw new ZipException("unsupported compression type");
        }
        if (zipparameters.getCompressionMethod() == 8 && zipparameters.getCompressionLevel() < 0 && zipparameters.getCompressionLevel() > 9)
        {
            throw new ZipException("invalid compression level. compression level dor deflate should be in the range of 0-9");
        }
        if (zipparameters.isEncryptFiles())
        {
            if (zipparameters.getEncryptionMethod() != 0 && zipparameters.getEncryptionMethod() != 99)
            {
                throw new ZipException("unsupported encryption method");
            }
            if (zipparameters.getPassword() == null || zipparameters.getPassword().length <= 0)
            {
                throw new ZipException("input password is empty or null");
            }
        } else
        {
            zipparameters.setAesKeyStrength(-1);
            zipparameters.setEncryptionMethod(-1);
        }
    }

    private EndCentralDirRecord createEndOfCentralDirectoryRecord()
    {
        EndCentralDirRecord endcentraldirrecord = new EndCentralDirRecord();
        endcentraldirrecord.setSignature(0x6054b50L);
        endcentraldirrecord.setNoOfThisDisk(0);
        endcentraldirrecord.setTotNoOfEntriesInCentralDir(0);
        endcentraldirrecord.setTotNoOfEntriesInCentralDirOnThisDisk(0);
        endcentraldirrecord.setOffsetOfStartOfCentralDir(0L);
        return endcentraldirrecord;
    }

    private void initAddFiles(ArrayList arraylist, ZipParameters zipparameters, ProgressMonitor progressmonitor)
        throws ZipException
    {
        Object obj;
        Object obj1;
        Object obj2;
        FileInputStream fileinputstream;
        FileInputStream fileinputstream1;
        byte abyte0[];
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        if (arraylist == null || zipparameters == null)
        {
            throw new ZipException("one of the input parameters is null when adding files");
        }
        if (arraylist.size() <= 0)
        {
            throw new ZipException("no files to add");
        }
        if (zipModel.getEndCentralDirRecord() == null)
        {
            zipModel.setEndCentralDirRecord(createEndOfCentralDirectoryRecord());
        }
        obj = null;
        fileinputstream1 = null;
        fileinputstream = null;
        obj6 = null;
        obj8 = null;
        obj4 = null;
        obj7 = null;
        obj5 = null;
        abyte0 = null;
        obj1 = obj8;
        obj2 = obj;
        checkParameters(zipparameters);
        obj1 = obj8;
        obj2 = obj;
        removeFilesIfExists(arraylist, zipparameters, progressmonitor);
        obj1 = obj8;
        obj2 = obj;
        boolean flag = Zip4jUtil.checkFileExists(zipModel.getZipFile());
        obj1 = obj8;
        obj2 = obj;
        SplitOutputStream splitoutputstream = new SplitOutputStream(new File(zipModel.getZipFile()), zipModel.getSplitLength());
        obj1 = obj8;
        obj2 = obj;
        obj = new ZipOutputStream(splitoutputstream, zipModel);
        if (!flag) goto _L2; else goto _L1
_L1:
        obj1 = abyte0;
        fileinputstream = obj4;
        fileinputstream1 = obj5;
        if (zipModel.getEndCentralDirRecord() != null) goto _L4; else goto _L3
_L3:
        obj1 = abyte0;
        fileinputstream = obj4;
        fileinputstream1 = obj5;
        throw new ZipException("invalid end of central directory record");
        obj2;
        zipparameters = ((ZipParameters) (obj));
        arraylist = ((ArrayList) (obj1));
        obj = obj2;
_L22:
        obj1 = arraylist;
        obj2 = zipparameters;
        progressmonitor.endProgressMonitorError(((Throwable) (obj)));
        obj1 = arraylist;
        obj2 = zipparameters;
        throw obj;
        arraylist;
_L18:
        int i;
        int j;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipParameters zipparameters) { }
        }
        if (obj2 != null)
        {
            try
            {
                ((ZipOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipParameters zipparameters) { }
        }
        throw arraylist;
_L4:
        obj1 = abyte0;
        fileinputstream = obj4;
        fileinputstream1 = obj5;
        splitoutputstream.seek(zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
_L2:
        obj1 = abyte0;
        fileinputstream = obj4;
        fileinputstream1 = obj5;
        abyte0 = new byte[4096];
        i = 0;
        obj1 = null;
_L23:
        if (i < arraylist.size()) goto _L6; else goto _L5
_L5:
        ((ZipOutputStream) (obj)).finish();
        progressmonitor.endProgressMonitorSuccess();
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist) { }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_387;
        }
        ((ZipOutputStream) (obj)).close();
_L16:
        return;
_L6:
        if (!progressmonitor.isCancelAllTasks()) goto _L8; else goto _L7
_L7:
        progressmonitor.setResult(3);
        progressmonitor.setState(0);
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist) { }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        ((ZipOutputStream) (obj)).close();
_L19:
        return;
_L8:
        obj2 = (ZipParameters)zipparameters.clone();
        progressmonitor.setFileName(((File)arraylist.get(i)).getAbsolutePath());
        if (((File)arraylist.get(i)).isDirectory()) goto _L10; else goto _L9
_L9:
        if (!((ZipParameters) (obj2)).isEncryptFiles() || ((ZipParameters) (obj2)).getEncryptionMethod() != 0) goto _L12; else goto _L11
_L11:
        progressmonitor.setCurrentOperation(3);
        ((ZipParameters) (obj2)).setSourceFileCRC((int)CRCUtil.computeFileCRC(((File)arraylist.get(i)).getAbsolutePath(), progressmonitor));
        progressmonitor.setCurrentOperation(0);
        if (!progressmonitor.isCancelAllTasks()) goto _L12; else goto _L13
_L13:
        progressmonitor.setResult(3);
        progressmonitor.setState(0);
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist) { }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_551;
        }
        ((ZipOutputStream) (obj)).close();
_L20:
        return;
_L12:
        if (Zip4jUtil.getFileLengh((File)arraylist.get(i)) == 0L)
        {
            ((ZipParameters) (obj2)).setCompressionMethod(0);
        }
_L10:
        ((ZipOutputStream) (obj)).putNextEntry((File)arraylist.get(i), ((ZipParameters) (obj2)));
        if (((File)arraylist.get(i)).isDirectory())
        {
            ((ZipOutputStream) (obj)).closeEntry();
            break MISSING_BLOCK_LABEL_977;
        }
        obj2 = new FileInputStream((File)arraylist.get(i));
_L17:
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        j = ((InputStream) (obj2)).read(abyte0);
        if (j != -1) goto _L15; else goto _L14
_L14:
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        ((ZipOutputStream) (obj)).closeEntry();
        obj1 = obj2;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_977;
        }
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        ((InputStream) (obj2)).close();
        obj1 = obj2;
        break MISSING_BLOCK_LABEL_977;
        obj1;
        zipparameters = ((ZipParameters) (obj));
        arraylist = fileinputstream;
        obj = obj1;
_L21:
        obj1 = arraylist;
        obj2 = zipparameters;
        progressmonitor.endProgressMonitorError(((Throwable) (obj)));
        obj1 = arraylist;
        obj2 = zipparameters;
        throw new ZipException(((Throwable) (obj)));
_L15:
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        if (!progressmonitor.isCancelAllTasks())
        {
            break MISSING_BLOCK_LABEL_825;
        }
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        progressmonitor.setResult(3);
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        progressmonitor.setState(0);
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist) { }
        }
        if (obj != null)
        {
            try
            {
                ((ZipOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                return;
            }
        }
          goto _L16
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        ((ZipOutputStream) (obj)).write(abyte0, 0, j);
        obj1 = obj2;
        fileinputstream = ((FileInputStream) (obj2));
        fileinputstream1 = ((FileInputStream) (obj2));
        progressmonitor.updateWorkCompleted(j);
          goto _L17
        arraylist;
        obj1 = fileinputstream1;
        obj2 = obj;
          goto _L18
        arraylist;
          goto _L19
        arraylist;
          goto _L20
        arraylist;
          goto _L16
        arraylist;
        obj2 = obj;
          goto _L18
        obj;
        arraylist = obj7;
        zipparameters = fileinputstream1;
          goto _L21
        Object obj3;
        obj3;
        arraylist = ((ArrayList) (obj1));
        zipparameters = ((ZipParameters) (obj));
        obj = obj3;
          goto _L21
        obj;
        arraylist = obj6;
        zipparameters = fileinputstream;
          goto _L22
        obj3;
        arraylist = ((ArrayList) (obj1));
        zipparameters = ((ZipParameters) (obj));
        obj = obj3;
          goto _L22
        i++;
          goto _L23
    }

    private RandomAccessFile prepareFileOutputStream()
        throws ZipException
    {
        Object obj = zipModel.getZipFile();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(((String) (obj))))
        {
            throw new ZipException("invalid output path");
        }
        try
        {
            obj = new File(((String) (obj)));
            if (!((File) (obj)).getParentFile().exists())
            {
                ((File) (obj)).getParentFile().mkdirs();
            }
            obj = new RandomAccessFile(((File) (obj)), "rw");
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            throw new ZipException(filenotfoundexception);
        }
        return ((RandomAccessFile) (obj));
    }

    private void removeFilesIfExists(ArrayList arraylist, ZipParameters zipparameters, ProgressMonitor progressmonitor)
        throws ZipException
    {
        if (zipModel != null && zipModel.getCentralDirectory() != null && zipModel.getCentralDirectory().getFileHeaders() != null && zipModel.getCentralDirectory().getFileHeaders().size() > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        int i;
        obj1 = null;
        i = 0;
_L3:
        Object obj2;
        Object obj3;
        obj3 = obj1;
        obj2 = obj1;
        int j = arraylist.size();
label0:
        {
            if (i < j)
            {
                break label0;
            }
            if (obj1 != null)
            {
                try
                {
                    ((RandomAccessFile) (obj1)).close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ArrayList arraylist)
                {
                    return;
                }
            }
        }
          goto _L1
        obj3 = obj1;
        obj2 = obj1;
        Object obj = Zip4jUtil.getRelativeFileName(((File)arraylist.get(i)).getAbsolutePath(), zipparameters.getRootFolderInZip(), zipparameters.getDefaultFolderPath());
        obj3 = obj1;
        obj2 = obj1;
        Object obj4 = Zip4jUtil.getFileHeader(zipModel, ((String) (obj)));
        obj2 = obj1;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        obj = obj1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        obj3 = obj1;
        obj2 = obj1;
        ((RandomAccessFile) (obj1)).close();
        obj = null;
        obj3 = obj;
        obj2 = obj;
        obj1 = new ArchiveMaintainer();
        obj3 = obj;
        obj2 = obj;
        progressmonitor.setCurrentOperation(2);
        obj3 = obj;
        obj2 = obj;
        obj1 = ((ArchiveMaintainer) (obj1)).initRemoveZipFile(zipModel, ((FileHeader) (obj4)), progressmonitor);
        obj3 = obj;
        obj2 = obj;
        if (!progressmonitor.isCancelAllTasks())
        {
            break MISSING_BLOCK_LABEL_279;
        }
        obj3 = obj;
        obj2 = obj;
        progressmonitor.setResult(3);
        obj3 = obj;
        obj2 = obj;
        progressmonitor.setState(0);
        if (obj != null)
        {
            try
            {
                ((RandomAccessFile) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                return;
            }
        }
          goto _L1
        obj3 = obj;
        obj2 = obj;
        progressmonitor.setCurrentOperation(0);
        obj2 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        obj3 = obj;
        obj2 = obj;
        obj = prepareFileOutputStream();
        obj2 = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        obj3 = obj;
        obj2 = obj;
        obj4 = ((HashMap) (obj1)).get("offsetCentralDir");
        obj2 = obj;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        obj3 = obj;
        obj2 = obj;
        long l = Long.parseLong((String)((HashMap) (obj1)).get("offsetCentralDir"));
        obj2 = obj;
        if (l < 0L)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        obj3 = obj;
        obj2 = obj;
        ((RandomAccessFile) (obj)).seek(l);
        obj2 = obj;
        break MISSING_BLOCK_LABEL_479;
        arraylist;
        obj3 = obj;
        obj2 = obj;
        try
        {
            throw new ZipException("NumberFormatException while parsing offset central directory. Cannot update already existing file header");
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            obj2 = obj3;
        }
        finally
        {
            if (obj2 == null) goto _L0; else goto _L0
        }
        throw new ZipException(arraylist);
        try
        {
            ((RandomAccessFile) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (ZipParameters zipparameters) { }
        throw arraylist;
        arraylist;
        obj3 = obj;
        obj2 = obj;
        throw new ZipException("Error while parsing offset central directory. Cannot update already existing file header");
        i++;
        obj1 = obj2;
          goto _L3
    }

    public void addFiles(ArrayList arraylist, ZipParameters zipparameters, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        if (arraylist == null || zipparameters == null)
        {
            throw new ZipException("one of the input parameters is null when adding files");
        }
        if (arraylist.size() <= 0)
        {
            throw new ZipException("no files to add");
        }
        progressmonitor.setCurrentOperation(0);
        progressmonitor.setState(1);
        progressmonitor.setResult(1);
        if (flag)
        {
            progressmonitor.setTotalWork(calculateTotalWork(arraylist, zipparameters));
            progressmonitor.setFileName(((File)arraylist.get(0)).getAbsolutePath());
            (new _cls1(progressmonitor)).start();
            return;
        } else
        {
            initAddFiles(arraylist, zipparameters, progressmonitor);
            return;
        }
    }

    public void addFolderToZip(File file, ZipParameters zipparameters, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        if (file == null || zipparameters == null)
        {
            throw new ZipException("one of the input parameters is null, cannot add folder to zip");
        }
        if (!Zip4jUtil.checkFileExists(file.getAbsolutePath()))
        {
            throw new ZipException("input folder does not exist");
        }
        if (!file.isDirectory())
        {
            throw new ZipException("input file is not a folder, user addFileToZip method to add files");
        }
        if (!Zip4jUtil.checkFileReadAccess(file.getAbsolutePath()))
        {
            throw new ZipException("cannot read folder: " + file.getAbsolutePath());
        }
        Object obj;
        ArrayList arraylist;
        if (zipparameters.isIncludeRootFolder())
        {
            if (file.getAbsolutePath() != null)
            {
                if (file.getAbsoluteFile().getParentFile() != null)
                {
                    obj = file.getAbsoluteFile().getParentFile().getAbsolutePath();
                } else
                {
                    obj = "";
                }
            } else
            if (file.getParentFile() != null)
            {
                obj = file.getParentFile().getAbsolutePath();
            } else
            {
                obj = "";
            }
        } else
        {
            obj = file.getAbsolutePath();
        }
        zipparameters.setDefaultFolderPath(((String) (obj)));
        arraylist = Zip4jUtil.getFilesInDirectoryRec(file, zipparameters.isReadHiddenFiles());
        obj = arraylist;
        if (zipparameters.isIncludeRootFolder())
        {
            obj = arraylist;
            if (arraylist == null)
            {
                obj = new ArrayList();
            }
            ((ArrayList) (obj)).add(file);
        }
        addFiles(((ArrayList) (obj)), zipparameters, progressmonitor, flag);
    }

    public void addStreamToZip(InputStream inputstream, ZipParameters zipparameters)
        throws ZipException
    {
        Object obj;
        ZipOutputStream zipoutputstream;
        Object obj1;
        Object obj2;
        if (inputstream == null || zipparameters == null)
        {
            throw new ZipException("one of the input parameters is null, cannot add stream to zip");
        }
        zipoutputstream = null;
        obj2 = null;
        obj1 = null;
        obj = zipoutputstream;
        checkParameters(zipparameters);
        obj = zipoutputstream;
        boolean flag = Zip4jUtil.checkFileExists(zipModel.getZipFile());
        obj = zipoutputstream;
        SplitOutputStream splitoutputstream = new SplitOutputStream(new File(zipModel.getZipFile()), zipModel.getSplitLength());
        obj = zipoutputstream;
        zipoutputstream = new ZipOutputStream(splitoutputstream, zipModel);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (zipModel.getEndCentralDirRecord() == null)
        {
            throw new ZipException("invalid end of central directory record");
        }
          goto _L3
        inputstream;
        obj = zipoutputstream;
_L10:
        throw inputstream;
        inputstream;
_L7:
        int i;
        if (obj != null)
        {
            try
            {
                ((ZipOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (ZipParameters zipparameters) { }
        }
        throw inputstream;
_L3:
        splitoutputstream.seek(zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
_L2:
        obj = new byte[4096];
        zipoutputstream.putNextEntry(null, zipparameters);
        if (zipparameters.getFileNameInZip().endsWith("/") || zipparameters.getFileNameInZip().endsWith("\\")) goto _L5; else goto _L4
_L4:
        i = inputstream.read(((byte []) (obj)));
        if (i != -1) goto _L6; else goto _L5
_L5:
        zipoutputstream.closeEntry();
        zipoutputstream.finish();
        if (zipoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        zipoutputstream.close();
        return;
_L6:
        zipoutputstream.write(((byte []) (obj)), 0, i);
          goto _L4
        inputstream;
        obj = zipoutputstream;
_L8:
        throw new ZipException(inputstream);
        inputstream;
        return;
        inputstream;
        obj = zipoutputstream;
          goto _L7
        inputstream;
        obj = obj2;
          goto _L8
        inputstream;
        obj = obj1;
        if (true) goto _L10; else goto _L9
_L9:
    }


    private class _cls1 extends Thread
    {

        final ZipEngine this$0;
        private final ArrayList val$fileList;
        private final ZipParameters val$parameters;
        private final ProgressMonitor val$progressMonitor;

        public void run()
        {
            try
            {
                initAddFiles(fileList, parameters, progressMonitor);
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
            this$0 = ZipEngine.this;
            fileList = arraylist;
            parameters = zipparameters;
            progressMonitor = progressmonitor;
        }
    }

}
