// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import tv.freewheel.ad.interfaces.IConstants;

public final class Constants
    implements IConstants
{

    public static final int _ACTIVITY_CALLBACK_CREATE = 1;
    public static final int _ACTIVITY_CALLBACK_DESTROY = 7;
    public static final int _ACTIVITY_CALLBACK_PAUSE = 4;
    public static final int _ACTIVITY_CALLBACK_RESTART = 3;
    public static final int _ACTIVITY_CALLBACK_RESUME = 5;
    public static final int _ACTIVITY_CALLBACK_START = 2;
    public static final int _ACTIVITY_CALLBACK_STOP = 6;
    public static final String _ADUNIT_MIDROLL = "MIDROLL";
    public static final String _ADUNIT_OVERLAY = "OVERLAY";
    public static final String _ADUNIT_PAUSE_MIDROLL = "PAUSE_MIDROLL";
    public static final String _ADUNIT_POSTROLL = "POSTROLL";
    public static final String _ADUNIT_PREROLL = "PREROLL";
    public static final String _ADUNIT_STREAM_POSTROLL = "stream_postroll";
    public static final String _ADUNIT_STREAM_PREROLL = "stream_preroll";
    public static final String _ADUNIT_UNKNOWN = "UNKNOWN";
    public static final String _CAPABILITY_ADUNIT_IN_MULTIPLE_SLOTS = "supportsAdUnitInMultipleSlots";
    public static final String _CAPABILITY_BYPASS_COMMERCIAL_RATIO_RESTRICTION = "bypassCommercialRatioRestriction";
    public static final String _CAPABILITY_CHECK_COMPANION = "checkCompanion";
    public static final String _CAPABILITY_CHECK_TARGETING = "checkTargeting";
    public static final String _CAPABILITY_FALLBACK_ADS = "supportsFallbackAds";
    public static final String _CAPABILITY_MULTIPLE_CREATIVE_RENDITIONS = "expectMultipleCreativeRenditions";
    public static final String _CAPABILITY_RECORD_VIDEO_VIEW = "recordVideoView";
    public static final String _CAPABILITY_REQUIRES_RENDERER_MANIFEST = "requiresRendererManifest";
    public static final String _CAPABILITY_RESET_EXCLUSIVITY = "resetExclusivity";
    public static final String _CAPABILITY_SLOT_CALLBACK = "supportsSlotCallback";
    public static final String _CAPABILITY_SLOT_TEMPLATE = "supportsSlotTemplate";
    public static final int _CAPABILITY_STATUS_DEFAULT = 2;
    public static final int _CAPABILITY_STATUS_OFF = 1;
    public static final int _CAPABILITY_STATUS_ON = 0;
    public static final String _CAPABILITY_SYNC_MULTI_REQUESTS = "synchronizeMultipleRequests";
    public static final String _ERROR_3P_COMPONENT = "_e_3p-comp";
    public static final String _ERROR_ADINSTANCE_UNAVAILABLE = "_e_adinst-unavail";
    public static final String _ERROR_INVALID_SLOT = "_e_invalid-slot";
    public static final String _ERROR_INVALID_VALUE = "_e_invalid-value";
    public static final String _ERROR_IO = "_e_io";
    public static final String _ERROR_MISSING_PARAMETER = "_e_missing-param";
    public static final String _ERROR_NO_AD_AVAILABLE = "_e_no-ad";
    public static final String _ERROR_NO_RENDERER = "_e_no-renderer";
    public static final String _ERROR_NULL_ASSET = "_e_null-asset";
    public static final String _ERROR_PARSE = "_e_parse";
    public static final String _ERROR_RENDERER_INIT = "_e_renderer_init";
    public static final String _ERROR_RENDERER_LOAD = "_e_renderer-load";
    public static final String _ERROR_TIMEOUT = "_e_timeout";
    public static final String _ERROR_UNKNOWN = "_e_unknown";
    public static final String _ERROR_UNSUPPORTED_3P_FEATURE = "_e_unsupp-3p-feature";
    public static final String _EVENT_ACTIVITY_STATE_CHANGED = "activityStateChanged";
    public static final String _EVENT_AD_ACCEPT_INVITATION = "_accept-invitation";
    public static final String _EVENT_AD_BUFFERING_END = "bufferingEnd";
    public static final String _EVENT_AD_BUFFERING_START = "bufferingStart";
    public static final String _EVENT_AD_CLICK = "defaultClick";
    public static final String _EVENT_AD_CLOSE = "_close";
    public static final String _EVENT_AD_COLLAPSE = "_collapse";
    public static final String _EVENT_AD_COMPLETE = "complete";
    public static final String _EVENT_AD_EXPAND = "_expand";
    public static final String _EVENT_AD_FIRST_QUARTILE = "firstQuartile";
    public static final String _EVENT_AD_IMPRESSION = "defaultImpression";
    public static final String _EVENT_AD_IMPRESSION_END = "adEnd";
    public static final String _EVENT_AD_LOADED = "loaded";
    public static final String _EVENT_AD_MIDPOINT = "midPoint";
    public static final String _EVENT_AD_MINIMIZE = "_minimize";
    public static final String _EVENT_AD_MUTE = "_mute";
    public static final String _EVENT_AD_PAUSE = "_pause";
    public static final String _EVENT_AD_QUARTILE = "quartile";
    public static final String _EVENT_AD_RESUME = "_resume";
    public static final String _EVENT_AD_REWIND = "_rewind";
    public static final String _EVENT_AD_STARTED = "started";
    public static final String _EVENT_AD_STOPPED = "stopped";
    public static final String _EVENT_AD_THIRD_QUARTILE = "thirdQuartile";
    public static final String _EVENT_AD_UNMUTE = "_un-mute";
    public static final int _EVENT_CODE_FAIL = 0;
    public static final int _EVENT_CODE_SUCCESS = 1;
    public static final String _EVENT_ERROR = "_e_unknown";
    public static final String _EVENT_EXTENSION_LOADED = "extensionLoaded";
    public static final String _EVENT_REQUEST_COMPLETE = "requestComplete";
    public static final String _EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "requestContentVideoPause";
    public static final String _EVENT_REQUEST_CONTENT_VIDEO_RESUME = "requestContentVideoResume";
    public static final String _EVENT_RESELLER_NO_AD = "resellerNoAd";
    public static final String _EVENT_SLOT_ENDED = "slotEnded";
    public static final String _EVENT_SLOT_IMPRESSION = "slotImpression";
    public static final String _EVENT_SLOT_PRELOADED = "slotPreloaded";
    public static final String _EVENT_SLOT_STARTED = "slotStarted";
    public static final String _EVENT_TYPE_CLICK = "CLICK";
    public static final String _EVENT_TYPE_CLICK_TRACKING = "CLICKTRACKING";
    public static final String _EVENT_TYPE_IMPRESSION = "IMPRESSION";
    public static final String _EVENT_TYPE_STANDARD = "STANDARD";
    public static final String _EVENT_USER_ACTION_NOTIFIED = "userActionNotified";
    public static final int _ID_TYPE_CUSTOM = 0;
    public static final int _ID_TYPE_FW = 1;
    public static final int _ID_TYPE_FWGROUP = 2;
    public static final String _INFO_KEY_ACTIVITY_STATE = "activityState";
    public static final String _INFO_KEY_AD_ID = "adId";
    public static final String _INFO_KEY_CREATIVE_ID = "creativeId";
    public static final String _INFO_KEY_CUSTOM_EVENT_NAME = "customEventName";
    public static final String _INFO_KEY_CUSTOM_ID = "customId";
    public static final String _INFO_KEY_ERROR_CODE = "errorCode";
    public static final String _INFO_KEY_ERROR_INFO = "errorInfo";
    public static final String _INFO_KEY_ERROR_MODULE = "errorModule";
    public static final String _INFO_KEY_EXTRA_INFO = "extraInfo";
    public static final String _INFO_KEY_MESSAGE = "message";
    public static final String _INFO_KEY_MODULE_NAME = "moduleName";
    public static final String _INFO_KEY_MODULE_TYPE = "moduleType";
    public static final String _INFO_KEY_REQUIRED_API_VERSION = "requiredAPIVersion";
    public static final String _INFO_KEY_SHOW_BROWSER = "showBrowser";
    public static final String _INFO_KEY_SUCCESS = "success";
    public static final String _INFO_KEY_URL = "url";
    public static final String _INFO_KEY_USER_ACTION = "userAction";
    public static final String _MODULE_TYPE_RENDERER = "renderer";
    public static final String _MODULE_TYPE_TRANSLATOR = "translator";
    public static final String _PARAMETER_ANDROID_ID = "_fw_did_android_id";
    public static final String _PARAMETER_AREA_CODE = "areaCode";
    public static final String _PARAMETER_CLICK_DETECTION = "renderer.video.clickDetection";
    public static final String _PARAMETER_CLICK_VIEW_HEIGHT = "clickViewHeight";
    public static final String _PARAMETER_CLICK_VIEW_WIDTH = "clickViewWidth";
    public static final String _PARAMETER_DATE_OF_BIRTH = "dateOfBirth";
    public static final String _PARAMETER_DISPLAY_AD_HTML_CONTENT_CLICK_PROCESSING = "htmlContentClickProcessing";
    public static final String _PARAMETER_ETHNICITY = "ethnicity";
    public static final String _PARAMETER_GENDER = "gender";
    public static final String _PARAMETER_INCOME = "income";
    public static final String _PARAMETER_IN_APP_VIEW_LOADING_TIMEOUT = "loadTimeOutSecond";
    public static final String _PARAMETER_KEYWORDS = "keywords";
    public static final int _PARAMETER_LEVEL_CREATIVE = 3;
    public static final int _PARAMETER_LEVEL_GLOBAL = 1;
    public static final int _PARAMETER_LEVEL_OVERRIDE = 5;
    public static final int _PARAMETER_LEVEL_PROFILE = 0;
    public static final int _PARAMETER_LEVEL_RENDITION = 4;
    public static final int _PARAMETER_LEVEL_SLOT = 2;
    public static final String _PARAMETER_MARITAL = "marital";
    public static final String _PARAMETER_NONTEMPORAL_SLOT_VISIBILITY_AUTO_TRACKING = "FW_PARAMETER_NONTEMPORAL_SLOT_VISIBILITY_AUTO_TRACKING";
    public static final String _PARAMETER_OPEN_IN_APP = "tapOpensInApplication";
    public static final String _PARAMETER_ORIENTATION = "orientation";
    public static final String _PARAMETER_POSTAL_CODE = "postalCode";
    public static final String _PARAMETER_SEARCH_STRING = "searchString";
    public static final String _PARAMETER_TRANSPARENT_BACKGROUND = "transparentBackground";
    public static final String _PARAMETER_VIDEO_AD_SCALING_MODE = "FW_PARAMETER_VIDEO_AD_SCALING_MODE";
    public static final String _PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FILL = "FW_PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FILL";
    public static final String _PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FIT = "FW_PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FIT";
    public static final String _PARAMETER_VIDEO_AD_SCALING_MODE_FILL = "FW_PARAMETER_VIDEO_AD_SCALING_MODE_FILL";
    public static final String _PARAMETER_VIDEO_AD_SCALING_MODE_NONE = "FW_PARAMETER_VIDEO_AD_SCALING_MODE_NONE";
    public static final String _RENDERER_LOAD_TIMEOUT_VALUE = "rendererLoadTimeoutValue";
    public static final int _REQUEST_MODE_LIVE = 2;
    public static final int _REQUEST_MODE_ON_DEMAND = 1;
    public static final int _SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_ONLY = 2;
    public static final int _SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_NO_STAND_ALONE = 5;
    public static final int _SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_NO_STAND_ALONE_IF_TEMPORAL = 8;
    public static final int _SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_STAND_ALONE = 3;
    public static final int _SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_THEN_STAND_ALONE = 4;
    public static final int _SLOT_OPTION_INITIAL_AD_KEEP_ORIGINAL = 1;
    public static final int _SLOT_OPTION_INITIAL_AD_NO_STAND_ALONE = 6;
    public static final int _SLOT_OPTION_INITIAL_AD_NO_STAND_ALONE_IF_TEMPORAL = 7;
    public static final int _SLOT_OPTION_INITIAL_AD_STAND_ALONE = 0;
    public static final int _SLOT_TYPE_SITESECTION_NONTEMPORAL = 2;
    public static final int _SLOT_TYPE_TEMPORAL = 0;
    public static final int _SLOT_TYPE_VIDEOPLAYER_NONTEMPORAL = 1;
    public static final int _TIME_POSITION_CLASS_DISPLAY = 5;
    public static final int _TIME_POSITION_CLASS_MIDROLL = 2;
    public static final int _TIME_POSITION_CLASS_OVERLAY = 4;
    public static final int _TIME_POSITION_CLASS_PAUSE_MIDROLL = 6;
    public static final int _TIME_POSITION_CLASS_POSTROLL = 3;
    public static final int _TIME_POSITION_CLASS_PREROLL = 1;
    public static int _USER_ACTION_PAUSE_BUTTON_CLICKED = 0;
    public static int _USER_ACTION_RESUME_BUTTON_CLICKED = 0;
    public static final int _VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED = 1;
    public static final int _VIDEO_ASSET_AUTO_PLAY_TYPE_NONE = 0;
    public static final int _VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED = 2;
    public static final int _VIDEO_ASSET_DURATION_TYPE_EXACT = 1;
    public static final int _VIDEO_ASSET_DURATION_TYPE_VARIABLE = 2;
    public static final int _VIDEO_STATE_COMPLETED = 4;
    public static final int _VIDEO_STATE_PAUSED = 2;
    public static final int _VIDEO_STATE_PLAYING = 1;
    public static final int _VIDEO_STATE_STOPPED = 3;

    public Constants()
    {
    }

    public final int ACTIVITY_CALLBACK_CREATE()
    {
        return 1;
    }

    public final int ACTIVITY_CALLBACK_DESTROY()
    {
        return 7;
    }

    public final int ACTIVITY_CALLBACK_PAUSE()
    {
        return 4;
    }

    public final int ACTIVITY_CALLBACK_RESTART()
    {
        return 3;
    }

    public final int ACTIVITY_CALLBACK_RESUME()
    {
        return 5;
    }

    public final int ACTIVITY_CALLBACK_START()
    {
        return 2;
    }

    public final int ACTIVITY_CALLBACK_STOP()
    {
        return 6;
    }

    public final int ACTIVITY_STATE_CREATE()
    {
        return 1;
    }

    public final int ACTIVITY_STATE_DESTROY()
    {
        return 7;
    }

    public final int ACTIVITY_STATE_PAUSE()
    {
        return 4;
    }

    public final int ACTIVITY_STATE_RESTART()
    {
        return 3;
    }

    public final int ACTIVITY_STATE_RESUME()
    {
        return 5;
    }

    public final int ACTIVITY_STATE_START()
    {
        return 2;
    }

    public final int ACTIVITY_STATE_STOP()
    {
        return 6;
    }

    public final String ADUNIT_MIDROLL()
    {
        return "MIDROLL";
    }

    public final String ADUNIT_OVERLAY()
    {
        return "OVERLAY";
    }

    public final String ADUNIT_PAUSE_MIDROLL()
    {
        return "PAUSE_MIDROLL";
    }

    public final String ADUNIT_POSTROLL()
    {
        return "POSTROLL";
    }

    public final String ADUNIT_PREROLL()
    {
        return "PREROLL";
    }

    public final String ADUNIT_STREAM_POSTROLL()
    {
        return "stream_postroll";
    }

    public final String ADUNIT_STREAM_PREROLL()
    {
        return "stream_preroll";
    }

    public final String ADUNIT_UNKNOWN()
    {
        return "UNKNOWN";
    }

    public final String CAPABILITY_ADUNIT_IN_MULTIPLE_SLOTS()
    {
        return "supportsAdUnitInMultipleSlots";
    }

    public final String CAPABILITY_BYPASS_COMMERCIAL_RATIO_RESTRICTION()
    {
        return "bypassCommercialRatioRestriction";
    }

    public final String CAPABILITY_CHECK_COMPANION()
    {
        return "checkCompanion";
    }

    public final String CAPABILITY_CHECK_TARGETING()
    {
        return "checkTargeting";
    }

    public final String CAPABILITY_FALLBACK_ADS()
    {
        return "supportsFallbackAds";
    }

    public final String CAPABILITY_MULTIPLE_CREATIVE_RENDITIONS()
    {
        return "expectMultipleCreativeRenditions";
    }

    public final String CAPABILITY_RECORD_VIDEO_VIEW()
    {
        return "recordVideoView";
    }

    public final String CAPABILITY_REQUIRES_RENDERER_MANIFEST()
    {
        return "requiresRendererManifest";
    }

    public final String CAPABILITY_RESET_EXCLUSIVITY()
    {
        return "resetExclusivity";
    }

    public final String CAPABILITY_SLOT_CALLBACK()
    {
        return "supportsSlotCallback";
    }

    public final String CAPABILITY_SLOT_TEMPLATE()
    {
        return "supportsSlotTemplate";
    }

    public final int CAPABILITY_STATUS_DEFAULT()
    {
        return 2;
    }

    public final int CAPABILITY_STATUS_OFF()
    {
        return 1;
    }

    public final int CAPABILITY_STATUS_ON()
    {
        return 0;
    }

    public final String CAPABILITY_SYNC_MULTI_REQUESTS()
    {
        return "synchronizeMultipleRequests";
    }

    public final String ERROR_3P_COMPONENT()
    {
        return "_e_3p-comp";
    }

    public final String ERROR_ADINSTANCE_UNAVAILABLE()
    {
        return "_e_adinst-unavail";
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

    public final String ERROR_MISSING_PARAMETER()
    {
        return "_e_missing-param";
    }

    public final String ERROR_NO_AD_AVAILABLE()
    {
        return "_e_no-ad";
    }

    public final String ERROR_NO_RENDERER()
    {
        return "_e_no-renderer";
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

    public final String EVENT_AD_BUFFERING_END()
    {
        return "bufferingEnd";
    }

    public final String EVENT_AD_BUFFERING_START()
    {
        return "bufferingStart";
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

    public final String EVENT_AD_IMPRESSION_END()
    {
        return "adEnd";
    }

    public final String EVENT_AD_LOADED()
    {
        return "loaded";
    }

    public final String EVENT_AD_MIDPOINT()
    {
        return "midPoint";
    }

    public final String EVENT_AD_MINIMIZE()
    {
        return "_minimize";
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

    public final int EVENT_CODE_FAIL()
    {
        return 0;
    }

    public final int EVENT_CODE_SUCCESS()
    {
        return 1;
    }

    public final String EVENT_ERROR()
    {
        return "_e_unknown";
    }

    public final String EVENT_EXTENSION_LOADED()
    {
        return "extensionLoaded";
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

    public final String EVENT_RESELLER_NO_AD()
    {
        return "resellerNoAd";
    }

    public final String EVENT_SLOT_ENDED()
    {
        return "slotEnded";
    }

    public final String EVENT_SLOT_IMPRESSION()
    {
        return "slotImpression";
    }

    public final String EVENT_SLOT_PRELOADED()
    {
        return "slotPreloaded";
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

    public final int ID_TYPE_CUSTOM()
    {
        return 0;
    }

    public final int ID_TYPE_FW()
    {
        return 1;
    }

    public final int ID_TYPE_FWGROUP()
    {
        return 2;
    }

    public final String INFO_KEY_ACTIVITY_STATE()
    {
        return "activityState";
    }

    public final String INFO_KEY_AD_ID()
    {
        return "adId";
    }

    public final String INFO_KEY_CREATIVE_ID()
    {
        return "creativeId";
    }

    public final String INFO_KEY_CUSTOM_EVENT_NAME()
    {
        return "customEventName";
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

    public final String INFO_KEY_ERROR_MODULE()
    {
        return "errorModule";
    }

    public final String INFO_KEY_EXTRA_INFO()
    {
        return "extraInfo";
    }

    public final String INFO_KEY_MESSAGE()
    {
        return "message";
    }

    public final String INFO_KEY_MODULE_NAME()
    {
        return "moduleName";
    }

    public final String INFO_KEY_MODULE_TYPE()
    {
        return "moduleType";
    }

    public final String INFO_KEY_REQUIRED_API_VERSION()
    {
        return "requiredAPIVersion";
    }

    public final String INFO_KEY_SHOW_BROWSER()
    {
        return "showBrowser";
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

    public final String MODULE_TYPE_RENDERER()
    {
        return "renderer";
    }

    public final String MODULE_TYPE_TRANSLATOR()
    {
        return "translator";
    }

    public String PARAMETER_ANDROID_ID()
    {
        return "_fw_did_android_id";
    }

    public String PARAMETER_AREA_CODE()
    {
        return "areaCode";
    }

    public final String PARAMETER_CLICK_DETECTION()
    {
        return "renderer.video.clickDetection";
    }

    public final String PARAMETER_CLICK_VIEW_HEIGHT()
    {
        return "clickViewHeight";
    }

    public final String PARAMETER_CLICK_VIEW_WIDTH()
    {
        return "clickViewWidth";
    }

    public String PARAMETER_DATE_OF_BIRTH()
    {
        return "dateOfBirth";
    }

    public final String PARAMETER_DISPLAY_AD_HTML_CONTENT_CLICK_PROCESSING()
    {
        return "htmlContentClickProcessing";
    }

    public String PARAMETER_ETHNICITY()
    {
        return "ethnicity";
    }

    public String PARAMETER_GENDER()
    {
        return "gender";
    }

    public String PARAMETER_INCOME()
    {
        return "income";
    }

    public final String PARAMETER_IN_APP_VIEW_LOADING_TIMEOUT()
    {
        return "loadTimeOutSecond";
    }

    public String PARAMETER_KEYWORDS()
    {
        return "keywords";
    }

    public final int PARAMETER_LEVEL_CREATIVE()
    {
        return 3;
    }

    public final int PARAMETER_LEVEL_GLOBAL()
    {
        return 1;
    }

    public final int PARAMETER_LEVEL_OVERRIDE()
    {
        return 5;
    }

    public final int PARAMETER_LEVEL_PROFILE()
    {
        return 0;
    }

    public final int PARAMETER_LEVEL_RENDITION()
    {
        return 4;
    }

    public final int PARAMETER_LEVEL_SLOT()
    {
        return 2;
    }

    public String PARAMETER_MARITAL()
    {
        return "marital";
    }

    public final String PARAMETER_NONTEMPORAL_SLOT_VISIBILITY_AUTO_TRACKING()
    {
        return "FW_PARAMETER_NONTEMPORAL_SLOT_VISIBILITY_AUTO_TRACKING";
    }

    public final String PARAMETER_OPEN_IN_APP()
    {
        return "tapOpensInApplication";
    }

    public String PARAMETER_ORIENTATION()
    {
        return "orientation";
    }

    public String PARAMETER_POSTAL_CODE()
    {
        return "postalCode";
    }

    public String PARAMETER_SEARCH_STRING()
    {
        return "searchString";
    }

    public final String PARAMETER_TRANSPARENT_BACKGROUND()
    {
        return "transparentBackground";
    }

    public final String PARAMETER_VIDEO_AD_SCALING_MODE()
    {
        return "FW_PARAMETER_VIDEO_AD_SCALING_MODE";
    }

    public final String PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FILL()
    {
        return "FW_PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FILL";
    }

    public final String PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FIT()
    {
        return "FW_PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FIT";
    }

    public final String PARAMETER_VIDEO_AD_SCALING_MODE_FILL()
    {
        return "FW_PARAMETER_VIDEO_AD_SCALING_MODE_FILL";
    }

    public final String PARAMETER_VIDEO_AD_SCALING_MODE_NONE()
    {
        return "FW_PARAMETER_VIDEO_AD_SCALING_MODE_NONE";
    }

    public String RENDERER_LOAD_TIMEOUT_VALUE()
    {
        return "rendererLoadTimeoutValue";
    }

    public int REQUEST_MODE_LIVE()
    {
        return 2;
    }

    public int REQUEST_MODE_ON_DEMAND()
    {
        return 1;
    }

    public int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_ONLY()
    {
        return 2;
    }

    public int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_NO_STAND_ALONE()
    {
        return 5;
    }

    public int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_NO_STAND_ALONE_IF_TEMPORAL()
    {
        return 8;
    }

    public int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_STAND_ALONE()
    {
        return 3;
    }

    public int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_THEN_STAND_ALONE()
    {
        return 4;
    }

    public int SLOT_OPTION_INITIAL_AD_KEEP_ORIGINAL()
    {
        return 1;
    }

    public int SLOT_OPTION_INITIAL_AD_NO_STAND_ALONE()
    {
        return 6;
    }

    public int SLOT_OPTION_INITIAL_AD_NO_STAND_ALONE_IF_TEMPORAL()
    {
        return 7;
    }

    public int SLOT_OPTION_INITIAL_AD_STAND_ALONE()
    {
        return 0;
    }

    public final int SLOT_TYPE_SITESECTION_NONTEMPORAL()
    {
        return 2;
    }

    public final int SLOT_TYPE_TEMPORAL()
    {
        return 0;
    }

    public final int SLOT_TYPE_VIDEOPLAYER_NONTEMPORAL()
    {
        return 1;
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

    public int USER_ACTION_PAUSE_BUTTON_CLICKED()
    {
        return _USER_ACTION_PAUSE_BUTTON_CLICKED;
    }

    public int USER_ACTION_RESUME_BUTTON_CLICKED()
    {
        return _USER_ACTION_RESUME_BUTTON_CLICKED;
    }

    public final int VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED()
    {
        return 1;
    }

    public final int VIDEO_ASSET_AUTO_PLAY_TYPE_NONE()
    {
        return 0;
    }

    public final int VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED()
    {
        return 2;
    }

    public final int VIDEO_ASSET_DURATION_TYPE_EXACT()
    {
        return 1;
    }

    public final int VIDEO_ASSET_DURATION_TYPE_VARIABLE()
    {
        return 2;
    }

    public final int VIDEO_STATE_COMPLETED()
    {
        return 4;
    }

    public final int VIDEO_STATE_PAUSED()
    {
        return 2;
    }

    public final int VIDEO_STATE_PLAYING()
    {
        return 1;
    }

    public final int VIDEO_STATE_STOPPED()
    {
        return 3;
    }

    static 
    {
        _USER_ACTION_PAUSE_BUTTON_CLICKED = 1;
        _USER_ACTION_RESUME_BUTTON_CLICKED = 2;
    }
}
