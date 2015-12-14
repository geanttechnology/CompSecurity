// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;

import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.Unzip;
import net.lingala.zip4j.util.Zip4jUtil;

// Referenced classes of package net.lingala.zip4j.model:
//            AESExtraDataRecord, Zip64ExtendedInfo, ZipModel, UnzipParameters

public class FileHeader
{

    private AESExtraDataRecord aesExtraDataRecord;
    private long compressedSize;
    private int compressionMethod;
    private long crc32;
    private byte crcBuff[];
    private boolean dataDescriptorExists;
    private int diskNumberStart;
    private int encryptionMethod;
    private byte externalFileAttr[];
    private ArrayList extraDataRecords;
    private int extraFieldLength;
    private String fileComment;
    private int fileCommentLength;
    private String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte generalPurposeFlag[];
    private byte internalFileAttr[];
    private boolean isDirectory;
    private boolean isEncrypted;
    private int lastModFileTime;
    private long offsetLocalHeader;
    private char password[];
    private int signature;
    private long uncompressedSize;
    private int versionMadeBy;
    private int versionNeededToExtract;
    private Zip64ExtendedInfo zip64ExtendedInfo;

    public FileHeader()
    {
        encryptionMethod = -1;
        crc32 = 0L;
        uncompressedSize = 0L;
    }

    public void extractFile(ZipModel zipmodel, String s, UnzipParameters unzipparameters, String s1, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("input zipModel is null");
        }
        if (!Zip4jUtil.checkOutputFolder(s))
        {
            throw new ZipException("Invalid output path");
        }
        if (this == null)
        {
            throw new ZipException("invalid file header");
        } else
        {
            (new Unzip(zipmodel)).extractFile(this, s, unzipparameters, s1, progressmonitor, flag);
            return;
        }
    }

    public void extractFile(ZipModel zipmodel, String s, UnzipParameters unzipparameters, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        extractFile(zipmodel, s, unzipparameters, null, progressmonitor, flag);
    }

    public void extractFile(ZipModel zipmodel, String s, ProgressMonitor progressmonitor, boolean flag)
        throws ZipException
    {
        extractFile(zipmodel, s, null, progressmonitor, flag);
    }

    public AESExtraDataRecord getAesExtraDataRecord()
    {
        return aesExtraDataRecord;
    }

    public long getCompressedSize()
    {
        return compressedSize;
    }

    public int getCompressionMethod()
    {
        return compressionMethod;
    }

    public long getCrc32()
    {
        return crc32 & 0xffffffffL;
    }

    public byte[] getCrcBuff()
    {
        return crcBuff;
    }

    public int getDiskNumberStart()
    {
        return diskNumberStart;
    }

    public int getEncryptionMethod()
    {
        return encryptionMethod;
    }

    public byte[] getExternalFileAttr()
    {
        return externalFileAttr;
    }

    public ArrayList getExtraDataRecords()
    {
        return extraDataRecords;
    }

    public int getExtraFieldLength()
    {
        return extraFieldLength;
    }

    public String getFileComment()
    {
        return fileComment;
    }

    public int getFileCommentLength()
    {
        return fileCommentLength;
    }

    public String getFileName()
    {
        return fileName;
    }

    public int getFileNameLength()
    {
        return fileNameLength;
    }

    public byte[] getGeneralPurposeFlag()
    {
        return generalPurposeFlag;
    }

    public byte[] getInternalFileAttr()
    {
        return internalFileAttr;
    }

    public int getLastModFileTime()
    {
        return lastModFileTime;
    }

    public long getOffsetLocalHeader()
    {
        return offsetLocalHeader;
    }

    public char[] getPassword()
    {
        return password;
    }

    public int getSignature()
    {
        return signature;
    }

    public long getUncompressedSize()
    {
        return uncompressedSize;
    }

    public int getVersionMadeBy()
    {
        return versionMadeBy;
    }

    public int getVersionNeededToExtract()
    {
        return versionNeededToExtract;
    }

    public Zip64ExtendedInfo getZip64ExtendedInfo()
    {
        return zip64ExtendedInfo;
    }

    public boolean isDataDescriptorExists()
    {
        return dataDescriptorExists;
    }

    public boolean isDirectory()
    {
        return isDirectory;
    }

    public boolean isEncrypted()
    {
        return isEncrypted;
    }

    public boolean isFileNameUTF8Encoded()
    {
        return fileNameUTF8Encoded;
    }

    public void setAesExtraDataRecord(AESExtraDataRecord aesextradatarecord)
    {
        aesExtraDataRecord = aesextradatarecord;
    }

    public void setCompressedSize(long l)
    {
        compressedSize = l;
    }

    public void setCompressionMethod(int i)
    {
        compressionMethod = i;
    }

    public void setCrc32(long l)
    {
        crc32 = l;
    }

    public void setCrcBuff(byte abyte0[])
    {
        crcBuff = abyte0;
    }

    public void setDataDescriptorExists(boolean flag)
    {
        dataDescriptorExists = flag;
    }

    public void setDirectory(boolean flag)
    {
        isDirectory = flag;
    }

    public void setDiskNumberStart(int i)
    {
        diskNumberStart = i;
    }

    public void setEncrypted(boolean flag)
    {
        isEncrypted = flag;
    }

    public void setEncryptionMethod(int i)
    {
        encryptionMethod = i;
    }

    public void setExternalFileAttr(byte abyte0[])
    {
        externalFileAttr = abyte0;
    }

    public void setExtraDataRecords(ArrayList arraylist)
    {
        extraDataRecords = arraylist;
    }

    public void setExtraFieldLength(int i)
    {
        extraFieldLength = i;
    }

    public void setFileComment(String s)
    {
        fileComment = s;
    }

    public void setFileCommentLength(int i)
    {
        fileCommentLength = i;
    }

    public void setFileName(String s)
    {
        fileName = s;
    }

    public void setFileNameLength(int i)
    {
        fileNameLength = i;
    }

    public void setFileNameUTF8Encoded(boolean flag)
    {
        fileNameUTF8Encoded = flag;
    }

    public void setGeneralPurposeFlag(byte abyte0[])
    {
        generalPurposeFlag = abyte0;
    }

    public void setInternalFileAttr(byte abyte0[])
    {
        internalFileAttr = abyte0;
    }

    public void setLastModFileTime(int i)
    {
        lastModFileTime = i;
    }

    public void setOffsetLocalHeader(long l)
    {
        offsetLocalHeader = l;
    }

    public void setPassword(char ac[])
    {
        password = ac;
    }

    public void setSignature(int i)
    {
        signature = i;
    }

    public void setUncompressedSize(long l)
    {
        uncompressedSize = l;
    }

    public void setVersionMadeBy(int i)
    {
        versionMadeBy = i;
    }

    public void setVersionNeededToExtract(int i)
    {
        versionNeededToExtract = i;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64extendedinfo)
    {
        zip64ExtendedInfo = zip64extendedinfo;
    }
}
