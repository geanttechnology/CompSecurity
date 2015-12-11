// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.view.mraid;


public interface JSInterface
{

    public static final String ACTION_CLOSE = "close";
    public static final String ACTION_CREATE_CALENDAR_EVENT = "createCalendarEvent";
    public static final String ACTION_EXPAND = "expand";
    public static final String ACTION_GET_CURRENT_POSITION = "getCurrentPosition";
    public static final String ACTION_GET_DEFAULT_POSITION = "getDefaultPosition";
    public static final String ACTION_GET_MAX_SIZE = "getMaxSize";
    public static final String ACTION_GET_PLACEMENT_TYPE = "getPlacementType";
    public static final String ACTION_GET_SCREEN_SIZE = "getScreenSize";
    public static final String ACTION_OPEN = "open";
    public static final String ACTION_PLAY_VIDEO = "playVideo";
    public static final String ACTION_RESIZE = "resize";
    public static final String ACTION_STORE_PICTURE = "storePicture";
    public static final String JSON_HEIGHT = "height";
    public static final String JSON_IS_MODAL = "isModal";
    public static final String JSON_METHOD = "method";
    public static final String JSON_USE_CUSTOM_CLOSE = "useCustomClose";
    public static final String JSON_VALUE = "value";
    public static final String JSON_WIDTH = "width";
    public static final String JSON_X = "x";
    public static final String JSON_Y = "y";
    public static final String STATE_DEFAULT = "default";
    public static final String STATE_EXPANDED = "expanded";
    public static final String STATE_HIDDEN = "hidden";
    public static final String STATE_LOADING = "loading";
    public static final String STATE_RESIZED = "resized";

    public abstract void close();

    public abstract void createCalendarEvent(String s);

    public abstract void expand();

    public abstract void expand(String s);

    public abstract String getCurrentPosition();

    public abstract String getDefaultPosition();

    public abstract String getMaxSize();

    public abstract String getPlacementType();

    public abstract String getScreenSize();

    public abstract void javaScriptCallback(String s, String s1, String s2);

    public abstract void onOrientationPropertiesChanged(String s);

    public abstract void open(String s);

    public abstract void playVideo(String s);

    public abstract void resize();

    public abstract void storePicture(String s);

    public abstract boolean supports(String s);
}
