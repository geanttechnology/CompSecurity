// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.interfaces;


public interface IConstants
{

    public abstract int ACTIVITY_CALLBACK_PAUSE();

    public abstract int ACTIVITY_CALLBACK_RESUME();

    public abstract int CAPABILITY_STATUS_OFF();

    public abstract int CAPABILITY_STATUS_ON();

    public abstract String ERROR_INVALID_SLOT();

    public abstract String ERROR_INVALID_VALUE();

    public abstract String ERROR_IO();

    public abstract String ERROR_NO_AD_AVAILABLE();

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

    public abstract String EVENT_AD_LOADED();

    public abstract String EVENT_AD_MIDPOINT();

    public abstract String EVENT_AD_MUTE();

    public abstract String EVENT_AD_PAUSE();

    public abstract String EVENT_AD_QUARTILE();

    public abstract String EVENT_AD_RESUME();

    public abstract String EVENT_AD_REWIND();

    public abstract String EVENT_AD_STARTED();

    public abstract String EVENT_AD_STOPPED();

    public abstract String EVENT_AD_THIRD_QUARTILE();

    public abstract String EVENT_AD_UNMUTE();

    public abstract String EVENT_ERROR();

    public abstract String EVENT_REQUEST_COMPLETE();

    public abstract String EVENT_REQUEST_CONTENT_VIDEO_PAUSE();

    public abstract String EVENT_REQUEST_CONTENT_VIDEO_RESUME();

    public abstract String EVENT_SLOT_ENDED();

    public abstract String EVENT_SLOT_STARTED();

    public abstract String EVENT_TYPE_CLICK();

    public abstract String EVENT_TYPE_CLICK_TRACKING();

    public abstract String EVENT_TYPE_IMPRESSION();

    public abstract String EVENT_TYPE_STANDARD();

    public abstract String EVENT_USER_ACTION_NOTIFIED();

    public abstract int ID_TYPE_CUSTOM();

    public abstract String INFO_KEY_ACTIVITY_STATE();

    public abstract String INFO_KEY_CUSTOM_ID();

    public abstract String INFO_KEY_ERROR_CODE();

    public abstract String INFO_KEY_ERROR_INFO();

    public abstract String INFO_KEY_EXTRA_INFO();

    public abstract String INFO_KEY_MESSAGE();

    public abstract String INFO_KEY_SUCCESS();

    public abstract String INFO_KEY_URL();

    public abstract String INFO_KEY_USER_ACTION();

    public abstract int PARAMETER_LEVEL_OVERRIDE();

    public abstract int SLOT_TYPE_TEMPORAL();

    public abstract int TIME_POSITION_CLASS_DISPLAY();

    public abstract int TIME_POSITION_CLASS_MIDROLL();

    public abstract int TIME_POSITION_CLASS_OVERLAY();

    public abstract int TIME_POSITION_CLASS_PAUSE_MIDROLL();

    public abstract int TIME_POSITION_CLASS_POSTROLL();

    public abstract int TIME_POSITION_CLASS_PREROLL();

    public abstract int USER_ACTION_PAUSE_BUTTON_CLICKED();

    public abstract int USER_ACTION_RESUME_BUTTON_CLICKED();

    public abstract int VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED();

    public abstract int VIDEO_ASSET_DURATION_TYPE_EXACT();
}
