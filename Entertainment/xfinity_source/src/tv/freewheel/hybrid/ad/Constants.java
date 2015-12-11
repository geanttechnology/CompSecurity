// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import tv.freewheel.hybrid.ad.interfaces.IConstants;

public final class Constants
    implements IConstants
{

    public static int _USER_ACTION_PAUSE_BUTTON_CLICKED = 1;
    public static int _USER_ACTION_RESUME_BUTTON_CLICKED = 2;

    public Constants()
    {
    }

    public final int ACTIVITY_CALLBACK_PAUSE()
    {
        return 4;
    }

    public final int ACTIVITY_CALLBACK_RESUME()
    {
        return 5;
    }

    public final int CAPABILITY_STATUS_OFF()
    {
        return 1;
    }

    public final int CAPABILITY_STATUS_ON()
    {
        return 0;
    }

    public final String ERROR_INVALID_SLOT()
    {
        return "_e_invalid-slot";
    }

    public final String ERROR_INVALID_VALUE()
    {
        return "_e_invalid-value";
    }

    public final String ERROR_IO()
    {
        return "_e_io";
    }

    public final String ERROR_NO_AD_AVAILABLE()
    {
        return "_e_no-ad";
    }

    public final String ERROR_NULL_ASSET()
    {
        return "_e_null-asset";
    }

    public final String ERROR_PARSE()
    {
        return "_e_parse";
    }

    public final String ERROR_RENDERER_INIT()
    {
        return "_e_renderer_init";
    }

    public final String ERROR_TIMEOUT()
    {
        return "_e_timeout";
    }

    public final String ERROR_UNKNOWN()
    {
        return "_e_unknown";
    }

    public final String ERROR_UNSUPPORTED_3P_FEATURE()
    {
        return "_e_unsupp-3p-feature";
    }

    public final String EVENT_ACTIVITY_STATE_CHANGED()
    {
        return "activityStateChanged";
    }

    public final String EVENT_AD_ACCEPT_INVITATION()
    {
        return "_accept-invitation";
    }

    public final String EVENT_AD_CLICK()
    {
        return "defaultClick";
    }

    public final String EVENT_AD_CLOSE()
    {
        return "_close";
    }

    public final String EVENT_AD_COLLAPSE()
    {
        return "_collapse";
    }

    public final String EVENT_AD_COMPLETE()
    {
        return "complete";
    }

    public final String EVENT_AD_EXPAND()
    {
        return "_expand";
    }

    public final String EVENT_AD_FIRST_QUARTILE()
    {
        return "firstQuartile";
    }

    public final String EVENT_AD_IMPRESSION()
    {
        return "defaultImpression";
    }

    public final String EVENT_AD_LOADED()
    {
        return "loaded";
    }

    public final String EVENT_AD_MIDPOINT()
    {
        return "midPoint";
    }

    public final String EVENT_AD_MUTE()
    {
        return "_mute";
    }

    public final String EVENT_AD_PAUSE()
    {
        return "_pause";
    }

    public final String EVENT_AD_QUARTILE()
    {
        return "quartile";
    }

    public final String EVENT_AD_RESUME()
    {
        return "_resume";
    }

    public final String EVENT_AD_REWIND()
    {
        return "_rewind";
    }

    public final String EVENT_AD_STARTED()
    {
        return "started";
    }

    public final String EVENT_AD_STOPPED()
    {
        return "stopped";
    }

    public final String EVENT_AD_THIRD_QUARTILE()
    {
        return "thirdQuartile";
    }

    public final String EVENT_AD_UNMUTE()
    {
        return "_un-mute";
    }

    public final String EVENT_ERROR()
    {
        return "_e_unknown";
    }

    public String EVENT_PROGRESS_UPDATE()
    {
        return "EVENT_PRORESS_UPDATE";
    }

    public final String EVENT_REQUEST_COMPLETE()
    {
        return "requestComplete";
    }

    public final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE()
    {
        return "requestContentVideoPause";
    }

    public final String EVENT_REQUEST_CONTENT_VIDEO_RESUME()
    {
        return "requestContentVideoResume";
    }

    public final String EVENT_SLOT_ENDED()
    {
        return "slotEnded";
    }

    public final String EVENT_SLOT_STARTED()
    {
        return "slotStarted";
    }

    public final String EVENT_TYPE_CLICK()
    {
        return "CLICK";
    }

    public final String EVENT_TYPE_CLICK_TRACKING()
    {
        return "CLICKTRACKING";
    }

    public final String EVENT_TYPE_IMPRESSION()
    {
        return "IMPRESSION";
    }

    public final String EVENT_TYPE_STANDARD()
    {
        return "STANDARD";
    }

    public final String EVENT_USER_ACTION_NOTIFIED()
    {
        return "userActionNotified";
    }

    public final String INFO_KEY_ACTIVITY_STATE()
    {
        return "activityState";
    }

    public final String INFO_KEY_AD_ID()
    {
        return "adId";
    }

    public final String INFO_KEY_CUSTOM_ID()
    {
        return "customId";
    }

    public final String INFO_KEY_ERROR_CODE()
    {
        return "errorCode";
    }

    public final String INFO_KEY_ERROR_INFO()
    {
        return "errorInfo";
    }

    public final String INFO_KEY_EXTRA_INFO()
    {
        return "extraInfo";
    }

    public final String INFO_KEY_MESSAGE()
    {
        return "message";
    }

    public final String INFO_KEY_REPLICA_ID()
    {
        return "replicaId";
    }

    public String INFO_KEY_SUCCESS()
    {
        return "success";
    }

    public final String INFO_KEY_URL()
    {
        return "url";
    }

    public final String INFO_KEY_USER_ACTION()
    {
        return "userAction";
    }

    public final int PARAMETER_LEVEL_GLOBAL()
    {
        return 1;
    }

    public final int PARAMETER_LEVEL_OVERRIDE()
    {
        return 5;
    }

    public final String PARAMETER_REQUEST_ALTERNATIVE_URL()
    {
        return "_fw_request_alternative_url";
    }

    public final int SLOT_TYPE_TEMPORAL()
    {
        return 0;
    }

    public final int TIME_POSITION_CLASS_DISPLAY()
    {
        return 5;
    }

    public final int TIME_POSITION_CLASS_MIDROLL()
    {
        return 2;
    }

    public final int TIME_POSITION_CLASS_OVERLAY()
    {
        return 4;
    }

    public final int TIME_POSITION_CLASS_PAUSE_MIDROLL()
    {
        return 6;
    }

    public final int TIME_POSITION_CLASS_POSTROLL()
    {
        return 3;
    }

    public final int TIME_POSITION_CLASS_PREROLL()
    {
        return 1;
    }

    public String TIME_POSITION_STRING()
    {
        return "TIME_POTISION";
    }

    public int USER_ACTION_PAUSE_BUTTON_CLICKED()
    {
        return _USER_ACTION_PAUSE_BUTTON_CLICKED;
    }

    public int USER_ACTION_RESUME_BUTTON_CLICKED()
    {
        return _USER_ACTION_RESUME_BUTTON_CLICKED;
    }

}
