// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import co.vine.android.lifevibes.LifeVibesTranscoder;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;

public class EncoderManager
{
    public static interface Encoder
    {

        public abstract void transcode(EncoderBoss encoderboss, String s, String s1, ArrayList arraylist)
            throws EncodingException;
    }

    public static interface EncoderBoss
    {

        public abstract boolean isCancelled();

        public abstract void updateLastProcess(int i);

        public abstract void updateProgress(int i);
    }

    public static class EncodingException extends Exception
    {

        public EncodingException(Exception exception)
        {
            super(exception);
        }
    }


    public EncoderManager()
    {
    }

    public static void transcode(EncoderBoss encoderboss, String s, String s1)
        throws EncodingException
    {
        SLog.d("Start transcoding from {} to {}.", s, s1);
        (new LifeVibesTranscoder()).transcode(encoderboss, s, s1, null);
    }

    public static void tryLoad()
    {
        new LifeVibesTranscoder();
    }
}
