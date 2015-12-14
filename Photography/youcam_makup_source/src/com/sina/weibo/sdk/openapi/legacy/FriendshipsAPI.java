// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.openapi.legacy;

import android.content.Context;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.openapi.AbsOpenAPI;

public class FriendshipsAPI extends AbsOpenAPI
{

    private static final String SERVER_URL_PRIX = "https://api.weibo.com/2/friendships";

    public FriendshipsAPI(Context context, String s, Oauth2AccessToken oauth2accesstoken)
    {
        super(context, s, oauth2accesstoken);
    }

    private WeiboParameters buildFriendIDParam(long l, int i)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("uid", l);
        weiboparameters.put("count", i);
        return weiboparameters;
    }

    private WeiboParameters buildFriendsParam(int i, int j, boolean flag)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("count", i);
        weiboparameters.put("cursor", j);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        weiboparameters.put("trim_status", i);
        return weiboparameters;
    }

    public void bilateral(long l, int i, int j, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendIDParam(l, i);
        weiboparameters.put("page", j);
        requestAsync("https://api.weibo.com/2/friendships/friends/bilateral.json", weiboparameters, "GET", requestlistener);
    }

    public void bilateralIds(long l, int i, int j, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendIDParam(l, i);
        weiboparameters.put("page", j);
        requestAsync("https://api.weibo.com/2/friendships/friends/bilateral/ids.json", weiboparameters, "GET", requestlistener);
    }

    public void chainFollowers(long l, int i, int j, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendIDParam(l, i);
        weiboparameters.put("page", j);
        requestAsync("https://api.weibo.com/2/friendships/friends_chain/followers.json", weiboparameters, "GET", requestlistener);
    }

    public void create(long l, String s, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("uid", l);
        weiboparameters.put("screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/create.json", weiboparameters, "POST", requestlistener);
    }

    public void create(String s, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/create.json", weiboparameters, "POST", requestlistener);
    }

    public void destroy(long l, String s, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("uid", l);
        weiboparameters.put("screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/destroy.json", weiboparameters, "POST", requestlistener);
    }

    public void destroy(String s, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/destroy.json", weiboparameters, "POST", requestlistener);
    }

    public void followers(long l, int i, int j, boolean flag, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendIDParam(l, i);
        weiboparameters.put("cursor", j);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        weiboparameters.put("trim_status", i);
        requestAsync("https://api.weibo.com/2/friendships/followers.json", weiboparameters, "GET", requestlistener);
    }

    public void followers(String s, int i, int j, boolean flag, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendsParam(i, j, flag);
        weiboparameters.put("screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/followers.json", weiboparameters, "GET", requestlistener);
    }

    public void followersActive(long l, int i, RequestListener requestlistener)
    {
        requestAsync("https://api.weibo.com/2/friendships/followers/active.json", buildFriendIDParam(l, i), "GET", requestlistener);
    }

    public void followersIds(long l, int i, int j, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendIDParam(l, i);
        weiboparameters.put("cursor", j);
        requestAsync("https://api.weibo.com/2/friendships/followers/ids.json", weiboparameters, "GET", requestlistener);
    }

    public void followersIds(String s, int i, int j, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("screen_name", s);
        weiboparameters.put("count", i);
        weiboparameters.put("cursor", j);
        requestAsync("https://api.weibo.com/2/friendships/followers/ids.json", weiboparameters, "GET", requestlistener);
    }

    public void friends(long l, int i, int j, boolean flag, RequestListener requestlistener)
    {
        new WeiboParameters(mAppKey);
        WeiboParameters weiboparameters = buildFriendsParam(i, j, flag);
        weiboparameters.put("uid", l);
        requestAsync("https://api.weibo.com/2/friendships/friends.json", weiboparameters, "GET", requestlistener);
    }

    public void friends(String s, int i, int j, boolean flag, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendsParam(i, j, flag);
        weiboparameters.put("screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/friends.json", weiboparameters, "GET", requestlistener);
    }

    public void friendsIds(long l, int i, int j, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendIDParam(l, i);
        weiboparameters.put("cursor", j);
        requestAsync("https://api.weibo.com/2/friendships/friends/ids.json", weiboparameters, "GET", requestlistener);
    }

    public void friendsIds(String s, int i, int j, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("screen_name", s);
        weiboparameters.put("count", i);
        weiboparameters.put("cursor", j);
        requestAsync("https://api.weibo.com/2/friendships/friends/ids.json", weiboparameters, "GET", requestlistener);
    }

    public void inCommon(long l, long l1, int i, int j, boolean flag, 
            RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = buildFriendIDParam(l, i);
        weiboparameters.put("suid", l1);
        weiboparameters.put("page", j);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        weiboparameters.put("trim_status", i);
        requestAsync("https://api.weibo.com/2/friendships/friends/in_common.json", weiboparameters, "GET", requestlistener);
    }

    public void show(long l, long l1, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("source_id", l);
        weiboparameters.put("target_id", l1);
        requestAsync("https://api.weibo.com/2/friendships/show.json", weiboparameters, "GET", requestlistener);
    }

    public void show(long l, String s, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("source_id", l);
        weiboparameters.put("target_screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/show.json", weiboparameters, "GET", requestlistener);
    }

    public void show(String s, long l, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("source_screen_name", s);
        weiboparameters.put("target_id", l);
        requestAsync("https://api.weibo.com/2/friendships/show.json", weiboparameters, "GET", requestlistener);
    }

    public void show(String s, String s1, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("target_screen_name", s1);
        weiboparameters.put("source_screen_name", s);
        requestAsync("https://api.weibo.com/2/friendships/show.json", weiboparameters, "GET", requestlistener);
    }
}
