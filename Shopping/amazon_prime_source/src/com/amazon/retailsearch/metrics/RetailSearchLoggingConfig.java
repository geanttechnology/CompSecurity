// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            ProgramName

public class RetailSearchLoggingConfig
{

    static final String TAG = com/amazon/retailsearch/metrics/RetailSearchLoggingConfig.getSimpleName();
    private String browseProgramName;
    private boolean enableLogging;
    private String issProgramName;
    private String searchProgramName;

    public RetailSearchLoggingConfig(Context context)
    {
        enableLogging = false;
        searchProgramName = ProgramName.ANDROID.getSearchProgramName();
        issProgramName = ProgramName.ANDROID.getIssProgramName();
        browseProgramName = ProgramName.ANDROID.getBrowseProgramName();
        context = context.getResources();
        enableLogging = "true".equals(context.getString(com.amazon.retailsearch.R.string.config_rs_enable_logging));
        context = ProgramName.getProgramName(context.getString(com.amazon.retailsearch.R.string.config_rs_logging_program_name));
        searchProgramName = context.getSearchProgramName();
        issProgramName = context.getIssProgramName();
        browseProgramName = context.getBrowseProgramName();
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

    public boolean isLoggingEnabled()
    {
        return enableLogging;
    }

}
