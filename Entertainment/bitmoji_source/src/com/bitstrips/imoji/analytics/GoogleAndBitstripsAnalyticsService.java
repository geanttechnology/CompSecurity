// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.app.Activity;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            AnalyticsService, Category, GoogleAnalyticsService, BitstripsAnalyticsService, 
//            Action, Variable

public class GoogleAndBitstripsAnalyticsService
    implements AnalyticsService
{

    private static final String TAG = com/bitstrips/imoji/analytics/GoogleAndBitstripsAnalyticsService.getSimpleName();
    BitstripsAnalyticsService bitstripsAnalyticsService;
    GoogleAnalyticsService googleAnalyticsService;
    final Category ignoredCategories[];

    public GoogleAndBitstripsAnalyticsService()
    {
        ignoredCategories = (new Category[] {
            Category.AVATAR, Category.AVATAR_UX
        });
    }

    public void incrementTotalShareCount(PreferenceUtils preferenceutils)
    {
        googleAnalyticsService.incrementTotalShareCount(preferenceutils);
    }

    public void reportStart(Activity activity)
    {
        googleAnalyticsService.reportStart(activity);
    }

    public void reportStop(Activity activity)
    {
        googleAnalyticsService.reportStop(activity);
    }

    public void sendEvent(Category category, Action action, String s)
    {
        if (Arrays.asList(ignoredCategories).contains(category))
        {
            return;
        } else
        {
            googleAnalyticsService.sendEvent(category, action, s);
            bitstripsAnalyticsService.sendEvent(category, action, s);
            return;
        }
    }

    public void sendEvent(Category category, Action action, String s, long l)
    {
        if (Arrays.asList(ignoredCategories).contains(category))
        {
            return;
        } else
        {
            googleAnalyticsService.sendEvent(category, action, s, l);
            bitstripsAnalyticsService.sendEvent(category, action, s, l);
            return;
        }
    }

    public void sendTiming(Category category, Variable variable, long l, String s)
    {
        if (Arrays.asList(ignoredCategories).contains(category))
        {
            return;
        } else
        {
            googleAnalyticsService.sendTiming(category, variable, l, s);
            return;
        }
    }

}
