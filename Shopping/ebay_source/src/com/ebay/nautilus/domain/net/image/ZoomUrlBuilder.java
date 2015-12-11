// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomImageId

public class ZoomUrlBuilder
{

    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ZoomUrlBuilder", 3, "ZoomUrlBuilder logger");
    private final Uri baseUri;
    final String baseUrl;
    private final LinkedList imageSizes;
    private final int maxSize;
    final String rawImageSizes;

    public ZoomUrlBuilder(DeviceConfiguration deviceconfiguration)
        throws IllegalArgumentException
    {
        this(deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomUrlPrefix), deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomImageWhitelistSizes));
    }

    public ZoomUrlBuilder(String s, String s1)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("invalid base url argument");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("invalid image sizes");
        } else
        {
            baseUrl = s;
            baseUri = Uri.parse(s);
            rawImageSizes = s1;
            imageSizes = parseRawImageSizes(s1);
            maxSize = ((Integer)imageSizes.getLast()).intValue();
            return;
        }
    }

    private int adjustSize(int i, int j)
    {
        j = Math.max(i, j);
        if (j >= maxSize)
        {
            return maxSize;
        }
        Iterator iterator = imageSizes.iterator();
        do
        {
            i = j;
            if (!iterator.hasNext())
            {
                break;
            }
            i = ((Integer)iterator.next()).intValue();
        } while (i <= j);
        return i;
    }

    public static boolean isValid(DeviceConfiguration deviceconfiguration)
    {
        return !TextUtils.isEmpty(deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomUrlPrefix)) && !TextUtils.isEmpty(deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomImageWhitelistSizes));
    }

    private LinkedList parseRawImageSizes(String s)
        throws IllegalArgumentException
    {
        LinkedList linkedlist;
        int i;
        int j;
        linkedlist = new LinkedList();
        s = s.split(",");
        j = s.length;
        i = 0;
_L2:
        String s1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        s1 = s[i];
        int k = Integer.parseInt(s1.trim());
        if (k > 0)
        {
            try
            {
                linkedlist.add(Integer.valueOf(k));
            }
            catch (NumberFormatException numberformatexception)
            {
                logger.logAsWarning("invalid raw image size", numberformatexception);
            }
            break MISSING_BLOCK_LABEL_126;
        }
        logger.logAsWarning((new StringBuilder()).append("invalid raw image size, ").append(k).toString());
        break MISSING_BLOCK_LABEL_126;
        if (linkedlist.size() == 0)
        {
            throw new IllegalArgumentException("no usable image sizes");
        } else
        {
            Collections.sort(linkedlist);
            return linkedlist;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String build(ZoomImageId zoomimageid, int i, int j)
    {
        if (zoomimageid == null)
        {
            throw new IllegalArgumentException("invalid identifier");
        }
        android.net.Uri.Builder builder = baseUri.buildUpon();
        String s;
        if (zoomimageid.type == ZoomImageId.Type.GUID)
        {
            s = "g";
        } else
        {
            s = "m";
        }
        builder.appendPath(s);
        builder.appendPath(zoomimageid.id);
        builder.appendPath(String.format("s-l%d.webp", new Object[] {
            Integer.valueOf(adjustSize(i, j))
        }));
        return builder.build().toString();
    }

    public String build(String s, String s1, int i, int j)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s) && TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("invalid identifier");
        } else
        {
            return build(new ZoomImageId(s, s1), i, j);
        }
    }

    public boolean isStale(DeviceConfiguration deviceconfiguration)
    {
        return isStale(deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomUrlPrefix), deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.S.zoomImageWhitelistSizes));
    }

    public boolean isStale(String s, String s1)
    {
        return !TextUtils.equals(s, baseUrl) || !TextUtils.equals(s1, rawImageSizes);
    }

}
