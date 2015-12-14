// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            Log

class Util
{

    Util()
    {
    }

    static void close(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
    }

    static void close(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        outputstream.flush();
        outputstream.close();
        return;
        outputstream;
    }

    static String convertInputStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = inputstream.readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                stringbuilder.append(s);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                Log.e("error converting input stream to string", inputstream);
                return null;
            }
        }
          goto _L1
        inputstream = stringbuilder.toString();
        return inputstream;
    }

    static void destroyProcess(Process process)
    {
        if (process != null)
        {
            process.destroy();
        }
    }

    static boolean isDebug(Context context)
    {
        context = context.getApplicationContext().getApplicationInfo();
        int i = ((ApplicationInfo) (context)).flags & 2;
        context.flags = i;
        return i != 0;
    }

    static boolean isProcessCompleted(Process process)
    {
        if (process == null)
        {
            return true;
        }
        try
        {
            process.exitValue();
        }
        // Misplaced declaration of an exception variable
        catch (Process process)
        {
            return false;
        }
        return true;
    }

    static boolean killAsync(AsyncTask asynctask)
    {
        return asynctask != null && !asynctask.isCancelled() && asynctask.cancel(true);
    }
}
