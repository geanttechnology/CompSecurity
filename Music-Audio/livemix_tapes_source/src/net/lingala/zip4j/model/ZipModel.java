// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;

import java.util.List;

// Referenced classes of package net.lingala.zip4j.model:
//            ArchiveExtraDataRecord, CentralDirectory, EndCentralDirRecord, Zip64EndCentralDirLocator, 
//            Zip64EndCentralDirRecord

public class ZipModel
    implements Cloneable
{

    private ArchiveExtraDataRecord archiveExtraDataRecord;
    private CentralDirectory centralDirectory;
    private List dataDescriptorList;
    private long end;
    private EndCentralDirRecord endCentralDirRecord;
    private String fileNameCharset;
    private boolean isNestedZipFile;
    private boolean isZip64Format;
    private List localFileHeaderList;
    private boolean splitArchive;
    private long splitLength;
    private long start;
    private Zip64EndCentralDirLocator zip64EndCentralDirLocator;
    private Zip64EndCentralDirRecord zip64EndCentralDirRecord;
    private String zipFile;

    public ZipModel()
    {
        splitLength = -1L;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public ArchiveExtraDataRecord getArchiveExtraDataRecord()
    {
        return archiveExtraDataRecord;
    }

    public CentralDirectory getCentralDirectory()
    {
        return centralDirectory;
    }

    public List getDataDescriptorList()
    {
        return dataDescriptorList;
    }

    public long getEnd()
    {
        return end;
    }

    public EndCentralDirRecord getEndCentralDirRecord()
    {
        return endCentralDirRecord;
    }

    public String getFileNameCharset()
    {
        return fileNameCharset;
    }

    public List getLocalFileHeaderList()
    {
        return localFileHeaderList;
    }

    public long getSplitLength()
    {
        return splitLength;
    }

    public long getStart()
    {
        return start;
    }

    public Zip64EndCentralDirLocator getZip64EndCentralDirLocator()
    {
        return zip64EndCentralDirLocator;
    }

    public Zip64EndCentralDirRecord getZip64EndCentralDirRecord()
    {
        return zip64EndCentralDirRecord;
    }

    public String getZipFile()
    {
        return zipFile;
    }

    public boolean isNestedZipFile()
    {
        return isNestedZipFile;
    }

    public boolean isSplitArchive()
    {
        return splitArchive;
    }

    public boolean isZip64Format()
    {
        return isZip64Format;
    }

    public void setArchiveExtraDataRecord(ArchiveExtraDataRecord archiveextradatarecord)
    {
        archiveExtraDataRecord = archiveextradatarecord;
    }

    public void setCentralDirectory(CentralDirectory centraldirectory)
    {
        centralDirectory = centraldirectory;
    }

    public void setDataDescriptorList(List list)
    {
        dataDescriptorList = list;
    }

    public void setEnd(long l)
    {
        end = l;
    }

    public void setEndCentralDirRecord(EndCentralDirRecord endcentraldirrecord)
    {
        endCentralDirRecord = endcentraldirrecord;
    }

    public void setFileNameCharset(String s)
    {
        fileNameCharset = s;
    }

    public void setLocalFileHeaderList(List list)
    {
        localFileHeaderList = list;
    }

    public void setNestedZipFile(boolean flag)
    {
        isNestedZipFile = flag;
    }

    public void setSplitArchive(boolean flag)
    {
        splitArchive = flag;
    }

    public void setSplitLength(long l)
    {
        splitLength = l;
    }

    public void setStart(long l)
    {
        start = l;
    }

    public void setZip64EndCentralDirLocator(Zip64EndCentralDirLocator zip64endcentraldirlocator)
    {
        zip64EndCentralDirLocator = zip64endcentraldirlocator;
    }

    public void setZip64EndCentralDirRecord(Zip64EndCentralDirRecord zip64endcentraldirrecord)
    {
        zip64EndCentralDirRecord = zip64endcentraldirrecord;
    }

    public void setZip64Format(boolean flag)
    {
        isZip64Format = flag;
    }

    public void setZipFile(String s)
    {
        zipFile = s;
    }
}
