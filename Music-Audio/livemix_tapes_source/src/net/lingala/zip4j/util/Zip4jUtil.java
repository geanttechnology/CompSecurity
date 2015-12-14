// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;

// Referenced classes of package net.lingala.zip4j.util:
//            InternalZipConstants

public class Zip4jUtil
{

    public Zip4jUtil()
    {
    }

    public static boolean checkArrayListTypes(ArrayList arraylist, int i)
        throws ZipException
    {
        if (arraylist == null)
        {
            throw new ZipException("input arraylist is null, cannot check types");
        }
        if (arraylist.size() > 0) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        boolean flag = false;
        i;
        JVM INSTR tableswitch 1 2: default 48
    //                   1 56
    //                   2 91;
           goto _L3 _L4 _L5
_L3:
        i = ((flag) ? 1 : 0);
_L7:
        if (i != 0)
        {
            return false;
        }
          goto _L1
_L4:
        int j = 0;
_L10:
        i = ((flag) ? 1 : 0);
        if (j >= arraylist.size()) goto _L7; else goto _L6
_L6:
        if (arraylist.get(j) instanceof File) goto _L9; else goto _L8
_L8:
        i = 1;
          goto _L7
_L9:
        j++;
          goto _L10
_L5:
        j = 0;
_L14:
        i = ((flag) ? 1 : 0);
        if (j >= arraylist.size()) goto _L7; else goto _L11
_L11:
        if (arraylist.get(j) instanceof String) goto _L13; else goto _L12
_L12:
        i = 1;
          goto _L7
_L13:
        j++;
          goto _L14
    }

    public static boolean checkFileExists(File file)
        throws ZipException
    {
        if (file == null)
        {
            throw new ZipException("cannot check if file exists: input file is null");
        } else
        {
            return file.exists();
        }
    }

    public static boolean checkFileExists(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("path is null");
        } else
        {
            return checkFileExists(new File(s));
        }
    }

    public static boolean checkFileReadAccess(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("path is null");
        }
        if (!checkFileExists(s))
        {
            throw new ZipException("file does not exist: " + s);
        }
        boolean flag;
        try
        {
            flag = (new File(s)).canRead();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException("cannot read zip file");
        }
        return flag;
    }

    public static boolean checkFileWriteAccess(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("path is null");
        }
        if (!checkFileExists(s))
        {
            throw new ZipException("file does not exist: " + s);
        }
        boolean flag;
        try
        {
            flag = (new File(s)).canWrite();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException("cannot read zip file");
        }
        return flag;
    }

    public static boolean checkOutputFolder(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException(new NullPointerException("output path is null"));
        }
        s = new File(s);
        if (s.exists())
        {
            if (!s.isDirectory())
            {
                throw new ZipException("output folder is not valid");
            }
            if (!s.canWrite())
            {
                throw new ZipException("no write access to output folder");
            }
            break MISSING_BLOCK_LABEL_124;
        }
        try
        {
            s.mkdirs();
            if (!s.isDirectory())
            {
                throw new ZipException("output folder is not valid");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException("Cannot create destination folder");
        }
        if (!s.canWrite())
        {
            throw new ZipException("no write access to destination folder");
        }
        return true;
    }

    public static byte[] convertCharset(String s)
        throws ZipException
    {
        byte abyte0[];
        try
        {
            abyte0 = (byte[])null;
            String s1 = detectCharSet(s);
            if (s1.equals("Cp850"))
            {
                return s.getBytes("Cp850");
            }
            if (s1.equals("UTF8"))
            {
                return s.getBytes("UTF8");
            }
            s1 = s.getBytes();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return s.getBytes();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException(s);
        }
        return s1;
    }

    public static String decodeFileName(byte abyte0[], boolean flag)
    {
        if (flag)
        {
            String s;
            try
            {
                s = new String(abyte0, "UTF8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                return new String(abyte0);
            }
            return s;
        } else
        {
            return getCp850EncodedString(abyte0);
        }
    }

    public static String detectCharSet(String s)
        throws ZipException
    {
        if (s == null)
        {
            throw new ZipException("input string is null, cannot detect charset");
        }
        boolean flag;
        try
        {
            flag = s.equals(new String(s.getBytes("Cp850"), "Cp850"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return InternalZipConstants.CHARSET_DEFAULT;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return InternalZipConstants.CHARSET_DEFAULT;
        }
        if (flag)
        {
            return "Cp850";
        }
        flag = s.equals(new String(s.getBytes("UTF8"), "UTF8"));
        if (flag)
        {
            return "UTF8";
        }
        s = InternalZipConstants.CHARSET_DEFAULT;
        return s;
    }

    public static long dosToJavaTme(int i)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set((i >> 25 & 0x7f) + 1980, (i >> 21 & 0xf) - 1, i >> 16 & 0x1f, i >> 11 & 0x1f, i >> 5 & 0x3f, (i & 0x1f) * 2);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static String getAbsoluteFilePath(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("filePath is null or empty, cannot get absolute file path");
        } else
        {
            return (new File(s)).getAbsolutePath();
        }
    }

    public static long[] getAllHeaderSignatures()
    {
        return (new long[] {
            0x4034b50L, 0x8074b50L, 0x2014b50L, 0x6054b50L, 0x5054b50L, 0x8064b50L, 0x8074b50L, 0x7064b50L, 0x6064b50L, 1L, 
            39169L
        });
    }

    public static String getCp850EncodedString(byte abyte0[])
    {
        String s;
        try
        {
            s = new String(abyte0, "Cp850");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return new String(abyte0);
        }
        return s;
    }

    public static int getEncodedStringLength(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("input string is null, cannot calculate encoded String length");
        } else
        {
            return getEncodedStringLength(s, detectCharSet(s));
        }
    }

    public static int getEncodedStringLength(String s, String s1)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("input string is null, cannot calculate encoded String length");
        }
        if (!isStringNotNullAndNotEmpty(s1))
        {
            throw new ZipException("encoding is not defined, cannot calculate string length");
        }
        if (!s1.equals("Cp850")) goto _L2; else goto _L1
_L1:
        s1 = ByteBuffer.wrap(s.getBytes("Cp850"));
        s = s1;
_L4:
        return s.limit();
_L2:
        if (!s1.equals("UTF8"))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        s1 = ByteBuffer.wrap(s.getBytes("UTF8"));
        s = s1;
        continue; /* Loop/switch isn't completed */
        s1 = ByteBuffer.wrap(s.getBytes(s1));
        s = s1;
        continue; /* Loop/switch isn't completed */
        s1;
        s = ByteBuffer.wrap(s.getBytes());
        continue; /* Loop/switch isn't completed */
        s;
        throw new ZipException(s);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static FileHeader getFileHeader(ZipModel zipmodel, String s)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null, cannot determine file header for fileName: " + s);
        }
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("file name is null, cannot determine file header for fileName: " + s);
        }
        FileHeader fileheader = getFileHeaderWithExactMatch(zipmodel, s);
        Object obj = fileheader;
        if (fileheader == null)
        {
            String s1 = s.replaceAll("\\\\", "/");
            s = getFileHeaderWithExactMatch(zipmodel, s1);
            obj = s;
            if (s == null)
            {
                obj = getFileHeaderWithExactMatch(zipmodel, s1.replaceAll("/", "\\\\"));
            }
        }
        return ((FileHeader) (obj));
    }

    public static FileHeader getFileHeaderWithExactMatch(ZipModel zipmodel, String s)
        throws ZipException
    {
        int i;
        if (zipmodel == null)
        {
            throw new ZipException("zip model is null, cannot determine file header with exact match for fileName: " + s);
        }
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("file name is null, cannot determine file header with exact match for fileName: " + s);
        }
        if (zipmodel.getCentralDirectory() == null)
        {
            throw new ZipException("central directory is null, cannot determine file header with exact match for fileName: " + s);
        }
        if (zipmodel.getCentralDirectory().getFileHeaders() == null)
        {
            throw new ZipException("file Headers are null, cannot determine file header with exact match for fileName: " + s);
        }
        if (zipmodel.getCentralDirectory().getFileHeaders().size() <= 0)
        {
            return null;
        }
        zipmodel = zipmodel.getCentralDirectory().getFileHeaders();
        i = 0;
_L2:
        FileHeader fileheader;
        String s1;
        if (i >= zipmodel.size())
        {
            return null;
        }
        fileheader = (FileHeader)zipmodel.get(i);
        s1 = fileheader.getFileName();
          goto _L1
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!isStringNotNullAndNotEmpty(s1) || !s.equalsIgnoreCase(s1)) goto _L4; else goto _L3
_L3:
        return fileheader;
    }

    public static long getFileLengh(File file)
        throws ZipException
    {
        if (file == null)
        {
            throw new ZipException("input file is null, cannot calculate file length");
        }
        if (file.isDirectory())
        {
            return -1L;
        } else
        {
            return file.length();
        }
    }

    public static long getFileLengh(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("invalid file name");
        } else
        {
            return getFileLengh(new File(s));
        }
    }

    public static String getFileNameFromFilePath(File file)
        throws ZipException
    {
        if (file == null)
        {
            throw new ZipException("input file is null, cannot get file name");
        }
        if (file.isDirectory())
        {
            return null;
        } else
        {
            return file.getName();
        }
    }

    public static ArrayList getFilesInDirectoryRec(File file, boolean flag)
        throws ZipException
    {
        ArrayList arraylist;
        List list;
        if (file == null)
        {
            throw new ZipException("input path is null, cannot read files in the directory");
        }
        arraylist = new ArrayList();
        list = Arrays.asList(file.listFiles());
        if (file.canRead()) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        int i = 0;
_L5:
        if (i >= list.size()) goto _L1; else goto _L3
_L3:
        file = (File)list.get(i);
        if (file.isHidden() && !flag) goto _L1; else goto _L4
_L4:
        arraylist.add(file);
        if (file.isDirectory())
        {
            arraylist.addAll(getFilesInDirectoryRec(file, flag));
        }
        i++;
          goto _L5
    }

    public static int getIndexOfFileHeader(ZipModel zipmodel, FileHeader fileheader)
        throws ZipException
    {
        int i;
        if (zipmodel == null || fileheader == null)
        {
            throw new ZipException("input parameters is null, cannot determine index of file header");
        }
        if (zipmodel.getCentralDirectory() == null)
        {
            throw new ZipException("central directory is null, ccannot determine index of file header");
        }
        if (zipmodel.getCentralDirectory().getFileHeaders() == null)
        {
            throw new ZipException("file Headers are null, cannot determine index of file header");
        }
        if (zipmodel.getCentralDirectory().getFileHeaders().size() <= 0)
        {
            return -1;
        }
        fileheader = fileheader.getFileName();
        if (!isStringNotNullAndNotEmpty(fileheader))
        {
            throw new ZipException("file name in file header is empty or null, cannot determine index of file header");
        }
        zipmodel = zipmodel.getCentralDirectory().getFileHeaders();
        i = 0;
_L2:
        String s;
        if (i >= zipmodel.size())
        {
            return -1;
        }
        s = ((FileHeader)zipmodel.get(i)).getFileName();
          goto _L1
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!isStringNotNullAndNotEmpty(s) || !fileheader.equalsIgnoreCase(s)) goto _L4; else goto _L3
_L3:
        return i;
    }

    public static long getLastModifiedFileTime(File file, TimeZone timezone)
        throws ZipException
    {
        if (file == null)
        {
            throw new ZipException("input file is null, cannot read last modified file time");
        }
        if (!file.exists())
        {
            throw new ZipException("input file does not exist, cannot read last modified file time");
        } else
        {
            return file.lastModified();
        }
    }

    public static String getRelativeFileName(String s, String s1, String s2)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("input file path/name is empty, cannot calculate relative file name");
        }
        if (isStringNotNullAndNotEmpty(s2))
        {
            String s3 = (new File(s2)).getPath();
            s2 = s3;
            if (!s3.endsWith(InternalZipConstants.FILE_SEPARATOR))
            {
                s2 = s3 + InternalZipConstants.FILE_SEPARATOR;
            }
            s3 = s.substring(s2.length());
            s2 = s3;
            if (s3.startsWith(System.getProperty("file.separator")))
            {
                s2 = s3.substring(1);
            }
            s = new File(s);
            if (s.isDirectory())
            {
                s = s2.replaceAll("\\\\", "/") + "/";
            } else
            {
                s = s2.substring(0, s2.lastIndexOf(s.getName())).replaceAll("\\\\", "/") + s.getName();
            }
        } else
        {
            s2 = new File(s);
            if (s2.isDirectory())
            {
                s = s2.getName() + "/";
            } else
            {
                s = getFileNameFromFilePath(new File(s));
            }
        }
        s2 = s;
        if (isStringNotNullAndNotEmpty(s1))
        {
            s2 = s1 + s;
        }
        if (!isStringNotNullAndNotEmpty(s2))
        {
            throw new ZipException("Error determining file name");
        } else
        {
            return s2;
        }
    }

    public static ArrayList getSplitZipFiles(ZipModel zipmodel)
        throws ZipException
    {
        if (zipmodel == null)
        {
            throw new ZipException("cannot get split zip files: zipmodel is null");
        }
        if (zipmodel.getEndCentralDirRecord() != null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = null;
_L4:
        return arraylist;
_L2:
        ArrayList arraylist1 = new ArrayList();
        String s2 = zipmodel.getZipFile();
        String s3 = (new File(s2)).getName();
        if (!isStringNotNullAndNotEmpty(s2))
        {
            throw new ZipException("cannot get split zip files: zipfile is null");
        }
        if (!zipmodel.isSplitArchive())
        {
            arraylist1.add(s2);
            return arraylist1;
        }
        int j = zipmodel.getEndCentralDirRecord().getNoOfThisDisk();
        if (j == 0)
        {
            arraylist1.add(s2);
            return arraylist1;
        }
        int i = 0;
        do
        {
            arraylist = arraylist1;
            if (i > j)
            {
                continue;
            }
            if (i == j)
            {
                arraylist1.add(zipmodel.getZipFile());
            } else
            {
                String s = ".z0";
                if (i > 9)
                {
                    s = ".z";
                }
                String s1;
                if (s3.indexOf(".") >= 0)
                {
                    s1 = s2.substring(0, s2.lastIndexOf("."));
                } else
                {
                    s1 = s2;
                }
                arraylist1.add(s1 + s + (i + 1));
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getZipFileNameWithoutExt(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("zip file name is empty or null, cannot determine zip file name");
        }
        String s1 = s;
        if (s.indexOf(System.getProperty("file.separator")) >= 0)
        {
            s1 = s.substring(s.lastIndexOf(System.getProperty("file.separator")));
        }
        s = s1;
        if (s1.indexOf(".") > 0)
        {
            s = s1.substring(0, s1.lastIndexOf("."));
        }
        return s;
    }

    public static boolean isStringNotNullAndNotEmpty(String s)
    {
        return s != null && s.trim().length() > 0;
    }

    public static boolean isSupportedCharset(String s)
        throws ZipException
    {
        if (!isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("charset is null or empty, cannot check if it is supported");
        }
        try
        {
            new String("a".getBytes(), s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ZipException(s);
        }
        return true;
    }

    public static boolean isWindows()
    {
        return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }

    public static long javaToDosTime(long l)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        int i = calendar.get(1);
        if (i < 1980)
        {
            return 0x210000L;
        } else
        {
            return (long)(i - 1980 << 25 | calendar.get(2) + 1 << 21 | calendar.get(5) << 16 | calendar.get(11) << 11 | calendar.get(12) << 5 | calendar.get(13) >> 1);
        }
    }

    public static void setFileArchive(File file)
        throws ZipException
    {
    }

    public static void setFileHidden(File file)
        throws ZipException
    {
    }

    public static void setFileReadOnly(File file)
        throws ZipException
    {
        if (file == null)
        {
            throw new ZipException("input file is null. cannot set read only file attribute");
        }
        if (file.exists())
        {
            file.setReadOnly();
        }
    }

    public static void setFileSystemMode(File file)
        throws ZipException
    {
    }
}
