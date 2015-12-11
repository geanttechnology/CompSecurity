// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.test;


public final class Event extends Enum
{

    private static final Event $VALUES[];
    public static final Event CACHE;
    public static final Event CACHE_IMAGES;
    public static final Event CANCEL;
    public static final Event CLOSED;
    public static final Event ERROR;
    public static final Event GET_PROMOS;
    public static final Event GET_SETTINGS;
    public static final Event INIT;
    public static final Event SCREEN_ROTATED;
    public static final Event SEND_CONFIRMATION_TOKEN;
    public static final Event SHOW;
    public static final Event SHOW_CANCELLED_NOT_CACHED;
    public static final Event SUBMIT_ALL_INSTALLED_APPS;
    public static final Event SUBMIT_ALREADY_INSTALLED_PROMOS;
    public static final Event TAPPED;

    private Event(String s, int i)
    {
        super(s, i);
    }

    public static Event valueOf(String s)
    {
        return (Event)Enum.valueOf(com/applift/playads/test/Event, s);
    }

    public static Event[] values()
    {
        return (Event[])$VALUES.clone();
    }

    static 
    {
        INIT = new Event("INIT", 0);
        SCREEN_ROTATED = new Event("SCREEN_ROTATED", 1);
        CACHE = new Event("CACHE", 2);
        SHOW = new Event("SHOW", 3);
        SHOW_CANCELLED_NOT_CACHED = new Event("SHOW_CANCELLED_NOT_CACHED", 4);
        CANCEL = new Event("CANCEL", 5);
        GET_PROMOS = new Event("GET_PROMOS", 6);
        CACHE_IMAGES = new Event("CACHE_IMAGES", 7);
        GET_SETTINGS = new Event("GET_SETTINGS", 8);
        SEND_CONFIRMATION_TOKEN = new Event("SEND_CONFIRMATION_TOKEN", 9);
        SUBMIT_ALREADY_INSTALLED_PROMOS = new Event("SUBMIT_ALREADY_INSTALLED_PROMOS", 10);
        SUBMIT_ALL_INSTALLED_APPS = new Event("SUBMIT_ALL_INSTALLED_APPS", 11);
        CLOSED = new Event("CLOSED", 12);
        TAPPED = new Event("TAPPED", 13);
        ERROR = new Event("ERROR", 14);
        $VALUES = (new Event[] {
            INIT, SCREEN_ROTATED, CACHE, SHOW, SHOW_CANCELLED_NOT_CACHED, CANCEL, GET_PROMOS, CACHE_IMAGES, GET_SETTINGS, SEND_CONFIRMATION_TOKEN, 
            SUBMIT_ALREADY_INSTALLED_PROMOS, SUBMIT_ALL_INSTALLED_APPS, CLOSED, TAPPED, ERROR
        });
    }
}
