// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Card
{

    public static final String BANNER_TYPE_HTML = "html";
    public static final String BANNER_TYPE_LINK = "link";
    public static final double DEFAULT_PROPORTION = 0.5D;
    public static final String RENDER_TYPE_COLLAGE = "collage";
    public static final String RENDER_TYPE_DEFAULT = "default";
    public static final String RENDER_TYPE_GRID = "grid";
    public static final String RENDER_TYPE_LINE = "line";
    public static final String RENDER_TYPE_SLIDE_BANNER = "slide_banner";
    public static final String RENDER_TYPE_SLIDE_FEATURE = "slide_feature";
    public static final String RENDER_TYPE_WEB = "web";
    public static final List SUPPORTED_CARDS;
    public static final String TYPE_BANNER = "banner_card";
    public static final String TYPE_LOGIN = "login_card";
    public static final String TYPE_PHOTO = "photo_card";
    public static final String TYPE_STUDIO = "studio_card";
    public static final String TYPE_TAG = "tag_card";
    public static final String TYPE_USER = "user_card";
    public static final String TYPE_WEB = "web_card";
    public static final String TYPE_YOUTUBE = "youtube_card";
    public String action;
    public transient List banners;
    public int cardPosition;
    public String card_tags[];
    public String content;
    public String contentUrl;
    public List data;
    public String footerTitle;
    public boolean full_screen;
    public String icon;
    public String id;
    public String index;
    public int itemSize;
    public String key;
    public String message;
    public String messageTitle;
    public int messageTitleRows;
    public transient List photos;
    public double proportion;
    public String renderType;
    public int rows;
    public String subtitle;
    public transient List tags;
    public String title;
    public String type;
    public transient List users;
    public long viewedMilliseconds;

    public Card()
    {
        full_screen = false;
        rows = 3;
        messageTitleRows = 1;
        proportion = 0.5D;
        data = new ArrayList();
        photos = new ArrayList();
        users = new ArrayList();
        tags = new ArrayList();
        banners = new ArrayList();
        itemSize = 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append(title).append(" ").append(type).toString();
    }

    static 
    {
        LinkedList linkedlist = new LinkedList();
        SUPPORTED_CARDS = linkedlist;
        linkedlist.add("photo_card");
        SUPPORTED_CARDS.add("user_card");
        SUPPORTED_CARDS.add("tag_card");
        SUPPORTED_CARDS.add("banner_card");
        SUPPORTED_CARDS.add("studio_card");
        SUPPORTED_CARDS.add("web_card");
        SUPPORTED_CARDS.add("login_card");
        SUPPORTED_CARDS.add("youtube_card");
    }
}
