// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils;

import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.amazon.gallery.framework.gallery.utils:
//            GifEncoderParams, Dimension

public static class scale
{

    private int delay;
    private Dimension dimension;
    private Collection frameSequence;
    private Collection inputFileNames;
    private String outputFileName;
    private int quality;
    private int repeat;
    private double scale;

    public GifEncoderParams build()
    {
        return new GifEncoderParams(this, null);
    }

    public scale withDelay(int i)
    {
        delay = i;
        return this;
    }

    public delay withDimension(int i, int j)
    {
        dimension = new Dimension(i, j);
        return this;
    }

    public dimension withInputFileName(String s)
    {
        inputFileNames.add(s);
        return this;
    }

    public inputFileNames withOutputFileName(String s)
    {
        outputFileName = s;
        return this;
    }

    public outputFileName withQuality(int i)
    {
        quality = i;
        return this;
    }

    public quality withRepeat(int i)
    {
        repeat = i;
        return this;
    }

    public repeat withScale(double d)
    {
        scale = d;
        return this;
    }









    public I()
    {
        inputFileNames = new ArrayList();
        frameSequence = new ArrayList();
        delay = 250;
        quality = 10;
        repeat = 1;
        scale = 1.0D;
    }
}
