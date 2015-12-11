// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import android.text.TextUtils;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ImageUrlRewriter, ZoomUriBuilder, EpsUrlMatcher

public class ZoomUrlRewriter extends ImageUrlRewriter
{

    private final ZoomUriBuilder.ImageFormat defaultImageFormat;
    private final int defaultImageSize;
    private final String galleryUrl;
    private final int largestImageSize;
    private final String lastImageFormat;
    private final String merchUrl;
    private final String rawSupportedImageSizes;
    private final ArrayList supportedImageSizes;
    private final String viewItemUrl;

    public ZoomUrlRewriter(DeviceConfiguration deviceconfiguration, int i)
    {
        this(deviceconfiguration.get(DcsNautilusString.ZoomDefaultImageFormat), deviceconfiguration.get(DcsNautilusString.ZoomGalleryUrl), deviceconfiguration.get(DcsNautilusString.ZoomViewItemUrl), deviceconfiguration.get(DcsNautilusString.ZoomMerchUrl), deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomImageWhitelistSizes), i);
    }

    public ZoomUrlRewriter(String s, String s1, String s2, String s3, String s4, int i)
    {
        int l;
        super(i);
        String s5 = s1;
        if (s1 != null)
        {
            s5 = s1;
            if (s1.isEmpty())
            {
                s5 = null;
            }
        }
        s1 = s2;
        if (s2 != null)
        {
            s1 = s2;
            if (s2.isEmpty())
            {
                s1 = null;
            }
        }
        s2 = s3;
        if (s3 != null)
        {
            s2 = s3;
            if (s3.isEmpty())
            {
                s2 = null;
            }
        }
        lastImageFormat = s;
        defaultImageFormat = ZoomUriBuilder.imageFormatFromString(s);
        galleryUrl = s5;
        viewItemUrl = s1;
        merchUrl = s2;
        rawSupportedImageSizes = s4;
        int j;
        if (rawSupportedImageSizes != null)
        {
            s = rawSupportedImageSizes.split(",");
        } else
        {
            s = new String[0];
        }
        supportedImageSizes = new ArrayList(s.length);
        j = s.length;
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        s1 = s[i];
        l = Integer.parseInt(s1.trim());
label0:
        {
            {
                if (l <= 0)
                {
                    break label0;
                }
                try
                {
                    supportedImageSizes.add(Integer.valueOf(l));
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    logTag.logAsWarning("invalid image size", s1);
                }
            }
            i++;
            continue; /* Loop/switch isn't completed */
        }
        logTag.logAsWarning((new StringBuilder()).append("invalid image size, ").append(l).toString());
        if (true)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        Collections.sort(supportedImageSizes);
        int k = supportedImageSizes.size();
        if (k > 0)
        {
            s = supportedImageSizes;
            if (k > 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            defaultImageSize = ((Integer)s.get(i)).intValue();
            largestImageSize = ((Integer)supportedImageSizes.get(k - 1)).intValue();
            return;
        } else
        {
            logTag.logAsWarning("no supported image sizes available");
            defaultImageSize = 0;
            largestImageSize = 0;
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean isStale(DeviceConfiguration deviceconfiguration)
    {
        String s4 = deviceconfiguration.get(DcsNautilusString.ZoomDefaultImageFormat);
        String s1 = deviceconfiguration.get(DcsNautilusString.ZoomGalleryUrl);
        String s2 = deviceconfiguration.get(DcsNautilusString.ZoomViewItemUrl);
        String s3 = deviceconfiguration.get(DcsNautilusString.ZoomMerchUrl);
        String s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.isEmpty())
            {
                s = null;
            }
        }
        s1 = s2;
        if (s2 != null)
        {
            s1 = s2;
            if (s2.isEmpty())
            {
                s1 = null;
            }
        }
        s2 = s3;
        if (s3 != null)
        {
            s2 = s3;
            if (s3.isEmpty())
            {
                s2 = null;
            }
        }
        return !TextUtils.equals(s4, lastImageFormat) || !TextUtils.equals(s, galleryUrl) || !TextUtils.equals(s1, viewItemUrl) || !TextUtils.equals(s2, merchUrl) || !TextUtils.equals(rawSupportedImageSizes, deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomImageWhitelistSizes));
    }

    public String rewriteUrl(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        Object obj;
        if (supportedImageSizes.isEmpty())
        {
            logTag.logAsWarning("no supported image sizes, rewrite aborted");
            return s;
        }
        obj = EpsUrlMatcher.create(s);
        s1 = null;
        if (((EpsUrlMatcher.UrlComponents) (obj)).type != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("Unrecognized URL type: ").append(s).toString());
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        ZoomUriBuilder zoomuribuilder;
        int i;
        i = 1;
        zoomuribuilder = new ZoomUriBuilder();
        clientIndicator;
        JVM INSTR tableswitch 1 3: default 124
    //                   1 339
    //                   2 352
    //                   3 365;
           goto _L5 _L6 _L7 _L8
_L5:
        ((EpsUrlMatcher.UrlComponents) (obj)).type;
        JVM INSTR tableswitch 1 6: default 168
    //                   1 394
    //                   2 430
    //                   3 462
    //                   4 446
    //                   5 498
    //                   6 378;
           goto _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L9:
        i = 0;
_L16:
        obj = s1;
        if (i != 0)
        {
            int j;
            if (outputWidth > 0 && outputHeight > 0)
            {
                if (outputWidth > outputHeight)
                {
                    i = outputWidth;
                } else
                {
                    i = outputHeight;
                }
            } else
            if (outputWidth > 0)
            {
                i = outputWidth;
            } else
            if (outputHeight > 0)
            {
                i = outputHeight;
            } else
            {
                i = defaultImageSize;
            }
            if (i > largestImageSize)
            {
                j = largestImageSize;
            } else
            {
                obj = supportedImageSizes.iterator();
                do
                {
                    j = i;
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    j = ((Integer)((Iterator) (obj)).next()).intValue();
                } while (j < i);
            }
            zoomuribuilder.withScaling(ZoomUriBuilder.ScaleBy.LONGEST, new Integer[] {
                Integer.valueOf(j)
            });
            zoomuribuilder.withProgressiveRendering(requestProgressiveRendering);
            if (imageQuality > 0)
            {
                zoomuribuilder.withImageQuality(imageQuality);
            }
            zoomuribuilder.withImageFormat(defaultImageFormat);
            try
            {
                obj = zoomuribuilder.build();
            }
            catch (IllegalStateException illegalstateexception)
            {
                obj = s1;
                if (logTag.isLoggable)
                {
                    logTag.log("Couldn't build zoom URL", illegalstateexception);
                    obj = s1;
                }
            }
        }
        s1 = s;
        if (obj != null)
        {
            if (logTag.isLoggable)
            {
                logTag.log((new StringBuilder()).append("Zoom rewriter created ").append(((String) (obj))).append(" from ").append(s).toString());
            }
            return ((String) (obj));
        }
          goto _L4
_L6:
        zoomuribuilder.withHost(galleryUrl);
          goto _L5
_L7:
        zoomuribuilder.withHost(viewItemUrl);
          goto _L5
_L8:
        zoomuribuilder.withHost(merchUrl);
          goto _L5
_L15:
        zoomuribuilder.withGuid(((EpsUrlMatcher.UrlMauiComposite)obj).zmetaGuid);
          goto _L16
_L10:
        obj = (EpsUrlMatcher.UrlDynamicThumbId)obj;
        try
        {
            zoomuribuilder.withItemId(Long.parseLong(((EpsUrlMatcher.UrlDynamicThumbId) (obj)).itemId), 0, Integer.parseInt(((EpsUrlMatcher.UrlDynamicThumbId) (obj)).galleryVersion));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            i = 0;
        }
          goto _L16
_L11:
        zoomuribuilder.withMd5(((EpsUrlMatcher.UrlDynamicThumbMd5)obj).hash);
          goto _L16
_L13:
        zoomuribuilder.withMd5(((EpsUrlMatcher.UrlThumbMd5)obj).hash);
          goto _L16
_L12:
        obj = (EpsUrlMatcher.UrlThumbItemId)obj;
        try
        {
            zoomuribuilder.withItemId(Long.parseLong(((EpsUrlMatcher.UrlThumbItemId) (obj)).itemId), 0, Integer.parseInt(((EpsUrlMatcher.UrlThumbItemId) (obj)).galleryVersion));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            i = 0;
        }
          goto _L16
_L14:
        i = 0;
          goto _L16
    }
}
