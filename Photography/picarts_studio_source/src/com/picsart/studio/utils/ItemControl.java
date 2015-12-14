// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.utils;


public final class ItemControl extends Enum
{

    private static final ItemControl $VALUES[];
    public static final ItemControl ADD_TO_MEMBOX;
    public static final ItemControl APPBOY_NEWS;
    public static final ItemControl BANNER;
    public static final ItemControl BANNER_PHOTO;
    public static final ItemControl CARD;
    public static final ItemControl CHECK;
    public static final ItemControl COMMENT_IMAGE;
    public static final ItemControl COPY_IMG_URL;
    public static final ItemControl CREATE;
    public static final ItemControl DELETE_PHOTO;
    public static final ItemControl DOUBLE_TAP_IMAGE;
    public static final ItemControl EDIT_DETAILS;
    public static final ItemControl FOLLOW;
    public static final ItemControl FOLLOW_TAG;
    public static final ItemControl FOLLOW_USER;
    public static final ItemControl IMAGE;
    public static final ItemControl ITEM;
    public static final ItemControl LIKE;
    public static final ItemControl LOCATION;
    public static final ItemControl LOGIN;
    public static final ItemControl MEMBOXES;
    public static final ItemControl OPEN_CONTEST;
    public static final ItemControl OPEN_EDITOR;
    public static final ItemControl OPEN_SAVE;
    public static final ItemControl OPEN_SHARE;
    public static final ItemControl OWNER_IMAGE;
    public static final ItemControl OWNER_NAME_TEXT;
    public static final ItemControl PAGE;
    public static final ItemControl REPORT_PHOTO;
    public static final ItemControl REPOSTS;
    public static final ItemControl REPOST_MORE;
    public static final ItemControl SHOW_COMMENTS;
    public static final ItemControl SHOW_LIKES;
    public static final ItemControl SHOW_MEMBOXES;
    public static final ItemControl SHOW_REPOSTS;
    public static final ItemControl TITLE;
    public static final ItemControl UPLOAD;
    public static final ItemControl UPLOAD_CANCEL;
    public static final ItemControl UPLOAD_RETRY;
    public static final ItemControl USER;
    public static final ItemControl VOTE;

    private ItemControl(String s, int i)
    {
        super(s, i);
    }

    public static ItemControl valueOf(String s)
    {
        return (ItemControl)Enum.valueOf(com/picsart/studio/utils/ItemControl, s);
    }

    public static ItemControl[] values()
    {
        return (ItemControl[])$VALUES.clone();
    }

    static 
    {
        TITLE = new ItemControl("TITLE", 0);
        IMAGE = new ItemControl("IMAGE", 1);
        CREATE = new ItemControl("CREATE", 2);
        CARD = new ItemControl("CARD", 3);
        DOUBLE_TAP_IMAGE = new ItemControl("DOUBLE_TAP_IMAGE", 4);
        USER = new ItemControl("USER", 5);
        FOLLOW_USER = new ItemControl("FOLLOW_USER", 6);
        FOLLOW_TAG = new ItemControl("FOLLOW_TAG", 7);
        LOCATION = new ItemControl("LOCATION", 8);
        MEMBOXES = new ItemControl("MEMBOXES", 9);
        OWNER_NAME_TEXT = new ItemControl("OWNER_NAME_TEXT", 10);
        OWNER_IMAGE = new ItemControl("OWNER_IMAGE", 11);
        LIKE = new ItemControl("LIKE", 12);
        COMMENT_IMAGE = new ItemControl("COMMENT_IMAGE", 13);
        REPOSTS = new ItemControl("REPOSTS", 14);
        REPOST_MORE = new ItemControl("REPOST_MORE", 15);
        SHOW_COMMENTS = new ItemControl("SHOW_COMMENTS", 16);
        OPEN_EDITOR = new ItemControl("OPEN_EDITOR", 17);
        VOTE = new ItemControl("VOTE", 18);
        ITEM = new ItemControl("ITEM", 19);
        PAGE = new ItemControl("PAGE", 20);
        FOLLOW = new ItemControl("FOLLOW", 21);
        UPLOAD = new ItemControl("UPLOAD", 22);
        UPLOAD_CANCEL = new ItemControl("UPLOAD_CANCEL", 23);
        UPLOAD_RETRY = new ItemControl("UPLOAD_RETRY", 24);
        OPEN_SAVE = new ItemControl("OPEN_SAVE", 25);
        OPEN_SHARE = new ItemControl("OPEN_SHARE", 26);
        COPY_IMG_URL = new ItemControl("COPY_IMG_URL", 27);
        REPORT_PHOTO = new ItemControl("REPORT_PHOTO", 28);
        ADD_TO_MEMBOX = new ItemControl("ADD_TO_MEMBOX", 29);
        EDIT_DETAILS = new ItemControl("EDIT_DETAILS", 30);
        DELETE_PHOTO = new ItemControl("DELETE_PHOTO", 31);
        SHOW_LIKES = new ItemControl("SHOW_LIKES", 32);
        SHOW_REPOSTS = new ItemControl("SHOW_REPOSTS", 33);
        SHOW_MEMBOXES = new ItemControl("SHOW_MEMBOXES", 34);
        BANNER = new ItemControl("BANNER", 35);
        BANNER_PHOTO = new ItemControl("BANNER_PHOTO", 36);
        OPEN_CONTEST = new ItemControl("OPEN_CONTEST", 37);
        APPBOY_NEWS = new ItemControl("APPBOY_NEWS", 38);
        CHECK = new ItemControl("CHECK", 39);
        LOGIN = new ItemControl("LOGIN", 40);
        $VALUES = (new ItemControl[] {
            TITLE, IMAGE, CREATE, CARD, DOUBLE_TAP_IMAGE, USER, FOLLOW_USER, FOLLOW_TAG, LOCATION, MEMBOXES, 
            OWNER_NAME_TEXT, OWNER_IMAGE, LIKE, COMMENT_IMAGE, REPOSTS, REPOST_MORE, SHOW_COMMENTS, OPEN_EDITOR, VOTE, ITEM, 
            PAGE, FOLLOW, UPLOAD, UPLOAD_CANCEL, UPLOAD_RETRY, OPEN_SAVE, OPEN_SHARE, COPY_IMG_URL, REPORT_PHOTO, ADD_TO_MEMBOX, 
            EDIT_DETAILS, DELETE_PHOTO, SHOW_LIKES, SHOW_REPOSTS, SHOW_MEMBOXES, BANNER, BANNER_PHOTO, OPEN_CONTEST, APPBOY_NEWS, CHECK, 
            LOGIN
        });
    }
}
