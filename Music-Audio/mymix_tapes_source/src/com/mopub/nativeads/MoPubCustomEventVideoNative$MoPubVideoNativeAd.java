// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.mobileads.VideoViewabilityTracker;
import com.mopub.mobileads.factories.VastManagerFactory;
import java.util.ArrayList;
import java.util.Arrays;
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
//            VideoNativeAd, MoPubCustomEventVideoNative, VisibilityTracker, MediaLayout, 
//            NativeVideoController, NativeImageHelper, NativeErrorCode

public static class mVastManager extends VideoNativeAd
    implements com.mopub.mobileads.mVastManager, le.ProgressListener, android.media.Runnable.ProgressListener
{
    static final class Parameter extends Enum
    {

        private static final Parameter $VALUES[];
        public static final Parameter CALL_TO_ACTION;
        public static final Parameter CLICK_DESTINATION;
        public static final Parameter CLICK_TRACKER;
        public static final Parameter FALLBACK;
        public static final Parameter ICON_URL;
        public static final Parameter IMAGE_URL;
        public static final Parameter IMPRESSION_TRACKER;
        public static final Parameter TEXT;
        public static final Parameter TITLE;
        public static final Parameter VAST_VIDEO;
        static final Set requiredKeys;
        final String mName;
        final boolean mRequired;

        static Parameter from(String s)
        {
            Preconditions.checkNotNull(s);
            Parameter aparameter[] = values();
            int j = aparameter.length;
            for (int i = 0; i < j; i++)
            {
                Parameter parameter = aparameter[i];
                if (parameter.mName.equals(s))
                {
                    return parameter;
                }
            }

            return null;
        }

        public static Parameter valueOf(String s)
        {
            return (Parameter)Enum.valueOf(com/mopub/nativeads/MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter, s);
        }

        public static Parameter[] values()
        {
            return (Parameter[])$VALUES.clone();
        }

        static 
        {
            IMPRESSION_TRACKER = new Parameter("IMPRESSION_TRACKER", 0, "imptracker", true);
            CLICK_TRACKER = new Parameter("CLICK_TRACKER", 1, "clktracker", true);
            TITLE = new Parameter("TITLE", 2, "title", false);
            TEXT = new Parameter("TEXT", 3, "text", false);
            IMAGE_URL = new Parameter("IMAGE_URL", 4, "mainimage", false);
            ICON_URL = new Parameter("ICON_URL", 5, "iconimage", false);
            CLICK_DESTINATION = new Parameter("CLICK_DESTINATION", 6, "clk", false);
            FALLBACK = new Parameter("FALLBACK", 7, "fallback", false);
            CALL_TO_ACTION = new Parameter("CALL_TO_ACTION", 8, "ctatext", false);
            VAST_VIDEO = new Parameter("VAST_VIDEO", 9, "video", false);
            $VALUES = (new Parameter[] {
                IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, IMAGE_URL, ICON_URL, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, VAST_VIDEO
            });
            requiredKeys = new HashSet();
            Parameter aparameter[] = values();
            int j = aparameter.length;
       