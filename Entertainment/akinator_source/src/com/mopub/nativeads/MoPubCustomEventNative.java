// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
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
//            CustomEventNative, NativeErrorCode, BaseForwardingNativeAd

public class MoPubCustomEventNative extends CustomEventNative
{
    static class MoPubForwardingNativeAd extends BaseForwardingNativeAd
    {

        private final Context mContext;
        private final CustomEventNative.CustomEventNativeListener mCustomEventNativeListener;
        private final JSONObject mJsonObject;

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

        private void addInstanceVariable(NativeResponse.Parameter parameter, Object obj)
            throws ClassCastException
        {
            static class _cls1
            {

                static final int $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[];

                static 
                {
                    $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter = new int[NativeResponse.Parameter.values().length];
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.MAIN_IMAGE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.ICON_IMAGE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.IMPRESSION_TRACKER.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.CLICK_TRACKER.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.CLICK_DESTINATION.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.CALL_TO_ACTION.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.TITLE.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.TEXT.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[NativeResponse.Parameter.STAR_RATING.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.mopub.nativeads.NativeResponse.Parameter[parameter.ordinal()];
            JVM INSTR tableswitch 1 9: default 191
        //                       1 86
        //                       2 129
        //                       3 138
        //                       4 194
        //                       5 144
        //                       6 153
        //                       7 162
        //                       8 171
        //                       9 180;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
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
_L6:
            setClickDestinationUrl((String)obj);
            return;
_L7:
            setCallToAction((String)obj);
            return;
_L8:
            setTitle((String)obj);
            return;
_L9:
            setText((String)obj);
            return;
_L10:
            setStarRating(Numbers.parseDouble(obj));
            return;
_L5:
        }

        private boolean containsRequiredKeys(JSONObject jsonobject)
        {
            HashSet hashset = new HashSet();
            for (jsonobject = jsonobject.keys(); jsonobject.hasNext(); hashset.add(jsonobject.next())) { }
            return hashset.containsAll(NativeResponse.Parameter.requiredKeys);
        }

        private boolean isImageKey(String s)
        {
            return s != null && s.toLowerCase(Locale.US).endsWith("image");
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
                NativeResponse.Parameter parameter = NativeResponse.Parameter.from(s);
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

            preCacheImages(mContext, getAllImageUrls(), new CustomEventNative.ImageListener() {

                final MoPubForwardingNativeAd this$0;

                public void onImagesCached()
                {
                    mCustomEventNativeListener.onNativeAdLoaded(MoPubForwardingNativeAd.this);
                }

                public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
                {
                    mCustomEventNativeListener.onNativeAdFailed(nativeerrorcode);
                }

            
            {
                this$0 = MoPubForwardingNativeAd.this;
                super();
            }
            });
        }


        MoPubForwardingNativeAd(Context context, JSONObject jsonobject, CustomEventNative.CustomEventNativeListener customeventnativelistener)
        {
            mJsonObject = jsonobject;
            mContext = context;
            mCustomEventNativeListener = customeventnativelistener;
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
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.INVALID_JSON);
            return;
        }
        context = new MoPubForwardingNativeAd(context.getApplicationContext(), (JSONObject)map, customeventnativelistener);
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
