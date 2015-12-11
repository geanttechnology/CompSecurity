// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import android.app.Application;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogFileSpec

public class LogPurger
{

    private static final int MAX_LOG_COUNT = 100;
    private Application application;
    private LogFileSpec spec;

    public LogPurger(Application application1, LogFileSpec logfilespec)
    {
        application = application1;
        spec = logfilespec;
    }

    public void purge()
    {
        ArrayList arraylist = new ArrayList();
        String as[] = application.fileList();
        int k = as.length;
        for (int i = 0; i < k; i++)
        {
            String s = as[i];
            if (spec.matchesSpec(s))
            {
                arraylist.add(s);
            }
        }

        if (arraylist.size() > 100)
        {
            Collections.sort(arraylist);
            int j = 0;
            while (j < arraylist.size() - 100) 
            {
                Log.d(com/groupon/tracking/mobile/internal/LogPurger.getName(), (new StringBuilder()).append("Removing file for upload ").append((String)arraylist.get(j)).toString());
                application.deleteFile((String)arraylist.get(j));
                j++;
            }
        }
    }
}
