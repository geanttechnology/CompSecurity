// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import android.util.Pair;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomUrlRewriter

public abstract class ImageUrlRewriter
{

    public static final int SOURCE_GALLERY = 1;
    public static final int SOURCE_MERCH = 3;
    public static final int SOURCE_VIEW_ITEM = 2;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ImageUrlRewriter", 3, "Log ImageUrlRewriter");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo testZoom = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("UseZoom", 3, "Forces zoom usage");
    protected final int clientIndicator;
    protected int imageQuality;
    protected int outputFormat;
    protected int outputHeight;
    protected int outputWidth;
    protected boolean requestProgressiveRendering;

    public ImageUrlRewriter(int i)
    {
        clientIndicator = i;
    }

    public static ImageUrlRewriter getRewriter(DeviceConfiguration deviceconfiguration, int i)
    {
        if (deviceconfiguration == null)
        {
            throw new IllegalArgumentException("ImageUrlRewriter requires non-null arguments");
        }
        boolean flag = deviceconfiguration.get(DcsNautilusBoolean.UseZoomImageService);
        if (testZoom.isLoggable)
        {
            flag = true;
        }
        if (flag)
        {
            if (logTag.isLoggable)
            {
                logTag.log("Using ZoomUrlRewriter");
            }
            return new ZoomUrlRewriter(deviceconfiguration, i);
        } else
        {
            return null;
        }
    }

    public void constrainHeight(int i)
    {
        outputHeight = i;
    }

    public void constrainSize(int i, int j)
    {
        outputWidth = i;
        outputHeight = j;
    }

    public void constrainWidth(int i)
    {
        outputWidth = i;
    }

    public Pair getMaxOutputSize()
    {
        return new Pair(Integer.valueOf(outputWidth), Integer.valueOf(outputHeight));
    }

    public abstract String rewriteUrl(String s);

    public void setProgressiveRendering(boolean flag)
    {
        requestProgressiveRendering = flag;
    }

    public void setQuality(int i)
    {
        imageQuality = i;
    }

}
