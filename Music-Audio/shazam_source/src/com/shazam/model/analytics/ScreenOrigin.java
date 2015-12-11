// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.analytics;


public class ScreenOrigin
{

    public static final ScreenOrigin ALBUM = new ScreenOrigin("album");
    public static final ScreenOrigin AUTO_TAGS_TAG = new ScreenOrigin("mytagsauto");
    public static final ScreenOrigin CHARTS = new ScreenOrigin("charts");
    public static final ScreenOrigin CHARTS_FEED = new ScreenOrigin("chartsfeed");
    public static final ScreenOrigin DEEPLINK = new ScreenOrigin("deeplink");
    public static final ScreenOrigin DETAILS = new ScreenOrigin("details");
    public static final ScreenOrigin EXPLORE = new ScreenOrigin("explore");
    public static final ScreenOrigin FACEBOOK_DEEPLINK = new ScreenOrigin("fbdeeplink");
    public static final ScreenOrigin HOME = new ScreenOrigin("home");
    public static final ScreenOrigin HTTP_DEEPLINK = new ScreenOrigin("httplink");
    public static final ScreenOrigin LYRICS = new ScreenOrigin("lyrics");
    public static final ScreenOrigin MISCELLANEOUS_WEB_VIEW = new ScreenOrigin("miscwebview");
    public static final ScreenOrigin MY_SHAZAM = new ScreenOrigin("myshazam");
    public static final ScreenOrigin MY_TAGS_TAG = new ScreenOrigin("mytags");
    public static final ScreenOrigin NEW_RESULT = new ScreenOrigin("newresult");
    public static final ScreenOrigin NONE = new ScreenOrigin("");
    public static final ScreenOrigin NOTIFICATION = new ScreenOrigin("notification");
    public static final ScreenOrigin OVERLAY = new ScreenOrigin("overlay");
    public static final ScreenOrigin PLAYER = new ScreenOrigin("fullscreenplayer");
    public static final ScreenOrigin PLAY_ALL_UPSELL = new ScreenOrigin("playallupsell");
    public static final ScreenOrigin PLUS_BUTTON = new ScreenOrigin("plusbutton");
    public static final ScreenOrigin RECONNECT_DIALOG = new ScreenOrigin("reconnectdialog");
    public static final ScreenOrigin SEARCH = new ScreenOrigin("search");
    public static final ScreenOrigin SETTINGS = new ScreenOrigin("settings");
    public final String value;

    private ScreenOrigin(String s)
    {
        value = s;
    }

    public static ScreenOrigin a(String s)
    {
        if (s == null)
        {
            return NONE;
        } else
        {
            return new ScreenOrigin(s);
        }
    }

    public static String a(ScreenOrigin screenorigin)
    {
        if (screenorigin != null)
        {
            return screenorigin.value;
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder("ScreenOrigin[")).append(value).append("]").toString();
    }

}
