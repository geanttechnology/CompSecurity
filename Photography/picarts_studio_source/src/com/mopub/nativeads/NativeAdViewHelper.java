// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.logging.MoPubLog;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            ImpressionTracker, NativeResponse, MoPubNativeAdRenderer, ViewBinder

class NativeAdViewHelper
{

    static final WeakHashMap sImpressionTrackerMap = new WeakHashMap();
    private static final WeakHashMap sNativeResponseMap = new WeakHashMap();

    private NativeAdViewHelper()
    {
    }

    private static void clearNativeResponse(Context context, View view)
    {
        getImpressionTracker(context).removeView(view);
        context = (NativeResponse)sNativeResponseMap.get(view);
        if (context != null)
        {
            context.clear(view);
        }
    }

    static View getAdView(View view, ViewGroup viewgroup, Context context, NativeResponse nativeresponse, ViewBinder viewbinder)
    {
label0:
        {
label1:
            {
                com.mopub.common.Preconditions.NoThrow.checkNotNull(viewbinder, "ViewBinder is null.");
                if (view != null)
                {
                    clearNativeResponse(context, view);
                }
                if (nativeresponse != null && !nativeresponse.isDestroyed() && viewbinder != null)
                {
                    break label0;
                }
                MoPubLog.d("nativeResponse or viewBinder null or invalid. Returning empty view");
                if (view != null)
                {
                    viewgroup = view;
                    if (ViewType.EMPTY.equals(view.getTag()))
                    {
                        break label1;
                    }
                }
                viewgroup = new View(context);
                viewgroup.setTag(ViewType.EMPTY);
                viewgroup.setVisibility(8);
            }
            return viewgroup;
        }
        MoPubNativeAdRenderer mopubnativeadrenderer;
label2:
        {
            mopubnativeadrenderer = new MoPubNativeAdRenderer(viewbinder);
            if (view != null)
            {
                viewbinder = view;
                if (ViewType.AD.equals(view.getTag()))
                {
                    break label2;
                }
            }
            viewbinder = mopubnativeadrenderer.createAdView(context, viewgroup);
            viewbinder.setTag(ViewType.AD);
        }
        prepareNativeResponse(context, viewbinder, nativeresponse);
        mopubnativeadrenderer.renderAdView(viewbinder, nativeresponse);
        return viewbinder;
    }

    private static ImpressionTracker getImpressionTracker(Context context)
    {
        ImpressionTracker impressiontracker1 = (ImpressionTracker)sImpressionTrackerMap.get(context);
        ImpressionTracker impressiontracker = impressiontracker1;
        if (impressiontracker1 == null)
        {
            impressiontracker = new ImpressionTracker(context);
            sImpressionTrackerMap.put(context, impressiontracker);
        }
        return impressiontracker;
    }

    private static void prepareNativeResponse(Context context, View view, NativeResponse nativeresponse)
    {
        sNativeResponseMap.put(view, nativeresponse);
        if (!nativeresponse.isOverridingImpressionTracker())
        {
            getImpressionTracker(context).addView(view, nativeresponse);
        }
        nativeresponse.prepare(view);
    }


    private class ViewType extends Enum
    {

        private static final ViewType $VALUES[];
        public static final ViewType AD;
        public static final ViewType EMPTY;

        public static ViewType valueOf(String s)
        {
            return (ViewType)Enum.valueOf(com/mopub/nativeads/NativeAdViewHelper$ViewType, s);
        }

        public static ViewType[] values()
        {
            return (ViewType[])$VALUES.clone();
        }

        static 
        {
            EMPTY = new ViewType("EMPTY", 0);
            AD = new ViewType("AD", 1);
            $VALUES = (new ViewType[] {
                EMPTY, AD
            });
        }

        private ViewType(String s, int i)
        {
            super(s, i);
        }
    }

}
