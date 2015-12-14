// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.venus;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class CPUUtility
{

    private static final String BOGOMIPS_PATTERN = "BogoMIPS[\\s]*:[\\s]*(\\d+\\.\\d+)[\\s]*\n";
    private static final String MEMFREE_PATTERN = "MemFree[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
    private static final String MEMTOTAL_PATTERN = "MemTotal[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";

    public CPUUtility()
    {
    }

    public static int getCPUFrequencyCurrent()
    {
        return readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
    }

    public static int getCPUFrequencyMax()
    {
        return readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
    }

    public static float getCPURate()
    {
        RandomAccessFile randomaccessfile;
        String as[];
        String s;
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l8;
        try
        {
            randomaccessfile = new RandomAccessFile("/proc/stat", "r");
            String as1[] = randomaccessfile.readLine().split(" ");
            l = Long.parseLong(as1[5]);
            l1 = Long.parseLong(as1[2]);
            l2 = Long.parseLong(as1[3]);
            l3 = Long.parseLong(as1[4]);
            l4 = Long.parseLong(as1[6]);
            l5 = Long.parseLong(as1[7]);
            l6 = Long.parseLong(as1[8]);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return 0.0F;
        }
        l1 = l1 + l2 + l3 + l4 + l5 + l6;
        try
        {
            Thread.sleep(360L);
        }
        catch (Exception exception) { }
        randomaccessfile.seek(0L);
        s = randomaccessfile.readLine();
        randomaccessfile.close();
        as = s.split(" ");
        l2 = Long.parseLong(as[5]);
        l3 = Long.parseLong(as[2]);
        l4 = Long.parseLong(as[3]);
        l5 = Long.parseLong(as[4]);
        l6 = Long.parseLong(as[6]);
        l7 = Long.parseLong(as[7]);
        l8 = Long.parseLong(as[8]);
        l3 = l8 + (l3 + l4 + l5 + l6 + l7);
        return (float)(l3 - l1) / (float)((l3 + l2) - (l + l1));
    }

    private static MatchResult matchSystemFile(String s, String s1, int i)
    {
        boolean flag = true;
        s = new Scanner((new ProcessBuilder(new String[] {
            "/system/bin/cat", s
        })).start().getInputStream());
        if (s.findWithinHorizon(s1, i) != null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        return s.match();
        throw new Exception();
        s;
        throw new Exception(s);
    }

    public static final String readFully(InputStream inputstream)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (inputstream = new Scanner(inputstream); inputstream.hasNextLine(); stringbuilder.append(inputstream.nextLine())) { }
        return stringbuilder.toString();
    }

    private static int readSystemFileAsInt(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(readFully((new ProcessBuilder(new String[] {
                "/system/bin/cat", s
            })).start().getInputStream()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new Exception(s);
        }
        return i;
    }
}
