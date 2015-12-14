// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.millennialmedia.internal.AdPlacementMetadata;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.Map;

// Referenced classes of package com.millennialmedia:
//            InlineAd, MMLog

public static class ta extends AdPlacementMetadata
{

    private static final String PLACEMENT_TYPE_INLINE = "inline";
    private tIfNotNull adSize;

    public ta getAdSize()
    {
        return adSize;
    }

    public int getHeight(InlineAd inlinead)
    {
        if (adSize != null && adSize.adSize != 0)
        {
            return (int)TypedValue.applyDimension(1, adSize.adSize, EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics());
        } else
        {
            return InlineAd.access$100(inlinead).getHeight();
        }
    }

    public int getWidth(InlineAd inlinead)
    {
        if (adSize != null && adSize.adSize != 0)
        {
            return (int)TypedValue.applyDimension(1, adSize.adSize, EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics());
        } else
        {
            return InlineAd.access$100(inlinead).getWidth();
        }
    }

    public s setAdSize(s s)
    {
        if (s == null)
        {
            MMLog.e(InlineAd.access$000(), "Provided AdSize cannot be null");
            return this;
        } else
        {
            adSize = s;
            return this;
        }
    }

    public Map toMap(InlineAd inlinead)
    {
        Map map = super.toMap(inlinead);
        Utils.injectIfNotNull(map, "width", Integer.valueOf(getWidth(inlinead)));
        Utils.injectIfNotNull(map, "height", Integer.valueOf(getHeight(inlinead)));
        Utils.injectIfNotNull(map, "refreshRate", InlineAd.access$200(inlinead));
        return map;
    }

    public Utils()
    {
        super("inline");
    }
}
