// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import co.vine.android.VineLoggingException;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package co.vine.android.recorder:
//            Processor, RelativeTime

public class VineProcessor
{

    private final Processor mProcessor;

    public VineProcessor(String s)
        throws VineLoggingException
    {
        try
        {
            mProcessor = new Processor(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new VineLoggingException(s);
        }
    }

    public int combineVideoAndAudio(String s, String s1, String s2)
    {
        return mProcessor.newCommand().addInputPath(s).addInputPath(s1).setMap("0:0").setMap("1:0").setCopy().enableOverwrite().processToOutput(s2);
    }

    public int combineVideoAndAudio(String s, String s1, String s2, HashMap hashmap)
    {
        return mProcessor.newCommand().addInputPath(s).addInputPath(s1).setMap("0:0").setMap("1:0").setCopy().setMetaData(hashmap).enableOverwrite().processToOutput(s2);
    }

    public int concat(List list, String s, HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder("concat:");
        int j = list.size() - 1;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((String)list.get(i));
            stringbuilder.append("|");
        }

        stringbuilder.append((String)list.get(j));
        return mProcessor.newCommand().addInputPath(stringbuilder.toString()).setCopy().setBsfA("aac_adtstoasc").enableOverwrite().setMetaData(hashmap).processToOutput(s);
    }

    public int cropTo480(String s, String s1)
    {
        return mProcessor.newCommand().addInputPath(s).setAudioCopy().filterCrop(480, 480).enableOverwrite().processToOutput(s1);
    }

    public int cropTo480andRotate(String s, String s1)
    {
        return mProcessor.newCommand().addInputPath(s).setAudioCopy().filterCrop(480, 480).filterRotation(Processor.Rotation.NO_FLIP_90_CLOCKWISE).enableOverwrite().processToOutput(s1);
    }

    public int getImageForFrame(String s, long l, int i, int j, String s1)
    {
        return mProcessor.newCommand().setStart(l).addInputPath(s).setVFrames(1).setFormat("image2").enableOverwrite().processToOutput(s1);
    }

    public void init()
    {
        mProcessor.process(new String[] {
            "ffmpeg", "-h"
        });
    }

    public int rotate(String s, String s1)
    {
        return mProcessor.newCommand().addInputPath(s).setAudioCopy().filterRotation(Processor.Rotation.NO_FLIP_90_CLOCKWISE).enableOverwrite().processToOutput(s1);
    }

    public int setMetadata(String s, String s1, HashMap hashmap)
    {
        return mProcessor.newCommand().addInputPath(s).setCopy().setMetaData(hashmap).enableOverwrite().processToOutput(s1);
    }

    public int split(String s, RelativeTime relativetime, String s1, int i)
    {
        return mProcessor.newCommand().addInputPath(s).setStart(relativetime.start).setFrames(relativetime.getDuration(i), i).setVideoCopy().setAudioCopy().enableOverwrite().processToOutput(s1);
    }

    public int splitTs(String s, RelativeTime relativetime, String s1, int i)
    {
        return mProcessor.newCommand().addInputPath(s).setStart(relativetime.start).setFrames(relativetime.getDuration(i), i).setCopy().setBsfV("h264_mp4toannexb").setFormat("mpegts").enableOverwrite().processToOutput(s1);
    }

    public int toH264(String s, Processor.Preset preset, String s1, HashMap hashmap)
    {
        return mProcessor.newCommand().addInputPath(s).useX264().setPreset(preset).setAudioCopy().setMetaData(hashmap).enableOverwrite().processToOutput(s1);
    }

    public int toTs(String s, String s1)
    {
        return mProcessor.newCommand().addInputPath(s).setCopy().setBsfV("h264_mp4toannexb").setFormat("mpegts").enableOverwrite().processToOutput(s1);
    }
}
