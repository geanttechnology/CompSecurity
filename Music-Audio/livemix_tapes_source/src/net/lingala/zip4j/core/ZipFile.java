// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.Unzip;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;
import net.lingala.zip4j.zip.ZipEngine;

// Referenced classes of package net.lingala.zip4j.core:
//            HeaderReader

public class ZipFile
{

    private String file;
    private String fileNameCharset;
    private boolean isEncrypted;
    private int mode;
    private ProgressMonitor progressMonitor;
    private boolean runInThread;
    private ZipModel zipModel;

    public ZipFile(File file1)
        throws ZipException
    {
        if (file1 == null)
        {
            throw new ZipException("Input zip file parameter is not null", 1);
        } else
        {
            file = file1.getPath();
            mode = 2;
            progressMonitor = new ProgressMonitor();
            runInThread = false;
            return;
        }
    }

    public ZipFile(String s)
        throws ZipException
    {
        this(new File(s));
    }

    private void addFolder(File file1, ZipParameters zipparameters, boolean flag)
        throws ZipException
    {
        checkZipModel();
        if (zipModel == null)
        {
            throw new ZipException("internal error: zip model is null");
        }
        if (flag && zipModel.isSplitArchive())
        {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        } else
        {
            (new ZipEngine(zipModel)).addFolderToZip(file1, zipparameters, progressMonitor, runInThread);
            return;
        }
    }

    private void checkZipModel()
        throws ZipException
    {
label0:
        {
            if (zipModel == null)
            {
                if (!Zip4jUtil.checkFileExists(file))
                {
                    break label0;
                }
                readZipInfo();
            }
            return;
        }
        createNewZipModel();
    }

    private void createNewZipModel()
    {
        zipModel = new ZipModel();
        zipModel.setZipFile(file);
        zipModel.setFileNameCharset(fileNameCharset);
    }

    private void readZipInfo()
        throws ZipException
    {
        Object obj;
        Object obj2;
        if (!Zip4jUtil.checkFileExists(file))
        {
            throw new ZipException("zip file does not exist");
        }
        if (!Zip4jUtil.checkFileReadAccess(file))
        {
            throw new ZipException("no read access for the input zip file");
        }
        if (mode != 2)
        {
            throw new ZipException("Invalid mode");
        }
        obj = null;
        obj2 = null;
        Object obj1 = new RandomAccessFile(new File(file), "r");
        if (zipModel == null)
        {
            zipModel = (new HeaderReader(((RandomAccessFile) (obj1)))).readAllHeaders(fileNameCharset);
            if (zipModel != null)
            {
                zipModel.setZipFile(file);
            }
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        ((RandomAccessFile) (obj1)).close();
        return;
        obj1;
        obj = obj2;
_L4:
        throw new ZipException(((Throwable) (obj1)));
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((RandomAccessFile) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj1;
        obj;
        return;
        Object obj3;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L2; else goto _L1
_L1:
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void addFile(File file1, ZipParameters zipparameters)
        throws ZipException
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(file1);
        addFiles(arraylist, zipparameters);
    }

    public void addFiles(ArrayList arraylist, ZipParameters zipparameters)
        throws ZipException
    {
        checkZipModel();
        if (zipModel == null)
        {
            throw new ZipException("internal error: zip model is null");
        }
        if (arraylist == null)
        {
            throw new ZipException("input file ArrayList is null, cannot add files");
        }
        if (!Zip4jUtil.checkArrayListTypes(arraylist, 1))
        {
            throw new ZipException("One or more elements in the input ArrayList is not of type File");
        }
        if (zipparameters == null)
        {
            throw new ZipException("input parameters are null, cannot add files to zip");
        }
        if (progressMonitor.getState() == 1)
        {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        if (Zip4jUtil.checkFileExists(file) && zipModel.isSplitArchive())
        {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        } else
        {
            (new ZipEngine(zipModel)).addFiles(arraylist, zipparameters, progressMonitor, runInThread);
            return;
        }
    }

    public void addFolder(File file1, ZipParameters zipparameters)
        throws ZipException
    {
        if (file1 == null)
        {
            throw new ZipException("input path is null, cannot add folder to zip file");
        }
        if (zipparameters == null)
        {
            throw new ZipException("input parameters are null, cannot add folder to zip file");
        } else
        {
            addFolder(file1, zipparameters, true);
            return;
        }
    }

    public void addFolder(String s, ZipParameters zipparameters)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("input path is null or empty, cannot add folder to zip file");
        } else
        {
            addFolder(new File(s), zipparameters);
            return;
        }
    }

    public void addStream(InputStream inputstream, ZipParameters zipparameters)
        throws ZipException
    {
        if (inputstream == null)
        {
            throw new ZipException("inputstream is null, cannot add file to zip");
        }
        if (zipparameters == null)
        {
            throw new ZipException("zip parameters are null");
        }
        setRunInThread(false);
        checkZipModel();
        if (zipModel == null)
        {
            throw new ZipException("internal error: zip model is null");
        }
        if (Zip4jUtil.checkFileExists(file) && zipModel.isSplitArchive())
        {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        } else
        {
            (new ZipEngine(zipModel)).addStreamToZip(inputstream, zipparameters);
            return;
        }
    }

    public void createZipFile(File file1, ZipParameters zipparameters)
        throws ZipException
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(file1);
        createZipFile(arraylist, zipparameters, false, -1L);
    }

    public void createZipFile(File file1, ZipParameters zipparameters, boolean flag, long l)
        throws ZipException
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(file1);
        createZipFile(arraylist, zipparameters, flag, l);
    }

    public void createZipFile(ArrayList arraylist, ZipParameters zipparameters)
        throws ZipException
    {
        createZipFile(arraylist, zipparameters, false, -1L);
    }

    public void createZipFile(ArrayList arraylist, ZipParameters zipparameters, boolean flag, long l)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(file))
        {
            throw new ZipException("zip file path is empty");
        }
        if (Zip4jUtil.checkFileExists(file))
        {
            throw new ZipException("zip file: " + file + " already exists. To add files to existing zip file use addFile method");
        }
        if (arraylist == null)
        {
            throw new ZipException("input file ArrayList is null, cannot create zip file");
        }
        if (!Zip4jUtil.checkArrayListTypes(arraylist, 1))
        {
            throw new ZipException("One or more elements in the input ArrayList is not of type File");
        } else
        {
            createNewZipModel();
            zipModel.setSplitArchive(flag);
            zipModel.setSplitLength(l);
            addFiles(arraylist, zipparameters);
            return;
        }
    }

    public void createZipFileFromFolder(File file1, ZipParameters zipparameters, boolean flag, long l)
        throws ZipException
    {
        if (file1 == null)
        {
            throw new ZipException("folderToAdd is null, cannot create zip file from folder");
        }
        if (zipparameters == null)
        {
            throw new ZipException("input parameters are null, cannot create zip file from folder");
        }
        if (Zip4jUtil.checkFileExists(file))
        {
            throw new ZipException("zip file: " + file + " already exists. To add files to existing zip file use addFolder method");
        }
        createNewZipModel();
        zipModel.setSplitArchive(flag);
        if (flag)
        {
            zipModel.setSplitLength(l);
        }
        addFolder(file1, zipparameters, false);
    }

    public void createZipFileFromFolder(String s, ZipParameters zipparameters, boolean flag, long l)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("folderToAdd is empty or null, cannot create Zip File from folder");
        } else
        {
            createZipFileFromFolder(new File(s), zipparameters, flag, l);
            return;
        }
    }

    public void extractAll(String s)
        throws ZipException
    {
        extractAll(s, null);
    }

    public void extractAll(String s, UnzipParameters unzipparameters)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("output path is null or invalid");
        }
        if (!Zip4jUtil.checkOutputFolder(s))
        {
            throw new ZipException("invalid output path");
        }
        if (zipModel == null)
        {
            readZipInfo();
        }
        if (zipModel == null)
        {
            throw new ZipException("Internal error occurred when extracting zip file");
        }
        if (progressMonitor.getState() == 1)
        {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        } else
        {
            (new Unzip(zipModel)).extractAll(unzipparameters, s, progressMonitor, runInThread);
            return;
        }
    }

    public void extractFile(String s, String s1)
        throws ZipException
    {
        extractFile(s, s1, null);
    }

    public void extractFile(String s, String s1, UnzipParameters unzipparameters)
        throws ZipException
    {
        extractFile(s, s1, unzipparameters, null);
    }

    public void extractFile(String s, String s1, UnzipParameters unzipparameters, String s2)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("file to extract is null or empty, cannot extract file");
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s1))
        {
            throw new ZipException("destination string path is empty or null, cannot extract file");
        }
        readZipInfo();
        s = Zip4jUtil.getFileHeader(zipModel, s);
        if (s == null)
        {
            throw new ZipException("file header not found for given file name, cannot extract file");
        }
        if (progressMonitor.getState() == 1)
        {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        } else
        {
            s.extractFile(zipModel, s1, unzipparameters, s2, progressMonitor, runInThread);
            return;
        }
    }

    public void extractFile(FileHeader fileheader, String s)
        throws ZipException
    {
        extractFile(fileheader, s, null);
    }

    public void extractFile(FileHeader fileheader, String s, UnzipParameters unzipparameters)
        throws ZipException
    {
        extractFile(fileheader, s, unzipparameters, null);
    }

    public void extractFile(FileHeader fileheader, String s, UnzipParameters unzipparameters, String s1)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("input file header is null, cannot extract file");
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("destination path is empty or null, cannot extract file");
        }
        readZipInfo();
        if (progressMonitor.getState() == 1)
        {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        } else
        {
            fileheader.extractFile(zipModel, s, unzipparameters, s1, progressMonitor, runInThread);
            return;
        }
    }

    public String getComment()
        throws ZipException
    {
        return getComment(null);
    }

    public String getComment(String s)
        throws ZipException
    {
        String s1 = s;
        if (s == null)
        {
            if (Zip4jUtil.isSupportedCharset("windows-1254"))
            {
                s1 = "windows-1254";
            } else
            {
                s1 = InternalZipConstants.CHARSET_DEFAULT;
            }
        }
        if (Zip4jUtil.checkFileExists(file))
        {
            checkZipModel();
            if (zipModel == null)
            {
                throw new ZipException("zip model is null, cannot read comment");
            }
        } else
        {
            throw new ZipException("zip file does not exist, cannot read comment");
        }
        if (zipModel.getEndCentralDirRecord() == null)
        {
            throw new ZipException("end of central directory record is null, cannot read comment");
        }
        if (zipModel.getEndCentralDirRecord().getCommentBytes() == null || zipModel.getEndCentralDirRecord().getCommentBytes().length <= 0)
        {
            return null;
        }
        try
        {
            s = new String(zipModel.getEndCentralDirRecord().getCommentBytes(), s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException(s);
        }
        return s;
    }

    public File getFile()
    {
        return new File(file);
    }

    public FileHeader getFileHeader(String s)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("input file name is emtpy or null, cannot get FileHeader");
        }
        readZipInfo();
        if (zipModel == null || zipModel.getCentralDirectory() == null)
        {
            return null;
        } else
        {
            return Zip4jUtil.getFileHeader(zipModel, s);
        }
    }

    public List getFileHeaders()
        throws ZipException
    {
        readZipInfo();
        if (zipModel == null || zipModel.getCentralDirectory() == null)
        {
            return null;
        } else
        {
            return zipModel.getCentralDirectory().getFileHeaders();
        }
    }

    public ZipInputStream getInputStream(FileHeader fileheader)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("FileHeader is null, cannot get InputStream");
        }
        checkZipModel();
        if (zipModel == null)
        {
            throw new ZipException("zip model is null, cannot get inputstream");
        } else
        {
            return (new Unzip(zipModel)).getInputStream(fileheader);
        }
    }

    public ProgressMonitor getProgressMonitor()
    {
        return progressMonitor;
    }

    public ArrayList getSplitZipFiles()
        throws ZipException
    {
        checkZipModel();
        return Zip4jUtil.getSplitZipFiles(zipModel);
    }

    public boolean isEncrypted()
        throws ZipException
    {
        ArrayList arraylist;
        int i;
        if (zipModel == null)
        {
            readZipInfo();
            if (zipModel == null)
            {
                throw new ZipException("Zip Model is null");
            }
        }
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null)
        {
            throw new ZipException("invalid zip file");
        }
        arraylist = zipModel.getCentralDirectory().getFileHeaders();
        i = 0;
_L5:
        if (i < arraylist.size()) goto _L2; else goto _L1
_L1:
        return isEncrypted;
_L2:
        FileHeader fileheader = (FileHeader)arraylist.get(i);
        if (fileheader == null || !fileheader.isEncrypted())
        {
            break; /* Loop/switch isn't completed */
        }
        isEncrypted = true;
        if (true) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean isRunInThread()
    {
        return runInThread;
    }

    public boolean isSplitArchive()
        throws ZipException
    {
        if (zipModel == null)
        {
            readZipInfo();
            if (zipModel == null)
            {
                throw new ZipException("Zip Model is null");
            }
        }
        return zipModel.isSplitArchive();
    }

    public boolean isValidZipFile()
    {
        try
        {
            readZipInfo();
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public void mergeSplitFiles(File file1)
        throws ZipException
    {
        if (file1 == null)
        {
            throw new ZipException("outputZipFile is null, cannot merge split files");
        }
        if (file1.exists())
        {
            throw new ZipException("output Zip File already exists");
        }
        checkZipModel();
        if (zipModel == null)
        {
            throw new ZipException("zip model is null, corrupt zip file?");
        } else
        {
            ArchiveMaintainer archivemaintainer = new ArchiveMaintainer();
            archivemaintainer.initProgressMonitorForMergeOp(zipModel, progressMonitor);
            archivemaintainer.mergeSplitZipFiles(zipModel, file1, progressMonitor, runInThread);
            return;
        }
    }

    public void removeFile(String s)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("file name is empty or null, cannot remove file");
        }
        if (zipModel == null && Zip4jUtil.checkFileExists(file))
        {
            readZipInfo();
        }
        if (zipModel.isSplitArchive())
        {
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
        FileHeader fileheader = Zip4jUtil.getFileHeader(zipModel, s);
        if (fileheader == null)
        {
            throw new ZipException("could not find file header for file: " + s);
        } else
        {
            removeFile(fileheader);
            return;
        }
    }

    public void removeFile(FileHeader fileheader)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("file header is null, cannot remove file");
        }
        if (zipModel == null && Zip4jUtil.checkFileExists(file))
        {
            readZipInfo();
        }
        if (zipModel.isSplitArchive())
        {
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        } else
        {
            ArchiveMaintainer archivemaintainer = new ArchiveMaintainer();
            archivemaintainer.initProgressMonitorForRemoveOp(zipModel, fileheader, progressMonitor);
            archivemaintainer.removeZipFile(zipModel, fileheader, progressMonitor, runInThread);
            return;
        }
    }

    public void setComment(String s)
        throws ZipException
    {
        if (s == null)
        {
            throw new ZipException("input comment is null, cannot update zip file");
        }
        if (!Zip4jUtil.checkFileExists(file))
        {
            throw new ZipException("zip file does not exist, cannot set comment for zip file");
        }
        readZipInfo();
        if (zipModel == null)
        {
            throw new ZipException("zipModel is null, cannot update zip file");
        }
        if (zipModel.getEndCentralDirRecord() == null)
        {
            throw new ZipException("end of central directory is null, cannot set comment");
        } else
        {
            (new ArchiveMaintainer()).setComment(zipModel, s);
            return;
        }
    }

    public void setFileNameCharset(String s)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("null or empty charset name");
        }
        if (!Zip4jUtil.isSupportedCharset(s))
        {
            throw new ZipException("unsupported charset: " + s);
        } else
        {
            fileNameCharset = s;
            return;
        }
    }

    public void setPassword(String s)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new NullPointerException();
        } else
        {
            setPassword(s.toCharArray());
            return;
        }
    }

    public void setPassword(char ac[])
        throws ZipException
    {
        if (zipModel == null)
        {
            readZipInfo();
            if (zipModel == null)
            {
                throw new ZipException("Zip Model is null");
            }
        }
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null)
        {
            throw new ZipException("invalid zip file");
        }
        int i = 0;
        do
        {
            if (i >= zipModel.getCentralDirectory().getFileHeaders().size())
            {
                return;
            }
            if (zipModel.getCentralDirectory().getFileHeaders().get(i) != null && ((FileHeader)zipModel.getCentralDirectory().getFileHeaders().get(i)).isEncrypted())
            {
                ((FileHeader)zipModel.getCentralDirectory().getFileHeaders().get(i)).setPassword(ac);
            }
            i++;
        } while (true);
    }

    public void setRunInThread(boolean flag)
    {
        runInThread = flag;
    }
}
