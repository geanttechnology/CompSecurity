// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.log;

import com.amazon.retailsearch.android.api.init.DebugMode;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;

// Referenced classes of package com.amazon.retailsearch.log:
//            AbstractMessageRecorder, AndroidLog, MessageRecorder, AppLog, 
//            MessageLogger

public class SearchLog extends AbstractMessageRecorder
{

    private final MessageRecorder _flddelegate;
    private RetailSearchLogger searchLogger;

    public SearchLog(AppLog applog)
    {
        super(applog);
        searchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
        _flddelegate = new AndroidLog(applog);
    }

    public void log(MessageLogger messagelogger, int i, String s, Throwable throwable)
    {
        if (searchLogger != null && i >= 6)
        {
            searchLogger.error(s, throwable);
        }
        if (_flddelegate != null && DebugMode.enabled())
        {
            _flddelegate.log(messagelogger, i, s, throwable);
        }
    }
}
