// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.shazam.android.analytics.session.exception.SessionInitializationException;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.annotation.analytics.WithAnalyticsInfo;
import com.shazam.android.annotation.analytics.WithPageView;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.b.e.a;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.o.k;
import java.lang.annotation.Annotation;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics:
//            AnalyticsInfoProvider

public class AnalyticsInfoToRootAttacher
{

    private final j launchingExtrasSerializer;

    public AnalyticsInfoToRootAttacher(j j1)
    {
        launchingExtrasSerializer = j1;
    }

    private void processOwnAnalyticsParams(Map map, Object obj)
    {
        if (obj instanceof AnalyticsInfoProvider)
        {
            map.putAll(((AnalyticsInfoProvider)obj).getAnalyticsInfo().eventParameters);
        }
    }

    private void processScreenName(Map map, Annotation aannotation[])
    {
        int i1 = aannotation.length;
        int l = 0;
        while (l < i1) 
        {
            Object obj = aannotation[l];
            if ((obj instanceof WithPageView) && (!map.containsKey(DefinedEventParameterKey.SCREEN_NAME) || a.a((String)map.get(DefinedEventParameterKey.SCREEN_NAME))))
            {
                obj = (WithPageView)obj;
                try
                {
                    obj = ((Page)((WithPageView) (obj)).page().newInstance()).getPageName();
                    map.put(DefinedEventParameterKey.SCREEN_NAME, obj);
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    throw new SessionInitializationException("Could not create page from annotated class", map);
                }
            }
            l++;
        }
    }

    private void processWithAnalyticsInfo(AnalyticsInfo analyticsinfo, Map map, Annotation aannotation[])
    {
        int j1 = aannotation.length;
        for (int l = 0; l < j1; l++)
        {
            Annotation annotation = aannotation[l];
            if (!(annotation instanceof WithAnalyticsInfo))
            {
                continue;
            }
            DefinedEventParameterKey adefinedeventparameterkey[] = ((WithAnalyticsInfo)annotation).additionalKeys();
            int k1 = adefinedeventparameterkey.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                DefinedEventParameterKey definedeventparameterkey = adefinedeventparameterkey[i1];
                map.put(definedeventparameterkey, analyticsinfo.a(definedeventparameterkey));
            }

        }

    }

    public void attachToRoot(Activity activity)
    {
        AnalyticsInfo analyticsinfo = j.a(activity.getIntent()).a();
        attachToRoot(activity, activity.getWindow().getDecorView(), analyticsinfo);
    }

    public void attachToRoot(Object obj, View view, AnalyticsInfo analyticsinfo)
    {
        Map map = analyticsinfo.eventParameters;
        Annotation aannotation[] = obj.getClass().getAnnotations();
        processWithAnalyticsInfo(analyticsinfo, map, aannotation);
        processScreenName(map, aannotation);
        processOwnAnalyticsParams(map, obj);
        obj = view.getTag(0x7f110033);
        if (obj != null && (obj instanceof AnalyticsInfo))
        {
            obj = ((AnalyticsInfo)obj).eventParameters;
            map.putAll(((Map) (obj)));
            k.a(map, ((Map) (obj)));
        }
        obj = com.shazam.model.analytics.AnalyticsInfo.Builder.a();
        ((com.shazam.model.analytics.AnalyticsInfo.Builder) (obj)).eventParameters.clear();
        ((com.shazam.model.analytics.AnalyticsInfo.Builder) (obj)).eventParameters.putAll(map);
        view.setTag(0x7f110033, ((com.shazam.model.analytics.AnalyticsInfo.Builder) (obj)).b());
    }
}
