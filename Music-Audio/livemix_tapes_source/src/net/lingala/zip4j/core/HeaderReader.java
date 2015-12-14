// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.core;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.DigitalSignature;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndCentralDirLocator;
import net.lingala.zip4j.model.Zip64EndCentralDirRecord;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderReader
{

    private RandomAccessFile zip4jRaf;
    private ZipModel zipModel;

    public HeaderReader(RandomAccessFile randomaccessfile)
    {
        zip4jRaf = null;
        zip4jRaf = randomaccessfile;
    }

    private byte[] getLongByteFromIntByte(byte abyte0[])
        throws ZipException
    {
        if (abyte0 == null)
        {
            throw new ZipException("input parameter is null, cannot expand to 8 bytes");
        }
        if (abyte0.length != 4)
        {
            throw new ZipException("invalid byte length, cannot expand to 8 bytes");
        } else
        {
            byte abyte1[] = new byte[8];
            abyte1[0] = abyte0[0];
            abyte1[1] = abyte0[1];
            abyte1[2] = abyte0[2];
            abyte1[3] = abyte0[3];
            return abyte1;
        }
    }

    private AESExtraDataRecord readAESExtraDataRecord(ArrayList arraylist)
        throws ZipException
    {
        if (arraylist != null)
        {
            int i = 0;
            while (i < arraylist.size()) 
            {
                ExtraDataRecord extradatarecord = (ExtraDataRecord)arraylist.get(i);
                if (extradatarecord == null || extradatarecord.getHeader() != 39169L)
                {
                    i++;
                } else
                if (extradatarecord.getData() == null)
                {
                    throw new ZipException("corrput AES extra data records");
                } else
                {
                    arraylist = new AESExtraDataRecord();
                    arraylist.setSignature(39169L);
                    arraylist.setDataSize(extradatarecord.getSizeOfData());
                    byte abyte0[] = extradatarecord.getData();
                    arraylist.setVersionNumber(Raw.readShortLittleEndian(abyte0, 0));
                    byte abyte1[] = new byte[2];
                    System.arraycopy(abyte0, 2, abyte1, 0, 2);
                    arraylist.setVendorID(new String(abyte1));
                    arraylist.setAesStrength(abyte0[4] & 0xff);
                    arraylist.setCompressionMethod(Raw.readShortLittleEndian(abyte0, 5));
                    return arraylist;
                }
            }
        }
        return null;
    }

    private void readAndSaveAESExtraDataRecord(FileHeader fileheader)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        }
        AESExtraDataRecord aesextradatarecord;
        if (fileheader.getExtraDataRecords() != null && fileheader.getExtraDataRecords().size() > 0)
        {
            if ((aesextradatarecord = readAESExtraDataRecord(fileheader.getExtraDataRecords())) != null)
            {
                fileheader.setAesExtraDataRecord(aesextradatarecord);
                fileheader.setEncryptionMethod(99);
                return;
            }
        }
    }

    private void readAndSaveAESExtraDataRecord(LocalFileHeader localfileheader)
        throws ZipException
    {
        if (localfileheader == null)
        {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        }
        AESExtraDataRecord aesextradatarecord;
        if (localfileheader.getExtraDataRecords() != null && localfileheader.getExtraDataRecords().size() > 0)
        {
            if ((aesextradatarecord = readAESExtraDataRecord(localfileheader.getExtraDataRecords())) != null)
            {
                localfileheader.setAesExtraDataRecord(aesextradatarecord);
                localfileheader.setEncryptionMethod(99);
                return;
            }
        }
    }

    private void readAndSaveExtraDataRecord(FileHeader fileheader)
        throws ZipException
    {
        if (zip4jRaf == null)
        {
            throw new ZipException("invalid file handler when trying to read extra data record");
        }
        if (fileheader == null)
        {
            throw new ZipException("file header is null");
        }
        int i = fileheader.getExtraFieldLength();
        if (i <= 0)
        {
            return;
        } else
        {
            fileheader.setExtraDataRecords(readExtraDataRecords(i));
            return;
        }
    }

    private void readAndSaveExtraDataRecord(LocalFileHeader localfileheader)
        throws ZipException
    {
        if (zip4jRaf == null)
        {
            throw new ZipException("invalid file handler when trying to read extra data record");
        }
        if (localfileheader == null)
        {
            throw new ZipException("file header is null");
        }
        int i = localfileheader.getExtraFieldLength();
        if (i <= 0)
        {
            return;
        } else
        {
            localfileheader.setExtraDataRecords(readExtraDataRecords(i));
            return;
        }
    }

    private void readAndSaveZip64ExtendedInfo(FileHeader fileheader)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        }
        Zip64ExtendedInfo zip64extendedinfo;
        if (fileheader.getExtraDataRecords() != null && fileheader.getExtraDataRecords().size() > 0)
        {
            if ((zip64extendedinfo = readZip64ExtendedInfo(fileheader.getExtraDataRecords(), fileheader.getUncompressedSize(), fileheader.getCompressedSize(), fileheader.getOffsetLocalHeader(), fileheader.getDiskNumberStart())) != null)
            {
                fileheader.setZip64ExtendedInfo(zip64extendedinfo);
                if (zip64extendedinfo.getUnCompressedSize() != -1L)
                {
                    fileheader.setUncompressedSize(zip64extendedinfo.getUnCompressedSize());
                }
                if (zip64extendedinfo.getCompressedSize() != -1L)
                {
                    fileheader.setCompressedSize(zip64extendedinfo.getCompressedSize());
                }
                if (zip64extendedinfo.getOffsetLocalHeader() != -1L)
                {
                    fileheader.setOffsetLocalHeader(zip64extendedinfo.getOffsetLocalHeader());
                }
                if (zip64extendedinfo.getDiskNumberStart() != -1)
                {
                    fileheader.setDiskNumberStart(zip64extendedinfo.getDiskNumberStart());
                    return;
                }
            }
        }
    }

    private void readAndSaveZip64ExtendedInfo(LocalFileHeader localfileheader)
        throws ZipException
    {
        if (localfileheader == null)
        {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        }
        Zip64ExtendedInfo zip64extendedinfo;
        if (localfileheader.getExtraDataRecords() != null && localfileheader.getExtraDataRecords().size() > 0)
        {
            if ((zip64extendedinfo = readZip64ExtendedInfo(localfileheader.getExtraDataRecords(), localfileheader.getUncompressedSize(), localfileheader.getCompressedSize(), -1L, -1)) != null)
            {
                localfileheader.setZip64ExtendedInfo(zip64extendedinfo);
                if (zip64extendedinfo.getUnCompressedSize() != -1L)
                {
                    localfileheader.setUncompressedSize(zip64extendedinfo.getUnCompressedSize());
                }
                if (zip64extendedinfo.getCompressedSize() != -1L)
                {
                    localfileheader.setCompressedSize(zip64extendedinfo.getCompressedSize());
                    return;
                }
            }
        }
    }

    private CentralDirectory readCentralDirectory()
        throws ZipException
    {
        Object obj;
        CentralDirectory centraldirectory;
        ArrayList arraylist;
        byte abyte2[];
        byte abyte3[];
        FileHeader fileheader;
        int i;
        int j;
        int k;
        if (zip4jRaf == null)
        {
            throw new ZipException("random access file was null", 3);
        }
        if (zipModel.getEndCentralDirRecord() == null)
        {
            throw new ZipException("EndCentralRecord was null, maybe a corrupt zip file");
        }
        try
        {
            centraldirectory = new CentralDirectory();
            arraylist = new ArrayList();
            EndCentralDirRecord endcentraldirrecord = zipModel.getEndCentralDirRecord();
            long l1 = endcentraldirrecord.getOffsetOfStartOfCentralDir();
            i = endcentraldirrecord.getTotNoOfEntriesInCentralDir();
            if (zipModel.isZip64Format())
            {
                l1 = zipModel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo();
                i = (int)zipModel.getZip64EndCentralDirRecord().getTotNoOfEntriesInCentralDir();
            }
            zip4jRaf.seek(l1);
            abyte2 = new byte[4];
            abyte3 = new byte[2];
            byte abyte0[] = new byte[8];
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ZipException(((Throwable) (obj)));
        }
        j = 0;
_L7:
        if (j < i)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        centraldirectory.setFileHeaders(arraylist);
        obj = new DigitalSignature();
        readIntoBuff(zip4jRaf, abyte2);
        i = Raw.readIntLittleEndian(abyte2, 0);
        if ((long)i != 0x5054b50L)
        {
            return centraldirectory;
        }
        break MISSING_BLOCK_LABEL_973;
        fileheader = new FileHeader();
        readIntoBuff(zip4jRaf, abyte2);
        k = Raw.readIntLittleEndian(abyte2, 0);
        if ((long)k == 0x2014b50L)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        throw new ZipException("Expected central directory entry not found (#" + (j + 1) + ")");
        fileheader.setSignature(k);
        readIntoBuff(zip4jRaf, abyte3);
        fileheader.setVersionMadeBy(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        fileheader.setVersionNeededToExtract(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        Object obj1;
        int l;
        boolean flag;
        if ((Raw.readShortLittleEndian(abyte3, 0) & 0x800) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        fileheader.setFileNameUTF8Encoded(flag);
        k = abyte3[0];
        if ((k & 1) == 0)
        {
            break MISSING_BLOCK_LABEL_375;
        }
        fileheader.setEncrypted(true);
        fileheader.setGeneralPurposeFlag((byte[])abyte3.clone());
        if (k >> 3 == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        fileheader.setDataDescriptorExists(flag);
        readIntoBuff(zip4jRaf, abyte3);
        fileheader.setCompressionMethod(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte2);
        fileheader.setLastModFileTime(Raw.readIntLittleEndian(abyte2, 0));
        readIntoBuff(zip4jRaf, abyte2);
        fileheader.setCrc32(Raw.readIntLittleEndian(abyte2, 0));
        fileheader.setCrcBuff((byte[])abyte2.clone());
        readIntoBuff(zip4jRaf, abyte2);
        fileheader.setCompressedSize(Raw.readLongLittleEndian(getLongByteFromIntByte(abyte2), 0));
        readIntoBuff(zip4jRaf, abyte2);
        fileheader.setUncompressedSize(Raw.readLongLittleEndian(getLongByteFromIntByte(abyte2), 0));
        readIntoBuff(zip4jRaf, abyte3);
        k = Raw.readShortLittleEndian(abyte3, 0);
        fileheader.setFileNameLength(k);
        readIntoBuff(zip4jRaf, abyte3);
        fileheader.setExtraFieldLength(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        l = Raw.readShortLittleEndian(abyte3, 0);
        fileheader.setFileComment(new String(abyte3));
        readIntoBuff(zip4jRaf, abyte3);
        fileheader.setDiskNumberStart(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        fileheader.setInternalFileAttr((byte[])abyte3.clone());
        readIntoBuff(zip4jRaf, abyte2);
        fileheader.setExternalFileAttr((byte[])abyte2.clone());
        readIntoBuff(zip4jRaf, abyte2);
        fileheader.setOffsetLocalHeader(Raw.readLongLittleEndian(getLongByteFromIntByte(abyte2), 0) & 0xffffffffL);
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_964;
        }
        obj = new byte[k];
        readIntoBuff(zip4jRaf, ((byte []) (obj)));
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset())) goto _L2; else goto _L1
_L1:
        obj = new String(((byte []) (obj)), zipModel.getFileNameCharset());
_L4:
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        throw new ZipException("fileName is null when reading central directory");
_L2:
        obj = Zip4jUtil.decodeFileName(((byte []) (obj)), fileheader.isFileNameUTF8Encoded());
        if (true) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        if (((String) (obj)).indexOf(":" + System.getProperty("file.separator")) >= 0)
        {
            obj1 = ((String) (obj)).substring(((String) (obj)).indexOf(":" + System.getProperty("file.separator")) + 2);
        }
        fileheader.setFileName(((String) (obj1)));
        if (!((String) (obj1)).endsWith("/") && !((String) (obj1)).endsWith("\\"))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        fileheader.setDirectory(flag);
_L5:
        readAndSaveExtraDataRecord(fileheader);
        readAndSaveZip64ExtendedInfo(fileheader);
        readAndSaveAESExtraDataRecord(fileheader);
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_947;
        }
        obj = new byte[l];
        readIntoBuff(zip4jRaf, ((byte []) (obj)));
        fileheader.setFileComment(new String(((byte []) (obj))));
        arraylist.add(fileheader);
        j++;
        continue; /* Loop/switch isn't completed */
        fileheader.setFileName(null);
          goto _L5
        ((DigitalSignature) (obj)).setHeaderSignature(i);
        readIntoBuff(zip4jRaf, abyte3);
        i = Raw.readShortLittleEndian(abyte3, 0);
        ((DigitalSignature) (obj)).setSizeOfData(i);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_1036;
        }
        byte abyte1[] = new byte[i];
        readIntoBuff(zip4jRaf, abyte1);
        ((DigitalSignature) (obj)).setSignatureData(new String(abyte1));
        return centraldirectory;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private EndCentralDirRecord readEndOfCentralDirectoryRecord()
        throws ZipException
    {
        Object obj;
        long l;
        if (zip4jRaf == null)
        {
            throw new ZipException("random access file was null", 3);
        }
        byte abyte0[];
        int i;
        try
        {
            abyte0 = new byte[4];
            l = zip4jRaf.length();
            obj = new EndCentralDirRecord();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ZipException("Probably not a zip file or a corrupted zip file", ((Throwable) (obj)), 4);
        }
        i = 0;
        l -= 22L;
_L3:
        zip4jRaf.seek(l);
        i++;
        if ((long)Raw.readLeInt(zip4jRaf, abyte0) != 0x6054b50L && i <= 3000)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        if ((long)Raw.readIntLittleEndian(abyte0, 0) != 0x6054b50L)
        {
            throw new ZipException("zip headers not found. probably not a zip file");
        }
        int j;
        byte abyte1[] = new byte[4];
        byte abyte3[] = new byte[2];
        ((EndCentralDirRecord) (obj)).setSignature(0x6054b50L);
        readIntoBuff(zip4jRaf, abyte3);
        ((EndCentralDirRecord) (obj)).setNoOfThisDisk(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        ((EndCentralDirRecord) (obj)).setNoOfThisDiskStartOfCentralDir(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        ((EndCentralDirRecord) (obj)).setTotNoOfEntriesInCentralDirOnThisDisk(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        ((EndCentralDirRecord) (obj)).setTotNoOfEntriesInCentralDir(Raw.readShortLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte1);
        ((EndCentralDirRecord) (obj)).setSizeOfCentralDir(Raw.readIntLittleEndian(abyte1, 0));
        readIntoBuff(zip4jRaf, abyte1);
        ((EndCentralDirRecord) (obj)).setOffsetOfStartOfCentralDir(Raw.readLongLittleEndian(getLongByteFromIntByte(abyte1), 0));
        readIntoBuff(zip4jRaf, abyte3);
        j = Raw.readShortLittleEndian(abyte3, 0);
        ((EndCentralDirRecord) (obj)).setCommentLength(j);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        byte abyte2[] = new byte[j];
        readIntoBuff(zip4jRaf, abyte2);
        ((EndCentralDirRecord) (obj)).setComment(new String(abyte2));
        ((EndCentralDirRecord) (obj)).setCommentBytes(abyte2);
_L1:
        if (((EndCentralDirRecord) (obj)).getNoOfThisDisk() <= 0)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        zipModel.setSplitArchive(true);
        return ((EndCentralDirRecord) (obj));
        ((EndCentralDirRecord) (obj)).setComment(null);
          goto _L1
        zipModel.setSplitArchive(false);
        return ((EndCentralDirRecord) (obj));
        l--;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private ArrayList readExtraDataRecords(int i)
        throws ZipException
    {
        if (i > 0) goto _L2; else goto _L1
_L1:
        byte abyte0[] = null;
_L5:
        return abyte0;
_L2:
        int j;
        ArrayList arraylist;
        ExtraDataRecord extradatarecord;
        byte abyte1[];
        int k;
        int l;
        try
        {
            abyte0 = new byte[i];
            zip4jRaf.read(abyte0);
        }
        catch (IOException ioexception)
        {
            throw new ZipException(ioexception);
        }
        j = 0;
        arraylist = new ArrayList();
          goto _L3
_L8:
        abyte0 = arraylist;
        if (arraylist.size() > 0) goto _L5; else goto _L4
_L4:
        return null;
_L9:
        extradatarecord = new ExtraDataRecord();
        extradatarecord.setHeader(Raw.readShortLittleEndian(abyte0, j));
        l = j + 2;
        k = Raw.readShortLittleEndian(abyte0, l);
        j = k;
        if (k + 2 <= i)
        {
            break; /* Loop/switch isn't completed */
        }
        j = Raw.readShortBigEndian(abyte0, l);
        if (j + 2 > i) goto _L7; else goto _L6
_L7:
        break; /* Loop/switch isn't completed */
_L6:
        extradatarecord.setSizeOfData(j);
        k = l + 2;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        abyte1 = new byte[j];
        System.arraycopy(abyte0, k, abyte1, 0, j);
        extradatarecord.setData(abyte1);
        j = k + j;
        arraylist.add(extradatarecord);
_L3:
        if (j < i) goto _L9; else goto _L8
    }

    private byte[] readIntoBuff(RandomAccessFile randomaccessfile, byte abyte0[])
        throws ZipException
    {
        if (randomaccessfile.read(abyte0, 0, abyte0.length) != -1)
        {
            return abyte0;
        }
        try
        {
            throw new ZipException("unexpected end of file when reading short buff");
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            throw new ZipException("IOException when reading short buff", randomaccessfile);
        }
    }

    private Zip64EndCentralDirLocator readZip64EndCentralDirLocator()
        throws ZipException
    {
        if (zip4jRaf == null)
        {
            throw new ZipException("invalid file handler when trying to read Zip64EndCentralDirLocator");
        }
        Zip64EndCentralDirLocator zip64endcentraldirlocator;
        byte abyte0[];
        byte abyte1[];
        int i;
        try
        {
            zip64endcentraldirlocator = new Zip64EndCentralDirLocator();
            setFilePointerToReadZip64EndCentralDirLoc();
            abyte0 = new byte[4];
            abyte1 = new byte[8];
            readIntoBuff(zip4jRaf, abyte0);
            i = Raw.readIntLittleEndian(abyte0, 0);
        }
        catch (Exception exception)
        {
            throw new ZipException(exception);
        }
        if ((long)i != 0x7064b50L)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        zipModel.setZip64Format(true);
        zip64endcentraldirlocator.setSignature(i);
        readIntoBuff(zip4jRaf, abyte0);
        zip64endcentraldirlocator.setNoOfDiskStartOfZip64EndOfCentralDirRec(Raw.readIntLittleEndian(abyte0, 0));
        readIntoBuff(zip4jRaf, abyte1);
        zip64endcentraldirlocator.setOffsetZip64EndOfCentralDirRec(Raw.readLongLittleEndian(abyte1, 0));
        readIntoBuff(zip4jRaf, abyte0);
        zip64endcentraldirlocator.setTotNumberOfDiscs(Raw.readIntLittleEndian(abyte0, 0));
        return zip64endcentraldirlocator;
        zipModel.setZip64Format(false);
        return null;
    }

    private Zip64EndCentralDirRecord readZip64EndCentralDirRec()
        throws ZipException
    {
        Object obj;
        byte abyte0[];
        byte abyte2[];
        byte abyte3[];
        int i;
        if (zipModel.getZip64EndCentralDirLocator() == null)
        {
            throw new ZipException("invalid zip64 end of central directory locator");
        }
        long l = zipModel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec();
        if (l < 0L)
        {
            throw new ZipException("invalid offset for start of end of central directory record");
        }
        try
        {
            zip4jRaf.seek(l);
            obj = new Zip64EndCentralDirRecord();
            abyte0 = new byte[2];
            abyte2 = new byte[4];
            abyte3 = new byte[8];
            readIntoBuff(zip4jRaf, abyte2);
            i = Raw.readIntLittleEndian(abyte2, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ZipException(((Throwable) (obj)));
        }
        if ((long)i == 0x6064b50L)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        throw new ZipException("invalid signature for zip64 end of central directory record");
        long l1 = i;
        ((Zip64EndCentralDirRecord) (obj)).setSignature(l1);
        readIntoBuff(zip4jRaf, abyte3);
        ((Zip64EndCentralDirRecord) (obj)).setSizeOfZip64EndCentralDirRec(Raw.readLongLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte0);
        ((Zip64EndCentralDirRecord) (obj)).setVersionMadeBy(Raw.readShortLittleEndian(abyte0, 0));
        readIntoBuff(zip4jRaf, abyte0);
        ((Zip64EndCentralDirRecord) (obj)).setVersionNeededToExtract(Raw.readShortLittleEndian(abyte0, 0));
        readIntoBuff(zip4jRaf, abyte2);
        ((Zip64EndCentralDirRecord) (obj)).setNoOfThisDisk(Raw.readIntLittleEndian(abyte2, 0));
        readIntoBuff(zip4jRaf, abyte2);
        ((Zip64EndCentralDirRecord) (obj)).setNoOfThisDiskStartOfCentralDir(Raw.readIntLittleEndian(abyte2, 0));
        readIntoBuff(zip4jRaf, abyte3);
        ((Zip64EndCentralDirRecord) (obj)).setTotNoOfEntriesInCentralDirOnThisDisk(Raw.readLongLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        ((Zip64EndCentralDirRecord) (obj)).setTotNoOfEntriesInCentralDir(Raw.readLongLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        ((Zip64EndCentralDirRecord) (obj)).setSizeOfCentralDir(Raw.readLongLittleEndian(abyte3, 0));
        readIntoBuff(zip4jRaf, abyte3);
        ((Zip64EndCentralDirRecord) (obj)).setOffsetStartCenDirWRTStartDiskNo(Raw.readLongLittleEndian(abyte3, 0));
        l1 = ((Zip64EndCentralDirRecord) (obj)).getSizeOfZip64EndCentralDirRec() - 44L;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        byte abyte1[] = new byte[(int)l1];
        readIntoBuff(zip4jRaf, abyte1);
        ((Zip64EndCentralDirRecord) (obj)).setExtensibleDataSector(abyte1);
        return ((Zip64EndCentralDirRecord) (obj));
    }

    private Zip64ExtendedInfo readZip64ExtendedInfo(ArrayList arraylist, long l, long l1, long l2, 
            int i)
        throws ZipException
    {
        int j = 0;
_L6:
        if (j < arraylist.size()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        ExtraDataRecord extradatarecord;
        byte abyte0[];
        extradatarecord = (ExtraDataRecord)arraylist.get(j);
        while (extradatarecord == null || extradatarecord.getHeader() != 1L) 
        {
            j++;
            continue; /* Loop/switch isn't completed */
        }
        arraylist = new Zip64ExtendedInfo();
        abyte0 = extradatarecord.getData();
        if (extradatarecord.getSizeOfData() <= 0) goto _L1; else goto _L3
_L3:
        boolean flag1;
        byte abyte1[] = new byte[8];
        byte abyte2[] = new byte[4];
        flag1 = false;
        int i1 = 0;
        int k = ((flag1) ? 1 : 0);
        boolean flag = i1;
        if ((65535L & l) == 65535L)
        {
            k = ((flag1) ? 1 : 0);
            flag = i1;
            if (extradatarecord.getSizeOfData() < 0)
            {
                System.arraycopy(abyte0, 0, abyte1, 0, 8);
                arraylist.setUnCompressedSize(Raw.readLongLittleEndian(abyte1, 0));
                k = 0 + 8;
                flag = true;
            }
        }
        i1 = k;
        flag1 = flag;
        if ((65535L & l1) == 65535L)
        {
            i1 = k;
            flag1 = flag;
            if (k < extradatarecord.getSizeOfData())
            {
                System.arraycopy(abyte0, k, abyte1, 0, 8);
                arraylist.setCompressedSize(Raw.readLongLittleEndian(abyte1, 0));
                i1 = k + 8;
                flag1 = true;
            }
        }
        k = i1;
        flag = flag1;
        if ((65535L & l2) == 65535L)
        {
            k = i1;
            flag = flag1;
            if (i1 < extradatarecord.getSizeOfData())
            {
                System.arraycopy(abyte0, i1, abyte1, 0, 8);
                arraylist.setOffsetLocalHeader(Raw.readLongLittleEndian(abyte1, 0));
                k = i1 + 8;
                flag = true;
            }
        }
        flag1 = flag;
        if ((0xffff & i) == 65535)
        {
            flag1 = flag;
            if (k < extradatarecord.getSizeOfData())
            {
                System.arraycopy(abyte0, k, abyte2, 0, 4);
                arraylist.setDiskNumberStart(Raw.readIntLittleEndian(abyte2, 0));
                flag1 = true;
            }
        }
        if (!flag1) goto _L1; else goto _L4
_L4:
        return arraylist;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void setFilePointerToReadZip64EndCentralDirLoc()
        throws ZipException
    {
        byte abyte0[];
        long l;
        abyte0 = new byte[4];
        l = zip4jRaf.length() - 22L;
_L1:
        zip4jRaf.seek(l);
        if ((long)Raw.readLeInt(zip4jRaf, abyte0) == 0x6054b50L)
        {
            zip4jRaf.seek(zip4jRaf.getFilePointer() - 4L - 4L - 8L - 4L - 4L);
            return;
        }
        break MISSING_BLOCK_LABEL_85;
        IOException ioexception;
        ioexception;
        throw new ZipException(ioexception);
        l--;
          goto _L1
    }

    public ZipModel readAllHeaders()
        throws ZipException
    {
        return readAllHeaders(null);
    }

    public ZipModel readAllHeaders(String s)
        throws ZipException
    {
        zipModel = new ZipModel();
        zipModel.setFileNameCharset(s);
        zipModel.setEndCentralDirRecord(readEndOfCentralDirectoryRecord());
        zipModel.setZip64EndCentralDirLocator(readZip64EndCentralDirLocator());
        if (zipModel.isZip64Format())
        {
            zipModel.setZip64EndCentralDirRecord(readZip64EndCentralDirRec());
            if (zipModel.getZip64EndCentralDirRecord() != null && zipModel.getZip64EndCentralDirRecord().getNoOfThisDisk() > 0)
            {
                zipModel.setSplitArchive(true);
            } else
            {
                zipModel.setSplitArchive(false);
            }
        }
        zipModel.setCentralDirectory(readCentralDirectory());
        return zipModel;
    }

    public LocalFileHeader readLocalFileHeader(FileHeader fileheader)
        throws ZipException
    {
        byte abyte0[];
        byte abyte2[];
        LocalFileHeader localfileheader;
        int i;
        long l;
        if (fileheader == null || zip4jRaf == null)
        {
            throw new ZipException("invalid read parameters for local header");
        }
        long l1 = fileheader.getOffsetLocalHeader();
        l = l1;
        if (fileheader.getZip64ExtendedInfo() != null)
        {
            l = l1;
            if (fileheader.getZip64ExtendedInfo().getOffsetLocalHeader() > 0L)
            {
                l = fileheader.getOffsetLocalHeader();
            }
        }
        if (l < 0L)
        {
            throw new ZipException("invalid local header offset");
        }
        try
        {
            zip4jRaf.seek(l);
            localfileheader = new LocalFileHeader();
            abyte0 = new byte[2];
            abyte2 = new byte[4];
            byte abyte3[] = new byte[8];
            readIntoBuff(zip4jRaf, abyte2);
            i = Raw.readIntLittleEndian(abyte2, 0);
        }
        // Misplaced declaration of an exception variable
        catch (FileHeader fileheader)
        {
            throw new ZipException(fileheader);
        }
        if ((long)i == 0x4034b50L)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        throw new ZipException("invalid local header signature for file: " + fileheader.getFileName());
        localfileheader.setSignature(i);
        readIntoBuff(zip4jRaf, abyte0);
        localfileheader.setVersionNeededToExtract(Raw.readShortLittleEndian(abyte0, 0));
        readIntoBuff(zip4jRaf, abyte0);
        String s;
        String s1;
        String s2;
        byte byte0;
        int j;
        int k;
        boolean flag;
        if ((Raw.readShortLittleEndian(abyte0, 0) & 0x800) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        localfileheader.setFileNameUTF8Encoded(flag);
        byte0 = abyte0[0];
        if ((byte0 & 1) == 0)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        localfileheader.setEncrypted(true);
        localfileheader.setGeneralPurposeFlag(abyte0);
        s2 = Integer.toBinaryString(byte0);
        if (s2.length() < 4)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        if (s2.charAt(3) == '1')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        localfileheader.setDataDescriptorExists(flag);
        readIntoBuff(zip4jRaf, abyte0);
        localfileheader.setCompressionMethod(Raw.readShortLittleEndian(abyte0, 0));
        readIntoBuff(zip4jRaf, abyte2);
        localfileheader.setLastModFileTime(Raw.readIntLittleEndian(abyte2, 0));
        readIntoBuff(zip4jRaf, abyte2);
        localfileheader.setCrc32(Raw.readIntLittleEndian(abyte2, 0));
        localfileheader.setCrcBuff((byte[])abyte2.clone());
        readIntoBuff(zip4jRaf, abyte2);
        localfileheader.setCompressedSize(Raw.readLongLittleEndian(getLongByteFromIntByte(abyte2), 0));
        readIntoBuff(zip4jRaf, abyte2);
        localfileheader.setUncompressedSize(Raw.readLongLittleEndian(getLongByteFromIntByte(abyte2), 0));
        readIntoBuff(zip4jRaf, abyte0);
        k = Raw.readShortLittleEndian(abyte0, 0);
        localfileheader.setFileNameLength(k);
        readIntoBuff(zip4jRaf, abyte0);
        j = Raw.readShortLittleEndian(abyte0, 0);
        localfileheader.setExtraFieldLength(j);
        i = 0 + 4 + 2 + 2 + 2 + 4 + 4 + 4 + 4 + 2 + 2;
        if (k <= 0) goto _L2; else goto _L1
_L1:
        byte abyte1[] = new byte[k];
        readIntoBuff(zip4jRaf, abyte1);
        s1 = Zip4jUtil.decodeFileName(abyte1, localfileheader.isFileNameUTF8Encoded());
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_533;
        }
        throw new ZipException("file name is null, cannot assign file name to local file header");
        s = s1;
        if (s1.indexOf(":" + System.getProperty("file.separator")) >= 0)
        {
            s = s1.substring(s1.indexOf(":" + System.getProperty("file.separator")) + 2);
        }
        localfileheader.setFileName(s);
        i = k + 30;
_L10:
        readAndSaveExtraDataRecord(localfileheader);
        localfileheader.setOffsetStartOfData((long)(i + j) + l);
        localfileheader.setPassword(fileheader.getPassword());
        readAndSaveZip64ExtendedInfo(localfileheader);
        readAndSaveAESExtraDataRecord(localfileheader);
        if (!localfileheader.isEncrypted() || localfileheader.getEncryptionMethod() == 99) goto _L4; else goto _L3
_L3:
        if ((byte0 & 0x40) != 64) goto _L6; else goto _L5
_L5:
        localfileheader.setEncryptionMethod(1);
_L4:
        if (localfileheader.getCrc32() <= 0L)
        {
            localfileheader.setCrc32(fileheader.getCrc32());
            localfileheader.setCrcBuff(fileheader.getCrcBuff());
        }
        if (localfileheader.getCompressedSize() <= 0L)
        {
            localfileheader.setCompressedSize(fileheader.getCompressedSize());
        }
        if (localfileheader.getUncompressedSize() > 0L) goto _L8; else goto _L7
_L7:
        localfileheader.setUncompressedSize(fileheader.getUncompressedSize());
        return localfileheader;
_L2:
        localfileheader.setFileName(null);
        continue; /* Loop/switch isn't completed */
_L6:
        localfileheader.setEncryptionMethod(0);
          goto _L4
_L8:
        return localfileheader;
        if (true) goto _L10; else goto _L9
_L9:
    }
}
