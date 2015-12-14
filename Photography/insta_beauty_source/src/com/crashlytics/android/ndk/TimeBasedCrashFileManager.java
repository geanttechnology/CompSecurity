// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;

import btx;
import bul;
import java.io.File;

// Referenced classes of package com.crashlytics.android.ndk:
//            CrashFileManager

class TimeBasedCrashFileManager
    implements CrashFileManager
{

    private static final String CRASHFILE_EXT = ".ndk.json";
    private static final File EMPTY_FILES[] = new File[0];
    private final File nativeCrashDirectory;
    private final btx timeProvider;

    public TimeBasedCrashFileManager(File file)
    {
        this(file, ((btx) (new bul())));
    }

    TimeBasedCrashFileManager(File file, btx btx1)
    {
        nativeCrashDirectory = file;
        timeProvider = btx1;
    }

    private File findLatestCrashFileByValue()
    {
        File file = null;
        File afile[] = getFiles();
        long l = 0L;
        for (int i = 0; i < afile.length; i++)
        {
            File file1 = afile[i];
            long l1 = Long.parseLong(stripExtension(file1.getName()));
            if (l1 > l)
            {
                file = file1;
                l = l1;
            }
        }

        return file;
    }

    private File[] getFiles()
    {
        File afile1[] = nativeCrashDirectory.listFiles();
        File afile[] = afile1;
        if (afile1 == null)
        {
            afile = EMPTY_FILES;
        }
        return afile;
    }

    private String stripExtension(String s)
    {
        return s.substring(0, s.length() - ".ndk.json".length());
    }

    public void clearCrashFiles()
    {
        File afile[] = getFiles();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            afile[i].delete();
        }

    }

    public File getLastWrittenCrashFile()
    {
        return findLatestCrashFileByValue();
    }

    public File getNewCrashFile()
    {
        String s = (new StringBuilder()).append(timeProvider.a()).append(".ndk.json").toString();
        return new File(nativeCrashDirectory, s);
    }

}
