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
//            NativeAd, ViewBinder

class NativeAdViewHelper
{
    static final class ViewType extends Enum
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


    private static final WeakHashMap sNativeAdMap = new WeakHashMap();

    private NativeAdViewHelper()
    {
    }

    private static void clearNativeAd(Context context, View view)
    {
        context = (NativeAd)sNativeAdMap.get(view);
        if (context != null)
        {
            context.clear(view);
        }
    }

    static View getAdView(View view, ViewGroup viewgroup, Context context, NativeAd nativead, ViewBinder viewbinder)
    {
label0:
        {
label1:
            {
                com.mopub.common.Preconditions.NoThrow.checkNotNull(viewbinder, "ViewBinder is null.");
                if (view != null)
                {
                    clearNativeAd(context, view);
                }
                if (nativead != null && !nativead.isDestroyed() && viewbinder != null)
                {
                    break label0;
                }
                MoPubLog.d("NativeAd or viewBinder null or invalid. Returning empty view");
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
label2:
        {
            if (view != null)
            {
                viewbinder = view;
                if (ViewType.AD.equals(view.getTag()))
                {
                    break label2;
                }
            }
            viewbinder = nativead.createAdView(viewgroup);
            viewbinder.setTag(ViewType.AD);
        }
        prepareNativeAd(context, viewbinder, nativead);
        nativead.renderAdView(viewbinder);
        return viewbinder;
    }

    private static void prepareNativeAd(Context context, View view, NativeAd nativead)
    {
        sNativeAdMap.put(view, nativead);
        nativead.prepare(view);
    }

}
