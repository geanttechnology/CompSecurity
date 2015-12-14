// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;
import java.lang.reflect.Array;
import java.util.Map;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            FFmpegInterface, Util, Log, FFmpegExecuteAsyncTask, 
//            FileUtils, ShellCommand, CommandResult, CpuArchHelper, 
//            CpuArch, FFmpegLoadLibraryAsyncTask, FFmpegExecuteResponseHandler, FFmpegLoadBinaryResponseHandler

public class FFmpeg
    implements FFmpegInterface
{

    private static final long MINIMUM_TIMEOUT = 10000L;
    private static FFmpeg instance = null;
    private final Context context;
    private FFmpegExecuteAsyncTask ffmpegExecuteAsyncTask;
    private FFmpegLoadLibraryAsyncTask ffmpegLoadLibraryAsyncTask;
    private long timeout;

    private FFmpeg(Context context1)
    {
        timeout = 0x7fffffffffffffffL;
        context = context1.getApplicationContext();
        Log.setDEBUG(Util.isDebug(context));
    }

    public static FFmpeg getInstance(Context context1)
    {
        if (instance == null)
        {
            instance = new FFmpeg(context1);
        }
        return instance;
    }

    public Object[] concatenate(Object aobj[], Object aobj1[])
    {
        int i = aobj.length;
        int j = aobj1.length;
        Object aobj2[] = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i + j);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj2)), 0, i);
        System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), i, j);
        return aobj2;
    }

    public void execute(Map map, String as[], FFmpegExecuteResponseHandler ffmpegexecuteresponsehandler)
        throws FFmpegCommandAlreadyRunningException
    {
        if (ffmpegExecuteAsyncTask != null && !ffmpegExecuteAsyncTask.isProcessCompleted())
        {
            throw new FFmpegCommandAlreadyRunningException("FFmpeg command is already running, you are only allowed to run single command at a time");
        }
        if (as.length != 0)
        {
            ffmpegExecuteAsyncTask = new FFmpegExecuteAsyncTask((String[])concatenate(new String[] {
                FileUtils.getFFmpeg(context, map)
            }, as), timeout, ffmpegexecuteresponsehandler);
            ffmpegExecuteAsyncTask.execute(new Void[0]);
            return;
        } else
        {
            throw new IllegalArgumentException("shell command cannot be empty");
        }
    }

    public void execute(String as[], FFmpegExecuteResponseHandler ffmpegexecuteresponsehandler)
        throws FFmpegCommandAlreadyRunningException
    {
        execute(null, as, ffmpegexecuteresponsehandler);
    }

    public String getDeviceFFmpegVersion()
        throws FFmpegCommandAlreadyRunningException
    {
        CommandResult commandresult = (new ShellCommand()).runWaitFor(new String[] {
            FileUtils.getFFmpeg(context), "-version"
        });
        if (commandresult.success)
        {
            return commandresult.output.split(" ")[2];
        } else
        {
            return "";
        }
    }

    public String getLibraryFFmpegVersion()
    {
        return context.getString(R.string.shipped_ffmpeg_version);
    }

    public boolean isFFmpegCommandRunning()
    {
        return ffmpegExecuteAsyncTask != null && !ffmpegExecuteAsyncTask.isProcessCompleted();
    }

    public boolean killRunningProcesses()
    {
        return Util.killAsync(ffmpegLoadLibraryAsyncTask) || Util.killAsync(ffmpegExecuteAsyncTask);
    }

    public void loadBinary(FFmpegLoadBinaryResponseHandler ffmpegloadbinaryresponsehandler)
        throws FFmpegNotSupportedException
    {
        Object obj = null;
        static class _cls1
        {

            static final int $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[];

            static 
            {
                $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch = new int[CpuArch.values().length];
                try
                {
                    $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.x86.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.ARMv7.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.ARMv7_NEON.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.NONE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.github.hiteshsondhi88.libffmpeg.CpuArch[CpuArchHelper.getCpuArch().ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 81
    //                   2 92
    //                   3 103
    //                   4 114;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_103;
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_114;
_L6:
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ffmpegLoadLibraryAsyncTask = new FFmpegLoadLibraryAsyncTask(context, ((String) (obj)), ffmpegloadbinaryresponsehandler);
            ffmpegLoadLibraryAsyncTask.execute(new Void[0]);
            return;
        } else
        {
            throw new FFmpegNotSupportedException("Device not supported");
        }
_L2:
        Log.i("Loading FFmpeg for x86 CPU");
        obj = "x86";
          goto _L6
_L3:
        Log.i("Loading FFmpeg for armv7 CPU");
        obj = "armeabi-v7a";
          goto _L6
        Log.i("Loading FFmpeg for armv7-neon CPU");
        obj = "armeabi-v7a-neon";
          goto _L6
        throw new FFmpegNotSupportedException("Device not supported");
    }

    public void setTimeout(long l)
    {
        if (l >= 10000L)
        {
            timeout = l;
        }
    }

}
