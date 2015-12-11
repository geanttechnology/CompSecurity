// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.error;


public final class ErrorCode extends Enum
{

    private static final ErrorCode $VALUES[];
    public static final ErrorCode ANDROID_AUTHZ_FAILED_EXCEPTION;
    public static final ErrorCode ANDROID_AUTHZ_TIMEOUT_EXCEPTION;
    public static final ErrorCode ANDROID_INVALID_AUTHTOKEN_FORMAT_EXCEPTION;
    public static final ErrorCode ANDROID_INVALID_MEDIA_EXCEPTION;
    public static final ErrorCode ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION;
    public static final ErrorCode ANDROID_METHOD_NOT_SUPPORTED_EXCEPTION;
    public static final ErrorCode ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION;
    public static final ErrorCode ANDROID_SDK_CHANNELS_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_CHANNELS_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SDK_CONFIG_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_CONFIG_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_CONFIG_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SDK_ENTITLEMENT_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_ENTITLEMENT_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_ENTITLEMENT_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SDK_FATAL_EXCEPTION_ERROR;
    public static final ErrorCode ANDROID_SDK_GEO_OUTSIDE_US;
    public static final ErrorCode ANDROID_SDK_GEO_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_GEO_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_GEO_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE;
    public static final ErrorCode ANDROID_SDK_GEO_UNSUPPORTED_AREA;
    public static final ErrorCode ANDROID_SDK_HDMI_OUTPUT_EXCEPTION;
    public static final ErrorCode ANDROID_SDK_INVALID_APIKEY_EXCEPTION;
    public static final ErrorCode ANDROID_SDK_INVALID_CONFIGURATION;
    public static final ErrorCode ANDROID_SDK_MEDIA_PLAYER_ASSET_UNAVAILABLE;
    public static final ErrorCode ANDROID_SDK_MEDIA_PLAYER_ASSET_UNPLAYABLE;
    public static final ErrorCode ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION;
    public static final ErrorCode ANDROID_SDK_MEDIA_PLAYER_INVALID_FORMAT;
    public static final ErrorCode ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR;
    public static final ErrorCode ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SDK_PARTNER_VIDEO_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_PARTNER_VIDEO_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_PARTNER_VIDEO_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION;
    public static final ErrorCode ANDROID_SDK_RUNTIME_EXCEPTION;
    public static final ErrorCode ANDROID_SDK_SERVICE_INVALID_HOST;
    public static final ErrorCode ANDROID_SDK_SERVICE_UNDEFINED_HOST;
    public static final ErrorCode ANDROID_SDK_SHOWS_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_SHOWS_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_SHOWS_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SDK_SLOGGER_ERROR;
    public static final ErrorCode ANDROID_SDK_UNSUPPORTED_APILEVEL_ERROR;
    public static final ErrorCode ANDROID_SDK_UNSUPPORTED_DEVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_VIDEOS_SERVICE_ERROR;
    public static final ErrorCode ANDROID_SDK_VIDEOS_SERVICE_IO_ERROR;
    public static final ErrorCode ANDROID_SDK_VIDEOS_SERVICE_TIMEOUT;
    public static final ErrorCode ANDROID_SEEK_DISABLED;
    public static final ErrorCode ANDROID_UNMANAGED_PLAYER_EXCEPTION;
    public int errorCode;
    String reason;

    private ErrorCode(String s, int i, int j, String s1)
    {
        super(s, i);
        errorCode = j;
        reason = s1;
    }

    public static ErrorCode valueOf(String s)
    {
        return (ErrorCode)Enum.valueOf(com/disney/datg/videoplatforms/sdk/error/ErrorCode, s);
    }

    public static ErrorCode[] values()
    {
        return (ErrorCode[])$VALUES.clone();
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public String getReason()
    {
        return reason;
    }

    static 
    {
        ANDROID_SDK_FATAL_EXCEPTION_ERROR = new ErrorCode("ANDROID_SDK_FATAL_EXCEPTION_ERROR", 0, 1000, "A Fatal Exception has occurred");
        ANDROID_SDK_RUNTIME_EXCEPTION = new ErrorCode("ANDROID_SDK_RUNTIME_EXCEPTION", 1, 1001, "A Runtime Exception has occured and the contents cannot be displayed");
        ANDROID_SDK_INVALID_CONFIGURATION = new ErrorCode("ANDROID_SDK_INVALID_CONFIGURATION", 2, 1002, "PlayerManager could not be created");
        ANDROID_METHOD_NOT_SUPPORTED_EXCEPTION = new ErrorCode("ANDROID_METHOD_NOT_SUPPORTED_EXCEPTION", 3, 1003, "Method called is not supported by SDK");
        ANDROID_SDK_UNSUPPORTED_APILEVEL_ERROR = new ErrorCode("ANDROID_SDK_UNSUPPORTED_APILEVEL_ERROR", 4, 1004, "The OS that initialized the application is running an unsupported API level. Required API level is ICS or Higher");
        ANDROID_SDK_HDMI_OUTPUT_EXCEPTION = new ErrorCode("ANDROID_SDK_HDMI_OUTPUT_EXCEPTION", 5, 1005, "Please disconnect the secondary output to play the video");
        ANDROID_SDK_INVALID_APIKEY_EXCEPTION = new ErrorCode("ANDROID_SDK_INVALID_APIKEY_EXCEPTION", 6, 1006, "api key is invalid");
        ANDROID_SDK_UNSUPPORTED_DEVICE_ERROR = new ErrorCode("ANDROID_SDK_UNSUPPORTED_DEVICE_ERROR", 7, 1007, "This device is not supported by the library");
        ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION = new ErrorCode("ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION", 8, 2001, "PlayerManager could not be created");
        ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION = new ErrorCode("ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION", 9, 2002, "CatalogManager could not be created");
        ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION = new ErrorCode("ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION", 10, 2003, "PlayerManager could not be created");
        ANDROID_INVALID_MEDIA_EXCEPTION = new ErrorCode("ANDROID_INVALID_MEDIA_EXCEPTION", 11, 2004, "VPMedia item supplied as input is invalid");
        ANDROID_UNMANAGED_PLAYER_EXCEPTION = new ErrorCode("ANDROID_UNMANAGED_PLAYER_EXCEPTION", 12, 2005, "Player is created but detached from VPPlayerManager");
        ANDROID_INVALID_AUTHTOKEN_FORMAT_EXCEPTION = new ErrorCode("ANDROID_INVALID_AUTHTOKEN_FORMAT_EXCEPTION", 13, 2006, "VPAuthToken supplied is invalid");
        ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION = new ErrorCode("ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION", 14, 2007, "VPMedia item supplied is of the wrong type for the current player");
        ANDROID_SDK_MEDIA_PLAYER_ASSET_UNPLAYABLE = new ErrorCode("ANDROID_SDK_MEDIA_PLAYER_ASSET_UNPLAYABLE", 15, 30102, "Asset supplied is unplayable");
        ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR = new ErrorCode("ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR", 16, 30008, "playback-stopped-[video id]");
        ANDROID_SDK_MEDIA_PLAYER_ASSET_UNAVAILABLE = new ErrorCode("ANDROID_SDK_MEDIA_PLAYER_ASSET_UNAVAILABLE", 17, 30007, "playback-missing-content-episode-[video id]");
        ANDROID_SDK_MEDIA_PLAYER_INVALID_FORMAT = new ErrorCode("ANDROID_SDK_MEDIA_PLAYER_INVALID_FORMAT", 18, 30004, "Asset is an invalid format");
        ANDROID_SEEK_DISABLED = new ErrorCode("ANDROID_SEEK_DISABLED", 19, 30005, "Seek is currently disabled");
        ANDROID_SDK_SERVICE_UNDEFINED_HOST = new ErrorCode("ANDROID_SDK_SERVICE_UNDEFINED_HOST", 20, 40001, "Host supplied does not exist");
        ANDROID_SDK_SERVICE_INVALID_HOST = new ErrorCode("ANDROID_SDK_SERVICE_INVALID_HOST", 21, 40002, "Host supplied is in an invalid format");
        ANDROID_SDK_CONFIG_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_CONFIG_SERVICE_ERROR", 22, 40003, "Service has encounted an error and has to quit");
        ANDROID_SDK_CONFIG_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_CONFIG_SERVICE_IO_ERROR", 23, 40004, "Error occurred while processing response data");
        ANDROID_SDK_CONFIG_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_CONFIG_SERVICE_TIMEOUT", 24, 40801, "Unable to connect to the server");
        ANDROID_SDK_VIDEOS_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_VIDEOS_SERVICE_ERROR", 25, 40005, "Service has encounted an error and has to quit");
        ANDROID_SDK_VIDEOS_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_VIDEOS_SERVICE_TIMEOUT", 26, 40802, "Unable to connect to the server");
        ANDROID_SDK_VIDEOS_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_VIDEOS_SERVICE_IO_ERROR", 27, 40006, "Error occurred while processing response data");
        ANDROID_SDK_CHANNELS_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_CHANNELS_SERVICE_ERROR", 28, 40007, "Service has encounted an error and has to quit");
        ANDROID_SDK_CHANNELS_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_CHANNELS_SERVICE_IO_ERROR", 29, 40008, "Error occurred while processing response data");
        ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT", 30, 40803, "Unable to connect to the server");
        ANDROID_SDK_SHOWS_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_SHOWS_SERVICE_ERROR", 31, 40009, "Service has encounted an error and has to quit");
        ANDROID_SDK_SHOWS_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_SHOWS_SERVICE_IO_ERROR", 32, 40010, "Error occurred while processing response data");
        ANDROID_SDK_SHOWS_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_SHOWS_SERVICE_TIMEOUT", 33, 40804, "Unable to connect to the server");
        ANDROID_SDK_ENTITLEMENT_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_ENTITLEMENT_SERVICE_ERROR", 34, 40315, "Service has encounted an error and has to quit");
        ANDROID_SDK_ENTITLEMENT_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_ENTITLEMENT_SERVICE_IO_ERROR", 35, 40316, "Error occurred while processing response data");
        ANDROID_SDK_ENTITLEMENT_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_ENTITLEMENT_SERVICE_TIMEOUT", 36, 40805, "Unable to connect to the server");
        ANDROID_SDK_GEO_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_GEO_SERVICE_ERROR", 37, 40318, "Service has encounted an error and has to quit");
        ANDROID_SDK_GEO_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_GEO_SERVICE_IO_ERROR", 38, 40319, "Error occurred while processing response data");
        ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE = new ErrorCode("ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE", 39, 40320, "Affiliate is not supported");
        ANDROID_SDK_GEO_UNSUPPORTED_AREA = new ErrorCode("ANDROID_SDK_GEO_UNSUPPORTED_AREA", 40, 40322, "Unsupported area for live stream");
        ANDROID_SDK_GEO_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_GEO_SERVICE_TIMEOUT", 41, 40806, "Unable to connect to the server");
        ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_ERROR", 42, 40011, "Service has encounted an error and has to quit");
        ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_IO_ERROR", 43, 40012, "Error occurred while processing response data");
        ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_TIMEOUT", 44, 40807, "Unable to connect to the server");
        ANDROID_SDK_PARTNER_VIDEO_SERVICE_ERROR = new ErrorCode("ANDROID_SDK_PARTNER_VIDEO_SERVICE_ERROR", 45, 40013, "Service has encounted an error and has to quit");
        ANDROID_SDK_PARTNER_VIDEO_SERVICE_IO_ERROR = new ErrorCode("ANDROID_SDK_PARTNER_VIDEO_SERVICE_IO_ERROR", 46, 40014, "Error occurred while processing response data");
        ANDROID_SDK_PARTNER_VIDEO_SERVICE_TIMEOUT = new ErrorCode("ANDROID_SDK_PARTNER_VIDEO_SERVICE_TIMEOUT", 47, 40808, "Unable to connect to the server");
        ANDROID_SDK_GEO_OUTSIDE_US = new ErrorCode("ANDROID_SDK_GEO_OUTSIDE_US", 48, 50001, "You appear to be outside the United States or its territories. Due to international rights agreements, we only offer this video to viewers located within the United States and its territories");
        ANDROID_AUTHZ_TIMEOUT_EXCEPTION = new ErrorCode("ANDROID_AUTHZ_TIMEOUT_EXCEPTION", 49, 40101, "AUTHZ has timed-out");
        ANDROID_AUTHZ_FAILED_EXCEPTION = new ErrorCode("ANDROID_AUTHZ_FAILED_EXCEPTION", 50, 40102, "AUTHZ has failed");
        ANDROID_SDK_SLOGGER_ERROR = new ErrorCode("ANDROID_SDK_SLOGGER_ERROR", 51, 40016, "Error occurred while processing response data");
        $VALUES = (new ErrorCode[] {
            ANDROID_SDK_FATAL_EXCEPTION_ERROR, ANDROID_SDK_RUNTIME_EXCEPTION, ANDROID_SDK_INVALID_CONFIGURATION, ANDROID_METHOD_NOT_SUPPORTED_EXCEPTION, ANDROID_SDK_UNSUPPORTED_APILEVEL_ERROR, ANDROID_SDK_HDMI_OUTPUT_EXCEPTION, ANDROID_SDK_INVALID_APIKEY_EXCEPTION, ANDROID_SDK_UNSUPPORTED_DEVICE_ERROR, ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION, ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION, 
            ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, ANDROID_INVALID_MEDIA_EXCEPTION, ANDROID_UNMANAGED_PLAYER_EXCEPTION, ANDROID_INVALID_AUTHTOKEN_FORMAT_EXCEPTION, ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION, ANDROID_SDK_MEDIA_PLAYER_ASSET_UNPLAYABLE, ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR, ANDROID_SDK_MEDIA_PLAYER_ASSET_UNAVAILABLE, ANDROID_SDK_MEDIA_PLAYER_INVALID_FORMAT, ANDROID_SEEK_DISABLED, 
            ANDROID_SDK_SERVICE_UNDEFINED_HOST, ANDROID_SDK_SERVICE_INVALID_HOST, ANDROID_SDK_CONFIG_SERVICE_ERROR, ANDROID_SDK_CONFIG_SERVICE_IO_ERROR, ANDROID_SDK_CONFIG_SERVICE_TIMEOUT, ANDROID_SDK_VIDEOS_SERVICE_ERROR, ANDROID_SDK_VIDEOS_SERVICE_TIMEOUT, ANDROID_SDK_VIDEOS_SERVICE_IO_ERROR, ANDROID_SDK_CHANNELS_SERVICE_ERROR, ANDROID_SDK_CHANNELS_SERVICE_IO_ERROR, 
            ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT, ANDROID_SDK_SHOWS_SERVICE_ERROR, ANDROID_SDK_SHOWS_SERVICE_IO_ERROR, ANDROID_SDK_SHOWS_SERVICE_TIMEOUT, ANDROID_SDK_ENTITLEMENT_SERVICE_ERROR, ANDROID_SDK_ENTITLEMENT_SERVICE_IO_ERROR, ANDROID_SDK_ENTITLEMENT_SERVICE_TIMEOUT, ANDROID_SDK_GEO_SERVICE_ERROR, ANDROID_SDK_GEO_SERVICE_IO_ERROR, ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE, 
            ANDROID_SDK_GEO_UNSUPPORTED_AREA, ANDROID_SDK_GEO_SERVICE_TIMEOUT, ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_ERROR, ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_IO_ERROR, ANDROID_SDK_PARTNER_SCHEDULE_SERVICE_TIMEOUT, ANDROID_SDK_PARTNER_VIDEO_SERVICE_ERROR, ANDROID_SDK_PARTNER_VIDEO_SERVICE_IO_ERROR, ANDROID_SDK_PARTNER_VIDEO_SERVICE_TIMEOUT, ANDROID_SDK_GEO_OUTSIDE_US, ANDROID_AUTHZ_TIMEOUT_EXCEPTION, 
            ANDROID_AUTHZ_FAILED_EXCEPTION, ANDROID_SDK_SLOGGER_ERROR
        });
    }
}
