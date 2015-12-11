// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.shazam.i.b.c;

public final class a
{

    public static final String a = com.shazam.i.b.c.a().getResources().getString(0x7f090211);
    public static final String b = (new StringBuilder()).append(w).append("subscription_expired/%s/%s").toString();
    public static final String c = (new StringBuilder()).append(w).append("streaming_logged_in/%s").toString();
    public static final String d = (new StringBuilder()).append(w).append("streaming_playlists/%s/%s").toString();
    public static final String e = (new StringBuilder()).append(w).append("streaming_upsell/%s?%s").toString();
    public static final String f = (new StringBuilder()).append(w).append("explore/%s").toString();
    public static final String g = (new StringBuilder()).append(w).append("legacy_email_registration").toString();
    public static final String h = (new StringBuilder()).append(w).append("email_registration").toString();
    public static final String i = (new StringBuilder()).append(w).append("email_signup").toString();
    public static final String j = (new StringBuilder()).append(w).append("email_signin").toString();
    public static final String k = (new StringBuilder()).append(w).append("check_email").toString();
    public static final String l = (new StringBuilder()).append(w).append("sign_up").toString();
    public static final String m = (new StringBuilder()).append(w).append("artist_profile/%s").toString();
    public static final String n = (new StringBuilder()).append(w).append("followings").toString();
    public static final String o = (new StringBuilder()).append(w).append("facebook_connect_prompt").toString();
    public static final String p = (new StringBuilder()).append(w).append("facebook_invite_friends").toString();
    public static final String q = (new StringBuilder()).append(w).append("share_tag_dialog").toString();
    public static final String r = (new StringBuilder()).append(w).append("share_data_bottom_sheet").toString();
    public static final String s = (new StringBuilder()).append(w).append("share_tag_bottom_sheet").toString();
    public static final String t = (new StringBuilder()).append(w).append("post_editor?key=%s&title=%s&artist=%s&cover=%s&tagId=%s").toString();
    public static final String u = (new StringBuilder()).append(w).append("search").toString();
    public static final String v = (new StringBuilder()).append(w).append("search_more_results?query=%s&section=%s&page_url=%s&").toString();
    private static final String w = (new StringBuilder()).append(a).append("://").toString();

    public static transient Uri a(String s1, Object aobj[])
    {
        return Uri.parse(String.format(s1, aobj));
    }

}
