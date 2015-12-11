// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.os.AsyncTask;
import java.io.IOException;

// Referenced classes of package com.sponsorpay.utils:
//            SPHttpConnection, SponsorPayLogger

public class GetRemoteFileContentTask extends AsyncTask
{

    private static final String TAG = "GetRemoteFileContentTask";

    public GetRemoteFileContentTask()
    {
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        Thread.currentThread().setName("GetRemoteFileContentTask");
        try
        {
            as = SPHttpConnection.getConnection(as[0]).open().getBodyContent();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            SponsorPayLogger.e("GetRemoteFileContentTask", as.getMessage(), as);
            return null;
        }
        return as;
    }
}
