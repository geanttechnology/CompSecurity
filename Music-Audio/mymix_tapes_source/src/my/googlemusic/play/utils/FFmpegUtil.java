// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.FFmpegExecuteResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;
import java.io.File;
import my.googlemusic.play.application.App;

public class FFmpegUtil
{

    private static Context mContext;
    private static FFmpegUtil sInstance;
    private static final String temporaryAudioPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("temporaryAudio.mp3").toString();
    private static final String temporaryVideoPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("temporaryVideo.mp4").toString();
    private static final int videoSize = 15000;
    private FFmpeg mFFmpeg;

    public FFmpegUtil(Context context)
    {
        mFFmpeg = App.getInstance().getFFmpeg();
    }

    public void cropAudio(String s, long l, FFmpegExecuteResponseHandler ffmpegexecuteresponsehandler)
    {
        File file = new File(temporaryAudioPath);
        if (file.exists())
        {
            file.delete();
        }
        s = (new StringBuilder()).append("-i ").append(s).append(" -ss ").append(l).append(" -to ").append((long)10 + l).append(" -acodec copy ").append(temporaryAudioPath).toString().split(" ");
        try
        {
            mFFmpeg.execute(s, ffmpegexecuteresponsehandler);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void generateDubVideo(String s, String s1, int i, int j, int k, int l, FFmpegExecuteResponseHandler ffmpegexecuteresponsehandler)
    {
        String s2 = App.getPreferences().getString("watermark_path", null);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        byte byte0 = 2;
        File file = new File(temporaryVideoPath);
        if (file.exists())
        {
            file.delete();
        }
        if (k == 0)
        {
            byte0 = 1;
        }
        s = (new StringBuilder()).append("-ss 0 -i ").append(s1).append(" -i ").append(s).append(" -i ").append(s2).append(" -filter_complex crop=").append(j).append(":").append(j).append(":").append(i).append(":").append(0).append(",transpose=").append(byte0).append(",overlay=").append(j - 302).append(":").append(j - 84).append(" -map 0:0 -map 1:0 -t ").append(l).append(" -strict -2 -threads 5 -preset ultrafast -tune fastdecode -tune zerolatency ").append(temporaryVideoPath).toString().split(" ");
        mFFmpeg.execute(s, ffmpegexecuteresponsehandler);
        return;
        s;
        s.printStackTrace();
        return;
    }

}
