// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import android.text.TextUtils;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ImageUrlRewriter, ConstructDipUrl

public class EpsUrlRewriter extends ImageUrlRewriter
{

    private static final Pattern pattern = Pattern.compile("(http[s]?://)(thumbs[1-9]?\\.ebaystatic\\.com)(.*)");
    private final String galleryImageHost;

    public EpsUrlRewriter(DeviceConfiguration deviceconfiguration)
    {
        super(1);
        String s = deviceconfiguration.get(DcsNautilusString.ThumbnailHost);
        deviceconfiguration = s;
        if (TextUtils.isEmpty(s))
        {
            deviceconfiguration = null;
        }
        galleryImageHost = deviceconfiguration;
    }

    public String rewriteUrl(String s)
    {
        String s1;
        int i;
        if (outputWidth >= outputHeight)
        {
            i = outputWidth;
        } else
        {
            i = outputHeight;
        }
        s1 = "_26";
        if (i <= 640) goto _L2; else goto _L1
_L1:
        s1 = "_3";
_L4:
        s1 = ConstructDipUrl.constructDynamicUrl(s, s1);
        if (s1 != null)
        {
            s = s1;
        }
        s1 = s;
        if (galleryImageHost != null)
        {
            s1 = pattern.matcher(s).replaceFirst((new StringBuilder()).append("$1").append(galleryImageHost).append("$3").toString());
        }
        return s1;
_L2:
        if (i > 400)
        {
            s1 = "_58";
        } else
        if (i > 140)
        {
            s1 = "_1";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
