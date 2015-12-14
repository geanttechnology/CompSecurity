// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.unzip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import net.lingala.zip4j.core.HeaderReader;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.InflaterInputStream;
import net.lingala.zip4j.io.PartInputStream;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

// Referenced classes of package net.lingala.zip4j.unzip:
//            UnzipUtil

public class UnzipEngine
{

    private CRC32 crc;
    private int currSplitFileCounter;
    private IDecrypter decrypter;
    private FileHeader fileHeader;
    private LocalFileHeader localFileHeader;
    private ZipModel zipModel;

    public UnzipEngine(ZipModel zipmodel, FileHeader fileheader)
        throws ZipException
    {
        currSplitFileCounter = 0;
        if (zipmodel == null || fileheader == null)
        {
            throw new ZipException("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        } else
        {
            zipModel = zipmodel;
            fileHeader = fileheader;
            crc = new CRC32();
            return;
        }
    }

    private int calculateAESSaltLength(AESExtraDataRecord aesextradatarecord)
        throws ZipException
    {
        if (aesextradatarecord == null)
        {
            throw new ZipException("unable to determine salt length: AESExtraDataRecord is null");
        }
        switch (aesextradatarecord.getAesStrength())
        {
        default:
            throw new ZipException("unable to determine salt length: invalid aes key strength");

        case 1: // '\001'
            return 8;

        case 2: // '\002'
            return 12;

        case 3: // '\003'
            return 16;
        }
    }

    private boolean checkLocalHeader()
        throws ZipException
    {
        Object obj;
        Object obj2;
        obj2 = null;
        obj = null;
        RandomAccessFile randomaccessfile = checkSplitFile();
        Object obj3;
        obj3 = randomaccessfile;
        if (randomaccessfile != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj = randomaccessfile;
        obj2 = randomaccessfile;
        obj3 = new RandomAccessFile(new File(zipModel.getZipFile()), "r");
        obj = obj3;
        obj2 = obj3;
        localFileHeader = (new HeaderReader(((RandomAccessFile) (obj3)))).readLocalFileHeader(fileHeader);
        obj = obj3;
        obj2 = obj3;
        if (localFileHeader != null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj = obj3;
        obj2 = obj3;
        try
        {
            throw new ZipException("error reading local file header. Is this a valid zip file?");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3)
        {
            obj2 = obj;
        }
        finally
        {
            if (obj2 == null) goto _L0; else goto _L0
        }
        throw new ZipException(((Throwable) (obj3)));
        Object obj1;
        int i;
        int j;
        try
        {
            ((RandomAccessFile) (obj2)).close();
        }
        catch (IOException ioexception) { }
        catch (Exception exception) { }
        throw obj;
        obj = obj3;
        obj2 = obj3;
        i = localFileHeader.getCompressionMethod();
        obj = obj3;
        obj2 = obj3;
        j = fileHeader.getCompressionMethod();
        if (i != j)
        {
            if (obj3 != null)
            {
                try
                {
                    ((RandomAccessFile) (obj3)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
            }
            return false;
        }
        if (obj3 != null)
        {
            try
            {
                ((RandomAccessFile) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        return true;
    }

    private RandomAccessFile checkSplitFile()
        throws ZipException
    {
        Object obj;
        if (!zipModel.isSplitArchive())
        {
            break MISSING_BLOCK_LABEL_221;
        }
        int i = fileHeader.getDiskNumberStart();
        currSplitFileCounter = i + 1;
        obj = zipModel.getZipFile();
        RandomAccessFile randomaccessfile;
        byte abyte0[];
        if (i == zipModel.getEndCentralDirRecord().getNoOfThisDisk())
        {
            obj = zipModel.getZipFile();
        } else
        if (i >= 9)
        {
            obj = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf(".")) + ".z" + (i + 1);
        } else
        {
            obj = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf(".")) + ".z0" + (i + 1);
        }
        try
        {
            randomaccessfile = new RandomAccessFile(((String) (obj)), "r");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ZipException(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ZipException(((Throwable) (obj)));
        }
        obj = randomaccessfile;
        if (currSplitFileCounter != 1)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        abyte0 = new byte[4];
        randomaccessfile.read(abyte0);
        obj = randomaccessfile;
        if ((long)Raw.readIntLittleEndian(abyte0, 0) != 0x8074b50L)
        {
            throw new ZipException("invalid first part split file signature");
        }
        break MISSING_BLOCK_LABEL_223;
        obj = null;
        return ((RandomAccessFile) (obj));
    }

    private void closeStreams(InputStream inputstream, OutputStream outputstream)
        throws ZipException
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        outputstream.close();
_L2:
        return;
        inputstream;
        if (inputstream == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Zip4jUtil.isStringNotNullAndNotEmpty(inputstream.getMessage()) && inputstream.getMessage().indexOf(" - Wrong Password?") >= 0)
        {
            throw new ZipException(inputstream.getMessage());
        }
        continue; /* Loop/switch isn't completed */
        inputstream;
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (OutputStream outputstream) { }
        }
        throw inputstream;
        if (outputstream == null) goto _L2; else goto _L1
_L1:
        try
        {
            outputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
        inputstream;
    }

    private RandomAccessFile createFileHandler(String s)
        throws ZipException
    {
        if (zipModel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getZipFile()))
        {
            throw new ZipException("input parameter is null in getFilePointer");
        }
        try
        {
            if (zipModel.isSplitArchive())
            {
                return checkSplitFile();
            }
            s = new RandomAccessFile(new File(zipModel.getZipFile()), s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException(s);
        }
        return s;
    }

    private byte[] getAESPasswordVerifier(RandomAccessFile randomaccessfile)
        throws ZipException
    {
        byte abyte0[];
        try
        {
            abyte0 = new byte[2];
            randomaccessfile.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            throw new ZipException(randomaccessfile);
        }
        return abyte0;
    }

    private byte[] getAESSalt(RandomAccessFile randomaccessfile)
        throws ZipException
    {
        if (localFileHeader.getAesExtraDataRecord() == null)
        {
            return null;
        }
        byte abyte0[];
        try
        {
            abyte0 = new byte[calculateAESSaltLength(localFileHeader.getAesExtraDataRecord())];
            randomaccessfile.seek(localFileHeader.getOffsetStartOfData());
            randomaccessfile.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            throw new ZipException(randomaccessfile);
        }
        return abyte0;
    }

    private String getOutputFileNameWithPath(String s, String s1)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s1))
        {
            s1 = fileHeader.getFileName();
        }
        return s + System.getProperty("file.separator") + s1;
    }

    private FileOutputStream getOutputStream(String s, String s1)
        throws ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("invalid output path");
        }
        try
        {
            s = new File(getOutputFileNameWithPath(s, s1));
            if (!s.getParentFile().exists())
            {
                s.getParentFile().mkdirs();
            }
            if (s.exists())
            {
                s.delete();
            }
            s = new FileOutputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException(s);
        }
        return s;
    }

    private byte[] getStandardDecrypterHeaderBytes(RandomAccessFile randomaccessfile)
        throws ZipException
    {
        byte abyte0[];
        try
        {
            abyte0 = new byte[12];
            randomaccessfile.seek(localFileHeader.getOffsetStartOfData());
            randomaccessfile.read(abyte0, 0, 12);
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
        return abyte0;
    }

    private void init(RandomAccessFile randomaccessfile)
        throws ZipException
    {
        if (localFileHeader == null)
        {
            throw new ZipException("local file header is null, cannot initialize input stream");
        }
        try
        {
            initDecrypter(randomaccessfile);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            throw randomaccessfile;
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            throw new ZipException(randomaccessfile);
        }
    }

    private void initDecrypter(RandomAccessFile randomaccessfile)
        throws ZipException
    {
label0:
        {
            if (localFileHeader == null)
            {
                throw new ZipException("local file header is null, cannot init decrypter");
            }
            if (localFileHeader.isEncrypted())
            {
                if (localFileHeader.getEncryptionMethod() != 0)
                {
                    break label0;
                }
                decrypter = new StandardDecrypter(fileHeader, getStandardDecrypterHeaderBytes(randomaccessfile));
            }
            return;
        }
        if (localFileHeader.getEncryptionMethod() == 99)
        {
            decrypter = new AESDecrypter(localFileHeader, getAESSalt(randomaccessfile), getAESPasswordVerifier(randomaccessfile));
            return;
        } else
        {
            throw new ZipException("unsupported encryption method");
        }
    }

    public void checkCRC()
        throws ZipException
    {
        if (fileHeader != null)
        {
            if (fileHeader.getEncryptionMethod() == 99)
            {
                if (decrypter != null && (decrypter instanceof AESDecrypter))
                {
                    byte abyte0[] = ((AESDecrypter)decrypter).getCalculatedAuthenticationBytes();
                    byte abyte1[] = ((AESDecrypter)decrypter).getStoredMac();
                    byte abyte2[] = new byte[10];
                    if (abyte2 == null || abyte1 == null)
                    {
                        throw new ZipException("CRC (MAC) check failed for " + fileHeader.getFileName());
                    }
                    System.arraycopy(abyte0, 0, abyte2, 0, 10);
                    if (!Arrays.equals(abyte2, abyte1))
                    {
                        throw new ZipException("invalid CRC (MAC) for file: " + fileHeader.getFileName());
                    }
                }
            } else
            if ((crc.getValue() & 0xffffffffL) != fileHeader.getCrc32())
            {
                String s1 = "invalid CRC for file: " + fileHeader.getFileName();
                String s = s1;
                if (localFileHeader.isEncrypted())
                {
                    s = s1;
                    if (localFileHeader.getEncryptionMethod() == 0)
                    {
                        s = s1 + " - Wrong Password?";
                    }
                }
                throw new ZipException(s);
            }
        }
    }

    public IDecrypter getDecrypter()
    {
        return decrypter;
    }

    public FileHeader getFileHeader()
    {
        return fileHeader;
    }

    public ZipInputStream getInputStream()
        throws ZipException
    {
        Object obj;
        Object obj1;
        if (fileHeader == null)
        {
            throw new ZipException("file header is null, cannot get inputstream");
        }
        obj1 = null;
        obj = null;
        Object obj2 = createFileHandler("r");
        obj = obj2;
        obj1 = obj2;
        if (!checkLocalHeader())
        {
            obj = obj2;
            obj1 = obj2;
            try
            {
                throw new ZipException("local header and file header do not match");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                int i;
                long l;
                long l1;
                long l2;
                long l3;
                if (obj != null)
                {
                    try
                    {
                        ((RandomAccessFile) (obj)).close();
                    }
                    catch (IOException ioexception) { }
                }
                throw obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            if (obj1 != null)
            {
                try
                {
                    ((RandomAccessFile) (obj1)).close();
                }
                catch (IOException ioexception1) { }
            }
            throw new ZipException(((Throwable) (obj)));
        }
        obj = obj2;
        obj1 = obj2;
        init(((RandomAccessFile) (obj2)));
        obj = obj2;
        obj1 = obj2;
        l3 = localFileHeader.getCompressedSize();
        obj = obj2;
        obj1 = obj2;
        l2 = localFileHeader.getOffsetStartOfData();
        obj = obj2;
        l = l2;
        l1 = l3;
        obj1 = obj2;
        if (!localFileHeader.isEncrypted()) goto _L2; else goto _L1
_L1:
        obj = obj2;
        obj1 = obj2;
        if (localFileHeader.getEncryptionMethod() != 99) goto _L4; else goto _L3
_L3:
        obj = obj2;
        obj1 = obj2;
        if (!(decrypter instanceof AESDecrypter)) goto _L6; else goto _L5
_L5:
        obj = obj2;
        obj1 = obj2;
        i = ((AESDecrypter)decrypter).getSaltLength();
        obj = obj2;
        obj1 = obj2;
        l1 = l3 - (long)(((AESDecrypter)decrypter).getPasswordVerifierLength() + i + 10);
        obj = obj2;
        obj1 = obj2;
        i = ((AESDecrypter)decrypter).getSaltLength();
        obj = obj2;
        obj1 = obj2;
        l = l2 + (long)(((AESDecrypter)decrypter).getPasswordVerifierLength() + i);
_L2:
        obj = obj2;
        obj1 = obj2;
        i = fileHeader.getCompressionMethod();
        obj = obj2;
        obj1 = obj2;
        if (fileHeader.getEncryptionMethod() != 99)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        obj = obj2;
        obj1 = obj2;
        if (fileHeader.getAesExtraDataRecord() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        obj1 = obj2;
        i = fileHeader.getAesExtraDataRecord().getCompressionMethod();
        obj = obj2;
        obj1 = obj2;
        ((RandomAccessFile) (obj2)).seek(l);
        i;
        JVM INSTR lookupswitch 2: default 536
    //                   0: 476
    //                   8: 501;
           goto _L7 _L8 _L9
_L7:
        obj = obj2;
        obj1 = obj2;
        throw new ZipException("compression type not supported");
_L6:
        obj = obj2;
        obj1 = obj2;
        throw new ZipException("invalid decryptor when trying to calculate compressed size for AES encrypted file: " + fileHeader.getFileName());
_L4:
        obj = obj2;
        l = l2;
        l1 = l3;
        obj1 = obj2;
        if (localFileHeader.getEncryptionMethod() == 0)
        {
            l1 = l3 - 12L;
            l = l2 + 12L;
        }
        if (true) goto _L2; else goto _L10
_L10:
        obj = obj2;
        obj1 = obj2;
        throw new ZipException("AESExtraDataRecord does not exist for AES encrypted file: " + fileHeader.getFileName());
_L8:
        obj = obj2;
        obj1 = obj2;
        return new ZipInputStream(new PartInputStream(((RandomAccessFile) (obj2)), l, l1, this));
_L9:
        obj = obj2;
        obj1 = obj2;
        obj2 = new ZipInputStream(new InflaterInputStream(((RandomAccessFile) (obj2)), l, l1, this));
        return ((ZipInputStream) (obj2));
    }

    public LocalFileHeader getLocalFileHeader()
    {
        return localFileHeader;
    }

    public ZipModel getZipModel()
    {
        return zipModel;
    }

    public RandomAccessFile startNextSplitFile()
        throws IOException, FileNotFoundException
    {
        Object obj = zipModel.getZipFile();
        if (currSplitFileCounter == zipModel.getEndCentralDirRecord().getNoOfThisDisk())
        {
            obj = zipModel.getZipFile();
        } else
        if (currSplitFileCounter >= 9)
        {
            obj = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf(".")) + ".z" + (currSplitFileCounter + 1);
        } else
        {
            obj = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf(".")) + ".z0" + (currSplitFileCounter + 1);
        }
        currSplitFileCounter = currSplitFileCounter + 1;
        try
        {
            if (!Zip4jUtil.checkFileExists(((String) (obj))))
            {
                throw new IOException("zip split file does not exist: " + obj);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IOException(((ZipException) (obj)).getMessage());
        }
        return new RandomAccessFile(((String) (obj)), "r");
    }

    public void unzipFile(ProgressMonitor progressmonitor, String s, String s1, UnzipParameters unzipparameters)
        throws ZipException
    {
        ZipInputStream zipinputstream;
        FileOutputStream fileoutputstream;
        ZipInputStream zipinputstream1;
        FileOutputStream fileoutputstream1;
        ZipInputStream zipinputstream2;
        FileOutputStream fileoutputstream2;
        ZipInputStream zipinputstream3;
        FileOutputStream fileoutputstream3;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        if (zipModel == null || fileHeader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        obj2 = null;
        obj3 = null;
        zipinputstream3 = null;
        obj = null;
        obj1 = null;
        fileoutputstream3 = null;
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = obj2;
        fileoutputstream = obj;
        zipinputstream2 = obj3;
        fileoutputstream2 = obj1;
        byte abyte0[] = new byte[4096];
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = obj2;
        fileoutputstream = obj;
        zipinputstream2 = obj3;
        fileoutputstream2 = obj1;
        zipinputstream3 = getInputStream();
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = obj;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = obj1;
        fileoutputstream3 = getOutputStream(s, s1);
_L2:
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        int i = zipinputstream3.read(abyte0);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        closeStreams(zipinputstream3, fileoutputstream3);
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        UnzipUtil.applyFileAttributes(fileHeader, new File(getOutputFileNameWithPath(s, s1)), unzipparameters);
        closeStreams(zipinputstream3, fileoutputstream3);
        return;
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        fileoutputstream3.write(abyte0, 0, i);
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        progressmonitor.updateWorkCompleted(i);
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        if (!progressmonitor.isCancelAllTasks()) goto _L2; else goto _L1
_L1:
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        progressmonitor.setResult(3);
        zipinputstream1 = zipinputstream3;
        fileoutputstream1 = fileoutputstream3;
        zipinputstream = zipinputstream3;
        fileoutputstream = fileoutputstream3;
        zipinputstream2 = zipinputstream3;
        fileoutputstream2 = fileoutputstream3;
        progressmonitor.setState(0);
        closeStreams(zipinputstream3, fileoutputstream3);
        return;
        progressmonitor;
        zipinputstream = zipinputstream1;
        fileoutputstream = fileoutputstream1;
        throw new ZipException(progressmonitor);
        progressmonitor;
        closeStreams(zipinputstream, fileoutputstream);
        throw progressmonitor;
        progressmonitor;
        zipinputstream = zipinputstream2;
        fileoutputstream = fileoutputstream2;
        throw new ZipException(progressmonitor);
    }

    public void updateCRC(int i)
    {
        crc.update(i);
    }

    public void updateCRC(byte abyte0[], int i, int j)
    {
        if (abyte0 != null)
        {
            crc.update(abyte0, i, j);
        }
    }
}
