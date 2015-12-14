// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.core;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndCentralDirLocator;
import net.lingala.zip4j.model.Zip64EndCentralDirRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderWriter
{

    private final int ZIP64_EXTRA_BUF = 50;

    public HeaderWriter()
    {
    }

    private byte[] byteArrayListToByteArray(List list)
        throws ZipException
    {
        if (list == null)
        {
            throw new ZipException("input byte array list is null, cannot conver to byte array");
        }
        if (list.size() > 0) goto _L2; else goto _L1
_L1:
        byte abyte0[] = null;
_L4:
        return abyte0;
_L2:
        byte abyte1[] = new byte[list.size()];
        int i = 0;
        do
        {
            abyte0 = abyte1;
            if (i >= list.size())
            {
                continue;
            }
            abyte1[i] = Byte.parseByte((String)list.get(i));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void copyByteArrayToArrayList(byte abyte0[], List list)
        throws ZipException
    {
        if (list == null || abyte0 == null)
        {
            throw new ZipException("one of the input parameters is null, cannot copy byte array to array list");
        }
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return;
            }
            list.add(Byte.toString(abyte0[i]));
            i++;
        } while (true);
    }

    private int countNumberOfFileHeaderEntriesOnDisk(ArrayList arraylist, int i)
        throws ZipException
    {
        if (arraylist == null)
        {
            throw new ZipException("file headers are null, cannot calculate number of entries on this disk");
        }
        int k = 0;
        int j = 0;
        do
        {
            if (j >= arraylist.size())
            {
                return k;
            }
            int l = k;
            if (((FileHeader)arraylist.get(j)).getDiskNumberStart() == i)
            {
                l = k + 1;
            }
            j++;
            k = l;
        } while (true);
    }

    private void processHeaderData(ZipModel zipmodel, OutputStream outputstream)
        throws ZipException
    {
        int i = 0;
        try
        {
            if (outputstream instanceof SplitOutputStream)
            {
                zipmodel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(((SplitOutputStream)outputstream).getFilePointer());
                i = ((SplitOutputStream)outputstream).getCurrSplitFileCounter();
            }
            if (zipmodel.isZip64Format())
            {
                if (zipmodel.getZip64EndCentralDirRecord() == null)
                {
                    zipmodel.setZip64EndCentralDirRecord(new Zip64EndCentralDirRecord());
                }
                if (zipmodel.getZip64EndCentralDirLocator() == null)
                {
                    zipmodel.setZip64EndCentralDirLocator(new Zip64EndCentralDirLocator());
                }
                zipmodel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(i);
                zipmodel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(i + 1);
            }
            zipmodel.getEndCentralDirRecord().setNoOfThisDisk(i);
            zipmodel.getEndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ZipModel zipmodel)
        {
            throw new ZipException(zipmodel);
        }
    }

    private void updateCompressedSizeInLocalFileHeader(SplitOutputStream splitoutputstream, LocalFileHeader localfileheader, long l, long l1, byte abyte0[], 
            boolean flag)
        throws ZipException
    {
        if (splitoutputstream == null)
        {
            throw new ZipException("invalid output stream, cannot update compressed size for local file header");
        }
        if (!localfileheader.isWriteComprSizeInZip64ExtraRecord())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        if (abyte0.length != 8)
        {
            throw new ZipException("attempting to write a non 8-byte compressed size block for a zip64 file");
        }
        long l2;
        try
        {
            l2 = l + l1 + 4L + 4L + 2L + 2L + (long)localfileheader.getFileNameLength() + 2L + 2L + 8L;
        }
        // Misplaced declaration of an exception variable
        catch (SplitOutputStream splitoutputstream)
        {
            throw new ZipException(splitoutputstream);
        }
        l = l2;
        if (l1 == 22L)
        {
            l = l2 + 8L;
        }
        splitoutputstream.seek(l);
        splitoutputstream.write(abyte0);
        return;
        splitoutputstream.seek(l + l1);
        splitoutputstream.write(abyte0);
        return;
    }

    private int writeCentralDirectory(ZipModel zipmodel, OutputStream outputstream, List list)
        throws ZipException
    {
        if (zipmodel == null || outputstream == null)
        {
            throw new ZipException("input parameters is null, cannot write central directory");
        }
        if (zipmodel.getCentralDirectory() != null && zipmodel.getCentralDirectory().getFileHeaders() != null && zipmodel.getCentralDirectory().getFileHeaders().size() > 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 0;
        int j = 0;
        do
        {
            k = i;
            if (j >= zipmodel.getCentralDirectory().getFileHeaders().size())
            {
                continue;
            }
            i += writeFileHeader(zipmodel, (FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(j), outputstream, list);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeEndOfCentralDirectoryRecord(ZipModel zipmodel, OutputStream outputstream, int i, long l, List list)
        throws ZipException
    {
        byte abyte0[];
        byte abyte1[];
        if (zipmodel == null || outputstream == null)
        {
            throw new ZipException("zip model or output stream is null, cannot write end of central directory record");
        }
        try
        {
            outputstream = new byte[2];
            abyte0 = new byte[4];
            abyte1 = new byte[8];
            Raw.writeIntLittleEndian(abyte0, 0, (int)zipmodel.getEndCentralDirRecord().getSignature());
            copyByteArrayToArrayList(abyte0, list);
            Raw.writeShortLittleEndian(outputstream, 0, (short)zipmodel.getEndCentralDirRecord().getNoOfThisDisk());
            copyByteArrayToArrayList(outputstream, list);
            Raw.writeShortLittleEndian(outputstream, 0, (short)zipmodel.getEndCentralDirRecord().getNoOfThisDiskStartOfCentralDir());
            copyByteArrayToArrayList(outputstream, list);
            if (zipmodel.getCentralDirectory() == null || zipmodel.getCentralDirectory().getFileHeaders() == null)
            {
                throw new ZipException("invalid central directory/file headers, cannot write end of central directory record");
            }
        }
        // Misplaced declaration of an exception variable
        catch (ZipModel zipmodel)
        {
            throw new ZipException(zipmodel);
        }
        int j;
        int k;
        k = zipmodel.getCentralDirectory().getFileHeaders().size();
        if (!zipmodel.isSplitArchive())
        {
            break MISSING_BLOCK_LABEL_334;
        }
        j = countNumberOfFileHeaderEntriesOnDisk(zipmodel.getCentralDirectory().getFileHeaders(), zipmodel.getEndCentralDirRecord().getNoOfThisDisk());
_L5:
        Raw.writeShortLittleEndian(outputstream, 0, (short)j);
        copyByteArrayToArrayList(outputstream, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)k);
        copyByteArrayToArrayList(outputstream, list);
        Raw.writeIntLittleEndian(abyte0, 0, i);
        copyByteArrayToArrayList(abyte0, list);
        if (l <= 0xffffffffL) goto _L2; else goto _L1
_L1:
        Raw.writeLongLittleEndian(abyte1, 0, 0xffffffffL);
        System.arraycopy(abyte1, 0, abyte0, 0, 4);
        copyByteArrayToArrayList(abyte0, list);
_L4:
        i = 0;
        if (zipmodel.getEndCentralDirRecord().getComment() != null)
        {
            i = zipmodel.getEndCentralDirRecord().getCommentLength();
        }
        Raw.writeShortLittleEndian(outputstream, 0, (short)i);
        copyByteArrayToArrayList(outputstream, list);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        copyByteArrayToArrayList(zipmodel.getEndCentralDirRecord().getCommentBytes(), list);
        return;
_L2:
        Raw.writeLongLittleEndian(abyte1, 0, l);
        System.arraycopy(abyte1, 0, abyte0, 0, 4);
        copyByteArrayToArrayList(abyte0, list);
        if (true) goto _L4; else goto _L3
_L3:
        return;
        j = k;
          goto _L5
    }

    private int writeFileHeader(ZipModel zipmodel, FileHeader fileheader, OutputStream outputstream, List list)
        throws ZipException
    {
        byte abyte2[];
        int i;
        int j;
        boolean flag;
        boolean flag1;
        if (fileheader == null || outputstream == null)
        {
            throw new ZipException("input parameters is null, cannot write local file header");
        }
        byte abyte0[];
        byte abyte1[];
        byte abyte3[];
        try
        {
            outputstream = new byte[2];
            abyte3 = new byte[4];
            abyte0 = new byte[8];
            abyte1 = new byte[2];
            abyte2 = new byte[4];
        }
        // Misplaced declaration of an exception variable
        catch (ZipModel zipmodel)
        {
            throw new ZipException(zipmodel);
        }
        flag = false;
        flag1 = false;
        Raw.writeIntLittleEndian(abyte3, 0, fileheader.getSignature());
        copyByteArrayToArrayList(abyte3, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)fileheader.getVersionMadeBy());
        copyByteArrayToArrayList(outputstream, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)fileheader.getVersionNeededToExtract());
        copyByteArrayToArrayList(outputstream, list);
        copyByteArrayToArrayList(fileheader.getGeneralPurposeFlag(), list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)fileheader.getCompressionMethod());
        copyByteArrayToArrayList(outputstream, list);
        Raw.writeIntLittleEndian(abyte3, 0, fileheader.getLastModFileTime());
        copyByteArrayToArrayList(abyte3, list);
        Raw.writeIntLittleEndian(abyte3, 0, (int)fileheader.getCrc32());
        copyByteArrayToArrayList(abyte3, list);
        i = 0 + 4 + 2 + 2 + 2 + 2 + 4 + 4;
        if (fileheader.getCompressedSize() < 0xffffffffL && fileheader.getUncompressedSize() + 50L < 0xffffffffL) goto _L2; else goto _L1
_L1:
        Raw.writeLongLittleEndian(abyte0, 0, 0xffffffffL);
        System.arraycopy(abyte0, 0, abyte3, 0, 4);
        copyByteArrayToArrayList(abyte3, list);
        copyByteArrayToArrayList(abyte3, list);
        i = i + 4 + 4;
        flag = true;
_L21:
        Raw.writeShortLittleEndian(outputstream, 0, (short)fileheader.getFileNameLength());
        copyByteArrayToArrayList(outputstream, list);
        abyte3 = new byte[4];
        if (fileheader.getOffsetLocalHeader() <= 0xffffffffL) goto _L4; else goto _L3
_L3:
        Raw.writeLongLittleEndian(abyte0, 0, 0xffffffffL);
        System.arraycopy(abyte0, 0, abyte3, 0, 4);
        flag1 = true;
_L13:
        i = 0;
        if (flag || flag1)
        {
            i = 0 + 4;
            j = i;
            if (flag)
            {
                j = i + 16;
            }
            i = j;
            if (flag1)
            {
                i = j + 8;
            }
        }
        j = i;
        if (fileheader.getAesExtraDataRecord() != null)
        {
            j = i + 11;
        }
        Raw.writeShortLittleEndian(outputstream, 0, (short)j);
        copyByteArrayToArrayList(outputstream, list);
        copyByteArrayToArrayList(abyte1, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)fileheader.getDiskNumberStart());
        copyByteArrayToArrayList(outputstream, list);
        copyByteArrayToArrayList(abyte1, list);
        if (fileheader.getExternalFileAttr() == null) goto _L6; else goto _L5
_L5:
        copyByteArrayToArrayList(fileheader.getExternalFileAttr(), list);
_L14:
        copyByteArrayToArrayList(abyte3, list);
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipmodel.getFileNameCharset())) goto _L8; else goto _L7
_L7:
        abyte1 = fileheader.getFileName().getBytes(zipmodel.getFileNameCharset());
        copyByteArrayToArrayList(abyte1, list);
        i = abyte1.length + 46;
          goto _L9
_L17:
        zipmodel.setZip64Format(true);
        Raw.writeShortLittleEndian(outputstream, 0, (short)1);
        copyByteArrayToArrayList(outputstream, list);
          goto _L10
_L19:
        Raw.writeShortLittleEndian(outputstream, 0, (short)k);
        copyByteArrayToArrayList(outputstream, list);
        j = i + 2 + 2;
        i = j;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_558;
        }
        Raw.writeLongLittleEndian(abyte0, 0, fileheader.getUncompressedSize());
        copyByteArrayToArrayList(abyte0, list);
        Raw.writeLongLittleEndian(abyte0, 0, fileheader.getCompressedSize());
        copyByteArrayToArrayList(abyte0, list);
        i = j + 8 + 8;
        j = i;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_592;
        }
        Raw.writeLongLittleEndian(abyte0, 0, fileheader.getOffsetLocalHeader());
        copyByteArrayToArrayList(abyte0, list);
        j = i + 8;
_L18:
        if (fileheader.getAesExtraDataRecord() == null) goto _L12; else goto _L11
_L11:
        zipmodel = fileheader.getAesExtraDataRecord();
        Raw.writeShortLittleEndian(outputstream, 0, (short)(int)zipmodel.getSignature());
        copyByteArrayToArrayList(outputstream, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)zipmodel.getDataSize());
        copyByteArrayToArrayList(outputstream, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)zipmodel.getVersionNumber());
        copyByteArrayToArrayList(outputstream, list);
        copyByteArrayToArrayList(zipmodel.getVendorID().getBytes(), list);
        copyByteArrayToArrayList(new byte[] {
            (byte)zipmodel.getAesStrength()
        }, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)zipmodel.getCompressionMethod());
        copyByteArrayToArrayList(outputstream, list);
        return j + 11;
_L2:
        Raw.writeLongLittleEndian(abyte0, 0, fileheader.getCompressedSize());
        System.arraycopy(abyte0, 0, abyte3, 0, 4);
        copyByteArrayToArrayList(abyte3, list);
        Raw.writeLongLittleEndian(abyte0, 0, fileheader.getUncompressedSize());
        System.arraycopy(abyte0, 0, abyte3, 0, 4);
        copyByteArrayToArrayList(abyte3, list);
        i = i + 4 + 4;
        continue; /* Loop/switch isn't completed */
_L4:
        Raw.writeLongLittleEndian(abyte0, 0, fileheader.getOffsetLocalHeader());
        System.arraycopy(abyte0, 0, abyte3, 0, 4);
          goto _L13
_L6:
        copyByteArrayToArrayList(abyte2, list);
          goto _L14
_L8:
        copyByteArrayToArrayList(Zip4jUtil.convertCharset(fileheader.getFileName()), list);
        i = Zip4jUtil.getEncodedStringLength(fileheader.getFileName());
        i += 46;
        continue; /* Loop/switch isn't completed */
_L9:
        if (flag) goto _L16; else goto _L15
_L15:
        break MISSING_BLOCK_LABEL_910;
_L16:
        break; /* Loop/switch isn't completed */
        j = i;
        if (!flag1) goto _L18; else goto _L17
_L10:
        j = 0;
        int k;
        if (flag)
        {
            j = 0 + 16;
        }
        k = j;
        if (flag1)
        {
            k = j + 8;
        }
          goto _L19
_L12:
        return j;
        if (true) goto _L21; else goto _L20
_L20:
    }

    private void writeZip64EndOfCentralDirectoryLocator(ZipModel zipmodel, OutputStream outputstream, List list)
        throws ZipException
    {
        if (zipmodel == null || outputstream == null)
        {
            throw new ZipException("zip model or output stream is null, cannot write zip64 end of central directory locator");
        }
        try
        {
            outputstream = new byte[4];
            byte abyte0[] = new byte[8];
            Raw.writeIntLittleEndian(outputstream, 0, 0x7064b50);
            copyByteArrayToArrayList(outputstream, list);
            Raw.writeIntLittleEndian(outputstream, 0, zipmodel.getZip64EndCentralDirLocator().getNoOfDiskStartOfZip64EndOfCentralDirRec());
            copyByteArrayToArrayList(outputstream, list);
            Raw.writeLongLittleEndian(abyte0, 0, zipmodel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec());
            copyByteArrayToArrayList(abyte0, list);
            Raw.writeIntLittleEndian(outputstream, 0, zipmodel.getZip64EndCentralDirLocator().getTotNumberOfDiscs());
            copyByteArrayToArrayList(outputstream, list);
            return;
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

    private void writeZip64EndOfCentralDirectoryRecord(ZipModel zipmodel, OutputStream outputstream, int i, long l, List list)
        throws ZipException
    {
        if (zipmodel == null || outputstream == null)
        {
            throw new ZipException("zip model or output stream is null, cannot write zip64 end of central directory record");
        }
        byte abyte0[];
        byte abyte1[];
        byte abyte2[];
        outputstream = new byte[2];
        abyte0 = new byte[2];
        abyte1 = new byte[4];
        abyte2 = new byte[8];
        Raw.writeIntLittleEndian(abyte1, 0, 0x6064b50);
        copyByteArrayToArrayList(abyte1, list);
        Raw.writeLongLittleEndian(abyte2, 0, 44L);
        copyByteArrayToArrayList(abyte2, list);
        if (zipmodel.getCentralDirectory() == null || zipmodel.getCentralDirectory().getFileHeaders() == null || zipmodel.getCentralDirectory().getFileHeaders().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        Raw.writeShortLittleEndian(outputstream, 0, (short)((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(0)).getVersionMadeBy());
        copyByteArrayToArrayList(outputstream, list);
        Raw.writeShortLittleEndian(outputstream, 0, (short)((FileHeader)zipmodel.getCentralDirectory().getFileHeaders().get(0)).getVersionNeededToExtract());
        copyByteArrayToArrayList(outputstream, list);
_L1:
        Raw.writeIntLittleEndian(abyte1, 0, zipmodel.getEndCentralDirRecord().getNoOfThisDisk());
        copyByteArrayToArrayList(abyte1, list);
        Raw.writeIntLittleEndian(abyte1, 0, zipmodel.getEndCentralDirRecord().getNoOfThisDiskStartOfCentralDir());
        copyByteArrayToArrayList(abyte1, list);
        int j;
        j = 0;
        try
        {
            if (zipmodel.getCentralDirectory() == null || zipmodel.getCentralDirectory().getFileHeaders() == null)
            {
                throw new ZipException("invalid central directory/file headers, cannot write end of central directory record");
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
        break MISSING_BLOCK_LABEL_267;
        copyByteArrayToArrayList(abyte0, list);
        copyByteArrayToArrayList(abyte0, list);
          goto _L1
        int k;
        k = zipmodel.getCentralDirectory().getFileHeaders().size();
        if (!zipmodel.isSplitArchive())
        {
            break MISSING_BLOCK_LABEL_372;
        }
        countNumberOfFileHeaderEntriesOnDisk(zipmodel.getCentralDirectory().getFileHeaders(), zipmodel.getEndCentralDirRecord().getNoOfThisDisk());
_L2:
        Raw.writeLongLittleEndian(abyte2, 0, j);
        copyByteArrayToArrayList(abyte2, list);
        Raw.writeLongLittleEndian(abyte2, 0, k);
        copyByteArrayToArrayList(abyte2, list);
        Raw.writeLongLittleEndian(abyte2, 0, i);
        copyByteArrayToArrayList(abyte2, list);
        Raw.writeLongLittleEndian(abyte2, 0, l);
        copyByteArrayToArrayList(abyte2, list);
        return;
        j = k;
          goto _L2
    }

    private void writeZipHeaderBytes(ZipModel zipmodel, OutputStream outputstream, byte abyte0[])
        throws ZipException
    {
        if (abyte0 == null)
        {
            throw new ZipException("invalid buff to write as zip headers");
        }
        try
        {
            if ((outputstream instanceof SplitOutputStream) && ((SplitOutputStream)outputstream).checkBuffSizeAndStartNextSplitFile(abyte0.length))
            {
                finalizeZipFile(zipmodel, outputstream);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ZipModel zipmodel)
        {
            throw new ZipException(zipmodel);
        }
        outputstream.write(abyte0);
        return;
    }

    public void finalizeZipFile(ZipModel zipmodel, OutputStream outputstream)
        throws ZipException
    {
        if (zipmodel == null || outputstream == null)
        {
            throw new ZipException("input parameters is null, cannot finalize zip file");
        }
        ArrayList arraylist;
        int i;
        long l;
        processHeaderData(zipmodel, outputstream);
        l = zipmodel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir();
        arraylist = new ArrayList();
        i = writeCentralDirectory(zipmodel, outputstream, arraylist);
        if (!zipmodel.isZip64Format()) goto _L2; else goto _L1
_L1:
        if (zipmodel.getZip64EndCentralDirRecord() == null)
        {
            zipmodel.setZip64EndCentralDirRecord(new Zip64EndCentralDirRecord());
        }
        if (zipmodel.getZip64EndCentralDirLocator() == null)
        {
            zipmodel.setZip64EndCentralDirLocator(new Zip64EndCentralDirLocator());
        }
        zipmodel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec((long)i + l);
        if (!(outputstream instanceof SplitOutputStream))
        {
            break MISSING_BLOCK_LABEL_185;
        }
        zipmodel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(((SplitOutputStream)outputstream).getCurrSplitFileCounter());
        zipmodel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(((SplitOutputStream)outputstream).getCurrSplitFileCounter() + 1);
_L3:
        writeZip64EndOfCentralDirectoryRecord(zipmodel, outputstream, i, l, arraylist);
        writeZip64EndOfCentralDirectoryLocator(zipmodel, outputstream, arraylist);
_L2:
        writeEndOfCentralDirectoryRecord(zipmodel, outputstream, i, l, arraylist);
        writeZipHeaderBytes(zipmodel, outputstream, byteArrayListToByteArray(arraylist));
        return;
        try
        {
            zipmodel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(0);
            zipmodel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1);
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
          goto _L3
    }

    public void finalizeZipFileWithoutValidations(ZipModel zipmodel, OutputStream outputstream)
        throws ZipException
    {
        if (zipmodel == null || outputstream == null)
        {
            throw new ZipException("input parameters is null, cannot finalize zip file without validations");
        }
        try
        {
            ArrayList arraylist = new ArrayList();
            long l = zipmodel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir();
            int i = writeCentralDirectory(zipmodel, outputstream, arraylist);
            if (zipmodel.isZip64Format())
            {
                if (zipmodel.getZip64EndCentralDirRecord() == null)
                {
                    zipmodel.setZip64EndCentralDirRecord(new Zip64EndCentralDirRecord());
                }
                if (zipmodel.getZip64EndCentralDirLocator() == null)
                {
                    zipmodel.setZip64EndCentralDirLocator(new Zip64EndCentralDirLocator());
                }
                zipmodel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec((long)i + l);
                writeZip64EndOfCentralDirectoryRecord(zipmodel, outputstream, i, l, arraylist);
                writeZip64EndOfCentralDirectoryLocator(zipmodel, outputstream, arraylist);
            }
            writeEndOfCentralDirectoryRecord(zipmodel, outputstream, i, l, arraylist);
            writeZipHeaderBytes(zipmodel, outputstream, byteArrayListToByteArray(arraylist));
            return;
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

    public void updateLocalFileHeader(LocalFileHeader localfileheader, long l, int i, ZipModel zipmodel, byte abyte0[], int j, 
            SplitOutputStream splitoutputstream)
        throws ZipException
    {
        boolean flag;
        if (localfileheader == null || l < 0L || zipmodel == null)
        {
            throw new ZipException("invalid input parameters, cannot update local file header");
        }
        flag = false;
        if (j == splitoutputstream.getCurrSplitFileCounter()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj1 = new File(zipmodel.getZipFile());
        obj = ((File) (obj1)).getParent();
        obj1 = Zip4jUtil.getZipFileNameWithoutExt(((File) (obj1)).getName());
        obj = obj + System.getProperty("file.separator");
        if (j >= 9) goto _L4; else goto _L3
_L3:
        obj = obj + obj1 + ".z0" + (j + 1);
_L10:
        obj = new SplitOutputStream(new File(((String) (obj))));
        j = 1;
_L11:
        long l1;
        try
        {
            l1 = ((SplitOutputStream) (obj)).getFilePointer();
        }
        // Misplaced declaration of an exception variable
        catch (LocalFileHeader localfileheader)
        {
            throw new ZipException(localfileheader);
        }
        i;
        JVM INSTR lookupswitch 3: default 316
    //                   14: 253
    //                   18: 283
    //                   22: 283;
           goto _L5 _L6 _L7 _L7
_L5:
        if (j == 0) goto _L9; else goto _L8
_L8:
        ((SplitOutputStream) (obj)).close();
        return;
_L4:
        obj = obj + obj1 + ".z" + (j + 1);
          goto _L10
_L6:
        ((SplitOutputStream) (obj)).seek((long)i + l);
        ((SplitOutputStream) (obj)).write(abyte0);
          goto _L5
_L7:
        long l2 = i;
        updateCompressedSizeInLocalFileHeader(((SplitOutputStream) (obj)), localfileheader, l, l2, abyte0, zipmodel.isZip64Format());
          goto _L5
_L9:
        splitoutputstream.seek(l1);
        return;
_L2:
        obj = splitoutputstream;
        j = ((flag) ? 1 : 0);
          goto _L11
    }

    public int writeExtendedLocalHeader(LocalFileHeader localfileheader, OutputStream outputstream)
        throws ZipException, IOException
    {
        if (localfileheader == null || outputstream == null)
        {
            throw new ZipException("input parameters is null, cannot write extended local header");
        }
        ArrayList arraylist = new ArrayList();
        byte abyte0[] = new byte[4];
        Raw.writeIntLittleEndian(abyte0, 0, 0x8074b50);
        copyByteArrayToArrayList(abyte0, arraylist);
        Raw.writeIntLittleEndian(abyte0, 0, (int)localfileheader.getCrc32());
        copyByteArrayToArrayList(abyte0, arraylist);
        long l1 = localfileheader.getCompressedSize();
        long l = l1;
        if (l1 >= 0x7fffffffL)
        {
            l = 0x7fffffffL;
        }
        Raw.writeIntLittleEndian(abyte0, 0, (int)l);
        copyByteArrayToArrayList(abyte0, arraylist);
        l1 = localfileheader.getUncompressedSize();
        l = l1;
        if (l1 >= 0x7fffffffL)
        {
            l = 0x7fffffffL;
        }
        Raw.writeIntLittleEndian(abyte0, 0, (int)l);
        copyByteArrayToArrayList(abyte0, arraylist);
        localfileheader = byteArrayListToByteArray(arraylist);
        outputstream.write(localfileheader);
        return localfileheader.length;
    }

    public int writeLocalFileHeader(ZipModel zipmodel, LocalFileHeader localfileheader, OutputStream outputstream)
        throws ZipException
    {
        if (localfileheader == null)
        {
            throw new ZipException("input parameters are null, cannot write local file header");
        }
        ArrayList arraylist;
        byte abyte0[];
        byte abyte1[];
        byte abyte2[];
        byte abyte3[];
        int i;
        boolean flag;
        int j;
        try
        {
            arraylist = new ArrayList();
            abyte0 = new byte[2];
            abyte1 = new byte[4];
            abyte2 = new byte[8];
            abyte3 = new byte[8];
            Raw.writeIntLittleEndian(abyte1, 0, localfileheader.getSignature());
            copyByteArrayToArrayList(abyte1, arraylist);
            Raw.writeShortLittleEndian(abyte0, 0, (short)localfileheader.getVersionNeededToExtract());
            copyByteArrayToArrayList(abyte0, arraylist);
            copyByteArrayToArrayList(localfileheader.getGeneralPurposeFlag(), arraylist);
            Raw.writeShortLittleEndian(abyte0, 0, (short)localfileheader.getCompressionMethod());
            copyByteArrayToArrayList(abyte0, arraylist);
            Raw.writeIntLittleEndian(abyte1, 0, localfileheader.getLastModFileTime());
            copyByteArrayToArrayList(abyte1, arraylist);
            Raw.writeIntLittleEndian(abyte1, 0, (int)localfileheader.getCrc32());
            copyByteArrayToArrayList(abyte1, arraylist);
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
        flag = false;
        if (50L + localfileheader.getUncompressedSize() < 0xffffffffL) goto _L2; else goto _L1
_L1:
        Raw.writeLongLittleEndian(abyte2, 0, 0xffffffffL);
        System.arraycopy(abyte2, 0, abyte1, 0, 4);
        copyByteArrayToArrayList(abyte1, arraylist);
        copyByteArrayToArrayList(abyte1, arraylist);
        zipmodel.setZip64Format(true);
        flag = true;
        localfileheader.setWriteComprSizeInZip64ExtraRecord(true);
_L3:
        Raw.writeShortLittleEndian(abyte0, 0, (short)localfileheader.getFileNameLength());
        copyByteArrayToArrayList(abyte0, arraylist);
        i = 0;
        if (flag)
        {
            i = 0 + 20;
        }
        j = i;
        if (localfileheader.getAesExtraDataRecord() != null)
        {
            j = i + 11;
        }
        Raw.writeShortLittleEndian(abyte0, 0, (short)j);
        copyByteArrayToArrayList(abyte0, arraylist);
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipmodel.getFileNameCharset()))
        {
            break MISSING_BLOCK_LABEL_573;
        }
        copyByteArrayToArrayList(localfileheader.getFileName().getBytes(zipmodel.getFileNameCharset()), arraylist);
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        Raw.writeShortLittleEndian(abyte0, 0, (short)1);
        copyByteArrayToArrayList(abyte0, arraylist);
        Raw.writeShortLittleEndian(abyte0, 0, (short)16);
        copyByteArrayToArrayList(abyte0, arraylist);
        Raw.writeLongLittleEndian(abyte2, 0, localfileheader.getUncompressedSize());
        copyByteArrayToArrayList(abyte2, arraylist);
        copyByteArrayToArrayList(abyte3, arraylist);
        if (localfileheader.getAesExtraDataRecord() != null)
        {
            zipmodel = localfileheader.getAesExtraDataRecord();
            Raw.writeShortLittleEndian(abyte0, 0, (short)(int)zipmodel.getSignature());
            copyByteArrayToArrayList(abyte0, arraylist);
            Raw.writeShortLittleEndian(abyte0, 0, (short)zipmodel.getDataSize());
            copyByteArrayToArrayList(abyte0, arraylist);
            Raw.writeShortLittleEndian(abyte0, 0, (short)zipmodel.getVersionNumber());
            copyByteArrayToArrayList(abyte0, arraylist);
            copyByteArrayToArrayList(zipmodel.getVendorID().getBytes(), arraylist);
            copyByteArrayToArrayList(new byte[] {
                (byte)zipmodel.getAesStrength()
            }, arraylist);
            Raw.writeShortLittleEndian(abyte0, 0, (short)zipmodel.getCompressionMethod());
            copyByteArrayToArrayList(abyte0, arraylist);
        }
        zipmodel = byteArrayListToByteArray(arraylist);
        outputstream.write(zipmodel);
        return zipmodel.length;
_L2:
        Raw.writeLongLittleEndian(abyte2, 0, localfileheader.getCompressedSize());
        System.arraycopy(abyte2, 0, abyte1, 0, 4);
        copyByteArrayToArrayList(abyte1, arraylist);
        Raw.writeLongLittleEndian(abyte2, 0, localfileheader.getUncompressedSize());
        System.arraycopy(abyte2, 0, abyte1, 0, 4);
        copyByteArrayToArrayList(abyte1, arraylist);
        localfileheader.setWriteComprSizeInZip64ExtraRecord(false);
          goto _L3
        copyByteArrayToArrayList(Zip4jUtil.convertCharset(localfileheader.getFileName()), arraylist);
          goto _L4
    }
}
