// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

public class gr
{

    public static int a()
    {
        class a
            implements FileFilter
        {

            public boolean accept(File file)
            {
                return Pattern.matches("cpu[0-9]+", file.getName());
            }

            a()
            {
            }
        }

        int i;
        try
        {
            i = (new File("/sys/devices/system/cpu/")).listFiles(new a()).length;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            return 1;
        }
        return i;
    }

    public static int b()
    {
        int i;
        try
        {
            RandomAccessFile randomaccessfile = new RandomAccessFile("/proc/meminfo", "r");
            String s = randomaccessfile.readLine();
            randomaccessfile.close();
            i = Integer.parseInt(s.split(":")[1].split("k")[0].replace(" ", ""));
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return 1024;
        }
        return (int)((double)i / 1024D);
    }
}
