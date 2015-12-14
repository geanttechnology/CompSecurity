// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import java.io.File;
import java.io.Serializable;

public class outputPath
    implements Serializable
{

    private final int COLORMX = 256;
    private final int HEIGHT = 480;
    private final int WIDTH = 640;
    private double delay;
    private String mUid;
    private String outputPath;
    private int quality;

    public int getCOLORMX()
    {
        return 256;
    }

    public double getDelay()
    {
        return delay;
    }

    public int getHeight()
    {
        return 480;
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

    public int getQuality()
    {
        return quality;
    }

    public int getWidth()
    {
        return 640;
    }

    public String getmUid()
    {
        return mUid;
    }

    public void setDelay(double d)
    {
        delay = d;
    }

    public void setOutputPath(String s)
    {
        outputPath = s;
    }

    public void setQuality(int i)
    {
        quality = i;
    }

    public void setmUid(String s)
    {
        mUid = s;
    }

    public String setupGifToVideoPathAndGet()
    {
        return (new StringBuilder()).append(getOutputDir()).append("/").append(getOutputName()).append(".mp4").toString();
    }

    public (double d, int i, String s)
    {
        quality = 10;
        delay = d;
        quality = i;
        outputPath = s;
    }
}
