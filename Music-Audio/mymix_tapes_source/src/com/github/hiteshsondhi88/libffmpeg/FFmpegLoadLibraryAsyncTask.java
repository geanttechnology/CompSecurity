// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            FileUtils, CpuArch, Log, FFmpegLoadBinaryResponseHandler

class FFmpegLoadLibraryAsyncTask extends AsyncTask
{

    private final Context context;
    private final String cpuArchNameFromAssets;
    private final FFmpegLoadBinaryResponseHandler ffmpegLoadBinaryResponseHandler;

    FFmpegLoadLibraryAsyncTask(Context context1, String s, FFmpegLoadBinaryResponseHandler ffmpegloadbinaryresponsehandler)
    {
        context = context1;
        cpuArchNameFromAssets = s;
        ffmpegLoadBinaryResponseHandler = ffmpegloadbinaryresponsehandler;
    }

    private boolean isDeviceFFmpegVersionOld()
    {
        return CpuArch.fromString(FileUtils.SHA1(FileUtils.getFFmpeg(context))).equals(CpuArch.NONE);
    }

    protected transient Boolean doInBackground(Void avoid[])
    {
        boolean flag = true;
        avoid = new File(FileUtils.getFFmpeg(context));
        if (avoid.exists() && isDeviceFFmpegVersionOld() && !avoid.delete())
        {
            return Boolean.valueOf(false);
        }
        if (!avoid.exists() && FileUtils.copyBinaryFromAssetsToData(context, (new StringBuilder()).append(cpuArchNameFromAssets).append(File.separator).append("ffmpeg").toString(), "ffmpeg"))
        {
            if (!avoid.canExecute())
            {
                Log.d("FFmpeg is not executable, trying to make it executable ...");
                if (avoid.setExecutable(true))
                {
                    return Boolean.valueOf(true);
                }
            } else
            {
                Log.d("FFmpeg is executable");
                return Boolean.valueOf(true);
            }
        }
        if (!avoid.exists() || !avoid.canExecute())
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        super.onPostExecute(boolean1);
        if (ffmpegLoadBinaryResponseHandler != null)
        {
            if (boolean1.booleanValue())
            {
                ffmpegLoadBinaryResponseHandler.onSuccess();
            } else
            {
                ffmpegLoadBinaryResponseHandler.onFailure();
            }
            ffmpegLoadBinaryResponseHandler.onFinish();
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }
}
