// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import net.lingala.zip4j.core.HeaderWriter;
import net.lingala.zip4j.crypto.AESEncrpyter;
import net.lingala.zip4j.crypto.IEncrypter;
import net.lingala.zip4j.crypto.StandardEncrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

// Referenced classes of package net.lingala.zip4j.io:
//            BaseOutputStream, SplitOutputStream

public class CipherOutputStream extends BaseOutputStream
{

    private long bytesWrittenForThisFile;
    protected CRC32 crc;
    private IEncrypter encrypter;
    protected FileHeader fileHeader;
    protected LocalFileHeader localFileHeader;
    protected OutputStream outputStream;
    private byte pendingBuffer[];
    private int pendingBufferLength;
    private File sourceFile;
    private long totalBytesRead;
    private long totalBytesWritten;
    protected ZipModel zipModel;
    protected ZipParameters zipParameters;

    public CipherOutputStream(OutputStream outputstream, ZipModel zipmodel)
    {
        outputStream = outputstream;
        initZipModel(zipmodel);
        crc = new CRC32();
        totalBytesWritten = 0L;
        bytesWrittenForThisFile = 0L;
        pendingBuffer = new byte[16];
        pendingBufferLength = 0;
        totalBytesRead = 0L;
    }

    private void createFileHeader()
        throws ZipException
    {
        String s;
        fileHeader = new FileHeader();
        fileHeader.setSignature(0x2014b50);
        fileHeader.setVersionMadeBy(20);
        fileHeader.setVersionNeededToExtract(20);
        if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == 99)
        {
            fileHeader.setCompressionMethod(99);
            fileHeader.setAesExtraDataRecord(generateAESExtraDataRecord(zipParameters));
        } else
        {
            fileHeader.setCompressionMethod(zipParameters.getCompressionMethod());
        }
        if (zipParameters.isEncryptFiles())
        {
            fileHeader.setEncrypted(true);
            fileHeader.setEncryptionMethod(zipParameters.getEncryptionMethod());
        }
        if (zipParameters.isSourceExternalStream())
        {
            fileHeader.setLastModFileTime((int)Zip4jUtil.javaToDosTime(System.currentTimeMillis()));
            if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getFileNameInZip()))
            {
                throw new ZipException("fileNameInZip is null or empty");
            }
            s = zipParameters.getFileNameInZip();
        } else
        {
            fileHeader.setLastModFileTime((int)Zip4jUtil.javaToDosTime(Zip4jUtil.getLastModifiedFileTime(sourceFile, zipParameters.getTimeZone())));
            fileHeader.setUncompressedSize(sourceFile.length());
            s = Zip4jUtil.getRelativeFileName(sourceFile.getAbsolutePath(), zipParameters.getRootFolderInZip(), zipParameters.getDefaultFolderPath());
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("fileName is null or empty. unable to create file header");
        }
        fileHeader.setFileName(s);
        byte abyte0[];
        int i;
        if (Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset()))
        {
            fileHeader.setFileNameLength(Zip4jUtil.getEncodedStringLength(s, zipModel.getFileNameCharset()));
        } else
        {
            fileHeader.setFileNameLength(Zip4jUtil.getEncodedStringLength(s));
        }
        if (outputStream instanceof SplitOutputStream)
        {
            fileHeader.setDiskNumberStart(((SplitOutputStream)outputStream).getCurrSplitFileCounter());
        } else
        {
            fileHeader.setDiskNumberStart(0);
        }
        i = 0;
        if (!zipParameters.isSourceExternalStream())
        {
            i = getFileAttributes(sourceFile);
        }
        abyte0 = new byte[4];
        abyte0[0] = (byte)i;
        fileHeader.setExternalFileAttr(abyte0);
        if (zipParameters.isSourceExternalStream())
        {
            FileHeader fileheader = fileHeader;
            boolean flag;
            if (!s.endsWith("/") && !s.endsWith("\\"))
            {
                flag = false;
            } else
            {
                flag = true;
            }
            fileheader.setDirectory(flag);
        } else
        {
            fileHeader.setDirectory(sourceFile.isDirectory());
        }
        if (!fileHeader.isDirectory()) goto _L2; else goto _L1
_L1:
        fileHeader.setCompressedSize(0L);
        fileHeader.setUncompressedSize(0L);
_L4:
        if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == 0)
        {
            fileHeader.setCrc32(zipParameters.getSourceFileCRC());
        }
        s = new byte[2];
        s[0] = Raw.bitArrayToByte(generateGeneralPurposeBitArray(fileHeader.isEncrypted(), zipParameters.getCompressionMethod()));
        flag = Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset());
        int j;
        long l;
        if (flag && zipModel.getFileNameCharset().equalsIgnoreCase("UTF8") || !flag && Zip4jUtil.detectCharSet(fileHeader.getFileName()).equals("UTF8"))
        {
            s[1] = 8;
        } else
        {
            s[1] = 0;
        }
        fileHeader.setGeneralPurposeFlag(s);
        return;
_L2:
        if (zipParameters.isSourceExternalStream()) goto _L4; else goto _L3
_L3:
        l = Zip4jUtil.getFileLengh(sourceFile);
        if (zipParameters.getCompressionMethod() != 0)
        {
            break MISSING_BLOCK_LABEL_786;
        }
        if (zipParameters.getEncryptionMethod() != 0) goto _L6; else goto _L5
_L5:
        fileHeader.setCompressedSize(12L + l);
_L7:
        fileHeader.setUncompressedSize(l);
          goto _L4
_L6:
        if (zipParameters.getEncryptionMethod() != 99)
        {
            break MISSING_BLOCK_LABEL_775;
        }
        switch (zipParameters.getAesKeyStrength())
        {
        case 2: // '\002'
        default:
            throw new ZipException("invalid aes key strength, cannot determine key sizes");

        case 3: // '\003'
            break MISSING_BLOCK_LABEL_769;

        case 1: // '\001'
            j = 8;
            break;
        }
_L8:
        fileHeader.setCompressedSize((long)j + l + 10L + 2L);
          goto _L7
        j = 16;
          goto _L8
        fileHeader.setCompressedSize(0L);
          goto _L7
        fileHeader.setCompressedSize(0L);
          goto _L7
    }

    private void createLocalFileHeader()
        throws ZipException
    {
        if (fileHeader == null)
        {
            throw new ZipException("file header is null, cannot create local file header");
        } else
        {
            localFileHeader = new LocalFileHeader();
            localFileHeader.setSignature(0x4034b50);
            localFileHeader.setVersionNeededToExtract(fileHeader.getVersionNeededToExtract());
            localFileHeader.setCompressionMethod(fileHeader.getCompressionMethod());
            localFileHeader.setLastModFileTime(fileHeader.getLastModFileTime());
            localFileHeader.setUncompressedSize(fileHeader.getUncompressedSize());
            localFileHeader.setFileNameLength(fileHeader.getFileNameLength());
            localFileHeader.setFileName(fileHeader.getFileName());
            localFileHeader.setEncrypted(fileHeader.isEncrypted());
            localFileHeader.setEncryptionMethod(fileHeader.getEncryptionMethod());
            localFileHeader.setAesExtraDataRecord(fileHeader.getAesExtraDataRecord());
            localFileHeader.setCrc32(fileHeader.getCrc32());
            localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
            localFileHeader.setGeneralPurposeFlag((byte[])fileHeader.getGeneralPurposeFlag().clone());
            return;
        }
    }

    private void encryptAndWrite(byte abyte0[], int i, int j)
        throws IOException
    {
        if (encrypter != null)
        {
            try
            {
                encrypter.encryptData(abyte0, i, j);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException(abyte0.getMessage());
            }
        }
        outputStream.write(abyte0, i, j);
        totalBytesWritten = totalBytesWritten + (long)j;
        bytesWrittenForThisFile = bytesWrittenForThisFile + (long)j;
    }

    private AESExtraDataRecord generateAESExtraDataRecord(ZipParameters zipparameters)
        throws ZipException
    {
        if (zipparameters == null)
        {
            throw new ZipException("zip parameters are null, cannot generate AES Extra Data record");
        }
        AESExtraDataRecord aesextradatarecord = new AESExtraDataRecord();
        aesextradatarecord.setSignature(39169L);
        aesextradatarecord.setDataSize(7);
        aesextradatarecord.setVendorID("AE");
        aesextradatarecord.setVersionNumber(2);
        if (zipparameters.getAesKeyStrength() == 1)
        {
            aesextradatarecord.setAesStrength(1);
        } else
        if (zipparameters.getAesKeyStrength() == 3)
        {
            aesextradatarecord.setAesStrength(3);
        } else
        {
            throw new ZipException("invalid AES key strength, cannot generate AES Extra data record");
        }
        aesextradatarecord.setCompressionMethod(zipparameters.getCompressionMethod());
        return aesextradatarecord;
    }

    private int[] generateGeneralPurposeBitArray(boolean flag, int i)
    {
        int ai[] = new int[8];
        if (flag)
        {
            ai[0] = 1;
        } else
        {
            ai[0] = 0;
        }
        if (i != 8)
        {
            ai[1] = 0;
            ai[2] = 0;
        }
        ai[3] = 1;
        return ai;
    }

    private int getFileAttributes(File file)
        throws ZipException
    {
        if (file == null)
        {
            throw new ZipException("input file is null, cannot get file attributes");
        }
        if (file.exists())
        {
            if (file.isDirectory())
            {
                return !file.isHidden() ? 16 : 18;
            }
            if (!file.canWrite() && file.isHidden())
            {
                return 3;
            }
            if (!file.canWrite())
            {
                return 1;
            }
            if (file.isHidden())
            {
                return 2;
            }
        }
        return 0;
    }

    private void initEncrypter()
        throws ZipException
    {
        if (!zipParameters.isEncryptFiles())
        {
            encrypter = null;
            return;
        }
        switch (zipParameters.getEncryptionMethod())
        {
        default:
            throw new ZipException("invalid encprytion method");

        case 0: // '\0'
            encrypter = new StandardEncrypter(zipParameters.getPassword(), (localFileHeader.getLastModFileTime() & 0xffff) << 16);
            return;

        case 99: // 'c'
            encrypter = new AESEncrpyter(zipParameters.getPassword(), zipParameters.getAesKeyStrength());
            break;
        }
    }

    private void initZipModel(ZipModel zipmodel)
    {
        if (zipmodel == null)
        {
            zipModel = new ZipModel();
        } else
        {
            zipModel = zipmodel;
        }
        if (zipModel.getEndCentralDirRecord() == null)
        {
            zipModel.setEndCentralDirRecord(new EndCentralDirRecord());
        }
        if (zipModel.getCentralDirectory() == null)
        {
            zipModel.setCentralDirectory(new CentralDirectory());
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null)
        {
            zipModel.getCentralDirectory().setFileHeaders(new ArrayList());
        }
        if (zipModel.getLocalFileHeaderList() == null)
        {
            zipModel.setLocalFileHeaderList(new ArrayList());
        }
        if ((outputStream instanceof SplitOutputStream) && ((SplitOutputStream)outputStream).isSplitZipFile())
        {
            zipModel.setSplitArchive(true);
            zipModel.setSplitLength(((SplitOutputStream)outputStream).getSplitLength());
        }
        zipModel.getEndCentralDirRecord().setSignature(0x6054b50L);
    }

    public void close()
        throws IOException
    {
        if (outputStream != null)
        {
            outputStream.close();
        }
    }

    public void closeEntry()
        throws IOException, ZipException
    {
label0:
        {
            if (pendingBufferLength != 0)
            {
                encryptAndWrite(pendingBuffer, 0, pendingBufferLength);
                pendingBufferLength = 0;
            }
            if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == 99)
            {
                if (!(encrypter instanceof AESEncrpyter))
                {
                    break label0;
                }
                outputStream.write(((AESEncrpyter)encrypter).getFinalMac());
                bytesWrittenForThisFile = bytesWrittenForThisFile + 10L;
                totalBytesWritten = totalBytesWritten + 10L;
            }
            fileHeader.setCompressedSize(bytesWrittenForThisFile);
            localFileHeader.setCompressedSize(bytesWrittenForThisFile);
            if (zipParameters.isSourceExternalStream())
            {
                fileHeader.setUncompressedSize(totalBytesRead);
                if (localFileHeader.getUncompressedSize() != totalBytesRead)
                {
                    localFileHeader.setUncompressedSize(totalBytesRead);
                }
            }
            long l1 = crc.getValue();
            long l = l1;
            if (fileHeader.isEncrypted())
            {
                l = l1;
                if (fileHeader.getEncryptionMethod() == 99)
                {
                    l = 0L;
                }
            }
            HeaderWriter headerwriter;
            if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == 99)
            {
                fileHeader.setCrc32(0L);
                localFileHeader.setCrc32(0L);
            } else
            {
                fileHeader.setCrc32(l);
                localFileHeader.setCrc32(l);
            }
            zipModel.getLocalFileHeaderList().add(localFileHeader);
            zipModel.getCentralDirectory().getFileHeaders().add(fileHeader);
            headerwriter = new HeaderWriter();
            totalBytesWritten = totalBytesWritten + (long)headerwriter.writeExtendedLocalHeader(localFileHeader, outputStream);
            crc.reset();
            bytesWrittenForThisFile = 0L;
            encrypter = null;
            totalBytesRead = 0L;
            return;
        }
        throw new ZipException("invalid encrypter for AES encrypted file");
    }

    public void decrementCompressedFileSize(int i)
    {
        while (i <= 0 || (long)i > bytesWrittenForThisFile) 
        {
            return;
        }
        bytesWrittenForThisFile = bytesWrittenForThisFile - (long)i;
    }

    public void finish()
        throws IOException, ZipException
    {
        zipModel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(totalBytesWritten);
        (new HeaderWriter()).finalizeZipFile(zipModel, outputStream);
    }

    public File getSourceFile()
    {
        return sourceFile;
    }

    public void putNextEntry(File file, ZipParameters zipparameters)
        throws ZipException
    {
        if (!zipparameters.isSourceExternalStream() && file == null)
        {
            throw new ZipException("input file is null");
        }
        if (!zipparameters.isSourceExternalStream() && !Zip4jUtil.checkFileExists(file))
        {
            throw new ZipException("input file does not exist");
        }
        sourceFile = file;
        zipParameters = (ZipParameters)zipparameters.clone();
        if (zipparameters.isSourceExternalStream()) goto _L2; else goto _L1
_L1:
        if (sourceFile.isDirectory())
        {
            zipParameters.setEncryptFiles(false);
            zipParameters.setEncryptionMethod(-1);
            zipParameters.setCompressionMethod(0);
        }
_L13:
        createFileHeader();
        createLocalFileHeader();
        if (zipModel.isSplitArchive() && (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() == 0))
        {
            file = new byte[4];
            Raw.writeIntLittleEndian(file, 0, 0x8074b50);
            outputStream.write(file);
            totalBytesWritten = totalBytesWritten + 4L;
        }
        if (!(outputStream instanceof SplitOutputStream)) goto _L4; else goto _L3
_L3:
        if (totalBytesWritten != 4L) goto _L6; else goto _L5
_L5:
        fileHeader.setOffsetLocalHeader(4L);
_L14:
        file = new HeaderWriter();
        totalBytesWritten = totalBytesWritten + (long)file.writeLocalFileHeader(zipModel, localFileHeader, outputStream);
        if (!zipParameters.isEncryptFiles()) goto _L8; else goto _L7
_L7:
        initEncrypter();
        if (encrypter == null) goto _L8; else goto _L9
_L9:
        if (zipparameters.getEncryptionMethod() != 0) goto _L11; else goto _L10
_L10:
        file = ((StandardEncrypter)encrypter).getHeaderBytes();
        outputStream.write(file);
        totalBytesWritten = totalBytesWritten + (long)file.length;
        bytesWrittenForThisFile = bytesWrittenForThisFile + (long)file.length;
_L8:
        crc.reset();
        return;
_L2:
        try
        {
            if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getFileNameInZip()))
            {
                throw new ZipException("file name is empty for external stream");
            }
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new ZipException(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw file;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new ZipException(file);
        }
        if (!zipParameters.getFileNameInZip().endsWith("/") && !zipParameters.getFileNameInZip().endsWith("\\")) goto _L13; else goto _L12
_L12:
        zipParameters.setEncryptFiles(false);
        zipParameters.setEncryptionMethod(-1);
        zipParameters.setCompressionMethod(0);
          goto _L13
_L6:
        fileHeader.setOffsetLocalHeader(((SplitOutputStream)outputStream).getFilePointer());
          goto _L14
_L4:
label0:
        {
            if (totalBytesWritten != 4L)
            {
                break label0;
            }
            fileHeader.setOffsetLocalHeader(4L);
        }
          goto _L14
        fileHeader.setOffsetLocalHeader(totalBytesWritten);
          goto _L14
_L11:
        if (zipparameters.getEncryptionMethod() != 99) goto _L8; else goto _L15
_L15:
        file = ((AESEncrpyter)encrypter).getSaltBytes();
        zipparameters = ((AESEncrpyter)encrypter).getDerivedPasswordVerifier();
        outputStream.write(file);
        outputStream.write(zipparameters);
        totalBytesWritten = totalBytesWritten + (long)(file.length + zipparameters.length);
        bytesWrittenForThisFile = bytesWrittenForThisFile + (long)(file.length + zipparameters.length);
          goto _L8
    }

    public void setSourceFile(File file)
    {
        sourceFile = file;
    }

    protected void updateTotalBytesRead(int i)
    {
        if (i > 0)
        {
            totalBytesRead = totalBytesRead + (long)i;
        }
    }

    public void write(int i)
        throws IOException
    {
        write(new byte[] {
            (byte)i
        }, 0, 1);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException();
        }
        if (abyte0.length == 0)
        {
            return;
        } else
        {
            write(abyte0, 0, abyte0.length);
            return;
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        int j1;
        j1 = i;
        i1 = j;
        if (!zipParameters.isEncryptFiles())
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = i;
        i1 = j;
        if (zipParameters.getEncryptionMethod() != 99)
        {
            continue; /* Loop/switch isn't completed */
        }
        int k = i;
        int l = j;
        if (pendingBufferLength != 0)
        {
            if (j < 16 - pendingBufferLength)
            {
                break MISSING_BLOCK_LABEL_208;
            }
            System.arraycopy(abyte0, i, pendingBuffer, pendingBufferLength, 16 - pendingBufferLength);
            encryptAndWrite(pendingBuffer, 0, pendingBuffer.length);
            k = 16 - pendingBufferLength;
            l = j - k;
            pendingBufferLength = 0;
        }
        j1 = k;
        i1 = l;
        if (l != 0)
        {
            j1 = k;
            i1 = l;
            if (l % 16 != 0)
            {
                System.arraycopy(abyte0, (l + k) - l % 16, pendingBuffer, 0, l % 16);
                pendingBufferLength = l % 16;
                i1 = l - pendingBufferLength;
                j1 = k;
            }
        }
        if (i1 == 0) goto _L1; else goto _L3
_L3:
        encryptAndWrite(abyte0, j1, i1);
        return;
        System.arraycopy(abyte0, i, pendingBuffer, pendingBufferLength, j);
        pendingBufferLength = pendingBufferLength + j;
        return;
    }
}
