// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

public final class ProgramName extends Enum
{

    private static final ProgramName $VALUES[];
    public static final ProgramName ANDROID;
    public static final ProgramName DUKE;
    public static final ProgramName KINDLE;
    public static final ProgramName KINDLE_LEGACY;
    public static final ProgramName TABLET;
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/metrics/ProgramName);
    private String browseProgramName;
    private String issProgramName;
    private String searchProgramName;

    private ProgramName(String s, int i, String s1, String s2, String s3)
    {
        super(s, i);
        searchProgramName = s1;
        issProgramName = s2;
        browseProgramName = s3;
    }

    public static ProgramName getProgramName(String s)
    {
        try
        {
            s = valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = ANDROID;
            log.warn((new StringBuilder()).append("Invalid program name configured. Defaulting to ").append(s.getSearchProgramName()).toString());
            return s;
        }
        return s;
    }

    public static ProgramName valueOf(String s)
    {
        return (ProgramName)Enum.valueOf(com/amazon/retailsearch/metrics/ProgramName, s);
    }

    public static ProgramName[] values()
    {
        return (ProgramName[])$VALUES.clone();
    }

    public String getBrowseProgramName()
    {
        return browseProgramName;
    }

    public String getIssProgramName()
    {
        return issProgramName;
    }

    public String getSearchProgramName()
    {
        return searchProgramName;
    }

    static 
    {
        ANDROID = new ProgramName("ANDROID", 0, "MShopAndroidSearch", "MShopAndroidISS", "MShopAndroidBrowse");
        KINDLE_LEGACY = new ProgramName("KINDLE_LEGACY", 1, "MShopKindleLegacySearch", "MShopKindleLegacyISS", "MShopKindleLegacyBrowse");
        KINDLE = new ProgramName("KINDLE", 2, "MShopKindleSearch", "MShopKindleISS", "MShopKindleBrowse");
        TABLET = new ProgramName("TABLET", 3, "MShopTabletSearch", "MShopTabletISS", "MShopTabletBrowse");
        DUKE = new ProgramName("DUKE", 4, "MShopDukeSearch", "MShopDukeISS", "MShopDukeBrowse");
        $VALUES = (new ProgramName[] {
            ANDROID, KINDLE_LEGACY, KINDLE, TABLET, DUKE
        });
    }
}
