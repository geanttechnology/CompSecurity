// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.interfaces;


public interface IConstants
{

    public abstract int ACTIVITY_CALLBACK_CREATE();

    public abstract int ACTIVITY_CALLBACK_DESTROY();

    public abstract int ACTIVITY_CALLBACK_PAUSE();

    public abstract int ACTIVITY_CALLBACK_RESTART();

    public abstract int ACTIVITY_CALLBACK_RESUME();

    public abstract int ACTIVITY_CALLBACK_START();

    public abstract int ACTIVITY_CALLBACK_STOP();

    public abstract int ACTIVITY_STATE_CREATE();

    public abstract int ACTIVITY_STATE_DESTROY();

    public abstract int ACTIVITY_STATE_PAUSE();

    public abstract int ACTIVITY_STATE_RESTART();

    public abstract int ACTIVITY_STATE_RESUME();

    public abstract int ACTIVITY_STATE_START();

    public abstract int ACTIVITY_STATE_STOP();

    public abstract String ADUNIT_MIDROLL();

    public abstract String ADUNIT_OVERLAY();

    public abstract String ADUNIT_PAUSE_MIDROLL();

    public abstract String ADUNIT_POSTROLL();

    public abstract String ADUNIT_PREROLL();

    public abstract String ADUNIT_STREAM_POSTROLL();

    public abstract String ADUNIT_STREAM_PREROLL();

    public abstract String ADUNIT_UNKNOWN();

    public abstract String CAPABILITY_ADUNIT_IN_MULTIPLE_SLOTS();

    public abstract String CAPABILITY_BYPASS_COMMERCIAL_RATIO_RESTRICTION();

    public abstract String CAPABILITY_CHECK_COMPANION();

    public abstract String CAPABILITY_CHECK_TARGETING();

    public abstract String CAPABILITY_MULTIPLE_CREATIVE_RENDITIONS();

    public abstract String CAPABILITY_RECORD_VIDEO_VIEW();

    public abstract String CAPABILITY_REQUIRES_RENDERER_MANIFEST();

    public abstract String CAPABILITY_RESET_EXCLUSIVITY();

    public abstract String CAPABILITY_SLOT_CALLBACK();

    public abstract String CAPABILITY_SLOT_TEMPLATE();

    public abstract int CAPABILITY_STATUS_DEFAULT();

    public abstract int CAPABILITY_STATUS_OFF();

    public abstract int CAPABILITY_STATUS_ON();

    public abstract String CAPABILITY_SYNC_MULTI_REQUESTS();

    public abstract String ERROR_3P_COMPONENT();

    public abstract String ERROR_ADINSTANCE_UNAVAILABLE();

    public abstract String ERROR_INVALID_SLOT();

    public abstract String ERROR_INVALID_VALUE();

    public abstract String ERROR_IO();

    public abstract String ERROR_MISSING_PARAMETER();

    public abstract String ERROR_NO_AD_AVAILABLE();

    public abstract String ERROR_NO_RENDERER();

    public abstract String ERROR_NULL_ASSET();

    public abstract String ERROR_PARSE();

    public abstract String ERROR_RENDERER_INIT();

    public abstract String ERROR_TIMEOUT();

    public abstract String ERROR_UNKNOWN();

    public abstract String ERROR_UNSUPPORTED_3P_FEATURE();

    public abstract String EVENT_ACTIVITY_STATE_CHANGED();

    public abstract String EVENT_AD_ACCEPT_INVITATION();

    public abstract String EVENT_AD_BUFFERING_END();

    public abstract String EVENT_AD_BUFFERING_START();

    public abstract String EVENT_AD_CLICK();

    public abstract String EVENT_AD_CLOSE();

    public abstract String EVENT_AD_COLLAPSE();

    public abstract String EVENT_AD_COMPLETE();

    public abstract String EVENT_AD_EXPAND();

    public abstract String EVENT_AD_FIRST_QUARTILE();

    public abstract String EVENT_AD_IMPRESSION();

    public abstract String EVENT_AD_IMPRESSION_END();

    public abstract String EVENT_AD_LOADED();

    public abstract String EVENT_AD_MIDPOINT();

    public abstract String EVENT_AD_MINIMIZE();

    public abstract String EVENT_AD_MUTE();

    public abstract String EVENT_AD_PAUSE();

    public abstract String EVENT_AD_QUARTILE();

    public abstract String EVENT_AD_RESUME();

    public abstract String EVENT_AD_REWIND();

    public abstract String EVENT_AD_STARTED();

    public abstract String EVENT_AD_STOPPED();

    public abstract String EVENT_AD_THIRD_QUARTILE();

    public abstract String EVENT_AD_UNMUTE();

    public abstract int EVENT_CODE_FAIL();

    public abstract int EVENT_CODE_SUCCESS();

    public abstract String EVENT_ERROR();

    public abstract String EVENT_EXTENSION_LOADED();

    public abstract String EVENT_REQUEST_COMPLETE();

    public abstract String EVENT_REQUEST_CONTENT_VIDEO_PAUSE();

    public abstract String EVENT_REQUEST_CONTENT_VIDEO_RESUME();

    public abstract String EVENT_RESELLER_NO_AD();

    public abstract String EVENT_SLOT_ENDED();

    public abstract String EVENT_SLOT_IMPRESSION();

    public abstract String EVENT_SLOT_PRELOADED();

    public abstract String EVENT_SLOT_STARTED();

    public abstract String EVENT_TYPE_CLICK();

    public abstract String EVENT_TYPE_CLICK_TRACKING();

    public abstract String EVENT_TYPE_IMPRESSION();

    public abstract String EVENT_TYPE_STANDARD();

    public abstract String EVENT_USER_ACTION_NOTIFIED();

    public abstract int ID_TYPE_CUSTOM();

    public abstract int ID_TYPE_FW();

    public abstract int ID_TYPE_FWGROUP();

    public abstract String INFO_KEY_ACTIVITY_STATE();

    public abstract String INFO_KEY_AD_ID();

    public abstract String INFO_KEY_CREATIVE_ID();

    public abstract String INFO_KEY_CUSTOM_EVENT_NAME();

    public abstract String INFO_KEY_CUSTOM_ID();

    public abstract String INFO_KEY_ERROR_CODE();

    public abstract String INFO_KEY_ERROR_INFO();

    public abstract String INFO_KEY_EXTRA_INFO();

    public abstract String INFO_KEY_MESSAGE();

    public abstract String INFO_KEY_MODULE_NAME();

    public abstract String INFO_KEY_MODULE_TYPE();

    public abstract String INFO_KEY_SHOW_BROWSER();

    public abstract String INFO_KEY_SUCCESS();

    public abstract String INFO_KEY_URL();

    public abstract String INFO_KEY_USER_ACTION();

    public abstract String MODULE_TYPE_RENDERER();

    public abstract String MODULE_TYPE_TRANSLATOR();

    public abstract String PARAMETER_ANDROID_ID();

    public abstract String PARAMETER_AREA_CODE();

    public abstract String PARAMETER_CLICK_DETECTION();

    public abstract String PARAMETER_CLICK_VIEW_HEIGHT();

    public abstract String PARAMETER_CLICK_VIEW_WIDTH();

    public abstract String PARAMETER_DATE_OF_BIRTH();

    public abstract String PARAMETER_DISPLAY_AD_HTML_CONTENT_CLICK_PROCESSING();

    public abstract String PARAMETER_ETHNICITY();

    public abstract String PARAMETER_GENDER();

    public abstract String PARAMETER_INCOME();

    public abstract String PARAMETER_KEYWORDS();

    public abstract int PARAMETER_LEVEL_CREATIVE();

    public abstract int PARAMETER_LEVEL_GLOBAL();

    public abstract int PARAMETER_LEVEL_OVERRIDE();

    public abstract int PARAMETER_LEVEL_PROFILE();

    public abstract int PARAMETER_LEVEL_RENDITION();

    public abstract int PARAMETER_LEVEL_SLOT();

    public abstract String PARAMETER_MARITAL();

    public abstract String PARAMETER_NONTEMPORAL_SLOT_VISIBILITY_AUTO_TRACKING();

    public abstract String PARAMETER_ORIENTATION();

    public abstract String PARAMETER_POSTAL_CODE();

    public abstract String PARAMETER_SEARCH_STRING();

    public abstract String PARAMETER_TRANSPARENT_BACKGROUND();

    public abstract String PARAMETER_VIDEO_AD_SCALING_MODE();

    public abstract String PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FILL();

    public abstract String PARAMETER_VIDEO_AD_SCALING_MODE_ASPECT_FIT();

    public abstract String PARAMETER_VIDEO_AD_SCALING_MODE_FILL();

    public abstract String PARAMETER_VIDEO_AD_SCALING_MODE_NONE();

    public abstract String RENDERER_LOAD_TIMEOUT_VALUE();

    public abstract int REQUEST_MODE_LIVE();

    public abstract int REQUEST_MODE_ON_DEMAND();

    public abstract int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_ONLY();

    public abstract int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_NO_STAND_ALONE();

    public abstract int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_NO_STAND_ALONE_IF_TEMPORAL();

    public abstract int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_OR_STAND_ALONE();

    public abstract int SLOT_OPTION_INITIAL_AD_FIRST_COMPANION_THEN_STAND_ALONE();

    public abstract int SLOT_OPTION_INITIAL_AD_KEEP_ORIGINAL();

    public abstract int SLOT_OPTION_INITIAL_AD_NO_STAND_ALONE();

    public abstract int SLOT_OPTION_INITIAL_AD_NO_STAND_ALONE_IF_TEMPORAL();

    public abstract int SLOT_OPTION_INITIAL_AD_STAND_ALONE();

    public abstract int SLOT_TYPE_SITESECTION_NONTEMPORAL();

    public abstract int SLOT_TYPE_TEMPORAL();

    public abstract int SLOT_TYPE_VIDEOPLAYER_NONTEMPORAL();

    public abstract int TIME_POSITION_CLASS_DISPLAY();

    public abstract int TIME_POSITION_CLASS_MIDROLL();

    public abstract int TIME_POSITION_CLASS_OVERLAY();

    public abstract int TIME_POSITION_CLASS_PAUSE_MIDROLL();

    public abstract int TIME_POSITION_CLASS_POSTROLL();

    public abstract int TIME_POSITION_CLASS_PREROLL();

    public abstract int USER_ACTION_PAUSE_BUTTON_CLICKED();

    public abstract int USER_ACTION_RESUME_BUTTON_CLICKED();

    public abstract int VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED();

    public abstract int VIDEO_ASSET_AUTO_PLAY_TYPE_NONE();

    public abstract int VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED();

    public abstract int VIDEO_ASSET_DURATION_TYPE_EXACT();

    public abstract int VIDEO_ASSET_DURATION_TYPE_VARIABLE();

    public abstract int VIDEO_STATE_COMPLETED();

    public abstract int VIDEO_STATE_PAUSED();

    public abstract int VIDEO_STATE_PLAYING();

    public abstract int VIDEO_STATE_STOPPED();
}
