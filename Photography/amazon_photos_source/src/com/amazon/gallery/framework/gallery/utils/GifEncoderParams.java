// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

// Referenced classes of package com.amazon.gallery.framework.gallery.utils:
//            Dimension

public class GifEncoderParams
{
    public static class Builder
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
            return new GifEncoderParams(this);
        }

        public Builder withDelay(int i)
        {
            delay = i;
            return this;
        }

        public Builder withDimension(int i, int j)
        {
            dimension = new Dimension(i, j);
            return this;
        }

        public Builder withInputFileName(String s)
        {
            inputFileNames.add(s);
            return this;
        }

        public Builder withOutputFileName(String s)
        {
            outputFileName = s;
            return this;
        }

        public Builder withQuality(int i)
        {
            quality = i;
            return this;
        }

        public Builder withRepeat(int i)
        {
            repeat = i;
            return this;
        }

        public Builder withScale(double d)
        {
            scale = d;
            return this;
        }









        public Builder()
        {
            inputFileNames = new ArrayList();
            frameSequence = new ArrayList();
            delay = 250;
            quality = 10;
            repeat = 1;
            scale = 1.0D;
        }
    }


    private final int delay;
    private final Dimension dimension;
    private final Collection frameSequence;
    private final Collection inputFileNames;
    private final String outputFileName;
    private final int quality;
    private final int repeat;
    private final double scale;

    private GifEncoderParams(Builder builder)
    {
        boolean flag1 = true;
        super();
        outputFileName = (String)Validate.notNull(builder.outputFileName, "Must provide output file name.", new Object[0]);
        Object obj;
        boolean flag;
        if (((Collection)Validate.notNull(builder.inputFileNames, "Must provide input file names", new Object[0])).size() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Must provide at least two input file names.", new Object[0]);
        inputFileNames = Collections.unmodifiableCollection(new ArrayList(builder.inputFileNames));
        if (builder.frameSequence.isEmpty())
        {
            obj = inputFileNames;
        } else
        {
            obj = new ArrayList(builder.frameSequence);
        }
        frameSequence = Collections.unmodifiableCollection(((Collection) (obj)));
        delay = builder.delay;
        quality = builder.quality;
        repeat = builder.repeat;
        if (builder.scale > 0.0D)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Scale must be positive.", new Object[0]);
        scale = builder.scale;
        if (builder.dimension != null)
        {
            builder = new Dimension(builder.dimension, builder.scale);
        } else
        {
            builder = null;
        }
        dimension = builder;
    }


    public int getDelay()
    {
        return delay;
    }

    public Dimension getDimension()
    {
        return dimension;
    }

    public Collection getInputFileNames()
    {
        return inputFileNames;
    }

    public String getOutputFileName()
    {
        return outputFileName;
    }

    public int getQuality()
    {
        return quality;
    }

    public int getRepeat()
    {
        return repeat;
    }

    public String toString()
    {
        return (new ToStringBuilder(this)).append("outputFileName", outputFileName).append("inputFileNames", inputFileNames).append("frameSequence", frameSequence).append("delay", delay).append("quality", quality).append("repeat", repeat).append("scale", scale).append("dimension", dimension).toString();
    }
}
