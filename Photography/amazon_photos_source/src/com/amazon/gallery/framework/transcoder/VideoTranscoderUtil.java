// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.transcoder;

import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.image.Dimension;
import com.amazon.gallery.foundation.image.ImageUtils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.transcoder:
//            CompressionQuality

public class VideoTranscoderUtil
{

    private static final String TAG = com/amazon/gallery/framework/transcoder/VideoTranscoderUtil.getName();

    public VideoTranscoderUtil()
    {
    }

    public static long calculateOutputSize(CompressionQuality compressionquality, int i)
    {
        long l = (long)(compressionquality.videoBitrate + compressionquality.audioBitrate) / 8L;
        return (long)i * l;
    }

    public static List getBitrates(long l, int i)
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = false;
        CompressionQuality acompressionquality[] = CompressionQuality.values();
        int k = acompressionquality.length;
        int j = 0;
        while (j < k) 
        {
            CompressionQuality compressionquality = acompressionquality[j];
            if (flag)
            {
                arraylist.add(compressionquality);
            } else
            if (calculateOutputSize(compressionquality, i) < l)
            {
                flag = true;
                arraylist.add(compressionquality);
            }
            j++;
        }
        if (arraylist.size() == 0)
        {
            arraylist.add(CompressionQuality.QUALITY_160P);
        }
        return arraylist;
    }

    public static Dimension getTranscodeDimension(Dimension dimension, int i)
    {
        dimension = ImageUtils.scaleDimension(dimension, new Dimension(i, i), ScaleMode.SCALE_TO_FIT, false);
        return new Dimension((dimension.width / 8) * 8, (dimension.height / 8) * 8);
    }

}
