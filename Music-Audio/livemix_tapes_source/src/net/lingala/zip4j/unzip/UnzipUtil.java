// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.unzip;

import java.io.File;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.util.Zip4jUtil;

public class UnzipUtil
{

    public UnzipUtil()
    {
    }

    public static void applyFileAttributes(FileHeader fileheader, File file)
        throws ZipException
    {
        applyFileAttributes(fileheader, file, null);
    }

    public static void applyFileAttributes(FileHeader fileheader, File file, UnzipParameters unzipparameters)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("cannot set file properties: file header is null");
        }
        if (file == null)
        {
            throw new ZipException("cannot set file properties: output file is null");
        }
        if (!Zip4jUtil.checkFileExists(file))
        {
            throw new ZipException("cannot set file properties: file doesnot exist");
        }
        if (unzipparameters == null || !unzipparameters.isIgnoreDateTimeAttributes())
        {
            setFileLastModifiedTime(fileheader, file);
        }
        if (unzipparameters == null)
        {
            setFileAttributes(fileheader, file, true, true, true, true);
            return;
        }
        if (unzipparameters.isIgnoreAllFileAttributes())
        {
            setFileAttributes(fileheader, file, false, false, false, false);
            return;
        }
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (unzipparameters.isIgnoreReadOnlyFileAttribute())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (unzipparameters.isIgnoreHiddenFileAttribute())
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (unzipparameters.isIgnoreArchiveFileAttribute())
        {
            flag2 = false;
        } else
        {
            flag2 = true;
        }
        if (unzipparameters.isIgnoreSystemFileAttribute())
        {
            flag3 = false;
        } else
        {
            flag3 = true;
        }
        setFileAttributes(fileheader, file, flag, flag1, flag2, flag3);
    }

    private static void setFileAttributes(FileHeader fileheader, File file, boolean flag, boolean flag1, boolean flag2, boolean flag3)
        throws ZipException
    {
        if (fileheader == null)
        {
            throw new ZipException("invalid file header. cannot set file attributes");
        }
        fileheader = fileheader.getExternalFileAttr();
        if (fileheader != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (fileheader[0])
        {
        default:
            return;

        case 1: // '\001'
            if (flag)
            {
                Zip4jUtil.setFileReadOnly(file);
                return;
            }
            break;

        case 2: // '\002'
        case 18: // '\022'
            if (flag1)
            {
                Zip4jUtil.setFileHidden(file);
                return;
            }
            break;

        case 32: // ' '
        case 48: // '0'
            if (flag2)
            {
                Zip4jUtil.setFileArchive(file);
                return;
            }
            break;

        case 3: // '\003'
            if (flag)
            {
                Zip4jUtil.setFileReadOnly(file);
            }
            if (flag1)
            {
                Zip4jUtil.setFileHidden(file);
                return;
            }
            break;

        case 33: // '!'
            if (flag2)
            {
                Zip4jUtil.setFileArchive(file);
            }
            if (flag)
            {
                Zip4jUtil.setFileReadOnly(file);
                return;
            }
            break;

        case 34: // '"'
        case 50: // '2'
            if (flag2)
            {
                Zip4jUtil.setFileArchive(file);
            }
            if (flag1)
            {
                Zip4jUtil.setFileHidden(file);
                return;
            }
            break;

        case 35: // '#'
            if (flag2)
            {
                Zip4jUtil.setFileArchive(file);
            }
            if (flag)
            {
                Zip4jUtil.setFileReadOnly(file);
            }
            if (flag1)
            {
                Zip4jUtil.setFileHidden(file);
                return;
            }
            break;

        case 38: // '&'
            if (flag)
            {
                Zip4jUtil.setFileReadOnly(file);
            }
            if (flag1)
            {
                Zip4jUtil.setFileHidden(file);
            }
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!flag3) goto _L1; else goto _L4
_L4:
        Zip4jUtil.setFileSystemMode(file);
        return;
    }

    private static void setFileLastModifiedTime(FileHeader fileheader, File file)
        throws ZipException
    {
        while (fileheader.getLastModFileTime() <= 0 || !file.exists()) 
        {
            return;
        }
        file.setLastModified(Zip4jUtil.dosToJavaTme(fileheader.getLastModFileTime()));
    }
}
