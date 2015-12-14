// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Numbers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mopub.nativeads:
//            CustomEventNative, NativeErrorCode, ImpressionTracker, NativeClickHandler, 
//            StaticNativeAd, NativeImageHelper

public class MoPubCustomEventNative extends CustomEventNative
{
    static class MoPubStaticNativeAd extends StaticNativeAd
    {

        static final String PRIVACY_INFORMATION_CLICKTHROUGH_URL = "https://www.mopub.com/optout";
        private final Context mContext;
        private final CustomEventNative.CustomEventNativeListener mCustomEventNativeListener;
        private final ImpressionTracker mImpressionTracker;
        private final JSONObject mJsonObject;
        private final NativeClickHandler mNativeClickHandler;

        private void addImpressionTrackers(Object obj)
            throws ClassCastException
        {
            if (!(obj instanceof JSONArray))
            {
                throw new ClassCastException("Expected impression trackers of type JSONArray.");
            }
            obj = (JSONArray)obj;
            int i = 0;
            while (i < ((JSONArray) (obj)).length()) 
            {
                try
                {
                    addImpressionTracker(((JSONArray) (obj)).getString(i));
                }
                catch (JSONException jsonexception)
                {
                    MoPubLog.d("Unable to parse impression trackers.");
                }
                i++;
            }
        }

        private void addInstanceVariable(Parameter parameter, Object obj)
            throws ClassCastException
        {
            static class _cls1
            {

                static final int $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[];

                static 
                {
                    $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter = new int[MoPubStaticNativeAd.Parameter.values().length];
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.MAIN_IMAGE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.ICON_IMAGE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.IMPRESSION_TRACKER.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.CLICK_DESTINATION.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.CALL_TO_ACTION.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.TITLE.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.TEXT.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventNative$MoPubStaticNativeAd$Parameter[MoPubStaticNativeAd.Parameter.STAR_RATING.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.mopub.nativeads.MoPubCustomEventNative.MoPubStaticNativeAd.Parameter[parameter.ordinal()];
            JVM INSTR tableswitch 1 8: default 187
        //                       1 82
        //                       2 125
        //                       3 134
        //                       4 140
        //                       5 149
        //                       6 158
        //                       7 167
        //                       8 176;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            MoPubLog.d((new StringBuilder()).append("Unable to add JSON key to internal mapping: ").append(parameter.name).toString());
            return;
_L2:
            try
            {
                setMainImageUrl((String)obj);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            if (!parameter.required)
            {
                MoPubLog.d((new StringBuilder()).append("Ignoring class cast exception for optional key: ").append(parameter.name).toString());
                return;
            } else
            {
                throw obj;
            }
_L3:
            setIconImageUrl((String)obj);
            return;
_L4:
            addImpressionTrackers(obj);
            return;
_L5:
            setClickDestinationUrl((String)obj);
            return;
_L6:
            setCallToAction((String)obj);
            return;
_L7:
            setTitle((String)obj);
            return;
_L8:
            setText((String)obj);
            return;
_L9:
            setStarRating(Numbers.parseDouble(obj));
            return;
        }

        private boolean containsRequiredKeys(JSONObject jsonobject)
        {
            HashSet hashset = new HashSet();
            for (jsonobject = jsonobject.keys(); jsonobject.hasNext(); hashset.add(jsonobject.next())) { }
            return hashset.containsAll(Parameter.requiredKeys);
        }

        private boolean isImageKey(String s)
        {
            return s != null && s.toLowerCase(Locale.US).endsWith("image");
        }

        public void clear(View view)
        {
            mImpressionTracker.removeView(view);
            mNativeClickHandler.clearOnClickListener(view);
        }

        public void destroy()
        {
            mImpressionTracker.destroy();
        }

        List getAllImageUrls()
        {
            ArrayList arraylist = new ArrayList();
            if (getMainImageUrl() != null)
            {
                arraylist.add(getMainImageUrl());
            }
            if (getIconImageUrl() != null)
            {
                arraylist.add(getIconImageUrl());
            }
            arraylist.addAll(getExtrasImageUrls());
            return arraylist;
        }

        List getExtrasImageUrls()
        {
            ArrayList arraylist = new ArrayList(getExtras().size());
            Iterator iterator = getExtras().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (isImageKey((String)entry.getKey()) && (entry.getValue() instanceof String))
                {
                    arraylist.add((String)entry.getValue());
                }
            } while (true);
            return arraylist;
        }

        public void handleClick(View view)
        {
            notifyAdClicked();
            mNativeClickHandler.openClickDestinationUrl(getClickDestinationUrl(), view);
        }

        void loadAd()
            throws IllegalArgumentException
        {
            if (!containsRequiredKeys(mJsonObject))
            {
                throw new IllegalArgumentException("JSONObject did not contain required keys.");
            }
            for (Iterator iterator = mJsonObject.keys(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Parameter parameter = Parameter.from(s);
                if (parameter != null)
                {
                    try
                    {
                        addInstanceVariable(parameter, mJsonObject.opt(s));
                    }
                    catch (ClassCastException classcastexception)
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("JSONObject key (").append(s).append(") contained unexpected value.").toString());
                    }
                } else
                {
                    addExtra(s, mJsonObject.opt(s));
                }
            }

            setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout");
            NativeImageHelper.preCacheImages(mContext, getAllImageUrls(), new NativeImageHelper.ImageListener() {

                final MoPubStaticNativeAd this$0;

                public void onImagesCached()
                {
                    mCustomEventNativeListener.onNativeAdLoaded(MoPubStaticNativeAd.this);
                }

                public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
                {
                    mCustomEventNativeListener.onNativeAdFailed(nativeerrorcode);
                }

            
            {
                this$0 = MoPubStaticNativeAd.this;
                super();
            }
            });
        }

        public void prepare(View view)
        {
            mImpressionTracker.addView(view, this);
            mNativeClickHandler.setOnClickListener(view, this);
        }

        public void recordImpression(View view)
        {
            notifyAdImpressed();
        }


        MoPubStaticNativeAd(Context context, JSONObject jsonobject, ImpressionTracker impressiontracker, NativeClickHandler nativeclickhandler, CustomEventNative.CustomEventNativeListener customeventnativelistener)
        {
            mJsonObject = jsonobject;
            mContext = context.getApplicationContext();
            mImpressionTracker = impressiontracker;
            mNativeClickHandler = nativeclickhandler;
            mCustomEventNativeListener = customeventnativelistener;
        }
    }

    static final class MoPubStaticNativeAd.Parameter extends Enum
    {

        private static final MoPubStaticNativeAd.Parameter $VALUES[];
        public static final MoPubStaticNativeAd.Parameter CALL_TO_ACTION;
        public static final MoPubStaticNativeAd.Parameter CLICK_DESTINATION;
        public static final MoPubStaticNativeAd.Parameter CLICK_TRACKER;
        public static final MoPubStaticNativeAd.Parameter FALLBACK;
        public static final MoPubStaticNativeAd.Parameter ICON_IMAGE;
        public static final MoPubStaticNativeAd.Parameter IMPRESSION_TRACKER;
        public static final MoPubStaticNativeAd.Parameter MAIN_IMAGE;
        public static final MoPubStaticNativeAd.Parameter STAR_RATING;
        public static final MoPubStaticNativeAd.Parameter TEXT;
        public static final MoPubStaticNativeAd.Parameter TITLE;
        static final Set requiredKeys;
        final String name;
        final boolean required;

        static MoPubStaticNativeAd.Parameter from(String s)
        {
            MoPubStaticNativeAd.Parameter aparameter[] = values();
            int j = aparameter.length;
            for (int i = 0; i < j; i++)
            {
                MoPubStaticNativeAd.Parameter parameter = aparameter[i];
                if (parameter.name.equals(s))
                {
                    return parameter;
                }
            }

            return null;
        }

        public static MoPubStaticNativeAd.Parameter valueOf(String s)
        {
            return (MoPubStaticNativeAd.Parameter)Enum.valueOf(com/mopub/nativeads/MoPubCustomEventNative$MoPubStaticNativeAd$Parameter, s);
        }

        public static MoPubStaticNativeAd.Parameter[] values()
        {
            return (MoPubStaticNativeAd.Parameter[])$VALUES.clone();
        }

        static 
        {
            IMPRESSION_TRACKER = new MoPubStaticNativeAd.Parameter("IMPRESSION_TRACKER", 0, "imptracker", true);
            CLICK_TRACKER = new MoPubStaticNativeAd.Parameter("CLICK_TRACKER", 1, "clktracker", true);
            TITLE = new MoPubStaticNativeAd.Parameter("TITLE", 2, "title", false);
            TEXT = new MoPubStaticNativeAd.Parameter("TEXT", 3, "text", false);
            MAIN_IMAGE = new MoPubStaticNativeAd.Parameter("MAIN_IMAGE", 4, "mainimage", false);
            ICON_IMAGE = new MoPubStaticNativeAd.Parameter("ICON_IMAGE", 5, "iconimage", false);
            CLICK_DESTINATION = new MoPubStaticNativeAd.Parameter("CLICK_DESTINATION", 6, "clk", false);
            FALLBACK = new MoPubStaticNativeAd.Parameter("FALLBACK", 7, "fallback", false);
            CALL_TO_ACTION = new MoPubStaticNativeAd.Parameter("CALL_TO_ACTION", 8, "ctatext", false);
            STAR_RATING = new MoPubStaticNativeAd.Parameter("STAR_RATING", 9, "starrating", false);
            $VALUES = (new MoPubStaticNativeAd.Parameter[] {
                IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, MAIN_IMAGE, ICON_IMAGE, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, STAR_RATING
            });
            requiredKeys = new HashSet();
            MoPubStaticNativeAd.Parameter aparameter[] = values();
            int j = aparameter.length;
            for (int i = 0; i < j; i++)
            {
                MoPubStaticNativeAd.Parameter parameter = aparameter[i];
                if (parameter.required)
                {
                    requiredKeys.add(parameter.name);
                }
            }

        }

        private MoPubStaticNativeAd.Parameter(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            name = s1;
            required = flag;
        }
    }


    public MoPubCustomEventNative()
    {
    }

    protected void loadNativeAd(Context context, CustomEventNative.CustomEventNativeListener customeventnativelistener, Map map, Map map1)
    {
        map = ((Map) (map.get("com_mopub_native_json")));
        if (!(map instanceof JSONObject))
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        context = new MoPubStaticNativeAd(context, (JSONObject)map, new ImpressionTracker(context), new NativeClickHandler(context), customeventnativelistener);
        try
        {
            context.loadAd();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
        }
    }
}
