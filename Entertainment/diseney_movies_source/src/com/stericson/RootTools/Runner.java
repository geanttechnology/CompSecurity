// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.stericson.RootTools:
//            InternalMethods, RootTools

class Runner extends Thread
{

    private static final String LOG_TAG = "RootTools::Runner";
    String binaryName;
    Context context;
    String parameter;

    public Runner(Context context1, String s, String s1)
    {
        context = context1;
        binaryName = s;
        parameter = s1;
    }

    public void run()
    {
        String s = null;
        String s1 = context.getFilesDir().getCanonicalPath();
        s = s1;
_L2:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        (new InternalMethods()).doExec(new String[] {
            (new StringBuilder(String.valueOf(s))).append("/").append(binaryName).append(" ").append(parameter).toString()
        }, -1);
        return;
        IOException ioexception;
        ioexception;
        if (RootTools.debugMode)
        {
            Log.e("RootTools::Runner", "Problem occured while trying to locate private files directory!");
        }
        ioexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        TimeoutException timeoutexception;
        timeoutexception;
    }
}
