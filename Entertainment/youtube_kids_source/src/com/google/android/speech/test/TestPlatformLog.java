// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.test;

import ewh;
import ewk;
import ewl;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class TestPlatformLog
{

    private static final String EVENT_ERROR_PREFIX = "ERROR: ";
    private static final String EVENT_LOGGING_AUDIO_PREFIX = "LOGGING_AUDIO: ";
    private static final String EVENT_PREFIX = "TEST_PLATFORM: ";
    private static final String EVENT_RESULTS_PREFIX = "RESULTS: ";
    public static final String EVENT_SPEAK_NOW = "SPEAK_NOW";
    public static final String EVENT_VOICE_SEARCH_COMPLETE = "VOICE_SEARCH_COMPLETE";
    public static final String EVENT_WORKING = "WORKING";
    private static final String RESULT_ITEM_FORMAT = "result:\"%s\",";
    private static final String TAG = "TestPlatformLog";
    private static boolean sEnableTestPlatformLogging = false;

    public TestPlatformLog()
    {
    }

    public static void log(String s)
    {
        if (sEnableTestPlatformLogging)
        {
            (new StringBuilder("TEST_PLATFORM: ")).append(s);
        }
    }

    public static void logAudioPath(String s)
    {
        log((new StringBuilder("LOGGING_AUDIO: ")).append(s).toString());
    }

    public static void logError(String s)
    {
        log((new StringBuilder("ERROR: ")).append(s).toString());
    }

    public static void logResults(ewk ewk1)
    {
        if (sEnableTestPlatformLogging)
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append("RESULTS: ");
            if (ewk1.b == 1)
            {
                ewk1 = ewk1.i;
                if (ewk1 != null && ewk1.d() > 0)
                {
                    ewh ewh1;
                    for (ewk1 = ((ewl) (ewk1)).a.iterator(); ewk1.hasNext(); stringbuffer.append(String.format(Locale.US, "result:\"%s\",", new Object[] {
    ewh1.b
})))
                    {
                        ewh1 = (ewh)ewk1.next();
                    }

                    log(stringbuffer.toString());
                }
            }
        }
    }

    public static void setEnabled(boolean flag)
    {
        sEnableTestPlatformLogging = flag;
    }

}
