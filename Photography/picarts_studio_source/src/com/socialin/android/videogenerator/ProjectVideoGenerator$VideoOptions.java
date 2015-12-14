// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import java.io.File;
import java.io.Serializable;

public class format
    implements Serializable
{

    private File audioFile;
    private int duration;
    private getOutputName format;
    private int fps;
    private String mUid;
    private String outputPath;
    private float quality;
    private on resolution;

    public File getAudioFile()
    {
        return audioFile;
    }

    public int getDuration()
    {
        return duration;
    }

    public duration getFormat()
    {
        return format;
    }

    public int getFps()
    {
        return fps;
    }

    public String getOutputDir()
    {
        return (new File(outputPath)).getParentFile().getAbsolutePath();
    }

    public String getOutputName()
    {
        String s1 = (new File(outputPath)).getName();
        int i = s1.lastIndexOf(".");
        String s = s1;
        if (i > 0)
        {
            s = s1.substring(0, i);
        }
        return s;
    }

    public String getOutputPath()
    {
        return outputPath;
    }

    public float getQuality()
    {
        return quality;
    }

    public on getResolution()
    {
        return resolution;
    }

    public String getmUid()
    {
        return mUid;
    }

    public void setAudioFile(File file)
    {
        audioFile = file;
    }

    public void setDuration(int i)
    {
        duration = i;
    }

    public void setFormat(duration duration1)
    {
        format = duration1;
    }

    public void setFps(int i)
    {
        fps = i;
    }

    public void setOutputPath(String s)
    {
        outputPath = s;
    }

    public void setQuality(float f)
    {
        quality = f;
    }

    public void setResolution(on on)
    {
        resolution = on;
    }

    public void setmUid(String s)
    {
        mUid = s;
    }

    public String setupVideoPathMP4AndGet()
    {
        return (new StringBuilder()).append(getOutputDir()).append("/").append(getOutputName()).append(".mp4").toString();
    }




    public on(int i, float f, int j, String s, on on, on on1, File file)
    {
        fps = i;
        quality = f;
        outputPath = s;
        duration = j;
        resolution = on;
        audioFile = file;
        format = on1;
    }
}
