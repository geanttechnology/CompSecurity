// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.Context;
import com.espn.androidplayersdk.utilities.Utils;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsDB, EPSDKPrefs, FeedsManagerAPI

class DataManager
{

    protected static FeedsDB feedsDbConn = null;
    protected static Context mCtx;

    DataManager()
    {
    }

    protected void deinitializeDataFactory()
    {
        String s;
        try
        {
            feedsDbConn.cleanEventsTable();
            feedsDbConn.close();
            EPSDKPrefs.clearConfigData();
            EPSDKPrefs.clearStartSessionData();
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("Error deintializing data factory: ")).append(exception.getMessage()).toString() != null)
            {
                s = exception.getMessage();
            } else
            {
                s = "";
            }
        }
        Utils.sdkLog(s, 5, null);
    }

    protected FeedsDB getDbInstance()
    {
        return feedsDbConn;
    }

    protected void initializeDataFactory(Context context)
    {
        try
        {
            mCtx = context;
            if (feedsDbConn == null)
            {
                feedsDbConn = new FeedsDB(context);
            }
            (new FeedsManagerAPI()).getConfigFeed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if ((new StringBuilder("Error intializing data factory: ")).append(context.getMessage()).toString() != null)
        {
            context = context.getMessage();
        } else
        {
            context = "";
        }
        Utils.sdkLog(context, 5, null);
    }

}
