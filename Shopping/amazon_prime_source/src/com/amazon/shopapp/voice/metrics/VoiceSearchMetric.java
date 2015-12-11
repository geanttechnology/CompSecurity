// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.metrics;


public final class VoiceSearchMetric extends Enum
{

    private static final VoiceSearchMetric $VALUES[];
    public static final VoiceSearchMetric ASR_RESULT;
    public static final VoiceSearchMetric CONTEXT_MENU;
    public static final VoiceSearchMetric MANUAL_ENDPOINT;
    public static final VoiceSearchMetric NAV;
    public static final VoiceSearchMetric READY_TIME;
    public static final VoiceSearchMetric RECOGNITION_TIME;
    public static final VoiceSearchMetric REQUEST_TIME;
    public static final VoiceSearchMetric RETRY;
    public static final VoiceSearchMetric SEARCH_VIEW;
    public static final VoiceSearchMetric TYPE_SEARCH;
    public static final VoiceSearchMetric VOICE_SEARCH;
    private final String mName;

    private VoiceSearchMetric(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static VoiceSearchMetric valueOf(String s)
    {
        return (VoiceSearchMetric)Enum.valueOf(com/amazon/shopapp/voice/metrics/VoiceSearchMetric, s);
    }

    public static VoiceSearchMetric[] values()
    {
        return (VoiceSearchMetric[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        VOICE_SEARCH = new VoiceSearchMetric("VOICE_SEARCH", 0, "VSVoiceSearch");
        NAV = new VoiceSearchMetric("NAV", 1, "VSNav");
        CONTEXT_MENU = new VoiceSearchMetric("CONTEXT_MENU", 2, "VSContextMenu");
        SEARCH_VIEW = new VoiceSearchMetric("SEARCH_VIEW", 3, "VSSearchView");
        REQUEST_TIME = new VoiceSearchMetric("REQUEST_TIME", 4, "VSRequestTime");
        READY_TIME = new VoiceSearchMetric("READY_TIME", 5, "VSReadyTime");
        RECOGNITION_TIME = new VoiceSearchMetric("RECOGNITION_TIME", 6, "VSRecognitionTime");
        ASR_RESULT = new VoiceSearchMetric("ASR_RESULT", 7, "VSAsrResult");
        MANUAL_ENDPOINT = new VoiceSearchMetric("MANUAL_ENDPOINT", 8, "VSManualEndpoint");
        RETRY = new VoiceSearchMetric("RETRY", 9, "VSRetry");
        TYPE_SEARCH = new VoiceSearchMetric("TYPE_SEARCH", 10, "VSType");
        $VALUES = (new VoiceSearchMetric[] {
            VOICE_SEARCH, NAV, CONTEXT_MENU, SEARCH_VIEW, REQUEST_TIME, READY_TIME, RECOGNITION_TIME, ASR_RESULT, MANUAL_ENDPOINT, RETRY, 
            TYPE_SEARCH
        });
    }
}
