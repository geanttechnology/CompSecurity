// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            ShellCommand, Util, CommandResult, Log, 
//            FFmpegExecuteResponseHandler

class FFmpegExecuteAsyncTask extends AsyncTask
{

    private final String cmd[];
    private final FFmpegExecuteResponseHandler ffmpegExecuteResponseHandler;
    private String output;
    private Process process;
    private final ShellCommand shellCommand = new ShellCommand();
    private long startTime;
    private final long timeout;

    FFmpegExecuteAsyncTask(String as[], long l, FFmpegExecuteResponseHandler ffmpegexecuteresponsehandler)
    {
        output = "";
        cmd = as;
        timeout = l;
        ffmpegExecuteResponseHandler = ffmpegexecuteresponsehandler;
    }

    private void checkAndUpdateProcess()
        throws TimeoutException, InterruptedException
    {
_L6:
        if (!Util.isProcessCompleted(process) && !Util.isProcessCompleted(process)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (timeout != 0x7fffffffffffffffL && System.currentTimeMillis() > startTime + timeout)
        {
            throw new TimeoutException("FFmpeg timed out");
        }
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
_L3:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (isCancelled())
        {
            continue; /* Loop/switch isn't completed */
        }
        output = (new StringBuilder()).append(output).append(s).append("\n").toString();
        publishProgress(new String[] {
            s
        });
          goto _L3
        if (true) goto _L1; else goto _L4
_L4:
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected transient CommandResult doInBackground(Void avoid[])
    {
        process = shellCommand.run(cmd);
        if (process != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        avoid = CommandResult.getDummyFailureResponse();
        Util.destroyProcess(process);
        return avoid;
        Log.d("Running publishing updates method");
        checkAndUpdateProcess();
        avoid = CommandResult.getOutputFromProcess(process);
        Util.destroyProcess(process);
        return avoid;
        avoid;
        Log.e("FFmpeg timed out", avoid);
        avoid = new CommandResult(false, avoid.getMessage());
        Util.destroyProcess(process);
        return avoid;
        avoid;
        Log.e("Error running FFmpeg", avoid);
        Util.destroyProcess(process);
        return CommandResult.getDummyFailureResponse();
        avoid;
        Util.destroyProcess(process);
        throw avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    boolean isProcessCompleted()
    {
        return Util.isProcessCompleted(process);
    }

    protected void onPostExecute(CommandResult commandresult)
    {
        if (ffmpegExecuteResponseHandler != null)
        {
            output = (new StringBuilder()).append(output).append(commandresult.output).toString();
            if (commandresult.success)
            {
                ffmpegExecuteResponseHandler.onSuccess(output);
            } else
            {
                ffmpegExecuteResponseHandler.onFailure(output);
            }
            ffmpegExecuteResponseHandler.onFinish();
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((CommandResult)obj);
    }

    protected void onPreExecute()
    {
        startTime = System.currentTimeMillis();
        if (ffmpegExecuteResponseHandler != null)
        {
            ffmpegExecuteResponseHandler.onStart();
        }
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((String[])aobj);
    }

    protected transient void onProgressUpdate(String as[])
    {
        if (as != null && as[0] != null && ffmpegExecuteResponseHandler != null)
        {
            ffmpegExecuteResponseHandler.onProgress(as[0]);
        }
    }
}
