// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;

import java.util.TimeZone;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipParameters
    implements Cloneable
{

    private int aesKeyStrength;
    private int compressionLevel;
    private int compressionMethod;
    private String defaultFolderPath;
    private boolean encryptFiles;
    private int encryptionMethod;
    private String fileNameInZip;
    private boolean includeRootFolder;
    private boolean isSourceExternalStream;
    private char password[];
    private boolean readHiddenFiles;
    private String rootFolderInZip;
    private int sourceFileCRC;
    private TimeZone timeZone;

    public ZipParameters()
    {
        compressionMethod = 8;
        encryptFiles = false;
        readHiddenFiles = true;
        encryptionMethod = -1;
        aesKeyStrength = -1;
        includeRootFolder = true;
        timeZone = TimeZone.getDefault();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public int getAesKeyStrength()
    {
        return aesKeyStrength;
    }

    public int getCompressionLevel()
    {
        return compressionLevel;
    }

    public int getCompressionMethod()
    {
        return compressionMethod;
    }

    public String getDefaultFolderPath()
    {
        return defaultFolderPath;
    }

    public int getEncryptionMethod()
    {
        return encryptionMethod;
    }

    public String getFileNameInZip()
    {
        return fileNameInZip;
    }

    public char[] getPassword()
    {
        return password;
    }

    public String getRootFolderInZip()
    {
        return rootFolderInZip;
    }

    public int getSourceFileCRC()
    {
        return sourceFileCRC;
    }

    public TimeZone getTimeZone()
    {
        return timeZone;
    }

    public boolean isEncryptFiles()
    {
        return encryptFiles;
    }

    public boolean isIncludeRootFolder()
    {
        return includeRootFolder;
    }

    public boolean isReadHiddenFiles()
    {
        return readHiddenFiles;
    }

    public boolean isSourceExternalStream()
    {
        return isSourceExternalStream;
    }

    public void setAesKeyStrength(int i)
    {
        aesKeyStrength = i;
    }

    public void setCompressionLevel(int i)
    {
        compressionLevel = i;
    }

    public void setCompressionMethod(int i)
    {
        compressionMethod = i;
    }

    public void setDefaultFolderPath(String s)
    {
        defaultFolderPath = s;
    }

    public void setEncryptFiles(boolean flag)
    {
        encryptFiles = flag;
    }

    public void setEncryptionMethod(int i)
    {
        encryptionMethod = i;
    }

    public void setFileNameInZip(String s)
    {
        fileNameInZip = s;
    }

    public void setIncludeRootFolder(boolean flag)
    {
        includeRootFolder = flag;
    }

    public void setPassword(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            setPassword(s.toCharArray());
            return;
        }
    }

    public void setPassword(char ac[])
    {
        password = ac;
    }

    public void setReadHiddenFiles(boolean flag)
    {
        readHiddenFiles = flag;
    }

    public void setRootFolderInZip(String s)
    {
        String s1 = s;
        if (Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            s1 = s;
            if (!s.endsWith("\\"))
            {
                s1 = s;
                if (!s.endsWith("/"))
                {
                    s1 = s + InternalZipConstants.FILE_SEPARATOR;
                }
            }
            s1 = s1.replaceAll("\\\\", "/");
        }
        rootFolderInZip = s1;
    }

    public void setSourceExternalStream(boolean flag)
    {
        isSourceExternalStream = flag;
    }

    public void setSourceFileCRC(int i)
    {
        sourceFileCRC = i;
    }

    public void setTimeZone(TimeZone timezone)
    {
        timeZone = timezone;
    }
}
