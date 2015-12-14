// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;

import java.util.ArrayList;

// Referenced classes of package net.lingala.zip4j.model:
//            AESExtraDataRecord, Zip64ExtendedInfo

public class LocalFileHeader
{

    private AESExtraDataRecord aesExtraDataRecord;
    private long compressedSize;
    private int compressionMethod;
    private long crc32;
    private byte crcBuff[];
    private boolean dataDescriptorExists;
    private int encryptionMethod;
    private ArrayList extraDataRecords;
    private byte extraField[];
    private int extraFieldLength;
    private String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte generalPurposeFlag[];
    private boolean isEncrypted;
    private int lastModFileTime;
    private long offsetStartOfData;
    private char password[];
    private int signature;
    private long uncompressedSize;
    private int versionNeededToExtract;
    private boolean writeComprSizeInZip64ExtraRecord;
    private Zip64ExtendedInfo zip64ExtendedInfo;

    public LocalFileHeader()
    {
        encryptionMethod = -1;
        writeComprSizeInZip64ExtraRecord = false;
        crc32 = 0L;
        uncompressedSize = 0L;
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
        return crc32;
    }

    public byte[] getCrcBuff()
    {
        return crcBuff;
    }

    public int getEncryptionMethod()
    {
        return encryptionMethod;
    }

    public ArrayList getExtraDataRecords()
    {
        return extraDataRecords;
    }

    public byte[] getExtraField()
    {
        return extraField;
    }

    public int getExtraFieldLength()
    {
        return extraFieldLength;
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

    public int getLastModFileTime()
    {
        return lastModFileTime;
    }

    public long getOffsetStartOfData()
    {
        return offsetStartOfData;
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

    public boolean isEncrypted()
    {
        return isEncrypted;
    }

    public boolean isFileNameUTF8Encoded()
    {
        return fileNameUTF8Encoded;
    }

    public boolean isWriteComprSizeInZip64ExtraRecord()
    {
        return writeComprSizeInZip64ExtraRecord;
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

    public void setEncrypted(boolean flag)
    {
        isEncrypted = flag;
    }

    public void setEncryptionMethod(int i)
    {
        encryptionMethod = i;
    }

    public void setExtraDataRecords(ArrayList arraylist)
    {
        extraDataRecords = arraylist;
    }

    public void setExtraField(byte abyte0[])
    {
        extraField = abyte0;
    }

    public void setExtraFieldLength(int i)
    {
        extraFieldLength = i;
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

    public void setLastModFileTime(int i)
    {
        lastModFileTime = i;
    }

    public void setOffsetStartOfData(long l)
    {
        offsetStartOfData = l;
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

    public void setVersionNeededToExtract(int i)
    {
        versionNeededToExtract = i;
    }

    public void setWriteComprSizeInZip64ExtraRecord(boolean flag)
    {
        writeComprSizeInZip64ExtraRecord = flag;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64extendedinfo)
    {
        zip64ExtendedInfo = zip64extendedinfo;
    }
}
