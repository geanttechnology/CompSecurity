// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

public class AppiumLogger
{

    private static String analyticsFilename = "analytics-report.txt";

    public AppiumLogger()
    {
    }

    private static String getAnalyticsPath()
    {
        return String.format("%s/%s", new Object[] {
            Environment.getExternalStorageDirectory().toString(), analyticsFilename
        });
    }

    private static String getTimestamp()
    {
        return (new Timestamp((new Date()).getTime())).toString();
    }

    public static void initLogger()
    {
        File file = new File(getAnalyticsPath());
        try
        {
            if (file.exists())
            {
                file.delete();
            }
            file.createNewFile();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public static void writeAnalytics(String s, String s1)
    {
        writeToFile(getAnalyticsPath(), String.format("%s (%s): %s", new Object[] {
            s, getTimestamp(), s1
        }));
    }

    private static void writeToFile(String s, String s1)
    {
        s = new PrintWriter(new BufferedWriter(new FileWriter(s, true)));
        try
        {
            s.println(s1);
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        break MISSING_BLOCK_LABEL_35;
        s;
        s.printStackTrace();
        return;
    }

}
