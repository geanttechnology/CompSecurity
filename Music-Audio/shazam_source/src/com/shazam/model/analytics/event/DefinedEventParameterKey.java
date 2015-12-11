// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.analytics.event;


// Referenced classes of package com.shazam.model.analytics.event:
//            EventParameterKey

public final class DefinedEventParameterKey extends Enum
    implements EventParameterKey
{

    private static final DefinedEventParameterKey $VALUES[];
    public static final DefinedEventParameterKey ACTION;
    public static final DefinedEventParameterKey AD_PROVIDER;
    public static final DefinedEventParameterKey ARTIST_ID;
    public static final DefinedEventParameterKey BACKGROUND;
    public static final DefinedEventParameterKey BLUETOOTH;
    public static final DefinedEventParameterKey CAMPAIGN;
    public static final DefinedEventParameterKey CARD_POSITION;
    public static final DefinedEventParameterKey CARD_TYPE;
    public static final DefinedEventParameterKey CHANGED_FROM;
    public static final DefinedEventParameterKey CHANGED_TO;
    public static final DefinedEventParameterKey CHART_TITLE;
    public static final DefinedEventParameterKey CODE;
    public static final DefinedEventParameterKey COMPLETED;
    public static final DefinedEventParameterKey COUNT;
    public static final DefinedEventParameterKey DEEP_LINK_ID;
    public static final DefinedEventParameterKey DELETE_ALL_TAGS;
    public static final DefinedEventParameterKey DURATION;
    public static final DefinedEventParameterKey END_OFFSET;
    public static final DefinedEventParameterKey END_TIME;
    public static final DefinedEventParameterKey ERROR_CODE;
    public static final DefinedEventParameterKey ERROR_DESCRIPTION;
    public static final DefinedEventParameterKey EVENT_ID;
    public static final DefinedEventParameterKey FIRST_OCCURRENCE;
    public static final DefinedEventParameterKey FOLLOW_KEY;
    public static final DefinedEventParameterKey FORCED_CONFIG;
    public static final DefinedEventParameterKey HINT_PRESENT;
    public static final DefinedEventParameterKey ID;
    public static final DefinedEventParameterKey INTERNAL_SERVER_CODE;
    public static final DefinedEventParameterKey IS_VERIFIED;
    public static final DefinedEventParameterKey ITEM_COUNT;
    public static final DefinedEventParameterKey LATENCY;
    public static final DefinedEventParameterKey LIMIT_ADS;
    public static final DefinedEventParameterKey LOADED;
    public static final DefinedEventParameterKey LOCATION;
    public static final DefinedEventParameterKey LOGIN_ORIGIN;
    public static final DefinedEventParameterKey LOG_OUT_REASON;
    public static final DefinedEventParameterKey MATCH_CATEGORY;
    public static final DefinedEventParameterKey MESSAGE_ID;
    public static final DefinedEventParameterKey METHOD;
    public static final DefinedEventParameterKey MINIMISED;
    public static final DefinedEventParameterKey MODULE_SIZE;
    public static final DefinedEventParameterKey MY_TAGS_COUNT;
    public static final DefinedEventParameterKey NETWORK;
    public static final DefinedEventParameterKey NEW_INID;
    public static final DefinedEventParameterKey N_ANNOUNCEMENT;
    public static final DefinedEventParameterKey N_TYPE;
    public static final DefinedEventParameterKey ORIENTATION;
    public static final DefinedEventParameterKey ORIGIN;
    public static final DefinedEventParameterKey OUTCOME;
    public static final DefinedEventParameterKey PLAYBACK_DURATION;
    public static final DefinedEventParameterKey PLAYLIST_TITLE;
    public static final DefinedEventParameterKey PLAYLIST_WAS_SELECTED;
    public static final DefinedEventParameterKey PLAY_QUEUE;
    public static final DefinedEventParameterKey PLUS_BUTTON_ACTIVITY;
    public static final DefinedEventParameterKey POST_ID;
    public static final DefinedEventParameterKey PREVIEW;
    public static final DefinedEventParameterKey PREVIEW_URL;
    public static final DefinedEventParameterKey PROVIDER;
    public static final DefinedEventParameterKey PROVIDER_NAME;
    public static final DefinedEventParameterKey RDIO_TRACK_ID;
    public static final DefinedEventParameterKey REASON;
    public static final DefinedEventParameterKey RECORD_TIME;
    public static final DefinedEventParameterKey REC_TYPE;
    public static final DefinedEventParameterKey REQUEST_ID;
    public static final DefinedEventParameterKey REQUEST_SIZE;
    public static final DefinedEventParameterKey REQUEST_TIME;
    public static final DefinedEventParameterKey REQUEST_URL;
    public static final DefinedEventParameterKey RESPONSE_SIZE;
    public static final DefinedEventParameterKey RESPONSE_TIME;
    public static final DefinedEventParameterKey SAMPLE_LENGTH;
    public static final DefinedEventParameterKey SCREEN_NAME;
    public static final DefinedEventParameterKey SCREEN_ORIGIN;
    public static final DefinedEventParameterKey SEARCH_RESULT_TYPE;
    public static final DefinedEventParameterKey SEARCH_TYPE;
    public static final DefinedEventParameterKey SHARE_STYLE;
    public static final DefinedEventParameterKey SHAZAM_APP_SESSION_ID;
    public static final DefinedEventParameterKey SITE_ID;
    public static final DefinedEventParameterKey SOURCE;
    public static final DefinedEventParameterKey START_OFFSET;
    public static final DefinedEventParameterKey START_TIME;
    public static final DefinedEventParameterKey STATUS_CODE;
    public static final DefinedEventParameterKey STORE;
    public static final DefinedEventParameterKey STYLE;
    public static final DefinedEventParameterKey TAG_ID;
    public static final DefinedEventParameterKey TAG_RESULT_VERSION;
    public static final DefinedEventParameterKey TAG_TYPE;
    public static final DefinedEventParameterKey TIME;
    public static final DefinedEventParameterKey TIME_SPENT;
    public static final DefinedEventParameterKey TRACKS_ADDED;
    public static final DefinedEventParameterKey TRACK_CATEGORY;
    public static final DefinedEventParameterKey TRACK_DURATION;
    public static final DefinedEventParameterKey TRACK_ID;
    public static final DefinedEventParameterKey TRACK_KEY;
    public static final DefinedEventParameterKey TYPE;
    public static final DefinedEventParameterKey UNSUBMITTED;
    public static final DefinedEventParameterKey URI;
    public static final DefinedEventParameterKey UUID;
    public static final DefinedEventParameterKey VALUE;
    public static final DefinedEventParameterKey VIDEO_URL;
    public static final DefinedEventParameterKey VIEW_LENGTH;
    public static final DefinedEventParameterKey VISUAL;
    public static final DefinedEventParameterKey VISUAL_ENGINE;
    private final String parameterKey;

    private DefinedEventParameterKey(String s, int i, String s1)
    {
        super(s, i);
        parameterKey = s1;
    }

    public static DefinedEventParameterKey valueOf(String s)
    {
        return (DefinedEventParameterKey)Enum.valueOf(com/shazam/model/analytics/event/DefinedEventParameterKey, s);
    }

    public static DefinedEventParameterKey[] values()
    {
        return (DefinedEventParameterKey[])$VALUES.clone();
    }

    public final String getParameterKey()
    {
        return parameterKey;
    }

    public final String toString()
    {
        return parameterKey;
    }

    static 
    {
        SAMPLE_LENGTH = new DefinedEventParameterKey("SAMPLE_LENGTH", 0, "samplelength");
        RECORD_TIME = new DefinedEventParameterKey("RECORD_TIME", 1, "recordtime");
        NETWORK = new DefinedEventParameterKey("NETWORK", 2, "network");
        LATENCY = new DefinedEventParameterKey("LATENCY", 3, "latency");
        REQUEST_TIME = new DefinedEventParameterKey("REQUEST_TIME", 4, "requesttime");
        REQUEST_SIZE = new DefinedEventParameterKey("REQUEST_SIZE", 5, "requestsize");
        RESPONSE_TIME = new DefinedEventParameterKey("RESPONSE_TIME", 6, "responsetime");
        RESPONSE_SIZE = new DefinedEventParameterKey("RESPONSE_SIZE", 7, "responsesize");
        ID = new DefinedEventParameterKey("ID", 8, "id");
        UNSUBMITTED = new DefinedEventParameterKey("UNSUBMITTED", 9, "unsubmitted");
        REC_TYPE = new DefinedEventParameterKey("REC_TYPE", 10, "rectype");
        LOCATION = new DefinedEventParameterKey("LOCATION", 11, "location");
        MY_TAGS_COUNT = new DefinedEventParameterKey("MY_TAGS_COUNT", 12, "mytagscount");
        TRACKS_ADDED = new DefinedEventParameterKey("TRACKS_ADDED", 13, "tracksadded");
        TIME = new DefinedEventParameterKey("TIME", 14, "time");
        POST_ID = new DefinedEventParameterKey("POST_ID", 15, "post_id");
        LOGIN_ORIGIN = new DefinedEventParameterKey("LOGIN_ORIGIN", 16, "loginorigin");
        LOG_OUT_REASON = new DefinedEventParameterKey("LOG_OUT_REASON", 17, "logoutreason");
        SOURCE = new DefinedEventParameterKey("SOURCE", 18, "source");
        CODE = new DefinedEventParameterKey("CODE", 19, "code");
        VIDEO_URL = new DefinedEventParameterKey("VIDEO_URL", 20, "videourl");
        REASON = new DefinedEventParameterKey("REASON", 21, "reason");
        INTERNAL_SERVER_CODE = new DefinedEventParameterKey("INTERNAL_SERVER_CODE", 22, "internalservercode");
        STATUS_CODE = new DefinedEventParameterKey("STATUS_CODE", 23, "statuscode");
        REQUEST_URL = new DefinedEventParameterKey("REQUEST_URL", 24, "requesturl");
        TRACK_KEY = new DefinedEventParameterKey("TRACK_KEY", 25, "trackkey");
        TRACK_CATEGORY = new DefinedEventParameterKey("TRACK_CATEGORY", 26, "trackcategory");
        CARD_TYPE = new DefinedEventParameterKey("CARD_TYPE", 27, "cardtype");
        UUID = new DefinedEventParameterKey("UUID", 28, "uuid");
        TAG_ID = new DefinedEventParameterKey("TAG_ID", 29, "tagid");
        EVENT_ID = new DefinedEventParameterKey("EVENT_ID", 30, "eventid");
        PLUS_BUTTON_ACTIVITY = new DefinedEventParameterKey("PLUS_BUTTON_ACTIVITY", 31, "plusbuttonactivity");
        SCREEN_ORIGIN = new DefinedEventParameterKey("SCREEN_ORIGIN", 32, "screenorigin");
        SCREEN_NAME = new DefinedEventParameterKey("SCREEN_NAME", 33, "screenname");
        ACTION = new DefinedEventParameterKey("ACTION", 34, "action");
        MESSAGE_ID = new DefinedEventParameterKey("MESSAGE_ID", 35, "messageid");
        PREVIEW_URL = new DefinedEventParameterKey("PREVIEW_URL", 36, "previewurl");
        PREVIEW = new DefinedEventParameterKey("PREVIEW", 37, "preview");
        ORIGIN = new DefinedEventParameterKey("ORIGIN", 38, "origin");
        START_OFFSET = new DefinedEventParameterKey("START_OFFSET", 39, "startoffset");
        END_OFFSET = new DefinedEventParameterKey("END_OFFSET", 40, "endoffset");
        VIEW_LENGTH = new DefinedEventParameterKey("VIEW_LENGTH", 41, "viewlength");
        COMPLETED = new DefinedEventParameterKey("COMPLETED", 42, "completed");
        RDIO_TRACK_ID = new DefinedEventParameterKey("RDIO_TRACK_ID", 43, "rdiotrackid");
        PLAYLIST_WAS_SELECTED = new DefinedEventParameterKey("PLAYLIST_WAS_SELECTED", 44, "playlistwasselected");
        OUTCOME = new DefinedEventParameterKey("OUTCOME", 45, "outcome");
        START_TIME = new DefinedEventParameterKey("START_TIME", 46, "starttime");
        END_TIME = new DefinedEventParameterKey("END_TIME", 47, "endtime");
        TIME_SPENT = new DefinedEventParameterKey("TIME_SPENT", 48, "timespent");
        SITE_ID = new DefinedEventParameterKey("SITE_ID", 49, "siteid");
        PROVIDER = new DefinedEventParameterKey("PROVIDER", 50, "provider");
        ERROR_DESCRIPTION = new DefinedEventParameterKey("ERROR_DESCRIPTION", 51, "errordescription");
        ERROR_CODE = new DefinedEventParameterKey("ERROR_CODE", 52, "errorcode");
        DURATION = new DefinedEventParameterKey("DURATION", 53, "duration");
        LOADED = new DefinedEventParameterKey("LOADED", 54, "loaded");
        TYPE = new DefinedEventParameterKey("TYPE", 55, "type");
        TRACK_ID = new DefinedEventParameterKey("TRACK_ID", 56, "trackid");
        PROVIDER_NAME = new DefinedEventParameterKey("PROVIDER_NAME", 57, "providername");
        MATCH_CATEGORY = new DefinedEventParameterKey("MATCH_CATEGORY", 58, "matchcategory");
        TAG_RESULT_VERSION = new DefinedEventParameterKey("TAG_RESULT_VERSION", 59, "tagresultversion");
        CAMPAIGN = new DefinedEventParameterKey("CAMPAIGN", 60, "campaign");
        DEEP_LINK_ID = new DefinedEventParameterKey("DEEP_LINK_ID", 61, "deeplinkid");
        DELETE_ALL_TAGS = new DefinedEventParameterKey("DELETE_ALL_TAGS", 62, "delete_all_tags");
        URI = new DefinedEventParameterKey("URI", 63, "uri");
        STYLE = new DefinedEventParameterKey("STYLE", 64, "style");
        CHANGED_TO = new DefinedEventParameterKey("CHANGED_TO", 65, "changedto");
        CHANGED_FROM = new DefinedEventParameterKey("CHANGED_FROM", 66, "changedfrom");
        FIRST_OCCURRENCE = new DefinedEventParameterKey("FIRST_OCCURRENCE", 67, "firstoccurrence");
        REQUEST_ID = new DefinedEventParameterKey("REQUEST_ID", 68, "requestid");
        ORIENTATION = new DefinedEventParameterKey("ORIENTATION", 69, "orientation");
        MODULE_SIZE = new DefinedEventParameterKey("MODULE_SIZE", 70, "modulesize");
        CHART_TITLE = new DefinedEventParameterKey("CHART_TITLE", 71, "charttitle");
        CARD_POSITION = new DefinedEventParameterKey("CARD_POSITION", 72, "cardposition");
        ITEM_COUNT = new DefinedEventParameterKey("ITEM_COUNT", 73, "itemcount");
        PLAYBACK_DURATION = new DefinedEventParameterKey("PLAYBACK_DURATION", 74, "playbackduration");
        TRACK_DURATION = new DefinedEventParameterKey("TRACK_DURATION", 75, "trackduration");
        METHOD = new DefinedEventParameterKey("METHOD", 76, "method");
        MINIMISED = new DefinedEventParameterKey("MINIMISED", 77, "minimised");
        BACKGROUND = new DefinedEventParameterKey("BACKGROUND", 78, "background");
        PLAY_QUEUE = new DefinedEventParameterKey("PLAY_QUEUE", 79, "playqueue");
        PLAYLIST_TITLE = new DefinedEventParameterKey("PLAYLIST_TITLE", 80, "playlisttitle");
        STORE = new DefinedEventParameterKey("STORE", 81, "store");
        COUNT = new DefinedEventParameterKey("COUNT", 82, "count");
        SHAZAM_APP_SESSION_ID = new DefinedEventParameterKey("SHAZAM_APP_SESSION_ID", 83, "sessionid");
        HINT_PRESENT = new DefinedEventParameterKey("HINT_PRESENT", 84, "hintpresent");
        LIMIT_ADS = new DefinedEventParameterKey("LIMIT_ADS", 85, "limitads");
        AD_PROVIDER = new DefinedEventParameterKey("AD_PROVIDER", 86, "adp");
        N_TYPE = new DefinedEventParameterKey("N_TYPE", 87, "ntype");
        N_ANNOUNCEMENT = new DefinedEventParameterKey("N_ANNOUNCEMENT", 88, "nann");
        TAG_TYPE = new DefinedEventParameterKey("TAG_TYPE", 89, "tagtype");
        VISUAL = new DefinedEventParameterKey("VISUAL", 90, "visual");
        VALUE = new DefinedEventParameterKey("VALUE", 91, "value");
        VISUAL_ENGINE = new DefinedEventParameterKey("VISUAL_ENGINE", 92, "e");
        FORCED_CONFIG = new DefinedEventParameterKey("FORCED_CONFIG", 93, "forcedconfig");
        NEW_INID = new DefinedEventParameterKey("NEW_INID", 94, "newinid");
        ARTIST_ID = new DefinedEventParameterKey("ARTIST_ID", 95, "artistid");
        FOLLOW_KEY = new DefinedEventParameterKey("FOLLOW_KEY", 96, "followkey");
        IS_VERIFIED = new DefinedEventParameterKey("IS_VERIFIED", 97, "isverified");
        SEARCH_TYPE = new DefinedEventParameterKey("SEARCH_TYPE", 98, "searchtype");
        SEARCH_RESULT_TYPE = new DefinedEventParameterKey("SEARCH_RESULT_TYPE", 99, "searchresulttype");
        SHARE_STYLE = new DefinedEventParameterKey("SHARE_STYLE", 100, "sharestyle");
        BLUETOOTH = new DefinedEventParameterKey("BLUETOOTH", 101, "bt");
        $VALUES = (new DefinedEventParameterKey[] {
            SAMPLE_LENGTH, RECORD_TIME, NETWORK, LATENCY, REQUEST_TIME, REQUEST_SIZE, RESPONSE_TIME, RESPONSE_SIZE, ID, UNSUBMITTED, 
            REC_TYPE, LOCATION, MY_TAGS_COUNT, TRACKS_ADDED, TIME, POST_ID, LOGIN_ORIGIN, LOG_OUT_REASON, SOURCE, CODE, 
            VIDEO_URL, REASON, INTERNAL_SERVER_CODE, STATUS_CODE, REQUEST_URL, TRACK_KEY, TRACK_CATEGORY, CARD_TYPE, UUID, TAG_ID, 
            EVENT_ID, PLUS_BUTTON_ACTIVITY, SCREEN_ORIGIN, SCREEN_NAME, ACTION, MESSAGE_ID, PREVIEW_URL, PREVIEW, ORIGIN, START_OFFSET, 
            END_OFFSET, VIEW_LENGTH, COMPLETED, RDIO_TRACK_ID, PLAYLIST_WAS_SELECTED, OUTCOME, START_TIME, END_TIME, TIME_SPENT, SITE_ID, 
            PROVIDER, ERROR_DESCRIPTION, ERROR_CODE, DURATION, LOADED, TYPE, TRACK_ID, PROVIDER_NAME, MATCH_CATEGORY, TAG_RESULT_VERSION, 
            CAMPAIGN, DEEP_LINK_ID, DELETE_ALL_TAGS, URI, STYLE, CHANGED_TO, CHANGED_FROM, FIRST_OCCURRENCE, REQUEST_ID, ORIENTATION, 
            MODULE_SIZE, CHART_TITLE, CARD_POSITION, ITEM_COUNT, PLAYBACK_DURATION, TRACK_DURATION, METHOD, MINIMISED, BACKGROUND, PLAY_QUEUE, 
            PLAYLIST_TITLE, STORE, COUNT, SHAZAM_APP_SESSION_ID, HINT_PRESENT, LIMIT_ADS, AD_PROVIDER, N_TYPE, N_ANNOUNCEMENT, TAG_TYPE, 
            VISUAL, VALUE, VISUAL_ENGINE, FORCED_CONFIG, NEW_INID, ARTIST_ID, FOLLOW_KEY, IS_VERIFIED, SEARCH_TYPE, SEARCH_RESULT_TYPE, 
            SHARE_STYLE, BLUETOOTH
        });
    }
}
